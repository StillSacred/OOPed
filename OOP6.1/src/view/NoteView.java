package view;

import controller.NoteControllable;

import java.util.List;
import java.util.Scanner;

public class NoteView {
    private NoteControllable noteControllable;

    public NoteView(NoteControllable noteControllable) {
        this.noteControllable = noteControllable;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            try {
                String command = prompt("Enter command: ");
                if (command.equals("")) throw new RuntimeException("Wrong command!");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case LIST:
                        List<String> notes = noteControllable.readAllNotes();
                        notes.forEach(i -> System.out.println(i + "\n"));
                        break;
                    case CREATE:
                        String title = prompt("Enter title: ");
                        String content = prompt("Enter content: ");
                        noteControllable.createNote(title, content);
                        break;
                    case UPDATE:
                        String id = prompt("Enter ID: ");
                        title = prompt("Enter title: ");
                        content = prompt("Enter content: ");
                        noteControllable.updateNote(id, title, content);
                        break;
                    case DELETE:
                        id = prompt("Enter ID: ");
                        noteControllable.deleteNote(id);
                        break;
                    case FIND:
                        id = prompt("Enter ID: ");
                        System.out.println(noteControllable.findById(id));
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}