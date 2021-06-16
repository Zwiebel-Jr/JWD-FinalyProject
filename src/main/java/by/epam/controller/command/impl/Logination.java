package by.epam.controller.command.impl;

import by.epam.bean.User;
import by.epam.controller.command.Command;
import by.epam.service.ServiceException;
import by.epam.service.ServiceProvider;
import by.epam.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logination implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login;
		String password;

		login = request.getParameter("email");
		password = request.getParameter("password");

		//ServiceProvider provider = ServiceProvider.getInstance();
		//UserService userService = provider.getUserService();

		User user = null;
		RequestDispatcher requestDispatcher = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		try{
			user = userService.authorization(login, password);
			if (user == null) {

				response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");
				return;
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("Controller?command=gotowelcomepage");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		//user = userService.authorization(login, password);



		//HttpSession session = request.getSession(true);
		//session.setAttribute("auth", true);
//			session.setAttribute("role", user.getRole());
		//session.setAttribute("role", "user");

		//response.sendRedirect("Controller?command=gotomainpage");

	}

}
