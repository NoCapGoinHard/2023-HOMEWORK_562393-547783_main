package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	//costruttore ComandoPosa
	public ComandoPosa(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	/*
	 * 
	 *esecuzione del comando
	 */
	@Override
		public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		System.out.println("Oggetto posato!");
	}
	
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}

