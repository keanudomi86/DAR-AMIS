/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.WfpDetailsFacade;
import dao.WfpDetails;
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
@WebServlet(name = "CreateWFP", urlPatterns = {"/CreateWFP"})
public class CreateWFP extends BaseServlet {
    
    @EJB
    private WfpDetailsFacade wfpDetailsFacade = new WfpDetailsFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       WfpDetails newWfpDetails = new WfpDetails();
       
       String[] strobj = request.getParameterValues("ob");
       String[] strq1 = request.getParameterValues("q1");
       String[] strq2 = request.getParameterValues("q2");
       String[] strq3 = request.getParameterValues("q3");
       String[] strq4 = request.getParameterValues("q4");
       
       /*for(int ctr = 0; ctr < strobj.length; ctr++){
           newWfpDetails.setExpandable("");
       }*/
    }

}
