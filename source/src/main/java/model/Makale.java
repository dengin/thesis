package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * User: dengin
 * Date: 14.03.2020
 * Time: 22:54
 */
@XmlRootElement(name = "makale")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Makale implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer sira;
    private String baslik;
    private List<YazarBilgileri> yazarbilgileri;
    private String goruntulenmesayisi;
    private String indirilmesayisi;
    private String doi;
    private String abstractbilgisi;
    private String ozetbilgisi;
    private List<KeywordBilgileri> keywordbilgileri;
    private List<AnahtarBilgileri> anahtarbilgileri;
    private List<KaynakBilgileri> kaynakbilgileri;
    private String birincildil;
    private String konular;
    private String bolum;
    private List<YazarDetaylari> yazardetaylari;
    private String pdf;

    public Makale()
    {
    }

    public Makale(Integer sira, String baslik, List<YazarBilgileri> yazarbilgileri, String goruntulenmesayisi, String indirilmesayisi, String doi, String abstractbilgisi, String ozetbilgisi, List<KeywordBilgileri> keywordbilgileri, List<AnahtarBilgileri> anahtarbilgileri, List<KaynakBilgileri> kaynakbilgileri, String birincildil, String konular, String bolum, List<YazarDetaylari> yazardetaylari, String pdf)
    {
        this.sira = sira;
        this.baslik = baslik;
        this.yazarbilgileri = yazarbilgileri;
        this.goruntulenmesayisi = goruntulenmesayisi;
        this.indirilmesayisi = indirilmesayisi;
        this.doi = doi;
        this.abstractbilgisi = abstractbilgisi;
        this.ozetbilgisi = ozetbilgisi;
        this.keywordbilgileri = keywordbilgileri;
        this.anahtarbilgileri = anahtarbilgileri;
        this.kaynakbilgileri = kaynakbilgileri;
        this.birincildil = birincildil;
        this.konular = konular;
        this.bolum = bolum;
        this.yazardetaylari = yazardetaylari;
        this.pdf = pdf;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Integer getSira()
    {
        return sira;
    }

    public void setSira(Integer sira)
    {
        this.sira = sira;
    }

    public String getBaslik()
    {
        return baslik;
    }

    public void setBaslik(String baslik)
    {
        this.baslik = baslik;
    }

    public List<YazarBilgileri> getYazarbilgileri()
    {
        return yazarbilgileri;
    }

    public void setYazarbilgileri(List<YazarBilgileri> yazarbilgileri)
    {
        this.yazarbilgileri = yazarbilgileri;
    }

    public String getGoruntulenmesayisi()
    {
        return goruntulenmesayisi;
    }

    public void setGoruntulenmesayisi(String goruntulenmesayisi)
    {
        this.goruntulenmesayisi = goruntulenmesayisi;
    }

    public String getIndirilmesayisi()
    {
        return indirilmesayisi;
    }

    public void setIndirilmesayisi(String indirilmesayisi)
    {
        this.indirilmesayisi = indirilmesayisi;
    }

    public String getDoi()
    {
        return doi;
    }

    public void setDoi(String doi)
    {
        this.doi = doi;
    }

    public String getAbstractbilgisi()
    {
        return abstractbilgisi;
    }

    public void setAbstractbilgisi(String abstractbilgisi)
    {
        this.abstractbilgisi = abstractbilgisi;
    }

    public String getOzetbilgisi()
    {
        return ozetbilgisi;
    }

    public void setOzetbilgisi(String ozetbilgisi)
    {
        this.ozetbilgisi = ozetbilgisi;
    }

    public List<KeywordBilgileri> getKeywordbilgileri()
    {
        return keywordbilgileri;
    }

    public void setKeywordbilgileri(List<KeywordBilgileri> keywordbilgileri)
    {
        this.keywordbilgileri = keywordbilgileri;
    }

    public List<AnahtarBilgileri> getAnahtarbilgileri()
    {
        return anahtarbilgileri;
    }

    public void setAnahtarbilgileri(List<AnahtarBilgileri> anahtarbilgileri)
    {
        this.anahtarbilgileri = anahtarbilgileri;
    }

    public List<KaynakBilgileri> getKaynakbilgileri()
    {
        return kaynakbilgileri;
    }

    public void setKaynakbilgileri(List<KaynakBilgileri> kaynakbilgileri)
    {
        this.kaynakbilgileri = kaynakbilgileri;
    }

    public String getBirincildil()
    {
        return birincildil;
    }

    public void setBirincildil(String birincildil)
    {
        this.birincildil = birincildil;
    }

    public String getKonular()
    {
        return konular;
    }

    public void setKonular(String konular)
    {
        this.konular = konular;
    }

    public String getBolum()
    {
        return bolum;
    }

    public void setBolum(String bolum)
    {
        this.bolum = bolum;
    }

    public List<YazarDetaylari> getYazardetaylari()
    {
        return yazardetaylari;
    }

    public void setYazardetaylari(List<YazarDetaylari> yazardetaylari)
    {
        this.yazardetaylari = yazardetaylari;
    }

    public String getPdf()
    {
        return pdf;
    }

    public void setPdf(String pdf)
    {
        this.pdf = pdf;
    }
}
