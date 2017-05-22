package fr.epsi.myEpsi.dao;

import java.sql.ResultSet;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class Main {
	
public static void main(String[] args) {
		
		
		IMessageDao messageDAO = new MessageDao();
		IUserDao userDAO = new UserDAO();
		User user = new User("ADMIN2","password",true);
		User userUpdate = new User("ADMIN2","pass",true);
		
		
		//Suprimer un utilisateur de la base
	//	userDAO.deleteUser(user);
		
		//créé un user dans la base
		userDAO.addUser(user);
		
		//Update User
		userDAO.updateUser(userUpdate);
		
		
		//récupère tout les users	
		List<User> listUser = userDAO.getListOfUsers();
		for(int i=0; i<listUser.size(); i++)
		{
			System.out.println("Les IDs des Users : " +listUser.get(i).getId());
		}
		
		//Récupère l'user en fonction de L'ID
		String  id = "ADMIN";
		User user2 = userDAO.getUserById(id);
		System.out.println( "Password de l'user ADMIN :" +user2.getPassword());
		
		
		
		//récupère tout les messages
		List<Message> messages = messageDAO.getListOfMessages(user2);
		for(int i=0; i<messages.size(); i++)
		{
			System.out.println("Le contenu des messages : " +messages.get(i).getId());
		}
		
		//récupère le message en fontion de l'ID
		long longID = 1;
		Message message = messageDAO.getMessage(longID);
		System.out.println( message.getContent());

		//ajout message en base
		Message newMessage = new Message(null, "titre", "content", user2, null, null, 0);
		messageDAO.addMessage(newMessage);


	}
}
