package com.example.plugins.service.persistence;

import com.example.plugins.NoSuchCourseException;
import com.example.plugins.model.Course;
import com.example.plugins.model.impl.CourseImpl;
import com.example.plugins.model.impl.CourseModelImpl;
import com.example.plugins.service.persistence.CoursePersistence;
import com.example.plugins.service.persistence.StudentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CoursePersistence
 * @see CourseUtil
 * @generated
 */
public class CoursePersistenceImpl extends BasePersistenceImpl<Course>
    implements CoursePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CourseImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_COURSE = "SELECT course FROM Course course";
    private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM Course course";
    private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Course exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CoursePersistenceImpl.class);
    private static Course _nullCourse = new CourseImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Course> toCacheModel() {
                return _nullCourseCacheModel;
            }
        };

    private static CacheModel<Course> _nullCourseCacheModel = new CacheModel<Course>() {
            @Override
            public Course toEntityModel() {
                return _nullCourse;
            }
        };

    @BeanReference(type = StudentPersistence.class)
    protected StudentPersistence studentPersistence;
    protected TableMapper<Course, com.example.plugins.model.Student> courseToStudentTableMapper;

    public CoursePersistenceImpl() {
        setModelClass(Course.class);
    }

    /**
     * Caches the course in the entity cache if it is enabled.
     *
     * @param course the course
     */
    @Override
    public void cacheResult(Course course) {
        EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseImpl.class, course.getPrimaryKey(), course);

        course.resetOriginalValues();
    }

    /**
     * Caches the courses in the entity cache if it is enabled.
     *
     * @param courses the courses
     */
    @Override
    public void cacheResult(List<Course> courses) {
        for (Course course : courses) {
            if (EntityCacheUtil.getResult(
                        CourseModelImpl.ENTITY_CACHE_ENABLED, CourseImpl.class,
                        course.getPrimaryKey()) == null) {
                cacheResult(course);
            } else {
                course.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all courses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CourseImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CourseImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the course.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Course course) {
        EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseImpl.class, course.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Course> courses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Course course : courses) {
            EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
                CourseImpl.class, course.getPrimaryKey());
        }
    }

    /**
     * Creates a new course with the primary key. Does not add the course to the database.
     *
     * @param courseId the primary key for the new course
     * @return the new course
     */
    @Override
    public Course create(long courseId) {
        Course course = new CourseImpl();

        course.setNew(true);
        course.setPrimaryKey(courseId);

        return course;
    }

    /**
     * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param courseId the primary key of the course
     * @return the course that was removed
     * @throws com.example.plugins.NoSuchCourseException if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course remove(long courseId)
        throws NoSuchCourseException, SystemException {
        return remove((Serializable) courseId);
    }

    /**
     * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the course
     * @return the course that was removed
     * @throws com.example.plugins.NoSuchCourseException if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course remove(Serializable primaryKey)
        throws NoSuchCourseException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Course course = (Course) session.get(CourseImpl.class, primaryKey);

            if (course == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(course);
        } catch (NoSuchCourseException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Course removeImpl(Course course) throws SystemException {
        course = toUnwrappedModel(course);

        courseToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(course.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(course)) {
                course = (Course) session.get(CourseImpl.class,
                        course.getPrimaryKeyObj());
            }

            if (course != null) {
                session.delete(course);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (course != null) {
            clearCache(course);
        }

        return course;
    }

    @Override
    public Course updateImpl(com.example.plugins.model.Course course)
        throws SystemException {
        course = toUnwrappedModel(course);

        boolean isNew = course.isNew();

        Session session = null;

        try {
            session = openSession();

            if (course.isNew()) {
                session.save(course);

                course.setNew(false);
            } else {
                session.merge(course);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
            CourseImpl.class, course.getPrimaryKey(), course);

        return course;
    }

    protected Course toUnwrappedModel(Course course) {
        if (course instanceof CourseImpl) {
            return course;
        }

        CourseImpl courseImpl = new CourseImpl();

        courseImpl.setNew(course.isNew());
        courseImpl.setPrimaryKey(course.getPrimaryKey());

        courseImpl.setCourseId(course.getCourseId());

        return courseImpl;
    }

    /**
     * Returns the course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the course
     * @return the course
     * @throws com.example.plugins.NoSuchCourseException if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCourseException, SystemException {
        Course course = fetchByPrimaryKey(primaryKey);

        if (course == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return course;
    }

    /**
     * Returns the course with the primary key or throws a {@link com.example.plugins.NoSuchCourseException} if it could not be found.
     *
     * @param courseId the primary key of the course
     * @return the course
     * @throws com.example.plugins.NoSuchCourseException if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course findByPrimaryKey(long courseId)
        throws NoSuchCourseException, SystemException {
        return findByPrimaryKey((Serializable) courseId);
    }

    /**
     * Returns the course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the course
     * @return the course, or <code>null</code> if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Course course = (Course) EntityCacheUtil.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
                CourseImpl.class, primaryKey);

        if (course == _nullCourse) {
            return null;
        }

        if (course == null) {
            Session session = null;

            try {
                session = openSession();

                course = (Course) session.get(CourseImpl.class, primaryKey);

                if (course != null) {
                    cacheResult(course);
                } else {
                    EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
                        CourseImpl.class, primaryKey, _nullCourse);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
                    CourseImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return course;
    }

    /**
     * Returns the course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param courseId the primary key of the course
     * @return the course, or <code>null</code> if a course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Course fetchByPrimaryKey(long courseId) throws SystemException {
        return fetchByPrimaryKey((Serializable) courseId);
    }

    /**
     * Returns all the courses.
     *
     * @return the courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Course> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of courses
     * @param end the upper bound of the range of courses (not inclusive)
     * @return the range of courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Course> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of courses
     * @param end the upper bound of the range of courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Course> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Course> list = (List<Course>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_COURSE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_COURSE;

                if (pagination) {
                    sql = sql.concat(CourseModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Course>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Course>(list);
                } else {
                    list = (List<Course>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the courses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Course course : findAll()) {
            remove(course);
        }
    }

    /**
     * Returns the number of courses.
     *
     * @return the number of courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_COURSE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the students associated with the course.
     *
     * @param pk the primary key of the course
     * @return the students associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.plugins.model.Student> getStudents(long pk)
        throws SystemException {
        return getStudents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the students associated with the course.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the course
     * @param start the lower bound of the range of courses
     * @param end the upper bound of the range of courses (not inclusive)
     * @return the range of students associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.plugins.model.Student> getStudents(long pk,
        int start, int end) throws SystemException {
        return getStudents(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the students associated with the course.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.plugins.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the course
     * @param start the lower bound of the range of courses
     * @param end the upper bound of the range of courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of students associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.plugins.model.Student> getStudents(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return courseToStudentTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of students associated with the course.
     *
     * @param pk the primary key of the course
     * @return the number of students associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getStudentsSize(long pk) throws SystemException {
        long[] pks = courseToStudentTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the student is associated with the course.
     *
     * @param pk the primary key of the course
     * @param studentPK the primary key of the student
     * @return <code>true</code> if the student is associated with the course; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsStudent(long pk, long studentPK)
        throws SystemException {
        return courseToStudentTableMapper.containsTableMapping(pk, studentPK);
    }

    /**
     * Returns <code>true</code> if the course has any students associated with it.
     *
     * @param pk the primary key of the course to check for associations with students
     * @return <code>true</code> if the course has any students associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsStudents(long pk) throws SystemException {
        if (getStudentsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param studentPK the primary key of the student
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addStudent(long pk, long studentPK) throws SystemException {
        courseToStudentTableMapper.addTableMapping(pk, studentPK);
    }

    /**
     * Adds an association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param student the student
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addStudent(long pk, com.example.plugins.model.Student student)
        throws SystemException {
        courseToStudentTableMapper.addTableMapping(pk, student.getPrimaryKey());
    }

    /**
     * Adds an association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param studentPKs the primary keys of the students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addStudents(long pk, long[] studentPKs)
        throws SystemException {
        for (long studentPK : studentPKs) {
            courseToStudentTableMapper.addTableMapping(pk, studentPK);
        }
    }

    /**
     * Adds an association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param students the students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addStudents(long pk,
        List<com.example.plugins.model.Student> students)
        throws SystemException {
        for (com.example.plugins.model.Student student : students) {
            courseToStudentTableMapper.addTableMapping(pk,
                student.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the course and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course to clear the associated students from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearStudents(long pk) throws SystemException {
        courseToStudentTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param studentPK the primary key of the student
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeStudent(long pk, long studentPK)
        throws SystemException {
        courseToStudentTableMapper.deleteTableMapping(pk, studentPK);
    }

    /**
     * Removes the association between the course and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param student the student
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeStudent(long pk, com.example.plugins.model.Student student)
        throws SystemException {
        courseToStudentTableMapper.deleteTableMapping(pk,
            student.getPrimaryKey());
    }

    /**
     * Removes the association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param studentPKs the primary keys of the students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeStudents(long pk, long[] studentPKs)
        throws SystemException {
        for (long studentPK : studentPKs) {
            courseToStudentTableMapper.deleteTableMapping(pk, studentPK);
        }
    }

    /**
     * Removes the association between the course and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param students the students
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeStudents(long pk,
        List<com.example.plugins.model.Student> students)
        throws SystemException {
        for (com.example.plugins.model.Student student : students) {
            courseToStudentTableMapper.deleteTableMapping(pk,
                student.getPrimaryKey());
        }
    }

    /**
     * Sets the students associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param studentPKs the primary keys of the students to be associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setStudents(long pk, long[] studentPKs)
        throws SystemException {
        Set<Long> newStudentPKsSet = SetUtil.fromArray(studentPKs);
        Set<Long> oldStudentPKsSet = SetUtil.fromArray(courseToStudentTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeStudentPKsSet = new HashSet<Long>(oldStudentPKsSet);

        removeStudentPKsSet.removeAll(newStudentPKsSet);

        for (long removeStudentPK : removeStudentPKsSet) {
            courseToStudentTableMapper.deleteTableMapping(pk, removeStudentPK);
        }

        newStudentPKsSet.removeAll(oldStudentPKsSet);

        for (long newStudentPK : newStudentPKsSet) {
            courseToStudentTableMapper.addTableMapping(pk, newStudentPK);
        }
    }

    /**
     * Sets the students associated with the course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the course
     * @param students the students to be associated with the course
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setStudents(long pk,
        List<com.example.plugins.model.Student> students)
        throws SystemException {
        try {
            long[] studentPKs = new long[students.size()];

            for (int i = 0; i < students.size(); i++) {
                com.example.plugins.model.Student student = students.get(i);

                studentPKs[i] = student.getPrimaryKey();
            }

            setStudents(pk, studentPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(CourseModelImpl.MAPPING_TABLE_STUDENTCOURSE_COURSES_STUDENTS_NAME);
        }
    }

    /**
     * Initializes the course persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.example.plugins.model.Course")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Course>> listenersList = new ArrayList<ModelListener<Course>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Course>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        courseToStudentTableMapper = TableMapperFactory.getTableMapper("StudentCourse_Courses_Students",
                "courseId", "studentId", this, studentPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CourseImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("StudentCourse_Courses_Students");
    }
}
