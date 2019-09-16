package Comments;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/reRecommentGetNickname")
public class reRecommentGetNickname extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public reRecommentGetNickname() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dusr");
		String Comment = request.getParameter("Comments");
		int SEQ_Comment = 0;
		int test = 0;
		JSONObject obj = new JSONObject();
		try {
			test = CommentsDAO.getSEQ_CommentByComments(Comment);
			obj.put("SEQ_No", test);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(obj);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
	}

}
