package delfinen.presentation;

import delfinen.Controller;
import static delfinen.presentation.DelfinGUI.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Methods from GUI placed here for "easier" perusing
 * Next version should be a methods file for each layer in DelfinGUI for even
 * easier perusing
 * @author martin b.
 */
public class DelfinGUImethods {

    Font FONT_NOTOSANS_PLAIN_12 = new Font("monospaced", Font.PLAIN, 12);
    Font FONT_NOTOSANS_BOLD_12 = new Font("monospaced", Font.BOLD, 12);
    Font FONT_NOTOSANS_ITALIC_12 = new Font("monospaced", Font.ITALIC, 12);
    Font FONT_NOTOSANS_BOLD_ITALIC_12 = new Font("monospaced", Font.BOLD + Font.ITALIC, 12);

    /**
     * ************************************************************************************
     * button methods
     */
    /**
     * members site clears input fields to pink
     */
    public void ClearFieldToPink() {
        for (JTextField textField : textFields) {
            textField.setText("");
            textField.setBackground(Color.pink);
        }
    }

    /**
     * members site code for when Add results is pressed
     */
    public void buttonNewResult() {
        dialogNewResults.setAlwaysOnTop(true);
        dialogNewResults.setVisible(true);
        labelNewResultsMemberName.setText(textFieldNavn.getText());
    }

    /**
     * members site code for when change member is pressed
     */
    public void buttonChangeMember() {
        okCancelLabelAction.setText("ændre");
        okCancelButtonbuttonOK.setText("Ja, ændre medlem");
        okCancelDialog.setAlwaysOnTop(true);
        okCancelDialog.setVisible(true);
    }

    /**
     * members site code for when delete member is pressed
     */
    public void buttonDeleteMember() {
        okCancelLabelAction.setText("slette");
        okCancelButtonbuttonOK.setText("Ja, slet medlem");
        okCancelDialog.setAlwaysOnTop(true);
        okCancelDialog.setVisible(true);
    }

    /**
     * members site - delete/change member dialog code for when close is pressed
     */
    public void buttonCloseOkCancel() {
        okCancelDialog.setAlwaysOnTop(false);
        okCancelDialog.setVisible(false);
    }

    /**
     * members site - new results dialog code for when close button is pressed
     */
    public void buttonNewResultsClose() {
        dialogNewResults.setAlwaysOnTop(false);
        dialogNewResults.setVisible(false);
    }

    /**
     * membersite - new results dialog code for when send result is pressed
     */
    public void buttonNewResultsSendData() {
        Controller.addResult();

    }

    /**
     * ************************************************************************************
     * comboBox methods
     */
    /**
     * members site sets several combobox, labels and panels to hide or show
     */
    public void comboBoxMotionistKonkurrence() {
        if (comboBoxMotionistKonkurrence.getSelectedItem().equals("Konkurrencesvømmer")) {
            panelDisciplin.setVisible(true);
            comboBoxTrainedBy.setVisible(true);
            labelTrainedBy.setVisible(true);
            labelDiscipliner.setVisible(true);
        } else {
            panelDisciplin.setVisible(false);
            comboBoxTrainedBy.setVisible(false);
            labelTrainedBy.setVisible(false);
            labelDiscipliner.setVisible(false);
        }
    }

    /**
     * members site
     * sets several combobox, labels and panels to hide or show
     */
    public void comboBoxStatus() {
        if (comboBoxStatus.getSelectedItem().equals("Aktiv")) {
            comboBoxMotionistKonkurrence.setVisible(true);
            panelDisciplin.setVisible(true);
            comboBoxTrainedBy.setVisible(true);
            labelTrainedBy.setVisible(true);
            labelDiscipliner.setVisible(true);
        } else {
            comboBoxMotionistKonkurrence.setVisible(false);
            panelDisciplin.setVisible(false);
            comboBoxTrainedBy.setVisible(false);
            labelTrainedBy.setVisible(false);
            labelDiscipliner.setVisible(false);
        }
    }

