
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;


public class clienteLogic extends Logic {

    public clienteLogic(String pConnectionString) {
        super(pConnectionString);
    }

    public int InsertCliente(String strNombre, int iNumerodetelefono, String strCorreoelectronico, String strContrasenia, float iLatitudactual, float iLongitudactual) {
        
         String query = "insert into uber.cliente "
                 +  "(id,nombre,numero_telefono,correo_electronico, contraseña, latitud_actual, longitud_actual)\n" 
                 +  "VALUES (0,'"+strNombre+"',"+iNumerodetelefono+",'"+strCorreoelectronico+"', '"+strContrasenia+"', "+iLatitudactual+", "+iLongitudactual+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
}

    
}

