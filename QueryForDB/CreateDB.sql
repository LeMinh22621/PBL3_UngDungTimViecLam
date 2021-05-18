USE UngDungTimViecLam
GO
CREATE TABLE TB_ADDRESS
(
	ID_ADDRESS NVARCHAR(10) NOT NULL,
	WARD NVARCHAR(20) NOT NULL,
	DISTRICT NVARCHAR(20) NOT NULL,
	PROVINCE NVARCHAR(20) NOT NULL,
	STREET NVARCHAR(20) NOT NULL,

	PRIMARY KEY (ID_ADDRESS)
)
CREATE TABLE TB_POST
(
	ID_POST NVARCHAR(10) NOT NULL,
	JOB_NAME NVARCHAR(50) NOT NULL,
	ENTERPRISE_NAME NVARCHAR(50),
	ID_ADDRESS NVARCHAR(10) NOT NULL,-- DIA CHI NOI LAM VIEC
	WORK_HOUR SMALLINT,
	SALARY INT,
	BENEFIT INT, -- LUONG PHU CAP

	PRIMARY KEY (ID_POST),
	FOREIGN KEY (ID_ADDRESS) REFERENCES TB_ADDRESS(ID_ADDRESS)
)
CREATE TABLE TB_ACCOUNT
(
	ID_ACCOUNT NVARCHAR(10) NOT NULL,
	USERNAME NVARCHAR(10) NOT NULL,
	PASSWORD NVARCHAR(10) NOT NULL,
	EMAIL NVARCHAR(50) NOT NULL,
	PHONENUMBER NVARCHAR(10) NOT NULL

	PRIMARY KEY (ID_ACCOUNT)
)
CREATE TABLE TB_EMPLOYER
(
	ID_EMPLOYER NVARCHAR(10) NOT NULL,
	NAME_EMPLOYER NVARCHAR(50) NOT NULL,
	ID_ADDRESS NVARCHAR(10) NOT NULL,
	ID_ACCOUNT NVARCHAR(10) NOT NULL

	PRIMARY KEY (ID_EMPLOYER),
	FOREIGN KEY (ID_ADDRESS) REFERENCES TB_ADDRESS(ID_ADDRESS),
	FOREIGN KEY (ID_ACCOUNT) REFERENCES TB_ACCOUNT(ID_ACCOUNT)
)
CREATE TABLE TB_JOBSEEKER
(
	ID_JOBSEEKER NVARCHAR(10) NOT NULL,
	NAME_JOBSEEKER NVARCHAR(50) NOT NULL,
	ID_ADDRESS NVARCHAR(10) NOT NULL,
	AGE SMALLINT NOT NULL,
	PROFESSIONAL NVARCHAR(50) NOT NULL,
	ID_ACCOUNT NVARCHAR(10) NOT NULL

	PRIMARY KEY (ID_JOBSEEKER),
	FOREIGN KEY (ID_ADDRESS) REFERENCES TB_ADDRESS(ID_ADDRESS),
	FOREIGN KEY (ID_ACCOUNT) REFERENCES TB_ACCOUNT(ID_ACCOUNT)
)
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