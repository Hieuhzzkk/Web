package controller_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.EncryptUtil;
import dao.StudentDao;
import entities.User;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveWideningDelegate;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private StudentDao studentDao;
    
    public LoginServlet() {
        super();
        this.studentDao = new StudentDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/Login.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email"),
				pwd  = request.getParameter("password");
		User user = this.studentDao.findByEmail(email);
		boolean check = EncryptUtil.check(pwd, user.getPassword());
		if (check == true) {
			session.setAttribute("user", user);
			response.sendRedirect("/hhh/home/banhang");
		}else {
		}
	}

}
