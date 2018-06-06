package service;

import java.util.List;

import dao.CidadeDAO;
import model.Cidade;

public class CidadeService {
	private CidadeDAO dao = new CidadeDAO();
	public CidadeService()
	{
		
	}
	
	public void salvar(Cidade cadastro)
	{
		cadastro = dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void alterar(Cidade cadastro)
	{
		dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void remove(Cidade cadastro)
	{
		cadastro = dao.getById(Cidade.class, cadastro.getId());
		dao.remove(cadastro);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Cidade> getCadastros()
	{
		List <Cidade> list = dao.getAll(Cidade.class);
		dao.closeEntityManager();
		return list;
		
	}
}
