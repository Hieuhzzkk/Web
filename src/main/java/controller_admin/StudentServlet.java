package controller_admin;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Utils.EncryptUtil;
import dao.StudentDao;
import entities.User;


@WebServlet({"/users/index",
	"/users/create", 
	"/users/store", 
	"/users/edit", 
	"/users/update", 
	"/users/delete",
	"/users/show",})
public class StudentServlet extends HttpServlet {
	private StudentDao studentDao;
    
    public StudentServlet() {
        super();
        this.studentDao = new StudentDao();
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} 
		else if (uri.contains("create")) {
			this.create(request, response);
		} 
		else if (uri.contains("edit")) {
			this.edit(request, response);
		} 
		else if (uri.contains("show")) {
			this.show(request, response);
		} 
		else if (uri.contains("delete")) {
			this.delete(request, response);
		}
		else if (uri.contains("store")) {
			this.store(request, response);
		}
	}

	
	private void store(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException{
		HttpSession session = request.getSession();
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			String encrypted = EncryptUtil.encypt(request.getParameter("password"));
			entity.setPassword(encrypted);
			this.studentDao.create(entity);
			session.setAttribute("message", "Them moi thanh cong");
			response.sendRedirect("/hhh" + "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Them moi that bai");
			response.sendRedirect("/hhh" + "/users/create");
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		String idStr = request.getParameter("id");
		try {
			int id = Integer.parseInt(idStr);
			User entity = this.studentDao.findById(id);
			this.studentDao.delete(entity);
			response.sendRedirect("/hhh" + "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void show(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		
	}


	private void edit(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException  {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.studentDao.findById(id);
		request.setAttribute("user", entity);
		request.setAttribute("view", "/view/admin/user/edit.jsp");
			request.getRequestDispatcher("/view/Home.jsp")
			.forward(request, response);
	}


	private void create(HttpServletRequest request, HttpServletResponse response
			)throws IOException, ServletException {
		request.setAttribute("view", "/view/admin/user/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp")
		.forward(request, response);
	}


	private void index(HttpServletRequest request, HttpServletResponse response
			)throws IOException, ServletException {
		List<User> ds = this.studentDao.all();
		
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/view/admin/user/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		}else if (uri.contains("update")) {
			this.update(request, response);
		}
	}


	private void update(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		String idStr = request.getParameter("id");
		try {
			int id = Integer.parseInt(idStr);
			User oldValueUser = this.studentDao.findById(id);
			User newValueUser = new User();
			BeanUtils.populate(newValueUser, request.getParameterMap());
			newValueUser.setPassword(oldValueUser.getPassword());
			this.studentDao.update(newValueUser);
			response.sendRedirect("/hhh" + "/users/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/hhh" + "/users/edit?id=" + idStr);
			// TODO: handle exception
		}
		
	}

}
