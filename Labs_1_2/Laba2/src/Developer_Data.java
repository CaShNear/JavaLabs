import java.util.Calendar;
import java.util.GregorianCalendar;

public class Developer_Data {

    static public void Info() {

        String dev_surname = "Kushnir";
        Calendar time_of_issue = new GregorianCalendar();
        time_of_issue.set(Calendar.YEAR, 2024);
        time_of_issue.set(Calendar.MONTH, 1);
        time_of_issue.set(Calendar.DAY_OF_MONTH, 9);
        time_of_issue.set(Calendar.HOUR_OF_DAY, 14);
        time_of_issue.set(Calendar.MINUTE, 30);
        time_of_issue.set(Calendar.SECOND, 0);
        Calendar due_time = new GregorianCalendar();
        System.out.println("This program was made by " + dev_surname + ". Task was given at " + time_of_issue.getTime() + ". Task was shown at " + due_time.getTime() + ".");
    }

}
