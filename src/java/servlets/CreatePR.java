/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.*;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "CreatePR", urlPatterns = {"/CreatePR"})
public class CreatePR extends BaseServlet {

    @EJB
    private PrFacade prFacade = new PrFacade();

    @EJB
    private PrDetailsFacade prDetailsFacade = new PrDetailsFacade();

    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();

    @EJB
    private FormRepoFacade formRepoFacade = new FormRepoFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error creating PR Form. Try again.";

        try {
            Pr newPr = new Pr();

            Office off = officeFacade.find(Integer.parseInt(new StringTokenizer(request.getParameter("office"), " -").nextToken()));

            newPr.setIdOffice(off);
            newPr.setDate(Date.from(Instant.now()));

            if (request.getParameter("fund_cluster") != null && !request.getParameter("fund_cluster").isEmpty()) {
                newPr.setFundCluster(request.getParameter("fund_cluster"));
            }

            if (request.getParameter("rcc") != null && !request.getParameter("rcc").isEmpty()) {
                newPr.setResponsibilityCenterCode(request.getParameter("rcc"));
            }

            if (request.getParameter("entity") != null && !request.getParameter("entity").isEmpty()) {
                newPr.setEntityName(request.getParameter("entity"));
            }

            prFacade.create(newPr);

            ArrayList<Pr> prList = new ArrayList<Pr>(prFacade.findAll());

            for (Pr pr : prList) {
                if (newPr.getIdOffice().getIdOffice().equals(pr.getIdOffice().getIdOffice()) && newPr.getDate().equals(pr.getDate())) {
                    newPr = pr;
                }
            }

            String[] entityName = request.getParameterValues("entity_name");
            String[] office = request.getParameterValues("office");
            String[] department = request.getParameterValues("department");
            String[] fundCluster = request.getParameterValues("fund_cluster");
            String[] rcc = request.getParameterValues("rcc");

            String[] stockNum = request.getParameterValues("stock_num");
            String[] units = request.getParameterValues("unit");

            String[] descs = request.getParameterValues("description");

            String[] quantities = request.getParameterValues("quantity");

            //String[] costs = request.getParameterValues("cost");
            String[] unitCost = request.getParameterValues("unitCost");
            String[] totalCost = request.getParameterValues("totalCost");
            String purpose = request.getParameter("purpose");
            String rqName = request.getParameter("rq_name");
            String rqDesig = request.getParameter("rq_desig"); //remember to rename parameter names accordingly
            //since the above 4 are of same length, use any of them for loop count
            for (int ctr = 0; ctr < units.length; ctr++) {
                PrDetails details = new PrDetails();
                details.setIdPr(newPr);
                details.setUnit(units[ctr]);
                details.setDescription(descs[ctr]);

                if (quantities[ctr] != null) {
                    details.setQuantity(Integer.parseInt(quantities[ctr]));
                } else {
                    details.setQuantity(0);
                }

                if (unitCost[ctr] != null) {
                    details.setUnitCost(Float.parseFloat(unitCost[ctr]));
                } else {
                    details.setUnitCost(0.0f);
                }

                if (totalCost[ctr] != null) {
                    details.setTotalCost(Float.parseFloat(totalCost[ctr]));
                } else {
                    details.setTotalCost(0.0f);
                }

                details.setPurpose(purpose);
                details.setRqDesig(rqDesig);
                details.setRqName(rqName);

                prDetailsFacade.create(details);
            }
            FormRepo newFormRepo = new FormRepo();

            newFormRepo.setIdPr(prFacade.find(newPr.getIdPr()));
            formRepoFacade.create(newFormRepo);
            return "From submission successful.";

        } catch (Exception a) {
            System.err.println(a);
            return msg;
        }

    }
}
