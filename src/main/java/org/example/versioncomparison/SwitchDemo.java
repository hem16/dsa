package org.example.versioncomparison;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchDemo {
    //Introduce in Java-17
    public static void main(String[] args) {
       DayOfWeek day =LocalDate.now().getDayOfWeek();
       boolean weekDay=switch (day) {
           /*case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
           case SATURDAY, SUNDAY -> false;
       };*/
           case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
               System.out.println("All Work..");
               yield true;
           }
            case SATURDAY,SUNDAY -> {
               System.out.println("Enjoy Weekend");
               yield false;
           }
       };
        System.out.println(weekDay);
    }
}
