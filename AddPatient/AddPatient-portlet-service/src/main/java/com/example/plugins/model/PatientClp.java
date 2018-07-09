package com.example.plugins.model;

import com.example.plugins.service.ClpSerializer;
import com.example.plugins.service.PatientLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class PatientClp extends BaseModelImpl<Patient> implements Patient {
    private long _patientId;
    private String _nom;
    private String _prenom;
    private int _patientAge;
    private int _patientGenre;
    private String _patientAddresse;
    private String _patientEmail;
    private BaseModel<?> _patientRemoteModel;
    private Class<?> _clpSerializerClass = com.example.plugins.service.ClpSerializer.class;

    public PatientClp() {
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
    public long getPrimaryKey() {
        return _patientId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPatientId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _patientId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getPatientId() {
        return _patientId;
    }

    @Override
    public void setPatientId(long patientId) {
        _patientId = patientId;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPatientId", long.class);

                method.invoke(_patientRemoteModel, patientId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNom() {
        return _nom;
    }

    @Override
    public void setNom(String nom) {
        _nom = nom;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setNom", String.class);

                method.invoke(_patientRemoteModel, nom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPrenom() {
        return _prenom;
    }

    @Override
    public void setPrenom(String prenom) {
        _prenom = prenom;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPrenom", String.class);

                method.invoke(_patientRemoteModel, prenom);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPatientAge() {
        return _patientAge;
    }

    @Override
    public void setPatientAge(int patientAge) {
        _patientAge = patientAge;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPatientAge", int.class);

                method.invoke(_patientRemoteModel, patientAge);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPatientGenre() {
        return _patientGenre;
    }

    @Override
    public void setPatientGenre(int patientGenre) {
        _patientGenre = patientGenre;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPatientGenre", int.class);

                method.invoke(_patientRemoteModel, patientGenre);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPatientAddresse() {
        return _patientAddresse;
    }

    @Override
    public void setPatientAddresse(String patientAddresse) {
        _patientAddresse = patientAddresse;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPatientAddresse",
                        String.class);

                method.invoke(_patientRemoteModel, patientAddresse);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPatientEmail() {
        return _patientEmail;
    }

    @Override
    public void setPatientEmail(String patientEmail) {
        _patientEmail = patientEmail;

        if (_patientRemoteModel != null) {
            try {
                Class<?> clazz = _patientRemoteModel.getClass();

                Method method = clazz.getMethod("setPatientEmail", String.class);

                method.invoke(_patientRemoteModel, patientEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getPatientRemoteModel() {
        return _patientRemoteModel;
    }

    public void setPatientRemoteModel(BaseModel<?> patientRemoteModel) {
        _patientRemoteModel = patientRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _patientRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_patientRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            PatientLocalServiceUtil.addPatient(this);
        } else {
            PatientLocalServiceUtil.updatePatient(this);
        }
    }

    @Override
    public Patient toEscapedModel() {
        return (Patient) ProxyUtil.newProxyInstance(Patient.class.getClassLoader(),
            new Class[] { Patient.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        PatientClp clone = new PatientClp();

        clone.setPatientId(getPatientId());
        clone.setNom(getNom());
        clone.setPrenom(getPrenom());
        clone.setPatientAge(getPatientAge());
        clone.setPatientGenre(getPatientGenre());
        clone.setPatientAddresse(getPatientAddresse());
        clone.setPatientEmail(getPatientEmail());

        return clone;
    }

    @Override
    public int compareTo(Patient patient) {
        int value = 0;

        if (getPatientId() < patient.getPatientId()) {
            value = -1;
        } else if (getPatientId() > patient.getPatientId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PatientClp)) {
            return false;
        }

        PatientClp patient = (PatientClp) obj;

        long primaryKey = patient.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{patientId=");
        sb.append(getPatientId());
        sb.append(", nom=");
        sb.append(getNom());
        sb.append(", prenom=");
        sb.append(getPrenom());
        sb.append(", patientAge=");
        sb.append(getPatientAge());
        sb.append(", patientGenre=");
        sb.append(getPatientGenre());
        sb.append(", patientAddresse=");
        sb.append(getPatientAddresse());
        sb.append(", patientEmail=");
        sb.append(getPatientEmail());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.example.plugins.model.Patient");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>patientId</column-name><column-value><![CDATA[");
        sb.append(getPatientId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nom</column-name><column-value><![CDATA[");
        sb.append(getNom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>prenom</column-name><column-value><![CDATA[");
        sb.append(getPrenom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>patientAge</column-name><column-value><![CDATA[");
        sb.append(getPatientAge());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>patientGenre</column-name><column-value><![CDATA[");
        sb.append(getPatientGenre());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>patientAddresse</column-name><column-value><![CDATA[");
        sb.append(getPatientAddresse());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>patientEmail</column-name><column-value><![CDATA[");
        sb.append(getPatientEmail());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
