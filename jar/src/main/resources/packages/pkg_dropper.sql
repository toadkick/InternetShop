CREATE OR REPLACE PACKAGE pkg_dropper AS

  PROCEDURE dropTable(tablename VARCHAR2);
  PROCEDURE dropSeq(seqname VARCHAR2);

END pkg_dropper;
/
