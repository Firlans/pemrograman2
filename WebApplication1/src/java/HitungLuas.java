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
@WebServlet(urlPatterns = {"/HitungLuas"})
public class HitungLuas extends HttpServlet {

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
        String panjang = request.getParameter("panjang");
        String lebar = request.getParameter("lebar");
        int luas, lebarPersegi = 0, panjangPersegi = 0;
        if(panjang == null) panjang = "";
        if(lebar == null) lebar = "";
        try {
            panjangPersegi = Integer.parseInt(panjang);
            lebarPersegi = Integer.parseInt(lebar);
        } catch (NumberFormatException e) {
        }
        luas = panjangPersegi * lebarPersegi;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>" +
                        "<html>" +
                            "<head>" +
                                "<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" +
                                "<title>JSP Page</title>" +
                            "</head>" +
                            "<body>" +
                                "<hr style=\"border-color: red\">" +
                                "<form action=HitungLuas method=post>" +
                                    "<table>" +
                                        "<tr>" +
                                            "<td>panjang</td>" +
                                            "<td>:</td>" +
                                            "<td><input type=text name=panjang></td>" +
                                        "</tr>" +
                                        "<tr>" +
                                            "<td>lebar</td>" +
                                            "<td>:</td>" +
                                            "<td><input type=text name=lebar></td>" +
                                        "</tr>" +
                                        "<tr>" +
                                            "<td><input type=submit value=hitung></td>" +
                                        "</tr>" +
                                    "</table>" +
                                "</form>" +
                                    "<table >" +
                                        "<tr>" +
                                            "<th>Panjang</th>" +
                                            "<th>Lebar</th>" +
                                            "<th>Luas</th>" +
                                        "</tr>" +
                                        "<tr>" +
                                            "<td colspan=3><hr style=\"border: 2px solid red;\"></td>" +
                                        "</tr>" +
                                        "<tr>" +
                                            "<td style=\"padding:0 5rem\">"+ panjang +"</td>" +
                                            "<td style=\"padding:0 5rem\">"+ lebar +"</td>" +
                                            "<td style=\"padding:0 5rem\">"+ luas +"</td>" +
                                        "</tr>" +
                                    "</table>"+
                            "</body>" +
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
