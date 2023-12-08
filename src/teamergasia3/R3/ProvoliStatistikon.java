package teamergasia3.R3;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modal.DrawOpapJoker;

public class ProvoliStatistikon extends javax.swing.JFrame {

    private String monthString;
    private String jackpotString;
    private String sumDistributed;
    private String drawsCount;

    public ProvoliStatistikon() {
        initComponents();
        monthChooser.setVisible(false); //Month button clickable ather user choose the year
    }

    private boolean getStatsByMonth(String datein) {
        String date;
        //Add month and year
        String month = datein.substring(datein.length() - 2);
        String year = datein.substring(0, 4);

        //Add the first day of the month
        date = datein + "-01";

        //Calculate the last day of the month
        LocalDate lastDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        lastDate = lastDate.withDayOfMonth(lastDate.getMonth().length(lastDate.isLeapYear()));

        //Show the month and year to the display
        switch (month) {
            case "01":
                month = "Ιανουάριο " + "του " + year;
                break;
            case "02":
                month = "Φεβρουάριο " + "του " + year;
                break;
            case "03":
                month = "Μάρτιο " + "του " + year;
                break;
            case "04":
                month = "Απρίλιο " + "του " + year;
                break;
            case "05":
                month = "Μάιο " + "του " + year;
                break;
            case "06":
                month = "Ιούνιο " + "του " + year;
                break;
            case "07":
                month = "Ιούλιο " + "του " + year;
                break;
            case "08":
                month = "Αύγουστο " + "του " + year;
                break;
            case "09":
                month = "Σεπτέμβριο " + "του " + year;
                break;
            case "10":
                month = "Οκτώβριο " + "του " + year;
                break;
            case "11":
                month = "Νοέμβριο " + "του " + year;
                break;
            case "12":
                month = "Δεκέμβριο " + "του " + year;
                break;
        }

        java.sql.Date d1 = java.sql.Date.valueOf(date);
        java.sql.Date d2 = java.sql.Date.valueOf(lastDate);

        // Connect DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Create query
        Query q = em.createNamedQuery("DrawOpapJoker.findByDrawtimeWithRange", DrawOpapJoker.class);
        // Set start date and the end date
        q.setParameter("start", d1);
        q.setParameter("end", d2);

        try {
            // Declare List with DrawOpapJoker object
            List<DrawOpapJoker> result;
            // Get all the draws
            result = (List<DrawOpapJoker>) q.getResultList();

            //Size of all the draws
            if (result.size() == 0) {
                return false;
            }

            int jackpot = 0;
            Double sum = Double.valueOf(0);
            for (DrawOpapJoker draw : result) {
                String distributed = draw.getDistributed();
                String[] distributedArray = distributed.split(",");
                String countwinners = draw.getCountwinners();
                String[] countwinnersArray = countwinners.split(",");

                for (int i = 0; i < distributedArray.length; i++) {
                    if (countwinnersArray[i].equals("0")) {
                        jackpot++;
                    } else {
                        double num = Double.valueOf(distributedArray[i]);
                        sum += num;
                    }

                }
                drawsCount = String.valueOf(result.size()); //Show the count of all the draws to the display
                DecimalFormat df = new DecimalFormat("#,##0.00"); //2 decimal numbers
                sumDistributed = String.valueOf(df.format(sum)); //Show the distributed to the display
                jackpotString = String.valueOf(jackpot); //Show the jackpots to the display 
                monthString = month;
            }
        } catch (NumberFormatException e) {
//          No results
            System.err.println("No result!  " + e);
        }
        //Check if the draw exists to DB
        em.getTransaction().commit();
        //Close DB
        em.close();
        emf.close();
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        monthChooser = new com.toedter.calendar.JMonthChooser();
        userInputTextField = new javax.swing.JTextField();
        chooseYearButton = new javax.swing.JButton();
        chooseMonthButton = new javax.swing.JButton();
        displayDataButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Προβολή δεδομένων ΤΖΟΚΕΡ ανά μήνα για συγκεκριμένο έτος");
        setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(0, 135, 221));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Έτος");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Μήνας");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Επιλογή Χρήστη");

        monthChooser.setForeground(new java.awt.Color(145, 11, 16));

        userInputTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        userInputTextField.setForeground(new java.awt.Color(145, 11, 16));
        userInputTextField.setText(" ");

        chooseYearButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        chooseYearButton.setForeground(new java.awt.Color(145, 11, 16));
        chooseYearButton.setText("Επιλογή έτους");
        chooseYearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseYearButtonActionPerformed(evt);
            }
        });

        chooseMonthButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        chooseMonthButton.setForeground(new java.awt.Color(145, 11, 16));
        chooseMonthButton.setText("Επιλογή μήνα");
        chooseMonthButton.setEnabled(false);
        chooseMonthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMonthButtonActionPerformed(evt);
            }
        });

        displayDataButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        displayDataButton.setForeground(new java.awt.Color(145, 11, 16));
        displayDataButton.setText("Προβολή δεδομένων");
        displayDataButton.setEnabled(false);
        displayDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayDataButtonActionPerformed(evt);
            }
        });

        returnButton.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        returnButton.setForeground(new java.awt.Color(145, 11, 16));
        returnButton.setText("Επιστροφή");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Προβολή δεδομένων ΤΖΟΚΕΡ ανά μήνα για συγκεκριμένο έτος");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(returnButton)
                .addGap(73, 73, 73))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(displayDataButton))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chooseYearButton))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(205, 205, 205)
                                    .addComponent(chooseMonthButton)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(chooseYearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseMonthButton))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayDataButton)
                    .addComponent(jLabel4)
                    .addComponent(userInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(returnButton)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseYearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseYearButtonActionPerformed
        chooseMonthButton.setEnabled(true);
        monthChooser.setVisible(true);
        userInputTextField.setText(String.valueOf(yearChooser.getYear()));  //Choose Year

    }//GEN-LAST:event_chooseYearButtonActionPerformed

    private void chooseMonthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMonthButtonActionPerformed
        displayDataButton.setEnabled(true);
        DecimalFormat formatter = new DecimalFormat("00");
        String month = formatter.format(monthChooser.getMonth() + 1);  //Choose month
        userInputTextField.setText(String.valueOf(yearChooser.getYear()) + "-" + month);
    }//GEN-LAST:event_chooseMonthButtonActionPerformed

    private void displayDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayDataButtonActionPerformed
