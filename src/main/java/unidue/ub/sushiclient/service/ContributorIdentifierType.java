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
 * <p>Java-Klasse für ContributorIdentifierType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ContributorIdentifierType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ISNI"/&gt;
 *     &lt;enumeration value="ORCID"/&gt;
 *     &lt;enumeration value="Name"/&gt;
 *     &lt;enumeration value="Proprietary"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContributorIdentifierType")
@XmlEnum
public enum ContributorIdentifierType {

    ISNI("ISNI"),
    ORCID("ORCID"),
    @XmlEnumValue("Name")
    NAME("Name"),
    @XmlEnumValue("Proprietary")
    PROPRIETARY("Proprietary");
    private final String value;

    ContributorIdentifierType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContributorIdentifierType fromValue(String v) {
        for (ContributorIdentifierType c: ContributorIdentifierType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
