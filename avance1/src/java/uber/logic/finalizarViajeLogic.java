
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import java.time.LocalDateTime;


public class finalizarViajeLogic extends Logic {

    public finalizarViajeLogic(String pConnectionString) {
        super(pConnectionString);
    }
     public int InsertFinalizarViaje(int iCliente, int iConductor, int iCatalogo,LocalDateTime iDateTime, float iLatitudFinal, float iLongitudFinal, float iDistancia) {
        
         String query = "insert into uber.viajes_final "
                 +  "(id, id_cliente, id_conductor, id_catalogo_lugares_turisticos,hora_final,latitud_final, longitud_final, distancia)\n"
                 +  "VALUES (0,"+iCliente+","+iConductor+","+iCatalogo+",'"+iDateTime+"',"+iLatitudFinal+","+iLongitudFinal+","+iDistancia+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
}
}