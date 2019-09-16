package ProfilePhoto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfilePhotoDelete")
public class ProfilePhotoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ProfilePhotoDelete() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		try {
			MemDAO.DeleteProfilePhoto(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
