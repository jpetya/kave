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
		<div class="card">
    		<html:form action="/login" focus="username">
				<label>Username:</label><html:text property="userName" />
				<label>Password:</label><html:password property="password" />
				<div class="errors"><html:errors/></div>
        		<html:submit value="login" />
    		</html:form>
    	</div>
    </body>
</html>