package com.cidx.rest.dto;

import java.util.Date;

import com.cidx.db.dto.OptOutDto;
import com.cidx.db.dto.OptOutDto.Builder;
import com.cidx.users.CidxUser;

public class CidxOptOutJson extends CidxUser {
	private String city ;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private String idNumber;
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	private String gender ; 
	private String streetAddress ; 
	private String apartmentAddress ; 
	private String state ; 
	private String dob ; 
	private String healthPlan ; 
	private String altPhoneNumber ; 
	private String groupNumber;
	private String groupId;
	private String middleName;
	private String firstNamePersonCompletingForm;
	private String lastNamePersonCompletingForm;
	private String phoneNumberPersonCompletingForm;
	private String relationshipPersonCompletingForm;
	private String previousFirstName;
	private String previousLastName;
	private String identificationNumber;
	private String otherHealthPlanName;
	private String healthPlanName;
	private String alternatePhoneNumber;
	private String subscriberId;
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFirstNamePersonCompletingForm() {
		return firstNamePersonCompletingForm;
	}
	public void setFirstNamePersonCompletingForm(
			String firstNamePersonCompletingForm) {
		this.firstNamePersonCompletingForm = firstNamePersonCompletingForm;
	}
	public String getLastNamePersonCompletingForm() {
		return lastNamePersonCompletingForm;
	}
	public void setLastNamePersonCompletingForm(String lastNamePersonCompletingForm) {
		this.lastNamePersonCompletingForm = lastNamePersonCompletingForm;
	}
	public String getPhoneNumberPersonCompletingForm() {
		return phoneNumberPersonCompletingForm;
	}
	public void setPhoneNumberPersonCompletingForm(
			String phoneNumberPersonCompletingForm) {
		this.phoneNumberPersonCompletingForm = phoneNumberPersonCompletingForm;
	}
	public String getRelationshipPersonCompletingForm() {
		return relationshipPersonCompletingForm;
	}
	public void setRelationshipPersonCompletingForm(
			String relationshipPersonCompletingForm) {
		this.relationshipPersonCompletingForm = relationshipPersonCompletingForm;
	}
	public String getPreviousFirstName() {
		return previousFirstName;
	}
	public void setPreviousFirstName(String previousFirstName) {
		this.previousFirstName = previousFirstName;
	}
	public String getPreviousLastName() {
		return previousLastName;
	}
	public void setPreviousLastName(String previousLastName) {
		this.previousLastName = previousLastName;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getOtherHealthPlanName() {
		return otherHealthPlanName;
	}
	public void setOtherHealthPlanName(String otherHealthPlanName) {
		this.otherHealthPlanName = otherHealthPlanName;
	}
	public String getHealthPlanName() {
		return healthPlanName;
	}
	public void setHealthPlanName(String healthPlanName) {
		this.healthPlanName = healthPlanName;
	}
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}
	public String getAltPhoneNumber() {
		return altPhoneNumber;
	}
	public void setAltPhoneNumber(String altPhoneNumber) {
		this.altPhoneNumber = altPhoneNumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	private String zipcode ; 
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getApartmentAddress() {
		return apartmentAddress;
	}
	public void setApartmentAddress(String apartmentAddress) {
		this.apartmentAddress = apartmentAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getHealthPlan() {
		return healthPlan;
	}
	public void setHealthPlan(String healthPlan) {
		this.healthPlan = healthPlan;
	}
	
	public OptOutDto getOptOutDto() {
		Builder optOut = new OptOutDto.Builder();
		optOut.withCreatedTimestamp(new Date());
		if (null!=getAltPhoneNumber() && !getAltPhoneNumber().isEmpty()) {
			optOut.withAlternatePhoneNumber(getAltPhoneNumber());
		}
		if (null!=getApartmentAddress() && !getApartmentAddress().isEmpty()) {
			optOut.withApartmentNumber(getApartmentAddress());
		}
		if (null!=getCity() && !getCity().isEmpty()) {
			optOut.withCity(getCity());
		}
		if (null!=getDob() && !getDob().isEmpty()) {
			optOut.withDateOfBirth(getDob());
		}
		if (null!=getEmail() && !getEmail().isEmpty()) {
			optOut.withEmail(getEmail());
		}
		if (null!=getFirstName() && !getFirstName().isEmpty()) {
			optOut.withFirstName(getFirstName());
		}
		if (null!=getGender() && !getGender().isEmpty()) {
			optOut.withGender(getGender());
		}
		if (null!= getGroupId()  && !getGroupId().isEmpty()) {
			optOut.withGroupId(getGroupId());
		}
		if (null!=getGroupNumber() && !getGroupNumber().isEmpty()) {
			optOut.withGroupNumber(getGroupNumber());
		}
		if (null!=getHealthPlan() && !getHealthPlan().isEmpty()) {
			optOut.withHealthPlanMember(getHealthPlan());
		}
		if (null!=getHealthPlanName() && !getHealthPlanName().isEmpty()) {
			optOut.withHealthPlanName(getHealthPlanName());
		}
		if (null!=getLastName() && !getLastName().isEmpty()) {
			optOut.withLastName(getLastName());
		}
		if (null!=getLastNamePersonCompletingForm() && !getLastNamePersonCompletingForm().isEmpty()) {
			optOut.withLastNameOfThePersonCompletingTheForm(getLastNamePersonCompletingForm());
		}
		if (null!=getMiddleName() && !getMiddleName().isEmpty()) {
			optOut.withMiddleName(getMiddleName());
		}
		if (null!=getOtherHealthPlanName() && !getOtherHealthPlanName().isEmpty()) {
			optOut.withOtherHealthPlanName(getOtherHealthPlanName());
		}
		if (null!=getPhoneNumber() && !getPhoneNumber().isEmpty()) {
			optOut.withPhoneNumber(getPhoneNumber());
		}
		if (null!=getPhoneNumberPersonCompletingForm() && !getPhoneNumberPersonCompletingForm().isEmpty()) {
			optOut.withPhoneNumberOfThePersonCompletingTheForm(getPhoneNumberPersonCompletingForm());
		}
		if (null!=getPreviousFirstName() && !getPreviousFirstName().isEmpty()) {
			optOut.withPreviousFirstName(getPreviousFirstName());
		}
		if (null!=getPreviousLastName() && !getPreviousLastName().isEmpty()) {
			optOut.withPreviousLastName(getPreviousLastName());
		}
		if (null!=getIdNumber() && !getIdNumber().isEmpty()) {
			optOut.withIdentificationNumber(getIdNumber());
		}
		if (null!=getZipcode() && !getZipcode().isEmpty()) {
			optOut.withZipcode(getZipcode());
		}
		if (null!=getState() && !getState().isEmpty()) {
			optOut.withState(getState());
		}
		if (null!=getSubscriberId() && !getSubscriberId().isEmpty()) {
			optOut.withSubscriberId(getSubscriberId());
		}
		if (null!=getStreetAddress() && !getStreetAddress().isEmpty()) {
			optOut.withAddress(getStreetAddress());
		}
		return optOut.build();
	}
}
