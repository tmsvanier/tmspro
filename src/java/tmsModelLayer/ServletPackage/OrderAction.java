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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tmsModelLayer.Item;
import tmsModelLayer.Kpilog;

/**
 *
 * @author cstuser
 */
public class OrderAction extends HttpServlet {
 UserOrderItem setClient_order=new UserOrderItem();
 
  UserActions prov,Carr,clientFeedback,driv;
    
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
             out.println("<h1>gpsid is=" +request.getParameter("ordergpsid") + "</h1>");
             out.println("<h1>x is=" +request.getParameter("latitude") + "</h1>");
              out.println("<h1>y is=" +request.getParameter("longitude") + "</h1>");
         
         if(request.getParameter("feedbackbutton")!=null){ 
             
             
                long orderid= Long.parseLong(request.getParameter("idfeedback"));
              ArrayList<Kpilog> feedbackList=new ArrayList(); 
             //set 1st item fro kpi
              Kpilog constFeedback=new Kpilog();
              double costWeight=  Double.parseDouble(request.getParameter("weightcost"));//parameter1 weight
              double costValue= Double.parseDouble(request.getParameter("valuecost"));//parameter1 value
           feedbackList.add(constFeedback);
              constFeedback.setOrderid(orderid);constFeedback.setKpiparid1(2);constFeedback.setKpiweight(costWeight/100);constFeedback.setKpivalue(costValue);
               //set 2st item fro kpi
              Kpilog timeFeedback=new Kpilog();
              double timeWeight=  Double.parseDouble(request.getParameter("weighttime"));//parameter2 weight
              double timeValue=  Double.parseDouble(request.getParameter("valuetime"));//parameter value
              timeFeedback.setOrderid(orderid);timeFeedback.setKpiparid1(3);timeFeedback.setKpiweight(timeWeight/100);timeFeedback.setKpivalue(timeValue);
              
               //set 3st item fro kpi
             feedbackList.add(timeFeedback);
             Kpilog defectFeedback=new Kpilog();
             double NODweight= Double.parseDouble(request.getParameter("weightnod"));//parameter3 weight
             double valuenod= Double.parseDouble(request.getParameter("valuenod"));//parameter3 value           
             defectFeedback.setOrderid(orderid);defectFeedback.setKpiparid1(4);defectFeedback.setKpiweight(NODweight/100);defectFeedback.setKpivalue(valuenod);
            feedbackList.add(defectFeedback);
            clientFeedback=new  UserActions();
            for(Kpilog test:feedbackList){
                   out.println("<h1>id is=" +test.getOrderid() + "</h1>");
                   out.println("<h1>parid is=" +test.getKpiparid1() + "</h1>");
                   out.println("<h1>value is=" +test.getKpivalue()+ "</h1>");
                   out.println("<h1>weight is=" +test.getKpiweight()+ "</h1>");
            }
//          
             
         }
              
           if(request.getParameter("orderbtn")!=null){
           
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
         ArrayList<Item> orderItem=new ArrayList();
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
         response.sendRedirect("client.jsp");
        }//end of placing an order
        
        else if(request.getParameter("feedbackbutton")!=null){ 
            
              long orderid= Long.parseLong(request.getParameter("idfeedback"));
              ArrayList<Kpilog> feedbackList=new ArrayList(); 
             //set 1st item fro kpi
              Kpilog constFeedback=new Kpilog();
              double costWeight=  Double.parseDouble(request.getParameter("weightcost"));//parameter1 weight
              double costValue= Double.parseDouble(request.getParameter("valuecost"));//parameter1 value
           feedbackList.add(constFeedback);
              constFeedback.setOrderid(orderid);constFeedback.setKpiparid1(2);constFeedback.setKpiweight(costWeight/100);constFeedback.setKpivalue(costValue);
               //set 2st item fro kpi
              Kpilog timeFeedback=new Kpilog();
              double timeWeight=  Double.parseDouble(request.getParameter("weighttime"));//parameter2 weight
              double timeValue=  Double.parseDouble(request.getParameter("valuetime"));//parameter value
              timeFeedback.setOrderid(orderid);timeFeedback.setKpiparid1(3);timeFeedback.setKpiweight(timeWeight/100);timeFeedback.setKpivalue(timeValue);
              
               //set 3st item fro kpi
             feedbackList.add(timeFeedback);
             Kpilog defectFeedback=new Kpilog();
             double NODweight= Double.parseDouble(request.getParameter("weightnod"));//parameter3 weight
             double valuenod= Double.parseDouble(request.getParameter("valuenod"));//parameter3 value           
             defectFeedback.setOrderid(orderid);defectFeedback.setKpiparid1(4);defectFeedback.setKpiweight(NODweight/100);defectFeedback.setKpivalue(valuenod);
            feedbackList.add(defectFeedback);
            
             
            clientFeedback=new  UserActions();
            clientFeedback.orderFeedBack(feedbackList);
           
             response.sendRedirect("client.jsp");
          }//end of feedback
           
          
         //////////////////////////////////////end of clien action//////////////////////////////////////////////
          
          
          //////////////////////////////////////provider actions//////////////////////////////////////////////
          
        else if(request.getParameter("confirmbtn")!=null|| request.getParameter("cancelbtn")!=null){           
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
        else if(request.getParameter("shipmentbtn")!=null || request.getParameter("waitingbtn")!=null){  
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
        
        
        
         //////////////////////////////////////driver actions//////////////////////////////////////////////
        else if(request.getParameter("setgps")!=null){  
            driv=new UserActions();        
            long orderid=Long.parseLong(request.getParameter("ordergpsid"));
            double gpsx=Double.parseDouble(request.getParameter("latitude"));
            double gpsy=Double.parseDouble(request.getParameter("longitude"));     
          driv.SetPositoin(orderid, gpsx, gpsy);
    
        response.sendRedirect("driver.jsp");
       } 
        if(request.getParameter("confirmdelivery")!=null){
              driv=new UserActions();        
            long orderid=Long.parseLong(request.getParameter("ordergpsid"));
            driv.deliverOrder(orderid);
            response.sendRedirect("driver.jsp");
        }
          //////////////////////////////////////end of driver action////////////////////////////////////////////// 
          
           
        processRequest(request, response);
    }
   
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
