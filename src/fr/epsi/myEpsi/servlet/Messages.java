package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IMessageDao;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.MessageDao;
import fr.epsi.myEpsi.dao.UserDAO;
import fr.epsi.myEpsi.forms.InscriptionForm;
import fr.epsi.myEpsi.forms.MessagesForm;

@WebServlet("/Messages")
public class Messages extends HttpServlet {
	 public static final String VUE = "/Messages.jsp";
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User utilisateur =  (User) session.getAttribute("sessionUtilisateur"); //récupère l'utilisateur de la session
		
		if(utilisateur == null)
		{
			  response.sendRedirect("Connection");
		}
		else{
			
		
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			IMessageDao messageDAO = new MessageDao();
			
			//récup list message Pub
			List<Message> listMessagePub = messageDAO.getListOfMessagesPublic();
			request.setAttribute( "listMessagesPub", listMessagePub );
			
			
	
			//récup list message priv
			List<Message> listMessagePriv = messageDAO.getListMessagePerso( utilisateur);
			request.setAttribute( "listMessagesPriv", listMessagePriv );
			 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 MessagesForm formMessage = new MessagesForm();

	        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
		 
	        formMessage.nouveauMessage( request );


	        
	        response.sendRedirect("Messages");
	    
	}

}
