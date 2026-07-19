package prerequisites.week1.lesson4;

/**
 * Check if the year is leap year or not.
 * A leap year is an year that is divisible by 400, or divisible by 4 but not 100.
 */
public class LeapYear {

    public static void main(String[] args) {
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2024));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2019));
    }

    static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}
