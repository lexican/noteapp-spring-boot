package com.kun.noteapp.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NoteModel {
	private Long id;
	private String title;
	private String decription;
	private Date createdAt;
	private Date updatedAt;
}
