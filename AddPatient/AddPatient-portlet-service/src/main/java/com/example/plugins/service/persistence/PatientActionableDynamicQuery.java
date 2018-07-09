package com.example.plugins.service.persistence;

import com.example.plugins.model.Patient;
import com.example.plugins.service.PatientLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class PatientActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PatientActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PatientLocalServiceUtil.getService());
        setClass(Patient.class);

        setClassLoader(com.example.plugins.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("patientId");
    }
}
