package model.sobiad;

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

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:53
 */
public class SobiadXmlParser
{
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, JAXBException
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
        SobiadMakaleler dataSerialize = (SobiadMakaleler) jaxbUnmarshaller.unmarshal(xmlSource);

        System.out.println("");
    }
}
