/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FormRepoFacade;
import controller.OfficeFacade;
import controller.PpmpDetailsFacade;
import controller.PpmpFacade;
import dao.Employee;
import dao.Office;
import dao.Employee;
import dao.Ppmp;
import dao.PpmpDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
@WebServlet(name = "CreatePPMP", urlPatterns = {"/CreatePPMP"})
public class CreatePPMP extends BaseServlet {
    
    @EJB
    private FormRepoFacade formRepoFacade = new FormRepoFacade();
    
    @EJB
    private PpmpFacade ppmpFacade = new PpmpFacade();
    
    @EJB
    private PpmpDetailsFacade ppmpDetailsFacade = new PpmpDetailsFacade();
    
    @EJB
    private OfficeFacade officeFacade =  new OfficeFacade();

        @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String msg = "Error";
        
        try{

            Employee user = (Employee)request.getSession().getAttribute("userData");
            Ppmp newPpmp = new Ppmp();
            List<PpmpDetails> ppmpDetails;

            String[] itemSpecs = request.getParameterValues("itemspec");

            String[] q1 = request.getParameterValues("q1");

            String[] q2 = request.getParameterValues("q2");

            String[] q3 = request.getParameterValues("q3");

            String[] q4 = request.getParameterValues("q4");

            String[] totalqty = request.getParameterValues("tq");

            String[] price = request.getParameterValues("pt");

            String[] offices = request.getParameterValues("office");


            for(int ctr = 0; ctr < itemSpecs.length; ctr++){
                    ppmpDetails = new ArrayList<>();

                    int officeId = 0;

                    StringTokenizer stok = new StringTokenizer(offices[ctr], "- ");

                    officeId = Integer.parseInt(stok.nextToken());

                    Office off = officeFacade.find(officeId);
                    newPpmp.setIdOffice(off);

                    PpmpDetails newPpmpDetails = new PpmpDetails();
                    
                    
                    newPpmpDetails.setItemSpec(itemSpecs[ctr]);
                    
                    newPpmpDetails.setIdPpmp(newPpmp);
                    newPpmpDetails.setIdOffice(officeId);
                    newPpmpDetails.setItemSpec(itemSpecs[ctr]);
                    newPpmpDetails.setQ1(Double.parseDouble(q1[ctr]));
                    newPpmpDetails.setQ2(Double.parseDouble(q2[ctr]));
                    newPpmpDetails.setQ3(Double.parseDouble(q3[ctr]));
                    newPpmpDetails.setQ4(Double.parseDouble(q4[ctr]));
                    newPpmpDetails.setTotalQty(Integer.parseInt(totalqty[ctr]));
                    newPpmpDetails.setTotalPriceAfn(Double.parseDouble(price[ctr]));

                    ppmpDetails.add(newPpmpDetails);

                    newPpmp.setPpmpDetailsList(ppmpDetails);

                    ppmpFacade.create(newPpmp);
                    
                    
                    
                    msg = "Success";
                }
        
        }catch(Exception e){
            e.printStackTrace();
            msg = "Error";
        }
        
        generateTextResponse(response, msg);
        
    }

    
    

}
