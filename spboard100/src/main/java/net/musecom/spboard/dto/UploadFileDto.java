package net.musecom.spboard.dto;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class UploadFileDto {
   private int id;
   private int jboard_id;
   private String ofilename;
   private String nfilename;
   private String ext;
   private long filesize;
   private String userid;
   private String imnum;
}
