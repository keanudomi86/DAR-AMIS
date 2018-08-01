/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.*;
import controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "CreateForms", urlPatterns = {"/CreateForms"})
public class CreateForms extends BaseServlet {
    //create EJB injections for all your forms here
    //sample already provided, retrieving data in PR table
    @EJB
    private FormRepoFacade repoFacade = new FormRepoFacade();
    //end block
    
    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("formMode", "create");
        
        //retireve form data here
        ArrayList<FormRepo> forms = new ArrayList<FormRepo>(repoFacade.findAll());
        //end block
        
        //pass data to jsp page via request here
        request.setAttribute("forms", forms);
        //end block
        
        return "/create_forms.jsp";
    }

}
