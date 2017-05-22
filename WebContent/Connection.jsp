<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
body{ background:url("img/trigle.png") no-repeat center center fixed; background-size:cover;}
</style>
<title>Connection</title>
</head>
<body>
	<div class="container" style="padding-top: 30px">
	<div class="col-sm-4">
		<div class="jumbotron" style="background-color:#F0F4F4 !important;">
        <form method="post" action="Connection">
            <fieldset>
                <legend>Connection</legend>
               
                
                <div class="form-group">
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" class="form-control"/>
                </div>
                <br />
				
				<div class="form-group">
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" class="form-control"/>
				</div>
                <br />

                <input type="submit" value="Connection" class="btn btn-primary" />
                <br />
            </fieldset>
        </form>
        </div>
        </div>
    </div>
</body>
</html>