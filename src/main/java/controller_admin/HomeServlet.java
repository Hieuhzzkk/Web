package controller_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/home/banhang","/home/thuong"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		if (uriString.contains("banhang")) {
			this.banhang(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void banhang(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		request.setAttribute("view", "/view/home/BanHang.jsp");
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
	}


	

}
