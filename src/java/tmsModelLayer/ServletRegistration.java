 
package tmsModelLayer;

import BussinessLayer.Impl.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class ServletRegistration extends HttpServlet {

   UserRegistration regs ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //response.sendRedirect("/Users");
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration confirmation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email"); 
        String roleRegistering = request.getParameter("roleRegistering");
        String usernamereg=request.getParameter("usernamereg");
        String passwordreg = request.getParameter("passwordreg");
        int roleReg=Integer.parseInt(roleRegistering);
        switch (roleReg){
            case 1:{
                Client regCl=new Client();
                regCl.setFullName(name);regCl.setAddress(address);regCl.setEmail(email);regCl.setPhone(telephone);
                regCl.setUsername(usernamereg);regCl.setPassword(passwordreg);
                getRegister().sendToDB(regCl);
                break;
            }
            case 2:{
                Provider regPr=new Provider();
                regPr.setFullName(name);regPr.setAddress(address);regPr.setEmail(email);regPr.setPhone(telephone);
                regPr.setUsername(usernamereg);regPr.setPassword(passwordreg);
                getRegister().sendToDB(regPr);
                break;
            }
            case 3:{
                Carrier regCr=new Carrier();
                regCr.setFullName(name);regCr.setAddress(address);regCr.setEmail(email);regCr.setPhone(telephone);
                regCr.setUsername(usernamereg);regCr.setPassword(passwordreg);
                getRegister().sendToDB(regCr);
                break;
            }
            case 4:{
                Driver regDr=new Driver();
                regDr.setFullName(name);regDr.setAddress(address);regDr.setEmail(email);regDr.setPhone(telephone);
                regDr.setUsername(usernamereg);regDr.setPassword(passwordreg);
                getRegister().sendToDB(regDr);
                break;
            }
            
        }
        
        
        //response.sendRedirect("Login");
        processRequest(request, response);
        
    }
    
    private UserRegistration getRegister(){
       regs=new UserRegistration();
        return regs;
    }

    
    @Override
    public String getServletInfo() {
        return "this servlet sent user information to the registration class to save them inside database";
    }// </editor-fold>

}
