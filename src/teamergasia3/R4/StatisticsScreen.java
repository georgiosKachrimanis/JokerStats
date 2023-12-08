package teamergasia3.R4;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import modal.DrawOpapJoker;
import org.json.simple.parser.ParseException;
import teamergasia3.DateFunctions;
import teamergasia3.DrawsFunctions;
import teamergasia3.Number;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class StatisticsScreen extends javax.swing.JFrame {
//  Create Arraylist for the draws

    private ArrayList<DrawOpapJoker> drawsList = new ArrayList<>();
//  Api Date Format
    private DateFormat apiDateFormat = new SimpleDateFormat("YYYY-MM-dd");
//  Pdf Date Format    
    private DateFormat pdfDateFormat = new SimpleDateFormat("dd/MM/YYYY");
    private String startDate = ""; // Starting date for search in database.
    private String endDate = ""; // Ending date for search in database.
//  Create arrays for the numbers and bonus numbers with the stats occuresenses and delays
    String[] numbers1 = new String[45];
    String[] numbers2 = new String[45];
    String[] numbers3 = new String[21];
    String[] numbers4 = new String[21];

    public StatisticsScreen() {
        initComponents();
    }

    public void statsNumbers(String from, String until, int gameId) throws ParseException {
//      Get Data from Api with Date Range
        DrawsFunctions f = new DrawsFunctions();
        f.dataJokerByDates(from, until, gameId);
        drawsList = f.getDrawsList();
//      Save drawlist size for count the delays
        int drawsCount = drawsList.size() - 1;
//      Sort drawList in accending mode
        Collections.sort(drawsList, new Comparator<DrawOpapJoker>() {
            @Override
            public int compare(DrawOpapJoker d1, DrawOpapJoker d2) {
                if (d1.getDrawid() == d2.getDrawid()) {
                    return 0;
                }
                return d1.getDrawid() < d2.getDrawid() ? -1 : 1;
            }
        });
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

//      Add Occurrences and Delays to the Numbers and Bonus Numbers
        for (DrawOpapJoker drawOpapJoker : drawsList) {

//          Add Occurrences Bonus Number
            bonusNumbers.get(drawOpapJoker.getBonusnumber() - 1).increaseOccurrencesNumber();
//          Add Delay to Bonus Number
            bonusNumbers.get(drawOpapJoker.getBonusnumber() - 1).decreaseDelaysNumber(drawsCount);

//          Get String Winning Numbers
            String winningNumbers = drawOpapJoker.getWinningnumbers();

//          Split winning number to single string 
            String[] winningNumbersArray = winningNumbers.split(",");
            for (String stringNumber : winningNumbersArray) {
//              Convert String to Number
                int number = Integer.valueOf(stringNumber);
//              Add Occurrences Number
                numbers.get(number - 1).increaseOccurrencesNumber();
//              Add Delay to Number
                numbers.get(number - 1).decreaseDelaysNumber(drawsCount);
            }
//          Decrease drawlist size count
            drawsCount--;
        }

        //Add occuresences and delays to the Numbers arrays
        for (int i = 0; i < numbers.size(); i++) {
            numbers1[i] = String.valueOf(numbers.get(i).getOccurrences());
            if (numbers.get(i).getDelays() == -1) {
                numbers2[i] = "-";
            } else {
                numbers2[i] = String.valueOf(numbers.get(i).getDelays());
            }
        }

        //Add occuresences and delays to the Bonus Numbers arrays
        for (int i = 0; i < bonusNumbers.size(); i++) {
            numbers3[i] = String.valueOf(bonusNumbers.get(i).getOccurrences());
            if (bonusNumbers.get(i).getDelays() == -1) {
                numbers4[i] = "-";
            } else {
                numbers4[i] = String.valueOf(bonusNumbers.get(i).getDelays());
            }
        }
        //Import Data to table 
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45"});
        model.addRow(numbers1);
        model.addRow(numbers2);

        DefaultTableModel model1 = new DefaultTableModel();
        model1.setColumnIdentifiers(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"});
        model1.addRow(numbers3);
        model1.addRow(numbers4);

        //Print the values at the table
        jTable1.setModel(model);
        jTable2.setModel(model1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        dateInputLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Προβολή στατιστικών δεδομένων");

        jPanel1.setBackground(new java.awt.Color(0, 135, 221));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Προβολή στατιστικών στοιχείων παιγνιδιού JOKER και εκτύπωση σε PDF");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Στατιστικά αριθμών ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Στατιστικά Joker");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Εμφανίσεις");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Εμφανίσεις");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Καθυστερήσεις");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Καθυστερήσεις");

        jButton2.setText("Εκτύπωση PDF");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Επιστροφή");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dateInputLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateInputLabel.setText("Εύρεση σε χρονικό δίαστημα:");
        dateInputLabel.setToolTipText("Επιλογη ημερομηνίας έναρξης λήψης/διαγραφής δεδομένων");

        startDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        startDateLabel.setText("ΑΠΟ");

        endDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        endDateLabel.setText("ΕΩΣ");

        jButton4.setText("Προβολή");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton2)
                        .addGap(474, 474, 474)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(endDateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(startDateLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateInputLabel))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel7))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(startDateLabel))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endDateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateInputLabel)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Print to PDF
        try {
            Document document = new Document(PageSize.A3.rotate()); //Ορίζουμε και το μέγεθος της σελίδας για να χωράει ο πίνακας
            PdfWriter.getInstance(document, new FileOutputStream("Statistika.pdf"));

            //Open Document
            document.open();
            //Set greek characters
            BaseFont arialGreek = BaseFont.createFont("/Fonts/arial.ttf", "CP1253", BaseFont.EMBEDDED);
            Font arial4 = new Font(arialGreek, 10, Font.BOLD);
            Font arial = new Font(arialGreek, 14, Font.BOLD);
            Font arial18 = new Font(arialGreek, 18, Font.BOLD);
            //Create Numbers Table
            PdfPTable table1 = new PdfPTable(jTable1.getColumnCount());
            table1.setWidthPercentage(100); //Ορίζουμε το μέγεθος του πίνακα για την εμφάνιση στη σελίδα 

            //Title at Number Table
            PdfPCell cell = new PdfPCell(new Paragraph("Στατιστικά Αριθμών", arial));
            cell.setColspan(46); // colspan 
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.CYAN);//Background color CYAN
            table1.addCell(cell);//Add cell to table

            //Import number at table
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(jTable1.getColumnName(i)));
                cell1.setBackgroundColor(BaseColor.ORANGE); //Χρώμα Background ORANGE
                table1.addCell(cell1);
            }

            //Import stats of the number at the table
            for (int rows = 0; rows < jTable1.getRowCount(); rows++) {
                for (int cols = 0; cols < jTable1.getColumnCount(); cols++) {
                    table1.addCell(jTable1.getModel().getValueAt(rows, cols).toString());
                }
            }
            //Create bonus number table            
            PdfPTable table2 = new PdfPTable(jTable2.getColumnCount());

            //Title at Bonus Number Table
            PdfPCell cell2 = new PdfPCell(new Paragraph("Στατιστικά Joker", arial));
            cell2.setColspan(46); // colspan 
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBackgroundColor(BaseColor.CYAN);//Χρώμα Background CYAN
            table2.addCell(cell2);//Προσθέτουμε το κελί στον table

            //Import bonus number at second table
            for (int i = 0; i < jTable2.getColumnCount(); i++) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(jTable2.getColumnName(i)));
                cell1.setBackgroundColor(BaseColor.ORANGE); //Χρώμα Background ORANGE
                table2.addCell(cell1);
            }

            //Import stats of the bonus number at the second table
            for (int rows = 0; rows < jTable2.getRowCount(); rows++) {
                for (int cols = 0; cols < jTable2.getColumnCount(); cols++) {
                    table2.addCell(jTable2.getModel().getValueAt(rows, cols).toString());
                }
            }
            // Create Title
            Paragraph title = new Paragraph("Προβολή στατιστικών στοιχείων παιγνιδιού JOKER - εκτύπωση σε PDF", arial18);
            title.setAlignment(Element.ALIGN_CENTER);
            // Create Date range
            String datesRangeString = pdfDateFormat.format(jDateChooser1.getDate()).toString() + " - " + pdfDateFormat.format(jDateChooser2.getDate()).toString();
            Paragraph datesRange = new Paragraph(datesRangeString, arial18);
            datesRange.setAlignment(Element.ALIGN_CENTER);
            // Notes for the print 
            Paragraph notes = new Paragraph("*Σημείωση: Στην πρώτη γραμμή είναι οι αριθμοί, στην δεύτερη γραμμή είναι οι εμφανίσεις και στην τρίτη γραμμή είναι καθυστερήσεις", arial4);
            //Add Title, Dates and the table to the PDF
            document.add(title);
            document.add(Chunk.NEWLINE);
            document.add(datesRange);
            document.add(Chunk.NEWLINE);
            document.add(table1);
            document.add(Chunk.NEWLINE);
            document.add(table2);
            document.add(Chunk.NEWLINE);
            document.add(notes);

            //Open the pdf to the user
            File f = new File("Statistika.pdf");
            Desktop.getDesktop().open(f);

            //Close document
            document.close();
        } catch (DocumentException | IOException e) {
            System.err.println(e);
        }

        System.out.println("Done execute PDF");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DateFunctions dateFunctions = new DateFunctions();

        if (dateFunctions.checkDates(jDateChooser1.getDate(), jDateChooser2.getDate())) {
            try {
                statsNumbers(apiDateFormat.format(jDateChooser1.getDate()), apiDateFormat.format(jDateChooser2.getDate()), 5104);
                jButton2.setEnabled(true);
            } catch (ParseException ex) {
                Logger.getLogger(StatisticsScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateInputLabel;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}
