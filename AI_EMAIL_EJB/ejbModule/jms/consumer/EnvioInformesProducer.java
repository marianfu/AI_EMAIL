package jms.consumer;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gson.Gson;

import entities.Log;

public class EnvioInformesProducer {

	/*	CLASE PARA TESTEAR JMS, VA EN EL MODULO MONITOR
	 * 	HAY QUE AGREGAR LA COLA java:/jboss/exported/jms/queue/monitorQueue con name = monitorQueue
	 * 	HAY QUE AGREGAR jboss-client.jar en MODULO MONITOR
	 * 	
	 * */
	
	private static EnvioInformesProducer instance;
	private static final Logger log = Logger.getLogger(EnvioInformesProducer.class.getName());

	// Set up all the default values
	//private static final String DEFAULT_MESSAGE = "Hello, World!";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "java:/jms/queue/monitorQueue";
	private static final String DEFAULT_MESSAGE_COUNT = "1";
	private static final String DEFAULT_USERNAME = "#";
	private static final String DEFAULT_PASSWORD = "guest";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://localhost:8180";
	
	public static EnvioInformesProducer getInstance(){
		
		if(instance == null)
			instance = new EnvioInformesProducer();
		return instance;
	}
	
	public void enviarMensaje() {

		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;
		MessageConsumer consumer = null;
		Destination destination = null;
		TextMessage message = null;
		Context context = null;

		try {
			// Set up the context for the JNDI lookup
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
			env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
			env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
			context = new InitialContext(env);

			// Perform the JNDI lookups
			String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
			log.info("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
			connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
			log.info("Found connection factory \"" + connectionFactoryString + "\" in JNDI");

			String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
			log.info("Attempting to acquire destination \"" + destinationString + "\"");
			destination = (Destination) context.lookup(destinationString);
			log.info("Found destination \"" + destinationString + "\" in JNDI");

			// Create the JMS connection, session, producer, and consumer
			connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME),
					System.getProperty("password", DEFAULT_PASSWORD));
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(destination);
			// consumer = session.createConsumer(destination);
			connection.start();

			int count = Integer.parseInt(System.getProperty("message.count", DEFAULT_MESSAGE_COUNT));
			
			Log lg = new Log("Monitor", "La wea chequeos", new Date());
			Gson gson = new Gson();
			
			
			String content = System.getProperty("message.content", gson.toJson(lg));

			log.info("Sending " + count + " messages with content: " + content);

			// Send the specified number of messages
			for (int i = 0; i < count; i++) {
				message = session.createTextMessage(content);
				producer.send(message);
			}

		} catch (Exception e) {
			log.severe(e.getMessage());
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// closing the connection takes care of the session, producer, and
			// consumer
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
