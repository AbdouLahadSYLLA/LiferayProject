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
<portlet:actionURL var="getPatientActionURL" windowState="normal" name="getPatient">
<portlet:param name="cmd" value="VIEW"/>
</portlet:actionURL>
<h2>Affichage des informations sur les patients</h2>
<a href="<%=homeURL.toString() %>">Accueil</a><br/><br/>
<%
List<Patient> patientList=PatientLocalServiceUtil.getPatients(0,PatientLocalServiceUtil.getPatientsCount());
Patient selectePatientObject=(Patient)renderRequest.getAttribute("patientObject");
%>
<form action="<%=getPatientActionURL.toString()%>" name="patientForm"  method="POST">
<b>Select Student ID</b><br>
<select name="<portlet:namespace/>patientId" onchange="submitform(this.value);">
<option value="-1">--select--</option>
<%for(Patient patient:patientList){%>
  <option value="<%=patient.getPatientId()%>" <%=selectePatientObject!=null&&selectePatientObject.getPatientId()==patient.getPatientId()?"selected":""%>><%=patient.getPatientId()%></option>
  <%} %>
</select><br>
<%if(selectePatientObject!=null){%>
<h3>The following are the selected Student Information</h3><br/>
Patient Name:<%=selectePatientObject.getPrenom()+"&nbsp;"+selectePatientObject.getNom()%><br/>
Student Age: <%=selectePatientObject.getPatientAge() %><br/>
Student Gender: <%=selectePatientObject.getPatientGenre()==1?"Male":"Famale"%><br/>
Address: <%=selectePatientObject.getPatientAddresse()%><br/>
<%}%>
</form>
<script>
function submitform(selectedValue)
{
  if(selectedValue!="-1"){
	  document.studentForm.submit();  
  }
	
}
</script>
