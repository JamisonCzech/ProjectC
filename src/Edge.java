import java.util.ArrayList;
import java.util.List;

public class Edge {

    private Node origin;
    private Node destination;
    private String edgeType;
    private int weight;


    public Edge(Node origin, Node finish) {
        this.origin = origin;
        this.destination = finish;
        this.edgeType = "";

    }


    /**
     * @param origin
     */
    public void setOrigin(Node origin) {
        this.origin = origin;
    }


    /**
     * @return
     */
    public Node getOrigin() {
        return origin;
    }


    /**
     * @param destination
     */
    public void setDestination(Node destination) {
        this.destination = destination;
    }


    /**
     * @return
     */
    public Node getDestination() {
        return destination;
    }


    /**
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getWeight() {
        return weight;
    }

    /**
     * @param edgeType
     */
    public void setEdgeClassification(String edgeType) {
        this.edgeType = edgeType;
    }


    /**
     * @return
     */
    public String getEdgeClassification() {
        return edgeType;
    }
    List<Edge> allEdges = new ArrayList();

    public void setAllEdges(List<Edge> allEdges) {
        this.allEdges = allEdges;

    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

//    @Override
//    public String toString() {
//        return "Edge{" +
//                "origin=" + origin +
//                ", destination=" + destination +
//                ", edgeType='" + edgeType + '\'' +
//                ", weight=" + weight +
//                '}';
//    }
}
