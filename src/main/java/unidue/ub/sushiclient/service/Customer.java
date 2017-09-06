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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Details about the customer whose data the report represents.
 * 
 * <p>Java-Klasse für Customer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Customer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.niso.org/schemas/counter}Organization"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Consortium" type="{http://www.niso.org/schemas/counter}Consortium" minOccurs="0"/&gt;
 *         &lt;element name="InstitutionalIdentifier" type="{http://www.niso.org/schemas/counter}Identifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
    "consortium",
    "institutionalIdentifier"
})
@XmlSeeAlso({
    unidue.ub.sushiclient.service.Report.Customer.class
})
public class Customer
    extends Organization
{

    @XmlElement(name = "Consortium")
    protected Consortium consortium;
    @XmlElement(name = "InstitutionalIdentifier")
    protected List<Identifier> institutionalIdentifier;

    /**
     * Ruft den Wert der consortium-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Consortium }
     *     
     */
    public Consortium getConsortium() {
        return consortium;
    }

    /**
     * Legt den Wert der consortium-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Consortium }
     *     
     */
    public void setConsortium(Consortium value) {
        this.consortium = value;
    }

    /**
     * Gets the value of the institutionalIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the institutionalIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstitutionalIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Identifier }
     * 
     * 
     */
    public List<Identifier> getInstitutionalIdentifier() {
        if (institutionalIdentifier == null) {
            institutionalIdentifier = new ArrayList<Identifier>();
        }
        return this.institutionalIdentifier;
    }

}
