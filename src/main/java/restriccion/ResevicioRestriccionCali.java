package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResevicioRestriccionCali extends ServicioRestriccion{

    /**
     * Refactore de variable
     * Logica de negocio para cali
     * @param placa
     * @param fechaHora
     * @return
     */
    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        boolean fechaMayorIgualSeisMenorIgualOnce = (fechaHora.getHour()>=6 && fechaHora.getHour() <= 11);
        boolean fechaMayorIgualDieciSeisMenorIgualVeinte = (fechaHora.getHour()>=16 && fechaHora.getHour()<=20);
        char ultimoDigitoPlaca = placa.charAt(placa.length()-1);

        switch (fechaHora.getDayOfWeek()){
            case MONDAY:
                if((ultimoDigitoPlaca == '1' || ultimoDigitoPlaca == '2')
                        && (fechaMayorIgualSeisMenorIgualOnce || fechaMayorIgualDieciSeisMenorIgualVeinte)){
                    return false;
                }
                break;
            case FRIDAY:
                if((ultimoDigitoPlaca == '1' || ultimoDigitoPlaca == '2')
                        && (fechaMayorIgualSeisMenorIgualOnce || fechaMayorIgualDieciSeisMenorIgualVeinte)) {
                    return false;
                }
                break;
        }
        return true;
    }

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(4400000);
    }
}
