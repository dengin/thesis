import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * User: dengin
 * Date: 28.09.2019
 * Time: 21:12
 */
public class AdobePdf
{
    private static final String FILE_NAME = "test3.pdf";

    public static void main(String[] args)
    {
        ClassLoader classLoader = new AdobePdf().getClass().getClassLoader();

        PDFTextStripper tStripper = null;
        try
        {
            PDDocument document = PDDocument.load(new File(classLoader.getResource(FILE_NAME).getFile()));

            tStripper = new PDFTextStripper();
            tStripper.setStartPage(1);
            tStripper.setEndPage(document.getNumberOfPages());
            document.getClass();
            String content = "";
            if (!document.isEncrypted()) {
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
                for (String line : lines) {
                    System.out.println(line);
                    content += line;
                }
            }
            System.out.println(content.trim());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
