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
        <link rel="stylesheet" href="css/bootstrap-v2-2-1.min.css">
        <link rel="stylesheet" href="css/unicorn.main.css" />
        <link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
        <style type="text/css">
        	*,input{
        		font-family:"Microsoft YaHei";
        	}
        	.shortselect{
        		width:80px; background:none; border:none;
				display:block; overflow:hidden;
				border:#61AC36 1px solid; border-right:none; background:url(arrow.gif) #fff no-repeat 62px 1px; display:block;
		    }  
        </style>
        <script>
        	var page = 1;
        	var maxPage = 1;
        	var adminAccount = "";
        	var adminPassword = "";
        	var adminName = "";
        	var checkNum = 0;
        	
        	var arr=["adminAccount", "adminPassword", "adminName"];
        	function addTR(cols){
        		var table = document.getElementById("info");
        		var tr = table.insertRow();
        		        		
        		for(var i = 0; i <= arr.length; i++){
        			var td = tr.insertCell(i);
        			if(i == 0){
        				td.setAttribute("text-align", "center");
        				var newInput = document.createElement("input"); 
        				newInput.type = "checkbox";
        				newInput.name = "delete";
        				newInput.value = cols["adminAccount"];
        				newInput.onchange = function (){
        					updateAdminAccount = this.value;
        					if(this.checked){
        						checkNum ++;
        					}
        					else {
        						checkNum --;
        					}
        					if(checkNum > 0) document.getElementById("deleteAdmin").setAttribute("class", "btn btn-success");
        					else document.getElementById("deleteAdmin").setAttribute("class", "btn btn-danger");
        				}
        				td.appendChild(newInput);
        			}
        			else{
	        			td.setAttribute("text-align", "center");
	        			td.value = cols["adminAccount"];
	        			td.onclick = function (){
	        				//window.location.href="user/user_update.action?stdnum=" + this.value;
	        			}
	        			if(window.navigator.userAgent.toLowerCase().indexOf("firefox")!=-1){
	        				td.textContent = cols[arr[i-1]];
	        			}
	        			else{
	        				td.innerText = cols[arr[i-1]];
	        			}
        			}
        		}
        	}
        	
        	function deleteAdminAjax(adminAccount){
        		var params = {
        			"admin.adminAccount" : adminAccount
        		};
    			$.ajax({
    				type : "post",
    				url : "json/admin_delete.action",
    				data : params,
    				dataType : "text",
    				success : function(json){
    					setInfo();
    				},
    				error : function(json){
    					alert("error " + json);
    				}
    			});
        	}
        	
        	function deleteAdmin(){
        		var objName= document.getElementsByName("delete");
        		for(var i = 0; i < objName.length; i++){
        			var obj = objName[i];
        			if(obj.checked){
        				deleteAdminAjax(obj.value);
        			}
        		}
        		checkNum = 0;
        	}
        	
        	function delTR(){
        		var table = document.getElementById("info");
        		while(table.getElementsByTagName("tr").length > 0){
        			table.removeChild(table.getElementsByTagName("tr")[0]);
        		}
        	}
        	function addSOP(id, text, value){
        		var obj = document.getElementById(id);
        		obj.options.add(new Option(text, value));
        	}
        	
            function removeAllSOP(id){
                var obj=document.getElementById(id);
                obj.options.length=0;
            }
            
            function selectSOP(id, index){
            	 var obj=document.getElementById(id);
            	 obj.value = index;
            }
            
            function choice(){
            	var obj=document.getElementById("pageNum");
            	var index = obj.selectedIndex;
            	var val = obj.options[index].value;
            	page = parseInt(val);
            	setInfo();
            }
        	function prePage(){
        		if(page == 1){
        			return ;
        		}
        		page = page - 1;
        		setInfo();
        	}
        	
        	function nxtPage(){
        		if(page == maxPage){
        			return ;
        		}
        		page = page + 1;
        		setInfo();
        	}
        	

        	function setInfo(){
        		delTR();
        		var params = {
    				"pageIndex" : page,
    				"numPerPage" : 20
    			};
   				$.ajax({
   					type : "post",
   					url : "json/admin_select.action",
   					data : params,
   					dataType : "text",
   					success : function(json){
   						var obj = $.parseJSON(json);
   						maxPage = obj.pageCount;
   						removeAllSOP("pageNum");
   						for(var i = 1; i <= maxPage; i++){
   							addSOP("pageNum", "第 " + i + " 页", i);
   						}
   						selectSOP("pageNum", page);
   						for(var i = 0; i < obj.result.length; i++){
   							addTR(obj.result[i]);
   						}
   						if(page == 1){
   							document.getElementById("prePage").setAttribute("class", "btn btn-danger");
   						}
   						else{
   							document.getElementById("prePage").setAttribute("class", "btn btn-success");
   						}
   						if(page == maxPage){
   							document.getElementById("nxtPage").setAttribute("class", "btn btn-danger");
   						}
   						else{
   							document.getElementById("nxtPage").setAttribute("class", "btn btn-success");
   						}
   						document.getElementById("deleteAdmin").setAttribute("class", "btn btn-danger");
   					},
   					error : function(json){
   						alert("error " + json);
   					}
   				});
        	}
        	
        	window.onload = function () {
        		setInfo();
			}
		</script>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>管理员信息</h1>
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
                        <div class="widget-title">
                        	<span class="icon"><i class="icon-signal"></i></span>
                        	<h5>Site Statistics</h5>
                        	<div class="buttons">
                        		<a href="#" class="btn btn-mini"><i class="icon-refresh"></i> Update data</a>
                        	</div>
                        </div>
                        <div class="span11"> </div>
	                    <div class="span8">
                            <table class="table">
                            	<thead>
		                            <tr>
		                            	<th></th>
					                    <th>账号</th>  
					                    <th>姓名</th>
					                    <th>密码</th>
					                </tr>  
				                </thead>
				                <tbody id="info">
				                </tbody>
                            </table>
                            <div style="float:left" class="form-inline">
	                            <button type="button" class="btn btn-danger" onclick="deleteAdmin()" id="deleteAdmin">删除</button>
                            </div>
                            <div style="float:right" class="form-inline">
	                            <button type="button" class="btn btn-success" onclick="prePage()" id="prePage">上一页</button>
	                            <select id="pageNum" onchange="choice()" class="shortselect"></select>
	                            <button type="button" class="btn btn-success" onclick="nxtPage()" id="nxtPage">下一页</button>
                            </div>
                            
	                    </div>
                    </div>                  
                </div>
            </div>

            <div class="row-fluid">
                <div id="footer" class="span12">
                    2015 &copy; BreakTime Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
                </div>
            </div>
        </div>
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
	</body>
</html>