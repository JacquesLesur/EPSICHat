package fr.epsi.myEpsi.forms;


import java.util.HashMap;

import java.util.Map;	
import java.io.IOException;	
import javax.servlet.http.HttpServletRequest;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDAO;

/**
 * Servlet implementation class InscriptionForm
 */

public class ConnectionForm {
	
    private static final String CHAMP_PASS = "password";
    private static final String CHAMP_NOM  = "nom";
    
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    User user = null;
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public User connectionUtilisateur( HttpServletRequest request ) {
      
    	
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String nom = getValeurChamp( request, CHAMP_NOM );
        User utilisateur = null;
        try {
        	validationConnection( nom, motDePasse );
        } catch ( Exception e ) {
            setErreur( "connection ", e.getMessage() );
        }
        System.out.println(getErreurs());
       return user;
       
    }

    private void validationConnection( String nom, String motDePasse ) throws Exception {
    	IUserDao userDAO = new UserDAO();
    	user = userDAO.getUserById(nom);
    	String passwordDAO = user.getPassword();
        if ( user != null  ) {
            System.out.println(user.getPassword() + " " + motDePasse);
	          if (!motDePasse.equals(passwordDAO))
	          {
	        	 throw new Exception( " Mot de passe incorrect." );  
	          }
        } 
        else {
        	throw new Exception( " Nom incorrect." );
        }
    }


    /*

     * Ajoute un message correspondant au champ spécifié à la map des erreurs.

     */

    private void setErreur( String champ, String message ) {

        erreurs.put( champ, message );
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


