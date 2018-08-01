/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.IarDetailsFacade;
import controller.IarFacade;
import dao.Iar;
import dao.IarDetails;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreateIAR", urlPatterns = {"/CreateIAR"})
public class CreateIAR extends BaseServlet {

    @EJB
    private IarFacade iarFacade = new IarFacade();

    @EJB
    private IarDetailsFacade iarDetailsFacade = new IarDetailsFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Iar newIar = new Iar();
        IarDetails newIarDetails = new IarDetails();

        newIar.setEntityName("");
        newIar.setRisNo(Integer.SIZE);
        newIar.setFundCluster("");
        newIar.setRisDate(null);
        newIar.setSupplier("");
        newIar.setInvoiceNo(Integer.MIN_VALUE);
        newIar.setPoNo(Integer.SIZE);
        newIar.setInvoiceDate(null);
        newIar.setDateInspected(null);
        newIar.setRequisitioningDept("");
        newIar.setResponsibilityCode("");
        newIar.setDateInspected(null);
        newIar.setVerified(Short.MIN_VALUE);
        newIar.setInspectionCommittee(null);
        newIar.setDateReceived(null);
        newIar.setComplete(Short.MIN_VALUE);
        newIar.setPartial(Short.MIN_VALUE);
        newIar.setSpecificQuantity(Integer.MIN_VALUE);
        newIar.setSupplyOfficer("");

        iarFacade.create(newIar);

        String[] stockno = request.getParameterValues("stock_no");

        String[] descs = request.getParameterValues("description");

        String[] unit = request.getParameterValues("unit");

        String[] quantity = request.getParameterValues("quantity");

        for (int ctr = 0; ctr < stockno.length; ctr++) {
            newIarDetails.setStockNo(Integer.parseInt(stockno[ctr]));
            newIarDetails.setUnit(unit[ctr]);
            newIarDetails.setDescription(descs[ctr]);

            if (quantity[ctr] != null) {
                newIarDetails.setQuantity(Integer.parseInt(quantity[ctr]));
            } else {
                newIarDetails.setQuantity(0);
            }

            iarDetailsFacade.create(newIarDetails);
        }

        //url or msg
        return "";
    }

}
