import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***************************************************************************************
 *    Title: title of program/source code Book by:
 *    Author: author(s) Ilias Tsagklis
 *    Date Accessed: July 12th 2017
 *    Availability: https://examples.javacodegeeks.com/core-java/util/comparator/sort-arraylist-using-comparator-example/
 ***************************************************************************************/


public class Nodes implements Comparator<Nodes> {

    protected List<Edge> nodeEdge = new ArrayList<>();
    private String name;
    private List<Nodes> neighborList;
    private boolean visited;
    private Nodes predecessor;
    private int startingRank;
    private int finishingRank;

    public Nodes(String name) {
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public void addNeighbor(Nodes nodes) {
        this.neighborList.add(nodes);
    }

    public Nodes getPredecessor() {
        return predecessor;
    }


    public void setPredecessor(Nodes predecessor) {
        this.predecessor = predecessor;
    }

    public int getStartingRank() {
        return startingRank;
    }

    public void setStartingRank(int startingRank) {
        this.startingRank = startingRank;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getFinishingRank() {
        return finishingRank;
    }

    public void setFinishingRank(int finishingRank) {
        this.finishingRank = finishingRank;
    }

    public boolean isMarked() {
        return visited;
    }

    public void setMarked(boolean marked) {
        this.visited = marked;
    }


    public List<Nodes> getNeighborList() {
        return neighborList;
    }

    public Nodes dfsUtil() {
        int weightValue = 9999999;
        Nodes compare = null;
        for (Edge edge : nodeEdge) {

            if (!edge.getDestination().isMarked()) {

                if ((edge.getWeight() < weightValue)) {

                    compare = edge.getDestination();
                    weightValue = edge.getWeight();
                }
            }
        }
        if (compare != null) {

            for (Edge edge : nodeEdge) {
                if (edge.getDestination().equals(compare)) {
                    edge.setEdgeClassification("T");
                }
            }
        }

        return compare;
    }

    public void printEdgeClassification() {

        for (Edge edge : nodeEdge) {


            if (edge.getEdgeClassification() != null) {


                edge.setEdgeClassification("F");
                System.out.println("Edge Class: " + edge.getOrigin().getName() + " " + edge.getDestination().getName()
                        + " " + edge.getEdgeClassification());
            }
        }


    }

    @Override
    public String toString() {
        return this.name + "   " + getStartingRank() + "   " + getFinishingRank();
    }

    @Override
    public int compare(Nodes o1, Nodes o2) {

        for (Edge edge : nodeEdge) {

        }

        return 0;
    }
}
