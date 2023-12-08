package teamergasia3.R5;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modal.DrawOpapJoker;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import teamergasia3.Number;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class ChartsScreen extends javax.swing.JFrame {

    private DateFormat apiDateFormat = new SimpleDateFormat("YYYY-MM-dd");
    ArrayList<Double> winningsList = new ArrayList<>();
    ArrayList<Number> fiveMaxOccurrencesNumbers = new ArrayList<>();
    ArrayList<Number> fiveMaxOccurrencesBonusNumbers = new ArrayList<>();
    private String[] idsArray = new String[]{"5+1", "5", "4+1", "4", "3+1", "3", "2+1", "1+1"};

    String startDate;
    String endDate;

    public ChartsScreen(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        getDateFromDataBaseForR5(startDate, endDate);
        initComponents();

    }

    public ChartsScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        mostFrequentNumbersButton = new javax.swing.JButton();
        mostFrequentJokerButton = new javax.swing.JButton();
        winningsButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JOSKA Chart Screen Selection");

        jPanel1.setBackground(new java.awt.Color(15, 61, 91));

        mostFrequentNumbersButton.setText("Συχνότερα εμφανιζόμενοι αριθμοί.");
        mostFrequentNumbersButton.setToolTipText("Προβολή διαγράμματος των πέντε συχνότερα εμφανιζόμενων αριθμών.");
        mostFrequentNumbersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostFrequentNumbersButtonActionPerformed(evt);
            }
        });

        mostFrequentJokerButton.setText("Συχνότερα εμφανιζόμενοι αριθμοί JOKER.");
        mostFrequentJokerButton.setToolTipText("Προβολή διαγράμματος των πέντε συχνότερα εμφανιζόμενων αριθμών.");
        mostFrequentJokerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostFrequentJokerButtonActionPerformed(evt);
            }
        });

        winningsButton.setText("Μέσος όρος κερδών ανά κατηγορία.");
        winningsButton.setToolTipText("Προβολή διαγράμματος μέσου όρου κερδών ανά κατηγορία.");
        winningsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winningsButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Επιστροφή");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mostFrequentNumbersButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(winningsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mostFrequentJokerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostFrequentNumbersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostFrequentJokerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(winningsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Creation of chart screen to display the winnings for each category
    private void winningsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winningsButtonActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int i = 0;
        
        for (Double d : winningsList) {
            dataset.setValue(d, "Κέρδη", idsArray[i]);
            i++;
        }
        if (!winningsList.isEmpty()){
            JFreeChart chart3 = ChartFactory.createBarChart("Kληρώσεις από " + startDate + " εώς " + endDate, "", "Ευρώ", dataset);
            CategoryPlot plot1 = chart3.getCategoryPlot();
            plot1.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame1 = new ChartFrame("Joker Game-Stats Μέσος όρος κερδών ανα κατηγορία!", chart3);
            frame1.setVisible(true);
            frame1.setSize(600, 600);
        } else{
            JOptionPane.showMessageDialog(null, "Η βάση δεδομένων είναι κενή παρακαλώ χρησιμοποιήστε πρώτα το tab διαχείριση δεδομένων!");
        }

    }//GEN-LAST:event_winningsButtonActionPerformed

    //Creation of chart screen of 5 most common numbers of JOKER draw 
    private void mostFrequentJokerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostFrequentJokerButtonActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Number bonusNumber : fiveMaxOccurrencesBonusNumbers) {
            dataset.setValue(bonusNumber.getOccurrences(), "Αριθμός JOKER", String.valueOf(bonusNumber.getNumber()));
        }
        
        if (!fiveMaxOccurrencesBonusNumbers.isEmpty() ){
        
            JFreeChart chart2 = ChartFactory.createBarChart("Kληρώσεις από " + startDate + " εώς " + endDate, "", "Εμφανίσεις", dataset);
            CategoryPlot plot1 = chart2.getCategoryPlot();
            plot1.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame1 = new ChartFrame("Joker Game-Stats Οι 5 πιο συχνά εμφανιζόμενοι αριθμοί JOKER!", chart2);
            frame1.setVisible(true);
            frame1.setSize(600, 600);
        } else{
            JOptionPane.showMessageDialog(null, "Η βάση δεδομένων είναι κενή παρακαλώ χρησιμοποιήστε πρώτα το tab διαχείριση δεδομένων!");
        }

    }//GEN-LAST:event_mostFrequentJokerButtonActionPerformed

    //Creation of chart screen of 5 most common numbers draw
    private void mostFrequentNumbersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostFrequentNumbersButtonActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Number number : fiveMaxOccurrencesNumbers) {
            dataset.setValue(number.getOccurrences(), "Αριθμός ", String.valueOf(number.getNumber()));
        }
        
        if (!fiveMaxOccurrencesNumbers.isEmpty()) {  
            JFreeChart chart2 = ChartFactory.createBarChart("Kληρώσεις από " + startDate + " εώς " + endDate, "", "Εμφανίσεις", dataset);
            CategoryPlot plot1 = chart2.getCategoryPlot();
            plot1.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame1 = new ChartFrame("Joker Game - Stats Οι 5 πιο συχνά εμφανιζόμενοι αριθμοί!", chart2);
            frame1.setVisible(true);
            frame1.setSize(600, 600);
        } else{
            JOptionPane.showMessageDialog(null, "Η βάση δεδομένων είναι κενή παρακαλώ χρησιμοποιήστε πρώτα το tab διαχείριση δεδομένων!");
        }

    }//GEN-LAST:event_mostFrequentNumbersButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);

    }//GEN-LAST:event_returnButtonActionPerformed

    public boolean getDateFromDataBaseForR5(String from, String until) {
        //      Create Number ArrayList
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Number> bonusNumbers = new ArrayList<>();
        //      Fill Number and bonusNumber ArrayList
        for (int i = 1; i <= 45; i++) {
            numbers.add(new Number(i));
            if (i <= 20) {
                bonusNumbers.add(new Number(i));
            }
        }
        //        Connect DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//      Check if the dates are empty to get all the data from the DB
        Query q;
        if (from.equals("")) {
            q = em.createNamedQuery("DrawOpapJoker.findAllGameIdASC", DrawOpapJoker.class);
        } else {
//          Convert Dates from string to Date
            Date startDate = java.sql.Date.valueOf(from);
            Date endDate = java.sql.Date.valueOf(until);
//          Get Data with startDate beetwen endDate
            q = em.createNamedQuery("DrawOpapJoker.findByDrawtimeWithRange", DrawOpapJoker.class);
            q.setParameter("start", startDate);
            q.setParameter("end", endDate);
        }

        List<DrawOpapJoker> result;
        try {

            result = (List<DrawOpapJoker>) q.getResultList();
            //      Save drawlist size for count the delays
            int drawsCount = result.size();
//          Check if we have no results
            if (drawsCount == 0) {
                return false;
            }
            double[] averageDistributed = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

            for (DrawOpapJoker drawOpapJoker : result) {
                //          Add Occurrences Bonus Number
                bonusNumbers.get(drawOpapJoker.getBonusnumber() - 1).increaseOccurrencesNumber();
                //          Get String Winning Numbers
                String winningNumbers = drawOpapJoker.getWinningnumbers();

//              Split winning number to single string 
                String[] winningNumbersArray = winningNumbers.split(",");
                for (String stringNumber : winningNumbersArray) {
//              Convert String to Number
                    int number = Integer.valueOf(stringNumber);
//              Add Occurrences Number
                    numbers.get(number - 1).increaseOccurrencesNumber();
                }

//              Profit
                String distributed = drawOpapJoker.getDistributed();
                String[] distributedArray = distributed.split(",");
                String countwinners = drawOpapJoker.getCountwinners();
                String[] countwinnersArray = countwinners.split(",");

//              Sum distributed for every category
                for (int i = 0; i < distributedArray.length; i++) {
                    if (countwinnersArray[i].equals("0")) {
                    } else {
                        double num = Double.valueOf(distributedArray[i]);
                        averageDistributed[i] += num;
                    }
                }
            }
//          Divide distributed for the average 
            for (int i = 0; i < averageDistributed.length; i++) {
                averageDistributed[i] = averageDistributed[i] / drawsCount;
                winningsList.add(averageDistributed[i]);
            }

//          Sort Bonus Numbers 
            Collections.sort(bonusNumbers, new Comparator<Number>() {
                public int compare(Number d1, Number d2) {
                    if (d1.getOccurrences() == d2.getOccurrences()) {
                        return 0;
                    }
                    return d1.getOccurrences() > d2.getOccurrences() ? -1 : 1;
                }
            });

//      Sort Numbers 
            Collections.sort(numbers, new Comparator<Number>() {
                public int compare(Number d1, Number d2) {
                    if (d1.getOccurrences() == d2.getOccurrences()) {
                        return 0;
                    }
                    return d1.getOccurrences() > d2.getOccurrences() ? -1 : 1;
                }
            });

            for (int i = 0; i < 5; i++) {
//              Check if the number Occurrences is greater from 0
                if (numbers.get(i).getOccurrences() > 0) {
                    fiveMaxOccurrencesNumbers.add(numbers.get(i));
                }
//              Check if the bonus number Occurrences is greater from 0
                if (bonusNumbers.get(i).getOccurrences() > 0) {
                    fiveMaxOccurrencesBonusNumbers.add(bonusNumbers.get(i));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        em.getTransaction().commit();
//      Close DB
        em.close();
        emf.close();
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mostFrequentJokerButton;
    private javax.swing.JButton mostFrequentNumbersButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton winningsButton;
    // End of variables declaration//GEN-END:variables
}
