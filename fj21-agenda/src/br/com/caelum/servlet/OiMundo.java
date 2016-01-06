package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Primeiro Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Oi mundo Servlet!</h1>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
