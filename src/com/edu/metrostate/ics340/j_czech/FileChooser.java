package com.edu.metrostate.ics340.j_czech;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jamison on 6/30/2017.
 */
public class FileChooser {

    private int lineNumber;
    private static int[] results;

    private ArrayList<Object[]> numbersList;
    private ArrayList<Integer> tempNumbersList;
    private static String[] slice;
    private ArrayList<int[]> matrix = new ArrayList<int[]>();

    private static int counter;
    private static int numSolutions;
    private static int finalResults[];
    private static String paths[];
    private static int counters = 0;
    private static int[][] intMatrix;
    private String add;
    MatrixHelper helper;

    private BufferedWriter bufferOut;
    private FileWriter writerOut;
    private String oFile;
    /**
     * Robin Ehrlich
     * 2017-05-24
     * Method to select a file with JFileChooser
     * <p>
     * <b>Precondition:</b>
     * File is available on drive.
     * <b>PostCondition:</b>
     * a file of distances is selected.
     * </p>
     *
     * @return returns the given selected file of milage and cities
     * that was choose by the user.
     */
    public static String chooseFile() {

        JFileChooser chooser;
        String fileName;
        FileNameExtensionFilter filter;
        int selection;

        fileName = null;
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Text Files", "dat", "txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("."));
        selection = chooser.showOpenDialog(null);

        if (selection == JFileChooser.APPROVE_OPTION)
            fileName = chooser.getSelectedFile().getAbsolutePath();

        return (fileName);
    }

    public void processFile(String iFile, String oFile) {
        this.oFile = oFile;
        BufferedReader inBuffer;
        String inText;
        FileReader iReader;


        tempNumbersList = new ArrayList<Integer>();
        numbersList = new ArrayList<Object[]>();

        helper = new MatrixHelper();

        try {
            //Read in file io
            iReader = new FileReader(iFile);
            inBuffer = new BufferedReader(iReader);

            //Write file io out to file
            writerOut = new FileWriter(oFile);
            bufferOut = new BufferedWriter(writerOut);

            counter = 0;
            lineNumber = 0;

            for (lineNumber = 1; ; lineNumber++) {

                inText = inBuffer.readLine();

                if (inText == null) {
                    break;
                }

                while ((inText = inBuffer.readLine()) != null) {

                    StringBuilder numberOnly = new StringBuilder(inText.replaceAll("[[^0-9]\\p{Zl}\\s]+", " "));

                    if (counter > 0) {
                        for (int i = 0; i < counter; i++) {
                            add = String.format("%0" + counter + "d", 0);
                            numberOnly.insert(0, add + " ");
                        }
                    }

                    slice = numberOnly.toString().trim().split("\\s+");
                    results = new int[slice.length];

                    for (int i = 0; i < slice.length; i++) {
                        results[i] = Integer.parseInt(slice[i]);
                        tempNumbersList.add(results[i]);
                    }

                    matrix.add(results);

                    numbersList.add(tempNumbersList.toArray());
                    tempNumbersList.clear();

                    ++counter;


                }// end while
            }   //end for


            System.out.println(Arrays.toString(numbersList.toArray()));


            intMatrix = new int[matrix.size()][];

            // convert 2d arrayList to 2d Matrix
            for (int i = 0; i < intMatrix.length; i++) {

                int[] row = matrix.get(i);
                intMatrix[i] = row;
            }

            //Print Lines from io File
            System.out.println("Number of lines in array = " + counter);
            System.out.println("Here it is array:   " + Arrays.deepToString(intMatrix));
            // Create 2d matrix
         //   intMatrix = helper.transposeMatrix(intMatrix);

//            for (int i = 0; i < counter - 1; i++) {
//                for (int j = i + 1; j < counter; j++) {
//                    int tmp = intMatrix[i][j];
//                    intMatrix[i][j] = intMatrix[j][i];
//                    intMatrix[i][i] = tmp;
//                }
//            }

            helper.printMatrix(intMatrix);

            // Print the adjacency matrix out to the console
            bufferOut.write("Adjacency Matrix : ");
            bufferOut.newLine();
            bufferOut.write(Arrays.deepToString(intMatrix));
            bufferOut.newLine();
            bufferOut.newLine();
            inBuffer.close();
            bufferOut.close();

        } catch (Exception e) {
            System.err.println("Reading failed at line " + lineNumber);
            e.printStackTrace(System.err);
        }





    }


}
