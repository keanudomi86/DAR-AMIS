/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.RisDetailsFacade;
import controller.RisFacade;
import dao.Ris;
import dao.RisDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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
@WebServlet(name = "CreateRIS", urlPatterns = {"/CreateRIS"})
public class CreateRIS extends BaseServlet {
    @EJB
    private RisFacade risFacade = new RisFacade();
    
    @EJB
    private RisDetailsFacade risDetailsFacade = new RisDetailsFacade();
    
    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error creating RIS Form. Try again.";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        Ris newRis = new Ris();
        RisDetails newRisDetails = new RisDetails();
        
        newRis.setEntityName(request.getParameter("entity"));
        newRis.setRisNo(Integer.parseInt(request.getParameter("ris_no")));
        newRis.setOffice(request.getParameter("office"));
        newRis.setFundCluster(request.getParameter("fund_cluster"));
        newRis.setDivision(request.getParameter("division"));
        newRis.setResponsibilityCode(request.getParameter("responsibility_code"));
        newRis.setPurpose(request.getParameter("purpose"));
        newRis.setRequestedName(request.getParameter("name_req"));
        newRis.setRequestedDesignation(request.getParameter("designation_req"));
        
        String req_date = request.getParameter("date_req");
        Date newDate;
        try {
            newDate = df.parse(req_date);
            newRis.setRequestedDate(newDate);
        } catch (ParseException ex) {
            newRis.setRequestedDate(Date.from(Instant.now()));
        }
        
        newRis.setApprovedName(request.getParameter("name_app"));
        newRis.setApprovedDesgination(request.getParameter("designation_app"));
        
        String app_date = request.getParameter("date_app");
        Date newDate2;
        try {
            newDate2 = df.parse(app_date);
            newRis.setApprovedDate(newDate2);
        } catch (ParseException ex) {
            newRis.setApprovedDate(Date.from(Instant.now()));
        }
        
        newRis.setIssuedName(request.getParameter("name_issued"));
        newRis.setIssuedDesignation(request.getParameter("designation_issued"));
        
        String issued_date = request.getParameter("date_issued");
        Date newDate3;
        try {
            newDate3 = df.parse(issued_date);
            newRis.setIssuedDate(newDate3);
        } catch (ParseException ex) {
            newRis.setIssuedDate(Date.from(Instant.now()));
        }
        
        newRis.setReceivedName(request.getParameter("name_rec"));
        newRis.setReceivedDesignation(request.getParameter("designation_rec"));
        
        String rec_date = request.getParameter("date_rec");
        Date startDate4;
        try {
            startDate4 = df.parse(req_date);
            newRis.setReceivedDate(startDate4);
        } catch (ParseException ex) {
            newRis.setReceivedDate(Date.from(Instant.now()));
        }
        
        risFacade.create(newRis);
        
        String[] stockno = request.getParameterValues("stock_no");
        String[] units = request.getParameterValues("unit");
        String[] descs = request.getParameterValues("description");
        String[] req_quantity = request.getParameterValues("req_quantity");
        String[] stock_avail = request.getParameterValues("stock_avail");
        String[] issued_quantity = request.getParameterValues("issuance_quantity");
        String[] remarks = request.getParameterValues("remarks");
        
        for(int ctr = 0; ctr < units.length; ctr++){
            
            newRisDetails.setStockNo(Integer.parseInt(stockno[ctr]));
            newRisDetails.setUnit(units[ctr]);
            newRisDetails.setDescription(descs[ctr]);
            newRisDetails.setReqQuantity(Integer.parseInt(req_quantity[ctr]));
            newRisDetails.setStockAvail(Integer.parseInt(stock_avail[ctr]));
            newRisDetails.setIssuedQuantity(Integer.parseInt(issued_quantity[ctr]));
            newRisDetails.setRemarks(remarks[ctr]);
            
            
            risDetailsFacade.create(newRisDetails);
        }
        
        return "/CreateForms";
    }

}
