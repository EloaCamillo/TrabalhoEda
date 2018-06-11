package buscas;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

import estruturas.Edge;
import estruturas.Node;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class AstarSearchAlgo{

        public static void main(String[] args){

        	Node portoUniao = new Node("Porto União", 203, 0);
    		Node pauloFrontin = new Node("Paulo Frontin", 172, 33);
    		Node canoinhas = new Node ("Canoinhas", 141, 69);
    		Node irati = new Node ("Irati", 139, 89);
    		Node palmeira = new Node("Palmeira", 59, 140);
            Node campoLargo = new Node("Campo Largo", 27, 178);
            Node curitiba = new Node("Curitiba",0, 203);
            Node balsaNova = new Node("Balsa Nova",41, 163);
            Node araucaria = new Node("Araucária",23, 183);
            Node saoJose = new Node("São José dos Pinhais",13, 204);
            Node contenda = new Node("Contenda",39, 167);
            Node mafra = new Node("Mafra",94, 127);
            Node tijucas = new Node("Tijucas do Sul",56, 268);
            Node lapa = new Node("Lapa",74, 142);
            Node saoMateus = new Node("São Mateus do Sul",123, 81);
            Node tresBarras = new Node("Três Barras",131, 78);

            portoUniao.adjacencies = new Edge[] {
            		new Edge(pauloFrontin, 46),
            		new Edge(canoinhas, 78),
            		new Edge(saoMateus, 87)
            };
            
            pauloFrontin.adjacencies = new Edge[] {
            		new Edge(portoUniao, 46),
            		new Edge(irati, 75)
            };
            
            canoinhas.adjacencies = new Edge[] {
            		new Edge(portoUniao, 78),
            		new Edge(tresBarras, 12),
            		new Edge(mafra, 66)
            };
            
            irati.adjacencies = new Edge[] {
            		new Edge(pauloFrontin, 75),
            		new Edge(palmeira, 75),
            		new Edge(saoMateus, 57)
            };
            
            palmeira.adjacencies = new Edge[] {
            		new Edge(irati, 75),
            		new Edge(saoMateus, 77),
            		new Edge(campoLargo, 55)
            };
            
            campoLargo.adjacencies = new Edge[] {
            		new Edge(palmeira, 55),
            		new Edge(balsaNova, 22),
            		new Edge(curitiba, 29)
            };
            
            curitiba.adjacencies = new Edge[] {
            		new Edge(campoLargo, 29),
            		new Edge(balsaNova, 51),
            		new Edge(araucaria, 37),
            		new Edge(saoJose, 15)
            		
            };
            
            balsaNova.adjacencies = new Edge[] {
            		new Edge(curitiba, 51),
            		new Edge(campoLargo, 22),
            		new Edge(contenda, 19)
            };
            
            araucaria.adjacencies = new Edge[] {
            		new Edge(curitiba, 37),
            		new Edge(contenda, 49)
            };
            
            saoJose.adjacencies = new Edge[] {
            		new Edge(curitiba, 15),
            		new Edge(tijucas, 49)
            };
            
            contenda.adjacencies = new Edge[] {
            		new Edge(balsaNova, 19),
            		new Edge(araucaria, 49),
            		new Edge(lapa, 26)
            };
            
            mafra.adjacencies = new Edge[] {
            		new Edge(tijucas, 99),
            		new Edge(lapa, 57),
            		new Edge(canoinhas, 66)
            };
            
            tijucas.adjacencies = new Edge[] {
            		new Edge(mafra, 99),
            		new Edge(saoJose, 49)
            };
            
            lapa.adjacencies = new Edge[] {
            		new Edge(contenda, 26),
            		new Edge(saoMateus, 60),
            		new Edge(mafra, 57)
            };
            
            saoMateus.adjacencies = new Edge[] {
            		new Edge(palmeira, 77),
            		new Edge(irati, 57),
            		new Edge(lapa, 60),
            		new Edge(tresBarras, 43),
            		new Edge(portoUniao, 87)
            };
            
            tresBarras.adjacencies = new Edge[] {
            		new Edge(saoMateus, 43),
            		new Edge(canoinhas, 12)
            };

                AstarSearch(portoUniao,curitiba);

                List<Node> path = printPath(curitiba);

                        System.out.println("Caminho:" + path);

        }

        public static List<Node> printPath(Node target){
	        List<Node> path = new ArrayList<Node>();
	        
	        for(Node node = target; node!=null; node = node.parent){
	            path.add(node);
	        }
	
	        Collections.reverse(path);
	
	        return path;
        }

        public static void AstarSearch(Node s, Node t){

                Set<Node> exploredS = new HashSet<Node>();
                Set<Node> exploredT = new HashSet<Node>();

                PriorityQueue<Node> queueS = new PriorityQueue<Node>(20, 
                     new Comparator<Node>(){
		                 public int compare(Node i, Node j){
		                    if(i.f > j.f){
		                        return 1;
		                    } else if (i.f < j.f){
		                        return -1;
		                    } else {
		                        return 0;
		                    }
		                 }
                 });
                
                PriorityQueue<Node> queueT = new PriorityQueue<Node>(20, 
                        new Comparator<Node>(){
   		                 public int compare(Node i, Node j){
   		                    if(i.f > j.f){
   		                        return 1;
   		                    } else if (i.f < j.f){
   		                        return -1;
   		                    } else {
   		                        return 0;
   		                    }
   		                 }
                    });

                s.g = 0;
                t.g = 0;

                queueS.add(s);
                queueT.add(t);

                boolean found = false;

                while(!found){

                        Node currentS = queueS.poll();
                        Node currentT = queueT.poll();
                        
                        System.out.println("[S] Nó atual: "+currentS.toString());
                        System.out.println("[T] Nó atual: "+currentT.toString());

                        exploredS.add(currentS);
                        exploredT.add(currentT);

                        if(currentS.value.equals(t.value)){
                        	System.out.println("O algoritmo S encontrou o objetivo T");
                                found = true;
                        } else if(currentT.value.equals(s.value)){
                        	System.out.println("O algoritmo T encontrou o objetivo S");
                            found = true;
                        } else if (currentT.value.equals(currentS.value)) {
                        	System.out.println("Os algoritmos T e S se encontraram em "+currentT.value);
                        	found = true;
                        }

                        for(Edge e : currentS.adjacencies){
                                Node node = e.target;
                                double cost = e.cost;
                                double aux_g = currentS.g + cost;
                                double aux_f = aux_g + node.hS;
                                
                                //System.out.println("[S] Nó alvo: " + node.toString());

                                if((exploredS.contains(node)) && 
                                        (aux_f >= node.f)){
                                        continue;
                                } else if((!queueS.contains(node)) || 
                                        (aux_f < node.f)){

                                        node.parent = currentS;
                                        node.g = aux_g;
                                        node.f = aux_f;

                                        if(queueS.contains(node)){
                                                queueS.remove(node);
                                        }
                                        queueS.add(node);
                                }
                        }
                        
                        for(Edge e : currentT.adjacencies){
                            Node node = e.target;
                            double cost = e.cost;
                            double aux_g = currentT.g + cost;
                            double aux_f = aux_g + node.hT;
                            
                            //System.out.println("[T] Nó alvo: " + node.toString());

                            if((exploredT.contains(node)) && 
                                    (aux_f >= node.f)){
                                    continue;
                            } else if((!queueT.contains(node)) || 
                                    (aux_f < node.f)){

                                    node.parent = currentT;
                                    node.g = aux_g;
                                    node.f = aux_f;

                                    if(queueT.contains(node)){
                                            queueT.remove(node);
                                    }
                                    queueT.add(node);
                            }
                    }
                }
        } 
}
