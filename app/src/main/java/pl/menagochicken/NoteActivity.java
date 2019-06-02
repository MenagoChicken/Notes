package pl.menagochicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import pl.menagochicken.models.Note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if (getIntent().hasExtra("selectedNote")) {
            Note note = getIntent().getParcelableExtra("selectedNote");
            Log.d(TAG, "onCreate: " + note.toString());
        }
    }
}
