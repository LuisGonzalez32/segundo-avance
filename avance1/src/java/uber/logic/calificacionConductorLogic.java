
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

public class calificacionConductorLogic extends Logic{

    public calificacionConductorLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
     public int InsertCalificacionConductor(int iCliente, int iConductor, int iCalificacion) {
        
         String query = "insert into uber.calificacion_conductor "
                 +  "(id, id_cliente, id_conductor, calificacion_conductor)\n" 
                 +  "VALUES (0,"+iCliente+","+iConductor+","+iCalificacion+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
    }
}