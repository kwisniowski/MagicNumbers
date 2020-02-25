import java.io.File;

public class FileDifferentiator {

    private File file;

    public FileDifferentiator(File file) {
        this.file = file;
    }

    public String getFileExtension() {
        int dotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(dotIndex+1,dotIndex+4);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
