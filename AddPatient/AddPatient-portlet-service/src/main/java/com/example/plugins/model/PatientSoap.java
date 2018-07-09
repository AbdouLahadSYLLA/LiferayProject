package com.example.plugins.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PatientSoap implements Serializable {
    private long _patientId;
    private String _nom;
    private String _prenom;
    private int _patientAge;
    private int _patientGenre;
    private String _patientAddresse;
    private String _patientEmail;

    public PatientSoap() {
    }

    public static PatientSoap toSoapModel(Patient model) {
        PatientSoap soapModel = new PatientSoap();

        soapModel.setPatientId(model.getPatientId());
        soapModel.setNom(model.getNom());
        soapModel.setPrenom(model.getPrenom());
        soapModel.setPatientAge(model.getPatientAge());
        soapModel.setPatientGenre(model.getPatientGenre());
        soapModel.setPatientAddresse(model.getPatientAddresse());
        soapModel.setPatientEmail(model.getPatientEmail());

        return soapModel;
    }

    public static PatientSoap[] toSoapModels(Patient[] models) {
        PatientSoap[] soapModels = new PatientSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PatientSoap[][] toSoapModels(Patient[][] models) {
        PatientSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PatientSoap[models.length][models[0].length];
        } else {
            soapModels = new PatientSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PatientSoap[] toSoapModels(List<Patient> models) {
        List<PatientSoap> soapModels = new ArrayList<PatientSoap>(models.size());

        for (Patient model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PatientSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _patientId;
    }

    public void setPrimaryKey(long pk) {
        setPatientId(pk);
    }

    public long getPatientId() {
        return _patientId;
    }

    public void setPatientId(long patientId) {
        _patientId = patientId;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        _nom = nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public void setPrenom(String prenom) {
        _prenom = prenom;
    }

    public int getPatientAge() {
        return _patientAge;
    }

    public void setPatientAge(int patientAge) {
        _patientAge = patientAge;
    }

    public int getPatientGenre() {
        return _patientGenre;
    }

    public void setPatientGenre(int patientGenre) {
        _patientGenre = patientGenre;
    }

    public String getPatientAddresse() {
        return _patientAddresse;
    }

    public void setPatientAddresse(String patientAddresse) {
        _patientAddresse = patientAddresse;
    }

    public String getPatientEmail() {
        return _patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        _patientEmail = patientEmail;
    }
}
