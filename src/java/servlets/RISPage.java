/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.OfficeFacade;
import dao.Office;
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

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "RISPage", urlPatterns = {"/RISPage"})
public class RISPage extends BaseServlet {
    
    @EJB
    private OfficeFacade officeFacade = new OfficeFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Office> offices = new ArrayList<Office>(officeFacade.findAll());
        request.setAttribute("offices", offices);
        
        return "/ris.jsp";
        
    }

}
