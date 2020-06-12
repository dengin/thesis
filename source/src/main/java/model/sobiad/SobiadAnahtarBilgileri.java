package model.sobiad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 23:01
 */
@XmlRootElement(name = "anahtarbilgileri")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SobiadAnahtarBilgileri implements Serializable
{
    private String anahtar;

    public SobiadAnahtarBilgileri()
    {
    }

    public SobiadAnahtarBilgileri(String anahtar)
    {
        this.anahtar = anahtar;
    }

    public String getAnahtar()
    {
        return anahtar;
    }

    public void setAnahtar(String anahtar)
    {
        this.anahtar = anahtar;
    }
}
