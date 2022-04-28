package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView vmakni_tekst, izkaray_tekst;
    private String input, output, NewOutput;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, clear_button, power_button, procent_button, delenie_button, umnojenie_button,
            minus_button, plus_button, tochka_button, ravno_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vmakni_tekst = findViewById(R.id.vmakni_tekst);
        izkaray_tekst = findViewById(R.id.izkaray_tekst);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        clear_button = findViewById(R.id.clear_button);
        power_button = findViewById(R.id.power_button);
        procent_button = findViewById(R.id.procent_button);
        delenie_button = findViewById(R.id.delenie_button);
        umnojenie_button = findViewById(R.id.umnojenie_button);
        minus_button = findViewById(R.id.minus_button);
        plus_button = findViewById(R.id.plus_button);
        tochka_button = findViewById(R.id.tochka_button);
        ravno_button = findViewById(R.id.ravno_button);
    }
    public void onButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input = null;
                output = null;
                izkaray_tekst.setText("");
                break;

            case "^":
                input+="^";
                reshenie();
                break;

            case "*":
                input+="*";
                reshenie();

            case "=":
                reshenie();
                break;

            case "%":
                input+="%";
                double d = Double.parseDouble(vmakni_tekst.getText().toString()) / 100;
                izkaray_tekst.setText(String.valueOf(d));
                break;

            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("/") || data.equals("-")){
                reshenie();
                }
                input += data;
        }
        vmakni_tekst.setText(input);
    }
    private void reshenie(){
        if(input.split("\\+").length==2){
            String numbers [] = input.split("\\+");
                try{
                    double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    NewOutput = cutDecimal(output);
                    izkaray_tekst.setText(NewOutput);
                    input = d+"";
                }catch (Exception e){
                    izkaray_tekst.setError(e.getMessage().toString());
                }
        }
        if(input.split("\\*").length==2){
            String numbers [] = input.split("\\*");
            try{
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                NewOutput = cutDecimal(output);
                izkaray_tekst.setText(NewOutput);
                input = d+"";
            }catch (Exception e){
                izkaray_tekst.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String numbers [] = input.split("\\/");
            try{
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                NewOutput = cutDecimal(output);
                izkaray_tekst.setText(NewOutput);
                input = d+"";
            }catch (Exception e){
                izkaray_tekst.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\^").length==2){
            String numbers [] = input.split("\\^");
            try{
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                NewOutput = cutDecimal(output);
                izkaray_tekst.setText(NewOutput);
                input = d+"";
            }catch (Exception e){
                izkaray_tekst.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length==2){
            String numbers [] = input.split("\\-");
            try{
                    if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                        double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                        output = Double.toString(d);
                        NewOutput = cutDecimal(output);
                        izkaray_tekst.setText("-" + NewOutput);
                        input = d+"";
                }
                    else {
                        double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                        output = Double.toString(d);
                        NewOutput = cutDecimal(output);
                        izkaray_tekst.setText(NewOutput);
                        input = d + "";
                    }
            }catch (Exception e){
                izkaray_tekst.setError(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length > 1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
            return number;
    }
}