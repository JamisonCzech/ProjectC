package com.edu.metrostate.ics340.j_czech;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.edu.metrostate.ics340.j_czech.FileChooser.*;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 *         (jamisonczech@gmail.com) </A>
 */
public class DepthFirstSearch {

    protected static int timeStamp = 1;
    protected List<Node> nodeArray = new ArrayList<>();
    Node CompareNext;
    private Stack<Node> nodeStack;
    private List<Edge> allEdges = new ArrayList<>();
    private Edge edge;
    private Stack<Node> stack = new Stack<>();
    private Node beginningNode = nodeList.get(0);
    //private List<Node> nodeList;
    private int time = 0;
    private int weightValue = 9999999;
    private Node compare;

    /**
     * Constructor for DepthFirstSearch
     */
    public DepthFirstSearch() {
        this.nodeStack = new Stack<>();
    }

    /**
     * Method when activated creates the weights from intMatrix as well as
     * the ArrayList nodeArray to create weighted edges
     */
    public void createGraph() {


        for (int i = 0; i < vertices.size(); i++) {

            for (int v = 0; v < intMatrix.length; v++) {

                if (intMatrix[i][v] > 0) {
                    //set name of node from nodeArray obtained in FileChooser
                    Node origin = nodeList.get(i);
                    Node destination = nodeList.get(v);

                    // Create a new edge object with start name, end name, and weight of edge
                    edge = new Edge(origin, destination);
                    edge.setWeight(intMatrix[i][v]);
                    allEdges.add(edge);
                }
            }
        }

    } // end CreateGraph

    public void dfsRecursive(Node node) {

        System.out.print(node + "->");

        for (Node v : node.getNeighborList()) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsRecursive(v);
            }
        }
    }

    public void dfsNormal(Node root) {

        nodeStack.add(root);
        root.setVisited(true);

        while (!nodeStack.isEmpty()) {

            Node actualNode = nodeStack.pop();
            System.out.println(actualNode + "->");

            for (Node v : actualNode.getNeighborList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    nodeStack.push(v);
                }
            }
        }
    }

    public void DepthFirstSearch() {

        Node newNode;

        stack.push(beginningNode);

        while (!stack.isEmpty()) {
            newNode = stack.pop();


            if (!newNode.isVisited()) {
                newNode.setStartingRank(timeStamp);

                newNode.setVisited(true);
                timeStamp++;
            }
            System.out.println(newNode.getName());

            for (Edge edge : allEdges) {


                if (!edge.getDestination().isVisited()) {

                    if (edge.getWeight() < weightValue) {


                        weightValue = edge.getWeight();
                        compare = edge.getDestination();

                        if (compare != null) {
                            if (edge.getDestination().equals(compare)) {
                                edge.setEdgeClassification("T");
                            }
                        }


                    }

                }// end if
                //  System.out.println("Here it is right order: " + edge.getOrigin());

            }// End For _________

            if (compare != null) {

                stack.push(beginningNode);
                stack.push(compare);

            } else {

                newNode.setFinishingRank(timeStamp);

                timeStamp++;
            }
        }

    }// End while


    public void runDfs() {
        Node output = null;

        for (Node node : nodeArray) {
            //System.out.println(node);
            node.getName();
            node.getStartingRank();
            node.getFinishingRank();
        }
    }

    public Node DFSUtil() {


        if (!(edge.getDestination().isVisited())) {

            if ((edge.getWeight() < weightValue)) {

                compare = edge.getDestination();
                weightValue = edge.getWeight();
            }
        }


        if (compare != null) {


            if (edge.getDestination().equals(compare)) {
                edge.setEdgeClassification("T");
            }

        }
        return compare;
    }


    public void dfs(Node node) {

        System.out.print(node.getName() + "-");

        time++;
        node.setStartingRank(time);

        for (Node v : node.getNeighborList()) {
            if (!v.isVisited()) {
                v.setVisited(true);
                v.setPredecessor(node);
                dfs(v);
            }
        }

        time++;
        node.setFinishingRank(time);
    }

    public void printVertices() {
        for (Node node : nodeArray) {
            System.out.println(node + "");
        }
    }
}
