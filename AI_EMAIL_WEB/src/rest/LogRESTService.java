package rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.LogBean;

@Stateless
@Path("/log")
public class LogRESTService {

	@EJB
	private LogBean logBean;

	public LogRESTService() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public String getLogs() {
		
		return logBean.getLogs();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{modulo}")
	public String getLogsPorModulo(@PathParam("modulo") String modulo) {
		
		return logBean.getLogsPorModulo(modulo);
	}

}
