<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>testPage</title>
<script>
		function showNews(){
			var xmlHttp=new XMLHttpRequest();
			var url="json/news_insert.action?newsPic='111'&newsPicTitle='222'"
					+"&newsTitle='333'&newsAuthor='444'&newsContent='555'";
			url.replace("'","\'");
			xmlHttp.open("GET",url,true);
			xmlHttp.setRequestHeader("Cache-Control","no-cache");
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4){
					if(xmlHttp.status==200){
						var resultJson=JSON.parse(xmlHttp.responseText);
						resultDiv.innerHTML=xmlHttp.responseText;
					}
					else{
						resultDiv.innerHTML="正在查询，请稍候……";
					}
				}
			}
			xmlHttp.send();
		}
	</script>
</head>
<body>
	<form name="newsForm">
	<h3>欢迎查询</h3>
		<input type="button" value="查询" onclick="showNews()">	
	<div id="resultDiv">yg </div>
</form>
</body>
</html>