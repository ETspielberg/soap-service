//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.04 um 06:23:38 PM CEST 
//


package unidue.ub.sushiclient.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AttributeType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="AttributeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ArticleVersion"/&gt;
 *     &lt;enumeration value="ArticleType"/&gt;
 *     &lt;enumeration value="QualificationName"/&gt;
 *     &lt;enumeration value="QualificationLevel"/&gt;
 *     &lt;enumeration value="Proprietary"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AttributeType")
@XmlEnum
public enum AttributeType {

    @XmlEnumValue("ArticleVersion")
    ARTICLE_VERSION("ArticleVersion"),
    @XmlEnumValue("ArticleType")
    ARTICLE_TYPE("ArticleType"),
    @XmlEnumValue("QualificationName")
    QUALIFICATION_NAME("QualificationName"),
    @XmlEnumValue("QualificationLevel")
    QUALIFICATION_LEVEL("QualificationLevel"),
    @XmlEnumValue("Proprietary")
    PROPRIETARY("Proprietary");
    private final String value;

    AttributeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AttributeType fromValue(String v) {
        for (AttributeType c: AttributeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
