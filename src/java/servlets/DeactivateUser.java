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
@WebServlet(name = "DeactivateUser", urlPatterns = {"/DeactivateUser"})
public class DeactivateUser extends BaseServlet {

    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();
    

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error deactivating user. Try again later.";
        
        int empID = 0; 
        
        if(request.getParameter("id")!= null)
            empID = Integer.parseInt(request.getParameter("id"));
        
        
        if(empID != 0){
            Employee emp = employeeFacade.find(empID);
            
            if(emp != null){
                emp.setUserActivated(0);
                
                employeeFacade.edit(emp);
                
                msg = "Deactivation successful.";
            }
            
        }
        
        generateTextResponse(response, msg);
    }

}
