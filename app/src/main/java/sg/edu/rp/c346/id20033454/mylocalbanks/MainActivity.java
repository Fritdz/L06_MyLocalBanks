package sg.edu.rp.c346.id20033454.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    int btnCheck=0;
    boolean favDBS=false;
    boolean favOCBC=false;
    boolean favUOB=false;

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

        menu.add(0,0,0,getString(R.string.website));
        menu.add(0,1,1,getString(R.string.dial));
        menu.add(0,2,1,getString(R.string.favourite));

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
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsdial)));
                startActivity(intentDial);
            }
            else if(item.getItemId()==2){//Fav
                if(favDBS==false){
                    btnDBS.setTextColor(Color.RED);
                    favDBS=true;
                }else{
                    btnDBS.setTextColor(Color.BLACK);
                    favDBS=false;
                }
            }
        }
        else if(btnCheck==2){//OCBC
            if(item.getItemId()==0){//Website
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intentDial);
            }
            else if(item.getItemId()==2){//Fav
                if(favOCBC==false){
                    btnOCBC.setTextColor(Color.RED);
                    favOCBC=true;
                }else{
                    btnOCBC.setTextColor(Color.BLACK);
                    favOCBC=false;
                }
            }
        }
        else if(btnCheck==3){//UOB
            if(item.getItemId()==0){//Website
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
                startActivity(intentWeb);
            }
            else if(item.getItemId()==1){//Dial
                Intent intentDial = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobweb)));
                startActivity(intentDial);
            }
            else if(item.getItemId()==2){//Fav
                if(favUOB==false){
                    btnUOB.setTextColor(Color.RED);
                    favUOB=true;
                }else{
                    btnUOB.setTextColor(Color.BLACK);
                    favUOB=false;
                }
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_languages,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.settingEng){
            btnDBS.setText(getString(R.string.dbs));
            btnOCBC.setText(getString(R.string.ocbc));
            btnUOB.setText(getString(R.string.uob));

        }
        else if(id==R.id.settingCh){
            btnDBS.setText(getString(R.string.dbsch));
            btnOCBC.setText(getString(R.string.ocbcch));
            btnUOB.setText(getString(R.string.uobch));
        }

        return super.onOptionsItemSelected(item);
    }
}