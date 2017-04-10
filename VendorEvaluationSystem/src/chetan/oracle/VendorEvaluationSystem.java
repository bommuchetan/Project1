package chetan.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VendorEvaluationSystem")
public class VendorEvaluationSystem extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Example e;
    public VendorEvaluationSystem() 
    {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		e=new Example();
		response.setContentType("text/html");
		String uname=request.getParameter("vendorName");
		String email=request.getParameter("vendorEmail");
		
		int complete=Integer.parseInt(request.getParameter("completeness"));
		String safety=request.getParameter("safety");
		String cost=request.getParameter("costeffectiveness");
		String recommend=request.getParameter("recommendation");
		int overallRating=Integer.parseInt(request.getParameter("rating"));
		String comments=request.getParameter("comments");
				
		PrintWriter out=response.getWriter();
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "+"transitional//en\">\n";
		String title="Welcome !";	
		out.println(docType +"<html>\n"+"<head><title>" + "Form" + "</title></head>\n" +"<body bgcolor=\"#e0e0eb\">" 
		+"<h1 align=\"center\">"+ title + "</h1>\n" +"\n"
		+"<h2 align=\"center\"> Your form has been submitted</h2>"
		+"<table frame=\"box\" style=\"width:80%\" align=\"center\" border=\"1\">"
		+"<colgroup><col style=\"background-color:#ff6666\"></col>  <col style=\"background-color:#ff6666\"></col></colgroup>"
		+"<tr><th>Attribute</th><th>Value</th></tr>"
		+"<tr><td>Name:</td><td> "+ request.getParameter("vendorName") + "</td></tr>" 
		+"<tr><td>Email:</td><td> "+ request.getParameter("vendorEmail") +"</td></tr>" 
		+"<tr><td>completeness:</td><td> "+ request.getParameter("completeness") +"</td></tr>" 
		+"<tr><td>safety:</td><td> "+ request.getParameter("safety") +"</td></tr>" 
		+"<tr><td>costeffectiveness:</td><td> "+ request.getParameter("costeffectiveness") +"</td></tr>" 
		+"<tr><td>recommend:</td><td> "+ request.getParameter("recommendation") +"</td></tr>"
		+"<tr><td>Overall rating:</td><td> "+ request.getParameter("rating") +"</td></tr>" 
		+"<tr><td>comments:</td><td> "+ request.getParameter("comments") +"</td></tr>"
		+ "</table>"+"<br>"+"<div align=\"center\">"
		+"<a href=\"VendorEvaluationSystemHomePage.html\">Logout</div>"
		+"</body></html>");
		
		//out.println("<script language=\"javascript\">alert('here');</script>");
		try
		{
			e.insertVendorData(uname, email);
			e.insertEvalSystemData(complete, safety, cost, recommend, overallRating, comments);
			e.c.commit();
			e.c.close();
		} 
		catch (Exception e) 
		{
			System.out.println( e.getClass().getName() +": "+ e.getMessage() );
	        System.exit(0);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		out.println("<h1>hi doPost</h1>");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
