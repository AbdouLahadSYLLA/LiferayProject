<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<h1>Liferay Service Builder/ Student CRUD Operations</h1>
<portlet:renderURL var="addPatient">
<portlet:param name="mvcPath" value="/html/patientmvcportletaction/add_patient.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="updatePatient">
<portlet:param name="mvcPath" value="/html/patientmvcportletaction/update_patient.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="dislayPatient">
<portlet:param name="mvcPath" value="/html/patientmvcportletaction/display_patient.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="deletePatient">
<portlet:param name="mvcPath" value="/html/patientmvcportletaction/delete_patient.jsp"/>
</portlet:renderURL>
<br/>
<a href="<%=addPatient.toString()%>">Ajouter Patient</a><br/>
<a href="<%=updatePatient.toString()%>">Mise à jour Patient</a><br/>
<a href="<%=deletePatient.toString()%>">Supprimer Patient</a><br/>
<a href="<%=dislayPatient.toString()%>">Afficher Patient</a><br/>
