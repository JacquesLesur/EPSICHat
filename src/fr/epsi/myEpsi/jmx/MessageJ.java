package fr.epsi.myEpsi.jmx;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IMessageDao;
import fr.epsi.myEpsi.dao.MessageDao;

public class MessageJ implements MessageJMBean{
	
	IMessageDao messageDao = new MessageDao();
	
	@Override
	public void addMessage(String titre, String message) {
		// TODO Auto-generated method stub
		User user = new User("ADMIN2","password",true);
		Message mess = new Message(null, titre, message, user, null, null, 2);
		messageDao.addMessage(mess);
	}

	@Override
	public int NombreMessage() {
		// TODO Auto-generated method stub
		
		int numberMessage = messageDao.getListOfMessagesPublic().size();
		return numberMessage;
	}

}
