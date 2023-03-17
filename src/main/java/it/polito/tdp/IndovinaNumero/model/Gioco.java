package it.polito.tdp.IndovinaNumero.model;

public class Gioco {

	public enum OutcomeGioco{
		Vinto, 
		Perso, 
		TroppoAlto, 
		TroppoBasso
	}
	// Dati di funzionamento dell'applicazione
	/*
	 * Mettiamo queste variabili final, cioè fissi; dopo quando abbiamo messo le difficolta abbiamo tolto le variabili final
	 */
	private int TMax;
	private int NMax;
	private int NTentativiFatti;
	private int numeroSegreto;
	
	
	public void iniziaGioco(Difficolta livello) {
		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
	}


	public int getTMax() {
		return TMax;
	}


	public int getNMax() {
		return NMax;
	}


	public int getNTentativiFatti() {
		return NTentativiFatti;
	}


	public int getNumeroSegreto() {
		return numeroSegreto;
	}

	/**
	 * Funzione che esegue un tentativo di indovinare il numero segreto
	 * @param tentativo: il numero che tiriamo per indovinare il numero segreto
	 * @return un intero (OutcomeGioco è l'aggiornamento più leggibile): 0 se indovinato: 1 se abbiamo esaurito i tentativi senza indovinare (perso): 
	 * 2 e 3 se non abbiamo indovinato (ma abbiamo ancora tentativi), 2 se il numero è troppo alto
	 * 3 se il numero è troppo basso
	 */
	public OutcomeGioco faiTentativo(int tentativo) {
		// incrementiamo il numero di tentativi fatti
		this.NTentativiFatti++;
		
		// caso 0: vittoria
		if (tentativo == this.numeroSegreto) {
    		return OutcomeGioco.Vinto;
    	}
    	// caso 1: sconfitta
    	if (this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	
    	// caso 2/3: non abbiamo indovinato, il numero è troppo alto oppure troppo basso
    	if(tentativo >this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto;
    	}else  {
    		return OutcomeGioco.TroppoBasso;
    	}
	}
}
