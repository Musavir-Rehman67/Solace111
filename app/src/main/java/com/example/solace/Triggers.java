package com.example.solace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Triggers extends AppCompatActivity {

    //CheckBox Variables and finding them by with their id
    CheckBox cbStress,cbSelfTalk,cbLoSleep,cbArguing,cbTooMuch,cbTreatment,cbLoExer,cbDrugs,cbDiffLife,cbAlcohol,cbDiet,cbMedicine;


    //TextView Variables and Finding them by id
    TextView tvStress,tvSelfTalk,tvLoSleep, tvArguing,tvTooMuch,tvTreatment,tvLoExer,tvDrugs,tvDiffLife,tvAlcohol,tvDiet,tvMedicine;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        HashMap<String, String> core = (HashMap<String, String>) intent.getSerializableExtra("core");
        HashMap<String, String> SWS = (HashMap<String, String>) intent.getSerializableExtra("stayWS");
        HashMap<String, String> symptoms = (HashMap<String, String>) intent.getSerializableExtra("symptoms");
        String date = intent.getStringExtra("date");





        setContentView(R.layout.activity_triggers);
        cbStress=findViewById(R.id.Stress);
        cbSelfTalk=findViewById(R.id.iveselftalk);
        cbLoSleep=findViewById(R.id.losleep);
        cbArguing=findViewById(R.id.arguing);
        cbTooMuch=findViewById(R.id.muchtodo);
        cbTreatment=findViewById(R.id.Chngtreatment);
        cbLoExer=findViewById(R.id.lkofexercise);
        cbDrugs=findViewById(R.id.redrugs);
        cbDiffLife=findViewById(R.id.lfchnges);
        cbAlcohol=findViewById(R.id.Alcohol);
        cbDiet=findViewById(R.id.poordiet);
        cbMedicine=findViewById(R.id.medicine);

         tvStress=findViewById(R.id.spinnerStress);
         tvSelfTalk=findViewById(R.id.spinnerSelftalk);
         tvLoSleep=findViewById(R.id.spinnerLoSleep);
         tvArguing=findViewById(R.id.spinnerArguing);
         tvTooMuch=findViewById(R.id.spinnerTooMuch);
         tvTreatment=findViewById(R.id.spinnerTreatment);
         tvLoExer=findViewById(R.id.spinnerLoExer);
         tvDrugs=findViewById(R.id.spinnerDrugs);
         tvDiffLife=findViewById(R.id.spinnerDifLife);
         tvAlcohol=findViewById(R.id.spinnerAlcohol);
         tvDiet=findViewById(R.id.spinnerDiet);
         tvMedicine=findViewById(R.id.spinnerMedicine);

        MaterialButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button1);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem1);
                        tvStress.setText(item.getTitle());
//                        CheckBox checkBox1 = findViewById(R.id.Stress);
                        cbStress.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button2);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem2);
                        tvSelfTalk.setText(item.getTitle());
//                        CheckBox checkBox2 = findViewById(R.id.iveselftalk);
                        cbSelfTalk.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button3);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem3);
                        tvLoSleep.setText(item.getTitle());
//                        CheckBox checkBox3 = findViewById(R.id.losleep);
                        cbLoSleep.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button4);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem4);
                        tvArguing.setText(item.getTitle());
//                        CheckBox checkBox4 = findViewById(R.id.arguing);
                        cbArguing.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button5);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem5);
                        tvTooMuch.setText(item.getTitle());
//                        CheckBox checkBox5 = findViewById(R.id.muchtodo);
                        cbTooMuch.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button6);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem6);
                        tvTreatment.setText(item.getTitle());
//                        CheckBox checkBox6 = findViewById(R.id.Chngtreatment);
                        cbTreatment.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button7);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem7);
                        tvLoExer.setText(item.getTitle());
//                        CheckBox checkBox7 = findViewById(R.id.lkofexercise);
                        cbLoExer.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button8);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem8);
                        tvDrugs.setText(item.getTitle());
//                        CheckBox checkBox8 = findViewById(R.id.redrugs);
                        cbDrugs.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button9);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem9);
                        tvDiffLife.setText(item.getTitle());
