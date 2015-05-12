<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>download</title>
<script>
		function getDownloadList(){
			var xmlHttp=new XMLHttpRequest();
			var url="json/file_execute.action";
			xmlHttp.open("GET",url,true);
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4)
					if(xmlHttp.status==200){
						var fileJson=JSON.parse(xmlHttp.responseText).result;
						for(var i=0;i<fileJson.length;i++){
							var file=fileJson[i];
							fileDiv.innerHTML+="<a href='fileDownload.action?uploadFile.filePath="+file.filePath
								+"&uploadFile.fileName="+file.fileName+"'>"+file.fileName+"</a><br/>";
						}
					}
			}
			xmlHttp.send();
		}
	</script>
</head>
<body>
	
</body>
	<div id="fileDiv"></div>
	<script>getDownloadList();</script>
</html>