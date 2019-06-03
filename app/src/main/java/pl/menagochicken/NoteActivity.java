package pl.menagochicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.menagochicken.models.Note;

public class NoteActivity extends AppCompatActivity implements View.OnTouchListener,
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnClickListener
{
    private static final String TAG = "NoteActivity";
    private static final int EDIT_MODE_ENABLED = 1;
    private static final int EDIT_MODE_DISABLED = 0;


    // ui components
    private EditText mEditTitle, mEditText;
    private TextView mViewTitle;
    private RelativeLayout mCheckContainer, mBackArrowContainer;
    private ImageButton mCheck, mBackArrow;

    //vars
    private boolean mIsNewNote;
    private Note mInitialNote;
    private GestureDetector mGestureDetector;
    private int mMode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);
        mCheckContainer = findViewById(R.id.check_container);
        mBackArrowContainer =findViewById(R.id.back_arrow_container);
        mCheck = findViewById(R.id.toolbar_check);
        mBackArrow = findViewById(R.id.toolbar_back_arrow);



        if (getIncomingIntent()){
            //new note (EDIT MODE)
            setNewNoteProperties();
            enabledEditMode();
        } else {
            //not new note (VIEW MODE)
            setNoteProperties();
        }

        setListeners();

    }

    private void setListeners(){
        mEditText.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);
        mViewTitle.setOnClickListener(this);
        mCheck.setOnClickListener(this);
    }

    private boolean getIncomingIntent(){
        if (getIntent().hasExtra("selectedNote")){
            mInitialNote = getIntent().getParcelableExtra("selectedNote");
            Log.d(TAG, "getIncomingIntent: " + mInitialNote.toString());
            mMode = EDIT_MODE_DISABLED;
            mIsNewNote = false;
            return false;
        }
        mMode = EDIT_MODE_ENABLED;
        mIsNewNote = true;
        return true;
    }

    private void enabledEditMode(){
        mBackArrowContainer.setVisibility(View.GONE);
        mCheckContainer.setVisibility(View.VISIBLE);

        mViewTitle.setVisibility(View.GONE);
        mEditTitle.setVisibility(View.VISIBLE);

        mMode = EDIT_MODE_ENABLED;
    }

    private void disabledEditMode(){
        mBackArrowContainer.setVisibility(View.VISIBLE);
        mCheckContainer.setVisibility(View.GONE);

        mViewTitle.setVisibility(View.VISIBLE);
        mEditTitle.setVisibility(View.GONE);

        mMode = EDIT_MODE_DISABLED;
    }

    private void setNoteProperties(){
        mViewTitle.setText(mInitialNote.getTitle());
        mEditTitle.setText(mInitialNote.getTitle());
        mEditText.setText(mInitialNote.getContent());
    }

    private void setNewNoteProperties(){
        mViewTitle.setText("Note title");
        mEditTitle.setText("Note title");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap: double tapped");
        enabledEditMode();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_check:{
                disabledEditMode();
                break;
            }
            case R.id.note_text_title:{
                enabledEditMode();
                mEditTitle.requestFocus();
                mEditTitle.setSelection(mEditTitle.length());
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(mMode == EDIT_MODE_ENABLED){
            onClick(mCheck);
        }else {
            super.onBackPressed();
        }
    }
}
