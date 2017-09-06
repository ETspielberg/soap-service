//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.04 um 06:23:38 PM CEST 
//


package unidue.ub.sushiclient.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * The actual usage details.
 * 
 * <p>Java-Klasse für Metric complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Metric"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Period" type="{http://www.niso.org/schemas/counter}DateRange"/&gt;
 *         &lt;element name="Category" type="{http://www.niso.org/schemas/counter}Category"/&gt;
 *         &lt;element name="Instance" type="{http://www.niso.org/schemas/counter}PerformanceCounter" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="PubYr" type="{http://www.w3.org/2001/XMLSchema}gYear" /&gt;
 *       &lt;attribute name="PubYrFrom" type="{http://www.w3.org/2001/XMLSchema}gYear" /&gt;
 *       &lt;attribute name="PubYrTo" type="{http://www.w3.org/2001/XMLSchema}gYear" /&gt;
 *       &lt;attribute name="IsArchive" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Metric", propOrder = {
    "period",
    "category",
    "instance"
})
public class Metric {

    @XmlElement(name = "Period", required = true)
    protected DateRange period;
    @XmlElement(name = "Category", required = true)
    @XmlSchemaType(name = "string")
    protected Category category;
    @XmlElement(name = "Instance", required = true)
    protected List<PerformanceCounter> instance;
    @XmlAttribute(name = "PubYr")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYr;
    @XmlAttribute(name = "PubYrFrom")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYrFrom;
    @XmlAttribute(name = "PubYrTo")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar pubYrTo;
    @XmlAttribute(name = "IsArchive")
    protected Boolean isArchive;

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setPeriod(DateRange value) {
        this.period = value;
    }

    /**
     * Ruft den Wert der category-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Legt den Wert der category-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
        this.category = value;
    }

    /**
     * Gets the value of the instance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerformanceCounter }
     * 
     * 
     */
    public List<PerformanceCounter> getInstance() {
        if (instance == null) {
            instance = new ArrayList<PerformanceCounter>();
        }
        return this.instance;
    }

    /**
     * Ruft den Wert der pubYr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPubYr() {
        return pubYr;
    }

    /**
     * Legt den Wert der pubYr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPubYr(XMLGregorianCalendar value) {
        this.pubYr = value;
    }

    /**
     * Ruft den Wert der pubYrFrom-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPubYrFrom() {
        return pubYrFrom;
    }

    /**
     * Legt den Wert der pubYrFrom-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPubYrFrom(XMLGregorianCalendar value) {
        this.pubYrFrom = value;
    }

    /**
     * Ruft den Wert der pubYrTo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPubYrTo() {
        return pubYrTo;
    }

    /**
     * Legt den Wert der pubYrTo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPubYrTo(XMLGregorianCalendar value) {
        this.pubYrTo = value;
    }

    /**
     * Ruft den Wert der isArchive-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsArchive() {
        return isArchive;
    }

    /**
     * Legt den Wert der isArchive-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsArchive(Boolean value) {
        this.isArchive = value;
    }

}
