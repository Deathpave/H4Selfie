package com.example.selfieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

/**
 * Code behind main activity xml
 * @author Martin*/
public class MainActivity extends AppCompatActivity {

    /**
     * Creates the activity
     * C# init*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method called by take picture button
     * Intents to take a picture using devices camera*/
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public void onPictureBtnClicked(View view)
    {
        // take picture intent
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        catch (ActivityNotFoundException e)
        {
            // display error state to the user
        }
    }

    /**
     * When activity ends
     * Checks if activity result is camero and status is ok
     * Sets imageview bitmap to picture taken*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bmp = (Bitmap) extras.get("data");
            final ImageView imageview = (ImageView)findViewById(R.id.pictureBox);
            imageview.setImageBitmap(bmp);
        }
    }
}