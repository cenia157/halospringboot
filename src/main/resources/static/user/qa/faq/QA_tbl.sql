create table QA_tbl(
    qa_seq number(3) primary key,
    qa_title varchar2(50 char) not null,
    qa_content varchar2(2000 char) null,
    qa_reg_date date null
);

create sequence QA_tbl_seq
  start with 1
  increment by 1;
  
drop table QA_tbl;
drop sequence QA_tbl_seq;
  
insert into QA_tbl values (QA_tbl_seq.nextval, '¡¸ªèª¯ª¢ªëòõÙı¡¹ªòª¹ªÙªÆ?ªßªŞª·ª¿ª¬¡¢Ùığ¹ª¬ú°Ì½ª·ªŞª»ªó¡£',
'ªâª·¡¢ªèª¯ªïª«ªéªÊª¤ïÃª¬ª¢ªëíŞùê¡¢¡¸QnA¡¹ªÎ¡¸ªªÙıª¤ùêªïª»¡¹«Ú?«¸ªòª´?ÍÅª¯ªÀªµª¤¡£«Õ«©?«àªòŞÅª¤¡¢ªèª¯ªïª«ªéªÊª¤ªÈª³ªíªòòÁïÈªªÚ¤ª­ª¹ªëª³ªÈª¬Ê¦ÒöªÇª¹¡£'
, sysdate);
delete from QA_tbl where qa_seq =10;

select * from QA_tbl;