package jms.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;

import entities.Log;

/**
 * Message-Driven Bean implementation class for: RecepcionInformeMDB
 */

@MessageDriven(name = "RecepcionDeInformesMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/monitorQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class RecepcionInformeMDB implements MessageListener {

    @PersistenceContext(unitName = "CRM")
    private EntityManager em;
    
    public RecepcionInformeMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
    	
    	TextMessage msg = (TextMessage) message;
    	try{
    		Gson gson = new Gson();
    		Log log = (Log) gson.fromJson(msg.getText(), Log.class);
    		em.persist(log);
    		em.flush();
    		System.out.println(msg.getText());
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
    }

}
