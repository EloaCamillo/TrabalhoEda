package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(cascade = CascadeType.ALL)
	private int id;
	private String nome;
    private boolean visitado;
    @ManyToMany
    private List<Adjacente> adjacentes;
    private int distanciaObjetivo;

    /*
    public Cidade(String nome, int distanciaObjetivo) {
        this.nome = nome;
        visitado = false;
        adjacentes = new ArrayList<Adjacente>();
        this.distanciaObjetivo= distanciaObjetivo;
    }
    */
    
    public int getDistanciaObjetivo() {
		return distanciaObjetivo;
	}

	public void setDistanciaObjetivo(int distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}
 /*
	public void addCidadeAdjacente(Adjacente cidade) {
        this.adjacentes.add(cidade);
    }
*/
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	 


}
