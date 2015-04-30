/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.dao;

import client.gui.Login;
import java.sql.*;
import mutualModels.Employee;
import server.model.Request;

public class EmployeeDAO {
            // JDBC driver name and database URL
   final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:8889/POS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   static String userFN;
   static String userLN;
   static String queryPass;
   static double queryAmount;
    
   public synchronized static void increaseSales(double amount)
    {
        int id = Login.userid;
        double paidamount = amount;
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT emp_ID, emp_FM, emp_LN, emp_Pass, emp_TotalSale from Employee where emp_ID ="+id;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("DB: Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("DB: Creating statement...");
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int userid = rs.getInt("emp_ID");
                userFN = rs.getString("emp_FM");
                userLN = rs.getString("emp_LN");
                queryPass = rs.getString("emp_Pass");
                queryAmount = rs.getDouble("emp_TotalSale");
                

                //Display values
                System.out.print("DB: ID: " + userid);
                System.out.print(", First: " + userFN);
                System.out.println(", Last: " + userLN);
                System.out.println(", Password: " + queryPass);
                System.out.println(", Sales: " + queryAmount);

            }
            double increaseAmount = paidamount + queryAmount;
            
        System.out.println("DB: NEW AMOUNT: " + increaseAmount);
        query = "UPDATE Employee set emp_TotalSale = "+ increaseAmount+" where emp_ID = "+id;
        System.out.println("DB: Executing" + query);
        stmt.executeUpdate(query);
            //STEP 6: Clean-up environment
            rs.close(); 
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
   
    public static Employee getEmployeeInfo(int id, String password) {
        System.out.println("ID: "+id);
        
        //Object o = request.getReceivedObject();
        String userpassword = password;
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT emp_ID, emp_FM, emp_LN, emp_Pass, emp_TotalSale from Employee where emp_ID ="+id;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("DB: Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Check: Creating statement...");
            System.out.println("Check: User ID is: "+id);
            System.out.println("Check: User Password is: "+userpassword);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int userid = rs.getInt("emp_ID");
                userFN = rs.getString("emp_FM");
                userLN = rs.getString("emp_LN");
                queryPass = rs.getString("emp_Pass");
                queryAmount = rs.getDouble("emp_TotalSale");
                

                //Display values
                System.out.print("DB: ID: " + userid);
                System.out.print(", First: " + userFN);
                System.out.println(", Last: " + userLN);
                System.out.println(", Password: " + queryPass);
                System.out.println(", Sales: " + queryAmount);
            }
            
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        if ((password.equals(queryPass))) {
               System.out.print("DB: USER IS LOGGING IN...");
        } 
        else{
            System.out.print("DB: NO USER WITH THIS LOGIN...");
            System.exit(0);
        }
        if(userFN == null){
            System.out.print("DB: NO USER WITH THIS LOGIN...");
            System.exit(0);
        }
        //System.out.println("END");
    return new Employee(id, userFN, userLN, queryPass, queryAmount);
    }
    
    public static void updateEmployee(int id) {
        // to do, will need more parameters
    }
}
