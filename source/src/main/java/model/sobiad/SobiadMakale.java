package model.sobiad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * User: dengin
 * Date: 12.06.2020
 * Time: 02:10
 */
@XmlRootElement(name = "makale")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SobiadMakale implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer sira;
    private String pdf;
    private String baslik;
    private Integer yil;
    private List<SobiadYazarBilgileri> yazarbilgileri;
    private String doi;
    private String ozet;
    private List<SobiadAnahtarBilgileri> anahtarbilgileri;

    public SobiadMakale()
    {
    }

    public SobiadMakale(Integer sira, String pdf, String baslik, Integer yil, List<SobiadYazarBilgileri> yazarbilgileri, String doi, String ozet, List<SobiadAnahtarBilgileri> anahtarbilgileri)
    {
        this.sira = sira;
        this.pdf = pdf;
        this.baslik = baslik;
        this.yil = yil;
        this.yazarbilgileri = yazarbilgileri;
        this.doi = doi;
        this.ozet = ozet;
        this.anahtarbilgileri = anahtarbilgileri;
    }

    public Integer getSira()
    {
        return sira;
    }

    public void setSira(Integer sira)
    {
        this.sira = sira;
    }

    public String getPdf()
    {
        return pdf;
    }

    public void setPdf(String pdf)
    {
        this.pdf = pdf;
    }

    public String getBaslik()
    {
        return baslik;
    }

    public void setBaslik(String baslik)
    {
        this.baslik = baslik;
    }

    public Integer getYil()
    {
        return yil;
    }

    public void setYil(Integer yil)
    {
        this.yil = yil;
    }

    public List<SobiadYazarBilgileri> getYazarbilgileri()
    {
        return yazarbilgileri;
    }

    public void setYazarbilgileri(List<SobiadYazarBilgileri> yazarbilgileri)
    {
        this.yazarbilgileri = yazarbilgileri;
    }

    public String getDoi()
    {
        return doi;
    }

    public void setDoi(String doi)
    {
        this.doi = doi;
    }

    public String getOzet()
    {
        return ozet;
    }

    public void setOzet(String ozet)
    {
        this.ozet = ozet;
    }

    public List<SobiadAnahtarBilgileri> getAnahtarbilgileri()
    {
        return anahtarbilgileri;
    }

    public void setAnahtarbilgileri(List<SobiadAnahtarBilgileri> anahtarbilgileri)
    {
        this.anahtarbilgileri = anahtarbilgileri;
    }
}
