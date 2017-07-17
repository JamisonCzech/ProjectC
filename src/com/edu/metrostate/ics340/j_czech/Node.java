package com.edu.metrostate.ics340.j_czech;

import java.util.ArrayList;
import java.util.List;


public class Node {

    protected List<Edge> nodeEdge = new ArrayList<>();
    private String name;
    private List<Node> neighborList;
    private boolean visited;
    private Node predecessor;
    private int startingRank;
    private int finishingRank;

    public Node(String name) {
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public void addNeighbor(Node node) {
        this.neighborList.add(node);
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
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


    public List<Node> getNeighborList() {
        return neighborList;
    }

    @Override
    public String toString() {
        return this.name + "   " + getStartingRank() + "   " + getFinishingRank();
    }


    public Node dfsUtilNewNew() {
        Node compare = null;// node compare
        int weightValue = Integer.MAX_VALUE;// int weightValue


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
}
