package by.vsu.ist.controller.manager;

import by.vsu.ist.domain.Account;
import by.vsu.ist.service.AccountService;
import by.vsu.ist.service.ServiceContainer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manager/account/list.html")
public class AccountListController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(ServiceContainer container = new ServiceContainer()) {
			AccountService accountService = container.getAccountServiceInstance();
			List<Account> accounts = accountService.findAll();
			req.setAttribute("accounts", accounts);
			req.getRequestDispatcher("/WEB-INF/jsp/manager/account/list.jsp").forward(req, resp);
		} catch(SQLException e) {
			throw new ServletException(e);
		}
	}
}
