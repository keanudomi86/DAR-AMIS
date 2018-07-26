/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.RfiDeliveriesFacade;
import controller.RfiFacade;
import controller.RfiFkFacade;
import controller.RfiRepairPostFacade;
import dao.Employee;
import dao.FormRepo;
import dao.Rfi;
import dao.RfiDeliveries;
import dao.RfiFk;
import dao.RfiRepairPost;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Myles Mempin
 */
@WebServlet(name = "CreateRFI", urlPatterns = {"/CreateRFI"})
public class CreateRFI extends BaseServlet {

    @EJB
    private RfiFacade rfiFacade = new RfiFacade();
    
    @EJB
    private RfiDeliveriesFacade rfiDeliveriesFacade = new RfiDeliveriesFacade();
    
    @EJB
    private RfiFkFacade rfiFkFacade =  new RfiFkFacade();

    @EJB
    private RfiRepairPostFacade rfiRepairPostFacade = new  RfiRepairPostFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        String msg = "Error creating RFI Form. Try again.";
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Rfi newRfi = new Rfi();
        RfiDeliveries newRfiDeliveries = new RfiDeliveries();
        RfiFk newRfiFk = new RfiFk();
        RfiRepairPost newRfiRepairPost = new RfiRepairPost();
        Employee emp = (Employee)session.getAttribute("userData");
        
        
        
        newRfi.setTypeInspection(request.getParameter("type_of_inspection"));
        newRfi.setTypeRepair(request.getParameter("type_of_repair"));
        newRfi.setTypeProperty(request.getParameter("type_of_property"));
        newRfi.setDescModel(request.getParameter("model"));
        newRfi.setDescEngineNo(Integer.parseInt(request.getParameter("engine_no")));
        newRfi.setDescPlateNo(request.getParameter("plate_no"));
        newRfi.setDescDefectsComplaintsScope(request.getParameter("scope"));
        newRfi.setDescEndUser(request.getParameter("end_user"));
        newRfi.setDescAmout(Float.parseFloat("amount"));
        newRfi.setDescAttachmentsPreRepair(Short.MAX_VALUE);
        newRfi.setDescAttachmentsPostRepair(Short.MAX_VALUE);
        newRfi.setDeliveriesSupplier(request.getParameter("supplier"));
        newRfi.setDeliveriesInvoiceNo(Integer.parseInt("invoice_no"));
        newRfi.setDeliveriesDrNo(Integer.parseInt("dr_no"));
        newRfi.setDeliveriesPrNo(Integer.parseInt("pr_no"));
        newRfi.setDeliveriesEndUser(request.getParameter("end_user_office"));
        newRfi.setDeliveriesAmount(Float.parseFloat("amount_2"));
        
        
        
            FormRepo newEntry = new FormRepo();
            
            newEntry.setIdRfi(newRfi);
            
            rfiFacade.create(newRfi);
            
            msg = "Success.";
        
    }

}
