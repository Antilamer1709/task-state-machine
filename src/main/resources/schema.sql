DROP TABLE PUBLIC.task IF EXISTS;
CREATE TABLE PUBLIC.task  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    status_id BIGINT NOT NULL,
    name VARCHAR(64)
);

DROP TABLE PUBLIC.status IF EXISTS;
CREATE TABLE PUBLIC.status  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(32)
);

alter table PUBLIC.task
	add constraint TASK_STATUS_ID_FK
		foreign key (status_id) references PUBLIC.status (id);



INSERT INTO PUBLIC.status (id, name) VALUES (1, 'New');
INSERT INTO PUBLIC.status (id, name) VALUES (2, 'Ready For Development');
INSERT INTO PUBLIC.status (id, name) VALUES (3, 'In Development');
INSERT INTO PUBLIC.status (id, name) VALUES (4, 'Ready For Test');
INSERT INTO PUBLIC.status (id, name) VALUES (5, 'In Test');
INSERT INTO PUBLIC.status (id, name) VALUES (6, 'Pending');
INSERT INTO PUBLIC.status (id, name) VALUES (7, 'Rejected');
INSERT INTO PUBLIC.status (id, name) VALUES (8, 'Resolved');

INSERT INTO PUBLIC.task (status_id, name) VALUES (1, 'Important task');