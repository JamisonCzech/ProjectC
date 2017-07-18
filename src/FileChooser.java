import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jamison on 6/30/2017.
 */
public class FileChooser<T> {

    protected static ArrayList<String> vertices;
    protected static int counter;
    protected static int[][] intMatrix;
    static ArrayList<Nodes> nodesList = new ArrayList<Nodes>();

    static String all;
    static FileWriter writerOut;
    private static int[] results;
    private static String[] slice;
    BufferedWriter bufferOut;
    private int lineNumber;
    private ArrayList<Object[]> numbersList;
    private ArrayList<Integer> tempNumbersList;
    private ArrayList<int[]> matrixHelper = new ArrayList<int[]>();
    private String vertex;

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
        BufferedReader inBuffer;
        String inText;
        FileReader iReader;


        tempNumbersList = new ArrayList<Integer>();
        numbersList = new ArrayList<Object[]>();
        vertices = new ArrayList<>();

        try {
            //Read in file io
            iReader = new FileReader(iFile);
            inBuffer = new BufferedReader(iReader);

            //Write file io out to file
            writerOut = new FileWriter(oFile, true);
            bufferOut = new BufferedWriter(writerOut);


            counter = 0;
            lineNumber = 0;

            for (lineNumber = 1; ; lineNumber++) {

                inText = inBuffer.readLine();

                if (inText == null) {
                    break;
                }
                while ((inText = inBuffer.readLine()) != null) {
                    vertex = inText.substring(0, 1);
                    all = vertex;
                    vertices.add(vertex);
                    nodesList.add(new Nodes(vertex));
                    inText = inText.substring(1);


                    slice = inText.replaceAll("[.]+", "0").trim().split("\\s+");
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
            }   //end for
            intMatrix = new int[matrixHelper.size()][];
            // convert 2d arrayList to 2d Matrix
            for (int i = 0; i < intMatrix.length; i++) {

                int[] row = matrixHelper.get(i);
                intMatrix[i] = row;
            }
        } catch (Exception e) {
            System.err.println("Reading failed at line " + lineNumber);
            e.printStackTrace(System.err);
        } finally {

            try {

                if (writerOut != null)
                    writerOut.close();

                if (bufferOut != null)
                    bufferOut.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }
}
