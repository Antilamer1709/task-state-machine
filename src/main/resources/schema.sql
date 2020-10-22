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



DROP TABLE PUBLIC.possible_status IF EXISTS;
CREATE TABLE PUBLIC.possible_status  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    status_id BIGINT NOT NULL,
    possible_status_id BIGINT NOT NULL
);

alter table PUBLIC.possible_status
	add constraint POSSIBLE_STATUS_STATUS_ID_FK
		foreign key (status_id) references PUBLIC.status (id);

alter table PUBLIC.possible_status
	add constraint POSSIBLE_STATUS_POSSIBLE_STATUS_ID_FK
		foreign key (possible_status_id) references PUBLIC.status (id);



INSERT INTO PUBLIC.status (id, name) VALUES (1, 'New');
INSERT INTO PUBLIC.status (id, name) VALUES (2, 'In Development');
INSERT INTO PUBLIC.status (id, name) VALUES (3, 'Ready For Test');
INSERT INTO PUBLIC.status (id, name) VALUES (4, 'In Test');
INSERT INTO PUBLIC.status (id, name) VALUES (5, 'Pending');
INSERT INTO PUBLIC.status (id, name) VALUES (6, 'Rejected');
INSERT INTO PUBLIC.status (id, name) VALUES (7, 'Resolved');

-- New
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (1, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (1, 5);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (1, 6);
-- In Development
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (2, 3);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (2, 5);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (2, 6);
-- Ready For Test
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (3, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (3, 4);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (3, 5);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (3, 6);
-- In Test
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (4, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (4, 5);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (4, 6);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (4, 7);
-- Pending
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (5, 1);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (5, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (5, 3);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (5, 4);
-- Rejected
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (6, 1);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (6, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (6, 3);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (6, 4);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (6, 5);
-- Resolved
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (7, 2);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (7, 3);
INSERT INTO PUBLIC.possible_status (status_id, possible_status_id) VALUES (7, 5);


INSERT INTO PUBLIC.task (status_id, name) VALUES (1, 'Important task');