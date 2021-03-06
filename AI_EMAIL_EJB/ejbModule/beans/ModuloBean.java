package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Modulo;
import entities.Modulos;

/**
 * Session Bean implementation class ModuloBean
 */
@Stateless
@LocalBean
public class ModuloBean {

	@PersistenceContext(unitName = "CRM")
	private EntityManager em;

	public ModuloBean() {
		// TODO Auto-generated constructor stub
	}

	public Modulo setMiConfiguracion(Modulo modulo) {

		em.persist(modulo);
		em.flush();
		return modulo;
	}

	public Modulo updateMiConfiguracion(Modulo modulo) {

		Modulo email = em.find(Modulo.class, modulo.getId());
		if (email == null) {
			em.persist(modulo);
		} else {
			email = modulo;
			em.merge(email);
			em.flush();
		}
		return email;
	}

	public Modulo getMiConfiguracion() {

		Modulo m = null;
		try {
			Long count = (Long) em.createQuery("select count(m) from Modulo m").getSingleResult();
			if(count > 0)
				m = (Modulo) em.createQuery("select m from Modulo m where m.modulo = 'Email'").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public void deleteMiConfiguracion(String ip){
		
		Modulo m = (Modulo) em.createQuery("select m from Modulo m where m.ip = ?").setParameter(1, ip).getSingleResult();
		em.remove(m);
	}

}
