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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The container for usage data and other information related to an item such as a journal, book, database, etc.
 * 
 * <p>Java-Klasse für ReportItem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReportItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ParentItem" type="{http://www.niso.org/schemas/counter}ParentItem" minOccurs="0"/&gt;
 *         &lt;element name="ItemIdentifier" type="{http://www.niso.org/schemas/counter}Identifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemContributor" type="{http://www.niso.org/schemas/counter}ItemContributor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemDate" type="{http://www.niso.org/schemas/counter}ItemDate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemAttribute" type="{http://www.niso.org/schemas/counter}ItemAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemPlatform" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ItemPublisher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ItemDataType" type="{http://www.niso.org/schemas/counter}DataType"/&gt;
 *         &lt;element name="ItemPerformance" type="{http://www.niso.org/schemas/counter}Metric" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportItem", propOrder = {
    "parentItem",
    "itemIdentifier",
    "itemContributor",
    "itemDate",
    "itemAttribute",
    "itemPlatform",
    "itemPublisher",
    "itemName",
    "itemDataType",
    "itemPerformance"
})
public class ReportItem {

    @XmlElement(name = "ParentItem")
    protected ParentItem parentItem;
    @XmlElement(name = "ItemIdentifier")
    protected List<Identifier> itemIdentifier;
    @XmlElement(name = "ItemContributor")
    protected List<ItemContributor> itemContributor;
    @XmlElement(name = "ItemDate")
    protected List<ItemDate> itemDate;
    @XmlElement(name = "ItemAttribute")
    protected List<ItemAttribute> itemAttribute;
    @XmlElement(name = "ItemPlatform", required = true)
    protected String itemPlatform;
    @XmlElement(name = "ItemPublisher")
    protected String itemPublisher;
    @XmlElement(name = "ItemName", required = true)
    protected String itemName;
    @XmlElement(name = "ItemDataType", required = true)
    @XmlSchemaType(name = "string")
    protected DataType itemDataType;
    @XmlElement(name = "ItemPerformance", required = true)
    protected List<Metric> itemPerformance;

    /**
     * Ruft den Wert der parentItem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ParentItem }
     *     
     */
    public ParentItem getParentItem() {
        return parentItem;
    }

    /**
     * Legt den Wert der parentItem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentItem }
     *     
     */
    public void setParentItem(ParentItem value) {
        this.parentItem = value;
    }

    /**
     * Gets the value of the itemIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Identifier }
     * 
     * 
     */
    public List<Identifier> getItemIdentifier() {
        if (itemIdentifier == null) {
            itemIdentifier = new ArrayList<Identifier>();
        }
        return this.itemIdentifier;
    }

    /**
     * Gets the value of the itemContributor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemContributor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemContributor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemContributor }
     * 
     * 
     */
    public List<ItemContributor> getItemContributor() {
        if (itemContributor == null) {
            itemContributor = new ArrayList<ItemContributor>();
        }
        return this.itemContributor;
    }

    /**
     * Gets the value of the itemDate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemDate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemDate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemDate }
     * 
     * 
     */
    public List<ItemDate> getItemDate() {
        if (itemDate == null) {
            itemDate = new ArrayList<ItemDate>();
        }
        return this.itemDate;
    }

    /**
     * Gets the value of the itemAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemAttribute }
     * 
     * 
     */
    public List<ItemAttribute> getItemAttribute() {
        if (itemAttribute == null) {
            itemAttribute = new ArrayList<ItemAttribute>();
        }
        return this.itemAttribute;
    }

    /**
     * Ruft den Wert der itemPlatform-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemPlatform() {
        return itemPlatform;
    }

    /**
     * Legt den Wert der itemPlatform-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemPlatform(String value) {
        this.itemPlatform = value;
    }

    /**
     * Ruft den Wert der itemPublisher-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemPublisher() {
        return itemPublisher;
    }

    /**
     * Legt den Wert der itemPublisher-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemPublisher(String value) {
        this.itemPublisher = value;
    }

    /**
     * Ruft den Wert der itemName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Legt den Wert der itemName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * Ruft den Wert der itemDataType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getItemDataType() {
        return itemDataType;
    }

    /**
     * Legt den Wert der itemDataType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setItemDataType(DataType value) {
        this.itemDataType = value;
    }

    /**
     * Gets the value of the itemPerformance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemPerformance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemPerformance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Metric }
     * 
     * 
     */
    public List<Metric> getItemPerformance() {
        if (itemPerformance == null) {
            itemPerformance = new ArrayList<Metric>();
        }
        return this.itemPerformance;
    }

}
