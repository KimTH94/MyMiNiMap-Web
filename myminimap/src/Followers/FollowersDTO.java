package Followers;

public class FollowersDTO {
	private double SEQ_Follow;
	private double User_SEQ;
	private double Follower_SEQ;
	private double SEQ_User;
	private String id;
	
	public double getSEQ_Follow() {
		return SEQ_Follow;
	}
	public void setSEQ_Follow(double sEQ_Follow) {
		SEQ_Follow = sEQ_Follow;
	}
	public double getUser_SEQ() {
		return User_SEQ;
	}
	public void setUser_SEQ(double user_SEQ) {
		User_SEQ = user_SEQ;
	}
	public double getFollower_SEQ() {
		return Follower_SEQ;
	}
	public void setFollower_SEQ(double follower_SEQ) {
		Follower_SEQ = follower_SEQ;
	}
	public double getSEQ_User() {
		return SEQ_User;
	}
	public void setSEQ_User(double sEQ_User) {
		SEQ_User = sEQ_User;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
