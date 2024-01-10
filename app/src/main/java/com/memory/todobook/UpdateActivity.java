package com.memory.todobook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button edit_button, delete_button;
    MyDatabaseHelper myDB;
    int bookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        edit_button = findViewById(R.id.edit_button);
        delete_button = findViewById(R.id.delete_button);

        myDB = new MyDatabaseHelper(this);

        Bundle data = getIntent().getExtras();
        Book current_book = (Book) data.getSerializable("book");

        bookId = current_book.getId();

        title_input.setText(current_book.getTitle());
        author_input.setText(current_book.getAuthor());
        pages_input.setText(String.valueOf(current_book.getPages()));

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.updateData(
                        String.valueOf(current_book.getId()),
                        title_input.getText().toString().trim() ,
                        author_input.getText().toString().trim(),
                        Integer.parseInt(pages_input.getText().toString().trim()));
            }

        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title_input.getText() + "?");
        builder.setMessage("Are you sure you want to delete " + title_input.getText() + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                myDB.deleteRow(String.valueOf(bookId));
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }




}




















