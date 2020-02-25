import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDifferentiator {

    public final String GIF_MARK = "GIF89";

    public String getFileExtension(File file) {
        int dotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(dotIndex+1,dotIndex+4);
    }

    public String getFirst5Chars(FileInputStream inputStream) throws FileNotFoundException {
        char[] first5Bytes = new char[5];
        for (int i = 0; i <= 4; i++) {
            try {
                first5Bytes[i] = (char) inputStream.read();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return String.valueOf(first5Bytes);
    }

    public boolean validateGifByMagicNumbers(File file) throws FileNotFoundException {
        String magicNumbers = getFirst5Chars(new FileInputStream(file));
        if (magicNumbers.equals(GIF_MARK)) {
            return true;
        }
        else return false;
    }


}
