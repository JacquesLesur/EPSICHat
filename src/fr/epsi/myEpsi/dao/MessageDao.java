package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;



	public class MessageDao implements IMessageDao{

		final static Logger log = org.apache.logging.log4j.LogManager.getRootLogger();
		@Override
		public List<Message> getListOfMessages(User user) {
			List<Message> listMessage = new ArrayList();
			String userId = user.getId();
			 ResultSet resultats = null;
				String requete = "SELECT * FROM Messages m "
								+ "	where m.USER_ID = " +"'" +userId + "'";
				connexion connect = new  connexion();
				Connection con = connect.getConnection();
				
				//on récupère les utilisateurs de la base
				try {
					
				    Statement stmt = con.createStatement();
				    resultats = stmt.executeQuery(requete);

				  
				   
				    
				    //on créé les objets message et on les ajout à la liste
				    while (resultats.next()) {
				       Message message = new Message(resultats.getLong(1),
				    		   resultats.getString(2),
				    		   resultats.getString(3),
				    		   new User("ADMIN","password",true),// resultats.getObject(4),récupérer l'user en fonction de l'id quand l'userdao seras fini
				    		   resultats.getTimestamp(5),
				    		   resultats.getTimestamp(6),
				    		   resultats.getInt(7));
				       
				       listMessage.add(message);
				        
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
		public List<Message> getListOfMessagesPublic() {
			List<Message> listMessage = new ArrayList();
			
			 ResultSet resultats = null;
				String requete = "SELECT * FROM Messages m "
								+ "	where m.STATUS = 0"
								+ " order by CREATION_DATE DESC" ;
				connexion connect = new  connexion();
				Connection con = connect.getConnection();
				
				//on récupère les utilisateurs de la base
				try {
					
				    Statement stmt = con.createStatement();
				    resultats = stmt.executeQuery(requete);
				    System.out.println(resultats);
				  
				   
				    
				    //on créé les objets message et on les ajout à la liste
				    while (resultats.next()) {
				       Message message = new Message(resultats.getLong(1),
				    		   resultats.getString(2),
				    		   resultats.getString(3),
				    		   new User("ADMIN","password",true),// resultats.getObject(4),récupérer l'user en fonction de l'id quand l'userdao seras fini
				    		   resultats.getTimestamp(5),
				    		   resultats.getTimestamp(6),
				    		   resultats.getInt(7));
				       System.out.println(message.getContent());
				       listMessage.add(message);
				        
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
		public List<Message> getListMessagePerso(User user) {
			List<Message> listMessage = new ArrayList();
			
			 ResultSet resultats = null;
				String requete = "SELECT * FROM Messages m "
								+ "	where m.STATUS = 1" 
								+ " and USER_ID = '"+user.getId()+"' "
								+ " order by CREATION_DATE DESC" ;
				connexion connect = new  connexion();
				Connection con = connect.getConnection();
				
				//on récupère les utilisateurs de la base
				try {
					
				    Statement stmt = con.createStatement();
				    resultats = stmt.executeQuery(requete);
				    
				  
				   
				    
				    //on créé les objets message et on les ajout à la liste
				    while (resultats.next()) {
				       Message message = new Message(resultats.getLong(1),
				    		   resultats.getString(2),
				    		   resultats.getString(3),
				    		   new User("ADMIN","password",true),// resultats.getObject(4),récupérer l'user en fonction de l'id quand l'userdao seras fini
				    		   resultats.getTimestamp(5),
				    		   resultats.getTimestamp(6),
				    		   resultats.getInt(7));
				       System.out.println(message.getContent());
				       listMessage.add(message);
				        
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
			Message message = null;
			String requete = "SELECT * FROM Messages m "
					+ "	where m.ID = " +id ;
			log.debug(requete);
				connexion connect = new  connexion();
				Connection con = connect.getConnection();
				 ResultSet resultats = null;
				 IUserDao userDAO = new UserDAO();
				//on récupère les utilisateurs de la base
			try {
				
			    Statement stmt = con.createStatement();
			    resultats = stmt.executeQuery(requete);
			    while(resultats.next())
				 {
			    	System.out.println( resultats.getTimestamp(5));
					 message = new Message(resultats.getLong(1),
				    		   resultats.getString(2),
				    		   resultats.getString(3),
				    		  userDAO.getUserById(resultats.getString(4)),//caster vers le bon objets --> User
				    		   resultats.getTimestamp(5),
				    		   resultats.getTimestamp(6),
				    		   resultats.getInt(7));
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
	
			return message;
		}
		
		

		@Override
		public void addMessage(Message message) {
			 ResultSet resultats = null;
				String requete = "INSERT INTO MESSAGES VALUES("+message.getId() +",'"+message.getTitle()+"','" +message.getContent()+"','"+message.getAuthor().getId()+"','" + new Timestamp(System.currentTimeMillis())+"','" +
								new Timestamp(System.currentTimeMillis()) +"'," +  message.getStatus().ordinal() +")";
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
		public void updateMessageStatus(Message message, int status) {
			ResultSet resultats = null;
			String requete = "	UPDATE MESSAGES SET STATUS  = "+status+",UPDATE_DATE = '"+new Timestamp(System.currentTimeMillis()) +"' WHERE id = '"+message.getId()+"'";
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
		public void deleteMessage(Message message) {
			ResultSet resultats = null;
			String requete = "	DELETE FROM MESSAGES WHERE ID = '"+message.getId()+"'";
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


