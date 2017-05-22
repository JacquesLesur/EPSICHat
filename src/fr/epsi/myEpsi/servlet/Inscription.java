package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDAO;
import fr.epsi.myEpsi.forms.InscriptionForm;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/Inscription.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 InscriptionForm form = new InscriptionForm();

	        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */

	       User utilisateur = form.inscrireUtilisateur( request );

	      /* Stockage du formulaire et du bean dans l'objet request */

	        request.setAttribute( ATT_FORM, form );
	        request.setAttribute( ATT_USER, utilisateur );
	        IUserDao userDAO = new UserDAO();
	        userDAO.addUser(utilisateur);

	        response.sendRedirect("Connection");
	    
	}
}
