package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/getTimelineDatas")
public class getTimelineDatas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public getTimelineDatas() {
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
//		JSONArray jarryt1 = new JSONArray();
		JSONArray jarryt2 = new JSONArray();
		JSONArray jarryt3 = new JSONArray();
		ArrayList<String> Followings = new ArrayList<String>();
		ArrayList<String> timeline = new ArrayList<String>();
		
//		ArrayList<String> timeline2 = new ArrayList<String>();
		JSONObject result2 = new JSONObject();
	

		try {
			timeline = PlacesDAO.getData1(sequserint);
			System.out.println(timeline);
			for(int i=0; i<timeline.size();i++) {
				String path = "./imageupload/";

				JSONArray jarryt1 = new JSONArray();
				ArrayList<String> timeline2 = new ArrayList<String>();
				timeline2 = PlacesDAO.getData2(timeline.get(i));
				jarryt1.put(timeline2);
				String pics = null;
				System.out.println("이미지경로");			
				ArrayList<FeedDTO> list123 = FeedDAO.ShowPhotoTimeline(timeline.get(i));
				int size = list123.size();
				for(FeedDTO feed1 : list123){
				pics = path + feed1.getFileName();
				}
				jarryt1.put(pics);
				ArrayList<String> timeline3 = new ArrayList<String>();
				timeline3 = PlacesDAO.getData3(timeline.get(i));
				jarryt1.put(timeline3);
				jarryt3 = PlacesDAO.getData4(timeline.get(i));
				jarryt1.put(jarryt3);
				System.out.println(jarryt1);
				jarryt2.put(jarryt1);				
			}		
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
			result.put("postId", jarryt2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);

		System.out.println("result : "+result);
	}
}
