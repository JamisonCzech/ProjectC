package com.edu.metrostate.ics340.j_czech;

import static com.edu.metrostate.ics340.j_czech.FileIO.processFile;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileIO fileIO = new FileIO();

        int i;
        String iFile;
        String oFile;

        iFile = fileIO.chooseFile();
        if (iFile != null) {
            i = iFile.lastIndexOf('.');
            if (i >= 0)
                oFile = iFile.substring(0, i) + "_out" + iFile.substring(i);
            else
                oFile = iFile + "_out";
            processFile(iFile, oFile);
        }

    }
}
