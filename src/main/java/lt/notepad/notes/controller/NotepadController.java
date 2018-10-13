package lt.notepad.notes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.notepad.notes.entity.Note;
import lt.notepad.notes.service.NotepadService;
import lt.notepad.notes.service.NotepadServiceImpl;

@Controller
public class NotepadController {

	@Autowired
	private NotepadServiceImpl service;
	
	private String sortDateMethod = "ASC";
	private String sortNameMethod = "ASC";
	
//	public NotepadController(NotepadService service) {
//		this.service = service;
//	}

	@GetMapping("/")
	public String list(Model model) {
//		List<Note> notepadLisD = filterAndSortDate();
//		List<Note> notepadListU = filterAndSortName();
		
//		model.addAttribute("notes", notepadLisD);
//		model.addAttribute("sortD", sortDateMethod);
//		model.addAttribute("sortU", sortNameMethod);
		return "index";
	}
	
	@GetMapping("/sortD/{sortDate}")
	public String sortDateChoise(@PathVariable String sortDate) {
		sortDateMethod = sortDate;
		return "redirect:/";
	}
	
	@GetMapping("/sortU/{sortName}")
	public String sortNameChoise(@PathVariable String sortName) {
		sortDateMethod = sortName;
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Note note = service.getNoteById(id);
		model.addAttribute("note", note);
		return "operations/edit";
	}
	
	@PostMapping("/update")
	public String saveNote(@RequestParam Integer id,
						   @RequestParam String message,
						   @RequestParam(value = "important", required = false) boolean important) {
		service.updateNote(id, message, important);
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String newNote() {
		return "operations/new";
	}
	
	@GetMapping("/save")
	public String updateNote(@RequestParam String message, String name) {
		service.saveNote(new Note(message, name));
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteNote(@PathVariable Integer id) {
		service.deleteNote(id);
		return "redirect:/";
	}
	
	private List<Note> filterAndSortDate() {
		List<Note> notebook = new ArrayList<>();
		switch (sortDateMethod) {
		case "ASC":
			System.out.println("Persikijau?");
			notebook = service.findAllOrderByDateASC();
			System.out.println("persikas findAllByOrderByDateASC");
			break;
		case "DESC":
			notebook = service.findAllOrderByDateDESC();
			System.out.println("persikas findAllByOrderByDateDESC");
			break;
		}
		System.out.println("Persikijau islysk");
		return notebook;
	}
	
	private List<Note> filterAndSortName() {
		List<Note> notebook = new ArrayList<>();
		switch (sortNameMethod) {
		case "ASC":
			notebook = service.findAllOrderByNameASC();
			break;
		case "DESC":
			notebook = service.findAllOrderByNameDESC();
			break;
		}
		return notebook;
	}
}
