<%-- 
    Document   : Validasi
    Created on : Nov 8, 2023, 2:38:24 PM
    Author     : mr_tech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            
            if (userId != null) {
                userId = userId.trim(); // Menghapus spasi ekstra dari awal dan akhir
            }

            if (password != null) {
                password = password.trim(); // Menghapus spasi ekstra dari awal dan akhir
            }

            Cookie cookie;
            
            if(userId != null && password != null && userId.equals("ADMIN") && password.equals("ADMIN")){
                java.text.SimpleDateFormat waktu = new java.text.SimpleDateFormat("HH:mm:ss");
                java.text.SimpleDateFormat tanggal = new java.text.SimpleDateFormat("dd-MM-yyyy");
                java.util.Date waktuLogin = new java.util.Date();

                session.setAttribute("userLogin", userId);
                session.setAttribute("password", password);
                session.setAttribute("waktuLogin", waktu.format(waktuLogin));
                session.setAttribute("tanggalLogin", tanggal.format(waktuLogin));
                session.setMaxInactiveInterval(20);

                cookie = new Cookie("nama", userId);
                cookie.setMaxAge(15);
                response.addCookie(cookie);
            
            } else {
                cookie = new Cookie("keterangan", "User ID atau password salah");
                cookie.setMaxAge(15);
                cookie.setValue(java.net.URLEncoder.encode("User ID atau password salah", "UTF-8"));
                response.addCookie(cookie);
            }
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
