package com.coolweather.app.util;

import java.util.Iterator;

import android.text.TextUtils;
import android.util.Log;

import com.coolweather.app.db.CoolweatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/**
 * 对XML格式数据进行处理
 * @author DarkFire
 *
 */
public class Utility {
	static String TAG = "Utility";
	/**
	 * 解析处理服务器返回的省份数据
	 */
	public synchronized static boolean handleProvincesResponse(CoolweatherDB coolweatherDB, String response){
		if (!TextUtils.isEmpty(response)) {
			Log.d("utility response", response);
			String[] allProvinces = response.split(",");
			if (allProvinces !=null && allProvinces.length >0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					coolweatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 解析处理服务器返回的城市数据
	 */
	public synchronized static boolean handCitiesResponse(CoolweatherDB coolweatherDB, String response, int provinceId){
		if (!TextUtils.isEmpty(response)) {
			Log.d("Utility response", response);
			String[] allCities = response.split(",");
			if (allCities!=null && allCities.length >0) {
				for (String c : allCities) {
					String[] array = c.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setId(provinceId);
					coolweatherDB.saveCity(city);
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 解析处理服务器返回的县数据
	 */
	public synchronized static boolean handCountiesResponse(CoolweatherDB coolweatherDB, String response, int cityId){
		if (!TextUtils.isEmpty(response)) {
			String[]allCounties = response.split(",");
			Log.d("utility response", response);
			if (allCounties!=null && allCounties.length>0) {
				for (String c : allCounties) {
					String[]array = c.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					coolweatherDB.saveCounty(county);
				}			
			}
			return true;
		}
	return false;	
	}
}