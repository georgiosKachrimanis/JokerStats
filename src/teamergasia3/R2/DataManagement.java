package teamergasia3.R2;

import teamergasia3.R2.DrawDisplayScreen;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modal.DrawOpapJoker;
import org.json.simple.parser.ParseException;
import teamergasia3.DrawsFunctions;
import teamergasia3.DateFunctions;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class DataManagement extends javax.swing.JFrame {

    //      Create Arraylist for the Draws
    private ArrayList<DrawOpapJoker> drawsList = new ArrayList<>();
    //      Create Dateformat for the API    
    private DateFormat apiDateFormat = new SimpleDateFormat("YYYY-MM-dd");
    //      Create Draw Object
    private DrawOpapJoker draw;

    public DataManagement() {
        initComponents();
    }

    private int getGameId(String gameString) {
//        Switch to find gameId 
        switch (gameString) {
            case "JOKER":
                return 5104;
            case "KINO":
                return 5104;
            case "POWERSPIN":
                return 5104;
            case "SUPER3":
                return 5104;
            case "PROTO":
                return 5104;
            case "LOTTO":
                return 5104;
            case "EXTRA5":
                return 5104;
            default:
//                Return -1 if is not one of this
                return -1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        dataManagementPanel = new javax.swing.JPanel();
        displayDrawDataButton = new javax.swing.JButton();
        returnMainMenuButton = new javax.swing.JButton();
        drawTextField = new javax.swing.JTextField();
        titlePanel = new javax.swing.JLabel();
        gameComboBox = new javax.swing.JComboBox<>();
        gameDropBoxLabel = new javax.swing.JLabel();
        drawTextBoxLabel = new javax.swing.JLabel();
        dateInputLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        dataDeleteDrawButton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        dataDeletePeriodButton = new javax.swing.JButton();
        displayRangeDataButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Joker Game-Stats ΔΙΑΧΕΙΡΙΣΗ ΔΕΔΟΜΕΝΩΝ");
        setBackground(new java.awt.Color(0, 102, 204));

        dataManagementPanel.setBackground(new java.awt.Color(0, 51, 51));
        dataManagementPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dataManagementPanel.setToolTipText("STOPA ΔΙΑΧΕΙΡΙΣΗ ΔΕΔΟΜΕΝΩΝ");

        displayDrawDataButton.setText("ΕΜΦΑΝΙΣΗ ΔΕΔΟΜΕΝΩΝ ΚΛΗΡΩΣΗΣ");
        displayDrawDataButton.setToolTipText("Εμφάνιση δεδομένων σε νέο παράθυρο.");
        displayDrawDataButton.setMaximumSize(new java.awt.Dimension(170, 30));
        displayDrawDataButton.setMinimumSize(new java.awt.Dimension(170, 30));
        displayDrawDataButton.setPreferredSize(new java.awt.Dimension(170, 30));
        displayDrawDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayDrawDataButtonActionPerformed(evt);
            }
        });

        returnMainMenuButton.setText("ΕΠΙΣΤΡΟΦΗ");
        returnMainMenuButton.setToolTipText("");
        returnMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnMainMenuButtonActionPerformed(evt);
            }
        });

        drawTextField.setToolTipText("Εισάγεται τον αριθμό κλήρωσης.");
        drawTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        drawTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawTextFieldActionPerformed(evt);
            }
        });

        titlePanel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));
        titlePanel.setText("ΔΙΑΧΕΙΡΙΣΗ ΔΕΔΟΜΕΝΩΝ");

        gameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "JOKER", "KINO", "LOTTO", "PROTO", "ΕΧΤΡΑ 3", "SUPER 3" }));
        gameComboBox.setToolTipText("Επιλογή παιχνιδιού, για εμφάνιση των δεδομένων του.");
        gameComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameComboBoxActionPerformed(evt);
            }
        });

        gameDropBoxLabel.setForeground(new java.awt.Color(255, 255, 255));
        gameDropBoxLabel.setText("ΕΠΙΛΟΓΗ ΠΑΙΧΝΙΔΙΟΥ");

        drawTextBoxLabel.setForeground(new java.awt.Color(255, 255, 255));
        drawTextBoxLabel.setText("Εύρεση με αριθμό κλήρωσης:");

        dateInputLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateInputLabel.setText("Εύρεση σε χρονικό δίαστημα:");
        dateInputLabel.setToolTipText("Επιλογη ημερομηνίας έναρξης λήψης/διαγραφής δεδομένων");

        endDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        endDateLabel.setText("ΕΩΣ");

        startDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        startDateLabel.setText("ΑΠΟ");

        dataDeleteDrawButton.setText("ΔΙΑΓΡΑΦΗ ΔΕΔΟΜΕΝΩΝ ΚΛΗΡΩΣΗΣ");
        dataDeleteDrawButton.setToolTipText("Διαγραφή δεδομένων από την βάση δεδομένων.");
        dataDeleteDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDeleteDrawButtonActionPerformed(evt);
            }
        });

        jDateChooser1.setToolTipText("Εισάγεται την αρχική ημερομηνία περιόδου κληρώσεων.");
        jDateChooser1.setMaximumSize(new java.awt.Dimension(50, 30));
        jDateChooser1.setMinimumSize(new java.awt.Dimension(50, 30));
        jDateChooser1.setPreferredSize(new java.awt.Dimension(50, 30));

        jDateChooser2.setToolTipText("Εισάγεται την τελική  ημερομηνία περιόδου κληρώσεων.");
        jDateChooser2.setMaximumSize(new java.awt.Dimension(50, 30));
        jDateChooser2.setMinimumSize(new java.awt.Dimension(50, 30));
        jDateChooser2.setPreferredSize(new java.awt.Dimension(50, 30));

        dataDeletePeriodButton.setText("ΔΙΑΓΡΑΦΗ ΔΕΔΟΜΕΝΩΝ ΚΛΗΡΩΣΕΩΝ ΕΝΤΟΣ ΕΥΡΟΥΣ ΗΜΕΡΟΜΗΝΙΩΝ");
        dataDeletePeriodButton.setToolTipText("Διαγραφή δεδομένων από την βάση δεδομένων.");
        dataDeletePeriodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDeletePeriodButtonActionPerformed(evt);
            }
        });

        displayRangeDataButton.setText("ΕΜΦΑΝΙΣΗ ΚΛΗΡΩΣΕΩΝ ΕΝΤΟΣ ΕΥΡΟΥΣ ΗΜΕΡΟΜΗΝΙΩΝ");
        displayRangeDataButton.setMaximumSize(new java.awt.Dimension(170, 30));
        displayRangeDataButton.setMinimumSize(new java.awt.Dimension(170, 30));
        displayRangeDataButton.setPreferredSize(new java.awt.Dimension(170, 30));
        displayRangeDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayRangeDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataManagementPanelLayout = new javax.swing.GroupLayout(dataManagementPanel);
        dataManagementPanel.setLayout(dataManagementPanelLayout);
        dataManagementPanelLayout.setHorizontalGroup(
            dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataManagementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawTextBoxLabel)
                    .addComponent(drawTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateInputLabel)
                    .addComponent(startDateLabel)
                    .addComponent(endDateLabel)
                    .addComponent(gameDropBoxLabel)
                    .addGroup(dataManagementPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayDrawDataButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataDeleteDrawButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataManagementPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnMainMenuButton))
                    .addComponent(dataDeletePeriodButton, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(dataManagementPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(displayRangeDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataManagementPanelLayout.setVerticalGroup(
            dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataManagementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel)
                .addGap(19, 19, 19)
                .addComponent(gameDropBoxLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayDrawDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataManagementPanelLayout.createSequentialGroup()
                        .addComponent(drawTextBoxLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateInputLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDateLabel)
                        .addGap(4, 4, 4)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dataManagementPanelLayout.createSequentialGroup()
                        .addComponent(displayRangeDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(dataDeleteDrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dataDeletePeriodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(returnMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataManagementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataManagementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Closing current window
    private void returnMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnMainMenuButtonActionPerformed
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_returnMainMenuButtonActionPerformed

    // This code can not be removed, protected...
    private void drawTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawTextFieldActionPerformed

    }//GEN-LAST:event_drawTextFieldActionPerformed

    // If the game is not yet implemented with supporting code popup window will inform the user.
    private void gameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameComboBoxActionPerformed
        try {
            if (gameComboBox.getSelectedIndex() != 1) {
                JOptionPane.showMessageDialog(null, "This option is not availbale yet.\nTry another game!");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_gameComboBoxActionPerformed

    // New window will pop up with the draw details of the game.
    private void displayDrawDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayDrawDataButtonActionPerformed
        // Control of users input
        if (checkComboBox() && getDrawText()) {
            DrawDisplayScreen drawDisplayScreen;
            try {
                // DrawId to Integer
                int drawId = Integer.parseInt(drawNumber);
                // Get Draw From API                
                DrawsFunctions f = new DrawsFunctions();
                draw = f.getDataJokerById(drawId, getGameId((String) gameComboBox.getSelectedItem()));
                // Chech if Draw is empty                
                if (draw == null) {
                    JOptionPane.showMessageDialog(null, "Λάθος αριθμός κλήρωσης, παρακαλώ προσπαθήστε ξανά με σωστό αριθμό!");

                } else {
                    drawDisplayScreen = new DrawDisplayScreen(draw);
                    drawDisplayScreen.setVisible(true);
                }

            } catch (ParseException ex) {
                Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_displayDrawDataButtonActionPerformed

    private void dataDeleteDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDeleteDrawButtonActionPerformed
        // Popup window to ask permision for deletion of data
        deleteData = JOptionPane.showConfirmDialog(this, "Ειστέ σίγουροι ότι θέλετε να γίνει διαγραφή των δεδομένων;", "Επιβεβαιώση", JOptionPane.YES_NO_OPTION, WIDTH);
        if (deleteData == JOptionPane.YES_OPTION) {
            try {
                if (gameComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Παρακαλώ εισάγετε το παιχνίδι που σας ενδιαφέρει.");
                }

                if (getDrawText()) {
                    if (deleteData == JOptionPane.YES_OPTION) {
                        DrawsFunctions callApi = new DrawsFunctions();
                        int drawNum = Integer.valueOf(drawTextField.getText());

                        if (!(callApi.deleteDrawWithIdFromDB(drawNum))) {
                            JOptionPane.showMessageDialog(null, "Η διαγραφή ήταν ανεπιτυχείς!\nΗ κλήρωση δεν υπάρχει στην βάση δεδομένων!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Η διαγραφή ήταν επιτυχείς!");
                        }
                    }
                }
            } catch (Exception e) {
                if (drawNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Λάθος δεδομένα!\nΠαρακαλώ ελέγχτε εάν έχει γίνει επιλογή παιχνιδιού στην συνέχεια, \nεάν έχετε εισάγει αριθμό κλήρωσης!");
                }
            }
        }
    }//GEN-LAST:event_dataDeleteDrawButtonActionPerformed

    private void dataDeletePeriodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDeletePeriodButtonActionPerformed
        deleteData = JOptionPane.showConfirmDialog(this, "Ειστέ σίγουροι ότι θέλετε να γίνει διαγραφή των δεδομένων;", "Επιβεβαιώση", JOptionPane.YES_NO_OPTION, WIDTH);
        DateFunctions dateFunctions = new DateFunctions();
        if (checkComboBox()) {
            if (deleteData == JOptionPane.YES_OPTION && (dateFunctions.checkDates(jDateChooser1.getDate(), jDateChooser2.getDate()))) {
                try {
                    startDate = jDateChooser1.getDate();
                    endDate = jDateChooser2.getDate();

//              Get gameId
                    int gameId = getGameId((String) gameComboBox.getSelectedItem());
//              Get the draws from API
                    DrawsFunctions c = new DrawsFunctions();
                    if (c.findDrawsToDB(apiDateFormat.format(startDate), apiDateFormat.format(endDate))) {
                        //              Clear List 
                        drawsList.clear();
//                  Find and store to arraylist the draws
                        DrawsFunctions f = new DrawsFunctions();
                        f.dataJokerByDates(apiDateFormat.format(startDate), apiDateFormat.format(endDate), gameId);
                        drawsList = f.getDrawsList();
                        for (DrawOpapJoker draw : drawsList) {
                            c.deleteDrawWithIdFromDB(draw.getDrawid());
                        }

                        JOptionPane.showMessageDialog(null, "Η διαγραφή ήταν επιτυχείς!");
                        drawsList.clear();
                    } else {
                        JOptionPane.showMessageDialog(null, "Η διαγραφή ήταν ανεπιτυχείς!\nΗ βάση δεδομένων είναι κενή.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PeriodDrawDisplay.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Λάθος συστήματος!");
                }

            }

        }

    }//GEN-LAST:event_dataDeletePeriodButtonActionPerformed

    // Here will be the code for the date range display
    private void displayRangeDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayRangeDataButtonActionPerformed
        DateFunctions dateFunctions = new DateFunctions();

        if (checkComboBox() && (dateFunctions.checkDates(jDateChooser1.getDate(), jDateChooser2.getDate()))) {
            try {
                PeriodDrawDisplay periodDrawDisplay;
                //              Get gameId
                int gameId = getGameId((String) gameComboBox.getSelectedItem());
                //              Clear drawList
                drawsList.clear();
                //              Find and store to arraylist the draws
                DrawsFunctions f = new DrawsFunctions();
                String startDate = apiDateFormat.format(jDateChooser1.getDate());
                String endDate = apiDateFormat.format(jDateChooser2.getDate());
                f.dataJokerByDates(startDate, endDate, gameId);
                drawsList = f.getDrawsList();
                Collections.sort(drawsList, new Comparator<DrawOpapJoker>() {
                    public int compare(DrawOpapJoker d1, DrawOpapJoker d2) {
                        if (d1.getDrawid() == d2.getDrawid()) {
                            return 0;
                        }
                        return d1.getDrawid() < d2.getDrawid() ? -1 : 1;
                    }
                });
                // Show draws to PeriodDrawDisplay
                periodDrawDisplay = new PeriodDrawDisplay(drawsList, gameId);
                periodDrawDisplay.setVisible(true);

            } catch (ParseException ex) {
                Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_displayRangeDataButtonActionPerformed

    // Users input. Draw number.
    private boolean getDrawText() {
        // Check if the textFiled is empty
        try {
            drawNumber = drawTextField.getText();
            if (drawNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Λάθος δεδομένα! \nΕλέγξτε εάν έχετε εισάγει αριθμό κλήρωσης!");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Λάθος δεδομένα! \nΕλέγξτε εάν έχετε εισάγει αριθμό κλήρωσης!");
            return false;
        }
    }

    // USers input. Game type. If gameType is empty will return error to user.
    private boolean checkComboBox() {
        if (gameComboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Παρακαλώ εισάγετε παιχνίδι(Joker, Kino, κλπ)!");
            return false;
        }
        return true;
    }

    // Variables declaration that can be modified.
    private String drawNumber = null; // The draw number of the game we are looking.
    private Date startDate; // Starting date for search in database.
    private Date endDate; // Ending date for search in database.
    private int deleteData;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dataDeleteDrawButton;
    private javax.swing.JButton dataDeletePeriodButton;
    private javax.swing.JPanel dataManagementPanel;
    private javax.swing.JLabel dateInputLabel;
    private javax.swing.JButton displayDrawDataButton;
    private javax.swing.JButton displayRangeDataButton;
    private javax.swing.JLabel drawTextBoxLabel;
    private javax.swing.JTextField drawTextField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JComboBox<String> gameComboBox;
    private javax.swing.JLabel gameDropBoxLabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JButton returnMainMenuButton;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel titlePanel;
    // End of variables declaration//GEN-END:variables
}
