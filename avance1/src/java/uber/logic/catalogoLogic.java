package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

public class catalogoLogic extends Logic{

    public catalogoLogic(String pConnectionString) {
        super(pConnectionString);
    }

    public int InsertCatalogo(String strNombreLugar, String strCategoria, float iLatitud, float iLongitud) {
        
         String query = "insert into uber.catalogo_lugares_turisticos "
                 +  "(id,nombre,categoria,latitud,longitud)\n" 
                 +  "VALUES (0,'"+strNombreLugar+"','"+strCategoria+"',"+iLatitud+", "+iLongitud+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
    }
}
