package restriccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResevicioRestriccionMedellin extends ServicioRestriccion{

    @Override
    public BigDecimal obtenerMulta() {
        return new BigDecimal(0);
    }

    @Override
    public boolean puedeSalir(String placa, LocalDateTime fechaHora) {
        return true;
    }
}
