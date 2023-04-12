package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}
	
/**
 * esecuzione del comando
 */
 @Override
	 public void esegui(Partita partita) {
		 
		 Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		 Stanza prossimaStanza = null;
		 
		 if(direzione == null) {
			 System.out.println("Dove vuoi andare?"
			 		+ "Devi specificare una direzione");
			 return;
		 }
		 
		 prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		 
			 if(prossimaStanza == null) {
				 System.out.println("Direzione inesistente");
				 return;
			 }
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
 
 
 @Override
 public void setParametro(String parametro) {
	 this.direzione = parametro;
 }
}