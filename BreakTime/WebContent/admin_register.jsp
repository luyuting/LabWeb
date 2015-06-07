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

<!-- saved from url=(0021)https://worktile.com/ -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BreakTime后台管理系统</title>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/unicorn.main.css" />
    <link rel="stylesheet" href="css/bootstrap-v2-2-1.min.css">
    <link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
    <script src="js/excanvas.min.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.peity.min.js"></script>
	<script src="js/fullcalendar.min.js"></script>
	<script src="js/unicorn.js"></script>
	<script src="js/unicorn.dashboard.js"></script>
	<script src="js/raphael.js"></script>
    <style type="text/css" media="screen">
    	*,input{
    		font-family:"Microsoft YaHei";
    	}
    </style>
    <script>
    
		function checkAdminAccount(adminAccount){
			if(!(/^[0-9]{8,20}$/.test(adminAccount))){
				var obj = document.getElementById("inputAdminAccount");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputAdminAccount");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkAdminPwd(adminPwd){
			if(!(/^[\w]{8,20}$/.test(adminPwd))){
				var obj = document.getElementById("inputAdminPwd");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputAdminPwd");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkAdminName(adminName){
			if(!(/^[\u4e00-\u9fa5]{1,10}$/.test(adminName))){
				var obj = document.getElementById("inputAdminName");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputAdminName");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		
		function checkForm(){
			var result = true;
			if(checkAdminAccount(document.getElementById("adminAccount").value) == false){
				result = false;
			}
			else if(checkAdminPwd(document.getElementById("adminPwd").value) == false){
				result = false;
			}
			else if(checkAdminName(document.getElementById("adminName").value) == false){
				result = false;
			}
			else{
				sendAdminInfo();
			}
			return result;
		}
		
		function sendAdminInfo(){
			var params = {
				"admin.adminAccount" : document.getElementById("adminAccount").value,
				"admin.adminPassword" : document.getElementById("adminPwd").value,
				"admin.adminName" : document.getElementById("adminName").value
			};
			$.ajax({
				type : "post",
				url : "json/admin_insert.action",
				data : params,
				dataType : "text",
				success : function(json){
					var obj = $.parseJSON(json);
					if(obj.mesg){
						window.location.href="register_success.jsp";
					}
					else{
						alert(obj.result);
					}
				},
				error : function(json){
					alert("error " + json);
				}
			});
		}
	</script>
</head>
	<body>
	    <jsp:include page="menu.jsp" />
	    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>管理员信息录入</h1>
                <div class="btn-group">
                    <a class="btn btn-large tip-bottom" title="Manage Files">
                    	<i class="icon-file"></i>
                    	<span class="label label-important">1</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Users">
                    	<i class="icon-user"></i>
                    	<span class="label label-important">2</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Comments">
                    	<i class="icon-comment"></i>
                    	<span class="label label-important">5</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Orders">
                    	<i class="icon-shopping-cart"></i>
                    	<span class="label label-important">1</span>
                    </a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span11">
                    <div class="alert alert-info">
                        Welcome to the <strong>BreakTime</strong>. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Happy New Year!
                        <a href="#" data-dismiss="alert" class="close">×</a>
                    </div>
                    <div class="widget-box">
                        <div class="span12"></div>
	                    <div class="span12">
		                    <div class="span8">
		                    	<form class="form-horizontal" role="form" >
		                    		<div class="form-group" id="inputAdminAccount">
										<label class="col-sm-2 control-label" for="adminAccount" > <big>账&nbsp;&nbsp;号</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="adminAccount" 
									    		placeholder="添加管理员账号" oninput="checkAdminAccount(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputAdminPwd">
										<label class="col-sm-2 control-label" for="adminPwd" > <big>密&nbsp;&nbsp;码</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="adminPwd"
									    		placeholder="密码8-20位" oninput="checkAdminPwd(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputAdminName">
										<label class="col-sm-2 control-label" for="adminName" > <big>姓&nbsp;&nbsp;名</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="adminName"
									    		placeholder="输入管理员姓名" oninput="checkAdminName(this.value)">
									    </div>
									</div>
									<div class="form-group" id="output">
			                            <div class="col-sm-2"></div>
			                            <div class="col-sm-3">
			                                <input type="button" class="btn btn-success" onclick="checkForm()" value="添加新管理员"/>
			                            </div>
			                        </div>
								</form>
							</div>
		                </div>
		                <div class="span12"></div>
                    </div>                  
                </div>
            </div>

            <div class="row-fluid">
                <div id="footer" class="span12">
                    2015 &copy; BreakTime Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
                </div>
            </div>
        </div>
        <s:debug></s:debug>
        
	</body>
</html>
