package cl.karangop.shoppingfood.data;

import java.util.Calendar;

/**
 * Created by karan_000 on 03-03-2017.
 */

public class CurrentDay {

    private int today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

    public int dayNum(){
        return today;
    }


    //    Rescatar dia de la semana
    public String dayOfWeek() {

        switch (today){
            case 1:
                return "Domingo";
            case 2:
                return "Lunes";

            case 3:
                return "Martes";

            case 4:
                return "Miércoles";

            case 5:
                return "Jueves";

            case 6:
                return "Viernes";

            case 7:
                return "Sábado";

            default:
                return "Lunes";
        }

        /*
        -YEAR: Año.
        -MONTH: Mes.
        -DATE, DAY_OF_MONTH: Día del mes.
        -DAY_OF_WEEK: Día de la semana entre 1 (MONDAY) y 7 (SATURDAY).
        -HOUR: Hora antes o después del medio día (en intervalos de 12 horas).
        -HOUR_OF_DAY: Lo hora absoluta del día (en intervalos de 24 horas).
        -MINUTE: El minuto dentro de la hora.
        -SECOND: El segundo dentro del minuto.*/
    }
}
