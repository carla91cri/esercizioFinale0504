package it.epicode.esercizioFinale0504.model;

public class Fornitore {

	private int codiceFornitore;
	private String nome;
	private String indirizzo;
	private String citta;

	public Fornitore(int codiceFornitore, String nome, String indirizzo, String citta) {

		this.codiceFornitore = codiceFornitore;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public int getCodiceFornitore() {
		return codiceFornitore;
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

}
