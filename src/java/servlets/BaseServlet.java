/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BavarianHotdog
 */
public abstract class BaseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public abstract String servletAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletResponse = new String();
        try {
            servletResponse = servletAction(request, response);
            if (servletResponse.contains("/")) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher(servletResponse);
                rd.forward(request, response);
            } else {
                response.setContentType("text/plain");
                try (PrintWriter out = response.getWriter()) {
                    if (servletResponse != null) {
                        out.println(servletResponse);
                    } else {
                        out.println("Error");
                    }
                }
            }
        } catch (Exception x) {
            response.setContentType("text/plain");
            try (PrintWriter out = response.getWriter()) {
                if (servletResponse != null) {
                    out.println(servletResponse);
                } else {
                    out.println("Error");
                }
            }
            System.err.println(x);
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

    public void generateTextResponse(HttpServletResponse response, String msg)
            throws IOException {
        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            out.println(msg);
        }
    }

}
