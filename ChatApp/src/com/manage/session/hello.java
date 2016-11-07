package com.manage.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hello
 */
@WebServlet("/hello")
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hello() {
        super();
        System.out.println("Hello Servlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Get method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello servlet Post method");
		//doGet(request, response);
		response.setContentType("text/html");
		System.out.println("============request id============"+request.getSession().getId());
		
		Date create = new Date(request.getSession().getCreationTime());
		Date access = new Date(request.getSession().getLastAccessedTime());
		
		System.out.println("============request timeCompare============"+access.compareTo(create));
		
		int interval=0;
		if (create.getHours() == access.getHours()) {
			if (create.getMinutes() <= access.getMinutes()) {
				interval = access.getMinutes() - create.getMinutes();
			} else {
				interval = 60 + create.getMinutes() - access.getMinutes();
			}
		} else {
			System.out.println("============session Timed out============");
		}
			
		System.out.println("============request getCreationTime============"+create);
		System.out.println("============request getLastAccessedTime============"+access);
		System.out.println("============request interval============"+interval);
		System.out.println("============request isNew============"+request.getSession().isNew());
		PrintWriter out = response.getWriter();
		//request.setAttribute("name", "value");
		response.sendRedirect("ChatUI.jsp");
		out.close();
	}

}
