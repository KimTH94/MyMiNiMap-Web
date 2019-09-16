package Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Followers.FollowersDAO;
import Priceandrecommends.PriceandrecommendsDAO;

@WebServlet("/Filter1")
public class Filter1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Filter1() {
        super();
    }

    @SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String Menu = request.getParameter("Menu");
		String Taste = request.getParameter("Taste");
		String Price1 = request.getParameter("Price1");
		String Price2 = request.getParameter("Price2");
		String[] P_FoodList = request.getParameterValues("FoodList[]");
		String[] P_Colleague = request.getParameterValues("Colleague[]");
		String[] P_SaveList = request.getParameterValues("SaveList[]");
		String Follow = request.getParameter("Follow"); // true | false

		String FoodList = "0,";
		String Colleague = "0,";
		String SaveList = "0,";
		if(P_SaveList == null) {
			System.out.println("SaveList : " + SaveList);
		}else if(P_SaveList != null) {
			for(int i = 0 ; i < P_SaveList.length; i++) {
				if(i == 0 && P_SaveList.length == 1) {
					SaveList = P_SaveList[i];
				}else if(i == 0 && P_SaveList.length != 1) {
					SaveList = P_SaveList[i] + ",";
				}else if(i != 0) {
					if(i != P_SaveList.length -1) {
						SaveList += P_SaveList[i] + ",";
					}else if(i == P_SaveList.length -1) {
						SaveList += P_SaveList[i];
					}
				}
			}
		}
		
		if(P_FoodList == null && P_Colleague == null) {
			System.out.println("FoodList : " + FoodList);
			System.out.println("Colleague : " + Colleague);
		}else if(P_FoodList != null && P_Colleague == null) {
			for(int i = 0 ; i < P_FoodList.length; i++) {
				if(i == 0 && P_FoodList.length == 1) {
					FoodList = P_FoodList[i];
				}else if(i == 0 && P_FoodList.length != 1) {
					FoodList = P_FoodList[i] + ",";
				}else if(i != 0) {
					if(i != P_FoodList.length -1) {
						FoodList += P_FoodList[i] + ",";
					}else if(i == P_FoodList.length -1) {
						FoodList += P_FoodList[i];
					}
				}
			}
			System.out.println("FoodList : " + FoodList);
			System.out.println("Colleague : Null");
		}else if(P_FoodList == null && P_Colleague != null) {
			for(int i = 0 ; i < P_Colleague.length; i++) {
				if(i == 0 && P_Colleague.length == 1) {
					Colleague = P_Colleague[i];
				}else if(i == 0 && P_Colleague.length != 1) {
					Colleague = P_Colleague[i] + ",";
				}else if(i != 0) {
					if(i != P_Colleague.length -1) {
						Colleague += P_Colleague[i] + ",";
					}else if(i == P_Colleague.length -1) {
						Colleague += P_Colleague[i];
					}
				}
			}
			System.out.println("FoodList : Null");
			System.out.println("Colleague : " + Colleague);
		}else if(P_FoodList != null && P_Colleague != null) {
			for(int i = 0 ; i < P_FoodList.length; i++) {
				if(i == 0 && P_FoodList.length == 1) {
					FoodList = P_FoodList[i];
				}else if(i == 0 && P_FoodList.length != 1) {
					FoodList = P_FoodList[i] + ",";
				}else if(i != 0) {
					if(i != P_FoodList.length -1) {
						FoodList += P_FoodList[i] + ",";
					}else if(i == P_FoodList.length -1) {
						FoodList += P_FoodList[i];
					}
				}
			}
			for(int i = 0 ; i < P_Colleague.length; i++) {
				if(i == 0 && P_Colleague.length == 1) {
					Colleague = P_Colleague[i];
				}else if(i == 0 && P_Colleague.length != 1) {
					Colleague = P_Colleague[i] + ",";
				}else if(i != 0) {
					if(i != P_Colleague.length -1) {
						Colleague += P_Colleague[i] + ",";
					}else if(i == P_Colleague.length -1) {
						Colleague += P_Colleague[i];
					}
				}
			}
			System.out.println("FoodList : " + FoodList);
			System.out.println("Colleague : " + Colleague);
		}
		System.out.println("SaveList : " + SaveList);
		
		StringTokenizer Mn = new StringTokenizer(Menu, ",");
		String[] F_Menu = new String[Mn.countTokens()];
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int a4 = 0;
		while(Mn.hasMoreTokens()) {
			F_Menu[a1] = Mn.nextToken();
			a1++;
		}
		
		StringTokenizer FL = new StringTokenizer(FoodList, ",");
		String[] F_FoodList = new String[FL.countTokens()];
		while(FL.hasMoreTokens()) {
			F_FoodList[a2] = FL.nextToken();
			a2++;
		}
		
		StringTokenizer C = new StringTokenizer(Colleague, ",");
		String[] F_Colleague = new String[C.countTokens()];
		while(C.hasMoreTokens()) {
			F_Colleague[a3] = C.nextToken();
			a3++;
		}
		
		StringTokenizer S = new StringTokenizer(SaveList, ",");
		String[] F_SaveList = new String[S.countTokens()];
		while(S.hasMoreTokens()) {
			F_SaveList[a4] = S.nextToken();
			a4++;
		}
		
		ArrayList<String> F_RecommendMenus = new ArrayList<String>();
		ArrayList<String> F_Tags = new ArrayList<String>();
		
		for(int i =0 ; i < F_Menu.length ; i++) {
			System.out.println("F_Menu[i] : " + F_Menu[i]);
			try {
				if(FilterDAO.CountMenu(F_Menu[i]) >= FilterDAO.CountTag(F_Menu[i])) {
					F_RecommendMenus.add(F_Menu[i]);
				}else if(FilterDAO.CountMenu(F_Menu[i]) < FilterDAO.CountTag(F_Menu[i])) {
					F_Tags.add(F_Menu[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 1�ܰ� ����(�޴�, �±�) ����
		System.out.println("1�ܰ� ����(�޴�, �±�) ����");
		System.out.println("Menus : " + F_RecommendMenus + " MenusList.Size : " + F_RecommendMenus.size());
		System.out.println("Tags : " + F_Tags + " TagsList.Size : " + F_Tags.size());
		ArrayList<String> PlaceId = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		if(F_RecommendMenus.size() == 0 && F_Tags.size() ==0) {
				System.out.println("1�ܰ� ���� ���� ���� ����");
				try {
					temp = FilterDAO.AddallRestaurants();
				} catch (Exception e) {
					e.printStackTrace();
				}
				PlaceId.addAll(temp);
				temp.clear();
		}else {
			if(F_RecommendMenus.isEmpty() == true && F_Tags.isEmpty() == false) {	// �޴� X �±� O => �±׸� ����
				System.out.println("1�ܰ� ���� �±� ����");
				for(int i = 0 ; i < F_Tags.size() ; i++) {
					try {
						temp = FilterDAO.getIdByTag(F_Tags.get(i));
						PlaceId.addAll(temp);
						temp.clear();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}/*else if(F_RecommendMenus.isEmpty() == true && F_Tags.isEmpty() == true) { // �޴� X �±� X => �Ѿ
				try {
					temp = FilterDAO.getId();
					PlaceId.addAll(temp);
					temp.clear();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}*/else if(F_RecommendMenus.isEmpty() == false && F_Tags.isEmpty() == false) { // �޴� O, �±� O => �޴� ���� �� �±� ����
				System.out.println("1�ܰ� ���� �޴�, �±� ����");
				try {
					for(int i = 0 ; i < F_RecommendMenus.size(); i++) {
						temp = FilterDAO.getIdByMenu(F_Tags.get(i));
						PlaceId.addAll(temp);
						temp.clear();
					}
					for(int j = 0 ; j < F_Tags.size(); j++) {
					  	temp = FilterDAO.getIdByTag(F_Tags.get(j));
					  	PlaceId.addAll(temp);
					  	temp.clear();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if(F_RecommendMenus.isEmpty() == false && F_Tags.isEmpty() == true) { // �޴�O, �±� X => �޴��� ����
				System.out.println("1�ܰ� ���� �޴� ����");
				for(int i = 0 ; i < F_RecommendMenus.size() ; i++) {
					try {
						temp = FilterDAO.getIdByMenu(F_RecommendMenus.get(i));
						PlaceId.addAll(temp);
						temp.clear();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		System.out.println("1�ܰ� ����(�޴�, �±�) ������ PlaceIdList ���");
		System.out.println("PlaceId.size() : " + PlaceId.size());
		for(int i = 0 ; i < PlaceId.size(); i++) {
			System.out.println("PlaceId("+i+")"+PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("1�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		
		// 1�ܰ� ����(�޴�, �±�) ��, 2�ܰ� ����(����) ����
		System.out.println("2�ܰ� ����(����) ���� ����");
		for(int i = 0 ; i < F_Colleague.length; i ++) {
			System.out.println("F_Colleague : " + F_Colleague[i]);
		}
		
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			String ColleagueTemp = null;
			try {
				ColleagueTemp = FilterDAO.getColleague(PlaceId.get(i));
				System.out.println("ColleageueTemp : " + ColleagueTemp);
				String[] ColleageueArray  = ColleagueTemp.split("/");
				int count = 0;
				try {
					for(int j = 0 ; j < F_Colleague.length ; j++) {
						if(ColleageueArray[0].contains(F_Colleague[j])) {
							System.out.println("ColleagueArray[0] : " + ColleageueArray[0]);
							System.out.println("���� üũ");
							count++;
						}
					}
					if(count > 0) {
						temp.add(PlaceId.get(i));
						count = 0;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("2�ܰ� ����(����) ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("2�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		
		//2�ܰ� ����(����) ��, 3�ܰ� ����(���� ����) ����
		System.out.println("3�ܰ� ����(���� ����) ���� ����");
		for(int i = 0 ; i < F_FoodList.length ; i++) {
			System.out.println("F_FoodList[" + i + "] : " + F_FoodList[i]);
		}

		for(int i = 0 ; i < PlaceId.size() ; i++) {
			String FoodTemp = null;
			try {
				FoodTemp = FilterDAO.getFoodType(PlaceId.get(i));
				System.out.println(PlaceId.get(i) + "�� FoodTemp : " + FoodTemp);
				String[] FoodArray  = FoodTemp.split("/");
				int count = 0;
				try {
					for(int j = 0 ; j < F_FoodList.length ; j++) {
						if(FoodArray[0].contains(F_FoodList[j])) {
							System.out.println("���� ���� üũ");
							count++;
						}
					}
					if(count > 0) {
						temp.add(PlaceId.get(i));
						count = 0;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("3�ܰ� ���� ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("3�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		
		//3�ܰ� ����(���� ����) ��, 4�ܰ� ����(���� ����) ����
		System.out.println("4�ܰ� ����(���� ����) ���� ����");
		System.out.println("F_SaveList.length : " + F_SaveList.length);
		for(int i = 0 ; i < F_SaveList.length ; i++) {
			System.out.println("F_SaveList["+ i + "] : " + F_SaveList[i]);
		}
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			String SaveTemp = null;
			try {
				SaveTemp = FilterDAO.getFoodType(PlaceId.get(i));
				System.out.println("SaveTemp : " + SaveTemp);
				String[] SaveArray  = SaveTemp.split("/");
				int count = 0;
				try {
					for(int j = 0 ; j < F_SaveList.length ; j++) {
						if(SaveArray[0].contains(F_SaveList[j])) {
							System.out.println("���� ���� üũ");
							count++;
						}
					}
					if(count > 0) {
						temp.add(PlaceId.get(i));
						count = 0;
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("4�ܰ� ���� ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("4�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		
		System.out.println("5�ܰ� ����(����) ���� ����");
		System.out.println(Price1);
		//4�ܰ� ����(���� ����) ��, 5�ܰ� ����(����) ����
		int F_Price1 = Integer.parseInt(Price1);
		System.out.println(F_Price1);
		if(F_Price1 == 0) {
			F_Price1++;
		}
		int F_Price2 = Integer.parseInt(Price2);
		
		System.out.println("F_Price1 : " + F_Price1);
		System.out.println("F_Price2 : " + F_Price2);
		int PriceCount = 0;
		if(F_Price1 == 1 && F_Price2 == 1) {
			for(int i = 0 ; i < PlaceId.size() ; i++) {
				
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					if(PriceCount == 0) {
						if(PriceResult.contains("1")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 1 && F_Price2 == 2) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					if(PriceCount == 0) {
						if(PriceResult.contains("1")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 1 && F_Price2 == 3) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					if(PriceCount == 0) {
						if(PriceResult.contains("1")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 1 && F_Price2 == 4) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					if(PriceCount == 0) {
						if(PriceResult.contains("1")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 1 && F_Price2 == 5) {
			/*for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("1")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("5")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					temp.addAll(PlaceId);
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
			temp.addAll(PlaceId);
		}else if(F_Price1 == 2 && F_Price2 == 2) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 2 && F_Price2 == 3) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 2 && F_Price2 == 4) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 2 && F_Price2 == 5) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("2")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("5")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 3 && F_Price2 == 3) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 3 && F_Price2 == 4) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 3 && F_Price2 == 5) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("3")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("5")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 4 && F_Price2 == 4) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 4 && F_Price2 == 5) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult);
					if(PriceCount == 0) {
						if(PriceResult.contains("4")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					if(PriceCount == 0) {
						if(PriceResult.contains("5")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(F_Price1 == 5 && F_Price2 == 5) {
			for(int i = 0 ; i < PlaceId.size() ; i ++) {
				String PriceResult;
				try {
					PriceResult = PriceandrecommendsDAO.getPrice(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� PriceResult : " + PriceResult); 
					if(PriceCount == 0) {
						if(PriceResult.contains("5")) {
							temp.add(PlaceId.get(i));
							PriceCount++;
						}
					}
					PriceCount = 0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("5�ܰ� ���� ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("5�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		//5�ܰ� ����(����) ��, 6�ܰ� ����(��õ) ����
		System.out.println("6�ܰ� ����(��õ) ���� ����");
		int F_Taste = Integer.parseInt(Taste);
		System.out.println("Taste : " + F_Taste);
		if(F_Taste == 0) {
			temp.addAll(PlaceId);
		}else if(F_Taste >= 1) {
			for(int i = 0 ; i < PlaceId.size() ; i++) {
				try {
					double result = PriceandrecommendsDAO.getRecommend(PlaceId.get(i));
					System.out.println(PlaceId.get(i) + "�� �򰡴� : " + result);
					if(result >= F_Taste * 10) {
						temp.add(PlaceId.get(i));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("6�ܰ� ���� ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("6�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
		//6�ܰ� ����(��õ) ��, 7�ܰ� ����(�ȷο�) ����
		System.out.println("7�ܰ� ����(�ȷο�) ���� ����");
		if(Follow.equals("false")) {
			temp.addAll(PlaceId);
		}else {
			System.out.println("�ȷξ� üũ o");
			ArrayList<String> FollowerList = new ArrayList<String>();
			try {
				FollowerList = FollowersDAO.getFollow(4);
				for(int i = 0 ; i < FollowerList.size() ; i ++) {
					System.out.println(FollowerList.get(i));
				}
				for(int i = 0 ; i < PlaceId.size() ; i++) {
					System.out.println("PlaceIdList�� " + i + "��° ID : " + PlaceId.get(i));
					/*for(int j = 0 ; j < FollowerList.size() ; j++) {
						System.out.println("followerList�� " + j + "��° ID : " + FollowerList.get(i));
						if(PlaceId.get(i) == Folo)
					}*/
					if(FollowerList.contains(PlaceId.get(i))){
						temp.add(PlaceId.get(i));
					}else {
						System.out.println(PlaceId.get(i) + "�� FollowerList�� �����ϴ�!");
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		PlaceId.clear();
		PlaceId.addAll(temp);
		temp.clear();
		
		System.out.println("7�ܰ� ���� ������ PlaceIdList ���");
		for(int i = 0 ; i < PlaceId.size() ; i++) {
			System.out.println(PlaceId.get(i));
			if(i == (PlaceId.size()-1)) {
				System.out.println("7�ܰ� ���� �� ���� ������ ���� : " + PlaceId.size());
			}
		}
				
		// AJAX���� �޾ƿ� �� ���� ��.
		JSONObject obj = new JSONObject();
		
		try {
			ArrayList<String> list = FilterDAO.getLocation();
			request.setAttribute("list", list);
			obj.put("a", list);
			obj.put("size", PlaceId.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}
}