package com.oracle.cc.model;

/**
 * @author Chiranjeevi Sutraye
 * This class holds the attributes for Customer type data.
 */
public class Customer extends BaseObject {

	private static final long serialVersionUID = 1L;
	
	private String contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private String buildDuration;
	
	public Customer() {	
	}
	
	public Customer(String customerId,String name, String shortDescription) {
		super(customerId, name, shortDescription);
	}
	
	public Customer(String customerId) {
		super(customerId);
	}

	public String getCustomerId() {
		return _id;
	}

	public void setCustomerId(String customerId) {
		super._id = customerId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getGeozone() {
		return geozone;
	}

	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getBuildDuration() {
		return buildDuration;
	}

	public void setBuildDuration(String buildDuration) {
		this.buildDuration = buildDuration;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + _id + ", contractId=" + contractId + ", geozone=" + geozone
				+ ", teamcode=" + teamcode + ", projectcode=" + projectcode + ", buildDuration=" + buildDuration + "]";
	}
	
	

}
