package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class LogBean
 */
@Stateless
@LocalBean
public class LogBean {

    @PersistenceContext (unitName = "CRM")
    private EntityManager em;
	
    public LogBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String getLogs(){
    	
    	
    }

}
