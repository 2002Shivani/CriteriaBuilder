package com.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class DistrictDetails {

	// Fields
	@Id
	private int districtId;
	private String districtName;
	private int districtPopulation;
	private String districtIASName;
	private int districtPinCode;
	private String distictState;

	// No-Argument Constructor
	public DistrictDetails() {

	}

	// Argument Constructor
	public DistrictDetails(int districtId, String districtName, int districtPopulation, String districtIASName,
			int districtPinCode, String distictState) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
		this.districtPopulation = districtPopulation;
		this.districtIASName = districtIASName;
		this.districtPinCode = districtPinCode;
		this.distictState = distictState;
	}

	// Getter and Setter
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getDistrictPopulation() {
		return districtPopulation;
	}

	public void setDistrictPopulation(int districtPopulation) {
		this.districtPopulation = districtPopulation;
	}

	public String getDistrictIASName() {
		return districtIASName;
	}

	public void setDistrictIASName(String districtIASName) {
		this.districtIASName = districtIASName;
	}

	public int getDistrictPinCode() {
		return districtPinCode;
	}

	public void setDistrictPinCode(int districtPinCode) {
		this.districtPinCode = districtPinCode;
	}

	public String getDistictState() {
		return distictState;
	}

	public void setDistictState(String distictState) {
		this.distictState = distictState;
	}

	// toString
	@Override
	public String toString() {
		return "DistrictDetails [districtId=" + districtId + ", districtName=" + districtName + ", districtPopulation="
				+ districtPopulation + ", districtIASName=" + districtIASName + ", districtPinCode=" + districtPinCode
				+ ", distictState=" + distictState + "]";
	}

}
