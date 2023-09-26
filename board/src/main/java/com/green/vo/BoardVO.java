package com.green.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int boardnum;
	private String boardtitle;
	private String boardcontent;
	private String boardwriter;
	private int boardcount;
	private Date boardregdate;
}
