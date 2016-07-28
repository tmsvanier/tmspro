/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsModelLayer;

import java.sql.*;
import javax.swing.JOptionPane;
public class Oracle 
{
  private static Connection conn;
  private static  Statement sts;
  private static PreparedStatement stmt;
  private static String query;
  private static ResultSet rslt;
  private String url;

    public Oracle()
    {
        conn=null;
        stmt=null;
        query=""; 
        
    }
    public void connect(String username, String password)
    {
       
       
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
         // url="jdbc:oracle:thin:@ Localhost:1521:orcl";
          url="jdbc:oracle:thin:@localhost:1521:scott";
          
            conn=DriverManager.getConnection(url,username,password); 
             
           conn.setAutoCommit(false);
         
           
        }//end of try
       catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {         
                  JOptionPane.showMessageDialog(null,"make sure user:system, pasword:tiger and SID:scott  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE); 
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                    
                }
           }//exception
       
    }//localconnect
    public void connect(String username, String password,String newurl,String SIN )
    {
       
        System.out.println("connect to oracle database");
        try
        {
           Class.forName("oracle.jdbc.driver.OracleDriver");
          url="jdbc:oracle:thin:@ Localhost:1521:orcl";
              conn=DriverManager.getConnection(url,username,password);
           
            url="jdbc:oracle:thin:@ "+ newurl+":1521:scott"; //if you have different url and deferent user nama and password enabe this statement
            conn=DriverManager.getConnection(url,username,password); 
//          
             System.out.println("************driver has been loaded*****************"); 
           conn.setAutoCommit(false);
          
             System.out.println("************driverand connection have been run****************"); 
           
        }//end of try
       catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {              
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                 JOptionPane.showMessageDialog(null,"Oracle Database Error addressing:  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE);    
                }
           }//exception  
    }//connect to other database
  
    public ResultSet getResult(String Tquery)
    {
        try
        {
           stmt=conn.prepareStatement(Tquery);
           rslt=stmt.executeQuery(Tquery);         
           conn.commit();
        }
         catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {              
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                 JOptionPane.showMessageDialog(null,"Oracle Database Error addressing:  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE);    
                }
           }//exception  
        return rslt;
    }//get rslt
    public void setQuery(String Tquery)
    {
        try
        {
            stmt=conn.prepareStatement(Tquery);
            stmt.executeUpdate();
           
            conn.commit();
        }
       
         catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {              
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                 JOptionPane.showMessageDialog(null,"Oracle Database Error addressing:  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE);    
                }
           }//exception  
    }//set query
     public ResultSet getLstKey()
    {
        try
        {           
           rslt=stmt.getGeneratedKeys();         
           conn.commit();
        }
         catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {              
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                 JOptionPane.showMessageDialog(null,"Oracle Database Error addressing:  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE);    
                }
           }//exception  
        return rslt;
    }
    public  void terminate()
    {
        try
        {
            conn.close();
        }
       
         catch (Exception e)
           {
            try
            {
                conn.rollback();
            }
           catch(Exception rr) 
              {              
                 System.out.println("---------connect Error----");
                 System.out.println("Oracle Database Error addressing: "+e);
                 JOptionPane.showMessageDialog(null,"Oracle Database Error addressing:  \n "+e
                                                  , "---------connect Error----",
                                            JOptionPane.ERROR_MESSAGE);    
                }
           }//exception  
        
    }//close
    public int size() throws SQLException
    {
        int index=0;
       
        while(rslt.next())
        {
            index++;
        } 
        while(rslt.previous())
        {
            
        }
        return index;
    }
}//end of connectToOracle












