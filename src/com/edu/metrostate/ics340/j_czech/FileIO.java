package com.edu.metrostate.ics340.j_czech;/* ICS 340 Program A */
/* Robin Ehrlich */
/* 2017-05-24 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileIO {

   public static String chooseFile() {

      JFileChooser chooser;
      String fileName;
      FileNameExtensionFilter filter;
      int r;

      fileName = null;
      chooser = new JFileChooser();
      filter = new FileNameExtensionFilter("Text Files", "dat", "txt");
      chooser.setFileFilter(filter);
      chooser.setCurrentDirectory(new File("."));
      r = chooser.showOpenDialog(null);
      if (r == JFileChooser.APPROVE_OPTION)
         fileName = chooser.getSelectedFile().getAbsolutePath();

      return (fileName);

   }

   public static void processFile(String iFile, String oFile) {

      int i;
      BufferedReader iBuffer;
      String iLine;
      FileReader iReader;
      int lineNumber;
      BufferedWriter oBuffer;
      FileWriter oWriter;
      Integer total;
      int value;
      String [] values;

      lineNumber = 0;
      try {
         iReader = new FileReader(iFile);
         iBuffer = new BufferedReader(iReader);

         oWriter = new FileWriter(oFile);
         oBuffer = new BufferedWriter(oWriter);

         for (lineNumber = 1; ; lineNumber++) {
            iLine = iBuffer.readLine();
            if (iLine == null)
               break;
            values = iLine.split(" +");
            total = 0;
            for (i = 0; i < values.length; i++) {
               if (values[i].length() > 0) {
                  value = Integer.parseInt(values[i]);
                  total += value;
               }
            }
            oBuffer.write(total.toString());
            oBuffer.newLine();
         }

         iBuffer.close();
         oBuffer.close();
         
      }
      catch (Exception e) {
         System.err.println("Reading failed at line " + lineNumber);
         e.printStackTrace(System.err);                
      }
   }
}
