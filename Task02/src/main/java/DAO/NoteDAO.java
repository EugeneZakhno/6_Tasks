package DAO;
import entity.Note;

import java.util.List;

public interface NoteDAO {

	boolean add(Note note);

	boolean remove(Note note);

	List<Note> getAll();

	Note toNote(String note);

	boolean saveAll(List<Note> noteList);

}