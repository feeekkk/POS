
package server;

import client.gui.Login;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import mutualModels.*;
import server.dao.EmployeeDAO;
import server.dao.ItemDAO;
import server.model.Request;

public class RequestProcessor {
    private final MainServer server;
    private final ExecutorService service;
    
    public RequestProcessor(MainServer server) {
        this.server = server;
        int threads = 5;
        this.service = Executors.newFixedThreadPool(threads);
    }
    
    public void submitRequest(final Request request) {
        synchronized(service) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized(request) {
                        Object o = request.getReceivedObject();
                        // integer is item lookup
                        if(o instanceof Integer) {
                            int id = (int) o;
                            System.out.println("server: working on item lookup");
                            Item item = ItemDAO.getByID(id);
                            request.setReturnObject(item);
                            System.out.println("server: found item: " + item.getItem_name() + "and submitting the response to main server");
                            server.submitResponse(request);
                        }
                        // purchase
                        else if(o instanceof Purchase) {
                            System.out.println("server: working on purchase");
                            Purchase purchase = (Purchase) o;
                            System.out.println("temp server: getting items");
                            LinkedBlockingQueue<Item> items = purchase.getItems();
                            System.out.println("temp server: got items. iterating through and updating stats");
                            if(items == null || items.isEmpty()) {
                                System.err.println("temp server: there are no items to be iterated..");
                            }
                            else {
                                System.out.println("temp server: is empty check complete. there are items to be worked on");
                                for(Item item : items) {
                                    ItemDAO.reduceQuantity(item.getItem_id(), 1);
                                    EmployeeDAO.increaseSales(item.getItem_price());
                                }
                            }
                            
                            System.err.println("server: TO DO: finish purchase stuff");
                        }
                        // return
                        else if(o instanceof Return) {
                            System.out.println("server: working on return");
                            Return return1 = (Return) o;
                            System.out.println("temp server: getting items");
                            LinkedBlockingQueue<Item> items = return1.getItems();
                            System.out.println("temp server: got items. iterating through and updating stats");
                            if(items == null || items.isEmpty()) {
                                System.err.println("temp server: there are no items to be iterated..");
                            }
                            else {
                                System.out.println("temp server: is empty check complete. there are items to be worked on");
                                for(Item item : items) {
                                    ItemDAO.increaseQuantity(item.getItem_id(), 1);
                                }
                            }
                            System.err.println("server: TO DO: finish return stuff");
                        }
                        // employee lookup
                        else if(o instanceof Employee) {
                            System.out.println("server: working on employee lookup");
                            Employee employee = (Employee) o;
                            System.out.println("EMPLOYEE: "+employee);
                            int id = employee.getId(Login.userid);
                            employee = EmployeeDAO.getEmployeeInfo(id);
                            request.setReturnObject(employee);
                            System.out.println("server: found employee with id " + employee.getId(Login.userid));
                            server.submitResponse(request);
                        }
                        // certain types of requests hide in strings
                        else if(o instanceof String) {
                            System.out.println("server: parsing string to find type of request");
                            String message = (String) o;
                            LinkedBlockingQueue<Item> items;
                            
                            switch(message) {
                                case "RETRIEVE-ALL-ITEMS":
                                    System.out.println("server: working on retrieving all items");
                                    items = ItemDAO.retrieveAll();
                                    request.setReturnObject(items);
                                    System.out.println("server: retrieved all items");
                                    server.submitResponse(request);
                                    break;
                                case "RETRIEVE-ALL-OUT-OF-STOCK-ITEMS":
                                    System.out.println("server: working on retrieving all out of stock items");
                                    items = ItemDAO.retrieveAllOutOfStock();
                                    request.setReturnObject(items);
                                    System.out.println("server: retrieved all out of stock items");
                                    server.submitResponse(request);
                                    break;
                                default:
                                    System.err.println("server: String request not found: " + message);
                            }
                        }
                        else {
                            System.err.println("server: unknown request type");
                        }
                    }
                }
            });
        }
    }
    
    
}
