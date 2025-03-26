기능      일정 생성        일정 전체 조회    일정 단건 조회    일정 수정         일정 삭제
method    POST              GET                GET                PATCH            DELETE
url       /scheduler        /scheduler        /scheduler/{id}    /scheduler/{id}  /scheduler/{id}
상태코드  201: 정상 생성    200:정상 조회     200: 정상 조회    200: 정상 수정    204: 정상 삭제
request  요청body           요청body          요청param          요청body          요청param
         {                   {
          "todo":"할일"       "edit":"수정날짜"                                      
          "name":"작성자"     "name":"작성자"
          "pswd":"비밀번호"   }
          }
response  등록정보           다건 응답 정보    단건 응답 정보   수정 정보             -

ERD : https://www.erdcloud.com/d/iv2Pwg8DHcjajxhdt

lv.1 일정 생성 기능 완성
검색기능 WIP Fixes-1
