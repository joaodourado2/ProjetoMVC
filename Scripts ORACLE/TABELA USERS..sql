CREATE TABLE USER_JAVA.USERS
(
   CD_USER      NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
   ID_USER      VARCHAR2(150) NOT NULL UNIQUE,
   NM_USER      VARCHAR2 (255) NOT NULL,
   DS_PASSWORD  VARCHAR2 (255) NOT NULL,
   SN_ACTIVE    CHAR NOT NULL
);