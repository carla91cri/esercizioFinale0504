package it.epicode.esercizioFinale0504.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.epicode.esercizioFinale0504.model.Fornitore;

public class FornitoreDAO implements AbstractArchivioFornitore {

	public static final String LISTA_FORNITORI = "SELECT codice_fornitore, nome, indirizzo, citta FROM negozio.fornitore";
	
	@Override
	public List<Fornitore> listaFornitori() throws SQLException {
		
		List<Fornitore> listaFornitori = new ArrayList<>();
		try(Connection connect = ConnectionUtils.createConnection();
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery(LISTA_FORNITORI)){
			
			while(rs.next()) {
				
				listaFornitori.add(new Fornitore(rs.getInt("codice_fornitore"), rs.getString("nome"), 
												 rs.getString("indirizzo"), rs.getString("citta")));
			}	
		}
		return listaFornitori;
	}

	public static final String CREA_FORNITORE = "INSERT INTO negozio.fornitore (codice_fornitore, nome, indirizzo, citta)"
            									+ " VALUES (?, ?, ?, ?)";
	
	@Override
    public void inserisciFornitore(Fornitore f) throws SQLException {
        try (Connection connect = ConnectionUtils.createConnection();
             PreparedStatement psi = connect.prepareStatement(CREA_FORNITORE);) {

            psi.setInt(1, f.getCodiceFornitore());
            psi.setString(2, f.getNome());
            psi.setString(3, f.getIndirizzo());
            psi.setString(4, f.getCitta());
            
            psi.executeUpdate();
        }
    }
	
	public static final String RIMUOVI_FORNITORE = "DELETE FROM negozio.fornitore WHERE codice_fornitore=?";
	
	@Override
    public void rimuoviFornitore(int codiceFornitore) throws SQLException {
        try (Connection connect = ConnectionUtils.createConnection();
             PreparedStatement ps = connect.prepareStatement(RIMUOVI_FORNITORE)) {
            ps.setInt(1, codiceFornitore);
            ps.executeUpdate();
        }
    }
	
	// AL MOMENTO E' DISABILITATO E QUINDI NON IMPLEMENTO IL METODO
//	public List<Prodotto> listaProdotti() {
//
//	}
	
}














