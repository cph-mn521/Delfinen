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
import java.util.regex.Pattern;

/**
 *
 * @author Niels Bang
 */
public class DataSearchEngine {

//    private PersistanceHandler p = new PersistanceHandler();
    private Gson gson = new Gson();

    /**
     * A method for a partial fuzzy search for members in the filesystem.
     *
     * @param Search List of data to be searched for.
     * @param disciplines List of disciplines for competitive members.
     * @param Coach The coach of competitive members.
     * @param data List of members.
     * @param isCompetitive True if there's searched for competitive members.
     * @return
     * @throws DataException
     */
    public List<String> Search(ArrayList<String> Search, List<String> disciplines, Member Coach, List<String> data, boolean isCompetitive) throws DataException {
        StringBuilder regQuery = new StringBuilder();
        regQuery.append("^\\{");
        List<String> matches = new ArrayList<>();

        ArrayList<String> regex = new ArrayList<>();
        regex.add("\"name\":\".+\",");
        regex.add("\"email\":\".+\",");
        regex.add("\"address\":\".+\",");
        regex.add("\"id\":.+,");
        regex.add("\"age\":.+,");
        regex.add("\"phone\":.+,");
        regex.add("\"status\":\".+\",");
        regex.add("\"isCoach\":.+");

        if (isCompetitive) {
            regQuery.append("\"disciplines\":\\[");

            if (disciplines != null) {
                if (disciplines.size() > 0) {
                    for (String s : disciplines) {
                        regQuery.append(".*\"");
                        regQuery.append(s);
                        regQuery.append("\".*,");
                    }
                    regQuery.deleteCharAt(regQuery.lastIndexOf("\".*,") + 3);
                    regQuery.append("\\],");
                } else {
                    regQuery.append(".+\\],");
                }
            }
            if (Coach != null) {
                regQuery.append("\"coach\":\\");
                regQuery.append(gson.toJson(Coach).replace("}", "\\}"));
                regQuery.append(",");
            } else {
                regQuery.append("\"coach\":\\{.+\\},");
            }
        }
        int i = 0;
        for (String s : Search) {
            if (s.isEmpty()) {
                regQuery.append(regex.get(i));
                i++;
                continue;
            } else {
                regQuery.append(regex.get(i).replace(".+", ".*" + s.replace(" ", ".*") + ".*"));
            }
            i++;
        }

        regQuery.append(
                "\\}$");

        if (delfinen.Controller.DEBUG) {
            System.out.println(regQuery);
        }
        Pattern p = Pattern.compile(regQuery.toString());

        for (String s : data) {
            if (p.matcher(s).matches()) {
                matches.add(s);
            }
        }

        return matches;
    }
}
