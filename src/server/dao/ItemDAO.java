package server.dao;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;
import mutualModels.Employee;
import mutualModels.Item;
import static server.dao.EmployeeDAO.DB_URL;

public class ItemDAO {
    // JDBC driver name and database URL
   final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:8889/POS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   static int itemID;
   static double itemPrice;
   static String itemDesc;
   static int itemQuantity;

    public static Item getByID(int id) {
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT In_item, In_Description, In_Price, In_Quantity from Inventory where In_item ="+id;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement... In GET ID");
            //System.out.println("User ID is: "+id);
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                itemID = rs.getInt("In_item");
                itemPrice = rs.getDouble("In_Price");
                itemDesc = rs.getString("In_Description");
                itemQuantity = rs.getInt("In_Quantity");
                        

                //Display values
                System.out.print("DB: ID: " + itemID);
                System.out.print(", Price: " + itemPrice);
                System.out.println(", Description: " + itemDesc);
                System.out.println(", Quantity: " + itemQuantity);
                
                
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
        //System.out.println("END");
    return new Item(itemID, itemDesc, itemPrice, itemQuantity);
        
    }
   
    
    public static void reduceQuantity(int id, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT In_item, In_Description, In_Price, In_Quantity from Inventory where In_item ="+id;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //System.out.println("User ID is: "+id);
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                itemID = rs.getInt("In_item");
                itemPrice = rs.getDouble("In_Price");
                itemDesc = rs.getString("In_Description");
                itemQuantity = rs.getInt("In_Quantity");

                //Display values
                System.out.print("DB: ID: " + itemID);
                System.out.print(", Price: " + itemPrice);
                System.out.println(", Description: " + itemDesc);
                System.out.println(", Quantity: " + itemQuantity);

            }
            int subQuantity = itemQuantity - 1;
            if(subQuantity < 0){
                System.out.println("ITEM: '"+itemID+"' IS NOT AVAILABLE FOR PURCHASE");
            }
            else{
        System.out.println("NEW QUANTITY: " + subQuantity);
        query = "UPDATE Inventory set In_Quantity = "+ subQuantity+" where In_item = "+itemID;
        System.out.println("Executing" + query);
        stmt.executeUpdate(query);
            
            
            //STEP 6: Clean-up environment
            rs.close();
            }  
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
    
    public static void increaseQuantity(int id, int quantity) {
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT In_item, In_Description, In_Price, In_Quantity from Inventory where In_item ="+id;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //System.out.println("User ID is: "+id);
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                itemID = rs.getInt("In_item");
                itemPrice = rs.getDouble("In_Price");
                itemDesc = rs.getString("In_Description");
                itemQuantity = rs.getInt("In_Quantity");

                //Display values
                System.out.print("ID: " + itemID);
                System.out.print(", Price: " + itemPrice);
                System.out.println(", Description: " + itemDesc);
                System.out.println(", Quantity: " + itemQuantity);
                
                //increase(itemID,itemQuantity);
                
                
            }
            int plusQuantity = itemQuantity + 1;
        System.out.println("NEW QUANTITY: " + plusQuantity);
        query = "UPDATE Inventory set In_Quantity = "+ plusQuantity+" where In_item = "+itemID;
        System.out.println("Executing" + query);
        stmt.executeUpdate(query);
            
            
            //STEP 6: Clean-up environment
            rs.close();
            //stmt.close();
            //conn.close();
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
    
    public static LinkedBlockingQueue<Item> retrieveAll() {
        Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT * from Inventory";
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue();
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //System.out.println("User ID is: "+id);
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                itemID = rs.getInt("In_item");
                itemPrice = rs.getDouble("In_Price");
                itemDesc = rs.getString("In_Description");
                itemQuantity = rs.getInt("In_Quantity");

                //Display values
                System.out.print("ID: " + itemID);
                System.out.print(", Price: " + itemPrice);
                System.out.println(", Description: " + itemDesc);
                System.out.println(", Quantity: " + itemQuantity);
                
                list.add(new Item(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4)));
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

        return list;
    }
    
    public static LinkedBlockingQueue<Item> retrieveAllOutOfStock() {
       Connection conn = null;
        Statement stmt = null;
        
        String query = "SELECT In_item, In_Description, In_Price, In_Quantity from Inventory where In_Quantity = 0";
        LinkedBlockingQueue<Item> list = new LinkedBlockingQueue();
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            //System.out.println("User ID is: "+id);
            stmt = conn.createStatement();
      
            ResultSet rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                itemID = rs.getInt("In_item");
                itemPrice = rs.getDouble("In_Price");
                itemDesc = rs.getString("In_Description");

                //Display values
                System.out.print("ID: " + itemID);
                System.out.print(", Price: " + itemPrice);
                System.out.println(", Description: " + itemDesc);
                
                list.add(new Item(rs.getInt(1),rs.getString(2), rs.getDouble(3),0));
             
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

        return list;
    }
}