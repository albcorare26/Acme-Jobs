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

	<acme:form-textarea code="worker.xxxx-answer.form.label.description" path="description"/>	
	<acme:form-textbox code="worker.xxxx-answer.form.label.moreInfo" path="moreInfo"/>
	<acme:form-password code="worker.xxxx-answer.form.label.password" path="password"/>
	<acme:form-hidden path="applicationid"/>

	<acme:form-submit test="${command == 'show' }"
		code="worker.xxxx-answer.form.button.update" 
		action="/worker/xxxx-answer/update"/>
		
	<acme:form-submit test="${command == 'show' }"
		code="worker.xxxx-answer.form.button.delete" 
		action="/worker/xxxx-answer/delete"/>
		
	<acme:form-submit test="${command == 'create' }"
		code="worker.xxxx-answer.form.button.create" 
		action="/worker/xxxx-answer/create"/>
		
	<acme:form-submit test="${command == 'update' }"
		code="worker.xxxx-answer.form.button.update" 
		action="/worker/xxxx-answer/update"/>
		
	<acme:form-submit test="${command == 'delete' }"
		code="worker.xxxx-answer.form.button.delete" 
		action="/worker/xxxx-answer/delete"/>
		
	<acme:form-return code="worker.xxxx-answer.form.button.return"/>
</acme:form> 