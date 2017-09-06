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
 * <p>Java-Klasse für MetricType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="MetricType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ft_ps"/&gt;
 *     &lt;enumeration value="ft_ps_mobile"/&gt;
 *     &lt;enumeration value="ft_pdf"/&gt;
 *     &lt;enumeration value="ft_pdf_mobile"/&gt;
 *     &lt;enumeration value="ft_html"/&gt;
 *     &lt;enumeration value="ft_html_mobile"/&gt;
 *     &lt;enumeration value="ft_epub"/&gt;
 *     &lt;enumeration value="ft_total"/&gt;
 *     &lt;enumeration value="sectioned_html"/&gt;
 *     &lt;enumeration value="toc"/&gt;
 *     &lt;enumeration value="abstract"/&gt;
 *     &lt;enumeration value="reference"/&gt;
 *     &lt;enumeration value="data_set"/&gt;
 *     &lt;enumeration value="audio"/&gt;
 *     &lt;enumeration value="video"/&gt;
 *     &lt;enumeration value="image"/&gt;
 *     &lt;enumeration value="podcast"/&gt;
 *     &lt;enumeration value="multimedia"/&gt;
 *     &lt;enumeration value="record_view"/&gt;
 *     &lt;enumeration value="result_click"/&gt;
 *     &lt;enumeration value="search_reg"/&gt;
 *     &lt;enumeration value="search_fed"/&gt;
 *     &lt;enumeration value="turnaway"/&gt;
 *     &lt;enumeration value="no_license"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MetricType")
@XmlEnum
public enum MetricType {

    @XmlEnumValue("ft_ps")
    FT_PS("ft_ps"),
    @XmlEnumValue("ft_ps_mobile")
    FT_PS_MOBILE("ft_ps_mobile"),
    @XmlEnumValue("ft_pdf")
    FT_PDF("ft_pdf"),
    @XmlEnumValue("ft_pdf_mobile")
    FT_PDF_MOBILE("ft_pdf_mobile"),
    @XmlEnumValue("ft_html")
    FT_HTML("ft_html"),
    @XmlEnumValue("ft_html_mobile")
    FT_HTML_MOBILE("ft_html_mobile"),
    @XmlEnumValue("ft_epub")
    FT_EPUB("ft_epub"),
    @XmlEnumValue("ft_total")
    FT_TOTAL("ft_total"),
    @XmlEnumValue("sectioned_html")
    SECTIONED_HTML("sectioned_html"),
    @XmlEnumValue("toc")
    TOC("toc"),
    @XmlEnumValue("abstract")
    ABSTRACT("abstract"),
    @XmlEnumValue("reference")
    REFERENCE("reference"),
    @XmlEnumValue("data_set")
    DATA_SET("data_set"),
    @XmlEnumValue("audio")
    AUDIO("audio"),
    @XmlEnumValue("video")
    VIDEO("video"),
    @XmlEnumValue("image")
    IMAGE("image"),
    @XmlEnumValue("podcast")
    PODCAST("podcast"),
    @XmlEnumValue("multimedia")
    MULTIMEDIA("multimedia"),
    @XmlEnumValue("record_view")
    RECORD_VIEW("record_view"),
    @XmlEnumValue("result_click")
    RESULT_CLICK("result_click"),
    @XmlEnumValue("search_reg")
    SEARCH_REG("search_reg"),
    @XmlEnumValue("search_fed")
    SEARCH_FED("search_fed"),
    @XmlEnumValue("turnaway")
    TURNAWAY("turnaway"),
    @XmlEnumValue("no_license")
    NO_LICENSE("no_license"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    MetricType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MetricType fromValue(String v) {
        for (MetricType c: MetricType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
