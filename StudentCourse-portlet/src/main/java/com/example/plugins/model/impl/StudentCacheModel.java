package com.example.plugins.model.impl;

import com.example.plugins.model.Student;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {
    public long studentId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(3);

        sb.append("{studentId=");
        sb.append(studentId);

        return sb.toString();
    }

    @Override
    public Student toEntityModel() {
        StudentImpl studentImpl = new StudentImpl();

        studentImpl.setStudentId(studentId);

        studentImpl.resetOriginalValues();

        return studentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        studentId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(studentId);
    }
}
