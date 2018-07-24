/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.OfficeFacade;
import controller.PrFacade;
import dao.Office;
import dao.Pr;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "PRPage", urlPatterns = {"/PRPage"})
public class PRPage extends BaseServlet {
    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();
    
    @EJB
    private PrFacade prFacade = new PrFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Office> offices = new ArrayList<Office>(officeFacade.findAll());
        request.setAttribute("offices", offices);
        
        
        
        if(session.getAttribute("formMode").equals("view")){
            int id = Integer.parseInt(request.getParameter("id"));
            
            Pr prData = prFacade.find(id);
            
            request.setAttribute("prData", prData);
        }else if(session.getAttribute("formMode").equals("create")){
            ArrayList<Pr> prData = new ArrayList<>(prFacade.findAll());
            
            int latestId = 1;
            
            for(Pr pr: prData){
                if(pr.getIdPr() > latestId){
                    latestId = pr.getIdPr();
                }
            }
            
            latestId++;
            
            request.setAttribute("prData", prData);
            request.setAttribute("newFormId", latestId);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        
        rd = context.getRequestDispatcher("/pr.jsp");
        rd.forward(request, response);
        
    }

}
