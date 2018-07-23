package com.example.plugins.model.impl;

import com.example.plugins.model.Course;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Externalizable {
    public long courseId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(3);

        sb.append("{courseId=");
        sb.append(courseId);

        return sb.toString();
    }

    @Override
    public Course toEntityModel() {
        CourseImpl courseImpl = new CourseImpl();

        courseImpl.setCourseId(courseId);

        courseImpl.resetOriginalValues();

        return courseImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        courseId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(courseId);
    }
}
