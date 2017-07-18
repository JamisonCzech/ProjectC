package com.edu.metrostate.ics340.j_czech;


import java.util.ArrayList;
import java.util.List;

public class Edge {

    List<Edge> allEdges = new ArrayList();
    private Node origin;
    private Node destination;
    private String classification;
    private int weightValue = 9999999;

    private int weight;


    public Edge(Node origin, Node finish) {
        this.origin = origin;
        this.destination = finish;
        this.classification = "";

    }

    /**
     * @return
     */
    public Node getOrigin() {
        return origin;
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
    public Node getDestination() {
        return destination;
    }

    /**
     * @param destination
     */
    public void setDestination(Node destination) {
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
