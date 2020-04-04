package edu.temple.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookcase.R;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter {

    public BookAdapter(Context context, ArrayList<String> bookList) {
        super(context, 0, bookList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_spinner_row, parent, false
            );
        }

        convertView.setBackgroundColor(Color.WHITE);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        String currentItem = (String) getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem);
        }

        return convertView;

    }
}