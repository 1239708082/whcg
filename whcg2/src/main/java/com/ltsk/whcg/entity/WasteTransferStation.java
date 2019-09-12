/**
 * 
 */
package com.ltsk.whcg.entity;

/**
 * @author YH
 * @ClassName: WasteTransferStation 
 * @Description
 * @date 2019年7月30日 下午5:59:44 
 */
public class WasteTransferStation {

	private Integer id;
	private String name;
	private String creatTime;
	private String sjzyl = "";
	private String sjzyl2 = "";
	private String tzje = "";
	private String bz = "";
	private String GDXY;
	private String GDX;
	private String GDY;
	private String xzqh;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getSjzyl() {
		return sjzyl;
	}
	public void setSjzyl(String sjzyl) {
		this.sjzyl = sjzyl;
	}
	public String getSjzyl2() {
		return sjzyl2;
	}
	public void setSjzyl2(String sjzyl2) {
		this.sjzyl2 = sjzyl2;
	}
	public String getTzje() {
		return tzje;
	}
	public void setTzje(String tzje) {
		this.tzje = tzje;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getGDXY() {
		return GDXY;
	}
	public void setGDXY(String gDXY) {
		GDXY = gDXY;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	
	
	public String getGDX() {
		return GDX;
	}
	public void setGDX(String gDX) {
		GDX = gDX;
	}
	public String getGDY() {
		return GDY;
	}
	public void setGDY(String gDY) {
		GDY = gDY;
	}
	@Override
	public String toString() {
		return "WasteTransferStation [id=" + id + ", name=" + name + ", creatTime=" + creatTime + ", sjzyl=" + sjzyl
				+ ", sjzyl2=" + sjzyl2 + ", tzje=" + tzje + ", bz=" + bz + ", GDXY=" + GDXY + ", GDX=" + GDX + ", GDY="
				+ GDY + ", xzqh=" + xzqh + "]";
	}

	
}
