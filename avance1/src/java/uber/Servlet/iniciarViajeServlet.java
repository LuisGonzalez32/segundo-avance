
package uber.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.logic.iniciarViajeLogic;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;



@WebServlet(name = "iniciarViajeServlet", urlPatterns = {"/iniciarViajeServlet"})
public class iniciarViajeServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String formId = request.getParameter("formid");
            
            if (formId.equals("1"))
            {
                String strCliente = request.getParameter("cliente");
                String strConductor = request.getParameter("conductor");
                String strLugar = request.getParameter("lugar");
                String strHora = request.getParameter("hora");
                String strLatitudInicial = request.getParameter("latitud_inicial");
                String strLongitudInicial = request.getParameter("longitud_inicial");
                String strLatitudFinal = request.getParameter("latitud_final");
                String strLongitudFinal = request.getParameter("longitud_final");
                
     
            //Transformar números
            int iIdCliente = Integer.parseInt(strCliente);
            int iIdConductor = Integer.parseInt(strConductor);
            int iIdLugar = Integer.parseInt(strLugar);
            LocalDateTime iDateTime = LocalDateTime.now();//dateFormatter.parse(strHora);
            float iLatitudInicial = Float.parseFloat(strLatitudInicial);
            float iLongitudInicial = Float.parseFloat(strLongitudInicial);
            float iLatitudFinal = Float.parseFloat(strLatitudFinal);
            float iLongitudFinal = Float.parseFloat(strLongitudFinal);
            String connString = "jdbc:mysql://localhost/uber?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true" 
                    + "&useLegacyDatetimeCode=false" 
                    + "&serverTimezone=UTC";
            
            iniciarViajeLogic logic = new iniciarViajeLogic(connString);
            
            int rows = logic.InsertIniciarViaje(iIdCliente, iIdConductor, iIdLugar, iDateTime, iLatitudInicial, iLongitudInicial, iLatitudFinal, iLongitudFinal);
            
            request.getSession().setAttribute("rows", rows);
            response.sendRedirect("respuestaIniciarViaje.jsp");

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
