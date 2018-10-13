package lt.notepad.notes.service;

import java.util.List;
import lt.notepad.notes.entity.Note;

public interface NotepadService {
	Note getNoteById(Integer id);
	void saveNote(Note note);
	void updateNote(Integer id, String message, boolean important);
	void deleteNote(Integer id);
	
	List<Note> findByName(String name);
	
	List<Note> findAllOrderByDateASC();
	List<Note> findAllOrderByDateDESC();
	
	List<Note> findAllOrderByNameASC();
	List<Note> findAllOrderByNameDESC();
}