package jms.consumer;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.json.JsonObject;

import org.hornetq.utils.json.JSONObject;

import entities.Log;

/**
 * Message-Driven Bean implementation class for: RecepcionInformeMDB
 */

@MessageDriven(name = "RecepcionDeInformesMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/monitorQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class RecepcionInformeMDB implements MessageListener {

    /**
     * Default constructor. 
     */
    public RecepcionInformeMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
    	TextMessage msg = (TextMessage) message;
    	try{
    		
    		System.out.println(msg.getText());
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
    }

}
