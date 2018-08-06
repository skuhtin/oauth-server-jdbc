INSERT INTO access.roles (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO access.roles (role_id, role) VALUES (2, 'USER');

ALTER SEQUENCE roles_seq_pk RESTART WITH 3;

INSERT INTO access.groups (group_id, name) VALUES (1, 'ADMINISTRATOR');
INSERT INTO access.groups (group_id, name) VALUES (2, 'USER');
INSERT INTO access.groups (group_id, name) VALUES (3, 'TOTAL');

ALTER SEQUENCE groups_seq_pk RESTART WITH 4;

INSERT INTO access.role_groups (group_id, role_id) VALUES (1, 1);
INSERT INTO access.role_groups (group_id, role_id) VALUES (2, 2);
INSERT INTO access.role_groups (group_id, role_id) VALUES (3, 1);
INSERT INTO access.role_groups (group_id, role_id) VALUES (3, 2);



-- pwd cepera = $2a$10$ihXeOCKGWFSPOE/uahVnAuXKaz9anlPhQ/roNFOn08MkBvyqL0WAG
-- pwd test = $2a$10$rhxqCdgCOx80lAeoXeaasuJivKqc7zZz5fWmaHhQF.QxML0m0MmeS
-- pwd total = $2a$10$gEZYXPaMyRMNl9Hh0cMQQO0enK.pAcULXT3t2KX7hrY5CS4g1jV9W
-- pwd diff_total = $2a$10$WIJvOqL/BXDQ6YYf7D6ur.P8rC5o4ejRN3ogSVZNnvCLElABHSsMu
-- pwd empty = $2a$10$XZC3AyuutC7uS5qJ4d5W8uVK2pJbftJyL1SV98uIoKcWN/E9Sss.y
INSERT INTO access.users (user_id, login, password, enabled) VALUES (1, 'cepera', '$2a$10$ihXeOCKGWFSPOE/uahVnAuXKaz9anlPhQ/roNFOn08MkBvyqL0WAG', true);
INSERT INTO access.users (user_id, login, password, enabled) VALUES (2, 'test', '$2a$10$rhxqCdgCOx80lAeoXeaasuJivKqc7zZz5fWmaHhQF.QxML0m0MmeS', true);
INSERT INTO access.users (user_id, login, password, enabled) VALUES (3, 'total', '$2a$10$gEZYXPaMyRMNl9Hh0cMQQO0enK.pAcULXT3t2KX7hrY5CS4g1jV9W', true);
INSERT INTO access.users (user_id, login, password, enabled) VALUES (4, 'diff_total', '$2a$10$WIJvOqL/BXDQ6YYf7D6ur.P8rC5o4ejRN3ogSVZNnvCLElABHSsMu', true);
INSERT INTO access.users (user_id, login, password, enabled) VALUES (5, 'empty', '$2a$10$XZC3AyuutC7uS5qJ4d5W8uVK2pJbftJyL1SV98uIoKcWN/E9Sss.y', true);
ALTER SEQUENCE users_seq_pk RESTART WITH 6;

INSERT INTO access.user_groups (user_id, group_id) VALUES (1, 1);
INSERT INTO access.user_groups (user_id, group_id) VALUES (2, 2);
INSERT INTO access.user_groups (user_id, group_id) VALUES (3, 3);
INSERT INTO access.user_groups (user_id, group_id) VALUES (4, 1);
INSERT INTO access.user_groups (user_id, group_id) VALUES (4, 2);

INSERT INTO public.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('clientId', 'resourceIds', '12345678', 'read,write', 'password,refresh_token', '', 'USER', 600, 3600, '{}', '');