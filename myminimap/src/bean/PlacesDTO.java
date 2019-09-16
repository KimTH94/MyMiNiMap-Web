package bean;

import java.net.URLDecoder;

public class PlacesDTO {
	
	private String name;
	private String address;
	private String id;
	private String val;
	private String taste;
	private String price;
	private String mood;
	private String tel;
	private String lat;
	private String lng;
	private String saveType;
	private String foodType;
	private String colleague;
	private String nickname;
	private String count; 
	private String recommendMenu;
	private String tags;
	private String menu;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = URLDecoder.decode(tags);
	}
	public String getRecommendMenu() {
		return recommendMenu;
	}
	public void setRecommendMenu(String recommendMenu) {
		this.recommendMenu = URLDecoder.decode(recommendMenu);
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = URLDecoder.decode(count);
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = URLDecoder.decode(nickname);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = URLDecoder.decode(name);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = URLDecoder.decode(address);
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String gettel() {
		return tel;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getColleague() {
		return colleague;
	}
	public void setColleague(String colleague) {
		this.colleague = colleague;
	}

}
