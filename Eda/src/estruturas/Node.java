package estruturas;

public class Node{

        public final String value;
        public double g;
        public final double h;
        public double f = 0;
        public Edge[] adjacencies;
        public Node parent;

        public Node(String val, double hVal){
                value = val;
                h = hVal;
        }

        public String toString(){
                return value;
        }

}