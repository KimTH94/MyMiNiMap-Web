package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/Timeline")
public class Timeline extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Timeline() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("연결");
		System.out.println("연결");
		String SEQ_User = request.getParameter("SEQ_User");
		int sequserint = Integer.parseInt(SEQ_User);
		System.out.println(SEQ_User);
		String nickname = null;
		
		int Count = 0;
		JSONObject result = new JSONObject();
		JSONArray jarryt1 = new JSONArray();
		JSONArray jarryt2 = new JSONArray();
		ArrayList<String> Followings = new ArrayList<String>();
		ArrayList<String> timeline = new ArrayList<String>();
		JSONObject result2 = new JSONObject();

		try {
			jarryt1 = PlacesDAO.followingtimeline(sequserint);

			
		} catch(Exception e) {
			e.printStackTrace();
		}
//		try {
//			Followings = MemDAO.followings(sequserint);
//			System.out.println(Followings);
//			timeline.addAll(Followings);
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			Count = MemDAO.Count_Following(sequserint);
//			System.out.println(Count);
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			ArrayList<String> list = PlacesDAO.Timeline(SEQ_User);
//			System.out.println("list = "+list);
//			//timeline.addAll(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			result.put("postId", jarryt1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);

		System.out.println("result : "+result);
	}
}
