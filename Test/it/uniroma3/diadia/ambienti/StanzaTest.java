package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaTest {

	private static final int MAX_ATTREZZI = 10;
	private static final String ATTREZZO = "AttrezzoDiTest";
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final String NORD = "nord";
	protected Stanza stanza;
	private Attrezzo scudo;

	@BeforeEach
	void setUp() {
		this.stanza=new Stanza(STANZA);
		this.scudo = new Attrezzo("scudo", 2);
	}
	//Metodo di utilità
	private Stanza creaStanzaEImpostaAdiacente (Stanza stanzaDiPartenza, String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione,stanzaAdiacente);
		return stanzaAdiacente;
	}

	@Test
	void testImpostaStanzaAdiacente() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(NORD));
	}

	@Test
	void testGetStanzaAdiacenteEsistente() {
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		stanza.impostaStanzaAdiacente(NORD, adiacente);
		assertEquals(adiacente,stanza.getStanzaAdiacente(NORD));
	}

	@Test
	public void testGetStanzaAdiacenteInesistente() {
		assertNull(stanza.getStanzaAdiacente(NORD));
	}
	@Test
	public void testGetStanzaAdiacenteDirezioneNonValida() {
		String direzioneNonValida= "direzioneACaso";
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		stanza.impostaStanzaAdiacente(NORD, adiacente);
		assertNull(stanza.getStanzaAdiacente(direzioneNonValida));
	}

	@Test 
	public void testGetAttrezzoEsistente() {
		Attrezzo esistente = new Attrezzo(ATTREZZO,1);
		stanza.addAttrezzo(esistente);
		assertEquals(esistente,stanza.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testGetAttrezzoNonEsistente() {
		assertNull(stanza.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testGetAttrezzoNomeVuoto() {
		Attrezzo attrezzo = new Attrezzo (ATTREZZO,1);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo(""));
	}
	
	// controlla se il metodo non aggiunge altri attrezzi se la stanza è piena
	@Test
	public void testAddAttrezzoArrayPieno() {
		Attrezzo attrezzo = new Attrezzo("osso",10);
		for(int i = 0;i < MAX_ATTREZZI;i++)
			stanza.addAttrezzo(attrezzo);
		assertFalse(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
    void testAddAttrezzo() {
		assertEquals(true, stanza.addAttrezzo(scudo));
	}

	@Test 
	void testRemoveAttrezzo(){
		assertEquals(true, stanza.removeAttrezzo(scudo));
	}

	@Test 
	void testHasAttrezzo(){
		assertEquals (false, stanza.hasAttrezzo("scudo"));
	}

}