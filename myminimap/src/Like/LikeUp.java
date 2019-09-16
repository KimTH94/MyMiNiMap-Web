package Like;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/LikeUp")
public class LikeUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String S_SEQ_Post = request.getParameter("SEQ_Post");
		String S_SEQ_User = request.getParameter("SEQ_User");
		String S_Post_owner = request.getParameter("Post_owner");
		
		double SEQ_Post = Integer.parseInt(S_SEQ_Post);
		double SEQ_User = Integer.parseInt(S_SEQ_User); 
		double Post_owner = Integer.parseInt(S_Post_owner);
		
		String Id = null;
		JSONObject obj = new JSONObject();
		
		try {
			LikeDAO.LikeUp(SEQ_User, Post_owner, SEQ_Post);
			/*Id= LikeDAO.getRestuarantId(SEQ_Post, SEQ_User);
			LikeDAO.RestuarantLikeUp(Id);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int LikeCount = LikeDAO.CountLike(SEQ_Post, Post_owner);
			obj.put("LikeCountResult", LikeCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}
