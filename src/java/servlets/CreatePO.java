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
        Po newPo = new Po();
        
        String msg = "Error. Try again.";
        
        System.out.println(request.getParameter("prID"));
        
        Pr pr = prFacade.find(Integer.parseInt(request.getParameter("prID")));
        
        newPo.setIdPr(pr);
        newPo.setSupplier("supplier");
        newPo.setDate(Date.from(Instant.now()));
        newPo.setAddress(request.getParameter("address"));
        newPo.setModeOfProc(request.getParameter("mode"));
        newPo.setTin((request.getParameter("tin")));
        newPo.setGentlemen(request.getParameter("gentlemen"));
        newPo.setPlaceOfDelivery(request.getParameter("place_delivery"));
        newPo.setModeOfProc2(request.getParameter("mode2"));
        
        String date_delivery = request.getParameter("date_delivery");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
        Date startDate;
        try {
            startDate = df.parse(date_delivery);
            newPo.setDateDelivery(startDate);
        } catch (ParseException ex) {
            newPo.setDateDelivery(Date.from(Instant.now()));
        }
        
        
        newPo.setPayTerm(request.getParameter("pay_term"));
        newPo.setAmountWords(request.getParameter("amount_words"));
        newPo.setNameConforme(request.getParameter("name_conforme"));
        newPo.setNameTruly(request.getParameter("name_truly"));
        
        String date_delivery2 = request.getParameter("date_delivery");
        Date newDate;
        try {
            newDate = df.parse(date_delivery2);
            newPo.setDateDelivery2(newDate);
        } catch (ParseException ex) {
            Logger.getLogger(CreatePO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        newPo.setPayTerm2(request.getParameter("payment_term"));
        
        
        String date_orsbus = request.getParameter("date_ors/burs");
        Date newDate2;
        try {
            newDate2 = df.parse(date_orsbus);
            newPo.setDateOrsburs(newDate2);
        } catch (ParseException ex) {
            newPo.setDateDelivery(Date.from(Instant.now()));
        }
        
        
        newPo.setNameReq(request.getParameter("name_req"));
        newPo.setAmount2(Float.parseFloat(request.getParameter("amount2")));
        
        poFacade.create(newPo);
        
        Po idPo = poFacade.find(newPo.getIdPo());
        newPoDetails.setIdPo(idPo);
        
        //newPoDetails.setIdPo(newPo);
        
        String[] stockno = request.getParameterValues("stock_no");
        
        String[] units = request.getParameterValues("unit");

        String[] descs = request.getParameterValues("description");

        String[] quantities = request.getParameterValues("quantity");

        String[] costs = request.getParameterValues("cost");
        
        String[] total = request.getParameterValues("total_cost");

        //since the above 4 are of same length, use any of them for loop count
        for(int ctr = 0; ctr < units.length; ctr++){
                newPoDetails.setStockNo(Integer.parseInt(stockno[ctr]));
                newPoDetails.setUnit(units[ctr]);
                newPoDetails.setDescription(descs[ctr]);

                if(quantities[ctr] != null)
                    newPoDetails.setQuantity(Integer.parseInt(quantities[ctr]));
                else
                    newPoDetails.setQuantity(0);

                if(costs[ctr] != null)
                    newPoDetails.setCost(Float.parseFloat(costs[ctr]));
                else
                    newPoDetails.setCost(0.0f);
                newPoDetails.setAmount(Float.parseFloat(total[ctr]));
                
                //poDetailsFacade.create(newPoDetails);
        }
        ArrayList<FormRepo> forms = new ArrayList<FormRepo>(repoFacade.findAll());
        
        FormRepo repoEntry = null;
        
        //find matching repo entry with prd
        for(FormRepo r: forms){
            if(r.getIdPr().getIdPr().equals(pr.getIdPr())){
                repoEntry = r;
            }
        }
        
        Employee emp = (Employee)session.getAttribute("userData");
        
        ArrayList<Employee> employees = new ArrayList<Employee>(employeeFacade.findAll());
        
        for(Employee curEmp: employees){
            if(emp.getUsername() == curEmp.getUsername()){
                emp = curEmp;
            }
        }
        
        repoEntry.setIdPo(idPo);
        
        repoFacade.edit(repoEntry);
        
        msg = "Success";
        
        generateTextResponse(response, msg);

    }

}
