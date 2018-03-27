/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.ParDetailsFacade;
import controller.ParFacade;
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
        
        ParDetails newParDetails = new ParDetails();
        
        newParDetails.setEntity(request.getParameter("entity"));
        newParDetails.setFundCluster(request.getParameter("fund_cluster"));
        newParDetails.setPurpose(request.getParameter("purpose"));
        newParDetails.setNameRec(request.getParameter("name_rec"));
        newParDetails.setPosRec(request.getParameter("pos_rec"));
        newParDetails.setOffRec(request.getParameter("off_rec"));
        newParDetails.setDateRec(Date.from(Instant.now()));
        newParDetails.setNameIss(request.getParameter("name_iss"));
        newParDetails.setPosIss(request.getParameter("pos_iss"));
        newParDetails.setOffIss(request.getParameter("off_iss"));
        newParDetails.setDateIss(Date.from(Instant.now()));
        
        String[] quantity = request.getParameterValues("quantity");
        String[] unit = request.getParameterValues("unit");
        String[] description = request.getParameterValues("description");
        String[] property_no = request.getParameterValues("property_num");
        String[] date_acq = request.getParameterValues("date_acquired");
        String[] amount = request.getParameterValues("amount");
        
        parDetailsFacade.create(newParDetails);
        
        for(int ctr = 0; ctr < quantity.length; ctr++){
            
            newParDetails.setQuantity(Integer.parseInt(quantity[ctr]));
            newParDetails.setUnit(unit[ctr]);
            newParDetails.setDescription(description[ctr]);
            newParDetails.setPropertyNo(Integer.parseInt(property_no[ctr]));
            
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
            Date stringDate;
            try {
                stringDate = df.parse(date_acq[ctr]);
                newParDetails.setDateAcq(stringDate);
            } catch (ParseException ex) {
                Logger.getLogger(CreatePO.class.getName()).log(Level.SEVERE, null, ex);
            }
            newParDetails.setAmount(Float.parseFloat(amount[ctr]));
            
            parDetailsFacade.create(newParDetails);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);
        
    }

}
