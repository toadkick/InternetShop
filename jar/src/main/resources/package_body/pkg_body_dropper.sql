CREATE OR REPLACE PACKAGE BODY pkg_dropper AS

  PROCEDURE dropTable(tablename VARCHAR2) is
  begin
    EXECUTE IMMEDIATE 'drop table '||tablename;
    exception when others then  null;
    END dropTable;

  PROCEDURE dropSeq(seqname VARCHAR2) is
    begin
      EXECUTE IMMEDIATE 'DROP SEQUENCE '||seqname;
      exception when others then  null;
    END dropSeq;

END pkg_dropper;
/
