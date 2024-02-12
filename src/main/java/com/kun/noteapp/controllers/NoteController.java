package com.kun.noteapp.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kun.noteapp.dto.requests.CreateNoteRequest;
import com.kun.noteapp.dto.requests.UpdateNoteRequest;
import com.kun.noteapp.dto.responses.BaseResponse;
import com.kun.noteapp.dto.responses.GetAllNotesResponse;
import com.kun.noteapp.dto.responses.GetNoteResponse;
import com.kun.noteapp.models.NoteModel;
import com.kun.noteapp.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController {

	NoteService _nodeService = new NoteService();

	@GetMapping("/notes")
	public ResponseEntity<Object> getAllNotes() {
		return ResponseEntity
				.ok(new GetAllNotesResponse("All notes retrieved successfully", "200", _nodeService.getAllNotes()));
	}

	@PostMapping("/notes")
	public ResponseEntity<Object> addNote(@Valid @RequestBody CreateNoteRequest note) {
		UUID uuid = UUID.randomUUID();
		List<NoteModel> notes = _nodeService
				.addNote(NoteModel.builder().title(note.getTitle()).decription(note.getDescription())
						.id(uuid.toString()).createdAt(new Date()).updatedAt(new Date()).build());
		return ResponseEntity.ok(new GetAllNotesResponse("Note successfully added", "200", notes));
	}

	@PatchMapping("/notes")
	public ResponseEntity<Object> updateNote(@Valid @RequestBody UpdateNoteRequest note) {
		System.out.println("Note body : " + note.toString());
		Optional<NoteModel> updatedNote = _nodeService.updateNote(note.getTitle(), note.getDescription(),
				note.getNoteId());

		if (updatedNote.isPresent()) {
			return ResponseEntity.ok(new GetNoteResponse("Note successfully updated", "200", updatedNote.get()));
		}
		return ResponseEntity.badRequest().body(new BaseResponse("Note does not exist", "400"));
	}

}
