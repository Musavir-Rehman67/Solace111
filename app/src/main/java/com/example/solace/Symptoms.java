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


public class Symptoms extends AppCompatActivity {
    //CheckBox Vairables
    CheckBox cbAnger,cbSadness,cbIrritable,cbAnxiety,cbSuicide,cbEnergy,cbGuilty,cbEXsleep,cbWorthless,cbInterest,cbPoorConc,cbAppetite;

    //Textview variables
    TextView tvAnger,tvSadness,tvIrritable,tvAnxiety,tvSuicide,tvEnergy,tvGuilty,tvEXsleep,tvWorthless,tvInterest,tvPoorConc,tvAppetite;



    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        Intent intent = getIntent();
        HashMap<String, String> core = (HashMap<String, String>) intent.getSerializableExtra("core");
        HashMap<String, String> SWS = (HashMap<String, String>) intent.getSerializableExtra("stayWS");
        date = intent.getStringExtra("date");


        //Finding CheckBox
        cbAnger=findViewById(R.id.anger);
        cbSadness=findViewById(R.id.sadness);
        cbIrritable=findViewById(R.id.irritability);
        cbAnxiety=findViewById(R.id.anxiety);
        cbSuicide=findViewById(R.id.suicidalthoughts);
        cbEnergy=findViewById(R.id.loenergy);
        cbGuilty=findViewById(R.id.feelguilty);
        cbEXsleep=findViewById(R.id.excessivesleep);
        cbWorthless=findViewById(R.id.worthless);
        cbInterest=findViewById(R.id.lointerest);
        cbPoorConc=findViewById(R.id.poorconcentration);
        cbAppetite=findViewById(R.id.appetite);

        //Finding TextView
        tvAnger=findViewById(R.id.spinnerAnger);
        tvSadness=findViewById(R.id.spinnerSad);
        tvIrritable=findViewById(R.id.spinnerIrritat);
        tvAnxiety=findViewById(R.id.spinnerAnxiety);
        tvSuicide=findViewById(R.id.spinnerSuicide);
        tvEnergy=findViewById(R.id.spinnerLossEnergy);
        tvGuilty=findViewById(R.id.spinnerGuilt);
        tvEXsleep=findViewById(R.id.spinnerExcesSleep);
        tvWorthless=findViewById(R.id.spinnerWorthless);
        tvInterest=findViewById(R.id.spinnerLossInterest);
        tvPoorConc=findViewById(R.id.spinnerPoorConc);
        tvAppetite=findViewById(R.id.spinnerChngAppetite);


        MaterialButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Symptoms.this, button1);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem1);
                        tvAnger.setText(item.getTitle());
//                        CheckBox checkBox1 = findViewById(R.id.anger);
                        cbAnger.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button2);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem2);
                        tvSadness.setText(item.getTitle());
//                        CheckBox checkBox2 = findViewById(R.id.sadness);
                        cbSadness.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button3);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem3);
                        tvIrritable.setText(item.getTitle());
//                        CheckBox checkBox3 = findViewById(R.id.irritability);
                        cbIrritable.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button4);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem4);
                        tvAnxiety.setText(item.getTitle());
//                        CheckBox checkBox4 = findViewById(R.id.anxiety);
                        cbAnxiety.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button5);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem5);
                        tvSuicide.setText(item.getTitle());
//                        CheckBox checkBox5 = findViewById(R.id.suicidalthoughts);
                        cbSuicide.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button6);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem6);
                        tvEnergy.setText(item.getTitle());
//                        CheckBox checkBox6 = findViewById(R.id.loenergy);
                        cbEnergy.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button7);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem7);
                        tvGuilty.setText(item.getTitle());
//                        CheckBox checkBox7 = findViewById(R.id.feelguilty);
                        cbGuilty.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button8);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem8);
                        tvEXsleep.setText(item.getTitle());
