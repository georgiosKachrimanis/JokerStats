package teamergasia3.R1;

import teamergasia3.R5.ChartsScreenForm;
import teamergasia3.R4.StatisticsScreen;
import teamergasia3.R3.ProvoliStatistikon;
import teamergasia3.R2.DataManagement;
import java.sql.DriverManager;
import java.sql.SQLException;
import modal.DrawOpapJoker;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class Mainscreen extends javax.swing.JFrame {

    private String connectionString = "jdbc:derby://localhost:1527/OpapDB;create=true;user=root;password=root;";

    public Mainscreen() {
//      Connect to Database and create table
        createTablAndColumns(connectionString);
        initComponents();
    }

    private static void createTablAndColumns(String connectionString) {
        try {
//          Create Connection
            Connection connection = connect(connectionString);
//          Create table
            String createTableSQL = "CREATE TABLE DRAW_OPAP_JOKER" + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "gameId INTEGER NOT NULL,"
                    + "drawID INTEGER NOT NULL UNIQUE,"
                    + "drawTime Date NOT NULL,"
                    + "winningNumbers VARCHAR(50) NOT NULL,"
                    + "bonusNumber INTEGER NOT NULL,"
                    + "countWinners VARCHAR(255) NOT NULL,"
                    + "divident VARCHAR(255) NOT NULL,"
                    + "distributed VARCHAR(255) NOT NULL,"
                    + "jackpot VARCHAR(255) NOT NULL,"
                    + "PRIMARY KEY(id))";

            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DrawOpapJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Connection connect(String connectionString) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DrawOpapJoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        mainScreen = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        dataManagementButton = new javax.swing.JButton();
        dataDisplayButton = new javax.swing.JButton();
        statisticDisplayButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        chartButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Joker Game-Stats");
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        mainScreen.setBackground(new java.awt.Color(0, 51, 102));
        mainScreen.setToolTipText("");

        welcomeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("Welcome to OPAP Statistics App.  ");

        dataManagementButton.setBackground(new java.awt.Color(255, 255, 255));
        dataManagementButton.setText("ΔΙΑΧΕΙΡΙΣΗ ΔΕΔΟΜΕΝΩΝ");
        dataManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataManagementButtonActionPerformed(evt);
            }
        });

        dataDisplayButton.setText("ΠΡΟΒΟΛΗ ΔΕΔΟΜΕΝΩΝ ΑΝΑ ΜΗΝΑ");
        dataDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDisplayButtonActionPerformed(evt);
            }
        });

        statisticDisplayButton.setText("ΠΡΟΒΟΛΗ/ΕΚΤΥΠΩΣΗ ΣΤΑΤΙΣΤΙΚΩΝ");
        statisticDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticDisplayButtonActionPerformed(evt);
            }
        });

        exitButton.setText("ΕΞΟΔΟΣ");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        chartButton.setText("ΠΡΟΒΟΛΗ ΓΡΑΦΗΜΑΤΟΣ");
        chartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainScreenLayout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(124, 124, 124))
                    .addGroup(mainScreenLayout.createSequentialGroup()
                        .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dataManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statisticDisplayButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataDisplayButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chartButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainScreenLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataManagementButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataDisplayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statisticDisplayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chartButton)
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainScreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Monthly stats Screen R3 init
    private void dataDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDisplayButtonActionPerformed
        ProvoliStatistikon r3Screen = new ProvoliStatistikon();
        r3Screen.setVisible(true);
    }//GEN-LAST:event_dataDisplayButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
//      Delete Database when the program ends
        try (Connection connection
                = DriverManager.getConnection(connectionString, "root", "root")) {
            // Query command
            String sql = "DROP TABLE DRAW_OPAP_JOKER";
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute the statement to delete the table
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exitButtonActionPerformed
       
    // When exit is clcked the program will terminate
    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    // Data managment screen R2 init
    private void dataManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataManagementButtonActionPerformed
        DataManagement r2Screen = new DataManagement();
        r2Screen.setVisible(true);
    }//GEN-LAST:event_dataManagementButtonActionPerformed
    // Stats  screen  R4 init
    private void statisticDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticDisplayButtonActionPerformed
        StatisticsScreen r4Screen = new StatisticsScreen();
        r4Screen.setVisible(true);
    }//GEN-LAST:event_statisticDisplayButtonActionPerformed
    // Charts screen R5 init
    private void chartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButtonActionPerformed
        ChartsScreenForm r5Screen = new ChartsScreenForm();
        r5Screen.setVisible(true);
    }//GEN-LAST:event_chartButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainscreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainscreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chartButton;
    private javax.swing.JButton dataDisplayButton;
    private javax.swing.JButton dataManagementButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel mainScreen;
    private javax.swing.JButton statisticDisplayButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
