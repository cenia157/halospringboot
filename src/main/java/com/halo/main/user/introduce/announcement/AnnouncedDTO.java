package com.halo.main.user.introduce.announcement;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AnnouncedDTO {
    private int an_seq;
    private String an_title;
    private String an_content;
    private String an_writer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Date an_reg_date;
    private String an_category;
}
