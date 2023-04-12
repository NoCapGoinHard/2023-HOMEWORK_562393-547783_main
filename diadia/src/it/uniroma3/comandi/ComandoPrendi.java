package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	//costruttore ComandoPrendi
	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	/**
	 * esecuzione del comando
	 */
	@Override
		public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(a);
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		io.mostraMessaggio("Oggetto preso!");
	}


	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
