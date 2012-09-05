package us.paulbrown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.WindowManager;
import android.view.Window;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    // Set up some variables
    private int[] imagesArray = {
            R.drawable.obnoxious1,
            R.drawable.obnoxious2,
            R.drawable.obnoxious3,
            R.drawable.obnoxious4,
            R.drawable.obnoxious5,
    };


    int position = 0;
    int farthestPositionReached = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Make the application Full-Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //end Full-Screen snippet

        setContentView(R.layout.main);



        final ImageView iv = (ImageView)findViewById(R.id.imageview1);



        ImageButton button1 = (ImageButton)findViewById(R.id.tabBarButton1);
        ImageButton button2 = (ImageButton)findViewById(R.id.tabBarButton2);
        ImageButton button3 = (ImageButton)findViewById(R.id.tabBarButton3);
        ImageButton button4 = (ImageButton)findViewById(R.id.tabBarButton4);
        ImageButton button5 = (ImageButton)findViewById(R.id.tabBarButton5);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                navigateToAnotherImage("previous");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                navigateToAnotherImage("next");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                navigateToAnotherImage("farthest");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                navigateToAnotherImage("restart");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                iv.setImageResource(R.drawable.laptopvsurface);
            }
        });

    }


    public void navigateToAnotherImage(String whatImage) {
        if ((whatImage.equals("next")) && position<4) {
            position++;
            final ImageView iv = (ImageView)findViewById(R.id.imageview1);
            iv.setImageResource(imagesArray[position]);
        }
        else if ((whatImage.equals("previous")) && position>0) {
            position--;
            final ImageView iv = (ImageView)findViewById(R.id.imageview1);
            iv.setImageResource(imagesArray[position]);
        }
        else if (whatImage.equals("restart")) {
            position=0;
            farthestPositionReached = 0;
            final ImageView iv = (ImageView)findViewById(R.id.imageview1);
            iv.setImageResource(imagesArray[position]);
        }
        else if (whatImage.equals("farthest")) {
            position=farthestPositionReached;
            final ImageView iv = (ImageView)findViewById(R.id.imageview1);
            iv.setImageResource(imagesArray[position]);
        }

        if (farthestPositionReached < position) {
            farthestPositionReached = position;
        }
    }
}
