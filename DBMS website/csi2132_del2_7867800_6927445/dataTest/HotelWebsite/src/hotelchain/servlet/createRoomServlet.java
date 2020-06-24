package hotelchain.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelChains.beans.Address;
import hotelChains.beans.Customer;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;

@WebServlet(urlPatterns = { "/createRoom" })
public class createRoomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public createRoomServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createRoomView.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String priceInst = (String) request.getParameter("price");
		String capacityInst = (String) request.getParameter("capacity");
		String view = (String) request.getParameter("view");
		String extended = (String) request.getParameter("extended");
		String quality = (String) request.getParameter("quality");
		
		HttpSession session = request.getSession();

		int price = 0;

		try {
			price = Integer.parseInt(priceInst);
		} catch (Exception e) {
		}

		boolean hasError = false;
		String errorString = null;

		if (priceInst == null || priceInst.length() == 0) {
			hasError = true;
			errorString = "Price is Required!";
		}  else if (capacityInst.isEmpty()) {
			hasError = true;
			errorString = "Capacity is Required!";
		} else if (view.isEmpty()) {
			hasError = true;
			errorString = "View is Required!";
		} else if (extended.isEmpty()) {
			hasError = true;
			errorString = "Extension Property is Required!";
		} else if (quality.isEmpty()) {
			hasError = true;
			errorString = "Quality is Required!";
		} else {

			Connection conn = MyUtils.getStoredConnection(request);

			try {
				// insert room into DB
				DBUtils.insertRoom(conn, session, price, capacityInst, view, extended, quality);
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}

		}
		
			response.sendRedirect(request.getContextPath() + "/employeeHome");
	}

}
