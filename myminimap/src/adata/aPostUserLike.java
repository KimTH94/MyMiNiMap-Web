package adata;

public class aPostUserLike {
    public Double SEQ_Post,SEQ_User;
    public String Like_DAY;

    public Double getSEQ_Post() {
        return SEQ_Post;
    }

    public void setSEQ_Post(Double SEQ_Post) {
        this.SEQ_Post = SEQ_Post;
    }

    public Double getSEQ_User() {
        return SEQ_User;
    }

    public void setSEQ_User(Double SEQ_User) {
        this.SEQ_User = SEQ_User;
    }

    public String getLike_DAY() {
        return Like_DAY;
    }

    public void setLike_DAY(String like_DAY) {
        Like_DAY = like_DAY;
    }

    public aPostUserLike(Double SEQ_Post, Double SEQ_User, String like_DAY) {
        this.SEQ_Post = SEQ_Post;
        this.SEQ_User = SEQ_User;
        Like_DAY = like_DAY;
    }
}
