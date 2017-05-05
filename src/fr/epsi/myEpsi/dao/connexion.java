package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;

public class connexion {
	String URL = "localhost:9003"; 
	String login = "log"; 
	String password = "pass";
	
	
	public  Connection getConnection(){
		Connection con = null;
		try{ 
			Class.forName("org.hsqldb.jdbcDriver");
			  con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA",""); 
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
//			try {
//				con.close();
//			} catch (SQLException e) {
//			
//				e.printStackTrace();
//			}
		        }
	}
}
