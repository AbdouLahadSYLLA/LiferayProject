package com.example.plugins.model.impl;

import com.example.plugins.model.Patient;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Patient
 * @generated
 */
public class PatientCacheModel implements CacheModel<Patient>, Externalizable {
    public long patientId;
    public String nom;
    public String prenom;
    public int patientAge;
    public int patientGenre;
    public String patientAddresse;
    public String patientEmail;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{patientId=");
        sb.append(patientId);
        sb.append(", nom=");
        sb.append(nom);
        sb.append(", prenom=");
        sb.append(prenom);
        sb.append(", patientAge=");
        sb.append(patientAge);
        sb.append(", patientGenre=");
        sb.append(patientGenre);
        sb.append(", patientAddresse=");
        sb.append(patientAddresse);
        sb.append(", patientEmail=");
        sb.append(patientEmail);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Patient toEntityModel() {
        PatientImpl patientImpl = new PatientImpl();

        patientImpl.setPatientId(patientId);

        if (nom == null) {
            patientImpl.setNom(StringPool.BLANK);
        } else {
            patientImpl.setNom(nom);
        }

        if (prenom == null) {
            patientImpl.setPrenom(StringPool.BLANK);
        } else {
            patientImpl.setPrenom(prenom);
        }

        patientImpl.setPatientAge(patientAge);
        patientImpl.setPatientGenre(patientGenre);

        if (patientAddresse == null) {
            patientImpl.setPatientAddresse(StringPool.BLANK);
        } else {
            patientImpl.setPatientAddresse(patientAddresse);
        }

        if (patientEmail == null) {
            patientImpl.setPatientEmail(StringPool.BLANK);
        } else {
            patientImpl.setPatientEmail(patientEmail);
        }

        patientImpl.resetOriginalValues();

        return patientImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        patientId = objectInput.readLong();
        nom = objectInput.readUTF();
        prenom = objectInput.readUTF();
        patientAge = objectInput.readInt();
        patientGenre = objectInput.readInt();
        patientAddresse = objectInput.readUTF();
        patientEmail = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(patientId);

        if (nom == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(nom);
        }

        if (prenom == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(prenom);
        }

        objectOutput.writeInt(patientAge);
        objectOutput.writeInt(patientGenre);

        if (patientAddresse == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(patientAddresse);
        }

        if (patientEmail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(patientEmail);
        }
    }
}
