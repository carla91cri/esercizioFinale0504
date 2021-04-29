<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="it.epicode.esercizioFinale0504.controller.Controller"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci fornitore</title>
</head>
<body>

	<form action="inserisciFornitore.do" method="post">
	
	<label>Inserisci codice fornitore</label>
	<input type="number" name="codiceFornitore"><br>
	<label>Inserisci il nome fornitore</label>
	<input type="text" name="nome"><br>
	<label>Inserisci l'indirizzo del fornitore</label>
	<input type="text" name="indirizzo"><br>
	<label>Inserisci la città del fornitore</label>
	<input type="text" name="citta"><br>
	
	<input type="submit" value="conferma"><br>
	
	</form>
	

</body>
</html>