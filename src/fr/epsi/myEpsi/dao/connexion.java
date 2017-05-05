package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class connexion {
	
	
	public static void main(String[] args) {
		String URL = "localhost:9003"; 
		String login = "log"; 
		String password = "pass";
		
	
	
	ResultSet resultats = null;
	String requete = "SELECT * FROM Users";
	Connection con = getConnection();
	
	try {
		
	    Statement stmt = con.createStatement();
	    resultats = stmt.executeQuery(requete);

	    ResultSetMetaData rsmd = resultats.getMetaData();
	    int nbCols = rsmd.getColumnCount();

	    while (resultats.next()) {
	        for (int i = 1; i <= nbCols; i++) {
	            System.out.print(resultats.getString(i) + " ");
	         }
	         System.out.println();
	     }

	    resultats.close();

	} catch (SQLException e) {
	//traitement de l'exception
		e.printStackTrace();
	}

	}
	public static Connection getConnection(){
		try{ 
			Class.forName("org.hsqldb.jdbcDriver");
			 Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA",""); 
			 return con;
		  //interaction avec la base 
		} 
		catch(ClassNotFoundException | SQLException e){ 
		   //cf. Comment gérer les erreurs ? 
			e.printStackTrace();
			return null;
		} 
		finally{ 
		   //cf. Comment bien fermer une connexion ? 
			
		        }
	}
}
