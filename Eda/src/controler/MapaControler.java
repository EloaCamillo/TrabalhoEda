package controler;

import model.Adjacente;
import model.Cidade;
import model.Local;
import mb.*;
import service.*;

public class MapaControler {
	
	private Cidade portoUniao;
	private Cidade pauloFrontin;
	private Cidade canoinhas;
	private Cidade Irati;
	private Cidade palmeira;
	private Cidade campoLargo;
	private Cidade curitiba;
	private Cidade balsaNova;
	private Cidade araucaria;
	private Cidade SaoJose;
	private Cidade contenda;
	private Cidade mafra;
	private Cidade tijucas;
	private Cidade lapa;
	private Cidade saoMateus;
	private Cidade tresBarras;
	
	public void adicionaAdjacentes(Cidade c1, Cidade c2, Services a) {
		c1.getAdjacentes().add(a.CriaAdjacente(c2));
	}
	public void salvaCidade(Cidade c, CidadeMB mb) {
		mb.setCidade(c);
		mb.salvar();
	}
	
	public void salvaAdjacentes(Cidade c, AdjacenteMB mb)
	{
		for (Adjacente ad : c.getAdjacentes()) {
			mb.setAdjacente(ad);
			mb.salvar();
		}
	}
	public void salvaLocal(String rua, int latitude, int longitude, LocalMB mb, Services a)
	{
		Local l = new Local();
		l.setLatitude(latitude);
		l.setLongitude(longitude);
		l.setRua(rua);
		l.setDistancia(a.calculaDistancia());
		
		mb.setLocal(l);
		mb.salvar();
	}
	
	
	public MapaControler() {
		Services a = new Services();
		LocalMB localMB = new LocalMB();
		CidadeMB cidadeMB = new CidadeMB();
		AdjacenteMB adjacenteMB = new AdjacenteMB();
		Cidade c = new Cidade();
		
		portoUniao = a.CriaCidade("Porto União", 203);
		cidadeMB.setCidade(portoUniao);
		cidadeMB.salvar();
		
		pauloFrontin= a.CriaCidade("Paulo Frontin", 172);
		cidadeMB.setCidade(pauloFrontin);
		cidadeMB.salvar();
		canoinhas = a.CriaCidade("Canoinhas", 141);
		cidadeMB.setCidade(canoinhas);
		cidadeMB.salvar();
		Irati = a.CriaCidade("Irati", 139);
		cidadeMB.setCidade(Irati);
		cidadeMB.salvar();
		palmeira = a.CriaCidade("Palmeira", 59);
		cidadeMB.setCidade(palmeira);
		cidadeMB.salvar();
        campoLargo = a.CriaCidade("Campo Largo", 27);
		cidadeMB.setCidade(campoLargo);
		cidadeMB.salvar();
        curitiba = a.CriaCidade("Curitiba",0);
		cidadeMB.setCidade(curitiba);
		cidadeMB.salvar();
        balsaNova = a.CriaCidade("Balsa Nova",41);
        salvaCidade(balsaNova,cidadeMB);
        
        araucaria = a.CriaCidade("Araucária",23);
        salvaCidade(araucaria,cidadeMB);
        
        SaoJose = a.CriaCidade("São José dos Pinhais",13);
        salvaCidade(SaoJose,cidadeMB);
        
        contenda = a.CriaCidade("Contenda",39);
        salvaCidade(contenda,cidadeMB);
        
        mafra = a.CriaCidade("Mafra",94);
        salvaCidade(mafra,cidadeMB);
        
        tijucas = a.CriaCidade("Tijucas do Sul",56);
        salvaCidade(tijucas,cidadeMB);
        
        lapa = a.CriaCidade("Lapa",74);
        salvaCidade(lapa,cidadeMB);
        
        saoMateus = a.CriaCidade("São Mateus do Sul",23);
        salvaCidade(saoMateus,cidadeMB);
        
        tresBarras = a.CriaCidade("Três Barras",131);
        salvaCidade(tresBarras,cidadeMB);
		
		
		//Definir as arestas
        portoUniao.getAdjacentes().add(a.CriaAdjacente(pauloFrontin));
        portoUniao.getAdjacentes().add(a.CriaAdjacente(canoinhas));
        portoUniao.getAdjacentes().add(a.CriaAdjacente(saoMateus));
        salvaAdjacentes(portoUniao,adjacenteMB);
        
        pauloFrontin.getAdjacentes().add(a.CriaAdjacente(portoUniao));
        pauloFrontin.getAdjacentes().add(a.CriaAdjacente(Irati));
        salvaAdjacentes(pauloFrontin,adjacenteMB);
        
        canoinhas.getAdjacentes().add(a.CriaAdjacente(portoUniao));
        canoinhas.getAdjacentes().add(a.CriaAdjacente(tresBarras));
        canoinhas.getAdjacentes().add(a.CriaAdjacente(mafra));
        salvaAdjacentes(canoinhas,adjacenteMB);
       
        Irati.getAdjacentes().add(a.CriaAdjacente(pauloFrontin));
        Irati.getAdjacentes().add(a.CriaAdjacente(palmeira));
        Irati.getAdjacentes().add(a.CriaAdjacente(saoMateus));
        salvaAdjacentes(Irati,adjacenteMB);
  
        palmeira.getAdjacentes().add(a.CriaAdjacente(Irati));
        palmeira.getAdjacentes().add(a.CriaAdjacente(saoMateus));
        palmeira.getAdjacentes().add(a.CriaAdjacente(campoLargo));
        salvaAdjacentes(palmeira,adjacenteMB);
        
        campoLargo.getAdjacentes().add(a.CriaAdjacente(palmeira));
        campoLargo.getAdjacentes().add(a.CriaAdjacente(balsaNova));
        campoLargo.getAdjacentes().add(a.CriaAdjacente(curitiba));
        salvaAdjacentes(campoLargo,adjacenteMB);
             
        adicionaAdjacentes(curitiba, campoLargo,a);
        adicionaAdjacentes(curitiba, balsaNova,a);
        adicionaAdjacentes(curitiba, araucaria,a);
        adicionaAdjacentes(curitiba, SaoJose,a);
        salvaAdjacentes(curitiba,adjacenteMB);
        

        adicionaAdjacentes(balsaNova, curitiba,a);
        adicionaAdjacentes(balsaNova, campoLargo,a);
        adicionaAdjacentes(balsaNova, contenda,a);
        salvaAdjacentes(balsaNova,adjacenteMB);
        
        adicionaAdjacentes(araucaria, curitiba,a);
        adicionaAdjacentes(araucaria, contenda,a);
        salvaAdjacentes(araucaria,adjacenteMB);

        adicionaAdjacentes(SaoJose, curitiba,a);
        adicionaAdjacentes(SaoJose, tijucas,a);
        salvaAdjacentes(SaoJose,adjacenteMB);

        adicionaAdjacentes(contenda, balsaNova,a);
        adicionaAdjacentes(contenda, araucaria,a);
        adicionaAdjacentes(contenda, lapa,a);
        salvaAdjacentes(contenda,adjacenteMB);
        
        adicionaAdjacentes(mafra, tijucas,a);
        adicionaAdjacentes(mafra, lapa,a);
        adicionaAdjacentes(mafra, canoinhas,a);
        salvaAdjacentes(mafra,adjacenteMB);
        
        adicionaAdjacentes(tijucas, mafra,a);
        adicionaAdjacentes(tijucas, SaoJose,a);
        salvaAdjacentes(tijucas,adjacenteMB);

        adicionaAdjacentes(lapa, contenda,a);
        adicionaAdjacentes(lapa, saoMateus,a);
        adicionaAdjacentes(lapa, mafra,a);
        salvaAdjacentes(lapa,adjacenteMB);

        adicionaAdjacentes(saoMateus, palmeira,a);
        adicionaAdjacentes(saoMateus, Irati,a);
        adicionaAdjacentes(saoMateus, lapa,a);
        adicionaAdjacentes(saoMateus, tresBarras,a);
        adicionaAdjacentes(saoMateus, portoUniao,a);
        salvaAdjacentes(saoMateus,adjacenteMB);

        adicionaAdjacentes(tresBarras, saoMateus,a);
        adicionaAdjacentes(tresBarras, canoinhas,a);
        salvaAdjacentes(tresBarras,adjacenteMB);
        
	}
 
