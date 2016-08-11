/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.UserActions;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cstuser
 */
public class carrierActionServlet extends HttpServlet {

   UserActions Carr;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet carrierActionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet carrierActionServlet at " + request.getContextPath() + "</h1>");
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
        
        
          Carr=new UserActions();
        
       int orderid=Integer.parseInt(request.getParameter("ordership"));
       int driverid=Integer.parseInt(request.getParameter("Driver"));
       if(driverid!=0)
           Carr.shipOrder(orderid,driverid);
       else
          Carr.noDriver(orderid);
    
   response.sendRedirect("carrier.jsp");
        
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
