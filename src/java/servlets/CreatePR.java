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
import java.util.InputMismatchException;
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
        String msg = "Error creating PR Form. Try again.";
        
        try{
            Pr newPr = new Pr();

            Office off = officeFacade.find(Integer.parseInt(new StringTokenizer(request.getParameter("office"), " -").nextToken()));

            newPr.setIdOffice(off);
            newPr.setDate(Date.from(Instant.now()));

            if(request.getParameter("fund_cluster") != null && !request.getParameter("fund_cluster").isEmpty())
                newPr.setFundCluster(request.getParameter("fund_cluster"));

            if(request.getParameter("rcc") != null && !request.getParameter("rcc").isEmpty())
                newPr.setResponsibilityCenterCode(request.getParameter("rcc"));

            if(request.getParameter("entity") != null  && !request.getParameter("entity").isEmpty())
                newPr.setEntityName(request.getParameter("entity"));

            prFacade.create(newPr);

            ArrayList<Pr> prList = new ArrayList<Pr>(prFacade.findAll());

            for(Pr pr: prList){
                if(newPr.getIdOffice().getIdOffice().equals(pr.getIdOffice().getIdOffice()) && newPr.getDate().equals(pr.getDate())){
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

                if(quantities[ctr] != null)
                    details.setQuantity(Integer.parseInt(quantities[ctr]));
                else
                    details.setQuantity(0);

                if(costs[ctr] != null)
                    details.setCost(Float.parseFloat(costs[ctr]));
                else
                    details.setCost(0.0f);

                prDetailsFacade.create(details);
            }

            msg = "From submission successful.";
        }catch(InputMismatchException | NullPointerException 
                | NumberFormatException a){
            
        }
        
        generateTextResponse(response, msg);
        
    }
}
