import model.AnahtarBilgileri;
import model.KaynakBilgileri;
import model.Makale;
import model.Makaleler;
import model.sobiad.SobiadAnahtarBilgileri;
import model.sobiad.SobiadMakale;
import model.sobiad.SobiadMakaleler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:53
 */
public class XmlParser
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException
    {
        dergiparkSozlukOlustur();
        sobiadSozlukOlustur();


//        JAXBContext context = JAXBContext.newInstance(Makaleler.class);
//        Unmarshaller un = context.createUnmarshaller();
//        Makaleler makaleler = (Makaleler) un.unmarshal(new File("D:\\makaleDetayDosyasi1.txt"));





//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser saxParser = factory.newSAXParser();
//        Makaleler makaleler = new Makaleler();
//
//        saxParser.parse("D:\\makaleDetayDosyasi1.txt", makaleler);



//        File file = new File("D:\\makaleDetayDosyasi1.txt");
//        InputStream inputStream= new FileInputStream(file);
//        Reader reader = new InputStreamReader(inputStream,"UTF-8");
//
//        InputSource is = new InputSource(reader);
//        is.setEncoding("UTF-8");
//
//        saxParser.parse(is, makale);


//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(file);
//        doc.getDocumentElement().normalize();
//        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
//        NodeList nodeList = doc.getElementsByTagName("makale");
//
//        for (int itr = 0; itr < nodeList.getLength(); itr++)
//        {
//            Node node = nodeList.item(itr);
//            System.out.println("\nNode Name :" + node.getNodeName());
//            if (node.getNodeType() == Node.ELEMENT_NODE)
//            {
//                Element eElement = (Element) node;
//                System.out.println("Sira: " + eElement.getElementsByTagName("sira").item(0).getTextContent());
//                System.out.println("Baslik: " + eElement.getElementsByTagName("baslik").item(0).getTextContent());
//            }
//        }
    }

    private static void sobiadSozlukOlustur() throws FileNotFoundException, UnsupportedEncodingException, SAXException, ParserConfigurationException, JAXBException
    {
        File xmlFile = new File("D:\\sobiad.txt");
        InputStream inputStream= new FileInputStream(xmlFile);
        InputStreamReader inputReader = new InputStreamReader(inputStream,"UTF-8");
        InputSource inputSource = new InputSource(inputReader);
        inputSource.setEncoding("UTF-8");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        Source xmlSource = new SAXSource(factory.newSAXParser().getXMLReader(), inputSource);

        JAXBContext jaxbContext = JAXBContext.newInstance(SobiadMakaleler.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        SobiadMakaleler makaleler = (SobiadMakaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        sozlukOlusturSobiad(makaleler);
    }

    private static void sozlukOlusturSobiad(SobiadMakaleler makaleler)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\kelimeler_sobiad.txt"));

            for (SobiadMakale makale : makaleler.getMakale())
            {
                if (makale.getSira() % 1000 < 3)
                {
                    System.out.println(makale.getSira());
                }
                String content = "";
                if (makale.getBaslik() != null)
                {
                    content += metinEkle(makale.getBaslik());
                }
                if (makale.getOzet() != null)
                {
                    content += metinEkle(makale.getOzet());
                }
                if (makale.getAnahtarbilgileri() != null)
                {
                    for (SobiadAnahtarBilgileri anahtarBilgileri : makale.getAnahtarbilgileri())
                    {
                        content += metinEkle(anahtarBilgileri.getAnahtar());
                    }
                }
                if (makale.getPdf() != null)
                {
                    content += metinEkle(makale.getPdf());
                }
                if (!content.isEmpty())
                {
                    writer.write(content.trim() + " ");
                }
            }
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void dergiparkSozlukOlustur() throws ParserConfigurationException, IOException, SAXException, JAXBException
    {
        File xmlFile = new File("D:\\dergipark.txt");
        InputStream inputStream= new FileInputStream(xmlFile);
        InputStreamReader inputReader = new InputStreamReader(inputStream,"UTF-8");
        InputSource inputSource = new InputSource(inputReader);
        inputSource.setEncoding("UTF-8");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        Source xmlSource = new SAXSource(factory.newSAXParser().getXMLReader(), inputSource);

        JAXBContext jaxbContext = JAXBContext.newInstance(Makaleler.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Makaleler makaleler = (Makaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        sozlukOlustur(makaleler);
    }

    private static void sozlukOlustur(Makaleler makaleler)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\kelimeler_dergipark.txt"));

            for (Makale makale : makaleler.getMakale())
            {
                if (makale.getSira() % 1000 < 3)
                {
                    System.out.println(makale.getSira());
                }
                String content = "";
                if (makale.getBaslik() != null)
                {
                    content += metinEkle(makale.getBaslik());
                }
                if (makale.getOzetbilgisi() != null)
                {
                    content += metinEkle(makale.getOzetbilgisi());
                }
                if (makale.getAnahtarbilgileri() != null)
                {
                    for (AnahtarBilgileri anahtarBilgileri : makale.getAnahtarbilgileri())
                    {
                        content += metinEkle(anahtarBilgileri.getAnahtar());
                    }
                }
                if (makale.getKaynakbilgileri() != null)
                {
                    for (KaynakBilgileri kaynakBilgileri : makale.getKaynakbilgileri())
                    {
                        content += metinEkle(kaynakBilgileri.getKaynak());
                    }
                }
                if (makale.getKonular() != null)
                {
                    content += metinEkle(makale.getKonular());
                }
                if (makale.getBolum() != null)
                {
                    content += metinEkle(makale.getBolum());
                }
                if (makale.getPdf() != null)
                {
                    content += metinEkle(makale.getPdf());
                }
                if (!content.isEmpty())
                {
                    writer.write(content.trim() + " ");
                }
            }
            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String metinEkle(String text)
    {
        String temizMetin = text.replaceAll("[^a-zA-Z ıiüğşöçÜİĞŞÇÖ,.;:\"!?()\\-]", "");
        temizMetin = temizMetin.replace(",", " <COMMA> ");
        temizMetin = temizMetin.replace(".", " <PERIOD> ");
        temizMetin = temizMetin.replace(";", " <SEMICOLON> ");
        temizMetin = temizMetin.replace(":", " <COLON> ");
        temizMetin = temizMetin.replace("\"", " <QUOTATION_MARK> ");
        temizMetin = temizMetin.replace("!", " <EXCLAMATION_MARK> ");
        temizMetin = temizMetin.replace("?", " <QUESTION_MARK> ");
        temizMetin = temizMetin.replace("(", " <LEFT_PAREN> ");
        temizMetin = temizMetin.replace(")", " <RIGHT_PAREN> ");
        temizMetin = temizMetin.replace("-", " <HYPHENS> ");
        temizMetin = temizMetin.replace("\n", " <NEW_LINE> ");
        return temizMetin.toLowerCase();
    }
}
