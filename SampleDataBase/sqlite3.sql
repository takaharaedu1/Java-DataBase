.open data.db

DROP TABLE IF EXISTS sampleTable;
CREATE TABLE sampleTable(
    id INTEGER PRIMARY KEY
    , name TEXT
    , value INTEGER default 0
);