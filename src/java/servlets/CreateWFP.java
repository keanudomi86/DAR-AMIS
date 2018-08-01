/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FormRepoFacade;
import controller.WfpDetailsFacade;
import controller.WfpFacade;
import dao.Employee;
import dao.Wfp;
import dao.WfpDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
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
@WebServlet(name = "CreateWFP", urlPatterns = {"/CreateWFP"})
public class CreateWFP extends BaseServlet {

    @EJB
    private FormRepoFacade formRepoFacade = new FormRepoFacade();

    @EJB
    private WfpDetailsFacade wfpDetailsFacade = new WfpDetailsFacade();

    @EJB
    private WfpFacade wfpFacade = new WfpFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee user = (Employee) request.getSession().getAttribute("userData");
        Wfp newWfp = new Wfp();
        WfpDetails[] newWfpDetails = new WfpDetails[request.getParameterValues("q1").length];
        List<WfpDetails> details;
        int wfpID;

        String[] strobj = request.getParameterValues("obj");
        String[] strq1 = request.getParameterValues("q1");
        String[] strq2 = request.getParameterValues("q2");
        String[] strq3 = request.getParameterValues("q3");
        String[] strq4 = request.getParameterValues("q4");
        String[] strtb = request.getParameterValues("total_qty");
        try {
            //add wfp data
            if (wfpFacade.findAll().size() > 0) {
                wfpID = wfpFacade.findAll().
                        get(wfpFacade.findAll().size() - 1).getIdWfp();
                newWfp.setIdWfp(wfpID);
            } else {
                wfpID = 1;
            }

            newWfp.setIdOffice(user.getIdDivision().getIdOffice());

            //put data in wfpdetails object
            for (int ctr = 0; ctr < strq1.length; ctr++) {
                newWfpDetails[ctr] = new WfpDetails();
                //put data storage logic here
                //add wfp data also
            }

        } catch (Exception e) {
            String msg = "Error in adding data to database.";

            e.printStackTrace();

            generateTextResponse(response, msg);
        }

        try {

            for (int ctr = 0; ctr < strq1.length; ctr++) {

                int idDetails = wfpDetailsFacade.findAll().size() + 1;

                newWfpDetails[ctr].setIdWfpDetails(idDetails);

                newWfpDetails[ctr].setIdWfp(newWfp);
                newWfpDetails[ctr].setObjectExp(strobj[ctr]);
                newWfpDetails[ctr].setQ1(Double.parseDouble(strq1[ctr]));
                newWfpDetails[ctr].setQ2(Double.parseDouble(strq2[ctr]));
                newWfpDetails[ctr].setQ3(Double.parseDouble(strq3[ctr]));
                newWfpDetails[ctr].setQ4(Double.parseDouble(strq4[ctr]));
                newWfpDetails[ctr].setTotalQty(Double.parseDouble(strtb[ctr]));

            }

            newWfp.setWfpDetailsList(Arrays.asList(newWfpDetails));

            //pass to server
            wfpFacade.create(newWfp);
            return "Data sucessfully added.";

        } catch (Exception e) {

            e.printStackTrace();
            return "Error in adding data to database.";
        }

    }

}
