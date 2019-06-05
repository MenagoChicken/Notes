package pl.menagochicken.persistance;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.menagochicken.models.Note;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    private void insertNoteTask(Note note) {

    }

    private void updateNote(Note note) {

    }

    public LiveData<List<Note>> retriveNoteTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note) {

    }


}
