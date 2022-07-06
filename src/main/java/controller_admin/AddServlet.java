package controller_admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import dao.CategoryDao;
import dao.StudentDao;
import entities.Category;
import entities.User;

//Cau hinh URL cua servlet
@WebServlet({ "/categories/index",
	"/categories/create",
	"/categories/store",
	"/categories/edit",
	"/categories/update",
	"/categories/delete" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	private CategoryDao categoryDao;
    
    public AddServlet() {
    	super();
    	this.studentDao = new StudentDao();
    	this.categoryDao = new CategoryDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		if (uriString.contains("index")) {
			this.index(request, response);
		}else if (uriString.contains("create")) {
			this.create(request, response);
		}else if (uriString.contains("edit")) {
			this.edit(request, response);
		}else if (uriString.contains("delete")) {
			this.delete(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		if (uriString.contains("store")) {
			this.store(request, response);
		}else if (uriString.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response
			) throws IOException {
		HttpSession session = request.getSession();
		String idString = request.getParameter("id");
		String idStr = request.getParameter("user_id");
		try {
			int id = Integer.parseInt(idString);
			int idus = Integer.parseInt(idStr);
			Category category = this.categoryDao.findById(id);
			User user = this.studentDao.findById(idus);
			BeanUtils.populate(category, request.getParameterMap());
			category.setUser(user);
			this.categoryDao.update(category);
			request.setAttribute("ds", category);
			response.sendRedirect("/hhh" + "/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/hhh" + "/categories/edit?id=" + idString);
			// TODO: handle exception
		}
	}


	private void store(HttpServletRequest request, HttpServletResponse response
			) throws IOException {
		try {
			Category category = new Category();
			BeanUtils.populate(category, request.getParameterMap());
			int userID = Integer.parseInt(request.getParameter("user_id"));
			User user = this.studentDao.findById(userID);
			category.setUser(user);
			this.categoryDao.create(category);
			response.sendRedirect("/hhh" + "/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			response.sendRedirect("/hhh" + "/categories/index");
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		try {
			int id = Integer.parseInt(idString);
			Category category = this.categoryDao.findById(id);
			this.categoryDao.delete(category);
			response.sendRedirect("/hhh/categories/index");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}


	private void edit(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		List<User> ds = this.studentDao.all();
		request.setAttribute("dsUser", ds);
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Category category = this.categoryDao.findById(id);
		request.setAttribute("cate", category);
		request.setAttribute("view", "/view/admin/categories/edit.jsp");
		request.getRequestDispatcher("/view/Home.jsp")
		.forward(request, response);
	}


	private void create(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		request.setAttribute("view", "/view/admin/categories/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp")
		.forward(request, response);
		
	}


	private void index(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		List<User> ds = this.studentDao.all();
		List<Category> dscate = this.categoryDao.all();
		request.setAttribute("dscate", dscate);
		request.setAttribute("dsUser", ds);
		request.setAttribute("view", "/view/admin/categories/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp")
		.forward(request, response);
				
	}


	

}
