package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getLabirinto().getStanzaCorrente().getDescrizione();
		System.out.println("\n");
		int cfu = partita.getGiocatore().getCfu();
		
		System.out.printf("\n%d\n", cfu);
		partita.getGiocatore().getBorsa().toString();
		System.out.println("\n");
	}
}
