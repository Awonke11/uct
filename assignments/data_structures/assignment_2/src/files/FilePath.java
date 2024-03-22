package files;
import java.io.File;

/**
 * FilePath class for getting the file path
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class FilePath {
    private String filePath;
    private String fileName = "";

    /**
     * FilePath constructor
     * @param fileName the fileName to set
     */
    public FilePath(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the file path
     * @return String return the filePath
     */
    public String getFilePath() {
        String fileDirectory = "data\\" + fileName;

        File file = new File(fileDirectory);
        this.filePath = file.getAbsolutePath();

        return this.filePath;
    }

    /**
     * Get the file name
     * @return String return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Override toString
     * @return string format
     */
    @Override
    public String toString() {
        return "FilePath [filePath=" + filePath + ", fileName=" + fileName + "]";
    }
}
