<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="fr.epsi.myEpsi.beans.Message"
      import="fr.epsi.myEpsi.beans.Message"
	import="fr.epsi.myEpsi.dao.IMessageDao"
	import="fr.epsi.myEpsi.dao.MessageDao "
	import="java.util.List"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
		<% 
		
		
			List<Message> listMessage  = (List<Message>) request.getAttribute("listMessages");
			for (Message message : listMessage)
			{
            out.println( message.getTitle()+"   "+message.getAuthor().getId()+"<br>"+message.getContent()+"<br><br>" );
			}
            %>
		
</body>
</html>