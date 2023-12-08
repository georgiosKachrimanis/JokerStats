package teamergasia3;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class Number {

    // Declare Number Name
    private int number;
    // Declare occurrences for the number
    private int occurrences = 0;
    // Declare delays for the number
    private int delays = -1;

    // Add only number with default the other variables
    public Number(int number) {
        this.number = number;
    }

    // Add number and occurrences
    public Number(int number, int occurrences) {
        this.number = number;
        this.occurrences = occurrences;
    }

    // Increase occurrences
    public void increaseOccurrencesNumber() {
        setOccurrences(getOccurrences() + 1);
    }

    // Decrase delays   
    public void decreaseDelaysNumber(int delays) {
        setDelays(delays);
    }

    // Get Number Name
    public int getNumber() {
        return number;
    }

    // Set Number Name
    public void setNumber(int number) {
        this.number = number;
    }

    // Get Number occurrences
    public int getOccurrences() {
        return occurrences;
    }

    // Set Number occurrences
    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    // Get Number delays
    public int getDelays() {
        return delays;
    }

    // Set Number delays
    public void setDelays(int delays) {
        this.delays = delays;
    }
}
