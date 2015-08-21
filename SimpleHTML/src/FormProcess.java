

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormProcess
 */
@WebServlet("/FormProcess")
public class FormProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String message="";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String others=request.getParameter("othervalue");
		String others1=request.getParameter("othervalue1");
		System.out.println(others);
		System.out.println(others1);
		if(others.equals("")&& others1.equals(""))
		message+="The Name Entered is:<br>"+fname+" "+lname;
		else if(!(others.equals("")) && others1.equals(""))
			message+="The Name Entered is:<br>"+others+" "+lname;	
		else if(others.equals("") && !( others1.equals("")))
			message+="The Name Entered is:<br>"+fname+" "+others1;
		else
			message+="The Name Entered is:<br>"+others+" "+others1;
		request.setAttribute("message", message);
		
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
	}

}
