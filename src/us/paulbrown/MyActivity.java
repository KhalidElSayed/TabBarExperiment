package us.paulbrown;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.WindowManager;
import android.view.Window;
import android.widget.Toast;


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

    CharSequence[] items = { "Google","Apple","Microsoft" };
    boolean[] itemsChecked = new boolean [items.length];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //addListenerOnLastButton();


        // Make the application Full-Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //These two lines make it full screen. Having the status bar is kinda nice though
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

    public void addListenerOnLastButton() {
        //Log.d("PAULBROWN","MESSAGE");

        //Button lastButton = (Button)findViewById(R.id.tabBarButton5);
        /*
        lastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://paulbrown.us"));
                startActivity(intent);
            }
        });
        */
    }

    public void restart(View view) {
        //Intent intent = new Intent(MyActivity.this,RestartDialog.class);
        //startActivity(intent);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setIcon(R.drawable.redo);
        builder.setTitle("Do you really want to restart?");
        builder.setInverseBackgroundForced(true);
        builder.setPositiveButton("Yes, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(),
                        "Restarting", Toast.LENGTH_SHORT).show();
                position=0;
                farthestPositionReached = 0;
                final ImageView iv = (ImageView)findViewById(R.id.imageview1);
                iv.setImageResource(imagesArray[position]);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();




        //showDialog(0);
    }


    /*
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitle("Do you really want to restart?")
                        .setPositiveButton("Restart",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton)
                                    {
                                        Toast.makeText(getBaseContext(),
                                                "Restarting", Toast.LENGTH_SHORT).show();
                                        position=0;
                                        farthestPositionReached = 0;
                                        final ImageView iv = (ImageView)findViewById(R.id.imageview1);
                                        iv.setImageResource(imagesArray[position]);
                                    }
                                }
                        )
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton)
                                    {
                                        Toast.makeText(getBaseContext(),
                                                "Cancelled dialog", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ).create();
                        .setMultiChoiceItems(items, itemsChecked,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which, boolean isChecked) {
                                        Toast.makeText(getBaseContext(),
                                                items[which] + (isChecked ? " checked:":" unchecked:"),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ).create();
        }
        return null;
    }
    */

}
