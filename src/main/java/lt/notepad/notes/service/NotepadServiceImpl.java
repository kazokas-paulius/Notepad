package lt.notepad.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.notepad.notes.entity.Note;
import lt.notepad.notes.repository.NotepadRepository;

@Service
@Transactional
public class NotepadServiceImpl implements NotepadService{
	
	private NotepadRepository repository;
	
	// priskiriama repositorija, kad pasiektume metodus
	
	public void setAppRepository(NotepadRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Note getNoteById(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public void saveNote(Note note) {
		repository.save(note);
	}

	@Override
	public void updateNote(Integer id, String message, boolean important) {
		Note updated = repository.getOne(id);
		updated.setImportant(important);
		updated.setMessage(message);
		repository.save(updated);
	}

	@Override
	public void deleteNote(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Note> findAllOrderByDateASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAllOrderByDateDESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAllOrderByNameASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findAllOrderByNameDESC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findByName(String name) {
		return repository.findByNameOrderByNameAsc(name);
	}

//	@Override
//	public List<Note> findAllOrderByDateASC() {
//		return repository.findAllOrderByDateAsc();
//	}
//
//	@Override
//	public List<Note> findAllOrderByDateDESC() {
//		return repository.findAllOrderByDateDesc();
//	}

//	@Override
//	public List<Note> findAllOrderByNameASC() {
//		return repository.findByNameOrderByMessageAsc();
//	}
//
//	@Override
//	public List<Note> findAllOrderByNameDESC() {
//		return repository.findByNameOrderByMessageDesc();
//	}

}