	public Cidade getPortoUniao() {
		return portoUniao;
	}

	public void setPortoUniao(Cidade portoUniao) {
		this.portoUniao = portoUniao;
	}

	public Cidade getPauloFrontin() {
		return pauloFrontin;
	}

	public void setPauloFrontin(Cidade pauloFrontin) {
		this.pauloFrontin = pauloFrontin;
	}

	public Cidade getCanoinhas() {
		return canoinhas;
	}

	public void setCanoinhas(Cidade canoinhas) {
		this.canoinhas = canoinhas;
	}

	public Cidade getIrati() {
		return Irati;
	}

	public void setIrati(Cidade irati) {
		Irati = irati;
	}

	public Cidade getPalmeira() {
		return palmeira;
	}

	public void setPalmeira(Cidade palmeira) {
		this.palmeira = palmeira;
	}

	public Cidade getCampoLargo() {
		return campoLargo;
	}

	public void setCampoLargo(Cidade campoLargo) {
		this.campoLargo = campoLargo;
	}

	public Cidade getCuritiba() {
		return curitiba;
	}

	public void setCuritiba(Cidade curitiba) {
		this.curitiba = curitiba;
	}

	public Cidade getBalsaNova() {
		return balsaNova;
	}

	public void setBalsaNova(Cidade balsaNova) {
		this.balsaNova = balsaNova;
	}

	public Cidade getAraucaria() {
		return araucaria;
	}

	public void setAraucaria(Cidade araucaria) {
		this.araucaria = araucaria;
	}

	public Cidade getSaoJose() {
		return SaoJose;
	}

	public void setSaoJose(Cidade saoJose) {
		SaoJose = saoJose;
	}

	public Cidade getContenda() {
		return contenda;
	}

	public void setContenda(Cidade contenda) {
		this.contenda = contenda;
	}

	public Cidade getMafra() {
		return mafra;
	}

	public void setMafra(Cidade mafra) {
		this.mafra = mafra;
	}

	public Cidade getTijucas() {
		return tijucas;
	}

	public void setTijucas(Cidade tijucas) {
		this.tijucas = tijucas;
	}

	public Cidade getLapa() {
		return lapa;
	}

	public void setLapa(Cidade lapa) {
		this.lapa = lapa;
	}

	public Cidade getSaoMateus() {
		return saoMateus;
	}

	public void setSaoMateus(Cidade saoMateus) {
		this.saoMateus = saoMateus;
	}

	public Cidade getTresBarras() {
		return tresBarras;
	}

	public void setTresBarras(Cidade tresBarras) {
		this.tresBarras = tresBarras;
	}

	
}
