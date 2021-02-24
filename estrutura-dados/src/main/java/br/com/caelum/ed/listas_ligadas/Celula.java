package br.com.caelum.ed.listas_ligadas;

public class Celula {
	
	private Celula proxima;
	private Celula anterior;
	
	private Object elemento;
	
	public Celula(Celula proxima, Object elemento) {
		this.proxima = proxima;
		this.elemento = elemento;
	}
	
	public Celula(Object elemento) {
		this.elemento = elemento;
	}

	/**
	 * @return the proxima
	 */
	public Celula getProxima() {
		return proxima;
	}

	/**
	 * @param proxima the proxima to set
	 */
	public void setProxima(Celula proxima) {
		this.proxima = proxima;
	}

	/**
	 * @return the elemento
	 */
	public Object getElemento() {
		return elemento;
	}

	/**
	 * @return the anterior
	 */
	public Celula getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
	
	
}
