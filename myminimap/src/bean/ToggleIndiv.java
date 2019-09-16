package bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ToggleIndiv")
public class ToggleIndiv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToggleIndiv() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PlaceID = request.getParameter("Id");
	
		String SEQ_User = request.getParameter("SEQ_User");
		System.out.println(PlaceID);
		System.out.println(SEQ_User);
		String Name = null;
		String Address = null;
		String Tel = null;
		String Price = null;	// %
		String Taste = null;	// %
		String Mood = null;
		String SaveType = null;	// %
		String FoodType = null;	// %
		String Colleague = null;	//%
		String Menu = null;
		String Tags = null;
		
		String c1, c2, c3, c4, c5, c6 = null;
		System.out.println(PlaceID);
		System.out.println(SEQ_User);
		int iPrice = 0;
		int iTaste = 0;
		int iFoodType = 0;
		int iSaveType = 0;
		JSONObject result = new JSONObject();
		System.out.println("연결성공");
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.PostIndiv(PlaceID,SEQ_User);
			for(PlacesDTO places : list){
				Name = places.getName();
				System.out.println(Name);
				Address = places.getAddress();
				System.out.println(Address);
				Tel = places.getTel();
				
				Price = places.getPrice();
				iPrice = Integer.parseInt(Price);
				switch (iPrice) {
				case 1: Price = "1만원 이하";
						break;
				case 2: Price = "3만원 이하";
						break;
				case 3: Price = "5만원 이하";
						break;
				case 4: Price = "7만원 이하";
						break;
				case 5: Price = "10만원 이상";
						break;
				}
				
				Taste = places.getTaste();
				iTaste = Integer.parseInt(Taste);
				switch (iTaste) {
				case 1: Taste = "긍정";
						break;
				case 2: Taste = "부정";
						break;
				default: Taste = "미정";
						break;
				}
				SaveType = places.getSaveType();
				iSaveType = Integer.parseInt(SaveType);
				switch (iTaste) {
				case 1: SaveType = "맛집";
						break;
				case 2: SaveType = "술집";
						break;
				default: SaveType = "미정";
						break;
				}
				FoodType = places.getFoodType();
				iFoodType = Integer.parseInt(FoodType);
				switch (iFoodType) {
				case 1: FoodType = "한식";
						break;
				case 2: FoodType = "중식";
						break;
				case 3: FoodType = "일식";
						break;
				case 4: FoodType = "양식";
						break;
				case 5: FoodType = "동남아";
						break;
				case 6: FoodType = "야식";
						break;
				case 7: FoodType = "분식";
						break;
				default: FoodType = "미정";
						break;
				}
				Colleague = places.getColleague();
				Colleague = Colleague.replaceAll(",", "");
				int iColl = Integer.parseInt(Colleague);
				if(iColl > 0) {
					
					Colleague = Colleague.replaceAll("0", "혼자  ");
					Colleague = Colleague.replaceAll("1", "친구  ");
					Colleague = Colleague.replaceAll("2", "연인  ");
					Colleague = Colleague.replaceAll("3", "회식  ");
					Colleague = Colleague.replaceAll("4", "비즈니스  ");
					Colleague = Colleague.replaceAll("5", "가족  ");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			ArrayList<PlacesDTO> list = PlacesDAO.getMenuIndiv(PlaceID, SEQ_User);
			
			for(PlacesDTO places : list){
				Menu = places.getMenu();
			}
			System.out.println("메뉴"+Menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			ArrayList<PlacesDTO> list = PlacesDAO.getTagIndiv(PlaceID, SEQ_User);
			
			for(PlacesDTO places : list){
				Tags = places.getTags();
			}
			System.out.println("태그"+Tags);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			result.put("Name", Name);
			result.put("Address", Address);
			result.put("Tel", Tel);
			result.put("Price", Price);
			result.put("Taste", Taste);
			//result.put("Mood", Mood);
			result.put("SaveType", SaveType);
			System.out.println(FoodType);
			result.put("FoodType", FoodType);
			result.put("Colleague", Colleague);
			result.put("Menu", Menu);
			result.put("Tags", Tags);
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("연결성공2");
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);
	}

}
