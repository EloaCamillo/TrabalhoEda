package cidadegrafo;

import java.util.ArrayList;
import java.util.List;


public class Cidade {

	private String nome;
    private boolean visitado;
    private List<Adjacente> adjacentes;
    private int distanciaObjetivo;

    public Cidade(String nome, int distanciaObjetivo) {
        this.nome = nome;
        visitado = false;
        adjacentes = new ArrayList<Adjacente>();
        this.distanciaObjetivo= distanciaObjetivo;
    }
    
    public int getDistanciaObjetivo() {
		return distanciaObjetivo;
	}

	public void setDistanciaObjetivo(int distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}

	public void addCidadeAdjacente(Adjacente cidade) {
        adjacentes.add(cidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Adjacente> getAdjacentes() {
        return adjacentes;
    }
    
	 


}
