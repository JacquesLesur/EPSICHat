package fr.epsi.myEpsi.dao;

import java.sql.ResultSet;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;

public class Main {
	
public static void main(String[] args) {
		
		
		IMessageDao message = new MessageDao();
		
		List<Message> messages = message.getListOfMessages();
		for(int i=0; i<messages.size(); i++)
		{
			System.out.println(messages.get(i).getContent());
		}
//		try {
//		
//	    Statement stmt = con.createStatement();
//	    resultats = stmt.executeQuery(requete);
//
//	    ResultSetMetaData rsmd = resultats.getMetaData();
//	    int nbCols = rsmd.getColumnCount();
//
//	    while (resultats.next()) {
//	        for (int i = 1; i <= nbCols; i++) {
//	            System.out.println(resultats.getString(i) + " ");
//	         }
//	         System.out.println();
//	     }
//
//	    resultats.close();
//
//	} catch (SQLException e) {
//	//traitement de l'exception
//		e.printStackTrace();
//	}
	ResultSet resultats = null;
//	String requete = "SELECT * FROM Users";
//	Connection con = getConnection();
//	
//	try {
//		
//	    Statement stmt = con.createStatement();
//	    resultats = stmt.executeQuery(requete);
//
//	    ResultSetMetaData rsmd = resultats.getMetaData();
//	    int nbCols = rsmd.getColumnCount();
//
//	    while (resultats.next()) {
//	        for (int i = 1; i <= nbCols; i++) {
//	            System.out.println(resultats.getString(i) + " ");
//	         }
//	         System.out.println();
//	     }
//
//	    resultats.close();
//
//	} catch (SQLException e) {
//	//traitement de l'exception
//		e.printStackTrace();
//	}

	}
}
