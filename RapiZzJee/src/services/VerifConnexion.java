package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RapiZzDao;
import model.Person;

@WebServlet ("/VerifConnect")

public class VerifConnexion extends HttpServlet {

	private static final long serialVersionUID = 1L;
		

    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    	Class.forName(RapiZzDao.class.getName());
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        RapiZzDao rapiZz = RapiZzDao.getInstance();
        Person user = rapiZz.getPerson("mail", "pwd");;

    
       if(session.getAttribute("utilisateur") == null)
    	   session.setAttribute("utilisateur", user );        	    	

       else
    	   user = (Person) session.getAttribute("utilisateur");
       if (user == null) {
           request.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
       }
       else {
           	request.getServletContext().getRequestDispatcher("/AccueilPatron.html").forward(request, response);
          	request.setAttribute("nameUser", user.getNamePerson());   
           	request.setAttribute("surnameUser",user.getSurnamePerson()); 
       }
       
    	       
    }
}    

