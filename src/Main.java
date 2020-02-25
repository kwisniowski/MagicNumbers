import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //For checking files from directory put it into specified directory and put a name in correct String value
        FileLocationConfig config = new FileLocationConfig();

        //For checking files included in project put them into files directory
        FileDifferentiator differentiator = new FileDifferentiator();

        File correctJpgFile = new File("files\\button.jpg");
        File correctGifFile = new File("files\\tenor.gif");
        File correctTxtFile = new File("files\\test.txt");
        File fakeGifFile = new File("files\\fakeGifFile.gif");

        System.out.println(differentiator.validateFile(correctJpgFile));
        System.out.println(differentiator.validateFile(correctGifFile));
        System.out.println(differentiator.validateFile(correctTxtFile));
        System.out.println(differentiator.validateFile(fakeGifFile));

    }
}

