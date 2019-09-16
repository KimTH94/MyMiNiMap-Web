package ProfilePhoto;

public class MemDTO {
	
	private String email;
	private boolean emailChecked;
	private String name;
	private String nickname;
	private String birthday;
	private String tel;
	private String address;
	private String nation;	
	private String Password;
	private String profile_imformation;
	private String filename;
	private String filepath;
	private String json;

	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getProfile_imformation() {
		return profile_imformation;
	}
	public void setProfile_imformation(String profile_imformation) {
		this.profile_imformation = profile_imformation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEmailChecked() {
		return emailChecked;
	}
	public void setEmailChecked(boolean emailChecked) {
		this.emailChecked = emailChecked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPassword() {
		return Password;
	}
	/*public void setPassword(String Password) {
		this.Password = SHA256.Encrypt(Password);
	}*/
	public void setPassword(String Password) {
		this.Password = Password;
	}

}
