/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.PoDetailsFacade;
import controller.PoFacade;
import dao.Po;
import dao.PoDetails;
import java.io.IOException;
import java.math.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
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
@WebServlet(name = "CreatePO", urlPatterns = {"/CreatePO"})
public class CreatePO extends BaseServlet {

    @EJB
    private PoFacade poFacade = new PoFacade();
    
    @EJB
    private PoDetailsFacade poDetailsFacade = new PoDetailsFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PoDetails newPoDetails = new PoDetails();
        
        newPoDetails.setEntity(request.getParameter("entity"));
        newPoDetails.setSupplier("supplier");
        newPoDetails.setDate(Date.from(Instant.now()));
        newPoDetails.setAddress(request.getParameter("address"));
        newPoDetails.setModeOfProc(request.getParameter("mode"));
        newPoDetails.setTin(new BigInteger(request.getParameter("tin")));
        newPoDetails.setGentlemen(request.getParameter("gentlemen"));
        newPoDetails.setPlaceDelivery(request.getParameter("place_delivery"));
        newPoDetails.setModeOfProc2(request.getParameter("mode2"));
        
        String date_delivery = request.getParameter("date_delivery");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date startDate;
        try {
            startDate = df.parse(date_delivery);
            newPoDetails.setDateDelivery(startDate);
        } catch (ParseException ex) {
            Logger.getLogger(CreatePO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        newPoDetails.setPayTerm(request.getParameter("pay_term"));
        newPoDetails.setAmountWords(request.getParameter("amount_words"));
        newPoDetails.setNameConforme(request.getParameter("name_conforme"));
        newPoDetails.setNameTruly(request.getParameter("name_truly"));
        
        String date_delivery2 = request.getParameter("date_delivery");
        Date newDate;
        try {
            newDate = df.parse(date_delivery2);
            newPoDetails.setDateDelivery2(newDate);
        } catch (ParseException ex) {
            Logger.getLogger(CreatePO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        newPoDetails.setPayTerm2(request.getParameter("payment_term"));
        
        
        String date_orsbus = request.getParameter("date_ors/burs");
        Date newDate2;
        try {
            newDate2 = df.parse(date_delivery2);
            newPoDetails.setDateOrsburs(newDate2);
        } catch (ParseException ex) {
            Logger.getLogger(CreatePO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        newPoDetails.setNameReq(request.getParameter("name_req"));
        newPoDetails.setAmount(Float.parseFloat(request.getParameter("amount")));
        
        poDetailsFacade.create(newPoDetails);
        
        ArrayList<Po> prList = new ArrayList<Po>(poFacade.findAll());
        
        for(Po po: prList){
            if(newPoDetails.getIdPoDetails() == po.getIdPo()){
                //newPoDetails = po;
            }
        }
        
        String[] units = request.getParameterValues("unit");
        String[] descs = request.getParameterValues("description");
        String[] quantities = request.getParameterValues("quantity");
        String[] costs = request.getParameterValues("cost");
        
        for(int ctr = 0; ctr < units.length; ctr++){
            PoDetails details = new PoDetails();
            
            //details.setIdPo(newPoDetails);
            details.setUnit(units[ctr]);
            details.setDescription(descs[ctr]);
            details.setQuantity(Integer.parseInt(quantities[ctr]));
            details.setCost(Float.parseFloat(costs[ctr]));
            
            poDetailsFacade.create(details);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);
    }

}
