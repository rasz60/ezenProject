<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- OAuth2.0 client information -->
<meta name ="google-signin-client_id" content="352601608946-o9mbtka5lvn9c397n93nvjjfn5godf7p.apps.googleusercontent.com">
<link rel="stylesheet" type="text/css" href="/init/css/includes/login_modal.css" />
<!-- naver login script -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

<title>login</title>

</head>

<body>
<input type="hidden" id="loginModalBtn" data-toggle="modal" data-target="#loginModal" value="modal" />

	<!-- modal 창 -->
	<div class="modal fade" id="loginModal" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-sm d-block">
			<button type="button" id="modalCloseBtn" class="btn btn-xl btn-default text-white text-weight-bold display-1 float-right" data-dismiss="modal">&times;</button>
			<div class="modal-content">
				<div class="modal-header d-flex justify-content-around">
					<img src="/init/images/logo.png" alt="" />
				</div>
				
				<div class="modal-body d-flex justify-content-center">
					<form action="/init/login" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="form-group">
							<label for="userId">ID</label>
							<input type="text" class="form-control" id="userId" name="uid" required/>
						</div>
						
						<div class="form-group">
							<label for="userPwd">PASSWORD</label>
							<input type="password" class="form-control"  id="userPwd" name="upw" required/>
						</div>
						
						<a href="#" class="text-secondary findInfo">Find your info <i class="fa-regular fa-circle-question"></i></a>
						
						<div class="form-group" style="visibility:hidden; color:red; font-size:12px;" id="loginError">아이디 혹은 비밀번호가 잘못 입력되었습니다.</div>
						
						<div class="row mx-0">
							<button type="button" id="glogin" class="btn btn-sm btn-light col-4 border-white"><i class="fa-brands fa-google"></i></button>
							<button type="button" id="naverIdLogin" class="d-none"><i class="fa-solid fa-n"></i></button>
							<button type="button" id="naverIdLogin_loginButton" class="btn btn-sm btn-success col-4 border-white font-white"><i class="fa-solid fa-n"></i></button>
							<button type="button" id="klogin" class="btn btn-sm btn-warning col-4 border-white"><i class="fa-solid fa-k"></i></button>
							<button type="submit" id="ModalLoginBtn" class="btn btn-sm btn-primary col-6 border-white">Login</button>
							<a href="user/join_view" id="joinBtn" class="btn btn-sm btn-dark col-6 border-white">Join Us</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
<!-- google login script -->
<script>

// google social login first method
function init() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
		options = new gapi.auth2.SigninOptionsBuilder();
		options.setPrompt('select_account');
		options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
		gapi.auth2.getAuthInstance().attachClickHandler('glogin', options, onSignIn, onSignInFailure);
	})
}

//성공시 실행
function onSignIn(googleUser) {
	var access_token = googleUser.getAuthResponse().access_token
	$.ajax({
    	// people api를 이용하여 프로필 및 생년월일에 대한 선택동의후 가져온다.
		url: 'https://people.googleapis.com/v1/people/me',
		data: {personFields:'birthdays', key:'AIzaSyCqJKxsFVy_l2XseYjjL7YRlAM45IViwzk', 'access_token': access_token},
		method:'GET'
	})
	.done(function(e){
        //프로필을 가져온다.
		var profile = googleUser.getBasicProfile();
		        
        // 구글에서 제공하는 프로필 정보 저장
       	var userId = profile.Hv;
       	var userPwd = profile.fX;

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
       	})
	})
	.fail(function(e){
		console.log(e);
	})
}

// 실패시 실행
function onSignInFailure(t){		
	console.log(t);
}
</script>
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<script>

	$('#naverIdLogin_loginButton').click(function () {
		$('#naverIdLogin').trigger('click');
	});


	const naverLogin = new naver.LoginWithNaverId(
		{
			clientId : 'wbrACOZjnqrurUANjevI',
			callbackUrl : 'https://localhost:8443/init/nlogin'
		}	
	);
	
	naverLogin.init();
	


	
</script>







</body>
</html>