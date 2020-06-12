package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * User: dengin
 * Date: 15.03.2020
 * Time: 22:06
 */
@XmlRootElement(name = "makaleler")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Makaleler implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<Makale> makale;

    public Makaleler()
    {
    }

    public Makaleler(List<Makale> makale)
    {
        this.makale = makale;
    }

    public List<Makale> getMakale()
    {
        return makale;
    }

    public void setMakale(List<Makale> makale)
    {
        this.makale = makale;
    }
}
