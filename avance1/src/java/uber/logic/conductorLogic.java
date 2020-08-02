
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;


public class conductorLogic extends Logic{

    public conductorLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
    public int InsertConductor(String strNombre, String strMarcaDeCarro, int iTarjetaDeCirculacion, String strCorreoElectronico,int iLicencia,int iNumeroDeDui,int iNumeroDeTelefono,String strAntecedentesPenales,int iCuentaBancaria,String strOcupado,float iLatitudActual, float iLongitudActual) {
        
         String query = "insert into uber.conductor "
                 +  "(id,nombre,marca_de_carro,tarjeta_circulacion,correo_electronico,licencia,numero_DUI,numero_telefono,antecedente_penales,cuenta_bancaria,ocupado,latitud_actual,longitud_actual)\n" 
                 +  "VALUES (0,'"+strNombre+"','"+strMarcaDeCarro+"',"+iTarjetaDeCirculacion+",'"+strCorreoElectronico+"',"+iLicencia+","+iNumeroDeDui+","+iNumeroDeTelefono+",'"+strAntecedentesPenales+"',"+iCuentaBancaria+",'"+strOcupado+"',"+iLatitudActual+","+iLongitudActual+")";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
}
   
    
}
