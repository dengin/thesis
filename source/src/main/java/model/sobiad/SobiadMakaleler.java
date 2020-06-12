package model.sobiad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * User: dengin
 * Date: 12.06.2020
 * Time: 02:09
 */
@XmlRootElement(name = "makaleler")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SobiadMakaleler implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<SobiadMakale> makale;

    public SobiadMakaleler()
    {
    }

    public SobiadMakaleler(List<SobiadMakale> makale)
    {
        this.makale = makale;
    }

    public List<SobiadMakale> getMakale()
    {
        return makale;
    }

    public void setMakale(List<SobiadMakale> makale)
    {
        this.makale = makale;
    }
}
