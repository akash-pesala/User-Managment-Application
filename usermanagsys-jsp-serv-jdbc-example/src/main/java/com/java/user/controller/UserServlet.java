package com.java.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.user.dao.UserDaoImp;
import com.java.user.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {

	UserDaoImp udao;
	public void init() {
	    udao = new UserDaoImp();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println("actions : "+action);
		try
		{			
			switch(action)
			{
			case "/new":
				showUserForm(req, resp);
				break;
			case "/insert":
				insertuser(req,resp);
				break;
			case "/update":
				updateuser(req,resp);
				break;
			case "/delete":
				deleteuser(req,resp);
				break;
			case "/edit":
				showeditform(req,resp);
				break;
			case "/list":
                listUser(req, resp);
                break;
			default:
				listUser(req, resp);
				break;
			}
		}
		catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		List<User> listUser = udao.selectAllUsers();
		req.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	private void showUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(req, resp);
	}

	private void insertuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		User newuser = new User(name,email,country);
		udao.insertUser(newuser);
		resp.sendRedirect("list");
	}
	private void deleteuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		udao.deleteUser(id);
		resp.sendRedirect("list");
	}
	private void updateuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		User upduser = new User(id,name,email,country);
		udao.updateUser(upduser);
		resp.sendRedirect("list");
	}
	
	
	private void showeditform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		User exitinguser = udao.selectUser(id);
		req.setAttribute("user", exitinguser);
		req.getRequestDispatcher("user-form.jsp").forward(req, resp);
	}
}
