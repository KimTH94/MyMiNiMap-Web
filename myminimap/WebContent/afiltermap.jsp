<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Collections"%>
<%@page import=" java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="mapDTO" class="amap.amapDTO"/>
<jsp:useBean id="mapDAO" class="amap.amapDAO"/>
<jsp:useBean id="memDAO" class="amem.amemDAO"/>
<jsp:useBean id="filterDAO" class="afilter.aFilterDAO"/>
<jsp:useBean id="placeDAO" class="aplace.aplaceDAO"/>
<%

	ArrayList<String> Email = mapDAO.getEmail();
	ArrayList<String> lngList = new ArrayList<>();
	ArrayList<String> latList = new ArrayList<>();
	ArrayList<String> NameList = new ArrayList<>();
	ArrayList<String> AddressList = new ArrayList<>();
	ArrayList<String> telList = new ArrayList<>();
	ArrayList<String> PriceList = new ArrayList<>();
	ArrayList<String> IdList = new ArrayList<>();
	ArrayList<String> TasteList = new ArrayList<>();
	ArrayList<String> CheckList = new ArrayList<>();
	ArrayList<String> first = new ArrayList<>();
	ArrayList<String> second = new ArrayList<>();
	ArrayList<String> third = new ArrayList<>();
	ArrayList<String> fourth = new ArrayList<>();
	ArrayList<String> five = new ArrayList<>();
	ArrayList<String> six = new ArrayList<>();
	ArrayList<String> seven = new ArrayList<>();
	ArrayList<String> temp = new ArrayList<>();
	ArrayList<Double> keySet = new ArrayList<>();
	boolean flag = false;
	HashMap<String ,Double> map= new HashMap<>();
	ArrayList<String> Rank = new ArrayList<>();
	ArrayList<String> List = new ArrayList<>();
	ArrayList<String> tagList = new ArrayList<>();
	ArrayList<String> tagtypeList = new ArrayList<>();
	Double A,B,C,D,E,F,G,Sum;
	int Min,Max;
	Double SEQ;
	ArrayList<Double> Colleagues= new ArrayList<>();
	ArrayList<Double> foodTypes = new ArrayList<>();
	ArrayList<Double> saveTypes = new ArrayList<>();
	ArrayList<Double> priceList = new ArrayList<>();
	ArrayList<Double> recommendList = new ArrayList<>();
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String tag = request.getParameter("tag");
	String tagtype = request.getParameter("tagtype");
	String recommend = request.getParameter("recommend");
	String min = request.getParameter("min");
	String max = request.getParameter("max");
	String key = request.getParameter("key");
	String savetype = request.getParameter("savetype");
	String foodtype = request.getParameter("foodtype");
	String colleague = request.getParameter("colleague");
	String latitude = request.getParameter("lat");
	String longitude = request.getParameter("lon");
	
	System.out.println("1"+tag);
	System.out.println("2"+tagtype);
	System.out.println("3"+recommend);
	System.out.println("4"+min);
	System.out.println("5"+max);
	System.out.println("6"+key);
	System.out.println("7"+savetype);
	System.out.println("8"+foodtype);
	System.out.println("9"+colleague);
	System.out.println("10"+latitude);
	System.out.println("11"+longitude);
	
	SEQ = memDAO.getSEQ_User(key);
	//tagtype을 StringTokenizer로 찢어서 for문 돌면서 tagtype 이 menu인 애 일때의 인덱스(i)를 찾아서 그 때의 tag(즉, menu가 옴)를 줘서 만족하는 ID값을 뽑아내자 .  함수는 5개가 있어야겠지 ㅎㅎ ,,
	//그 다음 tagtype이 tag일 때의 인덱스(i)를 찾아서 그 때의 tag(즉, tag가  옴)와 1번과정에서 얻어낸 ID 2개를 인자로 넘겨서 만족하는 ID값을 뽑아내자. 이거도 함수가 5개가 있어야할 것 같습니다. 
	// 그러고나면 menu와 tag를 만족하는 Post의 ID값을 가지고 있게 되겠지 . 

	StringTokenizer st = new StringTokenizer(tagtype,"/");
	while(st.hasMoreTokens()){
		tagtypeList.add(st.nextToken());
	}
	System.out.println("태그사이즈1 "+tagtypeList.size());
	st = new StringTokenizer(tag,"/");
	while(st.hasMoreTokens()){
		tagList.add(st.nextToken());
	}
	
	
	
	
	//메뉴가 0 개입력받았을 경우 , 그에 따른 tag의 필터를 제한을 둬야한다.   --> 두개 다 0개인 경우도 생각해야겟지 
	if(tag.length()==0 && tagtype.length()==0){ //둘다 없는경우 모든 음식점을 second에 넣어줘야함. 
		second = filterDAO.all();
		for(int i = 0 ; i <second.size();i++)
			System.out.println(second.get(i));
	}else{
		
	System.out.println("태그사이즈 "+tagList.size());
	for(int i = 0 ; i <tagtypeList.size();i++){
		if(tagtypeList.get(i).equals("menu")){
			temp = filterDAO.menu(tagList.get(i));
			first.addAll(temp);
			temp.clear();
		}
	}
	HashSet<String> hash = new HashSet<String>(first);
	first = new ArrayList<String>(hash);
	
	System.out.println("tagTypeListSize "+tagtypeList.size());
	//first에는 메뉴 필터된 ID가 최대 20개 들어있음
	if(first.size()!=0){
	for(int i = 0 ; i <tagtypeList.size();i++){
		if(tagtypeList.get(i).equals("tag")){
			for(int j = 0 ; j <first.size();j++){
				flag = true;
				temp = filterDAO.tag(tagList.get(i),first.get(j));
				second.addAll(temp);
				temp.clear();
				}
			}
		}
	}
	else{
		for(int i = 0 ; i <tagtypeList.size();i++){
			if(tagtypeList.get(i).equals("tag")){
				flag = true;
				temp = filterDAO.tag(tagList.get(i));
				second.addAll(temp);
				HashSet<String> hash2 = new HashSet<String>(second);
				second = new ArrayList<String>(hash2);
				temp.clear();
			}
		}
	}
	if(flag==false)
		second = first;
	
	
	for(int i = 0 ; i <first.size();i++)
		System.out.println("메뉴필터"+first.get(i));
	for(int i = 0 ; i <second.size();i++)
		System.out.println("태그필터"+second.get(i));
	flag = false;
	}
	//=======================================tag, menu로 걸러진 애들만 오는거다 ㅇㅋ ??? 
			
	//지금 tag, menu로 걸러진 애들 있을거 아님 ?? 
	//동행할때는 Colleagues Table에서 6개의 속성을 다 더해서 Total을 구하고   각 속성 / Total 이  0.2가 넘는 애들 3개만 출력해주는 방식으로 할건데 그걸 어떻게 진행을 해야될 지 를 모르겟다 이거. 
	//내가 지금음식점 ID랑 원하는 Colleague속성들을 가지고있자나 . 그럼 음식점 ID를 넘겨서 
	System.out.println("Tag" + tag);
	System.out.println("Colleagues"+colleague);
	try{
	st = new StringTokenizer(colleague,"/");
	while(st.hasMoreTokens()){
		String token = st.nextToken();
		System.out.println("Token " +token);
		if(token.equals("1"))
			List.add("Alone");
		else if (token.equals("2"))
			List.add("Friend");
		else if (token.equals("3"))
			List.add("Couple");
		else if (token.equals("4"))
			List.add("DiningTogether");
		else if (token.equals("5"))
			List.add("Business");
		else if (token.equals("6"))
			List.add("Family");
		}
	}
	
	catch(Exception e){}

	for(int i = 0 ; i<second.size();i++){
		try{
		Colleagues = filterDAO.getColleagues(second.get(i));
		A = Colleagues.get(0);
		B = Colleagues.get(1);
		C = Colleagues.get(2);
		D = Colleagues.get(3);
		E = Colleagues.get(4);
		F = Colleagues.get(5);
		Sum = A+B+C+D+E+F;
		System.out.println("Result : " + Sum);
		if(A<Sum*0.2)
			A=0.0;
		if(B<Sum*0.2)
			B=0.0;
		if(C<Sum*0.2)
			C=0.0;
		if(D<Sum*0.2)
			D=0.0;
		if(E<Sum*0.2)
			E=0.0;
		if(F<Sum*0.2)
			F=0.0;
		
		if(A  !=0){
			System.out.println("A"+A);
			keySet.add(A);
			map.put("Alone", A);	
		}
		if(B  !=0){
			System.out.println("B"+B);
			keySet.add(B);
			map.put("Friend", B);	
		}
		if(C  !=0){
			System.out.println("C"+C);
			keySet.add(C);
			map.put("Couple", C);	
		}
		if(D  !=0){
			System.out.println("D"+D);
			keySet.add(D);
			map.put("DiningTogether", D);	
		}
		if(E  !=0){
			System.out.println("E"+E);
			keySet.add(E);
			map.put("Business", E);	
		}
		if(F  !=0){
			System.out.println("F"+F);
			keySet.add(F);
			map.put("Family", F);	
		}
		
		Collections.sort(keySet);
		Collections.reverse(keySet);
		for(int k = 0 ; k<keySet.size();k++)
			System.out.println("KeySet : " +keySet.get(k));
		
		
		
			for(int m = 0 ; m <keySet.size();m++){
				if(m==3)
					break;
				if(map.get("Alone")==keySet.get(m)){
					Rank.add("Alone");
				}else if(map.get("Friend")==keySet.get(m)){
					Rank.add("Friend");
				}else if(map.get("Couple")==keySet.get(m)){
					Rank.add("Couple");
				}else if(map.get("DiningTogether")==keySet.get(m)){
					Rank.add("DiningTogether");
				}else if(map.get("Business")==keySet.get(m)){
					Rank.add("Business");
				}else if(map.get("Family")==keySet.get(m)){
					Rank.add("Family");
				}
			}
		
		System.out.println("ColleaguesRank" +Rank);
		//for(int k = 0 ; k <colleaguesRank.size();i++)
			//System.out.println("Ranking : " +colleaguesRank.get(k));
		
				outerloop:
		for(int n = 0  ; n <List.size();n++){
			System.out.println("아씨발뭔데");
			for(int m = 0 ; m < Rank.size();m++){
				if(List.get(n).equals(Rank.get(m))){
					System.out.println("진입각");
					third.add(second.get(i));
					break outerloop;
				}
			}
		}
			
		
		
		keySet.clear();
		Rank.clear();
		}
		catch(Exception e){
			
		}
	}
	
		System.out.println("Third size " +third.size());
		for(int i = 0 ; i < third.size();i++)
		System.out.println("Third : " +third.get(i));
	//===============================동료까지 걸러진거임 ??
	System.out.println("FoodType : "+foodtype);
	List.clear();
	map.clear();
				
			
	
	   try{
		   st = new StringTokenizer(foodtype,"/");
		   while(st.hasMoreTokens()){
		      String token = st.nextToken();
		      System.out.println("Token " +token);
		      if(token.equals("1"))
		    	  List.add("KoreanFood");
		      else if (token.equals("2"))
		    	  List.add("ChineseFood");
		      else if (token.equals("3"))
		    	  List.add("JapaneseFood");
		      else if (token.equals("4"))
		    	  List.add("WesternFood");
		      else if (token.equals("5"))
		    	  List.add("SoutheastAsianFood");
		      else if (token.equals("6"))
		    	  List.add("LateNightMeal");
		      else if (token.equals("7"))
		    	  List.add("FlourBasedFood");
		      }
		   }
		   
		   catch(Exception e){
			   
		   }
	   
	   for(int i = 0 ; i < third.size();i++){
		   try{
			   
		   foodTypes = filterDAO.getFoodTypes(third.get(i));
		   A= foodTypes.get(0);
		   B= foodTypes.get(1);
		   C= foodTypes.get(2);
		   D= foodTypes.get(3);
		   E= foodTypes.get(4);
		   F= foodTypes.get(5);
		   G= foodTypes.get(6);
		   Sum = A+B+C+D+E+F+G;
		   System.out.println("SUM :::"+Sum);
		   
		   if(A<Sum*0.2)
		         A=0.0;
		      if(B<Sum*0.2)
		         B=0.0;
		      if(C<Sum*0.2)
		         C=0.0;
		      if(D<Sum*0.2)
		         D=0.0;
		      if(E<Sum*0.2)
		         E=0.0;
		      if(F<Sum*0.2)
		         F=0.0;
		      if(G<Sum*0.2)
		         G=0.0;
		      
		      if(A  !=0){
		         System.out.println("A"+A);
		         keySet.add(A);
		         map.put("KoreanFood", A);   
		      }
		      if(B  !=0){
		         System.out.println("B"+B);
		         keySet.add(B);
		         map.put("ChineseFood", B);   
		      }
		      if(C  !=0){
		         System.out.println("C"+C);
		         keySet.add(C);
		         map.put("JapaneseFood", C);   
		      }
		      if(D  !=0){
		         System.out.println("D"+D);
		         keySet.add(D);
		         map.put("WesternFood", D);   
		      }
		      if(E  !=0){
		         System.out.println("E"+E);
		         keySet.add(E);
		         map.put("SoutheastAsianFood", E);   
		      }
		      if(F  !=0){
		         System.out.println("F"+F);
		         keySet.add(F);
		         map.put("LateNightMeal", F);   
		      }
		      if(G  !=0){
			     System.out.println("G"+G);
			     keySet.add(G);
			     map.put("FlourBasedFood", G);   
		      }

		      Collections.sort(keySet);
		      Collections.reverse(keySet);
		      for(int k = 0 ; k<keySet.size();k++)
		         System.out.println("KeySet : " +keySet.get(k));
		   

		         for(int m = 0 ; m <keySet.size();m++){
		            if(m==3)
		               break;
		            if(map.get("KoreanFood")==keySet.get(m)){
		               Rank.add("KoreanFood");
		            }else if(map.get("ChineseFood")==keySet.get(m)){
		            	Rank.add("ChineseFood");
		            }else if(map.get("JapaneseFood")==keySet.get(m)){
		            	Rank.add("JapaneseFood");
		            }else if(map.get("WesternFood")==keySet.get(m)){
		            	Rank.add("WesternFood");
		            }else if(map.get("SoutheastAsianFood")==keySet.get(m)){
		            	Rank.add("SoutheastAsianFood");
		            }else if(map.get("LateNightMeal")==keySet.get(m)){
		            	Rank.add("LateNightMeal");
		            }else if(map.get("FlourBasedFood")==keySet.get(m)){
		            	Rank.add("FlourBasedFood");
		            }
		         }
		         
		         System.out.println("foodTypes" +Rank);
		         //for(int k = 0 ; k <colleaguesRank.size();i++)
		            //System.out.println("Ranking : " +colleaguesRank.get(k));
		         
		         outerloop:
		         for(int n = 0  ; n <List.size();n++){
		            System.out.println("아씨발뭔데");
		            for(int m = 0 ; m < Rank.size();m++){
		               if(List.get(n).equals(Rank.get(m))){
		                  System.out.println("진입각");
		                  fourth.add(third.get(i));
		                  break outerloop;
		               }
		            }
		         }
		     

		         keySet.clear();
		         Rank.clear();
		         }
		   catch(Exception e){}         
		   
	   }
	   for(int i = 0 ; i < fourth.size();i++){
	    	  System.out.println("Fouth : " +fourth.get(i));
	   }
	   
		List.clear();
		map.clear();
	
	
	//====================================================메뉴 , 태그 , 동행 , 음식타입까지 완료 
	System.out.println("SaveTypes : " + savetype);
	try{
		st = new StringTokenizer(savetype,"/");
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			System.out.println("Token : " +token);
			if(token.equals("1"))
				List.add("Restaurant");
			else if(token.equals("2"))
				List.add("Cafe");
			else if(token.equals("3"))
				List.add("Alcohol");
			else if(token.equals("4"))
				List.add("Price");
			else if(token.equals("5"))
				List.add("Save");
		}
	}catch(Exception e){}
	
	

	   for(int i = 0 ; i<fourth.size();i++){
	      try{
	      saveTypes = filterDAO.getSaveTypes(fourth.get(i));
	      A = saveTypes.get(0);
	      B = saveTypes.get(1);
	      C = saveTypes.get(2);
	      D = saveTypes.get(3);
	      E = saveTypes.get(4);
	      Sum = A+B+C+D+E;
	      System.out.println("Result : " + Sum);
	      if(A<Sum*0.2)
	         A=0.0;
	      if(B<Sum*0.2)
	         B=0.0;
	      if(C<Sum*0.2)
	         C=0.0;
	      if(D<Sum*0.2)
	         D=0.0;
	      if(E<Sum*0.2)
	         E=0.0;
	      
	      if(A  !=0){
	         System.out.println("A"+A);
	         keySet.add(A);
	         map.put("Restaurant", A);   
	      }
	      if(B  !=0){
	         System.out.println("B"+B);
	         keySet.add(B);
	         map.put("Cafe", B);   
	      }
	      if(C  !=0){
	         System.out.println("C"+C);
	         keySet.add(C);
	         map.put("Alcohol", C);   
	      }
	      if(D  !=0){
	         System.out.println("D"+D);
	         keySet.add(D);
	         map.put("Price", D);   
	      }
	      if(E  !=0){
	         System.out.println("E"+E);
	         keySet.add(E);
	         map.put("Save", E);   
	      }
	      
	      Collections.sort(keySet);
	      Collections.reverse(keySet);
	      for(int k = 0 ; k<keySet.size();k++)
	         System.out.println("KeySet : " +keySet.get(k));
	      
	      
	      
	         for(int m = 0 ; m <keySet.size();m++){
	            if(m==3)
	               break;
	            if(map.get("Restaurant")==keySet.get(m)){
	               Rank.add("Restaurant");
	            }else if(map.get("Cafe")==keySet.get(m)){
	            	Rank.add("Cafe");
	            }else if(map.get("Alcohol")==keySet.get(m)){
	            	Rank.add("Alcohol");
	            }else if(map.get("Price")==keySet.get(m)){
	            	Rank.add("Price");
	            }else if(map.get("Save")==keySet.get(m)){
	            	Rank.add("Save");
	            }
	         }
	      
	      System.out.println("SaveTypeRank" +Rank);
	      //for(int k = 0 ; k <colleaguesRank.size();i++)
	         //System.out.println("Ranking : " +colleaguesRank.get(k));
	      
	            outerloop:
	      for(int n = 0  ; n <List.size();n++){
	         System.out.println("아씨발뭔데");
	         for(int m = 0 ; m < Rank.size();m++){
	            if(List.get(n).equals(Rank.get(m))){
	               System.out.println("진입각");
	               five.add(fourth.get(i));
	               break outerloop;
	            }
	         }
	      }
	         
	      
	      
	      keySet.clear();
	      Rank.clear();
	      }
	      catch(Exception e){
	         
	      }
	   }
	   
	   //===============================동료까지 걸러진거임 ??
	         
	   //System.out.println("Five size " +five.size());
	   //for(int i = 0 ; i < five.size();i++)
	   //   System.out.println(five.get(i));

	   
	//====================================================saveType ,foodType ,colleague 까지 다걸렀다
	//지금까지 걸러진 ID를 인자로 넘겨서 priceAndRecommend 테이블에서 Recommend NonRecommend 2개  카운트세서 가져온다음에 더해서 그 비율이 recommend 보다 높은 애들의 아이디만 거리면 되겠지 . 
	for(int i = 0 ; i <five.size();i++){
		try{
		recommendList = filterDAO.getRecommend(five.get(i));
		
		A = recommendList.get(0);
		B=  recommendList.get(1);
		if(B==0){
			six.add(five.get(i)); //비추가 0이니까 추천 100프로니까 	
		}
		else{
			double check = A/B;
			if(check+100 >=Double.parseDouble(recommend)){
				six.add(five.get(i));
			}
		}}catch(Exception e){}
	}
	//recommend까지 걸러진 ID들을 인자로 넘겨서 priceAndRecommend 테이블에서 Price1,2,3,4,5
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=============================================여기까지하면 seven 배열에 모든 필터링을 거친 음식점의 ID가 들어있엉 그럼 이제 ID를 기반으로 찾아서 가져오면된다이겁니다. 
			
	System.out.println("One"+first.size());
	System.out.println("Two"+second.size());
	System.out.println("Three"+third.size());
	System.out.println("Four"+fourth.size());
	System.out.println("Five"+five.size());
	System.out.println("Six"+six.size());
	System.out.println("SEVEN"+seven.size());

	HashSet<String> hash3 = new HashSet<String>(five);
	five = new ArrayList<String>(hash3);
	for(int i = 0 ; i <five.size();i++)
		System.out.println(i+"번째 : " + five.get(i));
			
			
	System.out.println("++++++++++++++++++++++++++++++");
	System.out.println("++++++++++++++++++++++++++++++");
	System.out.println("++++++++++++++++++++++++++++++");
	String temp1 ; 
	ArrayList<String> test = new ArrayList<>();
	String R,NR,P1,P2,P3,P4,P5;
	for(int i = 0 ; i<seven.size();i++){
		temp1 = mapDAO.getAddress(seven.get(i));
		AddressList.add(temp1);
		temp1 = mapDAO.getName(seven.get(i));
		NameList.add(temp1);
		temp1 = mapDAO.getTel(seven.get(i));
		telList.add(temp1);
		test = mapDAO.getPrice(seven.get(i));
		P1 = test.get(0);
		P2 = test.get(1);
		P3 = test.get(2);
		P4 = test.get(3);
		P5 = test.get(4);
		test = mapDAO.getRecommend(seven.get(i));
		R = test.get(0);
		NR = test.get(1);
		//여기서 가공해서 가격 얼마대인지 , 추천지수 몇인지 	
	}
	if(tag.length()!=0)
	System.out.println(tag);
	if(tagtype.length()!=0)
	System.out.println(tagtype);
	System.out.println(recommend);
	System.out.println(min);
	System.out.println(max);
	System.out.println(foodtype);
	System.out.println(savetype);
	System.out.println(colleague);
	System.out.println(latitude);
	System.out.println(longitude);
	System.out.println(key);
	
	for(int i = 0 ; i<five.size();i++){
		lngList.add(String.valueOf(placeDAO.get_lng(five.get(i))));
		latList.add(String.valueOf(placeDAO.get_lat(five.get(i))));
		NameList.add(placeDAO.get_Name(five.get(i)));
		AddressList.add(placeDAO.get_Address(five.get(i)));
		telList.add(placeDAO.get_Tel(five.get(i)));	
		CheckList.add(String.valueOf(placeDAO.getCheck(five.get(i),SEQ)));
		PriceList.add("1");
		TasteList.add("1");
	}
	out.print(five.size()+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(lngList.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(latList.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(NameList.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(AddressList.get(i)+"@/@");
	for(int i = 0 ; i <five.size();i++){
		if(telList.get(i).equals(""))
			out.print(" @/@");
		else
			out.print(telList.get(i)+"@/@");
	}
	for(int i = 0 ; i < five.size();i++)
		out.print(five.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(PriceList.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(TasteList.get(i)+"@/@");
	for(int i = 0 ; i < five.size();i++)
		out.print(CheckList.get(i)+"@/@");
%>