
package tmsModelLayer.ServletPackage;

import BussinessLayer.Impl.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tmsModelLayer.Carrier;
import tmsModelLayer.Client;
import tmsModelLayer.Driver;
import tmsModelLayer.Provider;

/**
 *
 * @author omid
 */
public class LoginServlet extends HttpServlet {
UserLogin log;Client user_1;Carrier user_3;Provider user_2;Driver user_4;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession loginSession =request.getSession();
          
       String username = request.getParameter("username");
       String password = request.getParameter("pass");
       int role=Integer.parseInt(request.getParameter("role"));
       int check=-1;
       check= getLogin().check_Username(role, username,password);
       
        switch (role){
            case 1:{
                user_1=new Client();
                break;
            }
            case 2:{
                user_2=new Provider();
                break;
            }
            case 3:{
                user_3=new Carrier();
                break;
            }
            case 4:{
                user_4=new Driver();
                break;
            }
        }
           if(check==1 &&role==1)//correct information
           {
               user_1.makeCopy(getLogin().getClient(username));
               loginSession.setAttribute("clientpage", user_1);
               response.sendRedirect("client.jsp");
               
           }//redirect to client page
           
           else if(check==0)//meets username only
              response.sendRedirect("index.jsp");
           else if(check==-1)// not exist in database
                response.sendRedirect("alert.jsp");           
             processRequest(request, response);    
              Client myclinet=new Client();
             myclinet.makeCopy(getLogin().getClient(username));
             
           
            loginSession.setAttribute("login", myclinet);
             
    }
    private UserLogin getLogin(){
      log=new UserLogin();
      return log;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
