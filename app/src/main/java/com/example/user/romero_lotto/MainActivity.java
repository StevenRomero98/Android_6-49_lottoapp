package com.example.user.romero_lotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtfldLottNum1, txtfldLottNum2, txtfldLottNum3, txtfldLottNum4, txtfldLottNum5, txtfldLottNum6;
    EditText txtfldLottInp1, txtfldLottInp2, txtfldLottInp3, txtfldLottInp4, txtfldLottInp5, txtfldLottInp6;
    EditText txtfldOUTPUT;
    Button btnCompute, btnBetAgain;

    //txtfldlotteryinputnum1 = txtfldLottInp

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtfldLottNum1 = (EditText) findViewById(R.id.txtfldlotteryrandomnum1);
        txtfldLottNum2 = (EditText) findViewById(R.id.txtfldlotteryrandomnum2);
        txtfldLottNum3 = (EditText) findViewById(R.id.txtfldlotteryrandomnum3);
        txtfldLottNum4  = (EditText) findViewById(R.id.txtfldlotteryrandomnum4);
        txtfldLottNum5 = (EditText) findViewById(R.id.txtfldlotteryrandomnum5);
        txtfldLottNum6 = (EditText) findViewById(R.id.txtfldlotteryrandomnum6);

        txtfldLottInp1 = (EditText) findViewById(R.id.txtfldlotteryinputnum1);
        txtfldLottInp2 = (EditText) findViewById(R.id.txtfldlotteryinputnum2);
        txtfldLottInp3 = (EditText) findViewById(R.id.txtfldlotteryinputnum3);
        txtfldLottInp4 = (EditText) findViewById(R.id.txtfldlotteryinputnum4);
        txtfldLottInp5 = (EditText) findViewById(R.id.txtfldlotteryinputnum5);
        txtfldLottInp6 = (EditText) findViewById(R.id.txtfldlotteryinputnum6);

        txtfldOUTPUT = (EditText) findViewById(R.id.txtfldOUTPUT);

        btnCompute = (Button) findViewById(R.id.btnCompute);
        btnBetAgain = (Button) findViewById(R.id.btnBetAgain);


        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LottoComputation lottocomp = new LottoComputation(Integer.parseInt(txtfldLottInp1.getText().toString()), Integer.parseInt(txtfldLottInp2.getText().toString()), Integer.parseInt(txtfldLottInp3.getText().toString()), Integer.parseInt(txtfldLottInp4.getText().toString()), Integer.parseInt(txtfldLottInp5.getText().toString()), Integer.parseInt(txtfldLottInp6.getText().toString()));
                    lottocomp.randomnumber();
                    //for lotto random number
                    txtfldLottNum1.setText(lottocomp.lottery[0] + "");
                    txtfldLottNum2.setText(lottocomp.lottery[1] + "");
                    txtfldLottNum3.setText(lottocomp.lottery[2] + "");
                    txtfldLottNum4.setText(lottocomp.lottery[3] + "");
                    txtfldLottNum5.setText(lottocomp.lottery[4] + "");
                    txtfldLottNum6.setText(lottocomp.lottery[5] + "");

                    if (lottocomp.checkInput()) {
                        txtfldOUTPUT.setText("There are duplicate numbers on your combination. Please bet again!");
                    } else if (lottocomp.checkGreater49()) {
                        txtfldOUTPUT.setText("Please input different number less than 49 or greater than 1.");
                    } else {
                        txtfldOUTPUT.setText(lottocomp.checkIfWin());
                        if (lottocomp.checkIfWin().equals("You win 5,000.00!!")) {
                            btnCompute.setEnabled(false);
                            btnBetAgain.setEnabled(true);
                            txtfldOUTPUT.setText(lottocomp.checkIfWin());
                        } else if (lottocomp.checkIfWin().equals("You win 20,000.00!!")) {
                            btnCompute.setEnabled(false);
                            btnBetAgain.setEnabled(true);
                            txtfldOUTPUT.setText(lottocomp.checkIfWin());
                        } else if (lottocomp.checkIfWin().equals("You win 50,000.00!!")) {
                            btnCompute.setEnabled(false);
                            btnBetAgain.setEnabled(true);
                            txtfldOUTPUT.setText(lottocomp.checkIfWin());
                        } else if (lottocomp.checkIfWin().equals("You win Jackpot (10,000,000.00)")) {
                            btnCompute.setEnabled(false);
                            btnBetAgain.setEnabled(true);
                            txtfldOUTPUT.setText(lottocomp.checkIfWin());
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Please enter correct character", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnBetAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCompute.setEnabled(true);
                btnBetAgain.setEnabled(false);
            }
        });

    }

    public void clear(View v) {
        txtfldLottNum1.setText("");
        txtfldLottNum2.setText("");
        txtfldLottNum3.setText("");
        txtfldLottNum4.setText("");
        txtfldLottNum5.setText("");
        txtfldLottNum6.setText("");
    }




}

