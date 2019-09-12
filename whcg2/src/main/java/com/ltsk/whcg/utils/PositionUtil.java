package com.ltsk.whcg.utils;

import com.ltsk.whcg.entity.Gps;

public class PositionUtil {
	public static final String BAIDU_LBS_TYPE = "bd09ll";
	public static double pi = 3.1415926535897932384626;
	public static double a = 6378245.0;
	public static double ee = 0.00669342162296594323;

	/**
	 * 84 to (GCJ-02) World Geodetic System ==> Mars Geodetic System
	 *
	 * @param lat
	 * @param lon
	 * @return
	 */
	// 84 to Gcj-02
	public static Gps gps84_To_Gcj02(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return null;
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	// Gcj-02 to 84
	public static Gps gcj_To_Gps84(double lat, double lon) {
		Gps gps = transform(lat, lon);
		double lontitude = lon * 2 - gps.getWgLon();
		double latitude = lat * 2 - gps.getWgLat();
		return new Gps(latitude, lontitude);
	}

	public static Gps gcj02_To_Bd09(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new Gps(bd_lat, bd_lon);
	}

	public static Gps bd09_To_Gcj02(double bd_lat, double bd_lon) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new Gps(gg_lat, gg_lon);
	}

	public static Gps bd09_To_Gps84(double bd_lat, double bd_lon) {

		Gps gcj02 = PositionUtil.bd09_To_Gcj02(bd_lat, bd_lon);
		Gps map84 = PositionUtil.gcj_To_Gps84(gcj02.getWgLat(), gcj02.getWgLon());
		return map84;

	}

	public static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	public static Gps transform(double lat, double lon) {
		if (outOfChina(lat, lon)) {
			return new Gps(lat, lon);
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Gps(mgLat, mgLon);
	}

	public static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	public static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}

	// GPS转高德
	public static double[] WGS2Mars(double wgLat, double wgLon) // y x
	{
		double[] result = new double[2];
		double mgLat = 0;
		double mgLon = 0;
		if (outofChina(wgLat, wgLon)) {
			mgLat = wgLat;
			mgLon = wgLon;
			return result;
		}
		double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
		double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
		double radLat = wgLat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		mgLat = wgLat + dLat;
		mgLon = wgLon + dLon;

		result[0] = mgLat;
		result[1] = mgLon;
		return result;
	}

	// GPS转高德 多个点
	public static double[] WGS2MarsArrs(double[] xys) {

		return null;
	}

	public static Boolean outofChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8374)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	// 经纬度转墨卡托
	public static Gps lonLat2Mercator(Gps lonLat) {
		Gps g = new Gps();
		double x = lonLat.getWgLon() * 20037508.34 / 180;
		double y = Math.log(Math.tan((90 + lonLat.getWgLat()) * Math.PI / 360)) / (Math.PI / 180);
		y = y * 20037508.34 / 180;
		g.setWgLon(x);
		g.setWgLat(y);
		return g;
	}

	// 墨卡托转经纬度
	public static Gps Mercator2lonLat(Gps mercator) {
		Gps lonLat = new Gps();
		double x = mercator.getWgLon()/ 20037508.34 * 180;
		double y = mercator.getWgLat() / 20037508.34 * 180;
		y = 180 / Math.PI * (2 * Math.atan(Math.exp(y * Math.PI / 180)) - Math.PI / 2);
		lonLat.setWgLon(x);
		lonLat.setWgLat(y);
		return lonLat;
	}

	public static void main(String[] args) {

		// 北斗芯片获取的经纬度为WGS84地理坐标 31.426896,119.496145
		// Gps gps = new Gps(30.603688,114.308189);
		// System.out.println("gps :" + gps);
		System.out.println(gps84_To_Gcj02(30.6545, 114.34));
//		System.out.println(gcj02_To_Bd09(30.65218049793857,114.34550451652915));
//		Gps g = new Gps();
//		g.setWgLon(114.34);
//		g.setWgLat(30.6545);
//		Gps lonLat2Mercator = lonLat2Mercator(g);
//		
//		System.out.println(lonLat2Mercator);
		//
		// Gps gcj = gps84_To_Gcj02(gps.getWgLat(), gps.getWgLon()); //84 to
		// Gcj-02
		// System.out.println("gcj :" + gcj);
		//
		// Gps star = gcj_To_Gps84(gcj.getWgLat(), gcj.getWgLon()); //Gcj-02 to
		// 84
		// System.out.println("star:" + star);
		//
		// Gps bd = gcj02_To_Bd09(gcj.getWgLat(), gcj.getWgLon()); //Gcj-02 to
		// bd09
		// System.out.println("bd :" + bd);

		// Gps gcj2 = bd09_To_Gcj02(gps.getWgLat(), gps.getWgLon()); //bd09 to
		// Gcj-02
		// System.out.println("gcj :" + gcj2);
	}

}
