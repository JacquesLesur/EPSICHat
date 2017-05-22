package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.dao.IMessageDao;
import fr.epsi.myEpsi.dao.MessageDao;

@WebServlet("/Messages")
public class Messages extends HttpServlet {
	 public static final String VUE = "/Messages.jsp";
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		IMessageDao messageDAO = new MessageDao();
		List<Message> listMessage = messageDAO.getListOfMessagesPublic();
		request.setAttribute( "listMessages", listMessage );

		 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
