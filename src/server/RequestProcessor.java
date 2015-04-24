
package server;

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

                        if(o instanceof Integer) {
                            int id = (int) o;
                            System.out.println("server: working on item lookup");
                            Item item = ItemDAO.getByID(id);
                            request.setReturnObject(item);
                            System.out.println("server: found item: " + item.getItem_name() + "and submitting the response to main server");
                            server.submitResponse(request);
                        }
                        else if(o instanceof Purchase) {
                            System.out.println("server: working on purchase");
                            Purchase purchase = (Purchase) o;
                            LinkedBlockingQueue<Item> items = purchase.getItems();
                            for(Item item : items) {
                                ItemDAO.reduceQuantity(item.getItem_id(), 1);
                                EmployeeDAO.increaseSales(item.getItem_price());
                            }
                            System.err.println("server: TO DO: finish purchase stuff");
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
