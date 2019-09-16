package Comments;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ReCommentGetNickname")
public class ReCommentGetNickname extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ReCommentGetNickname() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String S_SEQ_Comment = request.getParameter("SEQ_Comment");
		double SEQ_Comment = Integer.parseInt(S_SEQ_Comment);
		String Nickname = null;
		JSONObject obj = new JSONObject();
		try {
			Nickname = "@" + CommentsDAO.getNicknameBySEQ_Comment(SEQ_Comment) + '\t';
			obj.put("ReCommetGetNickname", Nickname);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
	}

}
