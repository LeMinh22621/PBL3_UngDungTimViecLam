USE UngDungTimViecLam
GO
CREATE TABLE TB_CATEGORY_JOB
(
	ID_CATEGORY_JOB NVARCHAR(10) NOT NULL,
	CATEGORY_JOB_NAME NVARCHAR(50) NOT NULL,

	CONSTRAINT PK_TB_CATEGORY_JOB PRIMARY KEY(ID_CATEGORY_JOB)
)
	
CREATE TABLE TB_ACCOUNT
(
	ID_ACCOUNT NVARCHAR(10) NOT NULL,
	USERNAME NVARCHAR(10) NOT NULL,
	PASSWORD NVARCHAR(10) NOT NULL,
	ACCESSER BIT,
	STATUS BIT NOT NULL

	CONSTRAINT PK_TB_ACCOUNT PRIMARY KEY (ID_ACCOUNT)
)
CREATE TABLE TB_PROFILE
(
	ID_PROFILE NVARCHAR(10) NOT NULL,
	IMAGE IMAGE,
	NAME NVARCHAR(50) NOT NULL,
	CITY NVARCHAR(20) NOT NULL,
	PHONE_NUMBER NVARCHAR(10) NOT NULL,
	EMAIL NVARCHAR(50) NOT NULL,
	FACEBOOK NVARCHAR(100),
	WEBSITE NVARCHAR(100)

	CONSTRAINT PK_TB_PROFILE PRIMARY KEY(ID_PROFILE)

)
CREATE TABLE TB_JOBSEEKER
(
	ID_JOBSEEKER NVARCHAR(10) NOT NULL,
	ID_ACCOUNT NVARCHAR(10) NOT NULL,
	ID_PROFILE NVARCHAR(10) NOT NULL,
	AGE INT NOT NULL,
	GENDER BIT NOT NULL,
	PROFESSIONAL NVARCHAR(50) NOT NULL,
	

	CONSTRAINT PK_ID_JOBSEEKER PRIMARY KEY (ID_JOBSEEKER),
	CONSTRAINT FK_ID_ACCOUNT_JOBSEEKER FOREIGN KEY (ID_ACCOUNT) REFERENCES TB_ACCOUNT(ID_ACCOUNT),
	CONSTRAINT FK_ID_PROFILE_JOBSEEKER FOREIGN KEY (ID_PROFILE) REFERENCES TB_PROFILE(ID_PROFILE)
)
CREATE TABLE TB_EMPLOYER
(
	ID_EMPLOYER NVARCHAR(10) NOT NULL,
	ID_ACCOUNT NVARCHAR(10) NOT NULL,
	ID_PROFILE NVARCHAR(10) NOT NULL,

	CONSTRAINT PK_ID_EMPLOYER PRIMARY KEY (ID_EMPLOYER),
	CONSTRAINT FK_ID_ACCOUNT_EMPLOYER FOREIGN KEY (ID_ACCOUNT) REFERENCES TB_ACCOUNT(ID_ACCOUNT),
	CONSTRAINT FK_ID_PROFILE_EMPLOYER FOREIGN KEY (ID_PROFILE) REFERENCES TB_PROFILE(ID_PROFILE)
)
CREATE TABLE TB_CV
(
	ID_CV NVARCHAR(10) NOT NULL,
	ID_JOBSEEKER NVARCHAR(10) NOT NULL,
	ADDRESS_CV NVARCHAR(MAX) NOT NULL

	CONSTRAINT  PK_ID_CV PRIMARY KEY (ID_CV),
	CONSTRAINT FK_ID_JOBSEEKER FOREIGN KEY (ID_JOBSEEKER) REFERENCES TB_JOBSEEKER(ID_JOBSEEKER)
)
CREATE TABLE TB_POST
(
	ID_POST NVARCHAR(10) NOT NULL,
	ID_EMPLOYER NVARCHAR(10) NOT NULL,
	ID_CATEGORY_JOB NVARCHAR(10) NOT NULL,
	JOB_NAME NVARCHAR(50) NOT NULL,
	COMPANY_NAME NVARCHAR(50),
	CITY NVARCHAR(50) NOT NULL,
	SALARY INT,
	DESCIPTION_JOB NVARCHAR(200),
	LABOR INT, -- NHAN CONG
	STATUS BIT NOT NULL
	
	CONSTRAINT PK_ID_POST PRIMARY KEY (ID_POST),
	CONSTRAINT FK_ID_EMPLOYER FOREIGN KEY (ID_EMPLOYER) REFERENCES TB_EMPLOYER(ID_EMPLOYER),
	CONSTRAINT FK_ID_CATEGORY_JOB FOREIGN KEY (ID_CATEGORY_JOB) REFERENCES TB_CATEGORY_JOB(ID_CATEGORY_JOB)
)
CREATE TABLE TB_DETAIL_CV_AND_POST
(
	ID_POST NVARCHAR(10) NOT NULL,
	ID_CV NVARCHAR(10) NOT NULL,

	CONSTRAINT PK_DETAIL_CV_AND_POST PRIMARY KEY (ID_POST,ID_CV),
	CONSTRAINT FK_ID_POST FOREIGN KEY (ID_POST) REFERENCES TB_POST(ID_POST),
	CONSTRAINT FK_ID_CV FOREIGN KEY (ID_CV) REFERENCES TB_CV(ID_CV)
)
CREATE TABLE TB_COMMUNICATION
(
	ID_COMMUNICATION NVARCHAR(10),
	ID_EMPLOYER NVARCHAR(10),
	ID_JOBSEEKER NVARCHAR(10),
	MESS NVARCHAR(MAX) NOT NULL

	CONSTRAINT PK_TB_COMMUNICATION PRIMARY KEY (ID_COMMUNICATION),
	CONSTRAINT FK_TB_ID_EMPLOYER FOREIGN KEY(ID_EMPLOYER) REFERENCES TB_EMPLOYER(ID_EMPLOYER),
	CONSTRAINT FK_TB_ID_JOBSEEKER FOREIGN KEY(ID_JOBSEEKER) REFERENCES TB_JOBSEEKER(ID_JOBSEEKER)
)
ALTER TABLE TB_DETAIL_CV_AND_POST ADD STATUS BIT
/*
ALTER TABLE TB_CV ALTER COLUMN ADDRESS_CV NVARCHAR(MAX) NULL
ALTER TABLE TB_PROFILE ALTER COLUMN IMAGE IMAGE NULL
ALTER TABLE TB_ACCOUNT ADD STATUS BIT NOT NULL
ALTER TABLE TB_ACCOUNT ADD CATEGORY BIT
ALTER TABLE TB_ACCOUNT
ALTER COLUMN CATEGORY NVARCHAR(10)
EXEC sp_rename 'TB_POST.ENTERPRISE_NAME', 'ID_EMPLOYER', 'COLUMN';
ALTER TABLE TB_POST 
ALTER COLUMN ID_EMPLOYER NVARCHAR(10)
ALTER TABLE TB_POST
DROP CONSTRAINT FK__TB_POST__ID_ADDR__38996AB5
ALTER TABLE TB_POST
ADD FOREIGN KEY (ID_EMPLOYER) REFERENCES TB_EMPLOYER(ID_EMPLOYER)
select CONSTRAINT_NAME
from INFORMATION_SCHEMA.TABLE_CONSTRAINTS
where TABLE_NAME = 'TB_POST'

DROP TABLE TB_DETAIL_CV_AND_POST
DROP TABLE TB_POST
DROP TABLE TB_CV
DROP TABLE TB_JOBSEEKER
DROP TABLE TB_EMPLOYER
DROP TABLE TB_ACCOUNT
DROP TABLE TB_CATEGORY_JOB
DROP TABLE TB_PROFILE

*/