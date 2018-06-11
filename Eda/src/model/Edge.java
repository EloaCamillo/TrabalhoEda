package model;

public class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
            target = targetNode;
            cost = costVal;
    }
    /*
    public Edge(Adjacente a){
        target = Find(a.getCidade().getNome());
        cost = a.;
    }*/
}