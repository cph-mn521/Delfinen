package delfinen.presentation;

import delfinen.Controller;
import delfinen.data.DataException;
import delfinen.logic.Accountant;
import delfinen.logic.Member;
import delfinen.logic.Subscription;
import static delfinen.presentation.DelfinGUI.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.image.ImageObserver.ERROR;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Methods from GUI placed here for easier perusing
 *
 * @author martin b.
 */
public class DelfinGUImethods {

    Font FONT_NOTOSANS_PLAIN_12 = new Font("notosans", Font.PLAIN, 12);
    Font FONT_NOTOSANS_BOLD_12 = new Font("notosans", Font.BOLD, 12);
    Font FONT_NOTOSANS_ITALIC_12 = new Font("notosans", Font.ITALIC, 12);
    Font FONT_NOTOSANS_BOLD_ITALIC_12 = new Font("notosans", Font.BOLD + Font.ITALIC, 12);

    /**
     * ************************************************************************************
     * button methods
     */
    /**
     *
     */
    public void ClearFieldToPink() {
        for (JTextField textField : textFields) {
            textField.setText("");
            textField.setBackground(Color.pink);
        }
    }

    /**
     *
     */
    public void buttonNewResult() {
        dialogNewResults.setAlwaysOnTop(true);
        dialogNewResults.setVisible(true);
        labelNewResultsMemberName.setText(textFieldNavn.getText());
    }

    /**
     *
     */
    public void buttonNewResultsClose() {
        dialogNewResults.setAlwaysOnTop(false);
        dialogNewResults.setVisible(false);
    }

    /**
     *
     */
    public void buttonNewResultsSendData() {
//        dialogNewResults.setAlwaysOnTop(false);
        Controller.addResult();
//        dialogNewResults.setVisible(false);

    }

    /**
     * ************************************************************************************
     * comboBox methods
     */
    /**
     *
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
     * When Resultater is pressed
     */
    public void menuSystemMembers() {
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelMembers");
    }

    public void menuSystemResults(String[][] rygCrawl, String[][] crawl,
            String[][] brystSvoemning, String[][] butterfly) {
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelResults");

        for (int j = 0; j < 4; j++) {
            resultsTableTopFem.setValueAt(rygCrawl[1][j], j, 0);
            resultsTableTopFem.setValueAt(crawl[1][j], j, 1);
            resultsTableTopFem.setValueAt(brystSvoemning[1][j], j, 2);
            resultsTableTopFem.setValueAt(butterfly[1][j], j, 3);
        }
    }

    /**
     * ************************************************************************************
     * List Account methods
     */
    /**
     * input check, Regex for address
     */
    public void accountListDebitor() {
        accountTextFieldSelectedMember.setText("");
        accountTextFieldSelectedMember.setText(accountListDebitor.getSelectedValue());
        accountTextFieldRestance.setText("");
        Controller.restancePerMember();
    }

    /**
     * ************************************************************************************
     * textfield Member methods
     */
    /**
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
     * input check, Regex for address
     */
    public void textFieldAlder() {

        if (Integer.parseInt(textFieldAlder.getText()) < 0
                || Integer.parseInt(textFieldAlder.getText()) > 120) {
            textFieldAlder.setBackground(Color.red);
            textFieldAlder.setForeground(Color.white);
        } else {
            clearFormatedText(textPaneMedlemsInfo);
            textFieldAlder.setBackground(Color.white);
            textFieldAlder.setForeground(Color.black);
        }
    }

    /**
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
     *
     */
    public void textField_FocusGained_NewResultsDate() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsDate);
        textFieldNewResultsDate.setText(formatDate("d-M-yyyy HH:mm"));
    }

    /**
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
     *
     */
    public void textField_FocusGained_NewResultsEvent() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsEvent);
    }

    /**
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
     *
     */
    public void textField_FocusGained_NewResultsPlace() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsPlace);
    }

    /**
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
     *
     */
    public void textField_FocusGained_NewResultsTime() {
        textFieldNewResultsClearWhiteBackground(textFieldNewResultsTime);
    }

    /**
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
     *
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
     *
     */
    public void changeToMemberAndSearch() {
        JTable tab = resultsTableTopFem;
        String member = tab.getValueAt(tab.getSelectedRow(),
                tab.getSelectedColumn()).toString();
        ClearFieldToPink();
        textFieldNavn.setText(member);
        Controller.search();
        menuSystemMembers(); // change to members layer
    }

    /**
     * *************************************************************************
     * Tools
     *
     */
    public String formatDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }

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

    public void displayFormatedText(JTextPane tp, String txt, Font font, Color color) {

        StyledDocument doc = (StyledDocument) tp.getDocument();
        try {
            doc.insertString(doc.getLength(), txt, displayFormat(font, color));
        } catch (BadLocationException ex) {
            System.out.println(ex);
        }
    }

    public SimpleAttributeSet displayFormat(Font font, Color color) {
        SimpleAttributeSet sAS = new SimpleAttributeSet();

        StyleConstants.setFontFamily(sAS, font.getFamily());
        StyleConstants.setFontSize(sAS, font.getSize());
        StyleConstants.setBold(sAS, font.isBold());
        StyleConstants.setItalic(sAS, font.isItalic());
        StyleConstants.setForeground(sAS, color);

        return sAS;
    }

    public void clearFormatedText(JTextPane tp) {
        tp.setText("");
    }

    public boolean regexUserInfoBackGroundColorSet(String regex, JTextField tf) {
        // check user input and set background accordingly
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tf.getText());
        if (!matcher.matches()) {
            tf.setBackground(Color.red);

            tf.setForeground(Color.white);
//            displayFormatedText(DelfinGUI.textPaneMedlemsInfo, err, FONT_NOTOSANS_PLAIN_12, Color.RED);
            return false;
        } else {
            tf.setBackground(Color.white);
            tf.setForeground(Color.black);
//            clearFormatedText(DelfinGUI.textPaneMedlemsInfo);

            return true;
        }
    }

}
