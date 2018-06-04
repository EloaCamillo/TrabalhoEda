package cidadegrafo;

public class Adjacente {

	private Cidade cidade;
	private int distancia;
	private int distanciaAEstrela;
	
	public Adjacente(Cidade cidade, int distancia) {
		
		this.cidade = cidade;
		this.distancia = distancia;
		// Distância em linha reta - distância pela estrada
		this.distanciaAEstrela = this.cidade.getDistanciaObjetivo() + this.distancia;
	}


	public int getDistancia() {
		return distancia;
	}


	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public int getDistanciaAEstrela() {
		return distanciaAEstrela;
	}
	
}
