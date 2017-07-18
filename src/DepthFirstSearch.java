import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 *         (jamisonczech@gmail.com) </A>
 */

/******************************************************************************
 *  Compilation:  javac DepthFirstSearch.java
 *  Execution:    java DepthFirstSearch filename.txt s
 *  Dependencies: Graph.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41graph/tinyG.txt
 *                http://algs4.cs.princeton.edu/41graph/mediumG.txt
 *
 *  Run depth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  % java DepthFirstSearch tinyG.txt 0
 *  0 1 2 3 4 5 6
 *  NOT connected
 *
 *  % java DepthFirstSearch tinyG.txt 9
 *  9 10 11 12
 *  NOT connected
 *
 ******************************************************************************/

/***************************************************************************************
 *    Title: title of program/source code
 *    Author: author(s) names: James Aspnes
 *    Date Accessed: July 11th 2017
 *    Availability: http://www.cs.yale.edu/homes/aspnes/pinewiki/DepthFirstSearch.html
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
    protected List<Nodes> nodesArray = new ArrayList<>();
    Nodes CompareNext;
    FileWriter writerOut;
    BufferedWriter bufferOut;

    Nodes print;

    private Stack<Nodes> nodesStack;
    private List<Edge> allEdges = new ArrayList<>();
    private List<String> sort = new ArrayList<String>();
    private Edge edge;
    private Stack<Nodes> stack = new Stack<>();
    private Nodes beginningNodes = FileChooser.nodesList.get(0);
    private Nodes compare;

    /**
     * Constructor for DepthFirstSearch
     */
    public DepthFirstSearch() throws IOException {
        this.nodesStack = new Stack<>();

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
     * the ArrayList nodesArray to create weighted edges
     *
     * @param
     */
    public void createGraph() {


        for (int i = 0; i < FileChooser.vertices.size(); i++) {

            for (int v = 0; v < FileChooser.intMatrix.length; v++) {

                if (FileChooser.intMatrix[i][v] > 0) {
                    //set name of node from nodesArray obtained in FileChooser
                    Nodes origin = FileChooser.nodesList.get(i);
                    Nodes destination = FileChooser.nodesList.get(v);

                    // Create a new edge object with start name, end name, and weight of edge
                    edge = new Edge(origin, destination);
                    edge.setWeight(FileChooser.intMatrix[i][v]);
                    allEdges.add(edge); //allEdges both origin and destanation nodes
                    origin.nodeEdge.add(edge);

                }
            }
        }

    } // end CreateGraph


    /**
     * @param nodes recursive function to run DFS
     */
    public void dfsRecursive(Nodes nodes) {

        System.out.print(nodes + "->");

        for (Nodes v : nodes.getNeighborList()) {

            if (!v.isMarked()) {
                v.setMarked(true);
                dfsRecursive(v);
            }
        }
    }

    public void dfsNormal(Nodes root) {

        nodesStack.add(root);
        root.setMarked(true);

        while (!nodesStack.isEmpty()) {

            Nodes actualNodes = nodesStack.pop();
            System.out.println(actualNodes + "->");

            for (Nodes v : actualNodes.getNeighborList()) {
                if (!v.isMarked()) {
                    v.setMarked(true);
                    nodesStack.push(v);
                }
            }
        }
    }

    /******************************************************************************
     * A Nodes provides a generic node for a linked list. Each node
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
     *   <A HREF="../../../../edu/colorado/nodes/Nodes.java">
     *   Java Source Code for this class
     *   (www.cs.colorado.edu/~main/edu/colorado/nodes/Nodes.java) </A>
     *
     * @author Michael Main
     *   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
     *
     * @version Feb 10, 2016
     *
     ******************************************************************************/

    public void dfsSearch(String iFile, String oFile) {
        BufferedReader inBuffer = null;
        String inText;
        FileReader iReader;

        //Write file io out to file


        try {
            //Read in file io
            iReader = new FileReader(iFile);
            inBuffer = new BufferedReader(iReader);

            writerOut = new FileWriter(oFile, true);

            bufferOut = new BufferedWriter(writerOut);
            Nodes newNodes;
            stack.push(beginningNodes);

            writerOut.write("woot boob");

            while (!stack.isEmpty()) {
                newNodes = stack.pop();
                if (!newNodes.isMarked()) {
                    newNodes.setStartingRank(timeStamp);
                    newNodes.setMarked(true);
                    timeStamp++;
                    System.out.print(newNodes.getName());
                    String name = newNodes.getName();
                    writerOut.write(name);
                }
                compare = newNodes.dfsUtil();
                if (compare != null) {
                    stack.push(newNodes);
                    stack.push(compare);
                } else {
                    newNodes.setFinishingRank(timeStamp);
                    sort.add(newNodes.getName());

                    timeStamp++;
                }
            }// End while

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runDfs() {
        Nodes output = null;

        for (Nodes nodes : nodesArray) {
            //System.out.println(nodes);
            nodes.getName();
            nodes.getStartingRank();
            nodes.getFinishingRank();
        }
    }


    /**
     * Prints the order in which the nodes were discovered
     * by preorder and post order.
     */
    public void printVertices() {
        System.out.println("\nOrder of Discovery: \n");
        for (Nodes nodes : FileChooser.nodesList) {
            System.out.println(nodes + "");


        }
    }

    /**
     * Edge type of uv
     * start times
     * end times
     * Tree edge
     * start[u] < start[v]
     * end[u] > end[v]
     * Back edge
     * start[u] > start[v]
     * end[u] < end[v]
     * Forward edge
     * start[u] < start[v]
     * end[u] > end[v]
     * Cross edge
     * start[u] > start[v]
     * end[u] > end[v]
     */
    public void printEdgeClassification() {


    }

    /***************************************************************************************
     *    Title: title of program/source code
     *    Author: author(s) names: Javin Paul
     *    Date Accessed: July 2nd 2017
     *    Availability: https://javarevisited.blogspot.com/2016/05/
     *    how-to-reverse-arraylist-in-place-in-java.html
     *
     *
     ***************************************************************************************/


    public void printSort() {
        int size = sort.size();
        for (int i = 0; i < size / 2; i++) {
            final String node = sort.get(i);
            sort.set(i, sort.get(size - i - 1)); // swap
            sort.set(size - i - 1, node); // swap
        }

        System.out.println("\nTopological Sort: " + sort + "\n");

    }

    /**
     * So how do we compute H(u) for each u? There is a simple algorithm that runs DepthFirstSearch twice:
     * StronglyConnectedComponents(G):
     * Run AnnotatedDFSForest on G.
     * Let G' equal G with all edges reversed and the vertices ordered by decreasing end time.
     * Run AnnotatedDFSForest on G' and output each tree as a SCC.
     */
    public void printStronglyConnected() {
        System.out.println(sort);
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
