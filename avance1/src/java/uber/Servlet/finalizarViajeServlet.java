
package uber.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.logic.finalizarViajeLogic;
import java.time.LocalDateTime;


@WebServlet(name = "finalizarViajeServlet", urlPatterns = {"/finalizarViajeServlet"})
public class finalizarViajeServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String formId = request.getParameter("formid");
            
            if (formId.equals("1"))
            {
                String strCliente = request.getParameter("cliente");
                String strConductor = request.getParameter("conductor");
                String strCatalogo = request.getParameter("catalogo");
                String strHora = request.getParameter("hora");
                String strLatitudFinal = request.getParameter("latitud_final");
                String strLongitudFinal = request.getParameter("longitud_final");
                String strDistancia = request.getParameter("distancia");
                
            
            //Transformar números
            int iCliente = Integer.parseInt(strCliente);
            int iConductor = Integer.parseInt(strConductor);
            int iCatalogo = Integer.parseInt(strCatalogo);
            LocalDateTime iDateTime = LocalDateTime.now();
            float iLatitudFInal = Float.parseFloat(strLatitudFinal);
            float iLongitudFInal = Float.parseFloat(strLongitudFinal);
            float iDistancia = Float.parseFloat(strDistancia);
            String connString = "jdbc:mysql://localhost/uber?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true" 
                    + "&useLegacyDatetimeCode=false" 
                    + "&serverTimezone=UTC";
            
            finalizarViajeLogic logic = new finalizarViajeLogic(connString);
            
            int rows = logic.InsertFinalizarViaje(iCliente, iConductor, iCatalogo, iDateTime, iLatitudFInal, iLongitudFInal, iDistancia);
            request.getSession().setAttribute("rows", rows);
            response.sendRedirect("respuestaFinalizarViaje.jsp");
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
