<%@page import="java.lang.String"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>ESEN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
            integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
            crossorigin=""/>
        <style>
            * { margin: 1px;}
            html, body {
              height: 100%;
              margin: 0;
              padding: 0;
            }
            .mapa {
              width: 50%;
              height: 40%;
              margin-bottom: 5px;
              border: 1px solid #777;
            }
            #coords{width: 500px;}
            
        </style>
    </head>
    <body>
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
            
       
        
        <form action="pagoTarjetaServlet" method="get">
            
           <h1>Pagar con tarjeta de credito</h1>
            
            <br><br>
            <div style="margin-left: 5px; margin: 5px;">
                
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
                    
                    
                    
            
                    <br><br>
                
                    Inserte su numero de tarjeta de credito:<br>
                    <input type="text" name="tarjetaCredito" placeholder="Tarjeta de credito"  id="tarjetaCredito"/>
                    <br><br>
                   
                    <br>
                    <input type="submit" value="Ingresar"/>
                    <input type="hidden" name="formid" value="1"/>
            
                    <p><a href="index.html">Regresar al menu</a></p>
</html>
