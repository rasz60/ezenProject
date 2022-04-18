<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<link rel="stylesheet" type="text/css" href="/init/css/includes/login_modal.css" />
<title>login</title>
<style>

h3.display-4 {
	font-size: 30px;
}

p.infoPincheck, p.infoPwdcheck, p.infoPwdcheck2 {
	font-size: 12px;
}
</style>
</head>

<body>
<input type="hidden" id="findInfoModalBtn" data-toggle="modal" data-target="#findInfoModal" value="modal" />

	<!-- modal 창 -->
	<div class="modal fade" id="findInfoModal" role="dialog">
		<div class="modal-dialog modal-dialog-centered modal-sm d-block">
			<button type="button" id="findCloseBtn" class="btn btn-xl btn-default text-white text-weight-bold display-1 float-right" data-dismiss="modal">&times;</button>
			<div class="modal-content" style="height: auto;">
				<div class="modal-header d-flex justify-content-around">
					<img src="/init/images/logo.png" alt="" />
				</div>
				
				<div class="modal-body d-flex justify-content-center">
					<%-- first. id 찾기 --%>
					<div class="findIdBox">
						<h3 class="col-12 font-italic display-4">FIND YOUR INFO</h3>
						<hr />
					
						<div class="form-group">
							<label for="userId">ID</label>
							<input type="text" class="form-control" id="findId" name="fid" required/>
						</div>
						
						<div class="form-group pinbox">
							<label for="pincheck">PIN</label>
							<input type="text" class="form-control" id="pincheck" name="pinNum" required readonly/>
							<p class="infoPincheck font-italic text-danger"></p>
						</div>
						
						<hr />
						
						<div class="d-flex justify-content-end">
							<button type="button" class="findBtn btn btn-sm btn-primary col-3 border-white">find</button>
						</div>
					</div>


					<%-- second. password 찾기 --%>
					<div class="findPwdBox d-none">
						<h3 class="col-12 font-italic display-4">NEW PASSWORD</h3>
						<hr />
					
						<div class="form-group">
							<label for="userPwd">PASSWORD</label>
							<input type="password" class="form-control" id="userPwdCheck1" name="npw" required/>
							<p class="infoPwdcheck font-italic"></p>
						</div>
	
						<div class="form-group">
							<label for="userPwdCheck">PASSWORD CHECK</label>
							<input type="password" class="form-control" id="userPwdCheck2" name="npwc" required readonly/>
							<p class="infoPwdcheck2 font-italic"></p>
						</div>
						
						<hr />
						
						<div class="d-flex justify-content-end">
							<button type="submit" class="changeBtn btn btn-sm btn-primary col-3 border-white" disabled>change</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>

$('.findBtn').click(function() {
	var fid = $('input#findId').val();
	var emailRex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

	if ( fid == null || fid == '' || fid.match(emailRex) == null) {
		alert('email 형식의 id를 입력해주세요.');
		return false;
		
	} else {
		$.ajax({
			url: '/init/user/emailCheck',
			type: 'get',
			data: { id : fid },
			success : function(data) {
				if ( data > 0 ) {
					alert('입력하신 이메일 주소로 Pin 번호를 전송했습니다.');
					
					$('p.infoPincheck').text('메일 주소로 전송된 pin번호를 입력해주세요.');
					$('input#findId').attr('readonly', true);
					$('input#pincheck').attr('readonly', false);
					$('button.findBtn').addClass('d-none');
					$('p.infoPincheck').removeClass('d-none');
					var pinNum = '';
					
					$.ajax({
						url: '/init/mail/findInfo',
						type: 'get',
						data: { email : fid },
						success : function(data) {
							pinNum = data;
						},
						error : function() {
							alert('서버 문제로 아이디 확인에 실패했습니다. 죄송합니다.');
							return false;
						}
					});
					
					$('input#pincheck').keyup(function() {
						var pinNumber = $('input#pincheck').val();
						
						if ( pinNum == pinNumber ) {
							alert('메일 인증이 완료되었습니다.');
							$('.findIdBox').addClass('d-none');
							$('.findPwdBox').removeClass('d-none');
						}						
					});
				} else {
					alert('가입되지 않은 아이디입니다.');
					return false;
				}
			},
			error : function() {
				alert('서버 문제로 아이디 확인에 실패했습니다. 죄송합니다.');
				return false;
			}
		})
		
	}
});


//1차 비밀번호 유효성검사
$('#userPwdCheck1').keyup(function () {
	var val = $('#userPwdCheck1').val();
    const regExp_pw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&^])[A-Za-z\d$@$!%*#?&^]{8,}$/;
    
    if (regExp_pw.test(val) == false) {
    	$('.infoPwdcheck').css('color', 'red');
        $('.infoPwdcheck').text('영문,숫자,특수문자를 혼합하여 8자 이상 16자 이하로 입력해주세요.');
        $('.changeBtn').attr('disabled', true);
    } else {
    	$('.infoPwdcheck').css('color', 'green');
        $('.infoPwdcheck').text('사용가능한 비밀번호 입니다.');
        $('#userPwdCheck2').attr('readonly', false); //1차 pw 형식 맞으면 2차 pw readonly false(입력가능)

        
        //2차 비밀번호 유효성검사
        $('#userPwdCheck2').keyup(function () {
            var checkVal = $('#userPwdCheck2').val();

            if (checkVal != ''){ //2차 pw 입력값 없을땐 validation 메세지 아무것도 안뜸
        		if (val != checkVal) {
        			$('.infoPwdcheck2').css('color', 'red');
                	$('.infoPwdcheck2').text('동일한 비밀번호를 입력해주세요.');
                	$('.changeBtn').attr('disabled', true);
        		} else {
        			$('.infoPwdcheck2').css('color', 'green');
                	$('.infoPwdcheck2').text('비밀번호가 일치합니다.');
                	$('.changeBtn').attr('disabled', false);
           		}
            }
        }); 
    }
});


$('.changeBtn').click(function() {
	var mail = $('.findIdBox .form-group #findId').val();
	
	console.log(mail);
	
	var password1 = $('#userPwdCheck1').val();
	var password2 = $('#userPwdCheck2').val();
	
	if ( password1 === password2 ) {
		$.ajax({
			url: '/init/feed/modifyPw',
			type: 'post',
			data: {
				mail : mail,
				npw : password1
			},
			beforeSend: function(xhr){
	 		   	var token = $("meta[name='_csrf']").attr('content');
	 			var header = $("meta[name='_csrf_header']").attr('content');
			        xhr.setRequestHeader(header, token);
			},
			
			success : function(data) {
				if ( data == 'pw-modified' ) {
					alert('새로운 비밀번호 설정에 성공했습니다.');
					$('#findCloseBtn').trigger('click');
				} else {
					alert('서버 문제로 비밀번호 변경에 실패했습니다. 죄송합니다.');
					return false;
				}
			},
			error : function() {
				alert('서버 문제로 비밀번호 변경에 실패했습니다. 죄송합니다.');
				return false;
			}
		})
	}
	

});


$(document).on('hidden.bs.modal', '.modal', function() {
	$('.findIdBox').removeClass('d-none');
	$('.findPwdBox').addClass('d-none');
	$('.findIdBox').removeClass('d-none');
	$('.findIdBox input').val('');
	$('.findIdBox p').text('');
	$('.findPwdBox input').val('');
	$('.findPwdBox p').text('');
	
});


</script>	
	




</body>
</html>