<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.example.plugins.service.PatientLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.example.plugins.model.Patient"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:actionURL var="updatePatientActionURL" windowState="normal" name="updatePatient">
</portlet:actionURL>
<portlet:actionURL var="getPatientActionURL" windowState="normal" name="getPatient">
<portlet:param name="cmd" value="UPDATE"/>
</portlet:actionURL>
<h2>Mise à jour des informations sur le patient</h2>
<a href="<%=homeURL.toString() %>">Accueil</a><br/><br/>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"patient-update-success")){%>
<liferay-ui:success key="patient-update-success" message="Selected Student information have been updated successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"patient-update-error")){%>
<liferay-ui:error key="patient-update-error" message="There is an Error occured while updating student please try again" />
<%} %>
<%
List<Patient> patientList=PatientLocalServiceUtil.getPatients(0,PatientLocalServiceUtil.getPatientsCount());
Patient selectePatientObject=(Patient)renderRequest.getAttribute("patientObject");
%>
<form action="<%=getPatientActionURL.toString()%>" name="patientForm"  method="POST">
<b>Choisissez l'ID du patient</b><br>
<select name="<portlet:namespace/>patientId" onchange="submitform(this.value);">
<option value="-1">--select--</option>
<%for(Patient patient:patientList){%>
  <option value="<%=patient.getPatientId()%>" <%=selectePatientObject!=null&&selectePatientObject.getPatientId()==patient.getPatientId()?"selected":""%>><%=patient.getPatientId()%></option>
  <%} %>
</select><br>
<%if(selectePatientObject!=null){%>
<b>Nom</b><br/>
<input  type="text" name="<portlet:namespace/>nom" id="<portlet:namespace/>nom" value="<%=selectePatientObject.getNom()%>"/><br/>
<b>Prénom</b><br/>
<input type="text" name="<portlet:namespace/>prenom" id="<portlet:namespace/>prenom" value="<%=selectePatientObject.getPrenom()%>"/><br/>
<b>Age</b><br/>
<input type="text" name="<portlet:namespace/>patientAge" id="<portlet:namespace/>patientAge" value="<%=selectePatientObject.getPatientAge()%>"/><br/>
<b>Genre</b><br/>
<input type="radio" name="<portlet:namespace/>sex" value="1" <%=selectePatientObject.getPatientGenre()==1?"checked":""%>>Male<br>
<input type="radio" name="<portlet:namespace/>sex" value="0" <%=selectePatientObject.getPatientGenre()==0?"checked":""%>>Female<br/>
<b>Addresse</b><br/>
<textarea rows="4" cols="50" name="<portlet:namespace/>patientAddresse">
<%=selectePatientObject.getPatientAddresse()%>
</textarea><br/>
<b>Email</b><br/>
<input  type="text" name="<portlet:namespace/>email" id="<portlet:namespace/>patientEmail" value="<%=selectePatientObject.getPatientEmail()%>"/><br/>
<input type="button" name="updatePatient" id="updatePatient" value="Modifier" onclick="updatePatientRecord();"/>
<%}%>
</form>
<script>
function submitform(selectedValue)
{
  if(selectedValue!="-1"){
	  document.patientForm.submit();  
  }
	
}
function updatePatientRecord()
{ 
	document.patientForm.action="<%=updatePatientActionURL.toString()%>"
    document.patientForm.submit();
}
</script>
