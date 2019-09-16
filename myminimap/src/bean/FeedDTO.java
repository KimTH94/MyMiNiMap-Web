package bean;

public class FeedDTO {
	
	private int SEQ_Attachment;
	private int SEQ_Post;
	private int SEQ_User;
	private String FileName;
	
	public int getSEQ_Attachment() {
		return SEQ_Attachment;
	}
	public void setSEQ_Attachment(int sEQ_Attachment) {
		SEQ_Attachment = sEQ_Attachment;
	}
	public int getSEQ_Post() {
		return SEQ_Post;
	}
	public void setSEQ_Post(int sEQ_Post) {
		SEQ_Post = sEQ_Post;
	}
	public int getSEQ_User() {
		return SEQ_User;
	}
	public void setSEQ_User(int sEQ_User) {
		SEQ_User = sEQ_User;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
}
