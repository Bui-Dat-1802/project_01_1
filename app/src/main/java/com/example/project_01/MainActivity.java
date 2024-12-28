package com.example.project_01;

import android.graphics.Color;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String text_xu_ly;
    private String text_show;
    private int countngoac=0;

    private int countsqrt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        // Bật tiêu đề trên ActionBar
        if (getSupportActionBar() != null) {
            // Đặt tiêu đề tùy chỉnh
            getSupportActionBar().setTitle("CALCULATOR");


        }



        binding.editText.setText("nhap");
        text_xu_ly = binding.editText.getText().toString();
        text_show = binding.editText.getText().toString();



        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                text_xu_ly = binding.editText.getText().toString();
//                text_show = binding.editText.getText().toString();
                if (v==binding.btn0){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"0";
                    text_show = text_show +"0";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn1){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"1";
                    text_show = text_show +"1";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn2){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"2";
                    text_show = text_show +"2";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn3){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"3";
                    text_show = text_show +"3";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn4){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"4";
                    text_show = text_show +"4";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn5){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"5";
                    text_show = text_show +"5";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn6){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"6";
                    text_show = text_show +"6";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn7){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"7";
                    text_show = text_show +"7";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn8){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"8";
                    text_show = text_show +"8";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btn9){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show ="";
                    }
                    text_xu_ly = text_xu_ly +"9";
                    text_show = text_show +"9";
                    binding.editText.setText(text_show);
                }
                if (v==binding.btncong){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"+";
                        text_show = text_show +"+";
                        binding.editText.setText(text_show);
                    }
                }
                if (v==binding.btntru){
                    if (text_xu_ly.equals("nhap")) {                //nếu chưa nhập gì thì sẽ là số âm
                        text_xu_ly ="-";
                        text_show ="-";
                        binding.editText.setText(text_show);
                    }
                    else if (text_xu_ly.charAt(text_xu_ly.length()-1)=='('){        //nếu mở ngoặc xong chưa nhập gì thì là số âm
                        text_xu_ly = text_xu_ly +"-";
                        text_show = text_show +"-";
                        binding.editText.setText(text_show);
                    }
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else{
                        text_xu_ly = text_xu_ly +"-";
                        text_show = text_show +"-";
                        binding.editText.setText(text_show);
                    }

                }
                if (v==binding.btnnhan){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"*";
                        text_show = text_show +"*";
                        binding.editText.setText(text_show);
                    }
                }
                if (v==binding.btnchia){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"/";
                        text_show = text_show +"/";
                        binding.editText.setText(text_show);
                    }
                }

// phần trăm có 1 lỗi nếu sau % là 1 toán hạng luôn: 1%2 => 1/1002 (sai vì đúng là 1/100*2)
                if (v==binding.btnphantram){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"/100";
                        text_show = text_show +"%";
                        binding.editText.setText(text_show);
                    }
                }