//                        CheckBox checkBox9 = findViewById(R.id.lfchnges);
                        cbDiffLife.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button10 = findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button10);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem10);
                        tvAlcohol.setText(item.getTitle());
//                        CheckBox checkBox10 = findViewById(R.id.Alcohol);
                        cbAlcohol.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        MaterialButton button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button11);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem11);
                        tvDrugs.setText(item.getTitle());
//                        CheckBox checkBox11 = findViewById(R.id.poordiet);
                        cbDiet.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });


        MaterialButton button12 = findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Triggers.this, button12);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem12);
                        tvMedicine.setText(item.getTitle());
//                        CheckBox checkBox12 = findViewById(R.id.medicine);
                        cbMedicine.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });


//        ??NextButton

        Button next_trig=findViewById(R.id.nexttrg);
        next_trig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stress=" ",selfTalk=" ",loSleep=" ",arguing=" ",tooMuch=" ",treatment=" ",loExer=" ",drugs=" ",diffLife=" ",alcohol=" ",diet=" ",medicine=" ";
                if (cbStress.isChecked()){
                    stress=tvStress.getText().toString();
                }else
                    stress =null;

                if (cbSelfTalk.isChecked()){
                    selfTalk=tvSelfTalk.getText().toString();
                }else
                    selfTalk =null;

                if (cbLoSleep.isChecked()){
                    loSleep=tvLoSleep.getText().toString();
                }else
                    loSleep=null;

                if (cbArguing.isChecked()){
                    arguing=tvArguing.getText().toString();
                }else
                    arguing=null;

                if (cbTooMuch.isChecked()){
                    tooMuch=tvTooMuch.getText().toString();
                }else
                    tooMuch=null;

                if (cbTreatment.isChecked()){
                    treatment=tvTreatment.getText().toString();
                }else
                    treatment=null;

                if (cbLoExer.isChecked()){
                    loExer=tvLoExer.getText().toString();
                }else
                    loExer=null;

                if (cbDrugs.isChecked()){
                    drugs=tvDrugs.getText().toString();
                }else
                    drugs=null;

                if (cbDiffLife.isChecked()){
                    diffLife=tvDiffLife.getText().toString();
                }else
                    diffLife=null;

                if (cbAlcohol.isChecked()){
                    alcohol=tvAlcohol.getText().toString();
                }else
                    alcohol=null;

                if (cbDiet.isChecked()){
                    diet =tvDiet.getText().toString();
                }else
                    diet=null;

                if (cbMedicine.isChecked()){
                    medicine=tvMedicine.getText().toString();
                }else
                    medicine=null;

                Map<String,String> trigerrs=new HashMap<>();
                //Storing data
                trigerrs.put("Stress at Work or School",stress);
                trigerrs.put("Negative Self Talk",selfTalk);
                trigerrs.put("lack of Sleep",loSleep);
                trigerrs.put("Arguing",arguing);
                trigerrs.put("Too Much to DO",tooMuch);
                trigerrs.put("Change in Treatment",treatment);
                trigerrs.put("Lack of Exercise",loExer);
                trigerrs.put("Recreational Drugs",drugs);
                trigerrs.put("Difficult Life Changes",diffLife);
                trigerrs.put("Alcohol Consumption",alcohol);
                trigerrs.put("Poor Diet",diet);
                trigerrs.put("Medicine Not Taken",medicine);


                trigerrs.entrySet().removeIf(entry -> entry.getValue() == null);


                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                String id=user.getUid();


                //Storing data in realtime

                FirebaseDatabase.getInstance().getReference().child(id).child(date).child("Core Data").setValue(core);
                FirebaseDatabase.getInstance().getReference().child(id).child(date).child("Stay Well Stratigies").setValue(SWS);
                FirebaseDatabase.getInstance().getReference().child(id).child(date).child("Symptoms").setValue(symptoms);
                FirebaseDatabase.getInstance().getReference().child(id).child(date).child("Triggers").setValue(trigerrs);




                Intent intent=new Intent(Triggers.this,report.class);
                intent.putExtra("date",date);
                intent.putExtra("core", core);
                intent.putExtra("sws", SWS);
                intent.putExtra("symptoms", symptoms);
                intent.putExtra("trigerrs",(Serializable)trigerrs);
                startActivity(intent);



            }
        });

    }
}