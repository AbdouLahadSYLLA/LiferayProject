<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<portlet:defineObjects />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:actionURL var="addPatientActionURL" windowState="normal" name="addPatient">
</portlet:actionURL>


<% if(SessionMessages.contains(renderRequest.getPortletSession(),"patient-add-success")){%>
<liferay-ui:success key="patient-add-success" message="Les informations sur les patients ont été bien enregistrées avec succès." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"patient-add-error")){%>
<liferay-ui:error key="patient-add-error" message="Le patient a été trouvé avec succès" />
<%} %>


<h2>Veuillez remplir ce formulaire pour ajouter un patient</h2>
<a href="<%=homeURL.toString() %>">Accueil</a><br/><br/>
<form action="<%=addPatientActionURL%>" name="patientForm"  method="POST">
<b>Nom</b><br/>
<input  type="text" name="<portlet:namespace/>nom" id="<portlet:namespace/>nom"/><br/>
<b>Prénom</b><br/>
<input type="text" name="<portlet:namespace/>prenom" id="<portlet:namespace/>prenom"/><br/>
<b>Age</b><br/>
<input type="text" name="<portlet:namespace/>Age" id="<portlet:namespace/>patientAge"/><br/>
<b>Sexe</b><br/>
<input type="radio" name="<portlet:namespace/>sex" value="1">Male<br>
<input type="radio" name="<portlet:namespace/>sex" value="0">Female<br/>
<b>Addresse</b><br/>
<textarea rows="4" cols="50" name="<portlet:namespace/>patientAddresse">
</textarea><br/>
<b>Email</b><br/>
<input type="text" name="<portlet:namespace/>email" id="<portlet:namespace/>patientEmail"/><br/>

<input type="submit" name="addPatient" id="addPatient" value="Ajouter Patient"/>
</form>