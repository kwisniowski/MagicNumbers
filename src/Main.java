import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileLocationConfig config = new FileLocationConfig();
        File testGifFile = new File(config.getPath()+config.getGifFilename());
        File testJpgFile = new File(config.getPath()+config.getJpgFilename());
        File testTxtFile = new File(config.getPath()+config.getTxFileName());

        FileDifferentiator differentiator = new FileDifferentiator();

        if (testGifFile!=null) {
            System.out.println(differentiator.getFileExtension(testGifFile));
            System.out.println(differentiator.validateGifByMagicNumbers(testGifFile));
        }

        if (testJpgFile!=null) {
            System.out.println(differentiator.getFileExtension(testJpgFile));
            System.out.println(differentiator.validateJPGByMagicNumbers(testJpgFile));
        }

        if (testTxtFile!=null) {
            System.out.println(differentiator.getFileExtension(testTxtFile));
            System.out.println(differentiator.validateTxtFileByContent(testTxtFile));
        }
    }
}
