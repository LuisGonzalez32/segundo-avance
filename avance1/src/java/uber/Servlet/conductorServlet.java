
package uber.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.logic.conductorLogic;


@WebServlet(name = "conductorServlet", urlPatterns = {"/conductorServlet"})
public class conductorServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String formId = request.getParameter("formid");
            
            if (formId.equals("1"))
            {
                String strNombre = request.getParameter("nombreConductor");
                String strMarcaDeCarro = request.getParameter("marcaDeCarro");
                String strTarjetaDeCirculacion = request.getParameter("tarjetaDeCirculacion");
                String strCorreoElectronico = request.getParameter("correoElectronico");
                String strLicencia = request.getParameter("licencia");
                String strNumeroDeDui = request.getParameter("numeroDeDui");
                String strNumeroDeTelefono = request.getParameter("numeroDeTelefono");
                String strAntecedentesPenales = request.getParameter("antecedentes");
                String strCuentaBancaria = request.getParameter("cuentaBancaria");
                String strOcupado = request.getParameter("ocupado");
                String strLatitudActual = request.getParameter("latitud");
                String strLongitudActual = request.getParameter("longitud");
            
            //Transformar números
            int iTarjetaDeCirculacion = Integer.parseInt(strTarjetaDeCirculacion);
            int iLicencia = Integer.parseInt(strLicencia);
            int iNumeroDeDui = Integer.parseInt(strNumeroDeDui);
            int iNumeroDeTelefono = Integer.parseInt(strNumeroDeTelefono);
            int iCuentaBancaria = Integer.parseInt(strCuentaBancaria);
            float iLatitudActual = Float.parseFloat(strLatitudActual);
            float iLongitudActual = Float.parseFloat(strLongitudActual);
            String connString = "jdbc:mysql://localhost/uber?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true" 
                    + "&useLegacyDatetimeCode=false" 
                    + "&serverTimezone=UTC";
            
            conductorLogic logic = new conductorLogic(connString);
            
            int rows = logic.InsertConductor(strNombre, strMarcaDeCarro, iTarjetaDeCirculacion, strCorreoElectronico, iLicencia, iNumeroDeDui, iNumeroDeTelefono, strAntecedentesPenales, iCuentaBancaria, strOcupado, iLatitudActual, iLongitudActual);
            
            request.getSession().setAttribute("rows", rows);
            response.sendRedirect("respuestaConductor.jsp");

        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
