/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.EmployeeFacade;
import dao.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**

}

 *
 * @author BavarianHotdog
 */
@WebServlet(name = "DeleteUser", urlPatterns = {"/DeleteUser"})
public class DeleteUser extends BaseServlet {
    
    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Error activating user. Try again later.";
        
        int empID = 0;
        
        if(request.getParameter("id")!= null)
            empID = Integer.parseInt(request.getParameter("id"));
        
        if(empID != 0){
            Employee emp = employeeFacade.find(empID);
            
            employeeFacade.remove(emp);
            msg = "Deletion successful.";
        }
        
        generateTextResponse(response, msg);
    }

}