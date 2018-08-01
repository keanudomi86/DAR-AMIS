/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.AnnouncementsFacade;
import dao.Announcements;
import dao.Division;
import dao.Employee;
import dao.Tier;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
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
@WebServlet(name = "HomePage", urlPatterns = {"/HomePage"})
public class HomePage extends BaseServlet {

    @EJB
    private AnnouncementsFacade announcementsFacade = new AnnouncementsFacade();

    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Employee e = (Employee) (session.getAttribute("userData"));
        ServletContext context;
        RequestDispatcher rd;
        ArrayList<Announcements> announcements;

        if (e.getIdTier().getIdTier() == 1) {
            announcements = new ArrayList<Announcements>(announcementsFacade.findAll());

            session.setAttribute("announcements", announcements);
            for (int ctr = 0; ctr < announcements.size(); ctr++) {
                for (int ctr2 = ctr + 1; ctr2 < announcements.size(); ctr2++) {
                    if (announcements.get(ctr).getDatePosted().toInstant().getEpochSecond()
                            < announcements.get(ctr2).getDatePosted().toInstant().getEpochSecond()) {
                        Announcements temp = announcements.get(ctr2);
                        announcements.set(ctr2, announcements.get(ctr));
                        announcements.set(ctr, temp);
                    }
                }
            }

            return "/dir_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 2) {
            announcements = new ArrayList<Announcements>(announcementsFacade.findAll());
            for (int ctr = 0; ctr < announcements.size(); ctr++) {
                for (int ctr2 = ctr + 1; ctr2 < announcements.size(); ctr2++) {
                    if (announcements.get(ctr).getDatePosted().toInstant().getEpochSecond()
                            < announcements.get(ctr2).getDatePosted().toInstant().getEpochSecond()) {
                        Announcements temp = announcements.get(ctr2);
                        announcements.set(ctr2, announcements.get(ctr));
                        announcements.set(ctr, temp);
                    }
                }
            }

            session.setAttribute("announcements", announcements);

            return "/ap_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 3) {
            announcements = new ArrayList<Announcements>(announcementsFacade.findAll());

            session.setAttribute("announcements", announcements);
            for (int ctr = 0; ctr < announcements.size(); ctr++) {
                for (int ctr2 = ctr + 1; ctr2 < announcements.size(); ctr2++) {
                    if (announcements.get(ctr).getDatePosted().toInstant().getEpochSecond()
                            < announcements.get(ctr2).getDatePosted().toInstant().getEpochSecond()) {
                        Announcements temp = announcements.get(ctr2);
                        announcements.set(ctr2, announcements.get(ctr));
                        announcements.set(ctr, temp);
                    }
                }
            }

            return "/gsdc_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 4) {
            return "/gsds_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 5) {
            return "/pcustodian_homepage.jsp";
        } else if (e.getIdTier().getIdTier() == 6) {
            return "/mgt_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 7) {
            return "/user_dashboard.jsp";
        } else if (e.getIdTier().getIdTier() == 8) {
            return "/rec_dashboard.jsp";
        }
        return "errorrr";
    }

}
