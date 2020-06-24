package hotelchain.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotelChains.beans.Booking;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;

@WebServlet(urlPatterns = { "/confirmBooking" })
public class confirmBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public confirmBookingServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = MyUtils.getStoredConnection(request);

		String c_sin = (String) request.getParameter("c_sin");

		Booking booking = null;
		String errorString = null;

		HttpSession session = request.getSession();

		// look for booking

		try {
			booking = DBUtils.querySpecificBooking(conn, session, c_sin);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// add booking to renting table

		try {
			DBUtils.queryBookingToRenting(conn, session, c_sin);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// add to booking arching

		try {
			DBUtils.queryInsertBookingArchive(conn, session, c_sin);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// add to renting arching

		try {
			DBUtils.queryInsertRentingArchive(conn, session, c_sin);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// remove booking from booking table and add it to booking archive table

		try {
			DBUtils.queryDelete(conn, session, c_sin);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("booking", booking);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/confirmBookingView.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
