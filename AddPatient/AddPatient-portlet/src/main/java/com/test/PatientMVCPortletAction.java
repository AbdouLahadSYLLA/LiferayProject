package com.test;

import com.liferay.util.bridges.mvc.MVCPortlet;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.example.plugins.model.impl.PatientImpl;
import com.example.plugins.service.PatientLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.example.plugins.model.Patient;


/**
 * Portlet implementation class PatientMVCPortletAction
 */
public class PatientMVCPortletAction extends MVCPortlet {
 

	
	public void addPatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try{
		String nom = ParamUtil.getString(actionRequest, "nom");
		String prenom = ParamUtil.getString(actionRequest, "prenom");
		int patientAge = ParamUtil.getInteger(actionRequest, "patientAge");
		int patientGenre = ParamUtil.getInteger(actionRequest, "sex",1);
		String patientAddresse = ParamUtil.getString(actionRequest, "patientAddresse");
		String patientEmail = ParamUtil.getString(actionRequest, "patientEmail");
		//add student record
		//create primary key
		long patientId=CounterLocalServiceUtil.increment();
		
		
		//create student persistance object
		Patient patient=null;
		patient=new PatientImpl();
		patient=PatientLocalServiceUtil.createPatient(patientId);
		
		//fill the data in persistance object
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setPatientAge(patientAge);
		patient.setPatientGenre(patientGenre);
		patient.setPatientAddresse(patientAddresse);
		patient.setPatientEmail(patientEmail);
		
		//Add student persistance object to database student table
		patient=PatientLocalServiceUtil.addPatient(patient);
		if(patient!=null){
			
			// adding success message
			SessionMessages.add(actionRequest.getPortletSession(),
					"patient-add-success");
			_log.info("Le patient a été ajouté avec succès");
		}else{
			SessionErrors.add(actionRequest.getPortletSession(),"patient-add-error");
			_log.error("Il y a une erreur dans l'ajout du patient");
		}
		//navigate to add student jsp page
		actionResponse.setRenderParameter("mvcPath",
				"/html/patientmvcportletaction/add_patient.jsp");
		}catch(Exception e){
			SessionErrors.add(actionRequest.getPortletSession(),"patient-add-error");
			e.printStackTrace();
		}
	}
	
	
	
	public void updatePatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long patientId = ParamUtil.getLong(actionRequest,"patientId");
			String nom = ParamUtil.getString(actionRequest, "nom");
			String prenom = ParamUtil.getString(actionRequest, "prenom");
			int patienttAge = ParamUtil.getInteger(actionRequest, "patientAge");
			int patientGenre = ParamUtil.getInteger(actionRequest, "sex",1);
			String patientAddresse = ParamUtil.getString(actionRequest, "patientAddresse");
			String email = ParamUtil.getString(actionRequest, "patientEmail");
			Patient patient=PatientLocalServiceUtil.getPatient(patientId);
			if(patient!=null){
				//fill update information
				patient.setNom(nom);
				patient.setPrenom(prenom);
				patient.setPatientAge(patienttAge);
				patient.setPatientGenre(patientGenre);
				patient.setPatientAddresse(patientAddresse);
				patient=PatientLocalServiceUtil.updatePatient(patient);
				patient.setPatientEmail(email);
				if(patient!=null){
					// adding success message
					SessionMessages.add(actionRequest.getPortletSession(),
							"patient-update-success");
					_log.info("Student have been updated successfylly");
				}else{
					SessionErrors.add(actionRequest.getPortletSession(),"patient-update-error");
					_log.error("There is an Erron in delete Student");
				}
			}else{
				SessionErrors.add(actionRequest.getPortletSession(),"patient-update-error");
				_log.error("Could not find student.");
			}
			//navigate to add student jsp page
			actionResponse.setRenderParameter("mvcPath",
					"/html/patientmvcportletaction/update_patient.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"patient-update-error");
			e.printStackTrace();
		}
	}

	public void getPatient(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long patientId = ParamUtil.getLong(actionRequest,"patientId");
			String cmd=ParamUtil.getString(actionRequest,"cmd");
			Patient patient=PatientLocalServiceUtil.getPatient(patientId);
			if(patient!=null){
				// adding success message
				actionRequest.setAttribute("patientObject",patient);
				_log.info("Le patient a été trouvé avec succès");
			}else{
				_log.error("Patient non trouvé");
			}
			if(cmd.equals("DELETE")){
				//navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/patientmvcportletaction/add_patient.jsp");
			}
			if(cmd.equals("UPDATE")){
				//navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/patientmvcportletaction/update_patient.jsp");
			}
			if(cmd.equals("VIEW")){
				//navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/patientmvcportletaction/view.jsp");
			}
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"patient-add-error");
			e.printStackTrace();
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(Patient.class); 
}