//                        CheckBox checkBox8 = findViewById(R.id.excessivesleep);
                        cbEXsleep.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button9);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem9);
                        tvWorthless.setText(item.getTitle());
//                        CheckBox checkBox9 = findViewById(R.id.worthless);
                        cbWorthless.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button10);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem10);
                        tvInterest.setText(item.getTitle());
//                        CheckBox checkBox10 = findViewById(R.id.lointerest);
                        cbInterest.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button11);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem11);
                        tvPoorConc.setText(item.getTitle());
//                        CheckBox checkBox11 = findViewById(R.id.poorconcentration);
                        cbPoorConc.setChecked(true);
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
                PopupMenu popup = new PopupMenu(Symptoms.this, button12);
//Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
//registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        TextView textView = findViewById(R.id.spinnerSelectedItem12);
                        tvAppetite.setText(item.getTitle());
//                        CheckBox checkBox12 = findViewById(R.id.appetite);
                        cbAppetite.setChecked(true);
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

        //NextButton

        Button next_symp;
        next_symp=(Button)findViewById(R.id.nextsym);

        next_symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anger=" ",sadness=" ",irritable=" ",anxiety=" ",suicide=" ",loenergy=" ",guilty=" ",xsleep=" ",worthless=" ",interest=" ",concentration=" ",appetite=" ";
                if (cbAnger.isChecked()){
                    anger=tvAnger.getText().toString();
                }else
                    anger=null;

                if (cbSadness.isChecked()){
                    sadness=tvSadness.getText().toString();
                }else
                    sadness=null;

                if(cbIrritable.isChecked()){
                    irritable=tvIrritable.getText().toString();
                }else
                    irritable=null;

                if(cbAnxiety.isChecked()){
                    anxiety=tvAnxiety.getText().toString();
                }else
                    anxiety=null;

                if(cbSuicide.isChecked()){
                    suicide=tvSuicide.getText().toString();
                }else
                    suicide=null;

                if(cbEnergy.isChecked()){
                    loenergy=tvEnergy.getText().toString();
                }else
                    loenergy=null;

                if(cbGuilty.isChecked()){
                    guilty=tvGuilty.getText().toString();
                }else
                    guilty=null;

                if(cbEXsleep.isChecked()){
                    xsleep=tvEXsleep.getText().toString();
                }else
                    xsleep=null;

                if(cbWorthless.isChecked()){
                    worthless =tvWorthless.getText().toString();
                }else
                    worthless=null;

                if(cbInterest.isChecked()){
                    interest=tvInterest.getText().toString();
                }else
                    interest=null;

                if(cbPoorConc.isChecked()){
                    concentration=tvPoorConc.getText().toString();
                }else
                    concentration=null;

                if(cbAppetite.isChecked()){
                    appetite=tvAppetite.getText().toString();
                }else
                    appetite =null;

                Map<String,Object> symptoms=new HashMap<>();
                //Storing data
                symptoms.put("Anger",anger);
                symptoms.put("Sadness",sadness);
                symptoms.put("Irritability",irritable);
                symptoms.put("Anxiety",anxiety);
                symptoms.put("Suicidal Thoughts",suicide);
                symptoms.put("Loss of Energy",loenergy);
                symptoms.put("Feeling Guilty",guilty);
                symptoms.put("Excessive Sleep",xsleep);
                symptoms.put("Feeling Worthless",worthless);
                symptoms.put("Loss of Interest",interest);
                symptoms.put("Poor Concentration",concentration);
                symptoms.put("Change of Appetite",appetite);

                symptoms.entrySet().removeIf(entry -> entry.getValue() == null);




                Intent intent=new Intent(Symptoms.this,Triggers.class);
                intent.putExtra("date",date);
                intent.putExtra("core", core);
                intent.putExtra("stayWS", SWS);
                intent.putExtra("symptoms",(Serializable)symptoms );
                startActivity(intent);
            }
        });
    }
}