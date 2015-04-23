
package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mutualModels.Item;
import server.dao.ItemDAO;
import server.model.Request;

public class RequestProcessor {
    private MainServer server;
    private ExecutorService service;
    
    public RequestProcessor(MainServer server) {
        this.server = server;
        int threads = 20;
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
                        else {
                            System.err.println("server: unknown request type");
                        }
                    }
                }
            });
        }
    }
    
    
}
