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
 * Servlet implementation class ServletAgregarConfiguracion
 */
@WebServlet("/agregarConfiguracion")
public class ServletAgregarConfiguracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ModuloBean moduloBean;
	
    public ServletAgregarConfiguracion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ip = (String) request.getParameter("ip_dir");
		String puerto = request.getParameter("puerto");
		String cola = request.getParameter("cola");
		
		if(moduloBean.getMiConfiguracion() == null){
		
			Modulo m = new Modulo(Modulos.Email, ip, puerto, cola);
			moduloBean.setMiConfiguracion(m);

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

}
