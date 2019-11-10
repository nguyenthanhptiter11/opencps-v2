//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.31 at 10:38:43 AM ICT 
//


package org.opencps.api.datamgt.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.opencps.dossiermgt.action.util.ConstantUtils;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name=ConstantUtils.TOTAL type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element ref="{}DictCollectionShortModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    ConstantUtils.TOTAL,
    "dictCollectionShortModel"
})
@XmlRootElement(name = ConstantUtils.DATA)
public class DictCollectionResults {

    protected long total;
    @XmlElement(name = ConstantUtils.DATA)
    protected List<DictCollectionShortModel> dictCollectionShortModel;

    /**
     * Gets the value of the total property.
     * 
     */
    public long getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(long value) {
        this.total = value;
    }

    /**
     * Gets the value of the dictCollectionShortModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dictCollectionShortModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDictCollectionShortModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DictCollectionShortModel }
     * 
     * 
     */
    public List<DictCollectionShortModel> getDictCollectionShortModel() {
        if (dictCollectionShortModel == null) {
            dictCollectionShortModel = new ArrayList<DictCollectionShortModel>();
        }
        return this.dictCollectionShortModel;
    }

}
