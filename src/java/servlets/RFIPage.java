/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.RfiFacade;
import controller.OfficeFacade;
import controller.PoFacade;
import controller.PrFacade;
import dao.Office;
import dao.Po;
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
@WebServlet(name = "RFIPage", urlPatterns = {"/RFIPage"})
public class RFIPage extends BaseServlet {
    
    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();

    @EJB
    private PoFacade poFacade = new PoFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int poID = Integer.parseInt(request.getParameter("po_id"));
        
        Po po = poFacade.find(poID);
        
        request.setAttribute("po", po);
        
        
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        
        rd = context.getRequestDispatcher("/rfi.jsp");
        rd.forward(request, response);
        
    }

}
