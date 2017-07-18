package com.edu.metrostate.ics340.j_czech;

import java.io.IOException;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 * (jamisonczech@gmail.com) </A>
 */

/***************************************************************************************
 *   *********************************************************************************
 *
 *   Title: title of program/source code
 *    Author: author(s) names: Geeksforgeeks
 *    Date Accessed: July 10th, 2017
 *    Availability: http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 *
 ***************************************************************************************/


/***************************************************************************************
 *
 *    Title: title of program/source code
 *    Author: author(s) names: Geeksforgeeks
 *    Date Accessed: July 10th 12th 2017
 *    Availability: http://www.geeksforgeeks.org/iterative-depth-first-traversal/
 ***************************************************************************************/

/***************************************************************************************
 *    Title: title of program/source code
 *    Author: author(s) names: Geeksforgeeks
 *    Date Accessed: July 12th 2017
 *    Availability: http://www.geeksforgeeks.org/topological-sorting/
 *
 ***************************************************************************************/

/***************************************************************************************
 *    Title: title of program/source code Book by:
 *    Author: author(s) names: Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *    Date Accessed: July 8th 2017
 *    Availability: Data Structures and  Algorithms in Java™  Sixth Edition
 ***************************************************************************************/

/***************************************************************************************
 *    Title: title of program/source code
 *    Author: author(s) names: Jin Zhe
 *    Date Accessed: July 7th 2017
 *    Availability: https:/https://github.com/spyrant/algorithms/blob/master/Graph.java
 *
 *
 ***************************************************************************************/


public class Main {

    public static void main(String[] args) throws IOException {

        FileChooser fileChooser = new FileChooser();

        int i;
        String iFile;
        String oFile;

        iFile = FileChooser.chooseFile();
        if (iFile != null) {
            i = iFile.lastIndexOf('.');
            if (i >= 0)
                oFile = iFile.substring(0, i) + "_out" + iFile.substring(i);
            else
                oFile = iFile + "_out";
            fileChooser.processFile(iFile, oFile);
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(iFile, oFile);
            depthFirstSearch.createGraph(oFile);
            depthFirstSearch.dfsSearch();
            depthFirstSearch.printVertices();
            depthFirstSearch.printEdgeClassification();
            depthFirstSearch.printSort();

        }


    }
}
