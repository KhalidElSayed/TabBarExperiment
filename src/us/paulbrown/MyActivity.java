package us.paulbrown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                ImageView imageViewToChange = (ImageView)findViewById(R.id.imageview1);
                imageViewToChange.setImageResource(R.drawable.laptopvsurface);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                iv.setImageResource(R.drawable.nesmug);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                iv.setImageResource(R.drawable.legoskel);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(MyActivity.this,ActivityEins.class));
                iv.setImageResource(R.drawable.whyfahrenheit);
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
}