    /**
     * ************************************************************************************
     * Menu
     */
    /**
     * menu System When Resultater is pressed
     */
    public void menuSystemMembers() {
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelMembers");
    }

    /**
     * menu System When Kassen is pressed
     */
    public void menuSystemAccount() {
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelAccount");
    }

    /**
     * menu System When Resultater is pressed
     */
    public void menuSystemResults(String[][] rygCrawl, String[][] crawl,
            String[][] brystSvoemning, String[][] butterfly) {
        //Cleanup long float digits
        for (int i = 0; i < 5; i++) {
            rygCrawl[0][i] = String.format("%.5s", rygCrawl[0][i]);
        }

        for (int i = 0; i < 5; i++) {
            crawl[0][i] = String.format("%.5s", crawl[0][i]);
        }

        for (int i = 0; i < 5; i++) {
            brystSvoemning[0][i] = String.format("%.5s", brystSvoemning[0][i]);
        }

        for (int i = 0; i < 5; i++) {
            butterfly[0][i] = String.format("%.5s", butterfly[0][i]);
        }

        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelResults");

        for (int j = 0; j < 5; j++) {
            resultsTableTopFem.setValueAt(rygCrawl[1][j], j, 0);
            resultsTableTopFem.setValueAt(rygCrawl[0][j], j, 1);
            resultsTableTopFem.setValueAt(crawl[1][j], j, 2);
            resultsTableTopFem.setValueAt(crawl[0][j], j, 3);
            resultsTableTopFem.setValueAt(brystSvoemning[1][j], j, 4);
            resultsTableTopFem.setValueAt(brystSvoemning[0][j], j, 5);
            resultsTableTopFem.setValueAt(butterfly[1][j], j, 6);
            resultsTableTopFem.setValueAt(butterfly[0][j], j, 7);
        }
    }

    /**
     * ************************************************************************************
     * List Account methods
     */
    /**
     * accouting site
     * input check, Regex for address
     */
    public void accountListDebitor() {
        accountTextFieldSelectedMember.setText("");
        accountTextFieldSelectedMember.setText(accountListDebitor.getSelectedValue());
        accountTextFieldRestance.setText(Controller.SubscriptionValue(accountListDebitor.getSelectedValue()));
        Controller.restancePerMember();

    }

    /**
     * ************************************************************************************
     * textfield Member methods
     */
    /**
     * members site
     * input check, Regex for address
     */
    public void textFieldAdresse() {
        if (textFieldAdresse.getText().isEmpty()) {
            textFieldAdresse.setBackground(Color.pink);
        } else {
            regexUserInfoBackGroundColorSet("^\\w+((\\s.+)+)?,(\\s)?\\d{4}\\s\\w+((\\s\\w+)+)?$", textFieldAdresse);
        }

    }

    /**
     * members site
     * input check, Regex for address
     */
    public void textFieldAlder() {

        if (!textFieldAlder.getText().isEmpty() && (Integer.parseInt(textFieldAlder.getText()) < 0
                || Integer.parseInt(textFieldAlder.getText()) > 120)) {
            textFieldAlder.setBackground(Color.red);
            textFieldAlder.setForeground(Color.white);
        } else {
            clearFormatedText(textPaneMedlemsInfo);
            textFieldAlder.setBackground(Color.white);
            textFieldAlder.setForeground(Color.black);
        }
    }

    /**
     * members site
     * input check, Regex for email
     */
    public void textFieldEmail() {
        if (textFieldEmail.getText().isEmpty()) {
            textFieldEmail.setBackground(Color.pink);
        } else {
            // input check, Regex for email
            regexUserInfoBackGroundColorSet("^\\w+@\\w+\\.\\w+$", textFieldEmail);
        }

    }

