/* post table */
CREATE TABLE POST(
 POSTNO NUMBER PRIMARY KEY,
 EMAIL VARCHAR2(1000),
 PLAN VARCHAR2(1000),
 TITLEIMAGE VARCHAR2(1000),
 IMAGES VARCHAR2(1000),
 CONTENT VARCHAR2(1000),
 HASHTAG VARCHAR2(1000),
 REGDATE DATE DEFAULT sysdate,
 LOCATION VARCHAR2(1000),
 VIEWS NUMBER DEFAULT 0,
 AUTHORITY VARCHAR2(1000)
);
 
/* post_like table */
CREATE TABLE POST_LIKE(
 POSTNO NUMBER PRIMARY KEY,
 EMAIL VARCHAR2(1000),
 LIKES NUMBER DEFAULT 0
);

/* post_comments table */
CREATE TABLE COMMENTS (
 COMMENTNO NUMBER PRIMARY KEY,
 POSTNO NUMBER,
 EMAIL  VARCHAR2(100),
 CONTENT VARCHAR2(1000),
 TIME DATE DEFAULT sysdate,
 grp number DEFAULT 0,
 grpl number DEFAULT 0,
 grps number DEFAULT 0
);


/* �۾��� */
SELECT * FROM COMMENTS;

SELECT COUNT(COMMENTNO) comments 
FROM POST a, COMMENTS b 
WHERE a.postno = b.postno;

SELECT a.CONTENT, COUNT(b.postno) 
FROM POST a, COMMENTS b 
WHERE a.postno = b.postno(+);            


SELECT * FROM POST,comments;

SELECT location, hashtag, (SELECT count(*) 
                           FROM COMMENTS 
                           WHERE POSTNO = 14) cnt 
FROM POST ;