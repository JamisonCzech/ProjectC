package com.edu.metrostate.ics340.j_czech;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import static com.edu.metrostate.ics340.j_czech.FileChooser.*;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 *         (jamisonczech@gmail.com) </A>
 */

/***************************************************************************************
 *    Title: title of program/source code Book by
 *    Author: author(s) names: rmuhamma
 *    Date Accessed: June 18th 2017
 *    Availability: http://www.personal.kent.edu/~rmuhamma/Algorithms/
 *    MyAlgorithms/AproxAlgor/TSP/tsp.htm
 *
 *
 ***************************************************************************************/

/***************************************************************************************
 *    Title: title of program/source code
 *    Author: author(s) names: dharam
 *    Date Accessed: June 18th 2017
 *    Availability: http://techieme.in/matrix-rotation/
 *
 *
 ***************************************************************************************/

/******************************************************************************
 * A <CODE>Graph</CODE> is a labeled graph with a fixed number of vertices.
 *
 * <b>Java Source Code for this class:</b>
 *   <A HREF="../../../../edu/colorado/collections/Graph.java">
 *   http://www.cs.colorado.edu/~main/EDU/colorado/collections/Graph.java
 *   </A>
 *
 * @author Michael Main
 *   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
 *
 * @version Feb 10, 2016
 ******************************************************************************/

public class DepthFirstSearch implements Comparator, Comparable {

    protected static int timeStamp = 1;
    protected List<Node> nodeArray = new ArrayList<>();
    Node CompareNext;
    BufferedWriter bufferOut;
    FileWriter writerOut;
    String oFile;
    BufferedReader inBuffer;
    String inText;
    FileReader iReader;
    //private List<Node> nodeList;
    String iFile;
    Node print;
    //  List<Node> nodeEdges = new ArrayList<>();
    private Stack<Node> nodeStack;
    private List<Edge> allEdges = new ArrayList<>();
    private List<String> sort = new ArrayList<String>();
    private Edge edge;
    private Stack<Node> stack = new Stack<>();
    private Node beginningNode = nodeList.get(0);
    private int weightValue = 9999999;
    private Node compare;

    /**
     * Constructor for DepthFirstSearch
     *
     * @param iFile
     * @param oFile
     */
    public DepthFirstSearch(String iFile, String oFile) throws IOException {
        this.iFile = iFile;
        this.oFile = oFile;
        this.nodeStack = new Stack<>();

//        bufferOut = new BufferedWriter(writerOut);

    }
    /***************************************************************************************
     *    Title: title of program/source code Book by:
     *    Author: author(s) names: Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
     *    Date Accessed: July 8th 2017
     *    Availability: Data Structures and  Algorithms in Java™  Sixth Edition
     ***************************************************************************************/
    /**
     * Method when activated creates the weights from intMatrix as well as
     * the ArrayList nodeArray to create weighted edges
     *
     * @param oFile
     */
    public void createGraph(String oFile) {


        for (int i = 0; i < vertices.size(); i++) {

            for (int v = 0; v < intMatrix.length; v++) {

                if (intMatrix[i][v] > 0) {
                    //set name of node from nodeArray obtained in FileChooser
                    Node origin = nodeList.get(i);
                    Node destination = nodeList.get(v);

                    // Create a new edge object with start name, end name, and weight of edge
                    edge = new Edge(origin, destination);
                    edge.setWeight(intMatrix[i][v]);
                    allEdges.add(edge); //allEdges both origin and destanation nodes
                    origin.nodeEdge.add(edge);

                }
            }
        }

    } // end CreateGraph


    /**
     * @param node recursive function to run DFS
     */
    public void dfsRecursive(Node node) {

        System.out.print(node + "->");

        for (Node v : node.getNeighborList()) {

            if (!v.isMarked()) {
                v.setMarked(true);
                dfsRecursive(v);
            }
        }
    }

    public void dfsNormal(Node root) {

        nodeStack.add(root);
        root.setMarked(true);

        while (!nodeStack.isEmpty()) {

            Node actualNode = nodeStack.pop();
            System.out.println(actualNode + "->");

            for (Node v : actualNode.getNeighborList()) {
                if (!v.isMarked()) {
                    v.setMarked(true);
                    nodeStack.push(v);
                }
            }
        }
    }

    /******************************************************************************
     * A Node provides a generic node for a linked list. Each node
     * contains a piece of data (which is a reference to an E object) and a link
     * (which is a reference to the next node of the list). The reference stored
     * in a node can be null.
     *
     * @note
     *   Lists of nodes can be made of any length, limited only by the amount of
     *   free memory in the heap. But beyond Integer.MAX_VALUE (2,147,483,647),
     *   the answer from listLength is incorrect because of arithmetic
     *   overflow.
     * @see
     *   <A HREF="../../../../edu/colorado/nodes/Node.java">
     *   Java Source Code for this class
     *   (www.cs.colorado.edu/~main/edu/colorado/nodes/Node.java) </A>
     *
     * @author Michael Main
     *   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
     *
     * @version Feb 10, 2016
     *
     ******************************************************************************/

    public void dfsSearch() {
        Node newNode;
        stack.push(beginningNode);

        while (!stack.isEmpty()) {
            newNode = stack.pop();
            if (!newNode.isMarked()) {
                newNode.setStartingRank(timeStamp);
                newNode.setMarked(true);
                timeStamp++;
                System.out.print(newNode.getName());
            }
            compare = newNode.dfsUtil();
            if (compare != null) {
                stack.push(newNode);
                stack.push(compare);
            } else {
                newNode.setFinishingRank(timeStamp);
                sort.add(newNode.getName());

                timeStamp++;
            }
        }// End while
    }

    public void runDfs() {
        Node output = null;

        for (Node node : nodeArray) {
            //System.out.println(node);
            node.getName();
            node.getStartingRank();
            node.getFinishingRank();
        }
    }


    /**
     * Prints the order in which the nodes were discovered
     * by preorder and post order.
     */
    public void printVertices() {
        System.out.println("\nOrder of Discovery: \n");
        for (Node node : nodeList) {
            System.out.println(node + "");


            //Write file io out to file
            try {
                iReader = new FileReader(iFile);
                inBuffer = new BufferedReader(iReader);
                writerOut = new FileWriter(oFile, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bufferOut = new BufferedWriter(writerOut);

        }
    }

    public void printEdgeClassification() {

        for (Node edge : nodeList) {

        }

    }

    /***************************************************************************************
     *    Title: title of program/source code
     *    Author: author(s) names:  Javin Paul
     *    Date Accessed: July 2nd 2017
     *    Availability: https://javarevisited.blogspot.com/2016/05/
     *    how-to-reverse-arraylist-in-place-in-java.html
     *
     *
     ***************************************************************************************/


    public void printSort() {
        int size = sort.size();
        for (int i = 0; i < size / 2; i++) {
            final String food = sort.get(i);
            sort.set(i, sort.get(size - i - 1)); // swap
            sort.set(size - i - 1, food); // swap
        }

        System.out.println("\nTopological Sort: " + sort + "\n");

    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
