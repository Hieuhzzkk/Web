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
import dao.ProductDao;
import entities.Category;
import entities.Product;
import net.bytebuddy.asm.Advice.This;

@WebServlet({"/product/index", 
	"/product/create", 
	"/product/store", 
	"/product/edit", 
	"/product/update", 
	"/product/delete",})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao productDao;
    private CategoryDao categoryDao;
    
    public ProductServlet() {
        super();
        this.productDao = new ProductDao();
        this.categoryDao = new CategoryDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		if (uriString.contains("index")) {
			this.index(request, response);
		}else if (uriString.contains("create")) {
			this.create(request, response);
		}
		else if (uriString.contains("delete")) {
			this.delete(request, response);
		}
		else if (uriString.contains("edit")) {
			this.edit(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString = request.getRequestURI();
		if (uriString.contains("store")) {
			this.store(request, response);
		}else if (uriString.contains("update")) {
			this.update(request, response);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response
			) throws IOException {
		String idString = request.getParameter("id");
		String idcate = request.getParameter("category_id");
		try {
			int id = Integer.parseInt(idString);
			int category_id = Integer.parseInt(idcate);
			Product product = this.productDao.findById(id);
			BeanUtils.populate(this.productDao.findById(id), request.getParameterMap());
			this.productDao.findById(id).setCategory(this.categoryDao.findById(category_id));
			this.productDao.update(product);
			response.sendRedirect("/hhh" + "/product/index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/hhh" + "/product/edit?id=" + idString);
			// TODO: handle exception
		}
	}


	private void store(HttpServletRequest request, HttpServletResponse response
			) throws IOException {
		HttpSession session = request.getSession();
		try {
			Product product = new Product();
			BeanUtils.populate(product, request.getParameterMap());
			product.setCategory(this.categoryDao.findById(Integer.parseInt(request.getParameter("category_id"))));
			this.productDao.create(product);
			response.sendRedirect("/hhh/" + "/product/	index");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/hhh/" + "/product/index");
			// TODO: handle exception
		}
	}


	private void edit(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		List<Category> categories = this.categoryDao.all();
		request.setAttribute("categories", categories);
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Product product = this.productDao.findById(id);
		request.setAttribute("pro", product);
		request.setAttribute("view", "/view/admin/product/edit.jsp");
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		try {
			int id = Integer.parseInt(idString);
			Product product = this.productDao.findById(id);
			this.productDao.delete(product);
			response.sendRedirect("/hhh" + "/product/index");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}


	private void create(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		List<Category> categories = this.categoryDao.all();
		request.setAttribute("cate", categories);
		request.setAttribute("view", "/view/admin/product/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
	}


	private void index(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		List<Product> dsProducts = this.productDao.all();
		List<Category> dsCategories = this.categoryDao.all();	
		request.setAttribute("dscate", dsCategories);
		request.setAttribute("dspro", dsProducts);
		request.setAttribute("view", "/view/admin/product/index.jsp");
		request.getRequestDispatcher("/view/Home.jsp").forward(request, response);
	}


	

}
