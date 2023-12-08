package teamergasia3.R2;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import modal.DrawOpapJoker;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.json.simple.parser.ParseException;
import teamergasia3.DrawsFunctions;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class PeriodDrawDisplay extends javax.swing.JFrame {
//  Set Date Format

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//  Create Arraylist for the draws  
    private ArrayList<DrawOpapJoker> drawsArrayList = new ArrayList<>();
    //      Create Draw Object
    private DrawOpapJoker draw;

    public PeriodDrawDisplay(ArrayList<DrawOpapJoker> draws, int gameId) {
        initComponents();
//      Add draws to arraylist
        drawsArrayList = draws;
//      Add draw details to Table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < draws.size(); i++) {
            model.addRow(new Object[]{getGameName(gameId), draws.get(i).getDrawid(), dateFormat.format(draws.get(i).getDrawtime())});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        displayDrawButton = new javax.swing.JButton();
        saveRangeButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Joker Game Stats ΕΜΦΑΝΙΣΗ ΚΛΗΡΩΣΕΩΝ");
        setBackground(new java.awt.Color(51, 0, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Παιχνίδι", "Αριθμός Κλήρωσης", "Ημερομηνία Κλήρωσης"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        displayDrawButton.setText("ΕΜΦΑΝΙΣΗ ΚΛΗΡΩΣΗΣ");
        displayDrawButton.setMaximumSize(new java.awt.Dimension(140, 60));
        displayDrawButton.setMinimumSize(new java.awt.Dimension(140, 60));
        displayDrawButton.setPreferredSize(new java.awt.Dimension(140, 60));
        displayDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayDrawButtonActionPerformed(evt);
            }
        });

        saveRangeButton.setText("ΑΠΟΘΗΚΕΥΣΗ ΚΛΗΡΩΣΕΩΝ");
        saveRangeButton.setMaximumSize(new java.awt.Dimension(140, 60));
        saveRangeButton.setMinimumSize(new java.awt.Dimension(140, 60));
        saveRangeButton.setPreferredSize(new java.awt.Dimension(140, 60));
        saveRangeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveRangeButtonMouseClicked(evt);
            }
        });
        saveRangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRangeButtonActionPerformed(evt);
            }
        });

        returnButton.setText("ΕΠΙΣΤΡΟΦΗ");
        returnButton.setMaximumSize(new java.awt.Dimension(140, 60));
        returnButton.setMinimumSize(new java.awt.Dimension(140, 60));
        returnButton.setPreferredSize(new java.awt.Dimension(140, 60));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayDrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveRangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayDrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveRangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getGameName(int gameID) {
//        Switch to find gameId
        switch (gameID) {
            case 5104:
                return "JOKER";
            case 1100:
                return "KINO";
            case 1110:
                return "Powerspin";
            case 2100:
                return "SUPER3";
            case 2101:
                return "PROTO";
            case 5103:
                return "LOTTO";
            case 5106:
                return "EXTRA5";
            default:
//          Return -1 if is not one of this
                return "Fault in database";
        }
    }

    private void saveRangeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveRangeButtonMouseClicked
        int count = 0;
//        Connect DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();

        DrawsFunctions callApi = new DrawsFunctions();
        for (DrawOpapJoker draw : drawsArrayList) {
            if (!callApi.findDrawToDB(draw.getDrawid(), em)) {
                callApi.saveDrawToDB(draw);
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Η κλήρωση  " + draw.getDrawid() + " υπάρχει στην βάση δεδομένων");
            }
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Η Αποθήκευση ολοκληρώθηκε με επιτυχία! ");
        }
    }//GEN-LAST:event_saveRangeButtonMouseClicked

    private void displayDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayDrawButtonActionPerformed
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
//      If we have more games we need to change the code here
        int gameID = 5104; // If we have more games we need to change the code here

        String drawID = model.getValueAt(index, 1).toString();
//      Στο μύνημα εκτυπώνει μόνο το παιχνίδι JOKER.
        int displayDraw = JOptionPane.showConfirmDialog(this, "Θέλετε να εμφανίσετε λεπτομέρειες για την κλήρωση " + drawID + " του παιχνιδιού JOKER",
                "Επιβεβαίωση", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (displayDraw == JOptionPane.YES_OPTION) {
            DrawDisplayScreen displayScreen;
            try {
                // DrawId to Integer
                int drawId = Integer.parseInt(drawID);
                // Get Draw From API                  
                DrawsFunctions f = new DrawsFunctions();
                draw = f.getDataJokerById(drawId, gameID);
                // Chech if Draw is empty                
                if (draw == null) {
                    System.out.println("NULL");
                } else {
                    System.out.println("NOT NULL");
                }
                displayScreen = new DrawDisplayScreen(draw);
                displayScreen.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(PeriodDrawDisplay.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PeriodDrawDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_displayDrawButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void saveRangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRangeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveRangeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displayDrawButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton saveRangeButton;
    // End of variables declaration//GEN-END:variables
}
