create table StudentCourse_Course (
	courseId LONG not null primary key
);

create table StudentCourse_Courses_Students (
	courseId LONG not null,
	studentId LONG not null,
	primary key (courseId, studentId)
);

create table StudentCourse_Student (
	studentId LONG not null primary key
);