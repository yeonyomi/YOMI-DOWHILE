package com.dw.dto;

public class RecommendVO {
	private String part,kind,posture;

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	
	public String getPosture() {
		return posture;
	}

	public void setPosture(String posture) {
		this.posture = posture;
	}

	@Override
	public String toString() {
		return "RecommendVO [part=" + part + ", kind=" + kind + ", posture=" + posture + "]";
	}

	

	

	
	
	
}
