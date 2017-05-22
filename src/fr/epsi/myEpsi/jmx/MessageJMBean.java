package fr.epsi.myEpsi.jmx;

public interface MessageJMBean {
	
	public int NombreMessage();
	void addMessage(String titre, String message);
}
