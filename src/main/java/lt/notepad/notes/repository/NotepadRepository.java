package lt.notepad.notes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import lt.notepad.notes.entity.Note;

@Repository
public interface NotepadRepository extends JpaRepository<Note, Integer>{
	List<Note> findByNameOrderByNameAsc(String name);
//	List<Note> findAllOrderByDateDesc();
	
//	List<Note> findByNameOrderByMessageAsc();
//	List<Note> findByNameOrderByMessageDesc();
}