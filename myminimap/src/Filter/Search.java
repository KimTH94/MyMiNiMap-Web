package Filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("word");
		String S_param1 = request.getParameter("param1");
		String S_param2 = request.getParameter("param2");
		String S_param3 = request.getParameter("param3");
		
		int param1 = Integer.parseInt(S_param1);
		int param2 = Integer.parseInt(S_param2);
		int param3 = Integer.parseInt(S_param3);

		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(param1 == 1 && param2 == 0 && param3 == 0) {
			try {
				ArrayList<FilterDTO> filterList = FilterDAO.SearchRestaurant(word);
				for(FilterDTO filter : filterList) {
					out.println("<li class=\"l-g-item\">");
					out.print(filter.getName());
					out.println("</li>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(param1 == 0 && param2 == 1 && param3 == 0) {
			try {
				ArrayList<FilterDTO> filterList = FilterDAO.SearchRecommendMenu(word);
				for(FilterDTO filter : filterList) {
					out.println("<li class=\"l-g-item\">");
					out.print(filter.getMenu());
					out.println("</li>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(param1 ==0 && param2 == 0 && param3 == 1) {
			try {
				ArrayList<FilterDTO> filterList = FilterDAO.SearchTag(word);
				for(FilterDTO filter : filterList) {
					out.println("<li class=\"l-g-item\">");
					out.print(filter.getTag());
					out.println("</li>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
