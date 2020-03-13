//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.23 at 09:44:18 AM ICT 
//


package org.opencps.dossiermgt.input.model;

public class DossierPublishModel {
    protected String referenceUid;
    protected String serviceCode;
    protected String serviceName;	
    protected String govAgencyCode;
    protected String govAgencyName;	
    protected String dossierTemplateNo;
    protected String applicantName;
    protected String applicantIdType;
    protected String applicantIdNo;
    protected String applicantIdDate;
    protected String address;
    protected String cityCode;
    protected String cityName;	
    protected String districtCode;
    protected String districtName;
    protected String wardCode;
    protected String wardName;
    protected String contactName;
    protected String contactTelNo;
    protected String contactEmail;
    protected String password;
    protected String online;
    protected String notification;
    protected String applicantNote;
	protected int viaPostal;
	protected String postalAddress;
	protected String postalCityCode;
	protected String postalTelNo;
	protected String originality;
	protected String dossierNo;
	protected String createDate;
	protected String modifiedDate;	
	protected String submitDate;
	protected String receiveDate;
	protected String dueDate;
	protected String releaseDate;
	protected String finishDate;
	protected String cancellingDate;
	protected String correcttingDate;
	protected String endorsementDate;
	protected String extendDate;
	protected String processDate;	
	protected String dossierStatus;
	protected String dossierStatusText;
	protected String dossierSubStatus;
	protected String dossierSubStatusText;
	private boolean isSameAsApplicant;
	private String delegateName;
	private String delegateIdNo;
	private String delegateTelNo;
	private String delegateEmail;
	private String delegateAddress;
	private String delegateCityCode;
	private String delegateDistrictCode;
	private String delegateWardCode;
	private Long dossierActionId;
	private String submissionNote;
	private String lockState;	
	private Integer counter;	
	protected String postalCityName;
	protected String delegateCityName;
	protected String delegateDistrictName;
	protected String delegateWardName;
	protected String processNo;
	protected Double durationCount;
	protected Integer durationUnit;
	protected Integer sampleCount;
	protected String dossierName;
	protected String metaData;
	protected String dossierCounter;

	public String getDossierCounter() {
		return dossierCounter;
	}

	public void setDossierCounter(String dossierCounter) {
		this.dossierCounter = dossierCounter;
	}

	public int getViaPostal() {
		return viaPostal;
	}

