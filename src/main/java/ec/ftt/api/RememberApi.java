package ec.ftt.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.ftt.dao.RememberDao;
import ec.ftt.model.Remember;

/**
 * Servlet implementation class RememberApi
 */
@WebServlet("/RememberApi")
public class RememberApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RememberApi() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
	          throws ServletException, IOException {
	      setAccessControlHeaders(resp);
	      resp.setStatus(HttpServletResponse.SC_OK);
	  }
	
	 private void setAccessControlHeaders(HttpServletResponse resp) {
	      resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "GET");
	      resp.setHeader("Access-Control-Allow-Methods", "POST");
	      resp.setHeader("Access-Control-Allow-Methods", "PUT");
	      resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
	  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setStatus(418); //200 - OK - Padrão (Default)

		setAccessControlHeaders(response);
		
		String rememberId = request.getParameter("remember-id");
		
		RememberDao rememberDao = new RememberDao();
		
	    if(rememberId != null) {
	    	long id = Long.valueOf(rememberId);	    	
	    	
	        Remember remember = rememberDao.getRememberById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(remember));
	    	
	    } else {		    	
	    	
	    	List<Remember> remembers = rememberDao.getAllRemembers();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(remembers));

	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		setAccessControlHeaders(response);
		
		Remember r = new Remember(
				request.getParameter("remember-id"),
				request.getParameter("remember-question"),
				request.getParameter("remember-answer"),
				request.getParameter("remember-site")
				);
		
		RememberDao rememberDao = new RememberDao();
		
		rememberDao.addRemember(r);
		
		System.out.println(r);
		Gson gson = new Gson();

        response.getWriter().append(gson.toJson(r));
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		setAccessControlHeaders(response);
		
		response.setContentType("application/json"); //mimeType - https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		Remember r = new Remember(
				request.getParameter("remember-id"),
				request.getParameter("remember-question"),
				request.getParameter("remember-answer"),
				request.getParameter("remember-site")
				);
		RememberDao rememberDao = new RememberDao();
		
		rememberDao.updateRemember(r);
		
		System.out.println(r);
		
		response.getWriter().append(r.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.setStatus(418); //200 - OK - Padrão (Default)

		if (request.getParameter("remember-id") == null)
			 response.sendError(407, "Informe o ID do remember a ser retornado!!!" );
		else {
		Long rememberId = Long.valueOf(request.getParameter("Remember-id"));
		
		
		RememberDao rd = new RememberDao();
		
		rd.deleteRemember(rememberId);
		
		response.getWriter().append(request.getParameter("remember-id") + " Remember removido");
		}
	}

}
