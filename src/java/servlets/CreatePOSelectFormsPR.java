/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.*;
import dao.FormRepo;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.persistence.logging.SessionLog.EJB;

/**
 *
 * @author BavarianHotdog
 */
@WebServlet(name = "CreatePOSelectFormsPR", urlPatterns = {"/CreatePOSelectFormsPR"})
public class CreatePOSelectFormsPR extends BaseServlet {
    
    @EJB
    private FormRepoFacade formrepoFacade = new FormRepoFacade();
    
    @Override
    public String servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<FormRepo> forms = new ArrayList<FormRepo>(formrepoFacade.findAll());
        
        Iterator<FormRepo> formIter = forms.iterator();
        
        while(formIter.hasNext()){
            FormRepo curItem = formIter.next();
            
            if(curItem.getIdPr() == null || curItem.getIdPo() != null){
                formIter.remove();
            }
        }
        
        System.out.println(forms.size());
        
        request.setAttribute("forms", forms);
        request.setAttribute("link", request.getContextPath() + "/POPage?pr_id=");
        request.setAttribute("mode", "create_po");
        
        return "/formrepo.jsp";
        
    }

}
