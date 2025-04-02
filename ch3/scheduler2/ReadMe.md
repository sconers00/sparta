ERD : https://www.erdcloud.com/d/T4SdL2W6ZHvNffbis
api 구성

	        Method	     URL			              request		response		    상태코드
         
생성    	POST	    /scheduler/schedule	      body		  생성정보		    201:created

조회    	GET	      /scheduler/schedule	      param		  다건 응답 정보	200:OK

단건조회	GET      	/scheduler/schedule/{id}	param		  단건 응답 정보	200:OK

수정    	PATCH	    /scheduler/schedule/{id}	body		  수정 정보		    200:OK

삭제    	DELETE	  /scheduler/schedule/{id}	param		  -		            200:OK

가입    	POST	    /scheduler/user		        body		  등록정보		    201:created

조회    	GET	      /scheduler/user		        param		  body		        200:OK

단건조회	GET	      /scheduler/user/{id}	    param		  단건 응답 정보	200:OK

수정	    PATCH	    /scheduler/user/{id}	    body		  수정정보		    200:OK

삭제    	DELETE	  /scheduler/user/{id}	    param		  -		            200:OK

로그인	  ?        	?		          	          ?		      ?		            200:OK

request body

lv1 schedule만 존재

    생성 : {"username":"?", "title":"?", "contents":"?"}

    수정 : {"title":"?", "contents":"?"}
    
response

lv1 schedule만 존재

  {"id":"?", "username":"?", "title":"?", "contents":"?", "createdAt":?", "editedAt":"?"}
