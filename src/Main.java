import com.edu.metrostate.ics340.j_czech.FileChooser;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileChooser fileChooser = new FileChooser();

        int i;
        String iFile;
        String oFile;

        iFile = fileChooser.chooseFile();
        if (iFile != null) {
            i = iFile.lastIndexOf('.');
            if (i >= 0)
                oFile = iFile.substring(0, i) + "_out" + iFile.substring(i);
            else
                oFile = iFile + "_out";
            fileChooser.processFile(iFile, oFile);
        }

    }
}
