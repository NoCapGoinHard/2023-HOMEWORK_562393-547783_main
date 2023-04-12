package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Questa interfaccia è addetta ai comandi.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public interface Comando {
	
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);
	
	public String getParametro();
	
	/**
	 * setter parametro del comando
	 */
	public void setParametro(String parametro);
	
	
}
	//PRIMA CHE DIVENISSE UN'INTERFACE SI OCCUPAVA DEI COMANDI LUI 
//	
//
//    private String nome;
//    private String parametro;
//
//    public Comando(String istruzione) {
//		Scanner scannerDiParole = new Scanner(istruzione);
//
//		// prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			this.nome = scannerDiParole.next(); 
//
//		// seconda parola: eventuale parametro
//		if (scannerDiParole.hasNext())
//			this.parametro = scannerDiParole.next();
//    }
//
//    public String getNome() {
//        return this.nome;
//    }
//
//    public String getParametro() {
//        return this.parametro;
//    }
//
//    public boolean sconosciuto() {
//        return (this.nome == null);
//    }
//}