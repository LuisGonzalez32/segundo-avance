
package uber.logic;
import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import java.time.LocalDateTime;


public class iniciarViajeLogic extends Logic {

    public iniciarViajeLogic(String pConnectionString) {
        super(pConnectionString);
    }
     public int InsertIniciarViaje(int iIdCliente, int iIdConductor, int iIdCatalogo,LocalDateTime iDateTime, float iLatitudInicial, float iLongitudInicial, float iLatitudFinal, float iLongitudFinal) {
        
         String query = ""+"insert into uber.viajes_inicial "
                 +  "(id, id_cliente, id_conductor, id_catalogo_lugares_turisticos,hora_inicial, latitud_inicial, longitud_inicial, latitud_final_sugerida, longitud_final_sugerida)\n"
                 +  "VALUES (0,"+iIdCliente+","+iIdConductor+","+iIdCatalogo+",'"+iDateTime+"',"+iLatitudInicial+","+iLongitudInicial+","+iLatitudFinal+","+iLongitudFinal+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
}
}