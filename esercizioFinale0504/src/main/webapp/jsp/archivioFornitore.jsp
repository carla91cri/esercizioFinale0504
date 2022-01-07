<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.epicode.esercizioFinale0504.controller.Controller"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivio Fornitore</title>
</head>
<body>
	<table>
		<tr>
			<th>codice fornitore</th>
			<th>nome</th>
			<th>indirizzo</th>
			<th>citta</th>
		</tr>

		<c:forEach var="fornitore" items="${CHIAVE_LISTA_FORNITORI}">

			<tr>
				<td>${fornitore.codiceFornitore}</td>
				<td>${fornitore.nome}</td>
				<td>${fornitore.indirizzo}</td>
				<td>${fornitore.citta}</td>

				<td>
					<form method="post" action="cancellaFornitore.do">
						<input type="hidden" name="codiceFornitore"
							value="${fornitore.codiceFornitore}"> <input
							type="submit" value="elimina">
					</form>
				</td>
			</tr>

		</c:forEach>

	</table>

	<a href="formInserimentoFornitore.do">
		<button>Insierisci nuovo fornitore</button>
	</a>

</body>
</html>