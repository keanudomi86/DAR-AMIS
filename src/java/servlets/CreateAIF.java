/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.AifDetailsFacade;
import controller.AifFacade;
import controller.EmployeeFacade;
import controller.FormRepoFacade;
import dao.Aif;
import dao.AifDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Myles Mempin
 */
@WebServlet(name = "CreateAIF", urlPatterns = {"/CreateAIF"})
public class CreateAIF extends BaseServlet {
    
    @EJB
    private AifFacade aifFacade = new AifFacade();
    
    @EJB
    private AifDetailsFacade aifDetailsFacade = new AifDetailsFacade();
    
    @EJB
    private FormRepoFacade repoFacade = new FormRepoFacade();
    
    @EJB
    private EmployeeFacade employeeFacade = new EmployeeFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Aif newAiF = new Aif();
        AifDetails newAifDetails = new AifDetails();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        
        String dr = request.getParameter("date_delivery");
        df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date d_r;
        try {
            d_r = df.parse(dr);
            newAiF.setDateReceived(d_r);
        } catch (ParseException ex) {
            newAiF.setDateReceived(Date.from(Instant.now()));
        }
        
        newAiF.setControlNo(Integer.parseInt(request.getParameter("date_delivery")));
        
        String dr2 = request.getParameter("date_delivery");
        df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date d_r2;
        try {
            d_r2 = df.parse(dr2);
            newAiF.setDateRequested(d_r2);
        } catch (ParseException ex) {
            newAiF.setDateReceived(Date.from(Instant.now()));
        }
        
        newAiF.setReceivedFrom(request.getParameter(""));
        newAiF.setReceivedBy(request.getParameter(""));
        
        aifFacade.create(newAiF);
        
        newAifDetails.setTypeOfRequest("");
        newAifDetails.setTypeOfRequest2("");
        newAifDetails.setTypeOfRequestOthers("");
        newAifDetails.setInspector("");
        newAifDetails.setRequieredAction("");
        newAifDetails.setRequiredActionOthers("");
        newAifDetails.setNameRequest("");
        
        String ds = request.getParameter("");
        df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date d_s;
        try {
            d_s = df.parse(ds);
            newAiF.setDateRequested(d_s);
        } catch (ParseException ex) {
            newAiF.setDateReceived(Date.from(Instant.now()));
        }
        
        aifDetailsFacade.create(newAifDetails);
    }

}
