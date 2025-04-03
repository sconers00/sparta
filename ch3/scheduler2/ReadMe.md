ERD : https://www.erdcloud.com/d/T4SdL2W6ZHvNffbis
api 구성

				Method			URL			request		response	상태코드
         
	생성			POST		/scheduler/schedule		body		생성정보		201:created
			
	조회			GET		/scheduler/schedule		param		다건 응답 정보	200:OK
			
	단건조회			GET		/scheduler/schedule/{id}	param		단건 응답 정보	200:OK
			
	수정			PATCH		/scheduler/schedule/{id}	body		수정 정보	200:OK

	삭제			DELETE		/scheduler/schedule/{id}	param		-		200:OK

	가입			POST		/member				body		등록정보		201:created
 
	조회			GET		/member				param		body		200:OK

	단건조회			GET		/member/{id}			param		단건 응답 정보	200:OK

	수정			PATCH		/member/{id}			body		수정정보		200:OK

	삭제			DELETE		/member/{id}			param		-		200:OK

	로그인			?		?				?		      ?		200:OK

request body

lv3 schedule

    생성 : {"title":"?", "contents":"?"}

    수정 : {"title":"?", "contents":"?"}

    member

    생성 : {"username":"?", "email":"?", "password":"?"}

    수정 : {"username":"?", "email":"?", "password":"?"}
    
response

lv3 schedule

{

	"id":"?",
 
	"userid":"?",
 
 	"title":"?",
	
 	"contents":"?",
	
	"createdAt":?",
 
	"modifiedAt":"?"
 
 }

    member
  {
	
	"userid":"?",
 
	"username":"?",
 
	"email":"?",
 
	"createdAt":"?",
 
	"modifiedAt":"?"
 
 }
 
로그인 기능이 없기에 스케쥴 등록시 userid에서 의존성 고장. lv4부터 정리될 예정.
titl은 공백이거나 빈 문자열일 수 없음(lv1~)
username, email은 공백일 수 없으며 빈 문자열일 수 없음.(lv2~)
비밀번호는 필수이며 공백이거나 빈 문자열일 수 없으며 최소크기 6 요구 (lv3~)
