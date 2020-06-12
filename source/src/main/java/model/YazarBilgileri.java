package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:58
 */
@XmlRootElement(name = "yazarbilgileri")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class YazarBilgileri implements Serializable
{
    private String yazaradi;

    public YazarBilgileri()
    {
    }

    public YazarBilgileri(String yazaradi)
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
