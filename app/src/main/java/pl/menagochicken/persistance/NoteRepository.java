package pl.menagochicken.persistance;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import pl.menagochicken.async.InsertAsyncTask;
import pl.menagochicken.models.Note;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note) {
new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    private void updateNote(Note note) {

    }

    public LiveData<List<Note>> retrieveNoteTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note) {

    }


}
