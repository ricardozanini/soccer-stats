CREATE TABLE IMPORT AS 
	SELECT * FROM CSVREAD('classpath:data/italian_2015_2016.csv');

INSERT INTO Match (away_team, away_team_goals, date, home_team, home_team_goals)
	SELECT AWAYTEAM, FTAG, PARSEDATETIME(DATE, 'dd/MM/yy'), HOMETEAM, FTHG FROM IMPORT WHERE AWAYTEAM IS NOT NULL;


	