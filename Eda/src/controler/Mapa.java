package controler;

import model.Adjacente;
import model.Cidade;
import mb.*;

public class Mapa {
	
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
	
	public Cidade CriaCidade(String nome, int valor) {
		Cidade a = new Cidade();
		a.setNome(nome);
		a.setDistanciaObjetivo(valor);
		return a;
	}
	
	public Adjacente CriaAdjacente(Cidade cidade) {
		Adjacente a = new Adjacente();
		a.setCidade(cidade);
		return a;
	}
	public void addCidadeAdjacente(Cidade c, Adjacente cidade) {
        c.getAdjacentes().add(cidade);
    }
	
	public Mapa() {
		LocalMB local = new LocalMB();
		CidadeMB cidadeMB = new CidadeMB();

		portoUniao = CriaCidade("Porto União", 203);
		pauloFrontin= CriaCidade("Paulo Frontin", 172);
		canoinhas = CriaCidade("Canoinhas", 141);
		Irati = CriaCidade("Irati", 139);
		palmeira = CriaCidade("Palmeira", 59);
        campoLargo = CriaCidade("Campo Largo", 27);
        curitiba = CriaCidade("Curitiba",0);
        balsaNova = CriaCidade("Balsa Nova",41);
        araucaria = CriaCidade("Araucária",23);
        SaoJose = CriaCidade("São José dos Pinhais",13);
        contenda = CriaCidade("Contenda",39);
        mafra = CriaCidade("Mafra",94);
        tijucas = CriaCidade("Tijucas do Sul",56);
        lapa = CriaCidade("Lapa",74);
        saoMateus = CriaCidade("São Mateus do Sul",23);
        tresBarras = CriaCidade("Três Barras",131);
		
		
		//Definir as arestas
        addCidadeAdjacente(portoUniao,CriaAdjacente(pauloFrontin));
        addCidadeAdjacente(portoUniao,CriaAdjacente(canoinhas));
        addCidadeAdjacente(portoUniao,CriaAdjacente(saoMateus));
        
        addCidadeAdjacente(pauloFrontin,CriaAdjacente(portoUniao));
        addCidadeAdjacente(pauloFrontin,CriaAdjacente(Irati));
        
        addCidadeAdjacente(canoinhas,CriaAdjacente(portoUniao));
        addCidadeAdjacente(canoinhas,CriaAdjacente(tresBarras));
        addCidadeAdjacente(canoinhas,CriaAdjacente(mafra));
        
        addCidadeAdjacente(Irati,CriaAdjacente(pauloFrontin));
        addCidadeAdjacente(Irati,CriaAdjacente(palmeira));
        addCidadeAdjacente(Irati,CriaAdjacente(saoMateus));
        
        addCidadeAdjacente(palmeira,CriaAdjacente(Irati));
        addCidadeAdjacente(palmeira,CriaAdjacente(saoMateus));
        addCidadeAdjacente(palmeira,CriaAdjacente(campoLargo));
        
        addCidadeAdjacente(campoLargo,CriaAdjacente(palmeira));
        addCidadeAdjacente(campoLargo,CriaAdjacente(balsaNova));
        addCidadeAdjacente(campoLargo,CriaAdjacente(curitiba));
        
        addCidadeAdjacente(curitiba,CriaAdjacente(campoLargo));
        addCidadeAdjacente(curitiba,CriaAdjacente(balsaNova));
        addCidadeAdjacente(curitiba,CriaAdjacente(araucaria));
        addCidadeAdjacente(curitiba,CriaAdjacente(SaoJose));
        
        addCidadeAdjacente(balsaNova,CriaAdjacente(curitiba));
        addCidadeAdjacente(balsaNova,CriaAdjacente(campoLargo));
        addCidadeAdjacente(balsaNova,CriaAdjacente(contenda));
        
        addCidadeAdjacente(araucaria,CriaAdjacente(curitiba));
        addCidadeAdjacente(araucaria,CriaAdjacente(contenda));
        
        addCidadeAdjacente(SaoJose,CriaAdjacente(curitiba));
        addCidadeAdjacente(SaoJose,CriaAdjacente(tijucas));
        
        addCidadeAdjacente(contenda,CriaAdjacente(balsaNova));
        addCidadeAdjacente(contenda,CriaAdjacente(araucaria));
        addCidadeAdjacente(contenda,CriaAdjacente(lapa));
        
        addCidadeAdjacente(mafra,CriaAdjacente(tijucas));
        addCidadeAdjacente(mafra,CriaAdjacente(lapa));
        addCidadeAdjacente(mafra,CriaAdjacente(canoinhas));
        
        addCidadeAdjacente(tijucas,CriaAdjacente(mafra));
        addCidadeAdjacente(tijucas,CriaAdjacente(SaoJose));
        
        addCidadeAdjacente(lapa,CriaAdjacente(contenda));
        addCidadeAdjacente(lapa,CriaAdjacente(saoMateus));
        addCidadeAdjacente(lapa,CriaAdjacente(mafra));
        
        addCidadeAdjacente(saoMateus,CriaAdjacente(palmeira));
        addCidadeAdjacente(saoMateus,CriaAdjacente(Irati));
        addCidadeAdjacente(saoMateus,CriaAdjacente(lapa));
        addCidadeAdjacente(saoMateus,CriaAdjacente(tresBarras));
        addCidadeAdjacente(saoMateus,CriaAdjacente(portoUniao));
        
        addCidadeAdjacente(tresBarras,CriaAdjacente(saoMateus));
        addCidadeAdjacente(tresBarras,CriaAdjacente(canoinhas));
		
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
