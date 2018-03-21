/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.EmployeeFacade;
import controller.TierFacade;
import dao.Employee;
import dao.Tier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "ManageAccounts", urlPatterns = {"/ManageAccounts"})
public class ManageAccounts extends BaseServlet {

    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade(); 
    
    @EJB
    private final TierFacade tierFacade = new TierFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = new ArrayList<Employee>(employeeFacade.findAll());
        ArrayList<Tier> tiers = new ArrayList<Tier>(tierFacade.findAll());
        
        for(Employee e: employees){
            e.setPassword("");
        }
        
        Iterator<Employee> empIter = employees.iterator();
        
        HttpSession session = request.getSession();
        
        Employee curUser = (Employee) session.getAttribute("userData");
        
        while(empIter.hasNext()){
            if(curUser != null && (empIter.next().getIdTier().getIdTier() < curUser.getIdTier().getIdTier())){
                empIter.remove();
            }
        }
        
        empIter = employees.iterator();
        while(empIter.hasNext()){
            if(empIter.next().getUserActivated() == 0){
                empIter.remove();
            }
        }
        
        request.setAttribute("employees", employees);
        request.setAttribute("tiers", tiers);
        
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        rd = context.getRequestDispatcher("/change_usertier.jsp");
        rd.forward(request, response);
        
    }
    

}
