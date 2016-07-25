/*
 This servlet gets information from Client page and it senthisizes the clinet's request data.
 Then It calls set clientorder method in order to update order table . Also, it send a message to provider 
  and notified them about new clinet request.
 
 */
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.UserOrderItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omid
 */
public class Client_orderServlet extends HttpServlet {
 UserOrderItem setClient_order=new UserOrderItem();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Client_orderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Client_orderServlet at " + request.getContextPath() + "</h1>");
          
            out.println("<h1>item2cat id is=" +request.getParameter("item2category") + "</h1>");
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
        //client_info
        int clientId=Integer.parseInt(request.getParameter("client_id"));
        //GPS value
        String departure=request.getParameter("departure");
        String destination=request.getParameter("destination");
        //KPI consideration 1
        String KPI=request.getParameter("KPI");
        String speed=request.getParameter("speed");
        String cost=request.getParameter("cost");
        String NumOfReq=request.getParameter("NumOfReq");
       String transportType=request.getParameter("transportType");
       setClient_order.setClientOrder(clientId,2,10, departure, destination);
        //item1
        String item1category=request.getParameter("item1category");
        String item1desc=request.getParameter("item1desc");
        String item1qty=request.getParameter("item1qty");
        String item1volume=request.getParameter("item1volume");
        String item1weight=request.getParameter("item1weight");
        
        //item2
        String item2category=request.getParameter("item2category");
        String item2desc=request.getParameter("item2desc");
        String item2qty=request.getParameter("item2qty");
        String item2volume=request.getParameter("item2volume");
        String item2weight=request.getParameter("item2weight");
      
        //item3
        String item3category=request.getParameter("item3category");
        String item3desc=request.getParameter("item3desc");
        String item3qty=request.getParameter("item3qty");
        String item3volume=request.getParameter("item3volume");
        String item3weight=request.getParameter("item3weight");
        
        //item4
        String item4category=request.getParameter("item4category");
        String item4desc=request.getParameter("item4desc");
        String item4qty=request.getParameter("item4qty");
        String item4volume=request.getParameter("item4volume");
        String item4weight=request.getParameter("item4weight");
        
         //item5
        String item5category=request.getParameter("item5category");
        String item5desc=request.getParameter("item5desc");
        String item5qty=request.getParameter("item5qty");
        String item5volume=request.getParameter("item5volume");
        String item5weight=request.getParameter("item5weight");
        
        processRequest(request, response);
    }
   
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
