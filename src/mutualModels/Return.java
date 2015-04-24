/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mutualModels;

import java.util.concurrent.LinkedBlockingQueue;

public class Return extends Transaction{

    public Return(LinkedBlockingQueue items, Employee employee, double total){
        
        super(items, employee, total);
        
    }
    
}
