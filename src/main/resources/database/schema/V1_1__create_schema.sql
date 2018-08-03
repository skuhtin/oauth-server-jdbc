CREATE TABLE oauth_access_token
(
  token_id VARCHAR(256),
  token BYTEA,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BYTEA,
  refresh_token VARCHAR(256)
);
CREATE UNIQUE INDEX token_id_uq ON oauth_access_token (token_id);
CREATE UNIQUE INDEX oauth_access_token_authentication_id_key ON oauth_access_token (authentication_id);
CREATE UNIQUE INDEX user_name_user_details_constr ON oauth_access_token (user_name, client_id);

CREATE TABLE oauth_client_details
(
  client_id VARCHAR(256) PRIMARY KEY NOT NULL,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

CREATE TABLE oauth_client_token
(
  token_id VARCHAR(256),
  token BYTEA,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE oauth_code
(
  code VARCHAR(256),
  authentication BYTEA
);

CREATE TABLE oauth_refresh_token
(
  token_id VARCHAR(256),
  token BYTEA,
  authentication BYTEA
);
CREATE UNIQUE INDEX token_id_uq_ref ON oauth_refresh_token (token_id);
