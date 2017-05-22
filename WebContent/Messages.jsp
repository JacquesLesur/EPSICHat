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

  <form method="post" action="Messages">
            
                
                <p>Ecrivez votre message</p>
                
                <label for="titre">Titre</label>
                <input type="text" id="titre" name="titre" value="" size="20" maxlength="20" />
                <br />

                <label for="message">Message <span class="requis">*</span></label>
                <input type="text" id="message" name="message" value="" size="20" maxlength="255" />
                <br />

                <input type="submit" value="Envoyer" class="sansLabel" />
                <br />
            
        </form>
		<% 
		
		
			List<Message> listMessage  = (List<Message>) request.getAttribute("listMessages");
			for (Message message : listMessage)
			{
            out.println( message.getAuthor().getId()+" :"+message.getTitle()+"   "+"<br>"+message.getContent()+"<br><br>" );
			}
            %>
		
</body>
</html>