//bang chua su ly
                if (v==binding.btnbang){
                    if ((text_xu_ly.equals("nhap"))||(text_xu_ly.equals("-"))) {}
                    else {
                        if (countsqrt>0){
                            while (countsqrt>0){
                                text_xu_ly=text_xu_ly + ")";
                                countsqrt--;
//                                Toast.makeText(MainActivity.this, text_xu_ly, Toast.LENGTH_SHORT).show();
                            }
                            text_xu_ly=text_xu_ly+"^0.5";
                        }


                        Caculater caculater= new Caculater(text_xu_ly);
                        text_xu_ly =caculater.ketqua();
                        text_show =caculater.ketqua();
                        countngoac=0;
                        binding.editText.setText(text_show);
                    }
                }
                if (v==binding.btnthapphan){
                    if (text_xu_ly.equals("nhap")) {}
                    else {
                        text_xu_ly = text_xu_ly +".";
                        text_show = text_show +".";
                        binding.editText.setText(text_show);
                    }
                }
                if (v==binding.btnpi){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show="";
                    }
                    text_xu_ly = text_xu_ly +"p";
                    text_show = text_show +"π";
                    binding.editText.setText(text_show);


                }
                if (v==binding.btnAC){
                    text_xu_ly ="nhap";
                    text_show ="nhap";
                    countngoac=0;
                    countsqrt=0;
                    binding.editText.setText(text_show);
                }
                if (v==binding.btnC){
                    if (text_xu_ly.equals("nhap")){}
                    else if ((text_show.length()>=2)&&(text_show.charAt(text_show.length()-2)=='√')){
                        text_xu_ly = text_xu_ly.substring(0, text_xu_ly.length()-1);
                        text_show =text_show.substring(0,text_show.length()-2);
                        countsqrt--;
                        countngoac--;
                        binding.editText.setText(text_show);
                    }
                    else if (text_show.charAt(text_show.length()-1)=='%'){
                        text_xu_ly = text_xu_ly.substring(0, text_xu_ly.length()-4);
                        text_show =text_show.substring(0,text_show.length()-1);
                    }
                    else {

                        if (text_xu_ly.charAt(text_xu_ly.length()-1)=='('){
                            countngoac--;
                        }
                        else if(text_xu_ly.charAt(text_xu_ly.length()-1)==')'){
                            countngoac++;
                        }
                        text_xu_ly = text_xu_ly.substring(0, text_xu_ly.length()-1);
                        text_show =text_show.substring(0,text_show.length()-1);
                        if (text_xu_ly.length()==0){
                            text_xu_ly ="nhap";
                            text_show ="nhap";
                        }
                        binding.editText.setText(text_show);

                    }
                }
                if (v==binding.btnngoac){
                    if(countngoac==0){
                        if(text_xu_ly.equals("nhap")) {
                            text_xu_ly ="";
                            text_show ="";
                        }
                        text_xu_ly = text_xu_ly +'(';
                        text_show = text_show +'(';
                        countngoac++;
                        binding.editText.setText(text_show);
                    }
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){
                        if ((countngoac>0)&&(text_xu_ly.charAt(text_xu_ly.length()-1)==')')){
                            text_xu_ly = text_xu_ly +')';
                            text_show = text_show +')';
                            countngoac--;
                            if (countsqrt>0){
                                countsqrt--;
                                if(countsqrt==0){
                                    text_xu_ly=text_xu_ly+"^0.5";
                                }
                            }
                            binding.editText.setText(text_show);
                        }
                        else{
                            text_xu_ly = text_xu_ly +'(';
                            text_show = text_show +'(';
                            countngoac++;
                            binding.editText.setText(text_show);
                        }

                    }
                    else{
                        text_xu_ly = text_xu_ly +')';
                        text_show = text_show +')';
                        countngoac--;
                        if (countsqrt>0){
                            countsqrt--;
                            if(countsqrt==0){
                                text_xu_ly=text_xu_ly+"^0.5";
                            }
                        }
                        binding.editText.setText(text_show);
                    }
                }
                if(v==binding.btnsqrt){
                    if (text_xu_ly.equals("nhap")) {
                        text_xu_ly ="";
                        text_show="";
                    }
                    text_xu_ly = text_xu_ly +"(";
                    text_show = text_show +"√(";
                    countngoac++;
                    countsqrt++;
                    binding.editText.setText(text_show);

                }
                if (v==binding.btnpow){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"^";
                        text_show = text_show +"^";
                        binding.editText.setText(text_show);
                    }
                }
                if(v==binding.btngiaithua){
                    if (text_xu_ly.equals("nhap")) {}
                    else if(((text_xu_ly.charAt(text_xu_ly.length()-1)<'0')||(text_xu_ly.charAt(text_xu_ly.length()-1)>'9'))&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='p')
                            &&(text_xu_ly.charAt(text_xu_ly.length()-1)!=')')&&(text_xu_ly.charAt(text_xu_ly.length()-1)!='!')){}
                    else {
                        text_xu_ly = text_xu_ly +"!";
                        text_show = text_show +"!";
                        binding.editText.setText(text_show);
                    }
                }



            }
        };



        binding.btn0.setOnClickListener(event);
        binding.btn1.setOnClickListener(event);
        binding.btn2.setOnClickListener(event);
        binding.btn3.setOnClickListener(event);
        binding.btn4.setOnClickListener(event);
        binding.btn5.setOnClickListener(event);
        binding.btn6.setOnClickListener(event);
        binding.btn7.setOnClickListener(event);
        binding.btn8.setOnClickListener(event);
        binding.btn9.setOnClickListener(event);
        binding.btncong.setOnClickListener(event);
        binding.btntru.setOnClickListener(event);
        binding.btnnhan.setOnClickListener(event);
        binding.btnchia.setOnClickListener(event);
        binding.btnbang.setOnClickListener(event);
        binding.btnthapphan.setOnClickListener(event);
        binding.btnpi.setOnClickListener(event);
        binding.btnAC.setOnClickListener(event);
        binding.btnbang.setOnClickListener(event);
        binding.btnC.setOnClickListener(event);
        binding.btnngoac.setOnClickListener(event);
        binding.btnsqrt.setOnClickListener(event);
        binding.btnpow.setOnClickListener(event);
        binding.btnphantram.setOnClickListener(event);
        binding.btngiaithua.setOnClickListener(event);






        setActivity();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu từ file menu_main.xml vào Menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;  // Trả về true để menu được hiển thị
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Xử lý sự kiện khi chọn một mục menu
        if(item.getItemId()==R.id.mnuhistory){
            if(1>2){}

            return true;
        }
        else if(item.getItemId()==R.id.background_green){
//            item.setChecked(!item.isChecked());

            binding.main.setBackgroundColor(Color.parseColor("#E1E7B8")); // Đổi màu nền thành xanh

            return true;
        }
        else if(item.getItemId()==R.id.background_red){
            binding.main.setBackgroundColor(Color.parseColor("#FBA6C3"));

            return true;
        }
        else if(item.getItemId()==R.id.background_yellow){
            binding.main.setBackgroundColor(Color.parseColor("#EDE281"));

            return true;
        }
        else if(item.getItemId()==R.id.background_blue){
            binding.main.setBackgroundColor(Color.parseColor("#9AD8F4"));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setActivity(){
        String s = binding.editText.getText().toString();

    }

}