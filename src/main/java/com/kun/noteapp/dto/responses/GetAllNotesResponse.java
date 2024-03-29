package com.kun.noteapp.dto.responses;

import java.util.List;

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
public class GetAllNotesResponse extends BaseResponse {

	List<NoteModel> data;

	public GetAllNotesResponse(String message, String status, List<NoteModel> notes) {
		super(message, status);

		this.data = notes;

	}

}
