/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.UserActions;
import BussinessLayer.Impl.UserOrderItem;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tmsModelLayer.Item;

/**
 *
 * @author cstuser
 */
public class OrderAction extends HttpServlet {
 UserOrderItem setClient_order=new UserOrderItem();
  ArrayList<Item> orderItem=new ArrayList();
  UserActions prov;
  UserActions Carr;
   
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
         if(request.getParameter("feedbackbutton")!=null){ 
            out.println("<h1>Servlet OrderAction at " + request.getContextPath() + "</h1>");
            out.println("<h1>weight is=" +request.getParameter("weightcost") + "</h1>");
            out.println("<h1>WValue is=" +request.getParameter("valuecost")+ "</h1>");
            out.println("<h1>Wtinme is=" + request.getParameter("weighttime")+ "</h1>");
            out.println("<h1>TimeValue is=" + request.getParameter("valuetime") + "</h1>");
                 
             out.println("<h1>WNOD is=" +request.getParameter("weightnod") + "</h1>");
             out.println("<h1>NODValue is=" + request.getParameter("valuenod") + "</h1>");
         }
              
           if(request.getParameter("orderbtn")!=null){
            for(int i=0;i<2;i++){
            out.println("<p> order:"+orderItem.get(i).getItemcategory()+"//"+orderItem.get(i).getItemqty()+
                    "//"+orderItem.get(i).getOrderId()+"//"+orderItem.get(i).getItemvolume()+"//"+orderItem.get(i).getItemprice()+
                    "//"+orderItem.get(i).getItemDesc()+
                    "</p>");
            }
             out.println("<h1>ordercost is=" +request.getParameter("item1price") + "</h1>");
               out.println("<h1>ordercost is=" +request.getParameter("item2price") + "</h1>");
            
            out.println("<h1>radiobtn is=" +request.getParameter("radiobtn") + "</h1>");
            out.println("<h1>Transport  is=" +request.getParameter("transportType") + "</h1>");
                out.println("<h1>Departure  is=" +request.getParameter("departure") + "</h1>");
           }
           
           if(request.getParameter("confirmbtn")!=null){         
             out.println("<h1>orderid is  is=" +request.getParameter("orderconf") + "</h1>");
              }
           
           
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
       
        
        
         //////////////////////////////////////client order Action  ////////////////////////////////////////////// //
        if(request.getParameter("orderbtn")!=null){
        //client_info
        int clientId=Integer.parseInt(request.getParameter("client_id"));
        //GPS value
        String departure=request.getParameter("departure");
        String destination=request.getParameter("destination");
       
    
         int cosiderid =Integer.parseInt(request.getParameter("radiobtn"));
         int clinetTransid =Integer.parseInt(request.getParameter("transportType")); 
         if(clinetTransid==0)
             clinetTransid=6;
        
       for(int i=1;i<3;i++){
           String cat,itemdes,itemqty,itemvol,itemweight,itemcost;
           cat="item"+i+"category";itemdes="item"+i+"desc";
           itemqty="item"+i+"qty";itemvol="item"+i+"volume";
           itemweight="item"+i+"weight";
           itemcost="item"+i+"price";
           Item record=new Item();
           record.setItemcategory(Integer.parseInt(request.getParameter(cat)));
          record.setItemDesc(request.getParameter(itemdes));          
           record.setItemqty(Integer.parseInt(request.getParameter(itemqty)));
           record.setItemweight(Double.parseDouble(request.getParameter(itemweight)));
           record.setItemvolume(Integer.parseInt(request.getParameter(itemvol)));
           record.setItemprice(Double.parseDouble(request.getParameter(itemcost)));
           orderItem.add(record);
       }
        //item1
        setClient_order.setClientOrder(clientId,2,10, departure, destination,orderItem,cosiderid,clinetTransid);
        }//end of placing an order
        
          if(request.getParameter("feedbackbutton")!=null){ 
            int weightcost= Integer.parseInt(request.getParameter("weightcost"));
            int valuecost= Integer.parseInt(request.getParameter("valuecost"));
            
             int weighttime= Integer.parseInt(request.getParameter("weighttime"));
            int valuetime= Integer.parseInt(request.getParameter("valuetime"));
            
             int weightnod= Integer.parseInt(request.getParameter("weightnod"));
            int valuenod= Integer.parseInt(request.getParameter("valuenod"));
           
           
          }//end of feedback
          
          
         //////////////////////////////////////end of clien action//////////////////////////////////////////////
          
          
          //////////////////////////////////////provider actions//////////////////////////////////////////////
          
          if(request.getParameter("confirmbtn")!=null){           
                prov=new UserActions();        
                int orderid=Integer.parseInt(request.getParameter("orderconf"));
                int carrierid=Integer.parseInt(request.getParameter("carrier"));
                if(carrierid!=0)
                 prov.confirmOrder(orderid,carrierid);
              else
                prov.cancelOrder(orderid);           
               response.sendRedirect("provider.jsp");
               }
          
         //////////////////////////////////////end of provider action//////////////////////////////////////////////
          
          
         //////////////////////////////////////carrier actions//////////////////////////////////////////////
       if(request.getParameter("shipmentbtn")!=null){  
          Carr=new UserActions();        
       int orderid=Integer.parseInt(request.getParameter("ordership"));
       int driverid=Integer.parseInt(request.getParameter("Driver"));
       if(driverid!=0)
           Carr.shipOrder(orderid,driverid);
       else
          Carr.noDriver(orderid);
    
        response.sendRedirect("carrier.jsp");
       } 
          //////////////////////////////////////end of carrier action////////////////////////////////////////////// 
          
          
        processRequest(request, response);
    }
   
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
