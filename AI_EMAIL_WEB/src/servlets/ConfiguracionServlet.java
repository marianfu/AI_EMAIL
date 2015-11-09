package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ModuloBean;
import entities.Modulo;
import entities.Modulos;

/**
 * Servlet implementation class ConfiguracionServlet
 */
@WebServlet("/configuracion")
public class ConfiguracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private ModuloBean moduloBean;
	
    public ConfiguracionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Modulo m = moduloBean.getMiConfiguracion();
		if(m != null){
			//m = moduloBean.setMiConfiguracion(new Modulo(Modulos.Email, "localhost", "8180", null));
		
		request.setAttribute("modulo", m.getmodulo().toString());
		request.setAttribute("ip", m.getIp());
		request.setAttribute("puerto", m.getPort());
		request.setAttribute("cola", m.getCola());
		if(m.isActivo())
			request.setAttribute("activo", "Si");
		else
			request.setAttribute("activo", "No");
		}
		request.getRequestDispatcher("configuracion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
