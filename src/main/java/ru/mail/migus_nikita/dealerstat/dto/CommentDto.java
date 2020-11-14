package ru.mail.migus_nikita.dealerstat.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {


  private String text;
  private Long postId;
  private String author;

}
