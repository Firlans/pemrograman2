/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.unpam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mr_tech
 */
@WebServlet(name = "MahasiswaController", urlPatterns = {"/MahasiswaController"})
public class MahasiswaController extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        String menu="<br><b>Master Data</b><br>"
                    + "<a href=.>Mahasiswa</a><br>"
                    + "<a href=.>Mata Kuliah</a><br><br>"
                    + "<b>Transaksi</b><br>"
                    + "<a href=.>Nilai</a><br><br>"
                    + "<b>Laporan</b><br>"
                    + "<a href=.>Nilai</a><br><br>"
                    + "<a href=LoginController>Login</a><br><br>";
        String topMenu="<nav><ul>"
                    +"<li><a href=.>Home</a></li>"
                    +"<li><a href=#>Master Data</a>"
                    +"<ul>"
                    +"<li><a href=.>Mahasiswa</a></li>"
                    +"<li><a href=.>Mata Kuliah</a></li>"
                    +"</ul>"
                    +"</li>"
                    +"<li><a href=#>Transaksi</a>"
                    +"<ul>"
                    +"<li><a href=.>Nilai</a></li>"
                    +"</ul>"
                    +"</li>"
                    +"<li><a href=#>Laporan</a>"
                    +"<ul>"
                    +"<li><a href=.>Nilai</a></li>"
                    +"</ul>"
                    +"</li>"
                    +"<li><a href=LoginController> Login</a></li>"
                    +"</ul>"
                    +"</nav>";
        String userName="";
        String konten = "";
        if (!session.isNew()){
            try {
                userName =
                session.getAttribute("userName").toString();
            } catch (Exception ex){}
            if (!((userName == null) || userName.equals(""))){
                if (konten.equals("")){
                    konten = "<br><h1>Selamat Datang</h1><h2>"+userName+"</h2>";
                }
                try {
                    menu = session.getAttribute("menu").toString();
                } catch (Exception ex){}
                try {
                    topMenu = session.getAttribute("topMenu").toString();
                } catch (Exception ex){}
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='style.css' rel='stylesheet' type='text/css' />");
            out.println("<title>Informasi Nilai Mahasiswa</title>");
            out.println("</head>");
            out.println("<body bgcolor=\"#808080\">");
            out.println("<center>");
            out.println("<table width=\"80%\" bgcolor=\"#eeeeee\">");
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\">");
            out.println("<br>");
            out.println("<h2 Style=\"margin-bottom:0px; margin-top:0px;\">");
            out.println("Informasi Nilai Mahasiswa");
            out.println("</h2>");
            out.println("<h1 Style=\"margin-bottom:0px; margin-top:0px;\">");
            out.println("UNIVERSITAS PAMULANG");
            out.println("</h1>");
            out.println("<h4 Style=\"margin-bottom:0px; margin-top:0px;\">");
            out.println("Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten");
            out.println("</h4>");
            out.println("<br>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr height=\"400\">");
            out.println("<td width=\"200\" align=\"center\" valign=\"top\"bgcolor=\"#eeffee\">");
            out.println("<div id='menu'>");
            out.println(menu);
            out.println("</div>");
            out.println("</td>");
            out.println("<td align=\"center\" valign=\"top\" bgcolor=\"#ffffff\">");
            out.println(topMenu);
            out.println("<br>");
            out.println(konten);
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\" bgcolor=\"#eeeeff\">");
            out.println("<small>");
            out.println("Copyright &copy; 2014 Universitas Pamulang<br>");
            out.println("Jl. Surya Kencana No. 1 Pamulang, Tangerang Selatan, Banten<br>");
            out.println("</small>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }    
    }
}

