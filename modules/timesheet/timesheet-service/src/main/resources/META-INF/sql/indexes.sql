create index IX_32C20107 on TIME_Project (clientId);

create index IX_499A4EC7 on TIME_Task (projectId);

create index IX_B3F4AF64 on TIME_TimeEntry (timesheetId);
create index IX_92159434 on TIME_TimeEntry (userId, onDate);

create index IX_A411AB25 on TIME_Timesheet (userId, open_);