package com.edu.metrostate.ics340.j_czech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/***************************************************************************************
 *    Title: title of program/source code Book by:
 *    Author: author(s) Ilias Tsagklis
 *    Date Accessed: July 12th 2017
 *    Availability: https://examples.javacodegeeks.com/core-java/util/comparator/sort-arraylist-using-comparator-example/
 ***************************************************************************************/


public class Node implements Comparator<Node> {

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

    public Node dfsUtil() {
        int weightValue = 9999999;
        Node compare = null;
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
    public int compare(Node o1, Node o2) {
        return 0;
    }
}
