package bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/CheckEmail")
public class CheckEmail extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CheckEmail() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		JSONObject obj = new JSONObject();
		int result = 0;
		try {
			result = MemDAO.ChEmail(email);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			obj.put("a", result);
			obj.put("result", "이미 존재하는 이메일입니다.");
			obj.put("result123", "사용 가능한 이메일 입니다.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}
