package Comments;

public class CommentsDTO {
	
	private int SEQ_Comment;
	private int SEQ_Post;
	private int SEQ_Owner;
	private int SEQ_User;
	private String Comment;
	private int Parent;
	private int Depth;
	private int Orders;
	private int Comment_DAY;
	
	private String fileName;
	private String Nickname;
	
	public int getSEQ_Comment() {
		return SEQ_Comment;
	}
	public void setSEQ_Comment(int sEQ_Comment) {
		SEQ_Comment = sEQ_Comment;
	}
	public int getSEQ_Post() {
		return SEQ_Post;
	}
	public void setSEQ_Post(int sEQ_Post) {
		SEQ_Post = sEQ_Post;
	}
	public int getSEQ_Owner() {
		return SEQ_Owner;
	}
	public void setSEQ_Owner(int sEQ_Owner) {
		SEQ_Owner = sEQ_Owner;
	}
	public int getSEQ_User() {
		return SEQ_User;
	}
	public void setSEQ_User(int sEQ_User) {
		SEQ_User = sEQ_User;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public int getParent() {
		return Parent;
	}
	public void setParent(int parent) {
		Parent = parent;
	}
	public int getDepth() {
		return Depth;
	}
	public void setDepth(int depth) {
		Depth = depth;
	}
	public int getOrders() {
		return Orders;
	}
	public void setOrders(int orders) {
		Orders = orders;
	}
	public int getComment_DAY() {
		return Comment_DAY;
	}
	public void setComment_DAY(int comment_DAY) {
		Comment_DAY = comment_DAY;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
}
