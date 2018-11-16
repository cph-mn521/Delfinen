package delfinen.presentation;

import java.awt.Color;
import java.awt.Font;
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

    public void textFieldID() {

        // input check, Regex for ID
        regexUserInfoBackGroundColorSet("^\\d+$", DelfinGUI.textFieldID,
                "ID skal være et tal større end 0\n");
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
            displayFormatedText(DelfinGUI.textPaneMedlemsInfo, err, FONT_NOTOSANS_PLAIN_12, Color.RED);
            return false;
        } else {
            tf.setBackground(Color.white);
            clearFormatedText(DelfinGUI.textPaneMedlemsInfo);
            return true;
        }
    }
}
