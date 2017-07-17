import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;

/**
 * Created by Jamison on 6/30/2017.
 */
public class FileChooser<T> {

    private int lineNumber;
    private static int[] results;

    private ArrayList<Object[]> numbersList;
    private ArrayList<Integer> tempNumbersList;
    private static String[] slice;
    private ArrayList<int[]> matrixHelper = new ArrayList<int[]>();
    protected static ArrayList<String> vertices;
    protected static int counter;
    private static int numSolutions;
    private static int finalResults[];
    private static String paths[];
    private static int counters = 0;
    protected static int[][] intMatrix;
    private String add;
    private String vertex;

    private BufferedWriter bufferOut;
    private FileWriter writerOut;
    private String oFile;

    //--------------------------------------


    static ArrayList<Node> nodeList = new ArrayList<Node>();
    static int[] visitedNodes;
    static String all;
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
        vertices = new ArrayList<String>();

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
                System.out.println("Input Graph: \n\n" + inText);
                while ((inText = inBuffer.readLine()) != null) {
                    vertex = inText.substring(0, 1);
                    all = vertex;
                    vertices.add(vertex);
                    nodeList.add(new Node(vertex));
                    inText = inText.substring(1);
                    StringBuilder numberOnly = new StringBuilder(inText.replaceAll("[.]+", "0"));


                    System.out.println(numberOnly);
                    slice = numberOnly.toString().trim().split("\\s+");
                    results = new int[slice.length];
                    for (int i = 0; i < slice.length; i++) {
                        results[i] = Integer.parseInt(slice[i]);
                        tempNumbersList.add(results[i]);
                    }

                    matrixHelper.add(results);
                    numbersList.add(tempNumbersList.toArray());
                    tempNumbersList.clear();

                    ++counter;

                }// end while
                System.out.println(Arrays.toString(results));
                System.out.println(vertices);
            }   //end for
            intMatrix = new int[matrixHelper.size()][];
            // convert 2d arrayList to 2d Matrix
            for (int i = 0; i < intMatrix.length; i++) {

                int[] row = matrixHelper.get(i);
                intMatrix[i] = row;
            }
            //Print Lines from io File
            System.out.println("Number of lines in array = " + counter);
            System.out.println("Here it is array:   " + Arrays.deepToString(intMatrix));

        } catch (Exception e) {
            System.err.println("Reading failed at line " + lineNumber);
            e.printStackTrace(System.err);
        }
    }












}
