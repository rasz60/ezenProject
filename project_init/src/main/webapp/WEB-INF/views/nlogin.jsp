<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<!-- naver login script -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script>


</script>
</head>

<body>

<form action="/init/login" method="post" id="loginFrm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" id="naverId" name="uid" />
	<input type="hidden" id="naverPw" name="upw"/>
	<button type="button" id="nloginBtn"></button>
</form>

<script>

const naverLogin = new naver.LoginWithNaverId(
	{
		clientId : 'wbrACOZjnqrurUANjevI',
		callbackUrl : 'https://localhost:8443/init/nlogin'
	}	
);

naverLogin.init();

// 페이지 로드가 완료되면 실행
window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		
		// 네이버 로그인 api를 호출하여 userinfo를 불러오는데 성공했을 경우
		if (status) {
			var userId = naverLogin.user.getEmail();
			var userPwd = naverLogin.user.getId();
				
			$.ajax({
				url: '/init/user/emailCheck',
				type: 'get',
				data: {id : userId},
				success: function(data) {
					if( data > 0 ) {
						$('#naverId').val(userId);
						$('#naverPw').val(userPwd);
						
						$('#loginFrm').submit();
					} else {
						location.href = '/init/user/socialjoin?userId='+ userId + '&userPwd=' + userPwd; 
					}
				},
				
				error: function() {
					console.log("callback 처리에 실패하였습니다.");
					location.href = '/init'
				}
				
			})
			
		} else {
			console.log("callback 처리에 실패하였습니다.");
			location.href = '/init'
		}
	});
});

</script>


</body>
</html>