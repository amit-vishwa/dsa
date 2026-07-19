package module.one.maths.one.assignment;

public class codefile {

    public static void main(String[] args) {
        System.out.println("Day of the week: " + getDayOfWeek(31, 8, 2099));
        System.out.println("Day of the week: " + getDayOfWeek(18, 7, 1999));
        System.out.println("Day of the week: " + getDayOfWeek(15, 12, 2025));
    }

    private static int[][] daysOfMonths = {
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    private static String[] dayOfWeek = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    private static int daysSince1970(int day, int month, int year) {
        int totalDays = 0;
        for (int visitedYear = 1970; visitedYear < year; visitedYear++) {
//            if(isLeapYear(visitedYear)){
//                totalDays += 366;
//            }else{
//                totalDays += 365;
//            }
            totalDays += isLeapYear(visitedYear) ? 366 : 365;
        }
        int leapYear = isLeapYear(year) ? 0 : 1;
        for (int visitedMonth = 0; visitedMonth < month - 1; visitedMonth++) {
            totalDays += daysOfMonths[leapYear][visitedMonth];
        }
        totalDays += day;
        return totalDays;
    }

    private static String getDayOfWeek(int day, int month, int year) {
        int daysTillToday = daysSince1970(15, 12, 2025);
        int daysTillGivenDay = daysSince1970(day, month, year);
        int weekDay = (((daysTillGivenDay - daysTillToday) % 7) + 7) % 7;
        return dayOfWeek[weekDay];
    }
}