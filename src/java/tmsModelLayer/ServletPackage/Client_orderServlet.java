/*
 This servlet gets information from Client page and it senthisizes the clinet's request data.
 Then It calls set clientorder method in order to update order table . Also, it send a message to provider 
  and notified them about new clinet request.
 
 */
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.UserOrderItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tmsModelLayer.Item;

/**
 *
 * @author omid
 */
public class Client_orderServlet extends HttpServlet {
 UserOrderItem setClient_order=new UserOrderItem();
  ArrayList<Item> orderItem=new ArrayList();
   
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
            for(int i=0;i<5;i++){
            out.println("<p> order:"+orderItem.get(i).getItemcategory()+"//"+orderItem.get(i).getItemqty()+
                    "//"+orderItem.get(i).getOrderId()+"//"+orderItem.get(i).getItemvolume()+"//"+orderItem.get(i).getItemprice()+
                    "//"+orderItem.get(i).getItemDesc()+
                    "</p>");
            }
            out.println("<h1>radiobtn id is=" +request.getParameter("radiobtn") + "</h1>");
            out.println("<h1>Transport id is=" +request.getParameter("transportType") + "</h1>");
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
        int considerid=Integer.parseInt(request.getParameter("radiobtn"));
        int trasportid=Integer.parseInt(request.getParameter("transportType"));
              
       for(int i=1;i<6;i++){
           String cat,itemdes,itemqty,itemvol,itemweight,itemcost;
           cat="item"+i+"category";itemdes="item"+i+"desc";
           itemqty="item"+i+"qty";itemvol="item"+i+"volume";
           itemweight="item"+i+"weight";
           itemcost="item"+i+"cost";
           Item record=new Item();
           record.setItemcategory(Integer.parseInt(request.getParameter(cat)));
          record.setItemDesc(request.getParameter(itemdes));
           record.setItemprice(100.00);
           record.setItemqty(Integer.parseInt(request.getParameter(itemqty)));
           record.setItemweight(Double.parseDouble(request.getParameter(itemweight)));
           record.setItemvolume(Integer.parseInt(request.getParameter(itemvol)));
           record.setItemprice(Double.parseDouble(request.getParameter(itemcost)));
           orderItem.add(record);
       }
        //item1
        setClient_order.setClientOrder(clientId,2,10, departure, destination,orderItem);
        
        processRequest(request, response);
    }
   
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
