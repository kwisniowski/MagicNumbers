import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileDifferentiator {

    public final String GIF_MARK = "GIF89";
    public String[] handledExtentions = {"jpg","gif","txt"};

    private boolean validateIsHandled(File file) {
        List<String> handledExt = Arrays.asList(handledExtentions);
        if (handledExt.contains(getFileExtension(file))) {
            return true;
        }
        else return false;
    }

    private String getFileExtension(File file) {
        int dotIndex = file.getName().lastIndexOf(".");
        return file.getName().substring(dotIndex+1,dotIndex+4);
    }


    private String getFirst5Chars(FileInputStream inputStream) throws FileNotFoundException {
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

    //Check if first 5 chars are GIF89
    private boolean validateGifByMagicNumbers(File file) throws FileNotFoundException {
        String magicNumbers = getFirst5Chars(new FileInputStream(file));
        if (magicNumbers.equals(GIF_MARK)) {
            return true;
        }
        else return false;
    }

    //Check if first to bytes are 0xFF(-1) and 0xD8(-40)
    private boolean validateJPGByMagicNumbers(File file) {
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

    //Check if all chars are ASCII (0-127)
    private boolean validateTxtFileByContent(File file) {
        boolean result = true;
        boolean eof = false;

        try {
            FileInputStream inputStream = new FileInputStream(file);
            while (!eof) {
                int input = inputStream.read();
                if (input>128) {
                    result = false;
                }
                if (input == -1) {
                    eof = true;
                }
            }
        }

         catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String validateFile(File file) throws FileNotFoundException {
        String result = null;
        if (!validateIsHandled(file)) {
            throw new IllegalArgumentException();
        }

        else {
            if (getFileExtension(file).equals("jpg")) {
                if (validateJPGByMagicNumbers(file)) {
                    result = "Correct! File extension is jpg and it is a jpg file";
                }
                else if (validateGifByMagicNumbers(file)) {
                    return "Not correct! File extension is jpg and it is a gif file";
                }
                else if (validateTxtFileByContent(file)) {
                    return "Not correct! File extension is jpg and it is a txt file";
                }
            }
            else if (getFileExtension(file).equals("gif")) {
                if (validateJPGByMagicNumbers(file)) {
                    result = "Not correct! File extension is gif and it is a jpg file";
                }
                else if (validateGifByMagicNumbers(file)) {
                    return "Correct! File extension is gif and it is a gif file";
                }
                else if (validateTxtFileByContent(file)) {
                    return "Not correct! File extension is gif and it is a txt file";
                }
            }
            else if (getFileExtension(file).equals("txt")) {
                if (validateJPGByMagicNumbers(file)) {
                    result = "Not correct! File extension is txt and it is a jpg file";
                }
                else if (validateGifByMagicNumbers(file)) {
                    return "Not correct! File extension is txt and it is a gif file";
                }
                else if (validateTxtFileByContent(file)) {
                    return "Correct! File extension is txt and it is a txt file";
                }
            }
        }
        return result;
    }

}
