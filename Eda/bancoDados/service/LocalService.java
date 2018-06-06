package service;

import java.util.List;

import dao.LocalDAO;
import model.Local;

public class LocalService {
	private LocalDAO dao = new LocalDAO();
	public LocalService()
	{
		
	}
	
	public void salvar(Local cadastro)
	{
		cadastro = dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void alterar(Local cadastro)
	{
		dao.save(cadastro);
		dao.closeEntityManager();
	}
	public void remove(Local cadastro)
	{
		cadastro = dao.getById(Local.class, cadastro.getId());
		dao.remove(cadastro);
		dao.closeEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List <Local> getCadastros()
	{
		List <Local> list = dao.getAll(Local.class);
		dao.closeEntityManager();
		return list;
		
	}
}
