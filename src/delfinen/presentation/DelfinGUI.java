/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.presentation;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.accessibility.AccessibleContext;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author martin b.
 */
public class DelfinGUI extends javax.swing.JFrame {

    ArrayList<JCheckBox> discipliner = new ArrayList<>();

    /**
     * Creates new form DelfinGUI
     */
    public DelfinGUI() {
        initComponents();
        discipliner.add(checkBoxDisciplinBryst);
        discipliner.add(checkBoxDisciplinButterfly);
        discipliner.add(checkBoxDisciplinCrawl);
        discipliner.add(checkBoxDisciplinRygcrawl);
        textFieldEmail.setBackground(Color.white);
        textFieldAdresse.setBackground(Color.white);
        textFieldAlder.setBackground(Color.white);
        textFieldEmail.setBackground(Color.white);
        textFieldID.setBackground(Color.white);
        textFieldNavn.setBackground(Color.white);
        textFieldTelefon.setBackground(Color.white);
        textPaneMedlemsInfo.setBackground(Color.white);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelMedlemmer = new javax.swing.JPanel();
        buttonMedlem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldTelefon = new javax.swing.JTextField();
        textFieldAlder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldAdresse = new javax.swing.JTextField();
        textFieldNavn = new javax.swing.JTextField();
        comboBoxMotionistKonkurrence = new javax.swing.JComboBox<>();
        panelDisciplin = new javax.swing.JPanel();
        checkBoxDisciplinBryst = new javax.swing.JCheckBox();
        checkBoxDisciplinButterfly = new javax.swing.JCheckBox();
        checkBoxDisciplinCrawl = new javax.swing.JCheckBox();
        checkBoxDisciplinRygcrawl = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneMedlemsInfo = new javax.swing.JTextPane();
        labelDelfinIcon = new javax.swing.JLabel();
        buttonSearchMember = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        panelAbout = new javax.swing.JPanel();
        panelLogo = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buttonClose = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuFileClose = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();
        menuHelpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelMain.setLayout(new java.awt.CardLayout());

        buttonMedlem.setText("Nyt Medlem");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktiv", "Passiv" }));
        comboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStatusActionPerformed(evt);
            }
        });

        jLabel7.setText("Alder");

        jLabel3.setText("Status");

        textFieldTelefon.setText("25854578");
        textFieldTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTelefonActionPerformed(evt);
            }
        });

        textFieldAlder.setText("23");
        textFieldAlder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAlderActionPerformed(evt);
            }
        });

        jLabel2.setText("Navn");

        textFieldID.setText("1");
        textFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        textFieldEmail.setText("lm@delfinen.dk");
        textFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldEmailActionPerformed(evt);
            }
        });

        jLabel6.setText("Adresse");

        jLabel5.setText("Telefon");

        jLabel4.setText("Email");

        textFieldAdresse.setText("Ligustervænget 23, 2756 Liguster");
        textFieldAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAdresseActionPerformed(evt);
            }
        });

        textFieldNavn.setText("Lars Emil");
        textFieldNavn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNavnActionPerformed(evt);
            }
        });

        comboBoxMotionistKonkurrence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motionist", "Konkurrencesvømmer" }));
        comboBoxMotionistKonkurrence.setSelectedIndex(1);
        comboBoxMotionistKonkurrence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMotionistKonkurrenceActionPerformed(evt);
            }
        });

        checkBoxDisciplinBryst.setText("Brystsvømning");

        checkBoxDisciplinButterfly.setSelected(true);
        checkBoxDisciplinButterfly.setText("Butterfly");

        checkBoxDisciplinCrawl.setText("Crawl");

        checkBoxDisciplinRygcrawl.setSelected(true);
        checkBoxDisciplinRygcrawl.setText("Rygcrawl");

        javax.swing.GroupLayout panelDisciplinLayout = new javax.swing.GroupLayout(panelDisciplin);
        panelDisciplin.setLayout(panelDisciplinLayout);
        panelDisciplinLayout.setHorizontalGroup(
            panelDisciplinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDisciplinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDisciplinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxDisciplinButterfly)
                    .addComponent(checkBoxDisciplinRygcrawl)
                    .addComponent(checkBoxDisciplinCrawl)
                    .addComponent(checkBoxDisciplinBryst))
                .addContainerGap())
        );
        panelDisciplinLayout.setVerticalGroup(
            panelDisciplinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDisciplinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxDisciplinButterfly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDisciplinCrawl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDisciplinRygcrawl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxDisciplinBryst)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelDisciplin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(textFieldAlder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxMotionistKonkurrence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textFieldAlder, textFieldID});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textFieldAdresse, textFieldEmail, textFieldNavn, textFieldTelefon});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldAlder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxMotionistKonkurrence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(panelDisciplin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        textPaneMedlemsInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.gray, java.awt.Color.white));
        jScrollPane1.setViewportView(textPaneMedlemsInfo);

        labelDelfinIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/delfin.jpg"))); // NOI18N
        labelDelfinIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonSearchMember.setText("Søg medlem");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 36)); // NOI18N
        jLabel9.setText("Medlemmer");

        javax.swing.GroupLayout panelMedlemmerLayout = new javax.swing.GroupLayout(panelMedlemmer);
        panelMedlemmer.setLayout(panelMedlemmerLayout);
        panelMedlemmerLayout.setHorizontalGroup(
            panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMedlemmerLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMedlemmerLayout.createSequentialGroup()
                        .addComponent(labelDelfinIcon)
                        .addGap(18, 18, 18)
                        .addGroup(panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSearchMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonMedlem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );
        panelMedlemmerLayout.setVerticalGroup(
            panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedlemmerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMedlemmerLayout.createSequentialGroup()
                        .addGroup(panelMedlemmerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMedlemmerLayout.createSequentialGroup()
                                .addComponent(buttonSearchMember, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(buttonMedlem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDelfinIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMedlemmerLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        panelMain.add(panelMedlemmer, "panelMedlemmer");

        panelLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setText("BBW software 2018");

        buttonClose.setText("Close");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/BBW.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClose)
                .addGap(190, 190, 190))
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClose)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAboutLayout = new javax.swing.GroupLayout(panelAbout);
        panelAbout.setLayout(panelAboutLayout);
        panelAboutLayout.setHorizontalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAboutLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(178, 178, 178))
        );
        panelAboutLayout.setVerticalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAboutLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        panelMain.add(panelAbout, "panelAbout");

        getContentPane().add(panelMain, "card4");

        menuFile.setText("File");

        menuFileClose.setText("Close");
        menuFileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileCloseActionPerformed(evt);
            }
        });
        menuFile.add(menuFileClose);

        menuBar.add(menuFile);

        menuEdit.setText("Edit");
        menuBar.add(menuEdit);

        menuHelp.setText("Help");

        menuHelpAbout.setText("About");
        menuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHelpAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuHelpAbout);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String getStatus() {
        return comboBoxStatus.getSelectedItem().toString();
    }

    public ArrayList<String> getDisciplin() {
        ArrayList<String> disc = new ArrayList<>();
        for (JCheckBox jCheckbox : discipliner) {
            if (jCheckbox.isSelected()) {
                disc.add(jCheckbox.getText());
            }
        }
        return disc;
    }

    public String getMotionKonkurrence() {
        return comboBoxMotionistKonkurrence.getSelectedItem().toString();
    }

    public String getMedlemsInfo() {
        if (textPaneMedlemsInfo.getBackground() == Color.white) {
            return textPaneMedlemsInfo.getText();
        } else {
            return "";
        }
    }

    public String getAdresse() {
        if (textFieldEmail.getBackground() == Color.white) {
            return textFieldAdresse.getText();
        } else {
            return "";
        }
    }

    public int getAlder() {
        if (textFieldAlder.getBackground() == Color.white) {
            return Integer.parseInt(textFieldAlder.getText());
        } else {
            return 0;
        }
    }

    public String getEmail() {
        if (textFieldEmail.getBackground() == Color.white) {
            return textFieldEmail.getText();
        } else {
            return "";
        }
    }

    public int getID() {
        if (textFieldID.getBackground() == Color.white) {
            return Integer.parseInt(textFieldID.getText());
        } else {
            return 0;
        }
    }

    public String getNavn() {
        if (textFieldNavn.getBackground() == Color.white) {
            return textFieldNavn.getText();
        } else {
            return "";
        }
    }

    public int getTelefon() {
        if (textFieldTelefon.getBackground() == Color.white) {
            return Integer.parseInt(textFieldTelefon.getText());
        } else {
            return 0;
        }
    }

    public void setDiscipliner(ArrayList<JCheckBox> discipliner) {
        this.discipliner = discipliner;
    }

    public void setCheckBoxDisciplinBryst(JCheckBox checkBoxDisciplinBryst) {
        this.checkBoxDisciplinBryst = checkBoxDisciplinBryst;
    }

    public void setCheckBoxDisciplinButterfly(JCheckBox checkBoxDisciplinButterfly) {
        this.checkBoxDisciplinButterfly = checkBoxDisciplinButterfly;
    }

    public void setCheckBoxDisciplinCrawl(JCheckBox checkBoxDisciplinCrawl) {
        this.checkBoxDisciplinCrawl = checkBoxDisciplinCrawl;
    }

    public void setCheckBoxDisciplinRygcrawl(JCheckBox checkBoxDisciplinRygcrawl) {
        this.checkBoxDisciplinRygcrawl = checkBoxDisciplinRygcrawl;
    }

    public void setComboBoxMotionistKonkurrence(JComboBox<String> comboBoxMotionistKonkurrence) {
        this.comboBoxMotionistKonkurrence = comboBoxMotionistKonkurrence;
    }

    public void setComboBoxStatus(JComboBox<String> comboBoxStatus) {
        this.comboBoxStatus = comboBoxStatus;
    }

    public void setTextFieldAdresse(String textFieldAdresse) {
        this.textFieldAdresse.setText(textFieldAdresse);
    }

    public void setTextFieldAlder(int textFieldAlder) {
        this.textFieldAlder.setText(String.valueOf(textFieldAlder));
    }

    public void setTextFieldEmail(String textFieldEmail) {
        this.textFieldEmail.setText(textFieldEmail);
    }

    public void setTextFieldID(int textFieldID) {
        this.textFieldID.setText(String.valueOf(textFieldID));
    }

    public void setTextFieldNavn(String textFieldNavn) {
        this.textFieldNavn.setText(textFieldNavn);
    }

    public void setTextFieldTelefon(JTextField textFieldTelefon) {
        this.textFieldTelefon = textFieldTelefon;
    }

    public void setTextPaneMedlemsInfo(String textPaneMedlemsInfo) {
//        this.textPaneMedlemsInfo.add.append(textPaneMedlemsInfo);
    }

    public static int getEXIT_ON_CLOSE() {
        return EXIT_ON_CLOSE;
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    private void textFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIDActionPerformed
        // input check, Regex for ID
        regexUserInfoBackGroundColorSet("^\\d+$", textFieldID);
    }//GEN-LAST:event_textFieldIDActionPerformed

    private void menuFileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuFileCloseActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelMedlemmer");
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void menuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHelpAboutActionPerformed
        CardLayout card = (CardLayout) panelMain.getLayout();
        card.show(panelMain, "panelAbout");
    }//GEN-LAST:event_menuHelpAboutActionPerformed

    private void comboBoxMotionistKonkurrenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMotionistKonkurrenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMotionistKonkurrenceActionPerformed

    private void textFieldTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTelefonActionPerformed
        // input check, Regex for Telephone
        regexUserInfoBackGroundColorSet("^\\d+$", textFieldTelefon);
    }//GEN-LAST:event_textFieldTelefonActionPerformed

    private void comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStatusActionPerformed
        if (comboBoxStatus.getSelectedItem().toString().equals("Aktiv")) {
            comboBoxMotionistKonkurrence.show();
        } else {
            comboBoxMotionistKonkurrence.hide();
        }
    }//GEN-LAST:event_comboBoxStatusActionPerformed

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldEmailActionPerformed
        // input check, Regex for email
        regexUserInfoBackGroundColorSet("^.+@.+\\..+$", textFieldEmail);
    }//GEN-LAST:event_textFieldEmailActionPerformed

    private void textFieldAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAdresseActionPerformed
        // input check, Regex for address
        regexUserInfoBackGroundColorSet("^.+,\\s+\\d{4}.+$", textFieldAdresse);
    }//GEN-LAST:event_textFieldAdresseActionPerformed

    private void textFieldNavnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNavnActionPerformed
        // input check, Regex for name
        regexUserInfoBackGroundColorSet("^\\w+(\\s\\w+)+$", textFieldNavn);
    }//GEN-LAST:event_textFieldNavnActionPerformed

    private void textFieldAlderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAlderActionPerformed
        // input check, Regex for address
        regexUserInfoBackGroundColorSet("^\\d+$", textFieldAlder);
        if(Integer.parseInt(textFieldAlder.getText())<0 ||
                Integer.parseInt(textFieldAlder.getText())>120){
            textFieldAlder.setBackground(Color.red);
        } else {
            textFieldAlder.setBackground(Color.white);
        }
    }//GEN-LAST:event_textFieldAlderActionPerformed

    private void regexUserInfoBackGroundColorSet(String regex, JTextField tf) {
        // check user input and set background accordingly
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tf.getText());
        if (!matcher.matches()) {
            tf.setBackground(Color.red);
        } else {
            tf.setBackground(Color.white);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DelfinGUI other = (DelfinGUI) obj;
        if (!Objects.equals(this.comboBoxStatus, other.comboBoxStatus)) {
            return false;
        }
        if (!Objects.equals(this.textPaneMedlemsInfo, other.textPaneMedlemsInfo)) {
            return false;
        }
        if (!Objects.equals(this.textFieldAdresse, other.textFieldAdresse)) {
            return false;
        }
        if (!Objects.equals(this.textFieldAlder, other.textFieldAlder)) {
            return false;
        }
        if (!Objects.equals(this.textFieldEmail, other.textFieldEmail)) {
            return false;
        }
        if (!Objects.equals(this.textFieldID, other.textFieldID)) {
            return false;
        }
        if (!Objects.equals(this.textFieldNavn, other.textFieldNavn)) {
            return false;
        }
        if (!Objects.equals(this.textFieldTelefon, other.textFieldTelefon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DelfinGUI{" + "comboBoxStatus=" + comboBoxStatus + ", jTextPane1=" + textPaneMedlemsInfo + ", textFieldAdresse=" + textFieldAdresse + ", textFieldAlder=" + textFieldAlder + ", textFieldEmail=" + textFieldEmail + ", textFieldID=" + textFieldID + ", textFieldNavn=" + textFieldNavn + ", textFieldTelefon=" + textFieldTelefon + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DelfinGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonMedlem;
    private javax.swing.JButton buttonSearchMember;
    private javax.swing.JCheckBox checkBoxDisciplinBryst;
    private javax.swing.JCheckBox checkBoxDisciplinButterfly;
    private javax.swing.JCheckBox checkBoxDisciplinCrawl;
    private javax.swing.JCheckBox checkBoxDisciplinRygcrawl;
    private javax.swing.JComboBox<String> comboBoxMotionistKonkurrence;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDelfinIcon;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFileClose;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuHelpAbout;
    private javax.swing.JPanel panelAbout;
    private javax.swing.JPanel panelDisciplin;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMedlemmer;
    private javax.swing.JTextField textFieldAdresse;
    private javax.swing.JTextField textFieldAlder;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldNavn;
    private javax.swing.JTextField textFieldTelefon;
    private javax.swing.JTextPane textPaneMedlemsInfo;
    // End of variables declaration//GEN-END:variables
}
