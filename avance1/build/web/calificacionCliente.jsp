<%@page import="java.lang.String"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <title>JSP Page</title>
    </head>
    <body style="margin-top: 30px">      
        <%
           
            Connection con;
             String connString = "jdbc:mysql://localhost/uber?"
                    + "user=root&password=12345&"
                    + "autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true" 
                    + "&useLegacyDatetimeCode=false" 
                    + "&serverTimezone=UTC";
            con = DriverManager.getConnection(connString);
            
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT id, nombre from cliente");
            rs = ps.executeQuery();
            
            
            PreparedStatement psC;
            ResultSet rsC;
            psC = con.prepareStatement("SELECT id, nombre from conductor");
            rsC = psC.executeQuery();
            
          
            %>
                
            <div>
                <form action="calificacionClienteServlet" method="get">
                    Pasajero
                    <select name="cliente">
                        <% while(rs.next()){ %>
                        <option value="<%= rs.getInt("id")%>"><%= rs.getString("nombre")%></option>
                        <% } %>
                    </select>
                    <br><br>
                    Conductor
                    <select name="conductor">
                        <% while(rsC.next()){ %>
                        <option value="<%= rsC.getInt("id")%>"><%= rsC.getString("nombre")%></option>
                        <% } %>
                    </select>
                    <br><br>
                    
                    
                    Que calificacion le pones al pasajero?<br>
                    <br><br>
                    <select name="calificacion">
                        <option value="1">Malo</option>
                        <option value="2">Regular</option>
                        <option value="3">Bueno</option>
                        <option value="4">Muy Bueno</option>
                        <option value="5">Excelente</option>
                    </select>
            <br><br>
                    
                    <input type="submit" value="Ingresar" >
                     <input type="hidden" name="formid" value="1"/>
                    <br><br>
                    <p><a href="index.html">Regresar al menu</a></p>
                    
                    
                </form>
            </div>
    </body>
</html>