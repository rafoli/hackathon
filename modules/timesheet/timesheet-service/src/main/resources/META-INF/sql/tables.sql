create table TIME_Client (
	clientId LONG not null primary key,
	name VARCHAR(400) null
);

create table TIME_Project (
	projectId LONG not null primary key,
	clientId LONG,
	name VARCHAR(400) null,
	startsOn DATE null,
	endsOn DATE null
);

create table TIME_Task (
	taskId LONG not null primary key,
	name VARCHAR(75) null,
	projectId LONG
);

create table TIME_TimeEntry (
	timeEntryId LONG not null primary key,
	userId LONG,
	hours DOUBLE,
	projectId LONG,
	taskId LONG,
	billable BOOLEAN,
	timesheetId LONG,
	onDate DATE null,
	msg_ STRING null
);

create table TIME_Timesheet (
	timesheetId LONG not null primary key,
	dateFrom DATE null,
	userId LONG,
	dateTo DATE null,
	approved BOOLEAN,
	open_ BOOLEAN,
	submittedOn DATE null,
	approvedOn DATE null
);