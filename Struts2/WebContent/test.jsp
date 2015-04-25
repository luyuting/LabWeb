<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>testPage</title>
</head>
<body>
	<s:actionerror/>
	<s:actionmessage/>
	upload directory:<s:property value="targetFileDir"/><br/>
	<s:iterator value="targetFileNames" status="status">
	--------------------------------------------------<br/>
	file<s:property value="%{#status.index+1}"/>name:
	<s:property value="%{uploadFilesFileName[#status.index]}"/><br/>
	file<s:property value="%{#status.index+1}"/>type:
	<s:property value="%{uploadFilesFileName[#status.index]}"/><br/>
	file<s:property value="%{#status.index+1}"/>new name:
	<s:property value="%{uploadFilesFileName[#status.index]}"/><br/>
	</s:iterator>
	<s:form action="fileUpload" method="post" enctype="multipart/form-data">
		<s:file name="uploadFiles" label="please choose uploadFile1"/>
		<s:file name="uploadFiles" label="please choose uploadFile2"/>
		<s:file name="uploadFiles" label="please choose uploadFile3"/>
		<s:submit value="upload"></s:submit>
	</s:form>
</body>
</html>