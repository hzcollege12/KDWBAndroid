//RegActivity.java  146页 23 
//23 丘远柱


 package wyf.wpf;
import android.content.Intent;
...
import android.widget.Toast;
pubic class RegActivity extends Activity{
   MyConnector mc = null;
   String un ="";
   ProgressDialog pd = null;
   Handler myHandler = new Handler(){}
   proted void onCreae(savedInsanceState);
   setContentView(R.layout.reg);
   Button btnReg = (Button)findViewById(R.id.btnReg);
   btnReg.setOnClickListener(new View.OnClickListener(){
   public void onClick(View v){
   pd = ProgressDialog.show(RegActivity.this,"请稍候...","正在连接服务器...",
   false );
   register(); 
}

 });
   Button btnBack = (Button)findViewById(R.id.btnBack);
btnBack.setOnClickListener(new View.OnClickListener(){
public void onClick(View v){
Intent intent = new Intent(RegActivity.this,LoginActivity.class);
    startActivity(intent);
    finish();
 }

 });
 Button btnEnter = (Button)findViewById(R.id.btnEnter);
 btEnter.setOnClickListener(mew View.OnClickListener(){
 public void onClick(View v){
 Intent intent = new Intent(RegActivity.this,FunctionTabActivity.class);
 intent.putExtra("uno",uno);
 startActivity(intent);
 finish();

}

}); 

}
public void register(){
protectad void onDestroy(){
}
}