USE UngDungTimViecLam
GO
INSERT INTO TB_ACCOUNT(ID_ACCOUNT,USERNAME,PASSWORD,ACCESSER,STATUS) VALUES
('AA1','ADMIN','ADMIN',NULL,1),
('AE1','LHM','1234',1,1),
('AE2','LTMN','1234',1,1),
('AJ1','LVN','1234',0,1),
('AJ2','LVN','1234',0,1)

INSERT INTO TB_PROFILE(ID_PROFILE, IMAGE, NAME, CITY, PHONE_NUMBER, EMAIL, FACEBOOK, WEBSITE) VALUES
('PF1',(SELECT * FROM OPENROWSET(BULK N'C:\Users\lehon\Desktop\HK4\PBL3_UngDungTimViecLam\Image\lop.jpg', SINGLE_BLOB) as IMAGE),'MINH','HA TINH','0763034216','LHM2K1@GMAIL.COM',NULL,NULL),
('PF2',(SELECT * FROM OPENROWSET(BULK N'C:\Users\lehon\Desktop\HK4\PBL3_UngDungTimViecLam\Image\lop.jpg', SINGLE_BLOB) as IMAGE),'LHM','HA TINH','0763034216','LHM2K1@GMAIL.COM',NULL,NULL),
('PF3',(SELECT * FROM OPENROWSET(BULK N'C:\Users\lehon\Desktop\HK4\PBL3_UngDungTimViecLam\Image\lop.jpg', SINGLE_BLOB) as IMAGE),'LHM','HA TINH','0763034216','LHM2K1@GMAIL.COM',NULL,NULL),
('PF4',(SELECT * FROM OPENROWSET(BULK N'C:\Users\lehon\Desktop\HK4\PBL3_UngDungTimViecLam\Image\lop.jpg', SINGLE_BLOB) as IMAGE),'LHM','HA TINH','0763034216','LHM2K1@GMAIL.COM',NULL,NULL)

INSERT INTO TB_EMPLOYER(ID_EMPLOYER, ID_ACCOUNT, ID_PROFILE) VALUES
('EM1', 'AE1', 'PF1'),
('EM2', 'AE2', 'PF2')

INSERT INTO TB_CATEGORY_JOB(ID_CATEGORY_JOB, CATEGORY_JOB_NAME) VALUES
('CJ1', 'IT'),
('CJ2', 'SALE'),
('CJ3', 'MANAGEMENT HR'),
('CJ4', 'TEACH')

INSERT INTO TB_JOBSEEKER(ID_JOBSEEKER, ID_ACCOUNT, ID_PROFILE, AGE, GENDER, PROFESSIONAL) VALUES
('JS1', 'AJ1', 'PF3', 20, 'TRUE', 'INFORMATION TEACHNOLOGY'),
('JS2', 'AJ2', 'PF4', 30, 'FALSE', 'TEACHER UP TOP 5 YEARS')

INSERT INTO TB_POST (ID_POST, ID_EMPLOYER, ID_CATEGORY_JOB, JOB_NAME, COMPANY_NAME, CITY, SALARY, DESCIPTION_JOB, LABOR, STATUS) VALUES
('P1', 'EM1', 'CJ1', 'DEVELOPER', 'VNG', 'DA NANG', 10000000, NULL, 4, 'TRUE' ),
('P2', 'EM1', 'CJ1', 'FRONT_END', 'DAC', 'DA NANG', 8000000, NULL, 2, 'FALSE' ),
('P3', 'EM2', 'CJ1', 'BACK_END', 'VNG', 'DA NANG', 12000000, NULL, 3, 'TRUE' ),
('P4', 'EM2', 'CJ1', 'TESTER', 'DAC', 'DA NANG', 15000000, NULL, 5, 'FALSE' )

/*DELETE FROM TB_ACCOUNT
DELETE FROM TB_CATEGORY_JOB
DELETE FROM TB_CV
DELETE FROM TB_DETAIL_CV_AND_POST
DELETE FROM TB_EMPLOYER
DELETE FROM TB_JOBSEEKER
DELETE FROM TB_POST
DELETE FROM TB_PROFILE

SELECT MAX(ID_PROFILE) FROM TB_PROFILE*/
