package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;



	public class MessageDao implements IMessageDao{

		@Override
		public List<Message> getListOfMessages() {
			List<Message> listMessage = new ArrayList();
			
			 ResultSet resultats = null;
				String requete = "SELECT * FROM Messages";
				connexion connect = new  connexion();
				Connection con = connect.getConnection();
				
				//on récupère les utilisateurs de la base
				try {
					
				    Statement stmt = con.createStatement();
				    resultats = stmt.executeQuery(requete);

				    ResultSetMetaData rsmd = resultats.getMetaData();
				    int nbCols = rsmd.getColumnCount();
				    
				    //on créé les objets message et on les ajout à la liste
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
			
				
				//on ferme la connection
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return listMessage;
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
	
		
	}


