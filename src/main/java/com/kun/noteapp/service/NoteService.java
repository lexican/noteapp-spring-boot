package com.kun.noteapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kun.noteapp.models.NoteModel;

public class NoteService {
	private List<NoteModel> notes = new ArrayList<NoteModel>();

	public NoteService() {
		notes = new ArrayList<>();
	}
	
	public List<NoteModel> getAllNotes() {
		return notes;
	}
	
	public Optional<NoteModel> getNote(Long noteId) {
		NoteModel note = null;
		
		for(NoteModel noteItem : notes) {
			if(noteItem.getId() == noteId) {
				note = noteItem;
				break;
			}
		}
		return Optional.ofNullable(note);
	}

	public List<NoteModel> addNote(NoteModel note) {
		notes.add(note);
		return notes;
	}
	
	
	public List<NoteModel> updateNote(String title, String description, Long noteId) {
		
		for(NoteModel noteItem : notes) {
			if(noteItem.getId() == noteId) {
				noteItem.setTitle(title);
				noteItem.setDecription(description);
				break;
			}
		}

		return notes;
	}
	
	public List<NoteModel> deleteNote(Long noteId) {
		
		List<NoteModel> updatedNotes = notes.stream()
		.filter(note -> note.getId() != noteId).toList();

		notes.clear();
		notes.addAll(updatedNotes);
		
		return notes;
	}
	
}
