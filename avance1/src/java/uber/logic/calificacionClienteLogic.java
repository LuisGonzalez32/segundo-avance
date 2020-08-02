
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

public class calificacionClienteLogic extends Logic{

    public calificacionClienteLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
     public int InsertCalificacionConductor(int iConductor, int iCliente, int iCalificacion) {
        
         String query = "insert into uber.calificacion_cliente "
                 +  "(id, id_conductor, id_cliente, calificacion_cliente)\n" 
                 +  "VALUES (0,"+iConductor+","+iCliente+","+iCalificacion+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
    }
}