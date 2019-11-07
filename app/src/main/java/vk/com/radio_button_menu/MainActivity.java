package vk.com.radio_button_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    int item_selection_choice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectNetwork(View view) {
        registerForContextMenu(view);
        openContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.radio_button_menu_items, menu);
        MenuItem item_wifi = menu.findItem(R.id.menu_item_wifi);
        MenuItem item_bluetooth = menu.findItem(R.id.menu_item_bluetooth);
        MenuItem item_cellular = menu.findItem(R.id.menu_item_cellular);
        Log.println(Log.DEBUG,"item choice",String.valueOf(item_selection_choice));
        if(item_selection_choice == 1)
        {
            item_wifi.setChecked(true);
        }
        else if(item_selection_choice == 2)
        {
            item_bluetooth.setChecked(true);
        }
        else if(item_selection_choice == 3)
        {
            item_cellular.setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_item_wifi:
                item_selection_choice = 1;
                return true;


            case R.id.menu_item_bluetooth:
                 item_selection_choice = 2;
                return true;


            case R.id.menu_item_cellular:
                 item_selection_choice = 3;
                return true;

            default:
                return false;
        }

    }
}
