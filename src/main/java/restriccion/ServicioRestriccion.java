package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * CLase que esta pensada para obtener jerarquia y no ser instanciada
 */
public abstract class ServicioRestriccion {

    /**
     * Metodo original sin refeactor
     * @return
     */
    /*public boolean puedeSalir(String ciudad, String placa, LocalDateTime fechaHora) {
        if(ciudad.equals("Medellin")) return true;
        if(ciudad.equals("Cali")) {
            switch (fechaHora.getDayOfWeek()){
                case MONDAY:
                    if((placa.charAt(placa.length()-1) == '1' || placa.charAt(placa.length()-1) == '2')
                            && ((fechaHora.getHour()>=6 && fechaHora.getHour() <= 11)
                            || (fechaHora.getHour()>=16 && fechaHora.getHour()<=20))){
                        return false;
                    }
                    break;
                case FRIDAY:
                    if((placa.charAt(placa.length()-1) == '1' || placa.charAt(placa.length()-1) == '2')
                            && ((fechaHora.getHour()>=6 && fechaHora.getHour() <= 11)
                            || (fechaHora.getHour()>=16 && fechaHora.getHour()<=20))) {
                        return false;
                    }
                    break;
            }
            return true;
        }

        if(ciudad.equals("Bogota")) {
            if(fechaHora.getDayOfWeek() == DayOfWeek.SATURDAY || fechaHora.getDayOfWeek() == DayOfWeek.SUNDAY){
                return true;
            }
            // Dia par en placa par
            if(fechaHora.getDayOfMonth() %  2 == 0 && Character.getNumericValue(placa.charAt(placa.length()-1))%2 == 0) {
                if((fechaHora.getHour()>=6 && fechaHora.getHour()<=8 && fechaHora.getMinute()<=30) || // mañana
                        (fechaHora.getHour()>=15 && fechaHora.getHour()<=19 && fechaHora.getMinute()<=30)) { // tarde
                    return false;
                }
            }
            // Dia impar en placa par
            if(fechaHora.getDayOfMonth() %  2 == 1 && Character.getNumericValue(placa.charAt(placa.length()-1))%2 == 1) {
                if((fechaHora.getHour()>=6 && fechaHora.getHour()<=8 && fechaHora.getMinute()<=30) || // mañana
                        (fechaHora.getHour()>=15 && fechaHora.getHour()<=19 && fechaHora.getMinute()<=30)) { // tarde
                    return false;
                }
            }
            return true;
        }
        throw new UnsupportedOperationException("La ciudad "+ciudad+" no esta soportada");
    }*/

    public abstract BigDecimal obtenerMulta();

    /**
     * Metodo con refactor separando la logica de cada ciudad en un metodo
     * @param placa
     * @param fechaHora
     * @return
     */
    public abstract boolean puedeSalir(String placa, LocalDateTime fechaHora);
}
