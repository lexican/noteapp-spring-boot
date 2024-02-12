package com.kun.noteapp.service;

import java.util.ArrayList;
import java.util.Date;
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

	public Optional<NoteModel> getNote(String noteId) {
		NoteModel note = null;

		for (NoteModel noteItem : notes) {
			if (noteItem.getId().equals(noteId)) {
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

	public Optional<NoteModel> updateNote(String title, String description, String noteId) {

		for (NoteModel noteItem : notes) {
			System.out.println("NoteId : " + noteId + "Loop Id : " + noteItem.getId());
			if (noteItem.getId().equals(noteId)) {
				noteItem.setTitle(title);
				noteItem.setDecription(description);
				noteItem.setUpdatedAt(new Date());
				return Optional.ofNullable(noteItem);
			}
		}
		return Optional.empty();
	}

	public Boolean deleteNote(String noteId) {

		Boolean isNoteExist = notes.stream().filter(note -> note.getId().equals(noteId)).findFirst().isPresent();

		if (isNoteExist) {
			List<NoteModel> updatedNotes = notes.stream().filter(note -> !note.getId().equals(noteId)).toList();
			notes.clear();
			notes.addAll(updatedNotes);
			return true;
		}

		return false;

	}

}
