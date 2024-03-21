package file;
import java.io.File;

public class FilePath {
    private String filePath;
    private String fileName = "";

    public FilePath(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return String return the filePath
     */
    public String getFilePath() {
        String fileDirectory = "data\\" + fileName;

        File file = new File(fileDirectory);
        this.filePath = file.getAbsolutePath();

        return this.filePath;
    }

    /**
     * @return String return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "FilePath [filePath=" + filePath + ", fileName=" + fileName + "]";
    }
}
