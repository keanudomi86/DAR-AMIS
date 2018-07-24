/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.OfficeFacade;
import dao.Office;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "WFPForm", urlPatterns = {"/WFPForm"})
public class WFPForm extends BaseServlet {
    
    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> offices = new ArrayList<>();
        
        List<Office> officesList = officeFacade.findAll();
        
        for(Office o: officesList){
            offices.add(o.getIdOffice() + " - " + o.getDepartment());
        }
        
        request.setAttribute("offices", offices);
        
        ServletContext context = getServletContext();
        
        RequestDispatcher rd = context.getRequestDispatcher("/wfp.jsp");
        
        rd.forward(request, response);
        
    }

    

}
