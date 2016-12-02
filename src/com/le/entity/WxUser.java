
package com.le.entity;

import com.le.util.DateUtil;

import net.sf.json.JSONObject;

// Generated 2016-11-30 16:16:22 by Hibernate Tools 3.5.0.Final

/**
 * WxUser generated by hbm2java
 */
public class WxUser implements java.io.Serializable {

	private String openId;
	private String nickname;
	private Integer sex;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private String subscribeTime;
	private String mobile;
	private String loginTime;
	private String lastLoginMobile;
	private String lastLoginTime;

	public WxUser() {
	}

	public WxUser(String openId) {
		this.openId = openId;
	}

	public WxUser(String openId, String nickname, Integer sex, String city, String country, String province,
			String language, String headimgurl, String subscribeTime, String mobile, String loginTime,
			String lastLoginMobile, String lastLoginTime) {
		this.openId = openId;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribeTime = subscribeTime;
		this.mobile = mobile;
		this.loginTime = loginTime;
		this.lastLoginMobile = lastLoginMobile;
		this.lastLoginTime = lastLoginTime;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadimgurl() {
		return this.headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLastLoginMobile() {
		return this.lastLoginMobile;
	}

	public void setLastLoginMobile(String lastLoginMobile) {
		this.lastLoginMobile = lastLoginMobile;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	 private NumberOfSubscriptions nos;

	public NumberOfSubscriptions getNos() {
		return nos;
	}

	public void setNos(NumberOfSubscriptions nos) {
		this.nos = nos;
	}
	
	public WxUser(JSONObject jo){
		this.nickname=(String) jo.get("nickname");
		this.country=(String) jo.get("country");
		this.headimgurl=(String) jo.get("headimgurl");
		this.language=(String) jo.get("language");
		this.city=(String) jo.get("city");
		this.openId=(String) jo.get("openid");
		this.province=(String) jo.get("province");
		System.out.println("sex is "+jo.get("sex"));
		this.sex=Integer.parseInt(jo.get("sex").toString());
		this.subscribeTime=DateUtil.TimeStampDate(jo.get("subscribe_time").toString(), "yyyy-MM-dd hh:mm:ss");
	}
	
	
}
