/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.RisDetailsFacade;
import controller.RisFacade;
import dao.RisDetails;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error creating RIS Form. Try again.";
        
        RisDetails newRisDetails = new RisDetails();
        
        newRisDetails.setEnityName(request.getParameter("entity"));
        newRisDetails.setOffice(request.getParameter("office"));
        newRisDetails.setFundCluster(request.getParameter("fund_cluster"));
        newRisDetails.setDivision(request.getParameter("division"));
        newRisDetails.setResponsibility(request.getParameter("rcc"));
        newRisDetails.setPurpose(request.getParameter("purpose"));
        newRisDetails.setNameReq(request.getParameter("req_name"));
        newRisDetails.setDesignationReq(request.getParameter("designation"));
        newRisDetails.setDateReq(Date.from(Instant.now()));
        newRisDetails.setNameApp(request.getParameter("name_app"));
        newRisDetails.setDesignationApp(request.getParameter("designation_app"));
        newRisDetails.setDateApp(Date.from(Instant.now()));
        newRisDetails.setNameIssued(request.getParameter("name_issued"));
        newRisDetails.setDesignationIssued(request.getParameter("designation_issued"));
        newRisDetails.setDateIssued(Date.from(Instant.now()));
        newRisDetails.setNameRec(request.getParameter("name_rec"));
        newRisDetails.setDesignation(request.getParameter("designation_rec"));
        newRisDetails.setDateRec(Date.from(Instant.now()));
        
        risDetailsFacade.create(newRisDetails);
        
        String[] units = request.getParameterValues("unit");
        String[] descs = request.getParameterValues("description");
        String[] req_quantity = request.getParameterValues("req_quantity");
        String[] stock_avail = request.getParameterValues("stock_avail");
        String[] issued_quantity = request.getParameterValues("issuance_quantity");
        String[] remarks = request.getParameterValues("remarks");
        
        for(int ctr = 0; ctr < units.length; ctr++){
            
            
            newRisDetails.setUnit(units[ctr]);
            newRisDetails.setDescription(descs[ctr]);
            newRisDetails.setReqQuantity(Integer.parseInt(req_quantity[ctr]));
            newRisDetails.setStockAvail(Integer.parseInt(stock_avail[ctr]));
            newRisDetails.setIssuedQuantity(Integer.parseInt(issued_quantity[ctr]));
            newRisDetails.setRemarks(remarks[ctr]);
            
            
            risDetailsFacade.create(newRisDetails);
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);
    }

}
