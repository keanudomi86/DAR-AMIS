/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.EmployeeFacade;
import controller.TierFacade;
import dao.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends BaseServlet {

    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();
    
    @EJB
    private final TierFacade tierFacade = new TierFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error updating user. Try again later.";
        
        int empID = 0, posID = 0; 
        
        if(request.getParameter("id")!= null)
            empID = Integer.parseInt(request.getParameter("id"));
        
        if(request.getParameter("position")!= null)
            posID = Integer.parseInt(request.getParameter("position"));
        
        if(empID != 0 && posID != 0){
            Employee emp = employeeFacade.find(empID);
            
            if(emp != null){
                emp.setIdTier(tierFacade.find(posID));
                
                employeeFacade.edit(emp);
                
                msg = "Update successful.";
            }
            
        }
        
        generateTextResponse(response, msg);
    }

}
