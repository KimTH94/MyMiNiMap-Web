package Post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public DeletePost() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String S_SEQ_Post = request.getParameter("SEQ_Post");
		double SEQ_Post = Integer.parseInt(S_SEQ_Post);
		
		try {
			PostDAO.DeleteLikeIncludePost(SEQ_Post);
			PostDAO.DeleteAttachmentIncludePost(SEQ_Post);
			PostDAO.DeleteCommentIncludePost(SEQ_Post);
			PostDAO.DeleteTagIncludePost(SEQ_Post);
			PostDAO.DeleteMenuIncludePost(SEQ_Post);
			PostDAO.DeletePost(SEQ_Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
