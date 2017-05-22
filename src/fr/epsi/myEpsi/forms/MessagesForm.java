package fr.epsi.myEpsi.forms;

import javax.servlet.http.HttpServletRequest;

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
	        
	        IMessageDao messageDAO = new MessageDao();
	        IUserDao userDAO = new UserDAO();
	        
	        String  id = "ADMIN";
			User user2 = userDAO.getUserById(id);
	        Message newMessage = new Message(null, titre, message, user2, null, null, 0);
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
