package com.manage.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.manage.user.*;
/**
 * Servlet implementation class hello
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
//        UserManagement.loadUser();
        System.out.println("Login Servlet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Login servlet Get method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("ID");
		String pwd = request.getParameter("Pwd");
		String confpwd = request.getParameter("confPwd");
		if(confpwd == null ){
			boolean usrControl = UserManagement.CheckUser(id, pwd, request.getSession().getId());
			System.out.println("Login servlet Post method");
			System.out.println("===========ID==========="+id);
			System.out.println("===========PWD==========="+pwd);
			if(usrControl){
				response.sendRedirect("ChatUI.jsp");
				System.out.println("=========request id========="+request.getSession().getId());
			}else{
				System.out.println("Login Failed");
				//response.sendRedirect("loginFail.jsp");
				out.write("Invalid Credentials");
				UserManagement.printUser();
			}
		}else if(pwd.equals(confpwd)){
			System.out.println("Check new user");
			boolean chk=UserManagement.createUser(id, pwd, request.getSession().getId());
			if(chk){
			response.sendRedirect("login.jsp");
			}else{
				response.getWriter().write("User Already Exists");
			}
		}
		out.close();
	}

}
