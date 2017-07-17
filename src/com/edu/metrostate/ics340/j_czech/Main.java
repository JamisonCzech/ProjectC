package com.edu.metrostate.ics340.j_czech;

/**
 * @author Jamison Czech <A HREF="mailto:main@jamisonczech@gmail.com">
 *         (jamisonczech@gmail.com) </A>
 */


public class Main {

    public static void main(String[] args) {

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
        }
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.createGraph();
        depthFirstSearch.dfsSearch();
        depthFirstSearch.printVertices();


    }
}
