CREATE TABLE flyway_schema_history
(
  installed_rank INTEGER PRIMARY KEY NOT NULL,
  version VARCHAR(50),
  description VARCHAR(200) NOT NULL,
  type VARCHAR(20) NOT NULL,
  script VARCHAR(1000) NOT NULL,
  checksum INTEGER,
  installed_by VARCHAR(100) NOT NULL,
  installed_on TIMESTAMP DEFAULT now() NOT NULL,
  execution_time INTEGER NOT NULL,
  success BOOLEAN NOT NULL
);
CREATE INDEX flyway_schema_history_s_idx ON flyway_schema_history (success);