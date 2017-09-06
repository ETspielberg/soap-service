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
import javax.xml.bind.annotation.XmlType;


/**
 * An author, editor or other contributor to a work.
 * 
 * <p>Java-Klasse für ItemContributor complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemContributor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ItemContributorID" type="{http://www.niso.org/schemas/counter}ItemContributorID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemContributorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ItemContributorAffiliation" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ItemContributorRole" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemContributor", propOrder = {
    "itemContributorID",
    "itemContributorName",
    "itemContributorAffiliation",
    "itemContributorRole"
})
public class ItemContributor {

    @XmlElement(name = "ItemContributorID")
    protected List<ItemContributorID> itemContributorID;
    @XmlElement(name = "ItemContributorName")
    protected String itemContributorName;
    @XmlElement(name = "ItemContributorAffiliation")
    protected List<String> itemContributorAffiliation;
    @XmlElement(name = "ItemContributorRole")
    protected List<String> itemContributorRole;

    /**
     * Gets the value of the itemContributorID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemContributorID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemContributorID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemContributorID }
     * 
     * 
     */
    public List<ItemContributorID> getItemContributorID() {
        if (itemContributorID == null) {
            itemContributorID = new ArrayList<ItemContributorID>();
        }
        return this.itemContributorID;
    }

    /**
     * Ruft den Wert der itemContributorName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemContributorName() {
        return itemContributorName;
    }

    /**
     * Legt den Wert der itemContributorName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemContributorName(String value) {
        this.itemContributorName = value;
    }

    /**
     * Gets the value of the itemContributorAffiliation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemContributorAffiliation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemContributorAffiliation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemContributorAffiliation() {
        if (itemContributorAffiliation == null) {
            itemContributorAffiliation = new ArrayList<String>();
        }
        return this.itemContributorAffiliation;
    }

    /**
     * Gets the value of the itemContributorRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemContributorRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemContributorRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemContributorRole() {
        if (itemContributorRole == null) {
            itemContributorRole = new ArrayList<String>();
        }
        return this.itemContributorRole;
    }

}
