//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.20 at 02:38:13 PM ICT 
//


package org.opencps.api.faq.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuestionModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuestionModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="questionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name=ConstantUtils.VALUE_EMAIL type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publish" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="questionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="govAgencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="govAgencyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="answered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionModel", propOrder = {
    "questionId",
    "createDate",
    "fullname",
    ConstantUtils.VALUE_EMAIL,
    "content",
    "publish",
    "questionType",
    "govAgencyCode",
    "govAgencyName",
    "answered",
    "subDomainCode",
    "subDomainName"
})
public class QuestionModel {

    protected long questionId;
    @XmlElement(required = true)
    protected String createDate;
    @XmlElement(required = true)
    protected String fullname;
    @XmlElement(required = true)
    protected String email;
    @XmlElement(required = true)
    protected String content;
    protected int publish;
    @XmlElement(required = true)
    protected String questionType;
    @XmlElement(required = true)
    protected String govAgencyCode;
    @XmlElement(required = true)
    protected String govAgencyName;
    protected boolean answered;
    @XmlElement(required = true)
    protected String subDomainCode;
    @XmlElement(required = true)
    protected String subDomainName;

    /**
     * Gets the value of the questionId property.
     * 
     */
    public long getQuestionId() {
        return questionId;
    }

    /**
     * Sets the value of the questionId property.
     * 
     */
    public void setQuestionId(long value) {
        this.questionId = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the fullname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the value of the fullname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullname(String value) {
        this.fullname = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the publish property.
     * 
     */
    public int getPublish() {
        return publish;
    }

    /**
     * Sets the value of the publish property.
     * 
     */
    public void setPublish(int value) {
        this.publish = value;
    }

    /**
     * Gets the value of the questionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * Sets the value of the questionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionType(String value) {
        this.questionType = value;
    }

    /**
     * Gets the value of the govAgencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovAgencyCode() {
        return govAgencyCode;
    }

    /**
     * Sets the value of the govAgencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovAgencyCode(String value) {
        this.govAgencyCode = value;
    }

    /**
     * Gets the value of the govAgencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGovAgencyName() {
        return govAgencyName;
    }

    /**
     * Sets the value of the govAgencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGovAgencyName(String value) {
        this.govAgencyName = value;
    }

    /**
     * Gets the value of the answered property.
     * 
     */
    public boolean isAnswered() {
        return answered;
    }

    /**
     * Sets the value of the answered property.
     * 
     */
    public void setAnswered(boolean value) {
        this.answered = value;
    }


    /**
     * Gets the value of the subDomainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubDomainCode() {
        return subDomainCode;
    }

    /**
     * Sets the value of the subDomainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubDomainCode(String value) {
        this.subDomainCode = value;
    }

    /**
     * Gets the value of the subDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubDomainName() {
        return subDomainName;
    }

    /**
     * Sets the value of the subDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubDomainName(String value) {
        this.subDomainName = value;
    }

}
