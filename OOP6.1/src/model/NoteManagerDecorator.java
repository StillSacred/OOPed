package model;

import java.util.List;

public class NoteManagerDecorator implements NoteOperable, Logable{
    private NoteOperable noteOperable;
    private  Logable logable;

    public NoteManagerDecorator(NoteOperable noteOperable, Logable logable) {
        this.noteOperable = noteOperable;
        this.logable = logable;
    }

    @Override
    public void writeLog(String message) {
        logable.writeLog(message);
    }

    @Override
    public void createNote(String title, String content) {
        logable.writeLog("Creating note: " + title);
        noteOperable.createNote(title, content);
    }

    @Override
    public void updateNote(String id, String newTitle, String newContent) {
        logable.writeLog("Updating note with ID: " + id);
        noteOperable.updateNote(id, newTitle, newContent);
    }

    @Override
    public void deleteNote(String id) {
        logable.writeLog("Deleting note with ID: " + id);
        noteOperable.deleteNote(id);
    }

    @Override
    public Note findById(String id) {
        logable.writeLog("Trying to find note with ID: " + id);
        return noteOperable.findById(id);
    }

    @Override
    public List<String> readAllNotes() {
        logable.writeLog("Reading notebook");
        return noteOperable.readAllNotes();
    }
}