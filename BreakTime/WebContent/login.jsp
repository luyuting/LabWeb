<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<% 
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + path;
%>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BreakTime后台管理系统</title>
        <base href="<%=basePath%>">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/bootstrap-v2-2-1.min.css">
        <link rel="stylesheet" href="./css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="./css/unicorn.login.css">
   		<style type="text/css" media="screen">
    		*,input{
    			font-family:"Microsoft YaHei";
    		}
    	</style>
        <script src="./js/jquery.min.js"></script>  
        <script src="./js/unicorn.login.js"></script>
        <script>
			$(document).ready(function (){
				$("#loginSubmit").click(function (){
					var params = {
							"admin.name" : document.getElementsByName("name")[0].value,
							"admin.password" : document.getElementsByName("password")[0].value
					};
					$.ajax({
						type : "post",
						url : "admin_json/checkAdminPasswordAction.action",
						data : params,
						dataType : "text",
						success : function(json){
							var obj = $.parseJSON(json);
							if(obj.result == "密码正确"){
								document.getElementById("errorMSG").innerHTML=obj.result;
								window.location.href="admin/admin.action";
							}
							else{
								document.getElementById("errorMSG").innerHTML=obj.result;
							}
						},
						error : function(json){
							alert("error " + json);
						}
					});
				});
			});
		</script>
    </head>
    <body>
        <div id="logo">
            <img src="./img/logo.png" alt="">
        </div>
        <div id="loginbox">
            <form id="loginform" class="form-vertical" action="admin/main.action" method="post">
                <p>管理员登录</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" name="name" placeholder="AdminName">
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="Password">
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <div class="pull-left">
	                    <div class="checkbox">
	                    	<label>
	                        	<input type="checkbox" name="userCookie" value="true"> 记住我一周
	                      	</label>
	                    </div>
                    </div>
                    <font color="red"><span id="errorMSG"></span></font>
                    <span class="pull-right"><input type="button" class="btn btn-inverse" value="Login" id="loginSubmit"></span>
                </div>
            </form>
        </div>
</body></html>