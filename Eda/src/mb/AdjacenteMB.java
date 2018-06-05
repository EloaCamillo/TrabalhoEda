package mb;
import java.util.List;

import model.Adjacente;
import service.AdjacenteService;

public class AdjacenteMB {
	private AdjacenteService service = new AdjacenteService();
	private Adjacente objeto = new Adjacente();
	
	public void salvar()
	{
		service.salvar(objeto);
		objeto = new Adjacente();
	}
	
	public Adjacente getAdjacente() {
		return objeto;
	}

	public void setAdjacente(Adjacente objeto) {
		this.objeto = objeto;
	}

	public void remover(Adjacente objeto) {
		service.remove(objeto);
	} 

	public List<Adjacente> getAdjacentes() {
		return service.getCadastros();
	}
}
