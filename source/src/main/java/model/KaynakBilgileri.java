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
@XmlRootElement(name = "kaynakbilgileri")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class KaynakBilgileri implements Serializable
{
    private String kaynak;

    public KaynakBilgileri()
    {
    }

    public KaynakBilgileri(String kaynak)
    {
        this.kaynak = kaynak;
    }

    public String getKaynak()
    {
        return kaynak;
    }

    public void setKaynak(String kaynak)
    {
        this.kaynak = kaynak;
    }
}
