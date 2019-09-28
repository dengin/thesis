import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dengin
 * Date: 28.09.2019
 * Time: 21:12
 */
public class AdobePdf
{
    private static final String FILE_NAME = "test2.pdf";

    public static void main(String[] args)
    {
        System.out.println("########################## Read Text From Pdf File ##########################");
        readTextFromPdf();
        System.out.println("\n########################## Read Urls From Pdf File ##########################");
        readAnnotationsFromPdf();
    }

    private static void readTextFromPdf()
    {
        ClassLoader classLoader = new AdobePdf().getClass().getClassLoader();
        PDFTextStripper tStripper = null;
        try
        {
            PDDocument document = PDDocument.load(new File(classLoader.getResource(FILE_NAME).getFile()));

            tStripper = new PDFTextStripper();
            tStripper.setStartPage(1);
            tStripper.setEndPage(document.getNumberOfPages());
//            System.out.println(document.getClass());
            String content = "";
            if (!document.isEncrypted())
            {
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
                for (String line : lines)
                {
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

    private static void readAnnotationsFromPdf()
    {
        ClassLoader classLoader = new AdobePdf().getClass().getClassLoader();
        try
        {
            PDDocument document = PDDocument.load(new File(classLoader.getResource(FILE_NAME).getFile()));
            List<String> urls = new ArrayList<>();
            for (int i = 0; i < document.getNumberOfPages(); i++)
            {
                PDPage pdfpage = document.getPage(i);
                List<PDAnnotation> annotations = pdfpage.getAnnotations();
                for (int j = 0; j < annotations.size(); j++)
                {
                    PDAnnotation annot = annotations.get(j);
                    if (annot instanceof PDAnnotationLink)
                    {
                        PDAnnotationLink link = (PDAnnotationLink) annot;
                        PDAction action = link.getAction();
                        if (action instanceof PDActionURI)
                        {
                            PDActionURI uri = (PDActionURI) action;
                            urls.add(uri.getURI());
                        }
                    }
                }
            }
            System.out.println("Urls: " + urls);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
