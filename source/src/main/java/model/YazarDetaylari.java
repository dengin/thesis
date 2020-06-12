package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 23:10
 */
@XmlRootElement(name = "yazardetay")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class YazarDetaylari implements Serializable
{
    private String yazarorcid;
    private String yazaradi;
    private String kurumadi;
    private String ulke;

    public YazarDetaylari()
    {
    }

    public YazarDetaylari(String yazarorcid, String yazaradi, String kurumadi, String ulke)
    {
        this.yazarorcid = yazarorcid;
        this.yazaradi = yazaradi;
        this.kurumadi = kurumadi;
        this.ulke = ulke;
    }

    public String getYazarorcid()
    {
        return yazarorcid;
    }

    public void setYazarorcid(String yazarorcid)
    {
        this.yazarorcid = yazarorcid;
    }

    public String getYazaradi()
    {
        return yazaradi;
    }

    public void setYazaradi(String yazaradi)
    {
        this.yazaradi = yazaradi;
    }

    public String getKurumadi()
    {
        return kurumadi;
    }

    public void setKurumadi(String kurumadi)
    {
        this.kurumadi = kurumadi;
    }

    public String getUlke()
    {
        return ulke;
    }

    public void setUlke(String ulke)
    {
        this.ulke = ulke;
    }
}
