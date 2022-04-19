<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<title>Insert title here</title>
<!-- naver login script -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
</head>

<body>


<script>
const naverLogin = new naver.LoginWithNaverId(
	{
		clientId : 'wbrACOZjnqrurUANjevI',
		callbackUrl : 'https://localhost:8443/init/nlogin'
	}	
);

naverLogin.init();

window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var userId = naverLogin.user.getEmail();
			var userPwd = naverLogin.user.getId();
			
			// 가입된 아이디인지 확인
	       	$.ajax({
	       		url: '/init/user/emailCheck',
	       		type: 'get',
	       		data: {id : userId},
	       		success : function(data) {
	       			if ( data > 0 ) {
	       				$('input#userId').val(userId);
	       				$('input#userPwd').val(userPwd);
	       				
	       				$('#ModalLoginBtn').trigger('click');
	       			} else {
	       				location.href = '/init/user/socialjoin?userId='+ userId + '&userPwd=' + userPwd;      				
	       			}
	       		}
	       	});
		
		} else {
			console.log("callback 처리에 실패하였습니다.");
			location.href = '/init'
		}
	});
});



console.log(naverLogin);

</script>

</body>
</html>