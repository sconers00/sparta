ERD : https://www.erdcloud.com/d/T4SdL2W6ZHvNffbis
api 구성

				Method			URL			request		response	상태코드
         
	생성			POST		/scheduler/schedule		body		생성정보		201:created
			
	조회			GET		/scheduler/schedule		param		다건 응답 정보	200:OK
			
	단건조회			GET		/scheduler/schedule/{id}	param		단건 응답 정보	200:OK
			
	수정			PATCH		/scheduler/schedule/{id}	body		수정 정보	200:OK

	삭제			DELETE		/scheduler/schedule/{id}	param		-		200:OK

	가입			POST		/member/signIn			body		등록정보		201:created
 
	조회			GET		/member				param		body		200:OK

	단건조회			GET		/member/{id}			param		단건 응답 정보	200:OK

	수정			PATCH		/member/{id}			body		수정정보		200:OK

	삭제			DELETE		/member/{id}			param		-		200:OK

	로그인			POST		/member/logIn			body		body+cookie	200:OK

request body

lv4 schedule

    생성 : {"title":"?", "contents":"?"}

    수정 : {"title":"?", "contents":"?"}

    member

    생성 : {"username":"?", "email":"?", "password":"?"}

    수정 : {"username":"?", "email":"?", "password":"?"}

    logIn : {"email":"?", "password":"?"}
    
response

lv3 schedule

{"id":"?", "userid":"?", "title":"?", "contents":"?", "createdAt":?", "modifiedAt":"?"}

    member
		
{"userid":"?", "username":"?", "email":"?", "createdAt":"?", "modifiedAt":"?"}

	login

{"email":"?", "userid":"?"}
 
titl은 공백이거나 빈 문자열일 수 없음(lv1~) 12자 이상일 수 없음(lv5~)

username은 공백일 수 없으며 빈 문자열일 수 없음.(lv2~), 4자이상, 12자 이하이여야함(lv5~)

email은 빈 문자열이거나 공백일 수 없음(lv2~), email규격을 따라야하며 _, ., @ 이외의 특수문자를 금지(lv5~)

비밀번호는 필수이며 공백이거나 빈 문자열일 수 없으며 최소크기 6 요구 (lv3~)

로그인 실패와 비 인가 접근은 401 에러(lv4~)

현제 문제점 : session attribute 값을 service에서 받아와야 memberid값을 schedule로 넘기는데 그 방법을 구현하기 힘듦.(issue#2 ref #1)
그러한 이유로 schedule작성시 memberid가 null로 처리되는 현상 발생.
