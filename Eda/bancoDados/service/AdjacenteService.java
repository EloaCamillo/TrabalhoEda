package service;

import java.util.List;

import dao.AdjacenteDAO;
import model.Adjacente;

public class AdjacenteService {
private AdjacenteDAO dao = new AdjacenteDAO();
	public AdjacenteService()
	{
		
	}
	
	public void salvar(Adjacente cadastro)
	{
		cadastro = dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void alterar(Adjacente cadastro)
	{
		dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void remove(Adjacente cadastro)
	{
		cadastro = dao.getById(Adjacente.class, cadastro.getId());
		dao.remove(cadastro);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Adjacente> getCadastros()
	{
		List <Adjacente> list = dao.getAll(Adjacente.class);
		dao.closeEntityManager();
		return list;
		
	}
}
