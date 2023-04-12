package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoVai implements Comando {
	private String direzione;
	
	//costruttore comandoVai
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
			 io.mostraMessaggio("Dove vuoi andare?"
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

@Override
public String getParametro() {

	return this.direzione;
	}
}