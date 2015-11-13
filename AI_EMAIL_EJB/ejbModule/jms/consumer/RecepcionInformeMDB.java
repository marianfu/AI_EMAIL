package jms.consumer;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
    	
    	
    	TextMessage json = (TextMessage) message;
    	try{
    		// Convert JSON String to List
    		Type type = new TypeToken<List<Log>>(){}.getType();
    		List<Log> logs = new Gson().fromJson(json.getText(), type);
    		Logger.getAnonymousLogger().info("Informes recibidos: "+logs.size());
    		
    		for(Log l : logs){
    			em.persist(l);
    			em.flush();
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
    }

}
