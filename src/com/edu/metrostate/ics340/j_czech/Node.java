package com.edu.metrostate.ics340.j_czech;

import java.util.ArrayList;
import java.util.List;


public class Node {

    protected static List<Edge> nodeEdge = new ArrayList<Edge>();
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

    public int getFinishingRank() {
        return finishingRank;
    }

    public void setFinishingRank(int finishingRank) {
        this.finishingRank = finishingRank;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


    public List<Node> getNeighborList() {
        return neighborList;
    }

    @Override
    public String toString() {
        return this.name + "   " + getStartingRank() + "   " + getFinishingRank();
        //eturn " The vertex here!!!!! " + this.name + " " + nodeEdge.toString();
    }
}
