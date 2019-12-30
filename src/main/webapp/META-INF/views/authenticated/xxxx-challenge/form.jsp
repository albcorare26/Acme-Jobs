<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textarea code="authenticated.xxxx-challenge.form.label.description" path="description"/>	
	<acme:form-url code="authenticated.xxxx-challenge.form.label.moreInfo" path="moreInfo"/>
	<acme:form-hidden path="jobid"/>

	<acme:form-submit test="${command == 'show' }"
		code="authenticated.xxxx-challenge.form.button.update" 
		action="/authenticated/xxxx-challenge/update"/>
		
	<acme:form-submit test="${command == 'show' }"
		code="authenticated.xxxx-challenge.form.button.delete" 
		action="/authenticated/xxxx-challenge/delete"/>
		
	<acme:form-submit test="${command == 'create' }"
		code="authenticated.xxxx-challenge.form.button.create" 
		action="/authenticated/xxxx-challenge/create"/>
		
	<acme:form-submit test="${command == 'update' }"
		code="authenticated.xxxx-challenge.form.button.update" 
		action="/authenticated/xxxx-challenge/update"/>
		
	<acme:form-submit test="${command == 'delete' }"
		code="authenticated.xxxx-challenge.form.button.delete" 
		action="/authenticated/xxxx-challenge/delete"/>
		
	<acme:form-return code="authenticated.xxxx-challenge.form.button.return"/>
</acme:form> 