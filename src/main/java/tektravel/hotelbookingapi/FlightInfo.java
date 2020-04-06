
package tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de FlightInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="FlightInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ArrivingByFlight" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="flightName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flightNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Hour" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Minutes" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlightInfo")
public class FlightInfo {

    @XmlAttribute(name = "ArrivingByFlight", required = true)
    protected boolean arrivingByFlight;
    @XmlAttribute(name = "flightName")
    protected String flightName;
    @XmlAttribute(name = "flightNumber")
    protected String flightNumber;
    @XmlAttribute(name = "Hour")
    protected String hour;
    @XmlAttribute(name = "Minutes")
    protected String minutes;
    @XmlAttribute(name = "remarks")
    protected String remarks;

    /**
     * Obtém o valor da propriedade arrivingByFlight.
     * 
     */
    public boolean isArrivingByFlight() {
        return arrivingByFlight;
    }

    /**
     * Define o valor da propriedade arrivingByFlight.
     * 
     */
    public void setArrivingByFlight(boolean value) {
        this.arrivingByFlight = value;
    }

    /**
     * Obtém o valor da propriedade flightName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * Define o valor da propriedade flightName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightName(String value) {
        this.flightName = value;
    }

    /**
     * Obtém o valor da propriedade flightNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Define o valor da propriedade flightNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

    /**
     * Obtém o valor da propriedade hour.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHour() {
        return hour;
    }

    /**
     * Define o valor da propriedade hour.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHour(String value) {
        this.hour = value;
    }

    /**
     * Obtém o valor da propriedade minutes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * Define o valor da propriedade minutes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinutes(String value) {
        this.minutes = value;
    }

    /**
     * Obtém o valor da propriedade remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define o valor da propriedade remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
