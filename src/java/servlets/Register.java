/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.DivisionFacade;
import controller.EmployeeFacade;
import dao.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.BaseServlet;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends BaseServlet {

    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();
    
    @EJB
    private final DivisionFacade divFacade = new DivisionFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int registerSuccessful = 0, usernameExists = 0;
        Employee e = new Employee();
        
        if(!request.getParameter("pass1").equals(request.getParameter("pass2"))){
            try(PrintWriter out = response.getWriter()){
                out.println("Password inputs do not match. Please go back and try again.");
            }
        }else{
            //add some details
            e.setLastName(request.getParameter("lastname"));
            e.setFirstName(request.getParameter("firstname"));
            e.setMiddleInitial(request.getParameter("middlename"));
            e.setCivilStatus(request.getParameter("civilstatus"));
            e.setGender(request.getParameter("gender"));
            e.setAddress(request.getParameter("address"));
            e.setEmail(request.getParameter("email"));
            e.setMobileNum(request.getParameter("cellno"));
            e.setEmployeeStatus(request.getParameter("empstatus"));
            
            //first token of StringTokenizer is division id
            int divId = Integer.parseInt(new StringTokenizer(request.getParameter("division"), "- ").nextToken());
            
            e.setIdDivision(divFacade.find(divId));

            ArrayList<Employee> employees = new ArrayList<Employee>(employeeFacade.findAll());
            
            for(Employee emp: employees){
                if(emp.getUsername().equals(request.getParameter("username"))){
                    usernameExists = 1;
                }
            }
            
            if(usernameExists == 0)
                e.setUsername(request.getParameter("username"));
            else{
                 try(PrintWriter out = response.getWriter()){
                    response.setContentType("text/html");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>User registration</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>Username already exists. Go back and try again.");
                    out.println("</body>");
                    out.println("</html>");
                 }
            }
            e.setPassword(request.getParameter("pass1"));


            //for date input
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dob;
            try {
                dob = sdf.parse(request.getParameter("birthday"));
            } catch (ParseException ex) {
                dob = Date.from(Instant.now());
            }

            e.setDob(dob);
            e.setUserActivated(0);
            
            employeeFacade.create(e);

            ArrayList<Employee> users = new ArrayList<Employee>(employeeFacade.findAll());

            try(PrintWriter out = response.getWriter()){
                if(users.isEmpty()){
                    out.println("No data in server. A DB error might have occured. Check server connection.");
                }else{
                    for(Employee user: users){
                        if(user.getUsername().equals(e.getUsername()) &&
                                user.getPassword().equals(e.getPassword())){
                            registerSuccessful = 1;

                        }
                    }
                }

                if(registerSuccessful == 1){
                    response.setContentType("text/html");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>User registration</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>User registration successful. please click <a href = \"./index.jsp\">here</a> to return to home page</h3>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
        return "?";
    }
    

}
