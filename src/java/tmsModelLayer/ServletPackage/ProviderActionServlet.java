/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.ProviderAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cstuser
 */
public class ProviderActionServlet extends HttpServlet  {

    ProviderAction prov;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet </title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<h1>Servlet I am working on this requestt "+Integer.parseInt(request.getParameter("orderconf"))+"------"+Integer.parseInt(request.getParameter("carrier"))+" </h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        prov=new ProviderAction();
        
       int orderid=Integer.parseInt(request.getParameter("orderconf"));
       int carrierid=Integer.parseInt(request.getParameter("carrier"));
       if(carrierid!=0)
           prov.confirmOrder(orderid,carrierid);
       else
          prov.cancelOrder(orderid);
    
   response.sendRedirect("provider.jsp");
       
        processRequest(request, response);
        //returnOrder=new HashSet();
      // request.setAttribute("orders", returnOrder);
    //ServletContext app2 = getServletContext().getContext("tms");
    //RequestDispatcher rd;
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
