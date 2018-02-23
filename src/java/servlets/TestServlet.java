/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.UserFacade;
import dao.EMFListener;
import dao.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BavarianHotdog
 * servlet to test java persistence entities
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends BaseServlet {
    
    //instantiate connection to db that will handle data manipulation for users table
    @EJB
    //private final UserFacade userFacade = new UserFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //create new user
        User u = new User();
        
        //add some details
        u.setUsername("newuser");
        u.setPassword("password");
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("DARAMISPU");
       System.out.println(emf.createEntityManager());
        //add new user to database
        //userFacade.create(u);
        
        //retrieve new data
        //params in findByQuery: name of NamedQuery (look in respective dao 
        //java file, class of object to cast to list, search parameter, 
        //parameter value [can be any type of object depending on query] )
        //ArrayList<User> users = (ArrayList<User>) userFacade.findByQuery("User.findByUsername", User.class, "username", "newuser");
        
        //output if there is any data found
        //set response to type 'text/plain'
        try(PrintWriter out = response.getWriter()){
            out.println("Servlet to test Java Persistence connection and data access");
            out.println();
       /*     if(users.isEmpty()){
                out.println("No data in server. A DB error might have occured. Check server connection.");
            }else{
                out.println("Users found. Listing: \n");
                
                for(User user: users){
                    out.println("Username: " + user.getUsername());
                    out.println("Password: " + user.getPassword());
                    out.println("");
                }
            }*/
        }
        
    }

    

}
