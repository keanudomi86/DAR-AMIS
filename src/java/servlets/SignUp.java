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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Myles Mempin
 */

public class SignUp extends BaseServlet {
 //instantiate connection to db that will handle data manipulation for users table
    @EJB
    private final EmployeeFacade employeeFacade = new EmployeeFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //create new user
        Employee e = new Employee();
        
        //add some details
        e.setLastName(request.getParameter("last_name"));
        e.setFirstName(request.getParameter("first_name"));
        e.setMiddleInitial(request.getParameter("middle_initial"));
        e.setCivilStatus(request.getParameter("civil_status"));
        e.setGender(request.getParameter("gender"));
        e.setAddress(request.getParameter("address"));
        
        //for date input
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dob;
        try {
            dob = sdf.parse(request.getParameter("birthday"));
        } catch (ParseException ex) {
            dob = Date.from(Instant.now());
        }
        
        e.setDob(dob);
        
        e.setEmail(request.getParameter("email"));
        e.setMobileNum(request.getParameter("mobile_number"));
        e.setEmployeeStatus(request.getParameter("employment_status"));
        e.setUsername(request.getParameter("username"));
        e.setPassword(request.getParameter("password"));
        e.setUserActivated(0);
        
       employeeFacade.create(e);
        
        //retrieve new data
        //params in findByQuery: name of NamedQuery (look in respective dao 
        //java file, class of object to cast to list, search parameter, 
        //parameter value [can be any type of object depending on query] )
        ArrayList<Employee> users = new ArrayList<Employee>(employeeFacade.findAll());
        
        //output if there is any data found
        //set response to type 'text/plain'
        try(PrintWriter out = response.getWriter()){
          out.println("Servlet to test Java Persistence connection and data access");
          out.println();
          if(users.isEmpty()){
                out.println("No data in server. A DB error might have occured. Check server connection.");
            }else{
                out.println("Users found. Listing: \n");
                
                for(Employee user: users){
                    out.println("ID: " + user.getIdEmployee());
                    out.println("Username: " + user.getUsername());
                    out.println("Password: " + user.getPassword());
                    out.println("");
                }
            }
//        //update db entry
//        Employee updateUser = users.get(users.size() - 1);
//        
//        updateUser.setUsername("kjdomi");
//        
//        employeeFacade.edit(updateUser);
//        
//        out.println("Testing entry update");
//        out.println();
//        if(users.isEmpty()){
//              out.println("No data in server. A DB error might have occured. Check server connection.");
//          }else{
//              out.println("Users found. Listing: \n");
//
//              for(Employee user: users){
//                  out.println("ID: " + user.getIdEmployee());
//                  out.println("Username: " + user.getUsername());
//                  out.println("Password: " + user.getPassword());
//                  out.println("");
//              }
//        }
        
//        //delete entry from database
//        employeeFacade.remove(e);
//        
//        //retrieve new data
//        //params in findByQuery: name of NamedQuery (look in respective dao 
//        //java file, class of object to cast to list, search parameter, 
//        //parameter value [can be any type of object depending on query] )
//        users = new ArrayList<Employee>(employeeFacade.findAll());
//        
//        out.println("Testing entry delete");
//          out.println();
//          if(users.isEmpty()){
//                out.println("No data in server. A DB error might have occured. Check server connection.");
//            }else{
//                out.println("Users found. Listing: \n");
//                
//                for(Employee user: users){
//                    out.println("ID: " + user.getIdEmployee());
//                    out.println("Username: " + user.getUsername());
//                    out.println("Password: " + user.getPassword());
//                    out.println("");
//                }
//            }
//        
//        }
        }
        
        
        
    }
    }
