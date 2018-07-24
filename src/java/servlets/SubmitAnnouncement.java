/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.AnnouncementsFacade;
import dao.Announcements;
import dao.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Myles Mempin
 */
@WebServlet(name = "SubmitAnnouncement", urlPatterns = {"/SubmitAnnouncement"})
public class SubmitAnnouncement extends BaseServlet {
    
    @EJB
    private AnnouncementsFacade announcementsFacade = new AnnouncementsFacade();

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Announcements a = new Announcements();
        HttpSession session = request.getSession();
        
        a.setSubject(request.getParameter("subject"));
        a.setAnnouncement(request.getParameter("announcement"));
        a.setAnnouncementBy((Employee)(session.getAttribute("userData")));
        a.setDatePosted(Date.from(Instant.now()));
        
        announcementsFacade.create(a);
        
        ArrayList<Announcements> announcements = new ArrayList<Announcements>(announcementsFacade.findAll());
        
        Announcements newAnnounce = null;
        
        for(Announcements announcement: announcements){
            if(announcement.getAnnouncementBy().equals(a.getAnnouncementBy()) &&
                    announcement.getAnnouncement().equals(a.getAnnouncement()) &&
                    announcement.getSubject().equals(a.getSubject()) &&
                    announcement.getDatePosted().equals(a.getDatePosted())){
                newAnnounce = announcement;
            }
        }
        
        ServletContext context = getServletContext();
        RequestDispatcher rd;
        
        if(newAnnounce != null){
            rd = context.getRequestDispatcher("/HomePage");
            rd.forward(request, response);
        }else{
            response.setContentType("text/plain");
            try(PrintWriter out = response.getWriter()){
                out.println("An error has occured. Please go back and try again later.");
            }
        }
        
        
    }
    
}
