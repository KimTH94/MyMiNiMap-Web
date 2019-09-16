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
		System.out.println("���Ἲ��");
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
				case 1: Price = "1���� ����";
						break;
				case 2: Price = "3���� ����";
						break;
				case 3: Price = "5���� ����";
						break;
				case 4: Price = "7���� ����";
						break;
				case 5: Price = "10���� �̻�";
						break;
				}
				
				Taste = places.getTaste();
				iTaste = Integer.parseInt(Taste);
				switch (iTaste) {
				case 1: Taste = "����";
						break;
				case 2: Taste = "����";
						break;
				default: Taste = "����";
						break;
				}
				SaveType = places.getSaveType();
				iSaveType = Integer.parseInt(SaveType);
				switch (iTaste) {
				case 1: SaveType = "����";
						break;
				case 2: SaveType = "����";
						break;
				default: SaveType = "����";
						break;
				}
				FoodType = places.getFoodType();
				iFoodType = Integer.parseInt(FoodType);
				switch (iFoodType) {
				case 1: FoodType = "�ѽ�";
						break;
				case 2: FoodType = "�߽�";
						break;
				case 3: FoodType = "�Ͻ�";
						break;
				case 4: FoodType = "���";
						break;
				case 5: FoodType = "������";
						break;
				case 6: FoodType = "�߽�";
						break;
				case 7: FoodType = "�н�";
						break;
				default: FoodType = "����";
						break;
				}
				Colleague = places.getColleague();
				Colleague = Colleague.replaceAll(",", "");
				int iColl = Integer.parseInt(Colleague);
				if(iColl > 0) {
					
					Colleague = Colleague.replaceAll("0", "ȥ��  ");
					Colleague = Colleague.replaceAll("1", "ģ��  ");
					Colleague = Colleague.replaceAll("2", "����  ");
					Colleague = Colleague.replaceAll("3", "ȸ��  ");
					Colleague = Colleague.replaceAll("4", "����Ͻ�  ");
					Colleague = Colleague.replaceAll("5", "����  ");
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
			System.out.println("�޴�"+Menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			ArrayList<PlacesDTO> list = PlacesDAO.getTagIndiv(PlaceID, SEQ_User);
			
			for(PlacesDTO places : list){
				Tags = places.getTags();
			}
			System.out.println("�±�"+Tags);
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
		System.out.println("���Ἲ��2");
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);
	}

}
