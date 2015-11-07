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
 * Servlet implementation class ServletRecepcionItem
 */
@WebServlet("/items")
public class ServletRecepcionItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private ModuloBean moduloBean;
	
    public ServletRecepcionItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Modulo m = moduloBean.getMiConfiguracion();
		if(m == null){
			m = moduloBean.setMiConfuracion(new Modulo(Modulos.Email, "localhost", "8180", null));
		}
		
		request.setAttribute("ip", m.getIp());
		request.setAttribute("puerto", m.getPort());
		
		request.getRequestDispatcher("recepcionItems.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
