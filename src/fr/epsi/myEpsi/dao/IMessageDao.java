package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public interface IMessageDao {

	List<Message> getListOfMessages(User user);
	Message getMessage(Long id);
	void addMessage(Message message);
	void updateMessageStatus(Message message, int status);
	void deleteMessage(Message message);
	public class MessageDao implements IMessageDao{

		@Override
		public List<Message> getListOfMessages(User user) {
			List<Message> listMessage = new ArrayList();
			
			 ResultSet resultats = null;
				String requete = "SELECT * FROM Users";
				Connection con = getConnection();
				
				try {
					
				    Statement stmt = con.createStatement();
				    resultats = stmt.executeQuery(requete);

				    ResultSetMetaData rsmd = resultats.getMetaData();
				    int nbCols = rsmd.getColumnCount();

				    while (resultats.next()) {
				       Message message = new Message();
				       message.setId(resultats.getLong(1));
				       message.setTitle(resultats.getString(2));
				       message.setContent(resultats.getString(3));
				       listMessage.add(message);
				         System.out.println(resultats.getString(2));
				     }

				    resultats.close();

				} catch (SQLException e) {
				//traitement de l'exception
					e.printStackTrace();
				}
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Message getMessage(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addMessage(Message message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateMessageStatus(Message message, int status) {
			//Status st = Status
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteMessage(Message message) {
			// TODO Auto-generated method stub
			
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
}
