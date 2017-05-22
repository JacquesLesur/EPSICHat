package fr.epsi.myEpsi.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IMessageDao;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.MessageDao;
import fr.epsi.myEpsi.dao.UserDAO;

public class MessagesForm {

	
	
	
	  public void nouveauMessage( HttpServletRequest request ) {
	      //todo vérifier si message pas null renvoyer un bool
	        String titre = getValeurChamp( request, "titre" );
	        String message = getValeurChamp( request, "message" );
	        String status = getValeurChamp( request, "STATUS" );
	        HttpSession session = request.getSession();
			User utilisateur =  (User) session.getAttribute("sessionUtilisateur"); //récupère l'utilisateur de la session
			
	        IMessageDao messageDAO = new MessageDao();
	        IUserDao userDAO = new UserDAO();
	        int StatusNbr=0;
	        
	        if(status.equals("prive"))
	        {
	        	StatusNbr = 1;
	        }
	        
	        Message newMessage = new Message(null, titre, message, utilisateur, null, null, StatusNbr);
	        System.out.println(status + StatusNbr);
			messageDAO.addMessage(newMessage);

	    


	       
	    }

	  /*

     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.

     */

    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {

        String valeur = request.getParameter( nomChamp );

        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
   
}
