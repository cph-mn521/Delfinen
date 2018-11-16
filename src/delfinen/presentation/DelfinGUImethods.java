package delfinen.presentation;

import static delfinen.presentation.DelfinGUI.comboBoxMotionistKonkurrence;
import static delfinen.presentation.DelfinGUI.comboBoxStatus;
import static delfinen.presentation.DelfinGUI.comboBoxTrainedBy;
import static delfinen.presentation.DelfinGUI.labelDiscipliner;
import static delfinen.presentation.DelfinGUI.labelTrainedBy;
import static delfinen.presentation.DelfinGUI.panelDisciplin;
import static delfinen.presentation.DelfinGUI.textFieldAdresse;
import static delfinen.presentation.DelfinGUI.textFieldAlder;
import static delfinen.presentation.DelfinGUI.textFieldEmail;
import static delfinen.presentation.DelfinGUI.textFieldNavn;
import static delfinen.presentation.DelfinGUI.textFieldNewResultsDate;
import static delfinen.presentation.DelfinGUI.textFieldTelefon;
import static delfinen.presentation.DelfinGUI.textPaneMedlemsInfo;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        for (JTextField textField : DelfinGUI.textFields) {
            textField.setText("");
            textField.setBackground(Color.pink);
        }
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
     * textfield Member methods
     */
    /**
     *
     */
    public void textFieldAdresse() {
        if (textFieldAdresse.getText().isEmpty()) {
            textFieldAdresse.setBackground(Color.pink);
        } else {
            // input check, Regex for address
            regexUserInfoBackGroundColorSet("^.+,(\\s+)?\\d{4}.+$", textFieldAdresse,
                    "Adresse skal være i formatet: adresse, 2938 Bynavn\n");
        }
    }

    /**
     *
     */
    public void textFieldAlder() {
        if (textFieldAlder.getText().isEmpty()) {
            textFieldAlder.setBackground(Color.pink);
        } else {
            // input check, Regex for address
            String err = "Alder skal være et tal mellem 0 og 120 år\n";
            regexUserInfoBackGroundColorSet("^\\d+$", textFieldAlder,
                    err);
            if (Integer.parseInt(textFieldAlder.getText()) < 0
                    || Integer.parseInt(textFieldAlder.getText()) > 120) {
                textFieldAlder.setBackground(Color.red);
                displayPlainRed(err);
            } else {
                clearFormatedText(textPaneMedlemsInfo);
                textFieldAlder.setBackground(Color.white);
            }
        }
    }

    /**
     *
     */
    public void textFieldEmail() {
        if (textFieldEmail.getText().isEmpty()) {
            textFieldEmail.setBackground(Color.pink);
        } else {
            // input check, Regex for email
            regexUserInfoBackGroundColorSet("^.+@.+\\..+$", textFieldEmail,
                    "Email skal være i formatet: xx@yy.zz\n");
        }
    }

    /**
     * input check, Regex for ID
     */
    public void textFieldID() {
        regexUserInfoBackGroundColorSet("^\\d+$", DelfinGUI.textFieldID,
                "ID skal være et tal større end 0\n");
    }

    /**
     *
     */
    public void textFieldNavn() {
        if (textFieldNavn.getText().isEmpty()) {
            textFieldNavn.setBackground(Color.pink);
        } else {
            // input check, Regex for name
            regexUserInfoBackGroundColorSet("^\\w+((\\s\\w+)+)?$", textFieldNavn,
                    "Navnet skal være i formatet: xxxx, eller xxx yyyy mfl.\n");
        }
    }

    /**
     *
     */
    public void textFieldTelefon() {
        if (textFieldTelefon.getText().isEmpty()) {
            textFieldTelefon.setBackground(Color.pink);
        } else {
            // input check, Regex for Telephone
            regexUserInfoBackGroundColorSet("^\\d+$", textFieldTelefon,
                    "Telefonnummer skal være i formatet: 12345678\n");
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
    public void textFieldNewResultsDate() {
        DelfinGUI.textFieldNewResultsDate.setText("");
        DelfinGUI.textFieldNewResultsDate.setBackground(Color.white);
        textFieldNewResultsDate.setText(formatDate("d-M-yyyy HH:mm"));
    }

    /**
     *
     */
    public void textFieldNewResultsTime() {
        DelfinGUI.textFieldNewResultsTime.setText("");
        DelfinGUI.textFieldNewResultsTime.setBackground(Color.white);
    }

    /**
     *
     */
    public void textFieldNewResultsClearWhiteBackground() {
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
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.black);
    }

    public void displayPlainRed(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.red);
    }

    public void displayBoldRed(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.red);
    }

    public void displayBoldBlack(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.black);
    }

    public void displayPlainGreen(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.green);
    }

    public void displayBoldGreen(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.green);
    }

    public void displayPlainBlue(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_PLAIN_12, Color.blue);
    }

    public void displayBoldBlue(String text) {
        displayFormatedText(DelfinGUI.textPaneMedlemsInfo, text, FONT_NOTOSANS_BOLD_12, Color.blue);
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

    public boolean regexUserInfoBackGroundColorSet(String regex, JTextField tf,
            String err) {
        // check user input and set background accordingly
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tf.getText());
        if (!matcher.matches()) {
            tf.setBackground(Color.red);
//            displayFormatedText(DelfinGUI.textPaneMedlemsInfo, err, FONT_NOTOSANS_PLAIN_12, Color.RED);
            return false;
        } else {
            tf.setBackground(Color.white);
//            clearFormatedText(DelfinGUI.textPaneMedlemsInfo);
            return true;
        }
    }
}
