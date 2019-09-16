package Like;

public class LikeDTO {
	
	private double SEQ_Like;
	private double SEQ_Post;
	private double SEQ_User;
	private double Post_owner;
	private double TotalLike;
	
	public double getSEQ_Like() {
		return SEQ_Like;
	}
	public void setSEQ_Like(double sEQ_Like) {
		SEQ_Like = sEQ_Like;
	}
	public double getSEQ_Post() {
		return SEQ_Post;
	}
	public void setSEQ_Post(double sEQ_Post) {
		SEQ_Post = sEQ_Post;
	}
	public double getSEQ_User() {
		return SEQ_User;
	}
	public void setSEQ_User(double sEQ_User) {
		SEQ_User = sEQ_User;
	}
	public double getPost_owner() {
		return Post_owner;
	}
	public void setPost_owner(double post_owner) {
		Post_owner = post_owner;
	}
	public double getTotalLike() {
		return TotalLike;
	}
	public void setTotalLike(double totalLike) {
		TotalLike = totalLike;
	}
}
