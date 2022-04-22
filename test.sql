SELECT postno
FROM (SELECT *
      FROM (SELECT A.*, rownum rnum
            FROM (SELECT postNo, ABS(latitude - 37.5455744) interval_lat, ABS(longitude - 126.8350976) interval_lng
                  FROM post_dt
                  ORDER BY interval_lat ASC, interval_lng ASC) A
            )
      WHERE rnum < 5
      )
WHERE rnum = 1;

