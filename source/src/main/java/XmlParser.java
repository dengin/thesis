import model.Makale;
import model.Makaleler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:53
 */
public class XmlParser
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException
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
        Makaleler dataSerialize = (Makaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        System.out.println("");

        List<Integer> siraListesi = new ArrayList<>();
        for (Iterator<Makale> iterator = dataSerialize.getMakale().iterator(); iterator.hasNext(); )
        {
            siraListesi.add(iterator.next().getSira());
        }

        for (int i = 0; i < 9984; i++)
        {
            if (!siraListesi.contains(i))
            {
                System.out.println(i);
            }
        }


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
}
