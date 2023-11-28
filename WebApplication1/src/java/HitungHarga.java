/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author mr_tech
 */
@WebServlet(urlPatterns = {"/HitungHarga"})
public class HitungHarga extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int harga=0; 
        int jumlahBarang = 0;
        int diskon = 0;
        int total;
        String namaBarang = request.getParameter("namaBarang");
        String hargaSatuan = request.getParameter("hargaSatuan");
        String jumlah = request.getParameter("jumlah");
        
        try {
            harga = Integer.parseInt(hargaSatuan);
        } catch (NumberFormatException e) {}
        try {
            jumlahBarang = Integer.parseInt(jumlah);
        } catch (NumberFormatException e) {}
        total = harga * jumlahBarang;
        if(jumlahBarang >= 100 && total >= 1_000_000){
            diskon = ((int)(total * 0.05));
            total -= diskon;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>"+
            "<html>"+
            "<head>"+
            "<title>Menghitung Harga (Servlet) </title>"+
            "</head>"+
            "<body>"+
            "<h2>Hasil Penghitungan Harga</h2>"+
            "<form action=index.jsp method=post>"+
            "<table>"+
            "<tr>"+
            "<td>Nama Barang</td><td>:</td><td>"+namaBarang+"</td>"+
            "</tr>"+
            "<tr>"+
            "<td>Harga Satuan</td><td>:</td><td>"+hargaSatuan+"</td>"+ 
            "</tr>"+
            "<tr>"+
            "<td>Jumlah</td><td>:</td><td>"+jumlah+"</td>"+ 
            "</tr>"+
            "<tr>"+
            "<td>Diskon</td><td>:</td><td>"+diskon+"</td>"+
            "</tr>"+
            "<tr>"+
            "<td>Total</td><td>:</td><td>"+total+"</td>"+
            "</tr>"+
            "<tr>"+
            "<td colspan=3><input type=submit value=KembaliX</td>"+
            "</tr>"+
            "</table>"+
            "</form>"+
            "</body>"+
            "</html>");
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
