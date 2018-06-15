DROP TABLE IF EXISTS Weather;

CREATE TABLE Weather  (
    id BIGINT auto_increment NOT NULL PRIMARY KEY,
    Stationid VARCHAR(40),
    yearmonth VARCHAR(40),
    element VARCHAR(100),
    value1 INT,
    mflag1 VARCHAR(40),
    qflag1 VARCHAR(40),
    sflag1 VARCHAR(40),
    value2 INT
);