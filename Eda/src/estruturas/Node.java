package estruturas;

public class Node{

        public final String value;
        public double g;
        public final double hS;
        public final double hT;
        public double f = 0;
        public Edge[] adjacencies;
        public Node parent;

        public Node(String val, double hValS, double hValT){
                value = val;
                hS = hValS;
                hT = hValT;
        }

        public String toString(){
                return value;
        }

}