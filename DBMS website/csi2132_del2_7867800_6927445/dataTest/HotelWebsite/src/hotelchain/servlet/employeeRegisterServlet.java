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

import hotelChains.beans.*;
import hotelchain.utils.DBUtils;
import hotelchain.utils.MyUtils;

@WebServlet(urlPatterns = { "/employeeRegister" })
public class employeeRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public employeeRegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/employeeRegisterView.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String first = (String) request.getParameter("first");
		String last = (String) request.getParameter("last");
		String sinInst = (String) request.getParameter("sin");
		String pass = (String) request.getParameter("pass");
		Date dateInst = Calendar.getInstance().getTime();

		// NEED TO MAKE ADDRESS OBJ THEN LINK ID TO CUSTOMER
		String street = (String) request.getParameter("street");
		String city = (String) request.getParameter("city");
		String country = (String) request.getParameter("country");
		String position = (String) request.getParameter("position");
		String hotel_idS = (String) request.getParameter("hotel_id");
		
		int hotel_id =0;
		try {
            hotel_id = Integer.parseInt(hotel_idS);
            
        } catch (Exception e) {
        }
		

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date = dateFormat.format(dateInst);

		int sin = 0;

		try {
			sin = Integer.parseInt(sinInst);
		} catch (Exception e) {
		}

		boolean hasError = false;
		String errorString = null;

		if (sinInst == null || sinInst.length() == 0) {
			hasError = true;
			errorString = "Sin is Required!";
		} else if (first.isEmpty()) {
			hasError = true;
			errorString = "First Name is Required!";
		} else if (last.isEmpty()) {
			hasError = true;
			errorString = "Last Name is Required!";
		} else if (pass.isEmpty()) {
			hasError = true;
			errorString = "Password is Required!";
		} else if (street.isEmpty()) {
			hasError = true;
			errorString = "Street is Required!";
		} else if (city.isEmpty()) {
			hasError = true;
			errorString = "City is Required!";
		} else if (country.isEmpty()) {
			hasError = true;
			errorString = "Country is Required!";
		} else {

			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setCountry(country);

			Connection conn = MyUtils.getStoredConnection(request);

			try {
				// insert address into DB
				DBUtils.insertAddress(conn, address);
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}

			// concatenate first and last name
			String full_name = first + " " + last;
			// create customer object
			Employee employee = new Employee(sin, hotel_id, full_name, address.getAddress_id(), position, pass);

			try {
				// insert customer into DB
				DBUtils.insertEmployee(conn, employee);
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}

		}

		// Store information to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		// request.setAttribute("customer", customer);

		// If error, forward to Edit page.
		if (errorString != null) {
			response.sendRedirect(request.getContextPath() + "/employeeRegister");
		}
		// If everything works.
		// Redirect to the login page.
		else {
			response.sendRedirect(request.getContextPath() + "/employeeLogin");
		}

	}

}
