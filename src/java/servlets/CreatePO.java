/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.EmployeeFacade;
import controller.FormRepoFacade;
import controller.PoDetailsFacade;
import controller.PoFacade;
import controller.PrDetailsFacade;
import controller.PrFacade;
import dao.Employee;
import dao.FormRepo;
import dao.Po;
import dao.PoDetails;
import dao.Pr;
import dao.PrDetails;
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
import javax.servlet.http.HttpSession;

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
    
    @EJB
    private PrFacade prFacade = new PrFacade();
    
    @EJB
    private FormRepoFacade repoFacade = new FormRepoFacade();
    
    @EJB
    private EmployeeFacade employeeFacade = new EmployeeFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PoDetails newPoDetails = new PoDetails();
        Po po = new Po();
        Pr pr = prFacade.find(Integer.parseInt(request.getParameter("prID")));
        
        po.setIdPr(pr);
        
        poFacade.create(po);
        
        ArrayList<Po> pos = new ArrayList<Po>(poFacade.findAll());
        
        for(Po curPo: pos){
            if(curPo.getIdPr().equals(po.getIdPr())){
                po = curPo;
            }
        }
        
        newPoDetails.setIdPo(po);
        newPoDetails.setSupplier("supplier");
        newPoDetails.setDate(Date.from(Instant.now()));
        newPoDetails.setAddress(request.getParameter("address"));
        newPoDetails.setModeOfProc(request.getParameter("mode"));
        newPoDetails.setTin((request.getParameter("tin")));
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
            newPoDetails.setDateDelivery(Date.from(Instant.now()));
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
            newDate2 = df.parse(date_orsbus);
            newPoDetails.setDateOrsburs(newDate2);
        } catch (ParseException ex) {
            newPoDetails.setDateDelivery(Date.from(Instant.now()));
        }
        
        
        newPoDetails.setNameReq(request.getParameter("name_req"));
        newPoDetails.setAmount(Float.parseFloat(request.getParameter("total_cost")));
        
        poDetailsFacade.create(newPoDetails);
        
        FormRepo newRepoEntry = new FormRepo();
        
        newRepoEntry.setIdPo(po);
        
        Employee emp = (Employee)session.getAttribute("userData");
        
        ArrayList<Employee> employees = new ArrayList<Employee>(employeeFacade.findAll());
        
        for(Employee curEmp: employees){
            if(emp.getUsername() == curEmp.getUsername()){
                emp = curEmp;
            }
        }
        
        newRepoEntry.setCreatedBy(emp);
        
        repoFacade.create(newRepoEntry);
        
        
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/CreateForms");
        rd.forward(request, response);

    }

}
