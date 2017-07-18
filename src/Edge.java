import java.util.ArrayList;
import java.util.List;

public class Edge {

    List<Edge> allEdges = new ArrayList();
    private Nodes origin;
    private Nodes destination;
    private String classification;
    private int weightValue = 9999999;

    private int weight;


    public Edge(Nodes origin, Nodes finish) {
        this.origin = origin;
        this.destination = finish;
        this.classification = "";

    }

    /**
     * @return
     */
    public Nodes getOrigin() {
        return origin;
    }

    /**
     * @param origin
     */
    public void setOrigin(Nodes origin) {
        this.origin = origin;
    }

    /**
     * @return
     */
    public Nodes getDestination() {
        return destination;
    }

    /**
     * @param destination
     */
    public void setDestination(Nodes destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    public String getEdgeClassification() {
        return classification;
    }

    /**
     * @param classification
     */
    public void setEdgeClassification(String classification) {
        this.classification = classification;
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }

    public void setAllEdges(List<Edge> allEdges) {
        this.allEdges = allEdges;

    }

    @Override
    public String toString() {
        return "Edge{" + "origin = " + origin +
                ", destination = " + destination +
                ", classification='" + classification + '\'' + '}';
    }
}
