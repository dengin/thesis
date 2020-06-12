package model;

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
public class AnahtarBilgileri implements Serializable
{
    private String anahtar;

    public AnahtarBilgileri()
    {
    }

    public AnahtarBilgileri(String anahtar)
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
