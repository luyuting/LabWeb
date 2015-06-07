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
	</script>
</head>
	<body>
	    <jsp:include page="menu.jsp" />
	    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>饮品录入</h1>
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
		                    		<div class="form-group" id="inputDrinkName">
										<label class="col-sm-2 control-label" for="drinkName" > <big>饮品名</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="drinkName" 
									    		placeholder="添加饮品名称" oninput="checkDrinkName(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputDrinkPic" >
										<label class="col-sm-2 control-label" for="drinkPic" > <big>图&nbsp;&nbsp;片</big></label>
										<div class="col-sm-3">
									    	<input type="file" style="height:1.43;line-height:1.43;" id="drinkPic">
									    </div>
									</div>
									<div class="form-group" id="inputDrinkOriPrice">
										<label class="col-sm-2 control-label" for="drinkOriPrice" > <big>价&nbsp;&nbsp;格</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="drinkOriPrice" 
									    		placeholder="饮品价格" oninput="checkDrinkOriPrice(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputDrinkIntro">
										<label class="col-sm-2 control-label" for="drinkIntro" > <big>简&nbsp;&nbsp;介</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="drinkIntro" 
									    		placeholder="饮品简介" oninput="checkDrinkIntro(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputDrinkIntro">
										<label class="col-sm-2 control-label" for="inputDrinkIntro" > <big>简&nbsp;&nbsp;介</big></label>
										<div class="col-sm-3">
									    	<textarea class="form-control" rows="3" id="drinkIntro" 
									    		placeholder="饮品简介" oninput="checkDrinkIntro(this.value)"></textarea>
									    </div>
									</div>
									<div class="form-group" id="inputDrinkType">
										<label class="col-sm-2 control-label" for="drinkType" > <big>类&nbsp;&nbsp;型</big></label>
										<div class="col-sm-3">
										    <select id="drinkType" class="form-control" style="width:80%;">
										    </select>
										</div>
									</div>
									<div class="form-group" id="output">
			                            <div class="col-sm-2"></div>
			                            <div class="col-sm-3">
			                                <input type="button" class="btn btn-success" onclick="checkForm()" value="添加饮品"/>
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
