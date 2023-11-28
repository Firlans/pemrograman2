/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mr_tech
 */
@WebServlet(urlPatterns = {"/HitungNilai"})
public class HitungNilai extends HttpServlet {

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
        String hadir = request.getParameter ("hadir");
        String pertemuan = request.getParameter("pertemuan");
        String tugas = request.getParameter ("tugas");
        String uts = request.getParameter("uts");
        String uas = request.getParameter("uas");
        if (hadir == null) hadir="";
        if (pertemuan == null) pertemuan="";
        if (tugas == null) tugas="";
        if (uts == null) uts="";
        if (uas == null) uas="";
        int jumlahHadir=0;
        int jumlahPertemuan = 0;
        double nilaiTugas=0;
        double nilaiUts=0;
        double nilaiUas=0;
        double nilaiAkhir = 0;
        double rataKehadiran = 0;
        String grade="", status="";
        
        try {
            jumlahHadir = Integer.parseInt(hadir);
        } catch (NumberFormatException ex) {}
        try {
            jumlahPertemuan = Integer.parseInt(pertemuan);
        } catch (NumberFormatException ex) {}
        try {
            nilaiTugas = Double.parseDouble(tugas);
        } catch (NumberFormatException ex) {}
        try {
            nilaiUts = Double.parseDouble(uts);
        } catch (NumberFormatException ex) {}
        try {
            nilaiUas = Double.parseDouble(uas);
        } catch (NumberFormatException ex) {}
        if(jumlahHadir != 0 || jumlahPertemuan!=0){
            nilaiAkhir = ( (0.1*(jumlahHadir*100/jumlahPertemuan)) + (0.2* nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas));
        }
        if ((nilaiAkhir >= 0) && (nilaiAkhir <=100)) { 
            if (nilaiAkhir >= 80) { 
                grade = "A";
                status = "Lulus";
            } else if (nilaiAkhir >= 70) { 
                grade = "B"; 
                status = "Lulus";
            } else if (nilaiAkhir >= 60) { 
                grade = "C"; 
                status = "Lulus";
            } else if (nilaiAkhir >= 50) { 
                grade = "D";
                status = "Tidak Lulus";
            } else { 
                grade = "E"; 
                status = "Tidak Lulus";
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>"+
                        "<html>"+
                            "<head>"+
                            "<title>Ritung Nilai (Servlet) </title>"+
                            "</head>"+
                            "<body>"+
                            "<h2>Menghitung Nilai</h2>"+
                                "<form action=HitungNilai method=post>"+
                                    "<table>"+
                                        "<tr>"+
                                            "<td>Jumlah hadir</td>"+
                                            "<td><input type=text name=hadir value="+hadir+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Jumlah pertemuan</td>"+
                                            "<td><input type=text name=pertemuan value="+pertemuan+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Nilai tugas</td>"+
                                            "<td><input type=text name=tugas value="+tugas+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Nilai UTS</td>"+
                                            "<td><input type=text name=uts value="+uts+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Nilai UAS</td>"+
                                            "<td><input type=text name=uas value="+uas+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Nilai Akhir</td>"+
                                            "<td><input type=text readonly value="+nilaiAkhir+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td>Grade</td>"+
                                            "<td><input type=text readonly value="+grade+"></td>"+
                                        "</tr>"+"<tr>"+
                                            "<td>Status</td>"+
                                            "<td><input type=text readonly value="+status+"></td>"+
                                        "</tr>"+
                                        "<tr>"+
                                            "<td colspan=2 align=center><input type=submit value=Hitung></td>"+ 
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