//      Check if the date from the form is bigger from the current day 
        String date = userInputTextField.getText() + "-01";
        Date dateSearch = java.sql.Date.valueOf(date);
//      Get current day  
        Date timestamp = new Date();
        if (dateSearch.getTime() > timestamp.getTime()) {
            JOptionPane.showMessageDialog(null, "Λάθος ημερομηνία!\nΗ τελική ημερομηνία δεν μπορεί να είναι αργότερα από την σημερινή.\nΠροσπαθήστε με σωστές ημερομηνίες!");
        } else {
            try {
//          Check if we have results
                if (getStatsByMonth(userInputTextField.getText())) {
//          Open new Window with results
                    ProvoliStatistikon2 p; //Open new window to show the details
                    p = new ProvoliStatistikon2(jackpotString, sumDistributed, drawsCount, monthString); //Show year and month to the new window
                    p.setVisible(true);
                } else {
//              No results
                    JOptionPane.showMessageDialog(null, "Δεν υπάρχουν δεδομένα για αυτό τον μήνα!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ProvoliStatistikon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_displayDataButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_returnButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseMonthButton;
    private javax.swing.JButton chooseYearButton;
    private javax.swing.JButton displayDataButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JMonthChooser monthChooser;
    private javax.swing.JButton returnButton;
    public static javax.swing.JTextField userInputTextField;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables
}
