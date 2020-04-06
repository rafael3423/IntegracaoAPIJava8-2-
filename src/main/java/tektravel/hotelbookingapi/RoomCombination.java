
package tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RoomCombination complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RoomCombination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TestElement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomCombination", propOrder = {
    "roomIndex",
    "testElement"
})
public class RoomCombination {

    @XmlElement(name = "RoomIndex", type = Integer.class)
    protected List<Integer> roomIndex;
    @XmlElement(name = "TestElement")
    protected String testElement;

    /**
     * Gets the value of the roomIndex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomIndex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomIndex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getRoomIndex() {
        if (roomIndex == null) {
            roomIndex = new ArrayList<Integer>();
        }
        return this.roomIndex;
    }

    /**
     * Obtém o valor da propriedade testElement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestElement() {
        return testElement;
    }

    /**
     * Define o valor da propriedade testElement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestElement(String value) {
        this.testElement = value;
    }

}
