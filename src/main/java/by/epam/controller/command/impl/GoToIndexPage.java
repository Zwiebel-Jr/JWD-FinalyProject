package by.epam.controller.command.impl;


import by.epam.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

public class GoToIndexPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ServiceProvider provider = ServiceProvider.getInstance();
		//NewsService newsService = provider.getNewsService();

		//	List<News> news = newsService.takeAll();

		//request.setAttribute("news", news);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index-jsp.jsp");
		requestDispatcher.forward(request, response);


	}

}
