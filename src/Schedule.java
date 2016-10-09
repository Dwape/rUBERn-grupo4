import Exceptions.InvalidDayOfTheWeekExc;
import org.joda.time.format.DateTimeFormat;

public class Schedule {
    org.joda.time.LocalTime[] workWeek = new org.joda.time.LocalTime[7];
    public void setHoursPerDayHours (String horasTrabajo, String dayOfTheWeek){
        int i=0;
        switch (dayOfTheWeek){
            case "monday":i=0;
                break;
            case "tuesday": i=1;
                break;
            case "wednesday": i=2;
                break;
            case "thursday": i=3;
                break;
            case "friday": i=4;
                break;
            case "saturday": i=5;
                break;
            case "sunday": i=6;
                break;
            default: throw new InvalidDayOfTheWeekExc();

        }
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        org.joda.time.LocalTime dt = formatter.parseLocalTime(horasTrabajo);
        workWeek[i]=dt;
    }
}
