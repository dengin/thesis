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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:53
 */
public class XmlParser
{
    private static String FILE_DIR = "C:\\Users\\XXX\\tez_calismasi\\";

    static List<String> stopWords = Arrays.asList(new String[]{"acaba", "ama", "aslında", "az", "bazı", "belki", "biri", "birkaç", "birşey",
            "biz", "bu", "çok", "çünkü", "da", "daha", "de", "defa", "diye", "eğer", "en", "gibi", "hem", "hep", "hepsi",
            "her", "hiç", "için", "ile", "ise", "kez", "ki", "kim", "mı", "mu", "mü", "nasıl", "ne", "neden", "nerde",
            "nerede", "nereye", "niçin", "niye", "o", "sanki", "şey", "siz", "şu", "tüm", "ve", "veya", "ya", "yani",
            "<COMMA>", "<PERIOD>", "<SEMICOLON>", "<COLON>", "<QUOTATION_MARK>", "<EXCLAMATION_MARK>", "<QUESTION_MARK>",
            "<LEFT_PAREN>", "<RIGHT_PAREN>", "<HYPHENS>", "<NEW_LINE>"});

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException
    {
        File xmlFile = new File("D:\\dergipark.txt");
        Source xmlSource = getXmlSource(xmlFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(Makaleler.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Makaleler makaleler = (Makaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        int max = 0;
        int len = 0;
        Set<String> kelimeunique = new HashSet();
        int toplam = 0;
        for (Makale sobiadMakale : makaleler.getMakale())
        {
            len = 0;
            if (sobiadMakale.getKonular() != null)
            {
                List a = onisle(sobiadMakale.getKonular());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getOzetbilgisi() != null)
            {
                List a = onisle(sobiadMakale.getOzetbilgisi());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getPdf()!= null)
            {
                List a = onisle(sobiadMakale.getPdf());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getBolum()!= null)
            {
                List a = onisle(sobiadMakale.getBolum());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getBaslik()!= null)
            {
                List a = onisle(sobiadMakale.getBaslik());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getAnahtarbilgileri() != null)
            {
                for (AnahtarBilgileri sobiadAnahtarBilgileri : sobiadMakale.getAnahtarbilgileri())
                {
                    List a = onisle(sobiadAnahtarBilgileri.getAnahtar());
                    kelimeunique.addAll(a);
                    len += a.size();
                }
            }
            if (sobiadMakale.getKaynakbilgileri() != null)
            {
                for (KaynakBilgileri sobiadAnahtarBilgileri : sobiadMakale.getKaynakbilgileri())
                {
                    List a = onisle(sobiadAnahtarBilgileri.getKaynak());
                    kelimeunique.addAll(a);
                    len += a.size();
                }
            }
            toplam += len;
            if (len > max)
            {
                max = len;
            }
        }

        System.out.println("Dergipark: ");
        System.out.println("Toplam kelime sayısı: " + toplam);
        System.out.println("Toplam unique kelime sayısı: " + kelimeunique.size());
        System.out.println("En büyük makale uzunluğu: " + max);


        xmlFile = new File("D:\\sobiad.txt");
        xmlSource = getXmlSource(xmlFile);
        jaxbContext = JAXBContext.newInstance(SobiadMakaleler.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        SobiadMakaleler sobiadMakaleler = (SobiadMakaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        max = 0;
        len = 0;
        kelimeunique = new HashSet();
        toplam = 0;
        for (SobiadMakale sobiadMakale : sobiadMakaleler.getMakale())
        {
            len = 0;
            if (sobiadMakale.getPdf() != null)
            {
                List a = onisle(sobiadMakale.getPdf());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getBaslik() != null)
            {
                List a = onisle(sobiadMakale.getBaslik());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getOzet()!= null)
            {
                List a = onisle(sobiadMakale.getOzet());
                kelimeunique.addAll(a);
                len += a.size();
            }
            if (sobiadMakale.getAnahtarbilgileri() != null)
            {
                for (SobiadAnahtarBilgileri sobiadAnahtarBilgileri : sobiadMakale.getAnahtarbilgileri())
                {
                    List a = onisle(sobiadAnahtarBilgileri.getAnahtar());
                    kelimeunique.addAll(a);
                    len += a.size();
                }
            }
            toplam += len;
            if (len > max)
            {
                max = len;
            }
        }

        System.out.println("Sobiad: ");
        System.out.println("Toplam kelime sayısı: " + toplam);
        System.out.println("Toplam unique kelime sayısı: " + kelimeunique.size());
        System.out.println("En büyük makale uzunluğu: " + max);



//
////        List<Integer> dergiparkList = new ArrayList(Arrays.asList(691,4990,1990,8524,7774,2474,5428,4021,3649,2840,6223,1477,7293,3016,1335,7417,318,1695,3840,296,285,8772,3526,3417,8062,3251,9346));
//        List<Integer> sobiadList = new ArrayList(Arrays.asList(2496,5597,7721,4353,13585,1058,1212,37846,22924,5583,437,5204,6774,33439,44231,7003,41185,2260,1969,3947,7775,48555,7701,41982,46762,38230,35653,15086,25113,1937,50510,3446,33549,42457,51730));
//
//        try
//        {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\sonuclar_sobiad.txt"));
//
//            for (SobiadMakale makale : makaleler.getMakale())
//            {
//                if (sobiadList.contains(makale.getSira()))
//                {
//                    String content = makale.getSira().toString() + ": ";
//                    if (makale.getBaslik() != null)
//                    {
//                        content += "baslik: " + metinEkle(makale.getBaslik() + "\n");
//                    }
//                    if (makale.getOzet() != null)
//                    {
//                        content += "#ozet: " + metinEkle(makale.getOzet()+ "\n");
//                    }
//                    if (makale.getAnahtarbilgileri() != null)
//                    {
//                        content += "#anahtar kelimeler: ";
//                        for (SobiadAnahtarBilgileri anahtarBilgileri : makale.getAnahtarbilgileri())
//                        {
//                            content += " " + metinEkle(anahtarBilgileri.getAnahtar()+ "\n");
//                        }
//                    }
//                    if (!content.isEmpty())
//                    {
//                        writer.write(content.trim() + "\n\n");
//                    }
//                }
//            }
//            writer.close();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//





//        dergiparkSozlukOlustur();
//        sobiadSozlukOlustur();

//        dergiparkMakaleOzetOlustur();
//        sobiadMakaleOzetOlustur();

//        dergiparkMakaleIcerikOlustur();
//        sobiadMakaleIcerikOlustur();

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

    private static List<String> onisle(String temp)
    {
        String[] temps = temp.toLowerCase(new Locale("tr-TR")).split(" ");
        List<String> temp2 = new ArrayList<>();

        for (int i = 0; i < temps.length; i++)
        {
            String s = temps[i];
            if (s.length() > 1 && !stopWords.contains(s)
                    && !s.startsWith("0")
                    && !s.startsWith("1")
                    && !s.startsWith("2")
                    && !s.startsWith("3")
                    && !s.startsWith("4")
                    && !s.startsWith("5")
                    && !s.startsWith("6")
                    && !s.startsWith("7")
                    && !s.startsWith("8")
                    && !s.startsWith("9"))
            {
                temp2.add(s);
            }
        }
        return temp2;
    }

    private static void dergiparkSozlukOlustur() throws ParserConfigurationException, IOException, SAXException, JAXBException
    {
        dergiparkSozlukOlustur(getDergiparkMakaleler());
    }

    private static Makaleler getDergiparkMakaleler() throws FileNotFoundException, UnsupportedEncodingException, ParserConfigurationException, SAXException, JAXBException
    {
        File xmlFile = new File(FILE_DIR + "dergipark.txt");
        Source xmlSource = getXmlSource(xmlFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(Makaleler.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Makaleler) jaxbUnmarshaller.unmarshal(xmlSource);
    }

    private static Source getXmlSource(File xmlFile) throws FileNotFoundException, UnsupportedEncodingException, ParserConfigurationException, SAXException
    {
        InputStream inputStream = new FileInputStream(xmlFile);
        InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
        InputSource inputSource = new InputSource(inputReader);
        inputSource.setEncoding("UTF-8");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        return new SAXSource(factory.newSAXParser().getXMLReader(), inputSource);
    }

    private static void dergiparkSozlukOlustur(Makaleler makaleler)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_DIR + "kelimeler_dergipark.txt"));

            for (Makale makale : makaleler.getMakale())
            {
                if (makale.getSira() % 1000 < 2)
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
        String temizMetin = text.replaceAll("[^a-zA-Z ıiüğşöçÜİĞŞÇÖ,.;:\"!?()\\-\n]", "");
        temizMetin = temizMetin.toLowerCase(Locale.forLanguageTag("tr"));
        temizMetin = temizMetin.replace("  ", " ");
        temizMetin = temizMetin.replace("   ", " ");
        temizMetin = temizMetin.replace("    ", " ");
        temizMetin = temizMetin.replace("     ", " ");
        temizMetin = temizMetin.replace("      ", " ");
        temizMetin = temizMetin.replace("       ", " ");
        temizMetin = temizMetin.replace("        ", " ");
        temizMetin = temizMetin.replace("         ", " ");
        temizMetin = temizMetin.replace("          ", " ");
        temizMetin = temizMetin.replace("           ", " ");
        temizMetin = temizMetin.replace("            ", " ");
        temizMetin = temizMetin.replace("             ", " ");
        temizMetin = temizMetin.replace("              ", " ");
        temizMetin = temizMetin.replace("               ", " ");
        temizMetin = temizMetin.replace("                ", " ");
        temizMetin = temizMetin.replace("                 ", " ");
        temizMetin = temizMetin.replace("                  ", " ");
        temizMetin = temizMetin.replace("                   ", " ");
        temizMetin = temizMetin.replace("                    ", " ");
//        temizMetin = temizMetin.replace(",", " <COMMA> ");
//        temizMetin = temizMetin.replace(".", " <PERIOD> ");
//        temizMetin = temizMetin.replace(";", " <SEMICOLON> ");
//        temizMetin = temizMetin.replace(":", " <COLON> ");
//        temizMetin = temizMetin.replace("\"", " <QUOTATION_MARK> ");
//        temizMetin = temizMetin.replace("!", " <EXCLAMATION_MARK> ");
//        temizMetin = temizMetin.replace("?", " <QUESTION_MARK> ");
//        temizMetin = temizMetin.replace("(", " <LEFT_PAREN> ");
//        temizMetin = temizMetin.replace(")", " <RIGHT_PAREN> ");
//        temizMetin = temizMetin.replace("-", " <HYPHENS> ");
//        temizMetin = temizMetin.replace("\n", " <NEW_LINE> ");
        return temizMetin;
    }

    private static void sobiadSozlukOlustur() throws FileNotFoundException, UnsupportedEncodingException, SAXException, ParserConfigurationException, JAXBException
    {
        sozlukOlusturSobiad(getSobiadMakaleler());
    }

    private static SobiadMakaleler getSobiadMakaleler() throws FileNotFoundException, UnsupportedEncodingException, ParserConfigurationException, SAXException, JAXBException
    {
        File xmlFile = new File(FILE_DIR + "sobiad.txt");
        Source xmlSource = getXmlSource(xmlFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(SobiadMakaleler.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (SobiadMakaleler) jaxbUnmarshaller.unmarshal(xmlSource);
    }

    private static void sozlukOlusturSobiad(SobiadMakaleler makaleler)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_DIR + "kelimeler_sobiad.txt"));

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

    private static void dergiparkMakaleOzetOlustur() throws FileNotFoundException, JAXBException, ParserConfigurationException, SAXException, UnsupportedEncodingException
    {
        ozetOlusturDergipark(getDergiparkMakaleler());
    }

    private static void ozetOlusturDergipark(Makaleler makaleler)
    {
        String adres = FILE_DIR + "ozet_dergipark.csv";

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(adres));
            String content = "sira;makale_no;ozet\n";
            writer.write(content);
            int i = 1;
            for (Makale makale : makaleler.getMakale())
            {
                content = "";
                if (makale.getSira() % 1000 < 2)
                {
                    System.out.println(makale.getSira());
                }
                if (makale.getOzetbilgisi() != null)
                {
                    content += metinEkle(makale.getOzetbilgisi()) + " ";
                }
                if (!content.isEmpty() && !content.trim().equals(""))
                {
                    content = i++ + ";" + makale.getSira() + ";" + content.trim() + "\n";
                    writer.write(content);
                }
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void sobiadMakaleOzetOlustur() throws FileNotFoundException, JAXBException, ParserConfigurationException, SAXException, UnsupportedEncodingException
    {
        ozetOlusturSobiad(getSobiadMakaleler());
    }

    private static void ozetOlusturSobiad(SobiadMakaleler makaleler)
    {
        String adres = FILE_DIR + "ozet_sobiad.csv";

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(adres));
            String content = "sira;makale_no;ozet\n";
            writer.write(content);
            int i = 1;
            for (SobiadMakale makale : makaleler.getMakale())
            {
                content = "";
                if (makale.getSira() % 1000 < 2)
                {
                    System.out.println(makale.getSira());
                }
                if (makale.getOzet() != null)
                {
                    content += metinEkle(makale.getOzet()) + " ";
                }
                if (!content.isEmpty() && !content.trim().equals(""))
                {
                    content = i++ + ";" + makale.getSira() + ";" + content.trim() + "\n";
                    writer.write(content);
                }
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void dergiparkMakaleIcerikOlustur() throws FileNotFoundException, JAXBException, ParserConfigurationException, SAXException, UnsupportedEncodingException
    {
        icerikOlusturDergipark(getDergiparkMakaleler());
    }

    private static void icerikOlusturDergipark(Makaleler makaleler)
    {
        String adres = FILE_DIR + "icerik_dergipark.csv";

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(adres));
            String content = "sira;makale_no;icerik\n";
            writer.write(content);
            int i = 1;
            for (Makale makale : makaleler.getMakale())
            {
                content = "";
                if (makale.getSira() % 1000 < 2)
                {
                    System.out.println(makale.getSira());
                }
                if (makale.getBaslik() != null)
                {
                    content += metinEkle(makale.getBaslik()) + " ";
                }
                if (makale.getOzetbilgisi() != null)
                {
                    content += metinEkle(makale.getOzetbilgisi()) + " ";
                }
                if (makale.getAnahtarbilgileri() != null)
                {
                    for (AnahtarBilgileri anahtarBilgileri : makale.getAnahtarbilgileri())
                    {
                        content += metinEkle(anahtarBilgileri.getAnahtar()) + " ";
                    }
                }
                if (makale.getPdf() != null)
                {
                    content += metinEkle(makale.getPdf()) + " ";
                }
                if (!content.isEmpty() && !content.trim().equals(""))
                {
                    content = i++ + ";" + makale.getSira() + ";" + content.trim() + "\n";
                    writer.write(content);
                }
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void sobiadMakaleIcerikOlustur() throws FileNotFoundException, JAXBException, ParserConfigurationException, SAXException, UnsupportedEncodingException
    {
        icerikOlusturSobiad(getSobiadMakaleler());
    }

    private static void icerikOlusturSobiad(SobiadMakaleler makaleler)
    {
        String adres = FILE_DIR + "icerik_sobiad.csv";
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(adres));
            String content = "sira;makale_no;icerik\n";
            writer.write(content.trim() + "\n");

            int i = 1;
            for (SobiadMakale makale : makaleler.getMakale())
            {
                content = "";
                if (makale.getSira() % 1000 < 2)
                {
                    System.out.println(makale.getSira());
                }
                if (makale.getBaslik() != null)
                {
                    content += metinEkle(makale.getBaslik()) + " ";
                }
                if (makale.getOzet() != null)
                {
                    content += metinEkle(makale.getOzet()) + " ";
                }
                if (makale.getAnahtarbilgileri() != null)
                {
                    for (SobiadAnahtarBilgileri anahtarBilgileri : makale.getAnahtarbilgileri())
                    {
                        content += metinEkle(anahtarBilgileri.getAnahtar()) + " ";
                    }
                }
                if (makale.getPdf() != null)
                {
                    content += metinEkle(makale.getPdf()) + " ";
                }
                if (!content.isEmpty() && !content.trim().equals(""))
                {
                    content = i++ + ";" + makale.getSira() + ";" + content.trim() + "\n";
                    writer.write(content);
                }
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
