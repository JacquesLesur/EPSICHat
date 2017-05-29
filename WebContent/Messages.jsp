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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body{ background:url("img/trigle.jpg") no-repeat center center fixed; background-size:cover;}
</style>
<title>Message</title>
</head>

<body>
<div class="container text-center">
<div class="row">
				
    			<div class="col-sm-3 well">
  				<form method="post" action="Messages">
            
                <div class="form-group">
                <p>Ecrivez votre message</p>
                
                <label for="titre">Titre</label>
                <input type="text" id="titre" name="titre" value="" class="form-control imput-sm" />
                <br />

                <label for="message">Message <span class="requis"></span></label>
                <!--<input type="text" id="message" name="message" value="" class="form-control imput-sm" />-->
		        <textarea class="form-control" rows="5" id="message" name="message"></textarea>
                <br />
				<INPUT type= "radio" name="STATUS" value="public" checked="checked"> Public
				<INPUT type= "radio" name="STATUS" value="prive"> Privé
				<br />
                <input type="submit" value="Envoyer" class="btn btn-primary" />
                <br />
                </div>
            
        </form>
        </div>
        
        <div class="col-sm-3">
	    <div class="well">
       <H5>Messages Publiques</H5><br>
		<% 
		
		
			List<Message> listMessagesPub  = (List<Message>) request.getAttribute("listMessagesPub");


				for (Message message : listMessagesPub)
				{
	            out.println( message.getAuthor().getId()+" :"+message.getTitle()+"   "+"<br>"+message.getContent()+"<br><hr>" );
				}

            %>
            
         </div>
         </div>
         
         <div class="col-sm-3">
	     <div class="well">
		 <h5>Messages Privé</h5><br>
		 
		 	<% 
		
		
			List<Message> listMessagePriv  = (List<Message>) request.getAttribute("listMessagesPriv");

			for (Message message : listMessagePriv)
			{
            out.println( message.getAuthor().getId()+" :"+message.getTitle()+"   "+"<br>"+message.getContent()+"<br><hr>" );
			}
		 
            %>
            </div>
            </div>
</div>
</div>
</body>
</html>