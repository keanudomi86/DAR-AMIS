/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.DivisionFacade;
import dao.Division;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
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
@WebServlet(name = "RegisterUser", urlPatterns = {"/RegisterUser"})
public class RegisterUser extends BaseServlet {
    
    @EJB
    private final DivisionFacade divFacade = new DivisionFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Division> divisions = new ArrayList<Division>(divFacade.findAll());
        
        request.setAttribute("divisions", divisions);
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/register.jsp");
        rd.forward(request, response);
    }

    
}
