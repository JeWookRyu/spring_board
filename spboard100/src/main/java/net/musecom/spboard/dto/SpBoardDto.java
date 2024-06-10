package net.musecom.spboard.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SpBoardDto {
   private int id;
   private int refid;
   private int depth;
   private int renum;
   private String title;
   private String content;
   private String writer;
   private String pass;
   private String userid;
   private int hit;
   private int chit;
   private Timestamp wdate;
   private String imnum;
}
