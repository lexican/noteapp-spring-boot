package com.kun.noteapp.dto.responses;

import com.kun.noteapp.models.NoteModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder(toBuilder = true)
public class GetNoteResponse extends BaseResponse {

	NoteModel data;

	public GetNoteResponse(String message, String status, NoteModel note) {
		super(message, status);

		this.data = note;

	}

}
