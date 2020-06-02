package com.rulan.project_distcovid;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;

public class Home extends AppCompatActivity {
    public static int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter bluethAdapter;
    Set<BluetoothDevice> pairedDevices;

    // BluetoothAdapter verifies if the device support bluetooth
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Button b = (Button)findViewById(R.id.scan);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    listDevices(v);
            }
        });
        bluethAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluethAdapter == null) {
            // Device doesn't support Bluetooth
            new AlertDialog.Builder(this)
                    .setTitle("Nicht Kompatibel")
                    .setMessage("Your phone does not support Bluetooth")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        if (!bluethAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, Home.class));
                return true;
            case R.id.history:
                startActivity(new Intent(this, History.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //respond to menu item selection

    }
    public void listDevices(View v) {
        pairedDevices = bluethAdapter.getBondedDevices();
        ArrayList mlist = new ArrayList<BluetoothDevice>();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();  // device Name
                String deviceHardwareAddress = device.getAddress(); // MAC address
                int bondState = device.getBondState();
                mlist.add(deviceName);
                mlist.add(deviceHardwareAddress);
                mlist.add(bondState);

            }
        }
    }

}