CREATE TABLE USER_JAVA.PRODUCT
(
    CD_PRODUCT      NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NM_PRODUCT      VARCHAR2(255) NOT NULL,
    NR_PRICE        NUMBER NOT NULL,
    NR_WEIGHT       NUMBER DEFAULT 0,
    DS_DESCRIPTION  VARCHAR2(2000),
    TP_CATEGORY     CHAR,
    CD_EAN          NUMBER
);
