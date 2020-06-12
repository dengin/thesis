package model.sobiad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: dengin
 * Date: 12.06.2020
 * Time: 02:12
 */
@XmlRootElement(name = "yazarbilgileri")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SobiadYazarBilgileri implements Serializable
{
    private String yazaradi;

    public SobiadYazarBilgileri()
    {
    }

    public SobiadYazarBilgileri(String yazaradi)
    {
        this.yazaradi = yazaradi;
    }

    public String getYazaradi()
    {
        return yazaradi;
    }

    public void setYazaradi(String yazaradi)
    {
        this.yazaradi = yazaradi;
    }
}
