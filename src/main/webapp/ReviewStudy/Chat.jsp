<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Web Socket Example</title>
<style>
// 에러 메시지 css
.error-message {
  color: red;
}
</style>
</head>
<body>
  <!-- 로그인 실패할 때 표시되는 에러 메시지 -->
  <p>
    <span class="error-message"></span>
  </p>
  <!-- 아이디를 넣고 login 버튼을 누르면 name이 저장된다. -->
  <p>
    login : <input type="text" id="username" name="username" class="login-package">
    <button id="loginBtn" class="login-package">login</button>
  </p>
  <!-- 채팅시에 사용될 채팅 textbox과 버튼(초기는 disabled) -->
  <p>
    <input id="textMessage" type="text" disabled="disabled" class="chat-package">
    <button id="sendBtn" disabled="disabled" class="chat-package">Send</button>
  </p>
  <!-- 채팅 내용이 적혀질 채팅 내용 박스 -->
  <p>
    <textarea id="messageTextArea" rows="10" cols="50" disabled="disabled"></textarea>
  </p>
  <!-- Jquery 라이브러리 링크 -->
  <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
    // Javascript 캡슐화
    (function(_) {
    })((function() {
      // WebSocket 변수
      let webSocket = null;
      // WebSocket 접속 함수
      function connect() {
        // 웹 소켓 객체 생성
        webSocket = new WebSocket("ws://localhost:8081/chat");
        // 웹 소켓이 open되면 실행되는 이벤트
        webSocket.onopen = function(message) {
          // 채팅 textbox와 버튼의 disabled 해제
          $(".chat-package").attr("disabled", false);
          // 접속 초기 데이터 작성
          let key = {
            id : $("#username").val(),
            state : 0 // state는 0
          };
          // 접속 메시지 보내기
          webSocket.send(JSON.stringify(key));
        };
        webSocket.onclose = function(message) {
        };
        webSocket.onerror = function(message) {
        };
        // 서버로 부터 메시지가 오면 실행되는 이벤트
        webSocket.onmessage = function(message) {
          // 채팅 내용 박스 객체 취득
          let messageTextArea = document.getElementById("messageTextArea");
          // 데이터 작성
          messageTextArea.value += message.data;
        };
      }
      // 메시지 보내기 함수
      function sendMessage() {
        // 텍스트 박스 객체 취득
        let message = document.getElementById("textMessage");
        // 메시지 전송 객체 만들기
        let key = {
          id : $("#username").val(),
          state : 1, // state는 1
          value : message.value // 메시지 내용
        }
        // 메시지 보내기
        webSocket.send(JSON.stringify(key));
        // 텍스트 박스 초기화
        message.value = "";
      }
      // 로그인 버튼 이벤트
      $("#loginBtn").on("click", function() {
        // 아이디 텍스트 박스에 내용이 없으면
        if ($.trim($("#username").val()) === '') {
          // 에러 표시
          $(".error-message").html("Please input the name textbox.");
          // 함수 종료
          return false;
        }
        // 에러 메시지 삭제
        $(".error-message").html("");
        // 로그인 텍스트 박스와 버튼 disabled
        $(".login-package").attr("disabled", "disabled");
        // 접속
        connect();
      });
      // 채팅 버튼 누르면 메시지 보내기
      $("#sendBtn").on("click", sendMessage);
      // 텍스트 박스에 키가 눌리면 enter함수 실행
      $("#textMessage").on("keydown", enter);
      // 텍스트 박스에서 엔터키가 오면 메시지 전송
      function enter() {
        if (event.keyCode === 13) {
          sendMessage();
          return false;
        }
        return true;
      }
      return {};
    })());
  </script>
</body>
</html>