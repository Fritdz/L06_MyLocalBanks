package sg.edu.rp.c346.id20033454.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    int btnCheck=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS=findViewById(R.id.buttonDBS);
        btnOCBC=findViewById(R.id.buttonOCBC);
        btnUOB=findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v==btnDBS){
            btnCheck=1;
        }
        else if(v==btnOCBC){
            btnCheck=2;
        }
        else if(v==btnUOB){
            btnCheck=3;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(btnCheck==1){//DBS
            if(item.getItemId()==0){//Website
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+"-"+111+"-"+1111));
                startActivity(intentDial);
            }
        }
        else if(btnCheck==2){//OCBC
            if(item.getItemId()==0){//Website
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+"-"+363+"-"+3333));
                startActivity(intentDial);
            }
        }
        else if(btnCheck==3){//UOB
            if(item.getItemId()==0){//Website
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800+"-"+222+"-"+2121));
                startActivity(intentDial);
            }
        }

        return super.onContextItemSelected(item);
    }
}