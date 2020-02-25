import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileLocationConfig config = new FileLocationConfig();
        File testGifFile = new File("tenor.gif");

        FileDifferentiator differentiator = new FileDifferentiator(testGifFile);

        System.out.println(differentiator.getFileExtension());
    }
}
