<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String userLogin = "";
            String password = "";
            String waktuLogin = "";
            String tanggalLogin = "";
            Cookie[] cookies = request.getCookies();
            java.util.Date saatIni = new java.util.Date();
            java.text.SimpleDateFormat waktu = new java.text.SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            
            if(!session.isNew()){
                try{
                    userLogin = session.getAttribute("userLogin").toString();
                    password = session.getAttribute("password").toString();
                    waktuLogin = session.getAttribute("waktuLogin").toString();
                    tanggalLogin = session.getAttribute("tanggalLogin").toString();
                }catch(Exception ex){}
            }
            
            
            if(!userLogin.equals("")){
        %>
        <p>Anda Sudah login dengan nama <b><%= userLogin %></b> dan password <b><%=password%></b><br>
            pada waktu Login: <b><%=waktuLogin%></b>
            tanggal : <b><%=tanggalLogin %></b>
        <% 
            }else{ 
        %>
                <form action="Validasi.jsp" method="post">
                    <table>
                        <tr>
                            <td>User ID</td>
                            <td><input type="text" name="userId"></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="password"></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="login">
                            </td>
                        </tr>
                    </table>
                </form>
        <%
            }
        %>
    </body>
</html>
