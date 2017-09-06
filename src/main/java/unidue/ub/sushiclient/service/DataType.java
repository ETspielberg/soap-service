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
 * <p>Java-Klasse für DataType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="DataType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Journal"/&gt;
 *     &lt;enumeration value="Database"/&gt;
 *     &lt;enumeration value="Platform"/&gt;
 *     &lt;enumeration value="Book"/&gt;
 *     &lt;enumeration value="Collection"/&gt;
 *     &lt;enumeration value="Multimedia"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataType")
@XmlEnum
public enum DataType {

    @XmlEnumValue("Journal")
    JOURNAL("Journal"),
    @XmlEnumValue("Database")
    DATABASE("Database"),
    @XmlEnumValue("Platform")
    PLATFORM("Platform"),
    @XmlEnumValue("Book")
    BOOK("Book"),
    @XmlEnumValue("Collection")
    COLLECTION("Collection"),
    @XmlEnumValue("Multimedia")
    MULTIMEDIA("Multimedia");
    private final String value;

    DataType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataType fromValue(String v) {
        for (DataType c: DataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
