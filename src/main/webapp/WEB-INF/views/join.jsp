<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/join.css" type="text/css">
    <title>EDT</title>
    <script src="resources/js/jquery.js"></script>
</head>

<body>
    <%@include file="header.jsp"%>
    
    <div id="joinPage">
    	<form action="#" id="joinForm">
    		<fieldset class="inputField">
    			<legend>IN THE EDT#_INFO</legend>
				<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="ID"/>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input type="text" name="pw1"/>
					</td>
				</tr>
				<tr>
					<td>Password check</td>
					<td>
						<input type="text" name="pw2"/>
					</td>
				</tr>
				<tr>
					<td>Nickname</td>
					<td>
						<input type="text" name="nickname"/>
					</td>
				</tr>
				<tr>
					<td>Profile</td>
					<td>
						<input type="file" name="profile"/>
					</td>
				</tr>
				</table>	
    		</fieldset>
    		
    		<fieldset class="inputField">
 	    		<legend>OUT THE EDT#_INFO</legend>
 	    						<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="ID"/>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input type="text" name="pw1"/>
					</td>
				</tr>
				<tr>
					<td>Password check</td>
					<td>
						<input type="text" name="pw2"/>
					</td>
				</tr>
				<tr>
					<td>Nickname</td>
					<td>
						<input type="text" name="nickname"/>
					</td>
				</tr>
				<tr>
					<td>Profile</td>
					<td>
						<input type="file" name="profile"/>
					</td>
				</tr>
				</table>

    		</fieldset>
    	</form>
    </div>
    
    <%@include file="footer.jsp"%>
</body>
</html>