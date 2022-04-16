package restriccion.test;

import org.junit.jupiter.api.Test;
import restriccion.FabricaServicio;
import restriccion.ServicioRestriccion;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RestriccionVehicularTest {

    @Test
    public void testPuedeSalirMedellin(){
        ServicioRestriccion servicio = FabricaServicio.getServicio("Medellin");
        boolean comprueba = servicio.puedeSalir("ABC123", null);
        // Validar que si puede salir
        assertTrue(comprueba);
    }

    @Test
    public void testPuedeSalirLunesCali(){
        ServicioRestriccion servicio = FabricaServicio.getServicio("Cali");
        LocalDateTime fecha = LocalDateTime.of(2022,4, 22, 11, 0, 0);
        boolean comprueba = servicio.puedeSalir("DEF012", fecha);
        // Validar que si puede salir
        assertFalse(comprueba);
    }

    /*@Test
    public void testPuedeSalirMartesCali(){
        ServicioRestriccion servicio = new ServicioRestriccion();
        LocalDateTime fecha = LocalDateTime.of(2022,4, 23, 8, 0, 0);
        boolean comprueba = servicio.puedeSalir("Cali", "DEF234", fecha);
        // Validar que si puede salir
        assertFalse(comprueba);
    }*/

    @Test
    public void testCiudadNoSoportada(){
        assertThrows(UnsupportedOperationException.class, ()-> FabricaServicio.getServicio("Pereira"));
    }
}
