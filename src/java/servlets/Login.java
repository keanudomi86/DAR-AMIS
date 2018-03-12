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
import java.util.ArrayList;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends BaseServlet {

    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();
    
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Employee e = null;
        ServletContext context;
        RequestDispatcher rd;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        ArrayList<Employee> employees = new ArrayList<Employee>(employeeFacade.findAll());
        
        //find the user
        for(Employee emp: employees){
            if(emp.getUsername().equals(username) && emp.getPassword().equals(password))
            e = emp;
        }
        
        
        HttpSession session = request.getSession();
        
        if(e != null){
            
            e.setPassword("");
            
            session.setAttribute("userData", e);
            
            if(e.getIdTier().getIdTier() == 1){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/dir_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 2){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/ap_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 3){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/gsdc_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 4){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/gsds_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 5){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/pcustodian_homepage.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 6){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/mgt_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 7){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/user_dashboard.jsp");
                rd.forward(request, response);
            }else if(e.getIdTier().getIdTier() == 8){
                context = request.getServletContext();
                rd = context.getRequestDispatcher("/rec_dashboard.jsp");
                rd.forward(request, response);
            }
                
        }else{
            try(PrintWriter out = response.getWriter()){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Incorrect email or password. Try again!');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }
        }
        
        
    }

}
