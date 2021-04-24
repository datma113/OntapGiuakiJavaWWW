package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDao;
import entity.Person;



@WebServlet(name = "Person", urlPatterns = {"/person/*" })
//@WebServlet("/person/*")
public class PersonController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonDao personDao = new PersonDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String action = getAction(uri); // call to private method to get an action
	
		switch (action) {
		case "/person/save":
			savePerson(req, resp);
			break;
		case "/person/showFormAdd":
			showFromAdd(req, resp);
			break;
	
		case "/person/edit":
			editPerson(req, resp);
			break;
		case "/person/delete":
			deletePerson(req, resp);
			break;
		default:
			showListPerson(req, resp);
			break;
		}
		
		

	}

	private void deletePerson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int personID = Integer.parseInt(req.getParameter("personID"));
		
		personDao.deletePerson(personID);
		resp.sendRedirect("personList.jsp");

	}

	private void editPerson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int personID = Integer.parseInt(req.getParameter("personID"));
		Person p = personDao.getPersonByID(personID);
		
		req.setAttribute("person", p);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/savePersonForm.jsp");
		dispatcher.forward(req, resp);		
	}

	
	private void showFromAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person person = new Person();
		req.setAttribute("person", person);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/savePersonForm.jsp");
		dispatcher.forward(req, resp);
		
	}

	private void showListPerson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Person> list = personDao.getAllPerson();
		req.setAttribute("listPerson", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/personList.jsp");
		dispatcher.forward(req, resp);
	}

	private void savePerson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Person p = new Person(id, name, email);	
		personDao.savePerson(p);		
		resp.sendRedirect("person/list");
		
	}

	private String getAction(String uri) {
		String[] temp = uri.split("person");
		return "/person".concat(temp[temp.length - 1]);
	}
}
