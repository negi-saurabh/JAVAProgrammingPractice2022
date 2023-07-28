package fileconversion;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class ConvertFromASCIItoUTF {

    public static void main(String[] args) {
        String inputFile = "/Users/Shared/Source/output";
        String outputFile = "/Users/Shared/Source/output1";
        String inputEncoding = "US-ASCII";
        String outputEncoding = "UTF-8";


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), inputEncoding));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), outputEncoding))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("File converted successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
