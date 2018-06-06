package main;

import controler.MapaControler;
import mb.CidadeMB;

public class AppPrinc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapaControler mapa = new MapaControler();
		CidadeMB mb = new CidadeMB();

		Gulosa g = new Gulosa (mapa.getPortoUniao());//objetivo
		g.buscar(mapa.getCuritiba());
		
		mapa= new MapaControler();
		VetorOrdenado vetor = new VetorOrdenado(5); 
		vetor.inserir(mapa.getPortoUniao());//203
		vetor.inserir(mapa.getPauloFrontin());//172
		vetor.inserir(mapa.getBalsaNova());//41
		vetor.inserir(mapa.getPalmeira());//59
		vetor.mostrar();
	}

}
