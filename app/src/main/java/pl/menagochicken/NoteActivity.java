package pl.menagochicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import pl.menagochicken.models.Note;

public class NoteActivity extends AppCompatActivity {

    // ui components
    private EditText mEditTitle, mEditText;
    private TextView mViewTitle;

    //vars
    private boolean mIsNewNote;

    private static final String TAG = "NoteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if (getIncomingIntent()){
            //new note (EDIT MODE)
        } else {
            //not new Note (View MODE)
        }

    }

    private boolean getIncomingIntent(){
        if (getIntent().hasExtra("selectedNote")){
            Note incomingNote = getIntent().getParcelableExtra("selectedNote");
            Log.d(TAG, "getIncomingIntent: " + incomingNote.toString());
            mIsNewNote = false;
            return false;
        }
        mIsNewNote = true;
        return true;
    }
}
