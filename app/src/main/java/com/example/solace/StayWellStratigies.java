package com.example.solace;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StayWellStratigies extends AppCompatActivity {

    String date;
    CheckBox checkBoxPosThink,cbAlterTherap,cbRelax,cbPlentyWater,cbAdeqSleep,cbSocialSupp,cbHealtyMeal,cbProfSupp,cbTimeout,cbLookout,cbActOther,cbMangConf;
    TextView textViewPosThink,tvAlterTherap,tvRelax,tvPlentyWater,tvAdeqSleep,tvSocialSupp,tvHealtyMeal,tvProfSupp,tvTimeout,tvLookout,tvActOther,tvMangConf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_well_stratigies);

        Intent intent = getIntent();
        HashMap<String, String> core = (HashMap<String, String>) intent.getSerializableExtra("core");
        date = intent.getStringExtra("date");

        //Finding Checkbox
        checkBoxPosThink = findViewById(R.id.positivethinking);
        cbAlterTherap=findViewById(R.id.therapies);
        cbRelax=findViewById(R.id.relaxation);
        cbPlentyWater=findViewById(R.id.powater);
        cbAdeqSleep=findViewById(R.id.adesleep);
        cbSocialSupp=findViewById(R.id.socialsupport);
        cbHealtyMeal=findViewById(R.id.healthymeals);
        cbProfSupp=findViewById(R.id.professionalsupport);
        cbTimeout=findViewById(R.id.timeoutside);
        cbLookout=findViewById(R.id.lookingoutside);
        cbActOther=findViewById(R.id.activitieswithothers);
        cbMangConf=findViewById(R.id.manageconflict);

        //Finding TextView
        tvAlterTherap=findViewById(R.id.spinnertherapies);
        tvRelax=findViewById(R.id.spinnerRelax);
        tvPlentyWater=findViewById(R.id.spinnerPlenty);
        tvAdeqSleep=findViewById(R.id.spinnerAdequate);
        tvSocialSupp=findViewById(R.id.spinnerSocial);
        tvHealtyMeal=findViewById(R.id.spinnerHealthy);
        tvProfSupp=findViewById(R.id.spinnerProf);
        tvTimeout=findViewById(R.id.spinnerTimeout);
        tvLookout=findViewById(R.id.spinnerLookout);
        tvActOther=findViewById(R.id.spinnerActiv);
        tvMangConf=findViewById(R.id.spinnerManage);
        textViewPosThink = findViewById(R.id.spinnerPosThnk);

        Button next_sws;


        MaterialButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button1);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        textViewPosThink = findViewById(R.id.spinnerSelectedItem1);
                        textViewPosThink.setText(item.getTitle());
//                         checkBox1 = findViewById(R.id.positivethinking);
                        checkBoxPosThink.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button2);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem2);
                        tvAlterTherap.setText(item.getTitle());
//                        CheckBox checkBox2 = findViewById(R.id.therapies);
                        cbAlterTherap.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button3);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem3);
                        tvRelax.setText(item.getTitle());
//                        CheckBox checkBox3 = findViewById(R.id.relaxation);
                        cbRelax.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button4);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem4);
                        tvPlentyWater.setText(item.getTitle());
//                        CheckBox checkBox4 = findViewById(R.id.powater);
                        cbPlentyWater.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button5);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem5);
                        tvAdeqSleep.setText(item.getTitle());
//                        CheckBox checkBox5 = findViewById(R.id.adesleep);
                        cbAdeqSleep.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button6);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem6);
                        tvSocialSupp.setText(item.getTitle());
//                        CheckBox checkBox6 = findViewById(R.id.socialsupport);
                        cbSocialSupp.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button7);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem7);
                        tvHealtyMeal.setText(item.getTitle());
//                        CheckBox checkBox7 = findViewById(R.id.healthymeals);
                        cbHealtyMeal.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button8);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem8);
                        tvProfSupp.setText(item.getTitle());
//                        CheckBox checkBox8 = findViewById(R.id.professionalsupport);
                        cbProfSupp.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button9);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem9);
                        tvTimeout.setText(item.getTitle());
//                        CheckBox checkBox9 = findViewById(R.id.timeoutside);
                        cbTimeout.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button10);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem10);
                        tvLookout.setText(item.getTitle());
//                        CheckBox checkBox10 = findViewById(R.id.lookingoutside);
                        cbLookout.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button11);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem11);
                        tvActOther.setText(item.getTitle());
//                        CheckBox checkBox11 = findViewById(R.id.activitieswithothers);
                        cbActOther.setChecked(true);
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
                PopupMenu popup = new PopupMenu(StayWellStratigies.this, button12);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem12);
                        tvMangConf.setText(item.getTitle());
//                        CheckBox checkBox12 = findViewById(R.id.manageconflict);
                        cbMangConf.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        //NextButton

        next_sws=findViewById(R.id.nextsws);
        next_sws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String posThink =" ",altTherap=" ",relax=" ",pltWater=" ",adeSleep=" ",socSup=" ",healthy=" ",profSupp=" ",timeout=" ",lookout=" ",actOther=" ",manage=" ";
                if (checkBoxPosThink.isChecked()){
                    posThink=textViewPosThink.getText().toString();
                }else
                    posThink=null;

                if(cbAlterTherap.isChecked()){
                    altTherap=tvAlterTherap.getText().toString();
                }else
                    altTherap=null;

                if(cbRelax.isChecked()){
                    relax=tvRelax.getText().toString();
                }else
                    relax=null;

                if(cbPlentyWater.isChecked()){
                    pltWater=tvPlentyWater.getText().toString();
                }else
                    pltWater=null;

                if(cbAdeqSleep.isChecked()){
                    adeSleep=tvAdeqSleep.getText().toString();
                }else
                    adeSleep=null;

                if(cbSocialSupp.isChecked()){
                    socSup=tvSocialSupp.getText().toString();
                }else
                    socSup=null;
                if(cbHealtyMeal.isChecked()){
                    healthy=tvHealtyMeal.getText().toString();
                }else
                    healthy=null;

                if(cbProfSupp.isChecked()){
                    profSupp=tvProfSupp.getText().toString();
                }else
                    profSupp=null;

                if(cbTimeout.isChecked()){
                    timeout=tvTimeout.getText().toString();
                }else
                    timeout=null;

                if(cbLookout.isChecked()){
                    lookout=tvLookout.getText().toString();
                }else
                    lookout=null;

                if(cbActOther.isChecked()){
                    actOther=tvActOther.getText().toString();
                }else
                    actOther=null;

                if(cbMangConf.isChecked()){
                    manage=tvMangConf.getText().toString();
                }else
                    manage=null;



                Map<String,Object> SWS=new HashMap<>();
                //Storing data
                SWS.put("Positive Thinking",posThink);
                SWS.put("Alternative Therapies",altTherap);
                SWS.put("Relaxation",relax);
                SWS.put("Plenty of Water",pltWater);
                SWS.put("Adequate Sleep",adeSleep);
                SWS.put("Social Support",socSup);
                SWS.put("Healthy Meals",healthy);
                SWS.put("Professional Support",profSupp);
                SWS.put("Time Outside",timeout);
                SWS.put("Looking Outside",lookout);
                SWS.put("Activities With Others,",actOther);
                SWS.put("Managing Conflicts",manage);
                SWS.entrySet().removeIf(entry -> entry.getValue() == null);


                Intent intent=new Intent(StayWellStratigies.this,Symptoms.class);
                intent.putExtra("date",date);
                intent.putExtra("core", core);
                intent.putExtra("stayWS",(Serializable)SWS );

                startActivity(intent);
            }
        });
    }
}