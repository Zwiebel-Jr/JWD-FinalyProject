package by.epam.controller.command.impl;

import by.epam.bean.User;
import by.epam.controller.command.Command;
import by.epam.dao.DAOException;
import by.epam.dao.impl.UserDAOimpl;
import by.epam.service.ServiceException;
import by.epam.service.ServiceProvider;
import by.epam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("name");
		//request.getParameter("surname");
		
		//RegistrationInfo regInfo = new RegistrationInfo();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//make user object
		User userModel = new User(name, email, password);

		//create database model
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		try {

			if (userService.registration(userModel)) {
				response.sendRedirect("Controller?command=gotoindexpage&message=Registration ok");
				System.out.println("class SaveNewUser implements Command");
				// UserDatabase regUser = new UserDatabase(ConnectionPro.getConnection());
				//if (regUser.saveUser(userModel)) {
				//     response.sendRedirect("index.jsp");
			} else {
				String errorMessage = "User Available";
				HttpSession regSession = request.getSession();
				regSession.setAttribute("RegError", errorMessage);
				response.sendRedirect("Controller?command=gotoindexpage");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		//regInfo - show in console

		
		//request.setAttribute("message", "Registration OK");
		//response.sendRedirect("Controller?command=gotoindexpage&message=Registration ok");
		//response.sendRedirect("Controller?command=gotoindexpage");
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		//requestDispatcher.forward(request, response);
		
	}

}
