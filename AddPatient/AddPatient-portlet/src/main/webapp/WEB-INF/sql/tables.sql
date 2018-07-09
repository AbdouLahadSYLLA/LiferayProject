create table AddPatient_Patient (
	patientId LONG not null primary key,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null,
	patientAge INTEGER,
	patientGenre INTEGER,
	patientAddresse VARCHAR(75) null,
	patientEmail VARCHAR(75) null
);