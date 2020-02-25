import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDifferentiator {

    public final String GIF_MARK = "GIF89";
    public final double JPG_MARK = 0xFFd8;


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


    public boolean validateJPGByMagicNumbers(File file) {
        boolean result = false;
        byte[] bytes = new byte[2];
        try {
            FileInputStream inputStream = new FileInputStream(file);
            bytes[0] = (byte) inputStream.read();
            bytes[1] = (byte) inputStream.read();
            if ((bytes[0]==-1)&&(bytes[1]==-40)) {
                result = true;
            }
            else result = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }




}
