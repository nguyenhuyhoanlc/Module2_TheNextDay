public class NextDayCalculator {
    final static int RESET_DAY = 1;
    final static int RESET_MONTH = 1;
    public static String findNextDay(int day, int month, int year) {
        String nextDayToString = "";
        if (checkDay(day, month, year)){
            nextDayToString = nextDay(day, month, year);
        } else {
            nextDayToString = "This day is invalid date, Please again";
        }
        return nextDayToString;
    }

    public static String nextDay(int day, int month, int year) {
        boolean isEndDayOfYear = (day == lastDayOfMonth(month, year)) && (month ==12);
        boolean isEndDayOfMonth = day == lastDayOfMonth(month, year);

        if (isEndDayOfYear) {
            year += 1;
            month = RESET_MONTH;
            day = RESET_DAY;
        }
        else if (isEndDayOfMonth) {
            month += 1;
            day = RESET_DAY;
        }
        else {
            day += 1;
        }

        return "The NextDay is: " + day + "/" + month + "/" + year;
    }

    public static boolean checkDay(int day, int month, int year){
        boolean isValidDate = true;

        boolean invalidYear = (year < 0 || year >3000);
        boolean invalidMonth = (month <= 0 || month >12);
        boolean invalidDay = (day <=0 || day > lastDayOfMonth(month,year));

        if (invalidYear) isValidDate = false;
        if (invalidMonth) isValidDate = false;
        if (invalidDay) isValidDate = false;

        return isValidDate;
    }

    public static int lastDayOfMonth(int month, int year) {
        int day = 0;
        boolean isLeafYear = (year % 400 ==0 || (year %4 == 0 && year % 100 != 0));

        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if (isLeafYear){
                    day = 29;
                } else {
                    day = 28;
                }
                break;
        }

        return day;
    }
}
