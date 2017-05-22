package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class UserDAO implements IUserDao {
	
	final static Logger log = org.apache.logging.log4j.LogManager.getRootLogger();


	@Override
	public List<User> getListOfUsers() {
		List<User> listUser = new ArrayList();
	
		 ResultSet resultats = null;
		 
			String requete = "SELECT * FROM USERS";
			log.debug(requete);
			connexion connect = new  connexion();
			Connection con = connect.getConnection();
			
			//on récupère les utilisateurs de la base
			try {
				
			    Statement stmt = con.createStatement();
			    resultats = stmt.executeQuery(requete);

			  
			   
			    
			    //on créé les objets user et on les ajout à la liste
			    while (resultats.next()) {
			       User user = new User(resultats.getString(1),
			    		   resultats.getString(2),
			    		   resultats.getBoolean(3));
			       
			       listUser.add(user);
			        
			     }

			    resultats.close();

			} catch (SQLException e) {
			//traitement de l'exception
				e.printStackTrace();
			}
		
			
			//on ferme la connection
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listUser;
	}

	@Override
	public User getUserById(String id) {
		User user = null;
		String requete = "SELECT * FROM USERS u "
				+ "	where u.ID = '" +id +"'" ;
		log.debug(requete);
			connexion connect = new  connexion();
			Connection con = connect.getConnection();
			 ResultSet resultats = null;
			
			//on récupère les utilisateurs de la base
		try {
			
		    Statement stmt = con.createStatement();
		    resultats = stmt.executeQuery(requete);
		    while(resultats.next())
			 {
		    	
		    	  user = new User(resultats.getString(1),
			    		   resultats.getString(2),
			    		   resultats.getBoolean(3));
			 }
		}
		catch (SQLException e) {
		//traitement de l'exception
			e.printStackTrace();
		}
	
		
		//on ferme la connection
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void addUser(User user) {
		 ResultSet resultats = null;
			String requete = "INSERT INTO USERS VALUES('"+user.getId() +"','"+user.getPassword()+"'," +user.getAdministrator()+")";
			log.debug(requete);
			connexion connect = new  connexion();
			Connection con = connect.getConnection();
			
			//on récupère les utilisateurs de la base
			try {
				
			    Statement stmt = con.createStatement();
			    resultats = stmt.executeQuery(requete);
			} catch (SQLException e) {
			//traitement de l'exception
				e.printStackTrace();
			}
		
			
			//on ferme la connection
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void updateUser(User user) {
		ResultSet resultats = null;
		String requete = "	UPDATE USERS SET PASSWORD  = '"+user.getPassword()+"',ISADMINISTRATOR = "+user.getAdministrator()+" WHERE id = '"+user.getId()+"'";
		log.debug(requete);
		connexion connect = new  connexion();
		Connection con = connect.getConnection();
		
		//on récupère les utilisateurs de la base
		try {
			
		    Statement stmt = con.createStatement();
		    resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
		//traitement de l'exception
			e.printStackTrace();
		}
	
		
		//on ferme la connection
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		ResultSet resultats = null;
		String requete = "	DELETE FROM USERS WHERE ID = '"+user.getId()+"'";
		log.debug(requete);
		connexion connect = new  connexion();
		Connection con = connect.getConnection();
		
		//on récupère les utilisateurs de la base
		try {
			
		    Statement stmt = con.createStatement();
		    resultats = stmt.executeQuery(requete);
		} catch (SQLException e) {
		//traitement de l'exception
			e.printStackTrace();
		}
	
		
		//on ferme la connection
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
