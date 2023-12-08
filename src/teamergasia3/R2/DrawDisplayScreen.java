/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package teamergasia3.R2;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modal.DrawOpapJoker;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import teamergasia3.DrawsFunctions;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class DrawDisplayScreen extends javax.swing.JFrame {

    //      Joker Id
    private String joker = "5104";
    //      Create names fo id property to the table
    private String[] idsArray = new String[]{"5+1", "5", "4+1", "4", "3+1", "3", "2+1", "1+1"};
    //      Add functions    
    private DrawsFunctions callApi = new DrawsFunctions();
    //      Create Draw Object
    private DrawOpapJoker draw;

    public DrawDisplayScreen(DrawOpapJoker draw) throws ParseException, IOException {
//      Set the draw  
        this.draw = draw;
        initComponents();
//      Fill the draw table
        showDrawDetailsById();
    }
//  Fill the draw table

    private void showDrawDetailsById() throws ParseException, IOException {
        // Εμφάνιση νικητήριας στήλης και Τζόκερ 
        String winnString = draw.getWinningnumbers(); // Νικητήρια στήλη
        int joker = draw.getBonusnumber();
        this.winningNumbers.setText("Νικητήρια Στήλη: " + winnString + " Joker: " + joker);
        // Εμφάνιση αριθμού και ημερομηνίας κλήρωσης
        this.drawLabel.setText("Αριθμός Κλήρωσης " + draw.getDrawid() + " Ημερομηνία: " + draw.getDrawtime());

        String countWinners = draw.getCountwinners();
        String divident = draw.getDivident();
        String distributed = draw.getDistributed();

//      Convert to array the strings
        String[] dividentArray = divident.split(",");
        String[] countWinnersArray = countWinners.split(",");
        String[] distributedArray = distributed.split(",");

//      Import Data to table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < idsArray.length; i++) {
            model.addRow(new Object[]{idsArray[i], distributedArray[i], countWinnersArray[i], dividentArray[i]});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        menuBar4 = new java.awt.MenuBar();
        menu7 = new java.awt.Menu();
        menu8 = new java.awt.Menu();
        apotelesmataAnajitisisiLabel = new javax.swing.JPanel();
        epistrofiMMButton = new javax.swing.JButton();
        apotelesmataAnazitisisLabel = new javax.swing.JLabel();
        saveData = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        drawLabel = new javax.swing.JLabel();
        winningNumbers = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        menu7.setLabel("File");
        menuBar4.add(menu7);

        menu8.setLabel("Edit");
        menuBar4.add(menu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STOPA ΕΜΦΑΝΙΣΗ ΔΕΔΟΜΕΝΩΝ");

        apotelesmataAnajitisisiLabel.setBackground(new java.awt.Color(51, 0, 102));

        epistrofiMMButton.setText("ΕΠΙΣΤΡΟΦΗ");
        epistrofiMMButton.setToolTipText("Επιστροφή στο βασικό μενού.");
        epistrofiMMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epistrofiMMButtonActionPerformed(evt);
            }
        });

        apotelesmataAnazitisisLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        apotelesmataAnazitisisLabel.setForeground(new java.awt.Color(255, 255, 255));
        apotelesmataAnazitisisLabel.setText("Αποτελέσματα αναζήτησης");

        saveData.setText("ΑΠΟΘΗΚΕΥΣΗ");
        saveData.setToolTipText("Αποθήκευση στην βάση δεδομένων.");
        saveData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveDataMouseClicked(evt);
            }
        });
        saveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Κατηγορία Επιτυχιών", "Διανεμόμενa Κέρδη", "Επιτυχίες", "Κέρδη ανα Επιτυχία"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable1);

        drawLabel.setForeground(new java.awt.Color(255, 255, 255));
        drawLabel.setText("Αριθμός Κλήρωσης");

        winningNumbers.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        winningNumbers.setForeground(new java.awt.Color(255, 255, 255));
        winningNumbers.setText("Νικητήρια Στήλη: ");

        javax.swing.GroupLayout apotelesmataAnajitisisiLabelLayout = new javax.swing.GroupLayout(apotelesmataAnajitisisiLabel);
        apotelesmataAnajitisisiLabel.setLayout(apotelesmataAnajitisisiLabelLayout);
        apotelesmataAnajitisisiLabelLayout.setHorizontalGroup(
            apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                .addGroup(apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epistrofiMMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                        .addGroup(apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addGroup(apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apotelesmataAnazitisisLabel)
                                    .addComponent(drawLabel)))
                            .addGroup(apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(winningNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(46, 46, 46)))
                .addContainerGap())
        );
        apotelesmataAnajitisisiLabelLayout.setVerticalGroup(
            apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apotelesmataAnajitisisiLabelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(apotelesmataAnazitisisLabel)
                .addGap(18, 18, 18)
                .addComponent(drawLabel)
                .addGap(46, 46, 46)
                .addComponent(winningNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(apotelesmataAnajitisisiLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(epistrofiMMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(apotelesmataAnajitisisiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(apotelesmataAnajitisisiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void closeWindow() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    private void epistrofiMMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epistrofiMMButtonActionPerformed
        closeWindow();
    }//GEN-LAST:event_epistrofiMMButtonActionPerformed

    private void saveDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveDataMouseClicked
        // This button will send a message to the DB to check if the data are available.
        // If not it will save the data in the DB

    }//GEN-LAST:event_saveDataMouseClicked

    private void saveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataActionPerformed
//      Save Draw to DB
        if (callApi.saveDrawToDB(draw)) {
            JOptionPane.showMessageDialog(null, "Η αποθήκευση των δεδομένων ήταν επιτυχείς");
        } else {
            JOptionPane.showMessageDialog(null, "Η αποθήκευση των δεδομένων δεν ήταν επιτυχείς");
        }

    }//GEN-LAST:event_saveDataActionPerformed

    public void setDrawNumber(String drawData) {
        drawLabel.setText(drawData);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel apotelesmataAnajitisisiLabel;
    private javax.swing.JLabel apotelesmataAnazitisisLabel;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JButton epistrofiMMButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.Menu menu7;
    private java.awt.Menu menu8;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private java.awt.MenuBar menuBar4;
    private javax.swing.JButton saveData;
    private javax.swing.JLabel winningNumbers;
    // End of variables declaration//GEN-END:variables
}