	public void setViaPostal(int viaPostal) {
		this.viaPostal = viaPostal;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalCityCode() {
		return postalCityCode;
	}

	public void setPostalCityCode(String postalCityCode) {
		this.postalCityCode = postalCityCode;
	}

	public String getPostalTelNo() {
		return postalTelNo;
	}

	public void setPostalTelNo(String postalTelNo) {
		this.postalTelNo = postalTelNo;
	}

	public String getApplicantNote() {
		return applicantNote;
	}

	public void setApplicantNote(String applicantNote) {
		this.applicantNote = applicantNote;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	/**
     * Gets the value of the referenceUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceUid() {
        return referenceUid;
    }

    /**
     * Sets the value of the referenceUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceUid(String value) {
        this.referenceUid = value;
    }

    /**
     * Gets the value of the serviceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
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
     * Gets the value of the dossierTemplateNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierTemplateNo() {
        return dossierTemplateNo;
    }

    /**
     * Sets the value of the dossierTemplateNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierTemplateNo(String value) {
        this.dossierTemplateNo = value;
    }

    /**
     * Gets the value of the applicantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * Sets the value of the applicantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantName(String value) {
        this.applicantName = value;
    }

    /**
     * Gets the value of the applicantIdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantIdType() {
        return applicantIdType;
    }

    /**
     * Sets the value of the applicantIdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantIdType(String value) {
        this.applicantIdType = value;
    }

    /**
     * Gets the value of the applicantIdNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantIdNo() {
        return applicantIdNo;
    }

    /**
     * Sets the value of the applicantIdNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantIdNo(String value) {
        this.applicantIdNo = value;
    }

    /**
     * Gets the value of the applicantIdDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicantIdDate() {
        return applicantIdDate;
    }

    /**
     * Sets the value of the applicantIdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicantIdDate(String value) {
        this.applicantIdDate = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the cityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Sets the value of the cityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityCode(String value) {
        this.cityCode = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }
    
    /**
     * Gets the value of the districtCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * Sets the value of the districtCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrictCode(String value) {
        this.districtCode = value;
    }

    /**
     * Gets the value of the districtName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * Sets the value of the districtCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrictName(String value) {
        this.districtName = value;
    }
    
    /**
     * Gets the value of the wardCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWardCode() {
        return wardCode;
    }

    /**
     * Sets the value of the wardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWardCode(String value) {
        this.wardCode = value;
    }

    /**
     * Gets the value of the wardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWardName() {
        return wardName;
    }

    /**
     * Sets the value of the wardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWardName(String value) {
        this.wardName = value;
    }
    
    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactTelNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactTelNo() {
        return contactTelNo;
    }

    /**
     * Sets the value of the contactTelNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactTelNo(String value) {
        this.contactTelNo = value;
    }

    /**
     * Gets the value of the contactEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the value of the contactEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the online property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnline() {
        return online;
    }

    /**
     * Sets the value of the online property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnline(String value) {
        this.online = value;
    }

    /**
     * Gets the value of the originality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginality() {
        return originality;
    }

    /**
     * Sets the value of the originality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginality(String value) {
        this.originality = value;
    } 

    /**
     * Gets the value of the dossierNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierNo() {
        return dossierNo;
    }

    /**
     * Sets the value of the dossierNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierNo(String value) {
        this.dossierNo = value;
    } 

    public String getCreateDate() {
    	return createDate;
    }
    
    public void setCreateDate(String value) {
    	this.createDate = value;
    }
    
    public String getModifiedDate() {
    	return modifiedDate;
    }
    
    public void setModifiedDate(String value) {
    	this.modifiedDate = value;
    }

    /**
     * Gets the value of the submitDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitDate() {
        return submitDate;
    }

    /**
     * Sets the value of the submitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitDate(String value) {
        this.submitDate = value;
    } 

    /**
     * Gets the value of the receiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiveDate() {
        return receiveDate;
    }

    /**
     * Sets the value of the receiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiveDate(String value) {
        this.receiveDate = value;
    } 

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    public String getReleaseDate() {
    	return releaseDate;
    }
    
    public void setReleaseDate(String value) {
    	this.releaseDate = value;
    }
    
    public String getFinishDate() {
    	return finishDate;
    }
    
    public void setFinishDate(String value) {
    	this.finishDate = value;
    }
    
    public String getCancellingDate() {
    	return cancellingDate;
    }
    
    public void setCancellingDate(String value) {
    	this.cancellingDate = value;
    }
    
    public String getCorrecttingDate() {
    	return correcttingDate;
    }
    
    public void setCorrectingDate(String value) {
    	this.correcttingDate = value;
    }
    
    public String getEndorsementDate() {
    	return endorsementDate;
    }
    
    public void setEndorsementDate(String value) {
    	this.createDate = value;
    }
    
    public String getExtendDate() {
    	return extendDate;
    }
    
    public void setExtendDate(String value) {
    	this.extendDate = value;
    }
    
    public String getProcessDate() {
    	return processDate;
    }
    
    public void setProcessDate(String value) {
    	this.processDate = value;
    }
    
	public String getDossierStatus() {
		return dossierStatus;
	}

	public void setDossierStatus(String dossierStatus) {
		this.dossierStatus = dossierStatus;
	}

	public String getDossierStatusText() {
		return dossierStatusText;
	}

	public void setDossierStatusText(String dossierStatusText) {
		this.dossierStatusText = dossierStatusText;
	}

	public String getDossierSubStatus() {
		return dossierSubStatus;
	}

	public void setDossierSubStatus(String dossierSubStatus) {
		this.dossierSubStatus = dossierSubStatus;
	}

	public String getDossierSubStatusText() {
		return dossierSubStatusText;
	}

	public void setDossierSubStatusText(String dossierSubStatusText) {
		this.dossierSubStatusText = dossierSubStatusText;
	}

	public boolean isSameAsApplicant() {
		return isSameAsApplicant;
	}

	public void setSameAsApplicant(boolean isSameAsApplicant) {
		this.isSameAsApplicant = isSameAsApplicant;
	}

	public String getDelegateName() {
		return delegateName;
	}

	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}

	public String getDelegateIdNo() {
		return delegateIdNo;
	}

	public void setDelegateIdNo(String delegateIdNo) {
		this.delegateIdNo = delegateIdNo;
	}

	public String getDelegateTelNo() {
		return delegateTelNo;
	}

	public void setDelegateTelNo(String delegateTelNo) {
		this.delegateTelNo = delegateTelNo;
	}

	public String getDelegateEmail() {
		return delegateEmail;
	}

	public void setDelegateEmail(String delegateEmail) {
		this.delegateEmail = delegateEmail;
	}

	public String getDelegateAddress() {
		return delegateAddress;
	}

	public void setDelegateAddress(String delegateAddress) {
		this.delegateAddress = delegateAddress;
	}

	public String getDelegateCityCode() {
		return delegateCityCode;
	}

	public void setDelegateCityCode(String delegateCityCode) {
		this.delegateCityCode = delegateCityCode;
	}

	public String getDelegateDistrictCode() {
		return delegateDistrictCode;
	}

	public void setDelegateDistrictCode(String delegateDistrictCode) {
		this.delegateDistrictCode = delegateDistrictCode;
	}

	public String getDelegateWardCode() {
		return delegateWardCode;
	}

	public void setDelegateWardCode(String delegateWardCode) {
		this.delegateWardCode = delegateWardCode;
	}

	public Long getDossierActionId() {
		return dossierActionId;
	}

	public void setDossierActionId(Long dossierActionId) {
		this.dossierActionId = dossierActionId;
	} 

	public String getSubmissionNote() {
		return submissionNote;
	}

	public void setSubmissionNote(String value) {
		this.submissionNote = value;
	} 	
	
	public String getLockState() {
		return lockState;
	}

	public void setLockState(String value) {
		this.lockState = value;
	} 
	
	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer value) {
		this.counter = value;
	} 
	
	public String getPostalCityName() {
		return postalCityName;
	}

	public void setPostalCityName(String value) {
		this.postalCityName = value;
	} 
	
	public String getDelegateCityName() {
		return delegateCityName;
	}

	public void setDelegateCityName(String value) {
		this.delegateCityName = value;
	} 
	
	public String getDelegateDistrictName() {
		return delegateDistrictName;
	}

	public void setDelegateDistrictName(String value) {
		this.delegateDistrictName = value;
	} 
	
	public String getDelegateWardName() {
		return delegateWardName;
	}

	public void setDelegateWardName(String value) {
		this.delegateWardName = value;
	} 
	
	public String getProcessNo() {
		return processNo;
	}

	public void setProcessNo(String value) {
		this.processNo = value;
	}
	
	public Double getDurationCount() {
		return durationCount;
	}

	public void setDurationCount(Double value) {
		this.durationCount = value;
	}
	
	public Integer getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(Integer value) {
		this.durationUnit = value;
	}
	
	public Integer getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(Integer value) {
		this.sampleCount = value;
	}
	
	public String getDossierName() {
		return dossierName;
	}

	public void setDossierName(String value) {
		this.dossierName = value;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public void setCorrecttingDate(String correcttingDate) {
		this.correcttingDate = correcttingDate;
	}

}
