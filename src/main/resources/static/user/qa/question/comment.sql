create table comment_tbl(
    c_seq number(5) primary key,
    c_commenter_name varchar2( 20 char) null,
    c_comment_content varchar2(2000 char) null,
    c_reg_date datetime null
);

create sequence comment_tbl_seq
  start with 1
  increment by 1;
  
insert into comment_tbl values (comment_tbl_seq.nextval, 'c_commenter_name', 'c_comment_content', 'c_reg_date');

select * from comment_tbl;