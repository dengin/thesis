import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * User: dengin
 * Date: 23.05.2020
 * Time: 15:52
 */
public class DownloadPdfFromUrl
{
    public static void main(String[] args) throws IOException
    {
        String adres = "";
        String adresBaslangici = "C:/pdf/sobiad/";
        String pdfAdresi = "";
        String dosyaAdresi = "";
        int makale_no = 0;

        try
        {
            int i = 0;
            //pdf dosyalarinin web adreslerini iceren bir dosya hazirlandi
            Scanner scanner = new Scanner(new File("pdf adreslerinin oldugu dosya"));
            while (scanner.hasNextLine())
            {
                if (i++ % 100 == 0)
                {
                    System.out.println("Sıra: " + i);
                    Thread.sleep(1000);
                }


                adres = scanner.nextLine();
                makale_no = Integer.valueOf(adres.substring(0, adres.indexOf("_")));
                pdfAdresi = "https://atif.sobiad.com/" + adres.substring(adres.indexOf("=/files") + 2);
                dosyaAdresi = adresBaslangici + makale_no;


                makePdfFile(pdfAdresi, dosyaAdresi);

                convertPdfToTxtFile(dosyaAdresi);

                deleteTemporaryPdfFile(dosyaAdresi);


            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void makePdfFile(String pdfAdresi, String dosyaAdresi)
    {
        try (BufferedInputStream in = new BufferedInputStream(new URL(pdfAdresi).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(dosyaAdresi + ".pdf"))
        {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1)
            {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void convertPdfToTxtFile(String dosyaAdresi) throws IOException
    {

        PDFTextStripper tStripper = null;

        BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdresi + ".txt"));
        String content = "";

        try
        {
            PDDocument document = PDDocument.load(new File(dosyaAdresi + ".pdf"));

            tStripper = new PDFTextStripper();
            tStripper.setStartPage(1);
            tStripper.setEndPage(document.getNumberOfPages());
            if (!document.isEncrypted())
            {
                String pdfFileInText = tStripper.getText(document);
                String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
                for (String line : lines)
                {
                    content += line;
                }
            }
            document.close();
            writer.write(content.trim());

        }
        catch (IOException e)
        {
            content = "";
        }
        writer.close();
    }

    private static void deleteTemporaryPdfFile(String dosyaAdresi)
    {
        File file = new File(dosyaAdresi + ".pdf");
        file.delete();
    }
}
