DROP TABLE PUBLIC.task IF EXISTS;
CREATE TABLE PUBLIC.task  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    status_id BIGINT NOT NULL,
    name VARCHAR(20)
);

DROP TABLE PUBLIC.status IF EXISTS;
CREATE TABLE PUBLIC.status  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20)
);

alter table PUBLIC.task
	add constraint TASK_STATUS_ID_FK
		foreign key (status_id) references PUBLIC.status (id);



INSERT INTO PUBLIC.status (id, name) VALUES (1, 'New');

INSERT INTO PUBLIC.task (status_id, name) VALUES (1, 'Important task');