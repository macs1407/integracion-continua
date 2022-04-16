package restriccion;

public class FabricaServicio {

    /**
     * Metodo que se encarga de retorna el objeto de acuerdo al tipo, para quitar
     * SMELL: condicional repetido
     * @param ciudad
     * @return
     */
    public static ServicioRestriccion getServicio(String ciudad){
        ServicioRestriccion restriccion = null;
        switch (ciudad){
            case "Medellin":
                restriccion = new ResevicioRestriccionMedellin();
                break;
            case "Cali":
                restriccion = new ResevicioRestriccionCali();
                break;
            case "Bogota":
                restriccion = new ResevicioRestriccionBogota();
                break;
            default:
                throw new UnsupportedOperationException("La ciudad "+ciudad+" no es soportada.");
        }
        return restriccion;
    }
}
