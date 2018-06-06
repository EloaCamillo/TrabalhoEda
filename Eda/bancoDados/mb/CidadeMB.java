package mb;
import java.util.List;

import model.Cidade;
import service.CidadeService;

public class CidadeMB {
	private CidadeService service = new CidadeService();
	private Cidade objeto = new Cidade();
	
	public void salvar()
	{
		service.salvar(objeto);
		objeto = new Cidade();
	}
	
	public Cidade getCidade() {
		return objeto;
	}

	public void setCidade(Cidade objeto) {
		this.objeto = objeto;
	}

	public void remover(Cidade objeto) {
		service.remove(objeto);
	} 

	public List<Cidade> getCidades() {
		return service.getCadastros();
	}
}
