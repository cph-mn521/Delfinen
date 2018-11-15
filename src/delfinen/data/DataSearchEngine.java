/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.data;

import com.google.gson.Gson;
import delfinen.logic.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import delfinen.data.PersistanceHandler;

/**
 *
 * @author Niels Bang
 */
public class DataSearchEngine {

    private PersistanceHandler p = new PersistanceHandler();
    private Gson gson = new Gson();

    /**
     *
     * @param Search
     * @param disciplines
     * @param Coach
     * @return
     * @throws DataException
     */
    public List<String> Search(ArrayList<String> Search, List<String> disciplines, Member Coach) throws DataException {
        StringBuilder regQuery = new StringBuilder();
        regQuery.append("^\\{");
        List<String> matches = new ArrayList<>();

        ArrayList<String> regex = new ArrayList<>();
        regex.add("\"disciplines\":\\[.+\\],");
        regex.add("\"coach\":\\{.+\\},");
        regex.add("\"name\":\".+\",");
        regex.add("\"email\":\".+\",");
        regex.add("\"address\":\".+\",");
        regex.add("\"id\":.+,");
        regex.add("\"age\":.+,");
        regex.add("\"phone\":.+,");
        regex.add("\"status\":\".+\",");
        regex.add("\"isCoach\":.+");

        if (disciplines != null) {
            int disSize = disciplines.size();
            if (disSize > 0) {
                regQuery.append("\"disciplines\":\\[");
                for (int i = 0; i <= disSize; i++) {
                    regQuery.append("\"");
                    regQuery.append(disciplines.get(i));
                    if (i == disSize - 1) {
                        regQuery.append("\"");
                    } else {
                        regQuery.append("\",");
                    }
                }

                regQuery.append("\\],\"coach\":");
                regQuery.append(gson.toJson(Coach));
                regQuery.append(",");
            } else {
                regQuery.append("(\"disciplines\":\\[.+\\],\"coach\":\\{.+\\},)");
            }
        }

        int i = 0;
        for (String s : Search) {
            if (s.isEmpty()) {
                regQuery.append(regex.get(i));
                i++;
                continue;
            } else {
                regQuery.append(regex.get(i).replace(".+", s));
            }
            i++;
        }
        regQuery.append("\\}$");

        List<String> data = p.dam.getEntries();

        Pattern p = Pattern.compile(regQuery.toString(), Pattern.MULTILINE);

        for (String s : data) {
            if (p.matcher(s).matches()) {
                matches.add(s);
            }
        }

        return matches;
    }
}
