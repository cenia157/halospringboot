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
  
insert into QA_tbl values (QA_tbl_seq.nextval, '���誯�����������򪹪٪�?�ߪު���������𹪬��̽���ު���',
'�⪷���誯�磌��ʪ��ê��������ꡢ��QnA���Ρ���������請����?����?�Ū����������ի�?����Ū����誯�磌��ʪ��Ȫ�������Ȫ�ڤ�����몳�Ȫ�ʦ���Ǫ���'
, sysdate);
delete from QA_tbl where qa_seq =10;

select * from QA_tbl;