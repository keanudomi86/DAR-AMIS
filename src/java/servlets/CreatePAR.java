/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.ParDetailsFacade;
import controller.ParFacade;
import dao.Par;
import dao.ParDetails;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Myles Mempin
 */
@WebServlet(name = "CreatePAR", urlPatterns = {"/CreatePAR"})
public class CreatePAR extends BaseServlet {
    @EJB
    private ParFacade parFacade = new ParFacade();

    @EJB
    private ParDetailsFacade parDetailsFacade = new ParDetailsFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error creating PR Form. Try again.";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        Par newPar = new Par();
        ParDetails newParDetails = new ParDetails();
        
        newPar.setEntityName(request.getParameter("entity"));
        newPar.setFundCluster(request.getParameter("fund_cluster"));
        newPar.setPurpose(request.getParameter("purpose"));
        newPar.setReceivedName(request.getParameter("name_rec"));
        newPar.setReceivedPosition(request.getParameter("pos_rec"));
        newPar.setReceivedOffice(request.getParameter("off_rec"));
        
        String date_rec = request.getParameter("date_rec");
        Date newDate;
        try {
            newDate = df.parse(date_rec);
            newPar.setReceivedDate(newDate);
        } catch (ParseException ex) {
            newPar.setReceivedDate(Date.from(Instant.now()));
        }
        
        newPar.setIssuedName(request.getParameter("name_iss"));
        newPar.setIssuedPosition(request.getParameter("pos_iss"));
        newPar.setIssuedOffice(request.getParameter("off_iss"));
        
        String date_iss = request.getParameter("date_iss");
        Date newDate2;
        try {
            newDate2 = df.parse(date_iss);
            newPar.setIssuedDate(newDate2);
        } catch (ParseException ex) {
            newPar.setIssuedDate(Date.from(Instant.now()));
        }
        
        parFacade.create(newPar);
        
        String[] quantity = request.getParameterValues("quantity");
        String[] unit = request.getParameterValues("unit");
        String[] description = request.getParameterValues("description");
        String[] property_no = request.getParameterValues("property_no");
        String[] date_acq = request.getParameterValues("acq_date");
        String[] amount = request.getParameterValues("amount");
        
        for(int ctr = 0; ctr < quantity.length; ctr++){
            
            newParDetails.setQuantity(Integer.parseInt(quantity[ctr]));
            newParDetails.setUnit(unit[ctr]);
            newParDetails.setDescription(description[ctr]);
            newParDetails.setPropertyNo(Integer.parseInt(property_no[ctr]));
            
            Date newDate3;
            try {
                newDate3 = df.parse(date_acq[ctr]);
                newParDetails.setDateAcq(newDate3);
            } catch (ParseException ex) {
                newParDetails.setDateAcq(Date.from(Instant.now()));
            }
            
            newParDetails.setAmount(Float.parseFloat(amount[ctr]));
            
            parDetailsFacade.create(newParDetails);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);
        
    }

}
