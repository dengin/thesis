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
@XmlRootElement(name = "keywordbilgileri")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class KeywordBilgileri implements Serializable
{
    private String keyword;

    public KeywordBilgileri()
    {
    }

    public KeywordBilgileri(String keyword)
    {
        this.keyword = keyword;
    }

    public String getKeyword()
    {
        return keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }
}
