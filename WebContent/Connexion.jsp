<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection</title>
</head>
<body>
        <form method="post" action="Connection">
            <fieldset>
                <legend>Connection</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="${param.nom}" size="20" maxlength="20" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="password" name="${param.password}" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Connection" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>