--------------------------------------------------------
--  File created - Tuesday-December-17-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "OFFICEMANAGEMENT"."STUDENT" 
   (	"ID" NUMBER, 
	"NAME" NVARCHAR2(100), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PHONE" NUMBER, 
	"ADDRESS" NVARCHAR2(100)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into OFFICEMANAGEMENT.STUDENT
SET DEFINE OFF;
Insert into OFFICEMANAGEMENT.STUDENT (ID,NAME,EMAIL,PHONE,ADDRESS) values (1,'Pham Duc Thang','phamdcuthang@gmail.com',8967567565,'Nam Dinh');
Insert into OFFICEMANAGEMENT.STUDENT (ID,NAME,EMAIL,PHONE,ADDRESS) values (21,'dung','DUNG@GMAIL.COM',9878676,'NGHE AN');
Insert into OFFICEMANAGEMENT.STUDENT (ID,NAME,EMAIL,PHONE,ADDRESS) values (22,'dungnv','DUNG@GMAIL.COM',9878676,'NGHE AN');
Insert into OFFICEMANAGEMENT.STUDENT (ID,NAME,EMAIL,PHONE,ADDRESS) values (23,'nam','nam@gmail.com',89978676,'Ha noi');
--------------------------------------------------------
--  DDL for Index STUDENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "OFFICEMANAGEMENT"."STUDENT_PK" ON "OFFICEMANAGEMENT"."STUDENT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "OFFICEMANAGEMENT"."STUDENT" ADD CONSTRAINT "STUDENT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "OFFICEMANAGEMENT"."STUDENT" MODIFY ("ID" NOT NULL ENABLE);
  
   CREATE SEQUENCE  "OFFICEMANAGEMENT"."STUDENT_SEQ"
 MINVALUE 1 MAXVALUE 999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;

