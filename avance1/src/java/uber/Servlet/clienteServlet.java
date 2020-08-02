
package uber.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uber.logic.clienteLogic;

@WebServlet(name = "clienteServlet", urlPatterns = {"/clienteServlet"})
public class clienteServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String formId = request.getParameter("formid");
            
            if (formId.equals("1"))
            {
                String strNombre = request.getParameter("nombre");
                String strNumerodetelefono = request.getParameter("numerodetelefono");
                String strCorreoelectronico = request.getParameter("correoelectronico");
                String strContrasenia = request.getParameter("contrasenia");
                String strLatitudactual = request.getParameter("latitud");
                String strLongitudactual = request.getParameter("longitud");
            
            //Transformar números
            int iNumerodetelefono = Integer.parseInt(strNumerodetelefono);
            float iLatitudactual = Float.parseFloat(strLatitudactual);
            float iLongitudactual = Float.parseFloat(strLongitudactual);
            String connString = "jdbc:mysql://localhost/uber?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true" 
                    + "&useLegacyDatetimeCode=false" 
                    + "&serverTimezone=UTC";
            
            clienteLogic logic = new clienteLogic(connString);
            
            int rows = logic.InsertCliente(strNombre, iNumerodetelefono, strCorreoelectronico, strContrasenia, iLatitudactual, iLongitudactual);
            
            request.getSession().setAttribute("rows", rows);
            response.sendRedirect("respuestaCliente.jsp");
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
