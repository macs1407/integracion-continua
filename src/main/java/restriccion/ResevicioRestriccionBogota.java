package restriccion;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ResevicioRestriccionBogota extends ServicioRestriccion{

    /**
     * Logica de negocio para bogota
     * @param placa
     * @param fechaHora
     * @return
     */
    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        if(fechaHora.getDayOfWeek() == DayOfWeek.SATURDAY || fechaHora.getDayOfWeek() == DayOfWeek.SUNDAY){
            return true;
        }
        boolean esDiaPar = fechaHora.getDayOfMonth() %  2 == 0;
        boolean esPlacaPar = Character.getNumericValue(placa.charAt(placa.length()-1))%2 == 0;
        boolean esManana = (fechaHora.getHour()>=6 && fechaHora.getHour()<=8 && fechaHora.getMinute()<=30);
        boolean esTarde = (fechaHora.getHour()>=15 && fechaHora.getHour()<=19 && fechaHora.getMinute()<=30);

        if(esDiaPar && esPlacaPar) {
            if(esManana || esTarde){
                return false;
            }
        }

        boolean esDiaImpar = !esDiaPar;
        if(esDiaImpar  && !esPlacaPar) {
            if(esManana || esTarde) {
                return false;
            }
        }
        return true;
    }

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(4700000);
    }
}
