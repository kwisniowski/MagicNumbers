import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileLocationConfig config = new FileLocationConfig();
        File testGifFile = new File(config.getPath()+config.getFilename());
        FileDifferentiator differentiator = new FileDifferentiator();

        if (testGifFile!=null) {
            System.out.println(differentiator.validateGifByMagicNumbers(testGifFile));
        }
    }
}
