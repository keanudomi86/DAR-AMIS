/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.PrFacade;
import dao.Pr;
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
@WebServlet(name = "POPage", urlPatterns = {"/POPage"})
public class POPage extends BaseServlet {
    
    @EJB
    private PrFacade prFacade = new PrFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int prID = Integer.parseInt(request.getParameter("pr_id"));
        
        Pr pr = prFacade.find(prID);
        
        request.setAttribute("pr", pr);
        
        
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        
        rd = context.getRequestDispatcher("/po.jsp");
        rd.forward(request, response);
        
    }

}
