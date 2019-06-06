package pl.menagochicken.async;

import android.os.AsyncTask;
import android.util.Log;

import pl.menagochicken.models.Note;
import pl.menagochicken.persistance.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

    private static final String TAG = "InsertAsyncTask";

    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao deo) {
        mNoteDao = deo;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread:" +Thread.currentThread().getName());
        mNoteDao.insertNotes(notes);
        return null;
    }
}
