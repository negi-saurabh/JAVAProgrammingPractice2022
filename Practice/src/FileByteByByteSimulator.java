package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileByteByByteSimulator {

    private static void simulateFileByteByByte(Path filePath) throws IOException {
        try {
            byte[] fileData = Files.readAllBytes(filePath);
            for (byte b : fileData) {
                // Simulate processing the byte (you can replace this with your actual processing logic)
                System.out.println("Processing byte: " + b);
            }

            // Specify the destination folder where you want to copy the file
            String destinationFolderPath = "/Users/Shared/Source";

            // Get the file name from the original file path
            String fileName = filePath.getFileName().toString();

            // Create the destination path by combining the destination folder path and the file name
            Path destinationPath = Paths.get(destinationFolderPath, fileName);

            // Copy the file to the destination folder
            Files.copy(filePath, destinationPath);

            System.out.println("File copied successfully to: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Error occurred while processing the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fixedFilePath = "/Users/Shared/fileforInput/AL65470157"; // Replace this with your actual file path

        Path filePath = Paths.get(fixedFilePath);
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            System.out.println("Invalid file path or the file does not exist.");
            return;
        }

        try {
            // Simulate providing the file byte by byte and copy the file to the destination folder
            simulateFileByteByByte(filePath);
        } catch (IOException e) {
            System.out.println("Error occurred while processing the file: " + e.getMessage());
        }
    }
}
