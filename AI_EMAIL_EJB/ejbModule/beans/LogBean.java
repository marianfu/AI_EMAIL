package beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;

import entities.Log;

/**
 * Session Bean implementation class LogBean
 */
@Stateless
@LocalBean
public class LogBean {

	@PersistenceContext(unitName = "CRM")
	private EntityManager em;

	public LogBean() {
		// TODO Auto-generated constructor stub
	}

	public String getLogs() {

		String logs = null;
		try {
			List<Log> lista = (List<Log>) em.createQuery("select m from Log m").getResultList();
			Gson gson = new Gson();
			logs = gson.toJson(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return logs;
	}

	public String getLogsPorModulo(String modulo) {

		String logs = null;
		try {
			List<Log> lista = (List<Log>) em.createQuery("select m from Log m where m.modulo = ?").setParameter(1, modulo).getResultList();
			Gson gson = new Gson();
			logs = gson.toJson(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return logs;
	}

}
