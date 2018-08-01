/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FormRepoFacade;
import controller.ParDetailsFacade;
import controller.ParFacade;
import dao.Employee;
import dao.FormRepo;
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
import javax.servlet.http.HttpSession;

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

    @EJB
    private FormRepoFacade formRepoFacade = new FormRepoFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Par newPar = new Par();
            ParDetails newParDetails = new ParDetails();
            Employee emp = (Employee) session.getAttribute("userData");

            newPar.setEntityName(request.getParameter("entity"));
            newPar.setFundCluster(request.getParameter("fund_cluster"));
            newPar.setPurpose(request.getParameter("purpose"));
            newPar.setReceivedName(request.getParameter("name_rec"));
            newPar.setReceivedPosition(request.getParameter("pos_rec"));

            //temporaroly use current logged in employee's 
            //office because logic has not been defined properly yet
            newPar.setReceivedOffice(emp.getIdDivision().getIdOffice());

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

            //parFacade.create(newPar);
            String[] quantity = request.getParameterValues("quantity");
            String[] unit = request.getParameterValues("unit");
            String[] description = request.getParameterValues("description");
            String[] property_no = request.getParameterValues("property_no");
            String[] date_acq = request.getParameterValues("acq_date");
            String[] amount = request.getParameterValues("amount");

            for (int ctr = 0; ctr < quantity.length; ctr++) {

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

                newParDetails.setIdPar(newPar);

                //parFacade.create(newPar);
                //create formrepo entry
                FormRepo newEntry = new FormRepo();

                newEntry.setIdPar(newPar);

                parFacade.create(newPar);

            }
            return "Success";
        } catch (Exception x) {
            System.err.println(x);
            return "Error creating PAR Form. Try again.";
        }

    }

}
