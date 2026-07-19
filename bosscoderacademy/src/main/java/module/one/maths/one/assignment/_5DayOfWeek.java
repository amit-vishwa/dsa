package module.one.maths.one.assignment;

/**
 * Day Of The Week:
 * <p>
 * Given a date, return the corresponding day of the week for that date. The input is given as three integers representing
 * the day, month and year respectively. Return the answer as one of the following values
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * <p>
 * Input 1: day = 31, month = 8, year = 2019
 * Output 1: "Saturday"
 * Explanation 1:
 * <p>
 * Input 2: day = 18, month = 7, year = 1999
 * Output 2: "Sunday"
 * <p>
 * Constraints:
 * The given dates are valid dates between the years 1971 and 2100.
 * <p>
 * Approach:
 * - The problem can be solved by a simple approach.
 * - There is nothing like optimal or bruteforce approach, the problem can be solved in constant time and space.
 * - First create a 2D array to store days of months in leap and a non-leap year.
 * - Now, create an array to store days of the week.
 * - After that create a function that checks whether the year is a leap year or not.
 * - Now, the main function comes that simply calculates the total number of days since year 1970.
 * - Here we are iterating over a loop from year 1970 to a year less than specified year and calculate days based on leap year check.
 * - Now, after calculating days using year, calculate the number of days for passed months in current year.
 * - Iterate over a loop from first month to a previous month and then add the specified days to the final total days.
 * - Now we also have to calculate days for weeks which we have provided for reference and this is the most important part.
 * - After that just subtract the days till reference date from days of specified date and take its mod by 7.
 * - Then re-add the 7 to it and at last take mod of 7 again just for negative date fixes.
 * - Time and space complexities are O(1) as we have fixed number of constraints.
 */
public class _5DayOfWeek {

    public static void main(String[] args) {
        System.out.println("Day of the week: " + getDayOfWeek(31, 8, 2019));
        System.out.println("Day of the week: " + getDayOfWeek(18, 7, 1999));
        System.out.println("Day of the week: " + getDayOfWeek(15, 12, 2025));
    }

    private static int[][] daysOfMonth = {
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    private static String[] dayOfWeek = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private static int daysFrom1970(int day, int month, int year) {
        int daysSince1971 = 0;
        for (int visitedYear = 1970; visitedYear < year; visitedYear++) {
            daysSince1971 += isLeapYear(visitedYear) ? 366 : 365;
        }
        int leapYear = isLeapYear(year) ? 0 : 1;
        for (int visitedMonth = 0; visitedMonth < month - 1; visitedMonth++) {
            daysSince1971 += daysOfMonth[leapYear][visitedMonth];
        }
        daysSince1971 += day;
        return daysSince1971;
    }

    private static String getDayOfWeek(int day, int month, int year) {
        int daysTillToday = daysFrom1970(15, 12, 2025);
        int totalDays = daysFrom1970(day, month, year);
        int daysOffset = (((totalDays - daysTillToday) % 7) + 7) % 7;
        return dayOfWeek[daysOffset];
    }

}