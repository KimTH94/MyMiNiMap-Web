package bean;

import java.io.IOException;  
//import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/Toggle")
public class Toggle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Toggle() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PlaceID = request.getParameter("key");
		System.out.println(PlaceID);
		int SEQ_Post = 0;
		String Count = null;
		String Name = null;
		String Address = null;
		String Tel = null;
		String Price = null;
		String iPrice = null;
		String Taste = null;
		String iTaste = null;
		String Mood = null;
		String SaveType = null;
		String iSaveType = null;
		String FoodType = null;
		String iFoodType = null;
		String Colleague = null;
		String iColleague = null;
		String Nickname = null;
		String nu11 = null;
		String countString = null;
		String recommendMenu = null;
		String iRecommandM = null;
		String FileName = null;
		String tags = null;
		int iCount = 0;
		int initCount = 0;
		String initCountString = null;
		JSONObject result = new JSONObject();
		ArrayList<String>Poster = new ArrayList<String>();
		
		try {
			ArrayList<FeedDTO> photo = FeedDAO.AllShowPhoto2(PlaceID);
			for(FeedDTO feed : photo) {
				FileName = "./imageupload/"+feed.getFileName();
				System.out.println("path = "+FileName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = MemDAO.CountPost(PlaceID);
			for(PlacesDTO places : list){
				initCountString = places.getCount();
				System.out.println(initCountString);
				initCount = Integer.parseInt(initCountString);
	
				System.out.println("등록수"+initCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.getTags(PlaceID);
			for(PlacesDTO places : list){

				tags = places.getTags();
				System.out.println("태그="+tags);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.getRecommendMenus(PlaceID);
			for(PlacesDTO places : list){

				recommendMenu = places.getRecommendMenu();
				System.out.println("추천메뉴="+recommendMenu);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = MemDAO.CountPoster(PlaceID);
			for(PlacesDTO places : list){
				Count = places.getCount();
				System.out.println(Count);
				iCount = Integer.parseInt(Count);
				if(iCount < 1) {
					countString="";
				} else {
					countString = iCount+" 명이 등록";
				}
				
				System.out.println(iCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.UseID(PlaceID);
			for(PlacesDTO places : list){
				Name = places.getName();
				Address = places.getAddress();
				Tel = places.getTel();
				//Price = places.getPrice();
				//Taste = places.getTaste();
				//SaveType = places.getSaveType();
				//System.out.println(SaveType);
				//FoodType = places.getFoodType();
				//Colleague = places.getColleague();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = MemDAO.Poster(PlaceID);
			for(PlacesDTO places : list){
				
				Nickname = places.getNickname();
//				Poster.add(Nickname);
//				Poster.add(" ");
				//System.out.println(Nickname);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.UseID2(PlaceID);
			for(PlacesDTO places : list){
				Colleague = places.getColleague();
				if(Colleague.contains(",")){
				     Colleague = Colleague.replaceAll("\\,", ""); 
				     Colleague = Colleague.replaceAll("/", "");
				     System.out.println("동행쿼리받기"+Colleague);
				     int ia;
				     int pricenull = 0;
				     int price1 = 0;
				     int price2 = 0;
				     int price3 = 0;
				     int price4 = 0;
				     int price5 = 0;
				     int price6 = 0;
				     for(ia=0; ia<Colleague.length(); ia++) {			    	 
//			
						}
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='0')
				    		 pricenull++;
				    	 System.out.println("pricenull = "+pricenull);
				     }
				     System.out.println(ia);
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='1')
				    		 price1++;
				     }
				     System.out.println(price1);
				     
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='2')
				    		 price2++;
				     }
				     System.out.println(price2);
				     
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='3')
				    		 price3++;
				     }
				     System.out.println(price3);
				     
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='4')
				    		 price4++;
				     }
				     System.out.println(price4);
				     
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='5')
				    		 price5++;
				     }
				     System.out.println(price5);
				     
				     for(int i = 0; i<ia; i++) {
				    	 if(Colleague.charAt(i)=='6')
				    		 price6++;
				     }
				     System.out.println(price6);
				     String colle1;
				     String colle2;
				     String colle3;
				     String colle4;
				     String colle5;
				     String colle6;
				     
				     float fcoll1 = ((float)price1 / (float)initCount) * 100;
				     
				     if (fcoll1 > 20) {
				    	 colle1 = "혼자 :"+String.format("%.0f", fcoll1)+"%  ";
				     } else {
				    	 colle1 = "";
				     }
				   
				     float fcoll2 = ((float)price2 / (float)initCount) * 100;
				     if (fcoll2 > 20) {
				    	 colle2 = "친구 :"+String.format("%.0f", fcoll2)+"%  ";
				     } else {
				    	 colle2 = "";
				     }
				     float fcoll3 = ((float)price3 / (float)initCount) * 100;
				     if (fcoll3 > 20) {
				    	 colle3 = "연인 :"+String.format("%.0f", fcoll3)+"%  ";
				     } else {
				    	 colle3 = "";
				     }
				     float fcoll4 = ((float)price4 / (float)initCount) * 100;
				     if (fcoll4 > 20) {
				    	 colle4 = "회식 :"+String.format("%.0f", fcoll4)+"%  ";
				     } else {
				    	 colle4 = "";
				     }
				     float fcoll5 = ((float)price5 / (float)initCount) * 100;
				     if (fcoll5 > 20) {
				    	 colle5 = "비지니스 :"+String.format("%.0f", fcoll5)+"%  ";
				     } else {
				    	 colle5 = "";
				     }
				     float fcoll6 = ((float)price6 / (float)initCount) * 100;
				     if (fcoll6 > 20) {
				    	 colle6 = "가족 :"+String.format("%.0f", fcoll6)+"%  ";
				     } else {
				    	 colle6 = "";
				     }
				     System.out.println("동행시작");
				     System.out.println(colle1);
				     System.out.println(colle2);
				     System.out.println(colle3);
				     System.out.println(colle4);
				     
				     System.out.println(colle5);
				     System.out.println(colle6);
				     iColleague =colle1+colle2+colle3+colle4+colle5+colle6;
				     System.out.println("with"+iColleague);
				  }
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {//savetype  종류 1
			ArrayList<PlacesDTO> list = PlacesDAO.UseID3(PlaceID);
			for(PlacesDTO places : list){
				SaveType = places.getSaveType();
				System.out.println(SaveType);
				if(SaveType.contains(",")){
				     SaveType = SaveType.replaceAll("\\,", ""); 
				     
				     int count;
				     int st1 = 0, st2 = 0, st3 = 0, st4 = 0, st5 = 0;
				     float saveTf1, saveTf2, saveTf3, saveTf4, saveTf5;;
				     String saveT1, saveT2, saveT3, saveT4, saveT5;
				     
				     for(count=0; count<SaveType.length(); count++) {			    	 
//							
						}
				     for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='1')
				    		 st1++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='2')
				    		 st2++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='3')
				    		 st3++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='4')
				    		 st4++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='5')
				    		 st5++;
				     }
				     saveTf1 = ((float)st1 / (float)count) * 100;
				      if (saveTf1 > 20) {
				    	  saveT1 = "맛집 :"+String.format("%.0f", saveTf1)+"%  ";
				     } else {
				    	 saveT1 = "";
				     }
				     saveTf2 = ((float)st2 / (float)count) * 100;
				     if (saveTf2 > 20) {
				    	 saveT2 = "카페 :"+String.format("%.0f", saveTf2)+"%  ";
				     } else {
				    	 saveT2 = "";
				     }
				     saveTf3 = ((float)st3 / (float)count) * 100;
				     if (saveTf3 > 20) {
				    	 saveT3 = "술집 :"+String.format("%.0f", saveTf3)+"%  ";
				     } else {
				    	 saveT3 = "";
				     }
				     saveTf4 = ((float)st4 / (float)count) * 100;
				     if (saveTf4 > 20) {
				    	 saveT4 = "기타 :"+String.format("%.0f", saveTf4)+"%  ";
				     } else {
				    	 saveT4 = "";
				     }
				     saveTf5 = ((float)st5 / (float)count) * 100;
				     if (saveTf5 > 20) {
				    	 saveT5 = "저장 :"+String.format("%.0f", saveTf5)+"%  ";
				     } else {
				    	 saveT5 = "";
				     }
				     System.out.println(saveTf1);
				     System.out.println(saveTf2);
				     System.out.println(saveTf3);
				     System.out.println(saveTf4);
				     System.out.println(saveTf5);
				     iSaveType = saveT1+saveT2+saveT3+saveT4+saveT5;
				     System.out.println("saveT1 = "+saveT1);
				     System.out.println("saveT2 = "+saveT2);
				     System.out.println("saveT3 = "+saveT3);
				     System.out.println("saveT4 = "+saveT4);
				     System.out.println("saveT4 = "+saveT5);

				     System.out.println("iSaveType = "+iSaveType);
				} else {
					int count;
				     int st1 = 0, st2 = 0, st3 = 0, st4 = 0, st5 = 0;
				     float saveTf1, saveTf2, saveTf3, saveTf4, saveTf5;
				     String saveT1, saveT2, saveT3, saveT4, saveT5;
				     
				     for(count=0; count<SaveType.length(); count++) {			    	 
//							
						}
				     for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='1')
				    		 st1++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='2')
				    		 st2++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='3')
				    		 st3++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='4')
				    		 st4++;
				     }for(int i = 0; i<count; i++) {
				    	 if(SaveType.charAt(i)=='5')
				    		 st5++;
				     }
				     saveTf1 = ((float)st1 / (float)count) * 100;
				      if (saveTf1 > 20) {
				    	  saveT1 = "맛집 :"+String.format("%.0f", saveTf1)+"%  ";
				     } else {
				    	 saveT1 = "";
				     }
				     saveTf2 = ((float)st2 / (float)count) * 100;
				     if (saveTf2 > 20) {
				    	 saveT2 = "카페 :"+String.format("%.0f", saveTf2)+"%  ";
				     } else {
				    	 saveT2 = "";
				     }
				     saveTf3 = ((float)st3 / (float)count) * 100;
				     if (saveTf3 > 20) {
				    	 saveT3 = "술집 :"+String.format("%.0f", saveTf3)+"%  ";
				     } else {
				    	 saveT3 = "";
				     }
				     saveTf4 = ((float)st4 / (float)count) * 100;
				     if (saveTf4 > 20) {
				    	 saveT4 = "기타 :"+String.format("%.0f", saveTf4)+"%  ";
				     } else {
				    	 saveT4 = "";
				     }
				     saveTf5 = ((float)st5 / (float)count) * 100;
				     if (saveTf5 > 20) {
				    	 saveT5 = "저장 :"+String.format("%.0f", saveTf5)+"%  ";
				     } else {
				    	 saveT5 = "";
				     }
				     iSaveType = saveT1+saveT2+saveT3+saveT4;
				     System.out.println(saveTf1);
				     System.out.println(saveTf2);
				     System.out.println(saveTf3);
				     System.out.println(saveTf4);
				     System.out.println(saveTf5);
				     System.out.println("saveT1 = "+saveT1);
				     System.out.println("saveT2 = "+saveT2);
				     System.out.println("saveT3 = "+saveT3);
				     System.out.println("saveT4 = "+saveT4);
				     System.out.println("saveT5 = "+saveT5);
				     System.out.println("iSaveType = "+iSaveType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.UseID4(PlaceID);
			for(PlacesDTO places : list){
				FoodType = places.getFoodType();
				String [] foodtypelist = FoodType.split(",");
				System.out.println("start");
				System.out.println(foodtypelist);
				int count;
				int intft1 = 0, intft2=0, intft3=0, intft4=0, intft5=0, intft6=0, intft7=0, intft8=0, intft9=0, intft10=0, intft11=0;
				int intft12=0, intft13=0, intft14=0, intft15=0, intft16=0, intft17=0;
				float floatft1, floatft2, floatft3, floatft4, floatft5, floatft6, floatft7, floatft8, floatft9, floatft10, floatft11, floatft12, floatft13, floatft14, floatft15, floatft16, floatft17;
				String strft1, strft2, strft3, strft4, strft5, strft6, strft7, strft8, strft9, strft10, strft11, strft12, strft13, strft14, strft15, strft16, strft17;
				for(count = 0; count<foodtypelist.length; count++) {
				}
				for(int i = 0; i<foodtypelist.length; i++) {
			
					System.out.println(foodtypelist[i]);
					switch(Integer.parseInt(foodtypelist[i])) {
					case 1: intft1++;
							break;
					case 2: intft2++;
							break;
					case 3: intft3++;
							break;
					case 4: intft4++;
							break;					
					case 5: intft5++;
							break;
					case 6: intft6++;
							break;
					case 7: intft7++;
							break;
					case 8: intft8++;
							break;
					case 9: intft9++;
							break;
					case 10: intft10++;
							break;
					case 11: intft11++;
							break;
					case 12: intft12++;
							break;
					case 13: intft13++;
							break;
					case 14: intft14++;
							break;
					case 15: intft15++;
							break;
					case 16: intft16++;
							break;
					case 17: intft17++;
							break;
					default : break;
					}
				
				}
				System.out.println("end");
				System.out.println("intft1 is");
				System.out.println(intft1);
				System.out.println(intft2);
				System.out.println(intft3);
				System.out.println(intft4);
				System.out.println(intft5);
				System.out.println(intft6);
				System.out.println(intft7);
				System.out.println(intft8);
				System.out.println(intft9);
				System.out.println(intft10);
				System.out.println(intft11);
				System.out.println(intft12);
				System.out.println(intft13);
				System.out.println(intft14);
				System.out.println(intft15);
				System.out.println(intft16);
				System.out.println(intft17);
				floatft1 = ((float)intft1 / (float)count) * 100;
				floatft2 = ((float)intft2 / (float)count) * 100;
				floatft3 = ((float)intft3 / (float)count) * 100;
				floatft4 = ((float)intft4 / (float)count) * 100;
				floatft5 = ((float)intft5 / (float)count) * 100;
				floatft6 = ((float)intft6 / (float)count) * 100;
				floatft7 = ((float)intft7 / (float)count) * 100;
				floatft8 = ((float)intft8 / (float)count) * 100;
				floatft9 = ((float)intft9 / (float)count) * 100;
				floatft10 = ((float)intft10 / (float)count) * 100;
				floatft11 = ((float)intft11 / (float)count) * 100;
				floatft12 = ((float)intft12 / (float)count) * 100;
				floatft13 = ((float)intft13 / (float)count) * 100;
				floatft14 = ((float)intft14 / (float)count) * 100;
				floatft15 = ((float)intft15 / (float)count) * 100;
				floatft16 = ((float)intft16 / (float)count) * 100;
				floatft17 = ((float)intft17 / (float)count) * 100;
				
				
				if (floatft1 > 20) {//1
			    	  strft1 = "한식 :"+String.format("%.0f", floatft1)+"%  ";
			     } else {
			    	 strft1 = "";
			     }
			      if (floatft2 > 20) {//2
			    	  strft2 = "중식 :"+String.format("%.0f", floatft2)+"%  ";
			     } else {
			    	 strft2 = "";
			     }
			      if (floatft3 > 20) {
			    	  strft3 = "일식 :"+String.format("%.0f", floatft3)+"%  ";
			     } else {
			    	 strft3 = "";
			     }
			      if (floatft4 > 20) {
			    	  strft4 = "양식 :"+String.format("%.0f", floatft4)+"%  ";
			     } else {
			    	 strft4 = "";
			     }
			      if (floatft5 > 20) {
			    	  strft5 = "동남아 :"+String.format("%.0f", floatft5)+"%  ";
			     } else {
			    	 strft5 = "";
			     }
			      if (floatft6 > 20) {
			    	  strft6 = "야식 :"+String.format("%.0f", floatft6)+"%  ";
			     } else {
			    	 strft6 = "";
			     }if (floatft7 > 20) {
			    	  strft7 = "분식 :"+String.format("%.0f", floatft7)+"%  ";
			     } else {
			    	 strft7 = "";
			     }if (floatft8 > 20) {
			    	  strft8 = "테마 :"+String.format("%.0f", floatft8)+"%  ";
			     } else {
			    	 strft8 = "";
			     }if (floatft9 > 20) {
			    	  strft9 = "감성 :"+String.format("%.0f", floatft9)+"%  ";
			     } else {
			    	 strft9 = "";
			     }if (floatft10 > 20) {
			    	  strft10 = "브런치 :"+String.format("%.0f", floatft10)+"%  ";
			     } else {
			    	 strft10 = "";
			     }if (floatft11 > 20) {
			    	  strft11 = "애견 :"+String.format("%.0f", floatft11)+"%  ";
			     } else {
			    	 strft11 = "";
			     }if (floatft12 > 20) {
			    	  strft12 = "한식 :"+String.format("%.0f", floatft12)+"%  ";
			     } else {
			    	 strft12 = "";
			     }if (floatft13 > 20) {
			    	  strft13 = "중식 :"+String.format("%.0f", floatft13)+"%  ";
			     } else {
			    	 strft13 = "";
			     }if (floatft14 > 20) {
			    	  strft14 = "일식 :"+String.format("%.0f", floatft14)+"%  ";
			     } else {
			    	 strft14 = "";
			     }if (floatft15 > 20) {
			    	  strft15 = "모던바 :"+String.format("%.0f", floatft15)+"%  ";
			     } else {
			    	 strft15 = "";
			     }if (floatft16 > 20) {
			    	  strft16 = "와인 :"+String.format("%.0f", floatft16)+"%  ";
			     } else {
			    	 strft16 = "";
			     }if (floatft17 > 20) {
			    	  strft17 = "포차 :"+String.format("%.0f", floatft17)+"%  ";
			     } else {
			    	 strft17 = "";
			     }
			     iFoodType = strft1+strft2+strft3+strft4+strft5+strft6+strft7+strft8+strft9+strft10+strft11+strft12+strft13+strft14+strft15+strft16+strft17;
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.UseID5(PlaceID);
			for(PlacesDTO places : list){
				Taste = places.getTaste();
				System.out.println(Taste);
				if(Taste.contains(",")) {
					Taste = Taste.replaceAll(",", "");
					int count;
					int intTaste1 =0, intTaste2 = 0;
					float ftTaste1, ftTaste2;
					String strTaste1, strTaste2;
					for(count = 0; count<Taste.length(); count++) {
					}
					for(int i = 0; i<count; i++) {
						if(Taste.charAt(i)=='1')
							intTaste1++;
					}for(int i = 0; i<count; i++) {
						if(Taste.charAt(i)=='2')
							intTaste2++;
					}
					ftTaste1 = ((float)intTaste1 / (float)count) * 100;
					ftTaste2 = ((float)intTaste2 / (float)count) * 100;
					
					 if (ftTaste1 > 20) {//1
				    	  strTaste1 = "긍정 :"+String.format("%.0f", ftTaste1)+"%  ";
				     } else {
				    	 strTaste1 = "";
				     }
				      if (ftTaste2 > 20) {//2
				    	  strTaste2 = "부정 :"+String.format("%.0f", ftTaste2)+"%  ";
				     } else {
				    	 strTaste2 = "";
				     }
				     iTaste = strTaste1+strTaste2;
				} else {
					int count;
					int intTaste1 =0, intTaste2 = 0;
					float ftTaste1, ftTaste2;
					String strTaste1, strTaste2;
					for(count = 0; count<Taste.length(); ++count) {
					}
					for(int i = 0; i<count; i++) {
						if(Taste.charAt(i)=='1')
							intTaste1++;
					}for(int i = 0; i<count; i++) {
						if(Taste.charAt(i)=='2')
							intTaste2++;
					}
					ftTaste1 = ((float)intTaste1 / (float)count) * 100;
					ftTaste2 = ((float)intTaste2 / (float)count) * 100;
					
					 if (ftTaste1 > 20) {//1
				    	  strTaste1 = "긍정 :"+String.format("%.0f", ftTaste1)+"%  ";
				     } else {
				    	 strTaste1 = "";
				     }
				      if (ftTaste2 > 20) {//2
				    	  strTaste2 = "부정 :"+String.format("%.0f", ftTaste2)+"%  ";
				     } else {
				    	 strTaste2 = "";
				     }
				     iTaste = strTaste1+strTaste2;
				}
				
				System.out.println("평가 = "+iTaste);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ArrayList<PlacesDTO> list = PlacesDAO.UseID6(PlaceID);
			for(PlacesDTO places : list){
				Price = places.getPrice();
				System.out.println(Price);
				if(Price.contains(",")) {
					Price = Price.replaceAll(",", "");
					Price = Price.replaceAll("0", "");
					System.out.println("Price"+Price);
					int count;
					int dprice1=0, dprice2=0, dprice3=0, dprice4=0, dprice5=0;
					float fprice1, fprice2, fprice3, fprice4, fprice5;
					String strprice1, strprice2, strprice3, strprice4, strprice5;
					
					for(count = 0; count<Price.length(); count++) {
					}
					for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='1')
							dprice1++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='2')
							dprice2++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='3')
							dprice3++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='4')
							dprice4++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='5')
							dprice5++;
					}
					fprice1 = ((float)dprice1 / (float)count) * 100;
					fprice2 = ((float)dprice2 / (float)count) * 100;
					fprice3 = ((float)dprice3 / (float)count) * 100;
					fprice4 = ((float)dprice4 / (float)count) * 100;
					fprice5 = ((float)dprice5 / (float)count) * 100;
					if (fprice1 > 20) {//1
				    	  strprice1 = "1만원 이하 :"+String.format("%.0f", fprice1)+"%  ";
				     } else {
				    	 strprice1 = "";
				     }if (fprice2 > 20) {//1
				    	  strprice2 = "3만원 이하 :"+String.format("%.0f", fprice2)+"%  ";
				     } else {
				    	 strprice2 = "";
				     }if (fprice3 > 20) {//1
				    	  strprice3 = "5만원 이하 :"+String.format("%.0f", fprice3)+"%  ";
				     } else {
				    	 strprice3 = "";
				     }if (fprice4 > 20) {//1
				    	  strprice4 = "7만원 이하 :"+String.format("%.0f", fprice4)+"%  ";
				     } else {
				    	 strprice4 = "";
				     }if (fprice5 > 20) {//1
				    	  strprice5 = "10만원 이하 :"+String.format("%.0f", fprice5)+"%  ";
				     } else {
				    	 strprice5 = "";
				     }
				     iPrice = strprice1+strprice2+strprice3+strprice4+strprice5;
				} else {
					int count;
					int dprice1=0, dprice2=0, dprice3=0, dprice4=0, dprice5=0;
					float fprice1, fprice2, fprice3, fprice4, fprice5;
					String strprice1, strprice2, strprice3, strprice4, strprice5;
					
					for(count = 0; count<Price.length(); count++) {
					}
					for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='1')
							dprice1++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='2')
							dprice2++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='3')
							dprice3++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='4')
							dprice4++;
					}for(int i = 0; i<count; i++) {
						if(Price.charAt(i)=='5')
							dprice5++;
					}
					fprice1 = ((float)dprice1 / (float)count) * 100;
					fprice2 = ((float)dprice2 / (float)count) * 100;
					fprice3 = ((float)dprice3 / (float)count) * 100;
					fprice4 = ((float)dprice4 / (float)count) * 100;
					fprice5 = ((float)dprice5 / (float)count) * 100;
					if (fprice1 > 20) {//1
				    	  strprice1 = "1만원 이하 :"+String.format("%.0f", fprice1)+"%  ";
				     } else {
				    	 strprice1 = "";
				     }if (fprice2 > 20) {//1
				    	  strprice2 = "3만원 이하 :"+String.format("%.0f", fprice2)+"%  ";
				     } else {
				    	 strprice2 = "";
				     }if (fprice3 > 20) {//1
				    	  strprice3 = "5만원 이하 :"+String.format("%.0f", fprice3)+"%  ";
				     } else {
				    	 strprice3 = "";
				     }if (fprice4 > 20) {//1
				    	  strprice4 = "7만원 이하 :"+String.format("%.0f", fprice4)+"%  ";
				     } else {
				    	 strprice4 = "";
				     }if (fprice5 > 20) {//1
				    	  strprice5 = "10만원 이하 :"+String.format("%.0f", fprice5)+"%  ";
				     } else {
				    	 strprice5 = "";
				     }
				     iPrice = strprice1+strprice2+strprice3+strprice4+strprice5;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			result.put("file", FileName);
			result.put("Count", countString);
			result.put("Name", Name);
			result.put("Address", Address);
			result.put("Tel", Tel);
			result.put("Price", iPrice);
			result.put("Taste",iTaste);
			result.put("SaveType", iSaveType);
			result.put("FoodType", iFoodType);
			result.put("Colleague", iColleague);
			result.put("recommendMenu", recommendMenu);
			result.put("Tags", tags);
			//Poster.add(Nickname);
			//result.put("Nickname", Poster);
			System.out.println(Poster);
			System.out.println("end");
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
