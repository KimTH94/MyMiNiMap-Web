package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/whoPost")
public class whoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public whoPost() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("¿¬°á");
		String PlaceID = request.getParameter("Id");
		System.out.println(PlaceID);
		String nickname = null;
		JSONObject result = new JSONObject();
		ArrayList<String> whopost = new ArrayList<String>();
		
		
		try {
			
			ArrayList<String> list = PlacesDAO.getPoster1(PlaceID);
			
			System.out.println("list = "+list);
			/* for(PlacesDTO places : list) {
				nickname = places.getNickname();
				System.out.println("123123123");
				System.out.println(nickname);
			}*/
			
			whopost.addAll(list);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			result.put("a123", whopost);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);
		
		System.out.println(whopost);
		System.out.println("result : "+result);

	}

}
