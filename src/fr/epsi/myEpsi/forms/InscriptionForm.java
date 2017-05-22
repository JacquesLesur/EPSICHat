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

public class InscriptionForm {
	
    private static final String CHAMP_PASS = "password";
    private static final String CHAMP_NOM  = "nom";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public User inscrireUtilisateur( HttpServletRequest request ) {
      
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String nom = getValeurChamp( request, CHAMP_NOM );

        User utilisateur = new User(nom,motDePasse,false);

    

        try {
            validationMotsDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        System.out.println(motDePasse);
        utilisateur.setPassword( motDePasse );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        System.out.println(nom);
        utilisateur.setId( nom );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return utilisateur;
    }
    
 


    private void validationMotsDePasse( String motDePasse ) throws Exception {

        if ( motDePasse != null ) {

          if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }

        } else {

            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }


    private void validationNom( String nom ) throws Exception {
    	IUserDao userDAO = new UserDAO();
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
        if ( userDAO.getUserById(nom) != null ) {
            throw new Exception( "Ce nom d'utilisateur existe déjà" );
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