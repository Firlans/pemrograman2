<%-- 
    Document   : index
    Created on : Nov 24, 2023, 2:34:19 PM
    Author     : mr_tech
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <%@ page import="java.sql.*" %>
        <% 
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            try {
                String connectionURL = "jdbc:mysql://localhost:3306/mahasiswa";
                String username = "root";
                String password = "12345678"; 
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(connectionURL, username, password);
                statement = connection.createStatement(); 
                String query = "SELECT * FROM mahasiswa";
                rs = statement.executeQuery(query);
                String topMenu = "<nav>"
                                +        "<ul>"
                                +            "<li><a href=index.jsp>Home</a></li>"
                                +            "<li><a href=tambah.jsp>Tambah Data Mahasiswa</a></li>"
                                +        "</ul>"
                                + "</nav>";
                String menu = "<br><b>Master Data</b><br>"
                            + "<a href='HitungNilai Mahasiswa'>Hitung Nilai Mahasiswa</a><br>"
                            + "<a href='MataKuliahController'>Mata Kuliah</a><br><br>"
                            + "<b>Transaksi</b><br>"
                            + "<a href=''>Nilai</a><br><br>"
                            + "<b>Laporan</b><br>"
                            + "<a href=''>Nilai</a><br><br>"
                            + "<a href='LoginController'>Login</a><br><br>";
                String userName = "";
                if (!session.isNew()) {
                    try {
                        userName = session.getAttribute("userName").toString();
                    } catch (Exception ex1) {
                        try {
                            menu = session.getAttribute("menu").toString();
                        } catch (Exception ex2) {}
                    }
                }
            %>
            <center>
                <table width="70%" bgcolor="#eeeeee">
                    <tr>
                        <td colspan="4" align="center">
                            <br>
                            <h2 colspan="4" align="center"> Data Mahasiswa</h2>
                            <h1 colspan="4" align="center">UNIVERSITAS PAMULANG</h1>
                            <h4 colspan="4" align="center">Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten</h4>
                            <%=topMenu%>
                            <br>
                        </td>
                    </tr>
                    <tr> 
                        <td colspan="4" align="center">
                            <br>
                            <h2 colspan="4" align="center">Data Mahasiswa</h2>
                            <h1 colspan="4" align="center">UNIVERSITAS PAMULANG</h1> 
                            <h4 colspan="4" align="center">Jl. Surya Kencang No. 1 Pamulang. Tangerang Selatan, Banten</h4>
                            <br>
                        </td>
                    </tr>
                    <tr colspan="4" align="center">
                        <th colspan="1" align="center">NIM</th>
                        <th colspan="1" align="center">Nama</th>
                        <th colspan="1" align="center">Alamat</th>
                        <th colspan="2" align="center">Program Studi</th>
                        <th colspan="2" align="center">Aksi</th>
                    </tr>
                    <% while (rs.next()){ %>
                        <tr colspan="4" align="center">
                            <td colspan="1" align="center"><%= rs.getString("nim") %></td> 
                            <td colspan="1" align="center"><%= rs.getString("nama") %></td>
                            <td colspan="1" align="center"><%= rs.getString("alamat") %></td>
                            <td colspan="1" align="center"><%= rs.getString("prodi") %></td>
                            <td colspan="1" align="center"><a href="edit.jsp?nim=<%= rs.getString("prodi") %>">edit</a></td>
                        </tr>
                    <%}%>
                    <%
                        rs.close();
                        statement.close();
                        connection.close();
                    } catch (Exception e) {
                        System.err.println("GAGAL KONEKSI"+e.getMessage()); 
                        out.println("GAGAL"+e.getMessage());
                    }
                %>
                <tr>
                    <td colspan="4" align="center" bgcolor="#eeeeff">
                        <small>
                        Copyright &copy; 2022 Universitas Pamulang<br>
                        Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten<br>
                        </small>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
