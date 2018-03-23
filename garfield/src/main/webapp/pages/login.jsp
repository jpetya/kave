<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<head>
		<spring:url value="styles/carddesign.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
	</head>
	<body>
		<h2>login source</h2>
		<div style="color:blue">
		<html:errors />
		</div>
		<div class="card">
    		<html:form action="/login" focus="username">
				Username: <html:text property="userName" />    			
        		<br />
        		Password: <html:text property="password" />
        		<html:submit value="login" />
    		</html:form>
    	</div>
    </body>
</html>