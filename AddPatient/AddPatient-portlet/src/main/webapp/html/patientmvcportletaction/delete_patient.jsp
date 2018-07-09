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
<portlet:actionURL var="deletePatientActionURL" windowState="normal" name="deletePatient">
</portlet:actionURL>
<portlet:actionURL var="getPatientActionURL" windowState="normal" name="getPatient">
<portlet:param name="cmd" value="DELETE"/>
</portlet:actionURL>
<h2>Suppression Patient</h2>
<a href="<%=homeURL.toString() %>">Accueil</a><br/><br/>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"patient-delete-success")){%>
<liferay-ui:success key="patient-delete-success" message="Selected Student information have been deleted successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"patient-delete-error")){%>
<liferay-ui:error key="patient-delete-error" message="There is an Error occured while deleting student please try again" />
<%} %>
<%
List<Patient> patientList=PatientLocalServiceUtil.getPatients(0,PatientLocalServiceUtil.getPatientsCount());
Patient selectePatientObject=(Patient)renderRequest.getAttribute("patientObject");
%>
<form action="<%=getPatientActionURL.toString()%>" name="patientForm"  method="POST">
<b>Choisissez l'ID du patient </b><br>
<select name="<portlet:namespace/>patientId" onchange="submitform(this.value);">
<option value="-1">--select--</option>
<%for(Patient patient:patientList){%>
  <option value="<%=patient.getPatientId()%>" <%=selectePatientObject!=null&&selectePatientObject.getPatientId()==patient.getPatientId()?"selected":""%>><%=patient.getPatientId()%></option>
  <%} %>
</select><br>
<%if(selectePatientObject!=null){%>
Patient Nom:<%=selectePatientObject.getNom()+"&nbsp;"+selectePatientObject.getNom()%><br/>
Patient Age: <%=selectePatientObject.getPatientAge() %><br/>
Patient Sexe: <%=selectePatientObject.getPatientGenre()==1?"Male":"Famale"%><br/>
Address: <%=selectePatientObject.getPatientAddresse()%><br/>
Patient Email:<%=selectePatientObject.getPatientEmail()%><br/>
<input type="button" name="deletePatient" id="addPatient" value="Spprimer" onclick="deletePatientRecord();"/>
<%}%>
</form>
<script>
function submitform(selectedValue)
{
  if(selectedValue!="-1"){
	  document.patientForm.submit();  
  }
	
}
function deletePatientRecord()
{ 
	document.patientForm.action="<%=deletePatientActionURL.toString()%>"
    document.patientForm.submit();
}
</script>
