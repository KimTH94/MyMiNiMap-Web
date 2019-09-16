package net.codejava.upload;

import java.io.File;
import net.codejava.upload.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.mysql.cj.Session;
import Restaurants.*;
import RecommendMenus.*;
import Tags.*;
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	
	
	
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> value = new ArrayList<String>();
    ArrayList<String> fileName = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    int count = 0;
    int count_file = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	int SEQ_User = (Integer)session.getAttribute("SEQ_User");

    	request.setCharacterEncoding("UTF-8");
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        /*String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;*/
        String imageupload = "imageupload";
        String uploadPath = getServletContext().getRealPath("") + imageupload;
        /*String uploadPath = "C:\\Temp";*/
         
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (item.isFormField()) { // �뙆�씪 �씠�쇅�쓽 �젙蹂�
                    	name.add(item.getFieldName());
                    	value.add(item.getString());
                    }
                    else if(!item.isFormField()){ // �뙆�씪 �젙蹂�
                    	String RealFileName = new File(item.getName()).getName();
                    	int pos = RealFileName.lastIndexOf( "." );
                    	String extension = RealFileName.substring( pos + 1 ); // �뙆�씪 �솗�옣�옄
                    	String OnlyFileName = FilenameUtils.getBaseName(RealFileName);
                    	String RealFile = uploadPath + File.separator + RealFileName;
                    	
                    	/*System.out.println("extension : " + extension);
                    	System.out.println("RealFileName : " + RealFileName);
                    	System.out.println("RealFile : " + RealFile);
                    	System.out.println("OnlyFileName : " + OnlyFileName);*/
                    	
                    	File file = new File(RealFile);
                    	boolean isExists = file.exists();
                    	
                    	while(isExists) {
                    		Random random = new Random();
                    		OnlyFileName = OnlyFileName + random.nextInt(1000);
                    		RealFileName = OnlyFileName + "." + extension;
                    		RealFile = uploadPath + File.separator + RealFileName;
                    		File NewFile = new File(RealFileName);
                    		/*System.out.println("�뙆�씪 議댁옱");*/
                    		isExists = NewFile.exists();
                    	}
                    	/*System.out.println("�뙆�씪 議댁옱 x");*/
                    	
                    	/*System.out.println("uploadPath : " + uploadPath);
                    	System.out.println("getServletContext().getRealPath() : " +  getServletContext().getRealPath(""));
                    	System.out.println("File.separator : " + File.separator);
                    	System.out.println("UPLOAD_DIRECTORY : " + UPLOAD_DIRECTORY);
                    	String 二쇱꽍 = "getServletContext().getRealPath() : C:\\Users\\kcc94\\Desktop\\源��깭�솚\\怨듬�\\JSP-Test\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Final_Minimap\\\r\n" + 
                    				 "File.separator : \\\r\n" + 
                    				 "UPLOAD_DIRECTORY : upload";*/
                    	fileName.add(new File(item.getName()).getName());
                        list.add(RealFileName);
                        String fileName1 = new File(item.getName()).getName();
                        /*String filePath1 =  uploadPath + File.separator + fileName1;*/
                        String filePath1 =  uploadPath + File.separator + RealFileName;
                        File storeFile = new File(filePath1);
                        item.write(storeFile);             
                    }
                }
                /*System.out.println("value[0] =>  name : " + value.get(0));
                System.out.println("value[1] =>  address : " + value.get(1));
                System.out.println("value[2] =>  tel : " + value.get(2));
                System.out.println("value[3] =>  id : " + value.get(3));
                System.out.println("value[4] =>  lat : " + value.get(4));
                System.out.println("value[5] =>  lng : " + value.get(5));
                System.out.println("value[6] =>  savetype : " + value.get(6));
                System.out.println("value[7] =>  autocompletefoodtype : " + value.get(7));
                System.out.println("value[8] =>  filterTaste : " + value.get(8));
                System.out.println("value[9] =>  autocompletecolleague : " + value.get(9));
                System.out.println("value[10] =>  filterprice : " + value.get(10));
                System.out.println("value[11] =>  Menu : " + value.get(11));
                System.out.println("value[12] =>  Tag : " + value.get(12));
                */
                
                String Name = URLDecoder.decode(value.get(0));
                String Address = URLDecoder.decode(value.get(1));
                String Tel = value.get(2);
                String Id = value.get(3);
                String Colleague = "0," + value.get(9);
                double Lat = Double.parseDouble(value.get(4));
                double Lng = Double.parseDouble(value.get(5));
                int SaveType = Integer.parseInt(value.get(6));
                int FoodType = Integer.parseInt(value.get(7));
                int Taste = Integer.parseInt(value.get(8));
                int Price = Integer.parseInt(value.get(10));
                String Menu = URLDecoder.decode(value.get(11));
                String Tag = URLDecoder.decode(value.get(12));
                
                Menu = Menu.replaceAll(" ", "");
                Tag = Tag.replaceAll(" ", "");
                
                /*System.out.println("Menu : " + Menu);
                System.out.println("Tag : " + Tag);*/
                
                if(RestarantsDAO.OverlapRestarants(Id) == 0) { // �쓬�떇�젏 ���옣
                	RestarantsDAO.InsertRestarants(Name, Address, Tel, Id, Lat, Lng);
                	RestarantsDAO.InsertSaveType(Id, SaveType);
                	RestarantsDAO.InsertFoodType(Id, FoodType);
                	RestarantsDAO.InsertColleagues(Id, Colleague);
                	RestarantsDAO.InsertPriceAndRecommends(Id, Price, Taste);
                }else if(RestarantsDAO.OverlapRestarants(Id) >= 1) {
                	RestarantsDAO.UpdateSaveType(Id, SaveType);
                	RestarantsDAO.UpdateFoodType(Id, FoodType);
                	RestarantsDAO.UpdateColleagues(Id, Colleague);
                	RestarantsDAO.UpdatePriceAndRecommends(Id, Price, Taste);
                }
                
                PlacesDAO.InsertPostAllData(SEQ_User,Id, SaveType, FoodType, Taste, Colleague, Price);
                
                double SEQ_Post = FileDAO.getSEQ_Post(SEQ_User, value.get(3));
                
                for(int i  = 0 ; i < list.size(); i++) {
                	FileDAO.Update_upload(SEQ_User, list.get(i), SEQ_Post);
                	/*System.out.println("list : " + list.get(i));*/
                }
                
                StringTokenizer MenuTokenizer = new StringTokenizer(Menu, "#");

                while(MenuTokenizer.hasMoreTokens()) {
                	RecommendMenusDAO.MenuInsert(SEQ_Post, SEQ_User, value.get(3), MenuTokenizer.nextToken());
                }
                
                StringTokenizer TagTokenizer = new StringTokenizer(Tag, "#");
                
                while(TagTokenizer.hasMoreTokens()) {
                	TagDAO.TagInsert(SEQ_Post, SEQ_User, value.get(3), TagTokenizer.nextToken());
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/main.jsp").forward(
                request, response);
        list.clear();
        name.clear();
        value.clear();
        fileName.clear();
    }
}