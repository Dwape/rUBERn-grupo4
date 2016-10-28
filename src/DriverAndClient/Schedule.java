package DriverAndClient;

import Exceptions.InvalidDayOfTheWeekExc;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.LocalTime;

public class Schedule {
    private int[][] workWeek = new int[7][2];

    public void setHoursPerDay (String horasTrabajoInicia, String horasTrabajoFin, String dayOfTheWeek){
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
        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        LocalTime inicioTrabajo = formatter.parseLocalTime(horasTrabajoInicia);
        LocalTime finTrabajo = formatter.parseLocalTime(horasTrabajoFin);

        workWeek[i][0]=inicioTrabajo.getMillisOfDay();
        workWeek[i][1]=finTrabajo.getMillisOfDay();
    }

    public int[][] getWorkWeek() {
        return workWeek;
    }
}
