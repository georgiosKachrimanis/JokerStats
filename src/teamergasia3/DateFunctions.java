package teamergasia3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class DateFunctions {

    private String startDate = "";
    private String endDate = "";
    private DateFormat apiDateFormat = new SimpleDateFormat("YYYY-MM-dd");

    public DateFunctions() {
    }

    //  Check for valid input dates  by user
    private boolean compareDates(Date startDate, Date endDate) throws java.text.ParseException {

        // 1st official draw of the game Joker.
        Date jokerStartDate = apiDateFormat.parse("1997-11-16"); 
        // Today's date
        Date todayDate = new Date();

        if (startDate.before(jokerStartDate)) {
            JOptionPane.showMessageDialog(null, "Λάθος ημερομηνία!\nΗ πρώτη κλήρωση Joker έγινε στις 16/11/1997.\nΠροσπαθήστε με σωστές ημερομηνίες!");
            return false;
        } else if (endDate.after(todayDate)) {
            JOptionPane.showMessageDialog(null, "Λάθος ημερομηνία!\nΗ τελική ημερομηνία δεν μπορεί να είναι αργότερα από την σημερινή.\nΠροσπαθήστε με σωστές ημερομηνίες!");
            return false;
        } else if (endDate.before(startDate)) {
            JOptionPane.showMessageDialog(null, "Λάθος ημερομηνία!\nΗ τελική ημερομηνία δεν μπορεί να είναι πριν από την αρχική.\nΠροσπαθήστε με σωστές ημερομηνίες!");
            return false;
        }
        return true;
    }

    // Check if the user provided both start and end dates. Then the method compareDates will check for the vallidity of the dates.
    public boolean checkDates(Date startDate, Date endDate) {


        try {
            if ((startDate.equals(null)) || endDate.equals(null)) {
                JOptionPane.showMessageDialog(null, "Λάθος δεδομένα!\nΠαρακαλώ ελέγξτε το εύρος ημερομηνίων κλήρωσης!");
                return false;
            } else {
                if (compareDates(startDate, endDate)) {
                        this.startDate = apiDateFormat.format(startDate);
                        this.endDate = apiDateFormat.format(endDate);
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Λάθος δεδομένα!\nΠαρακαλώ ελέγξτε το εύρος ημερομηνίων κλήρωσης!");
            return false;
        }

    }

}
