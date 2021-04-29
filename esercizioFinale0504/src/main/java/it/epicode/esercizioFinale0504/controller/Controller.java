package it.epicode.esercizioFinale0504.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.esercizioFinale0504.connection.AbstractArchivioFornitore;
import it.epicode.esercizioFinale0504.connection.FornitoreDAO;
import it.epicode.esercizioFinale0504.model.Fornitore;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AbstractArchivioFornitore archivioFornitore = new FornitoreDAO();
	public static final String CHIAVE_LISTA_FORNITORI = "CHIAVE_LISTA_FORNITORI";
	public static final String LISTA_FORNITORI_DESTINATION = "archivioFornitore.jsp";
	public static final String AGGIUNGI_FORNITORE_DESTINATION = "inserisciFornitore.jsp";
	public static final String PAGINA_DI_ERRORE_DESTINATION = "paginaDiErrore.jsp";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		int pos = path.lastIndexOf('/');
		String action = path.substring(pos+1, path.length()-3);
		try{
			switch (action) {
				case "listaFornitori": listaFornitori(request, response);
				break;
				case "inserisciFornitore": inserisciFornitore(request, response);
				break;
				case "formInserimentoFornitore": formInserimentoFornitore(request, response);
				break;
				case "listaProdotti": listaProdotti(request, response);
				break;
				case "cancellaFornitore": cancellaFornitore(request, response);
				break;
				default: mostraPaginaDiErrore(request, response);
		
			}
		} catch(SQLException e) {
			e.printStackTrace();
			mostraPaginaDiErrore(request, response);
		}
	}

	private void listaFornitori(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		List<Fornitore> result = archivioFornitore.listaFornitori();
		request.setAttribute(CHIAVE_LISTA_FORNITORI, result); 
		RequestDispatcher disp = request.getRequestDispatcher(LISTA_FORNITORI_DESTINATION); 
		disp.forward(request, response);
	}
	
	private void inserisciFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String codiceFornitoreStringa = request.getParameter("codiceFornitore");
		int codiceFornitore = Integer.parseInt(codiceFornitoreStringa);
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		archivioFornitore.inserisciFornitore(new Fornitore(codiceFornitore, nome, indirizzo, citta));
		listaFornitori(request, response);
	}
	
	private void formInserimentoFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher(AGGIUNGI_FORNITORE_DESTINATION);
        disp.forward(request, response);
    }
	
	private void cancellaFornitore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int codiceFornitore= Integer.parseInt(request.getParameter("codiceFornitore"));
		archivioFornitore.rimuoviFornitore(codiceFornitore);
		listaFornitori(request, response);
	}
	
	// AL MOMENTO E' DISABILITATO E QUINDI NON IMPLEMENTO IL METODO
	private void listaProdotti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	}
	
	private void mostraPaginaDiErrore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher disp = request.getRequestDispatcher(PAGINA_DI_ERRORE_DESTINATION); 
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
