package com.salimo.plainolnotes2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by salim on 8/7/2016.
 */
public class NotesCursorAdapter extends CursorAdapter{

    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

        // 10 is the ASCII value of a new-line (line feed) character
        int pos = noteText.indexOf(10);
        if (pos != -1){
            noteText = noteText.substring(0,pos) + " ...";
        }

        TextView tv = (TextView) view.findViewById(R.id.tvNote);
        tv.setText(noteText);
    }
}
