import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileLocationConfig config = new FileLocationConfig();
        FileDifferentiator differentiator = new FileDifferentiator();
        File testGifFile = new File("tenor.gif");

        System.out.println(differentiator.getFileEtrension(testGifFile));
    }
}
