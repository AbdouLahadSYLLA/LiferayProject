package com.example.plugins.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patient}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
public class PatientWrapper implements Patient, ModelWrapper<Patient> {
    private Patient _patient;

    public PatientWrapper(Patient patient) {
        _patient = patient;
    }

    @Override
    public Class<?> getModelClass() {
        return Patient.class;
    }

    @Override
    public String getModelClassName() {
        return Patient.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("patientId", getPatientId());
        attributes.put("nom", getNom());
        attributes.put("prenom", getPrenom());
        attributes.put("patientAge", getPatientAge());
        attributes.put("patientGenre", getPatientGenre());
        attributes.put("patientAddresse", getPatientAddresse());
        attributes.put("patientEmail", getPatientEmail());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long patientId = (Long) attributes.get("patientId");

        if (patientId != null) {
            setPatientId(patientId);
        }

        String nom = (String) attributes.get("nom");

        if (nom != null) {
            setNom(nom);
        }

        String prenom = (String) attributes.get("prenom");

        if (prenom != null) {
            setPrenom(prenom);
        }

        Integer patientAge = (Integer) attributes.get("patientAge");

        if (patientAge != null) {
            setPatientAge(patientAge);
        }

        Integer patientGenre = (Integer) attributes.get("patientGenre");

        if (patientGenre != null) {
            setPatientGenre(patientGenre);
        }

        String patientAddresse = (String) attributes.get("patientAddresse");

        if (patientAddresse != null) {
            setPatientAddresse(patientAddresse);
        }

        String patientEmail = (String) attributes.get("patientEmail");

        if (patientEmail != null) {
            setPatientEmail(patientEmail);
        }
    }

    /**
    * Returns the primary key of this patient.
    *
    * @return the primary key of this patient
    */
    @Override
    public long getPrimaryKey() {
        return _patient.getPrimaryKey();
    }

    /**
    * Sets the primary key of this patient.
    *
    * @param primaryKey the primary key of this patient
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _patient.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the patient ID of this patient.
    *
    * @return the patient ID of this patient
    */
    @Override
    public long getPatientId() {
        return _patient.getPatientId();
    }

    /**
    * Sets the patient ID of this patient.
    *
    * @param patientId the patient ID of this patient
    */
    @Override
    public void setPatientId(long patientId) {
        _patient.setPatientId(patientId);
    }

    /**
    * Returns the nom of this patient.
    *
    * @return the nom of this patient
    */
    @Override
    public java.lang.String getNom() {
        return _patient.getNom();
    }

    /**
    * Sets the nom of this patient.
    *
    * @param nom the nom of this patient
    */
    @Override
    public void setNom(java.lang.String nom) {
        _patient.setNom(nom);
    }

    /**
    * Returns the prenom of this patient.
    *
    * @return the prenom of this patient
    */
    @Override
    public java.lang.String getPrenom() {
        return _patient.getPrenom();
    }

    /**
    * Sets the prenom of this patient.
    *
    * @param prenom the prenom of this patient
    */
    @Override
    public void setPrenom(java.lang.String prenom) {
        _patient.setPrenom(prenom);
    }

    /**
    * Returns the patient age of this patient.
    *
    * @return the patient age of this patient
    */
    @Override
    public int getPatientAge() {
        return _patient.getPatientAge();
    }

    /**
    * Sets the patient age of this patient.
    *
    * @param patientAge the patient age of this patient
    */
    @Override
    public void setPatientAge(int patientAge) {
        _patient.setPatientAge(patientAge);
    }

    /**
    * Returns the patient genre of this patient.
    *
    * @return the patient genre of this patient
    */
    @Override
    public int getPatientGenre() {
        return _patient.getPatientGenre();
    }

    /**
    * Sets the patient genre of this patient.
    *
    * @param patientGenre the patient genre of this patient
    */
    @Override
    public void setPatientGenre(int patientGenre) {
        _patient.setPatientGenre(patientGenre);
    }

    /**
    * Returns the patient addresse of this patient.
    *
    * @return the patient addresse of this patient
    */
    @Override
    public java.lang.String getPatientAddresse() {
        return _patient.getPatientAddresse();
    }

    /**
    * Sets the patient addresse of this patient.
    *
    * @param patientAddresse the patient addresse of this patient
    */
    @Override
    public void setPatientAddresse(java.lang.String patientAddresse) {
        _patient.setPatientAddresse(patientAddresse);
    }

    /**
    * Returns the patient email of this patient.
    *
    * @return the patient email of this patient
    */
    @Override
    public java.lang.String getPatientEmail() {
        return _patient.getPatientEmail();
    }

    /**
    * Sets the patient email of this patient.
    *
    * @param patientEmail the patient email of this patient
    */
    @Override
    public void setPatientEmail(java.lang.String patientEmail) {
        _patient.setPatientEmail(patientEmail);
    }

    @Override
    public boolean isNew() {
        return _patient.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _patient.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _patient.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _patient.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _patient.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _patient.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _patient.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _patient.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _patient.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _patient.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _patient.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PatientWrapper((Patient) _patient.clone());
    }

    @Override
    public int compareTo(com.example.plugins.model.Patient patient) {
        return _patient.compareTo(patient);
    }

    @Override
    public int hashCode() {
        return _patient.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.example.plugins.model.Patient> toCacheModel() {
        return _patient.toCacheModel();
    }

    @Override
    public com.example.plugins.model.Patient toEscapedModel() {
        return new PatientWrapper(_patient.toEscapedModel());
    }

    @Override
    public com.example.plugins.model.Patient toUnescapedModel() {
        return new PatientWrapper(_patient.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _patient.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _patient.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _patient.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PatientWrapper)) {
            return false;
        }

        PatientWrapper patientWrapper = (PatientWrapper) obj;

        if (Validator.equals(_patient, patientWrapper._patient)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Patient getWrappedPatient() {
        return _patient;
    }

    @Override
    public Patient getWrappedModel() {
        return _patient;
    }

    @Override
    public void resetOriginalValues() {
        _patient.resetOriginalValues();
    }
}