    /**
     * members site
     * input check, Regex for ID
     */
    public void textFieldID() {
        if (regexUserInfoBackGroundColorSet("^\\d+$", DelfinGUI.textFieldID)) {
            if (Integer.parseInt(textFieldID.getText()) < 0) {
                textFieldID.setBackground(Color.red);
                textFieldID.setForeground(Color.white);
            } else {
                textFieldID.setBackground(Color.white);
                textFieldID.setForeground(Color.black);
            }
        }
    }

    /**
     * members site
     * input check, Regex for name
     */
    public void textFieldNavn() {
        if (textFieldNavn.getText().isEmpty()) {
            textFieldNavn.setBackground(Color.pink);
        } else {
            regexUserInfoBackGroundColorSet("^.+(\\s.+)*$", textFieldNavn);
        }

    }

    /**
     * members site
     * input check, Regex for Telephone
     */
    public void textFieldTelefon() {
        if (textFieldTelefon.getText().isEmpty()) {
            textFieldTelefon.setBackground(Color.pink);
        } else {
            regexUserInfoBackGroundColorSet("^(\\+)?\\d+$", textFieldTelefon);
        }
    }

    /**
     * *************************************************************************
     * textField NewResults
     *
     */
    /**
     * members site - new results
     * set colour and put in now as date and time
     */
    public void textField_FocusGained_NewResultsDate() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsDate);
        textFieldNewResultsDate.setText(formatDate("d.M.yyyy HH:mm"));
    }

    /**
     * members site - new results
     * input check, Regex for Date
     */
    public void textFieldNewResultsDate() {
        if (textFieldNewResultsDate.getText().isEmpty()) {
            textFieldNewResultsDate.setBackground(Color.pink);
        } else {
            regexUserInfoBackGroundColorSet("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}\\s\\d{2}:\\d{2}", textFieldNewResultsDate);
        }
    }

    /**
     * members site - new results
     * clears chosen event
     */
    public void textField_FocusGained_NewResultsEvent() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsEvent);
    }

    /**
     * members site - new results
     * input check, Regex for Event
     */
    public void textFieldNewResultsEvent() {
        if (textFieldNewResultsEvent.getText().isEmpty()) {
            textFieldNewResultsEvent.setBackground(Color.pink);
        } else {
            regexUserInfoBackGroundColorSet("^.+(\\s+)?(.+)?$", textFieldNewResultsEvent);
        }
    }

    /**
     * members site - new results
     * clears chosen ranking
     */
    public void textField_FocusGained_NewResultsPlace() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsPlace);
    }

    /**
     * members site
     * input check, Regex for Ranking
     */
    public void textFieldNewResultsPlace() {
        if (textFieldNewResultsPlace.getText().isEmpty()) {
            textFieldNewResultsPlace.setBackground(Color.pink);
        } else {
            if (regexUserInfoBackGroundColorSet("^\\d+$", textFieldNewResultsPlace)) {
                if (Integer.parseInt(textFieldNewResultsPlace.getText()) < 0) {
                    textFieldNewResultsPlace.setBackground(Color.red);
                    textFieldNewResultsPlace.setForeground(Color.white);
                } else {
                    textFieldNewResultsPlace.setBackground(Color.white);
                    textFieldNewResultsPlace.setForeground(Color.black);
                }
            }
        }
    }

    /**
     * members site
     * clears textfield
     */
    public void textField_FocusGained_NewResultsTime() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsTime);
    }

    /**
     * members site
     * input check, Regex for Time
     */
    public void textFieldNewResultsTime() {
        if (textFieldNewResultsTime.getText().isEmpty()) {
            textFieldNewResultsTime.setBackground(Color.pink);
        } else {
            if (regexUserInfoBackGroundColorSet("^\\d+(\\.\\d+)?$", textFieldNewResultsTime)) {
                if (Float.parseFloat(textFieldNewResultsTime.getText()) < 0) {
                    textFieldNewResultsTime.setBackground(Color.red);
                    textFieldNewResultsTime.setForeground(Color.white);
                } else {
                    textFieldNewResultsTime.setBackground(Color.white);
                    textFieldNewResultsTime.setForeground(Color.black);
                }
            }
        }
    }

    /**
     * resetting textfields
     */
    public void textFieldNewResultsClearWhiteBackground(JTextField tf) {
        tf.setText("");
        tf.setBackground(Color.white);
        tf.setForeground(Color.black);
    }

    /**
     * *************************************************************************
     * results selection from table
     *
     */
    /**
     * change to member page when name is pressed
     * and sets some attributes before searching
     */
    public void changeToMemberAndSearch() {
        JTable tab = resultsTableTopFem;
        String member = tab.getValueAt(tab.getSelectedRow(),
                tab.getSelectedColumn()).toString();
        ClearFieldToPink();
        textFieldNavn.setText(member);
        DelfinGUI.setMotionistKonkurrence("Konkurrencesvømmer");
        for (String trainerName : Controller.getTrainerNames()) {
            if (trainerName.equals(member)) {
                checkBoxTrainer.setSelected(true);
            } else {

                checkBoxTrainer.setSelected(false);
            }
        }
        Controller.search();
        menuSystemMembers(); // change to members layer
    }

    /**
     * *************************************************************************
     * Tools
     *
     */
    /**
     * 
     * @param format
     * @return the time of now in chosen format
     */
    public String formatDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }

    /**
     * 
     * several different types of fonts
     * for member info box in members site
     */
    public void displayPlainBlack(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.black);
    }

    public void displayPlainRed(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.red);
    }

    public void displayBoldRed(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.red);
    }

    public void displayBoldBlack(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.black);
    }

    public void displayPlainGreen(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.green);
    }

    public void displayBoldGreen(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.green);
    }

    public void displayPlainBlue(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.blue);
    }

    public void displayBoldBlue(String text) {
        displayFormatedText(textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.blue);
    }

    /**
     * display formatted text in chosen font, colour and location
     * @param tp -> location
     * @param txt -> printed text
     * @param font -> chosen font
     * @param color -> chosen colour
     */
    public void displayFormatedText(JTextPane tp, String txt, Font font, Color color) {

        StyledDocument doc = (StyledDocument) tp.getDocument();
        try {
            doc.insertString(doc.getLength(), txt, displayFormat(font, color));
        } catch (BadLocationException ex) {
            System.out.println(ex);
        }
    }

    /**
     * return attributes for formatting text needed by displayFormatedText()
     * @param font, chosen font
     * @param color, chosen colour
     * @return type SimpleAttributeSet used in displayFormatedText()
     */
    public SimpleAttributeSet displayFormat(Font font, Color color) {
        SimpleAttributeSet sAS = new SimpleAttributeSet();

        StyleConstants.setFontFamily(sAS, font.getFamily());
        StyleConstants.setFontSize(sAS, font.getSize());
        StyleConstants.setBold(sAS, font.isBold());
        StyleConstants.setItalic(sAS, font.isItalic());
        StyleConstants.setForeground(sAS, color);

        return sAS;
    }

    /**
     * clear text in chosen textpane
     * @param tp 
     */
    public void clearFormatedText(JTextPane tp) {
        tp.setText("");
    }

    /**
     * check patterns in chosen textfield and sets colors in textfields accordingly
     * @param regex
     * @param tf, textfield
     * @return, both set color and returns boolean
     */
    public boolean regexUserInfoBackGroundColorSet(String regex, JTextField tf) {
        // check user input and set background accordingly
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tf.getText());
        if (!matcher.matches()) {
            tf.setBackground(Color.red);

            tf.setForeground(Color.white);
            return false;
        } else {
            tf.setBackground(Color.white);
            tf.setForeground(Color.black);

            return true;
        }
    }

}
