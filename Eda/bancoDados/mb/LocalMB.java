package mb;
import java.util.List;

import model.Local;
import service.LocalService;

public class LocalMB {
	private LocalService service = new LocalService();
	private Local objeto = new Local();
	
	public void salvar()
	{
		service.salvar(objeto);
		objeto = new Local();
	}
	
	public Local getLocal() {
		return objeto;
	}

	public void setLocal(Local objeto) {
		this.objeto = objeto;
	}

	public void remover(Local objeto) {
		service.remove(objeto);
	} 

	public List<Local> getLocais() {
		return service.getCadastros();
	}
}
