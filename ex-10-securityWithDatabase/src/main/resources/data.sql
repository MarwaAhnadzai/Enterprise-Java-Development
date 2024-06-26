INSERT INTO sec_user (email, encryptedPassword, enabled)
values ('Jon@sheridancollege.ca','$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
values ('admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
INSERT INTO sec_role (roleName)
values ('ROLE_ADMIN');
 
INSERT INTO sec_role (roleName)
values ('ROLE_USER');
 
insert into user_role (userId, roleId)
values (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (1, 2);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);
