package com.ltsk.whcg.entity;

public class MuckTrace {

	private Double gdx ;
	private Double gdy;
	
	
	public Double getGdx() {
		return gdx;
	}


	public void setGdx(Double gdx) {
		this.gdx = gdx;
	}


	public Double getGdy() {
		return gdy;
	}


	public void setGdy(Double gdy) {
		this.gdy = gdy;
	}


	@Override
	public String toString() {
		return "MuckTrace [gdx=" + gdx + ", gdy=" + gdy + "]";
	}
	
	
}
