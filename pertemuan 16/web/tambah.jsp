<%-- 
    Document   : tambah
    Created on : Nov 24, 2023, 3:52:02 PM
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
        <%@ page import="javax.swing.*" %>
        <%
            String topMenu="<nav>"
                                + "<ul>"
                                    + "<li><a href='index.jsp'>Home</a></li>"
                                    + "<li><a href='tambah.jsp'>Tambah Data Mahasiswa</a></li>"
                                + "</ul>"
                            + "</nav>";
            // Panggil hasil inputan di form
            String nim = request.getParameter("nim");
            String nama = request.getParameter("nama");
            String alamat = request.getParameter("alamat");
            String prodi = request.getParameter("prodi");
            String URL = "jdbc:mysql://localhost:3306/mahasiswa";
            // Koneksi database
            Connection conn = null;
            PreparedStatement ps = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            int updateQuery = 0;
            // Notifikasi bahwa seluruh form tidak boleh kosong
            if (nim != null && nama != null && alamat != null && prodi != null) {
                try {
                    conn = DriverManager.getConnection(URL, "root", "12345678");
                    String query = "INSERT INTO mahasiswa (nim, nama, alamat, prodi) VALUES (?, ?, ?, ?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, nim);
                    ps.setString(2, nama);
                    ps.setString(3, alamat);
                    ps.setString(4, prodi);
                    updateQuery = ps.executeUpdate();
                    if (updateQuery != 0) {
                        JOptionPane.showMessageDialog(null, "Berhasil Tambah Data Mahasiswa");
                        response.sendRedirect("index.jsp");
                    }
                } catch (Exception e) {
                    response.sendRedirect("index.jsp");
                } finally {
                    ps.close();
                    conn.close();
                }
            }
        %>
        <center>
            <table width="80%" bgcolor="#eeeeee">
                <tr>
                    <td colspan="4" align="center">
                        <br>
                        <h2 colspan="4" align="center">Tambah Data Mahasiswa</h2>
                        <h1 colspan="4" align="center">UNIVERSITAS PAMULANG</h1>
                        <h4 colspan="4" align="center">Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten</h4>
                        <%= topMenu %>
                        <br>
                        <form colspan="4" align="center" action="" method="POST">
                            <table>
                                <tr>
                                    <td>
                                        <label>NIM:</label>
                                    </td>
                                    <td>
                                        <input type="text" name="nim" /> <br/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Nama Mahasiswa:</label> 
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="nama" /> <br/>
                                        
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>
                                        <label>Alamat:</label>
                                        
                                    </td>
                                    <td>
                                        <input type="text" name="alamat" /><br/>
                                        
                                    </td>
                                    
                                </tr>
                                    <td>
                                        <label>Program Studi:</label>
                                        
                                    </td>
                                    <td>
                                        <select id="prodi" name="prodi">
                                            <option value="Teknik Informatika">Teknik Informatika</option>
                                            <option value="Sistem Informasi">Sistem Informasi</option>
                                            <option value="Akuntansi">Akuntansi</option>
                                            <option value="Manajemen">Manajemen</option>
                                        </select><br/>
                                        
                                    </td>
                            </table>
                            <br>
                            <input type="submit" name="submit" value="Simpan"/>
                            <button onclick="window.location.href='index.jsp'">Kembali</button><br><br>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#eeeeff">
                        <small>
                            Copyright copy: 2022 Universitas Pamulang<br>
                            Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten<br>
                        </small>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
