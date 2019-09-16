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
			obj.put("result", "�̹� �����ϴ� �̸����Դϴ�.");
			obj.put("result123", "��� ������ �̸��� �Դϴ�.");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}
