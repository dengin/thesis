import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

/**
 * User: dengin
 * Date: 28.09.2019
 * Time: 20:44
 */
public class ITextPdf
{
    private static final String FILE_NAME = "test.pdf";

    public static void main(String[] args)
    {
        PdfReader reader;
        try
        {
            reader = new PdfReader(FILE_NAME);
            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

            System.out.println(textFromPage);

            reader.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
