package com.mazenet.mani.guruguberasnehabindu.Spinners;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mazenet.mani.guruguberasnehabindu.Model.District_array_Model;

import java.util.ArrayList;


public class DistrictSpinnerdilog {
    ArrayList<District_array_Model> items;
    Activity context;
    String dTitle;
    String closeTitle = "Close";
    OnSpinnerItemClick onSpinerItemClick;
    AlertDialog alertDialog;
    int pos;
    int style;
    String groupid="",groupname="";

    public DistrictSpinnerdilog(Activity activity, ArrayList<District_array_Model> items, String dialogTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
    }

    public DistrictSpinnerdilog(Activity activity, ArrayList<District_array_Model> items, String dialogTitle, String closeTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.closeTitle = closeTitle;
    }

    public DistrictSpinnerdilog(Activity activity, ArrayList<District_array_Model> items, String dialogTitle, int style) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.style = style;
    }

    public DistrictSpinnerdilog(Activity activity, ArrayList<District_array_Model> items, String dialogTitle, int style, String closeTitle) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.style = style;
        this.closeTitle = closeTitle;
    }

    public void bindOnSpinerListener(OnSpinnerItemClick onSpinerItemClick1) {
        this.onSpinerItemClick = onSpinerItemClick1;
    }

    public void showSpinerDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this.context);
        View v = this.context.getLayoutInflater().inflate(in.galaxyofandroid.spinerdialog.R.layout.dialog_layout, (ViewGroup) null);
        TextView rippleViewClose = (TextView) v.findViewById(in.galaxyofandroid.spinerdialog.R.id.close);
        TextView title = (TextView) v.findViewById(in.galaxyofandroid.spinerdialog.R.id.spinerTitle);
        rippleViewClose.setText(this.closeTitle);
        title.setText(this.dTitle);
        ListView listView = (ListView) v.findViewById(in.galaxyofandroid.spinerdialog.R.id.list);
        final EditText searchBox = (EditText) v.findViewById(in.galaxyofandroid.spinerdialog.R.id.searchBox);
        final ArrayAdapter<District_array_Model> adapter = new ArrayAdapter(this.context, in.galaxyofandroid.spinerdialog.R.layout.items_view, this.items);
        listView.setAdapter(adapter);
        adb.setView(v);
        this.alertDialog = adb.create();
        this.alertDialog.getWindow().getAttributes().windowAnimations = this.style;
        this.alertDialog.setCancelable(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t = (TextView) view.findViewById(in.galaxyofandroid.spinerdialog.R.id.text1);
                for (int j = 0; j < DistrictSpinnerdilog.this.items.size(); ++j) {
                    if (t.getText().toString().equalsIgnoreCase(((District_array_Model) DistrictSpinnerdilog.this.items.get(j)).toString())) {
                        DistrictSpinnerdilog.this.pos = j;
                        groupid = String.valueOf(items.get(j).getdistrict_id());
                        groupname = String.valueOf(items.get(j).getdistrict_name());
                    }
                }

//                GroupSpinnerdilog.this.onSpinerItemClick.onClick(t.getText().toString(), GroupSpinnerdilog.this.pos);
                DistrictSpinnerdilog.this.onSpinerItemClick.onClick(t.getText().toString(), Integer.parseInt(groupid),groupname);
                DistrictSpinnerdilog.this.alertDialog.dismiss();
            }
        });
        searchBox.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(searchBox.getText().toString());
            }
        });
        rippleViewClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DistrictSpinnerdilog.this.alertDialog.dismiss();
            }
        });
        this.alertDialog.show();
    }
}
