package bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/FilteringMark")
public class FilteringMark extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public FilteringMark() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] FilterFoodTypeList = request.getParameterValues("filterFoodTypeList[]");
		String[] FilterColleagueTypeList = request.getParameterValues("filterColleagueList[]");
		
		String S_TasteValue = request.getParameter("TasteValue");
		String S_PriceValue = request.getParameter("PriceValue");
		
		int TasteValue = Integer.parseInt(S_TasteValue);
		int PriceValue = Integer.parseInt(S_PriceValue);
		
		JSONObject obj = new JSONObject();
		
		if(FilterFoodTypeList != null) {
			for(int i  = 0 ; i < FilterFoodTypeList.length ; i++) {
				System.out.println(FilterFoodTypeList[i]);
			}
		}
		
		if(FilterColleagueTypeList != null) {
			for(int i  = 0 ; i < FilterColleagueTypeList.length ; i++) {
				System.out.println(FilterColleagueTypeList[i]);	
			}
		}
		
		System.out.println(TasteValue);
		System.out.println(PriceValue);

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}
