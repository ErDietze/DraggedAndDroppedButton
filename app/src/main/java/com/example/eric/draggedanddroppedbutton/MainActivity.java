package com.example.eric.draggedanddroppedbutton;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    LinearLayout target1;
    LinearLayout target2;
    LinearLayout target3;
    LinearLayout target4;

    Button test1;
    Button test2;
    Button test3;
    Button test4;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        // change for Commit

        target1 = (LinearLayout) findViewById(R.id.target1);
        target2 = (LinearLayout) findViewById(R.id.target2);
        target3 = (LinearLayout) findViewById(R.id.target3);
        target4 = (LinearLayout) findViewById(R.id.target4);

        test1 = (Button) findViewById(R.id.test1);
        test2 = (Button) findViewById(R.id.test2);
        test3 = (Button) findViewById(R.id.test3);
        test4 = (Button) findViewById(R.id.test4);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

//        btn1.setOnLongClickListener(longClickListener);
//        btn2.setOnLongClickListener(longClickListener);
//        btn3.setOnLongClickListener(longClickListener);
//        btn4.setOnLongClickListener(longClickListener);
        btn1.setOnTouchListener(onTouchListener);
        btn2.setOnTouchListener(onTouchListener);
        btn3.setOnTouchListener(onTouchListener);
        btn4.setOnTouchListener(onTouchListener);

    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }

//        @Override
//        public boolean onLongClick(View v) {
//            ClipData data = ClipData.newPlainText("", "");
//            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
//            v.startDrag(data, myShadowBuilder, v, 0);
//            return true;
//        }

    };
    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };


    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.btn1 && v.getId() == R.id.target1) {
                        Toast.makeText(MainActivity.this, "Dropped 1", Toast.LENGTH_SHORT).show();
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test1.setVisibility(View.GONE);
                        newParent.addView(view);
                        i++;
                        if (i == 4) {
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.right);
                            mediaPlayer.start();
                        }

                    } else if (view.getId() == R.id.btn2 && v.getId() == R.id.target2) {
                        Toast.makeText(MainActivity.this, "Dropped 2", Toast.LENGTH_SHORT).show();
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test2.setVisibility(View.GONE);
                        newParent.addView(view);
                        i++;
                        if (i == 4) {
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.right);
                            mediaPlayer.start();
                        }

                    } else if (view.getId() == R.id.btn3 && v.getId() == R.id.target3) {
                        Toast.makeText(MainActivity.this, "Dropped 3", Toast.LENGTH_SHORT).show();
                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test3.setVisibility(View.GONE);
                        newParent.addView(view);
                        i++;
                        if (i == 4) {
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.right);
                            mediaPlayer.start();
                            Toast.makeText(MainActivity.this, "All right", Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "All right", Toast.LENGTH_SHORT).show();
                        }
                    } else if (view.getId() == R.id.btn4 && v.getId() == R.id.target4) {

                        LinearLayout oldParent = (LinearLayout) view.getParent();
                        oldParent.removeView(view);
                        LinearLayout newParent = (LinearLayout) v;
                        test4.setVisibility(View.GONE);
                        newParent.addView(view);
                        i++;
                        if (i == 4) {
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.right);
                            mediaPlayer.start();
                            Toast.makeText(MainActivity.this, "All right", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.wrong);
                        mediaPlayer.start();
                    }
                    break;


            }

            return true;
        }
    };
}
