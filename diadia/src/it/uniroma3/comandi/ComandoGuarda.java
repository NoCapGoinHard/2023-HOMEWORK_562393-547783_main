package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getLabirinto().getStanzaCorrente().getDescrizione();
		System.out.println("\n");
		partita.getGiocatore().getCfu();
		System.out.println("\n");
		partita.getGiocatore().getBorsa().toString();
		System.out.println("\n");
	}
}
