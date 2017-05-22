package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDAO;
import fr.epsi.myEpsi.forms.ConnectionForm;
import fr.epsi.myEpsi.forms.InscriptionForm;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE = "/Connection.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
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
		 ConnectionForm form = new ConnectionForm();
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */

         User utilisateur = form.connectionUtilisateur(request);
         
         HttpSession session = request.getSession();
         session.setAttribute( ATT_SESSION_USER, utilisateur );
         request.setAttribute( ATT_FORM, form );
         
         if ( form.getErreurs().isEmpty() ) {
             session.setAttribute( ATT_SESSION_USER, utilisateur );
             response.sendRedirect("Messages");
         } else {
             session.setAttribute( ATT_SESSION_USER, null );
             this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
         }

      /* Stockage du formulaire et du bean dans l'objet request */
        
	}

}
