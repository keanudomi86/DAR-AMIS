/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.AppDetailsFacade;
import controller.AppFacade;
import controller.FormRepoFacade;
import controller.OfficeFacade;
import dao.App;
import dao.AppDetails;
import dao.Employee;
import dao.Office;
import dao.Wfp;
import dao.WfpDetails;
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
@WebServlet(name = "CreateAPP", urlPatterns = {"/CreateAPP"})
public class CreateAPP extends BaseServlet {

    @EJB
    private FormRepoFacade formRepoFacade = new FormRepoFacade();

    @EJB
    private AppFacade appFacade = new AppFacade();

    @EJB
    private AppDetailsFacade appDetailsFacade = new AppDetailsFacade();

    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "Error";

        try {

            Employee user = (Employee) request.getSession().getAttribute("userData");
            App newApp = new App();
            List<AppDetails> appDetails;

            String[] itemSpecs = request.getParameterValues("itemspec");

            String[] q1 = request.getParameterValues("q1");

            String[] q2 = request.getParameterValues("q2");

            String[] q3 = request.getParameterValues("q3");

            String[] q4 = request.getParameterValues("q4");

            String[] totalqty = request.getParameterValues("tq");

            String[] price = request.getParameterValues("pt");

            String[] offices = request.getParameterValues("office");

            for (int ctr = 0; ctr < itemSpecs.length; ctr++) {
                appDetails = new ArrayList<>();

                int officeId = 0;

                StringTokenizer stok = new StringTokenizer(offices[ctr], "- ");

                officeId = Integer.parseInt(stok.nextToken());

                Office off = officeFacade.find(officeId);
                newApp.setIdOffice(off);

                AppDetails newAppDetails = new AppDetails();

                newApp.setItemSpecs(itemSpecs[ctr]);

                newAppDetails.setIdApp(newApp);
                newAppDetails.setIdOffice(officeId);
                newAppDetails.setItemSpec(itemSpecs[ctr]);
                newAppDetails.setQ1(Double.parseDouble(q1[ctr]));
                newAppDetails.setQ2(Double.parseDouble(q2[ctr]));
                newAppDetails.setQ3(Double.parseDouble(q3[ctr]));
                newAppDetails.setQ4(Double.parseDouble(q4[ctr]));
                newAppDetails.setTotalQty(Integer.parseInt(totalqty[ctr]));
                newAppDetails.setTotalPriceAfn(Double.parseDouble(price[ctr]));

                appDetails.add(newAppDetails);

                newApp.setAppDetailsList(appDetails);

                appFacade.create(newApp);

                msg = "Success";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return msg;

    }

}
