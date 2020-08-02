
package uber.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;


public class pagoTarjetaLogic extends Logic {

    public pagoTarjetaLogic(String pConnectionString) {
        super(pConnectionString);
    }
    
    public int InsertPagoTarjeta(int iIdCliente, int iIdConductor, String strTarjetaCredito) {
        
         String query = "insert into uber.pago_tarjeta "
                 +  "(id, id_cliente, id_conductor, tarjeta_credito_cliente)"
                 +  "VALUES (0, "+iIdCliente+","+iIdConductor+",'"+strTarjetaCredito+"')";
        
        //Ingresar en la base de datos
        DatabaseX db = getDatabase();
        int rows = db.executeNonQueryRows(query); 
        return rows; 
}
}
