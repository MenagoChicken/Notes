package pl.menagochicken;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NotesListActivity extends AppCompatActivity {

    private static final String TAG = "NotesListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_list_activity);

    }
}
