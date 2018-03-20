/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.*;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "CreatePR", urlPatterns = {"/CreatePR"})
public class CreatePR extends BaseServlet {
    @EJB
    private PrFacade prFacade = new PrFacade();
    
    @EJB
    private PrDetailsFacade prDetailsFacade = new PrDetailsFacade();
    
    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pr newPr = new Pr();
        
        Office off = officeFacade.find(Integer.parseInt(new StringTokenizer(request.getParameter("office"), " -").nextToken()));
        
        newPr.setIdOffice(off);
        newPr.setDate(Date.from(Instant.now()));
        newPr.setFundCluster(request.getParameter("fund_cluster"));
        newPr.setResponsibilityCenterCode(request.getParameter("rcc"));
        newPr.setEntityName(request.getParameter("entity"));
        
        prFacade.create(newPr);
        
        ArrayList<Pr> prList = new ArrayList<Pr>(prFacade.findAll());
        
        for(Pr pr: prList){
            if(newPr.getIdOffice().equals(pr.getIdOffice()) && newPr.getDate().equals(pr.getDate())){
                newPr = pr;
            }
        }
        
        String[] units = request.getParameterValues("unit");
        String[] descs = request.getParameterValues("description");
        String[] quantities = request.getParameterValues("quantity");
        String[] costs = request.getParameterValues("cost");
        
        //since the above 4 are of same length, use any of them for loop count
        for(int ctr = 0; ctr < units.length; ctr++){
            PrDetails details = new PrDetails();
            
            details.setIdPr(newPr);
            details.setUnit(units[ctr]);
            details.setDescription(descs[ctr]);
            details.setQuantity(Integer.parseInt(quantities[ctr]));
            details.setCost(Float.parseFloat(costs[ctr]));
            
            prDetailsFacade.create(details);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);
        
    }
}
