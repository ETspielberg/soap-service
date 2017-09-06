//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.09.04 um 06:23:38 PM CEST 
//


package unidue.ub.sushiclient.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This is the actual response expected from a COUNTER_SUSHI service. A combination of the SUSHI ReportResponse with the COUNTER "Report" added. NOTE: The ReportRequest and ReportResponse are defined in the SUSHI1_7.xsd and the COUNTER report is defined in the Counter4_1.xsd.
 * 
 * <p>Java-Klasse für CounterReportResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CounterReportResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.niso.org/schemas/sushi}ReportResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Report" type="{http://www.niso.org/schemas/counter}Reports"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CounterReportResponse", namespace = "http://www.niso.org/schemas/sushi/counter", propOrder = {
    "report"
})
public class CounterReportResponse
    extends ReportResponse
{

    @XmlElement(name = "Report", required = true, nillable = true)
    protected Reports report;

    /**
     * Ruft den Wert der report-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Reports }
     *     
     */
    public Reports getReport() {
        return report;
    }

    /**
     * Legt den Wert der report-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Reports }
     *     
     */
    public void setReport(Reports value) {
        this.report = value;
    }

}
