//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.15 at 02:33:21 PM ICT 
//


package org.opencps.api.serviceconfig.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processOptionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="seqOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="autoSelect" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instructionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submissionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dossierTemplateId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="templateNo " type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceProcessId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="processNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessOption", propOrder = {
    "processOptionId",
    "seqOrder",
    "autoSelect",
    "instructionNote",
    "submissionNote",
    "dossierTemplateId",
    "templateNo0020",
    "templateName",
    "serviceProcessId",
    "processNo",
    "processName",
    "optionName",
    "serviceConfigId"
})
@XmlRootElement(name = "ProcessOption")
public class ProcessOption {

    protected Integer processOptionId;
    protected Integer seqOrder;
    protected String autoSelect;
    protected String instructionNote;
    protected String submissionNote;
    protected Integer dossierTemplateId;
    @XmlElement(name = "templateNo")
    protected String templateNo0020;
    protected String templateName;
    protected Integer serviceProcessId;
    protected String processNo;
    protected String processName;
    protected Long serviceConfigId;

    public Long getServiceConfigId() {
		return serviceConfigId;
	}

	public void setServiceConfigId(Long serviceConfigId) {
		this.serviceConfigId = serviceConfigId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	protected String optionName;

    /**
     * Gets the value of the processOptionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProcessOptionId() {
        return processOptionId;
    }

    /**
     * Sets the value of the processOptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProcessOptionId(Integer value) {
        this.processOptionId = value;
    }

    /**
     * Gets the value of the seqOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeqOrder() {
        return seqOrder;
    }

    /**
     * Sets the value of the seqOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeqOrder(Integer value) {
        this.seqOrder = value;
    }

    /**
     * Gets the value of the autoSelect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoSelect() {
        return autoSelect;
    }

    /**
     * Sets the value of the autoSelect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoSelect(String value) {
        this.autoSelect = value;
    }

    /**
     * Gets the value of the instructionNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructionNote() {
        return instructionNote;
    }

    /**
     * Sets the value of the instructionNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructionNote(String value) {
        this.instructionNote = value;
    }

    /**
     * Gets the value of the submissionNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmissionNote() {
        return submissionNote;
    }

    /**
     * Sets the value of the submissionNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmissionNote(String value) {
        this.submissionNote = value;
    }

    /**
     * Gets the value of the dossierTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDossierTemplateId() {
        return dossierTemplateId;
    }

    /**
     * Sets the value of the dossierTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDossierTemplateId(Integer value) {
        this.dossierTemplateId = value;
    }

    /**
     * Gets the value of the templateNo0020 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateNo_0020() {
        return templateNo0020;
    }

    /**
     * Sets the value of the templateNo0020 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateNo_0020(String value) {
        this.templateNo0020 = value;
    }

    /**
     * Gets the value of the templateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the value of the templateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateName(String value) {
        this.templateName = value;
    }

    /**
     * Gets the value of the serviceProcessId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServiceProcessId() {
        return serviceProcessId;
    }

    /**
     * Sets the value of the serviceProcessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceProcessId(Integer value) {
        this.serviceProcessId = value;
    }

    /**
     * Gets the value of the processNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessNo() {
        return processNo;
    }

    /**
     * Sets the value of the processNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessNo(String value) {
        this.processNo = value;
    }

    /**
     * Gets the value of the processName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessName(String value) {
        this.processName = value;
    }

}
