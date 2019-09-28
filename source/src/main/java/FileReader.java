import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: dengin
 * Date: 28.09.2019
 * Time: 20:59
 */
public class FileReader
{
    private static final String FILE_NAME = "test.properties";

    private File readFile(String fileName)
    {
        return new File(
                getClass().getClassLoader().getResource(fileName).getFile()
        );
    }

    public static void main(String[] args)
    {
        FileReader fileReader = new FileReader();
        File file = fileReader.readFile(FILE_NAME);
        printFile(file);
    }

    private static void printFile(File file)
    {
        if (file == null) return;

        try (java.io.FileReader reader = new java.io.FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
