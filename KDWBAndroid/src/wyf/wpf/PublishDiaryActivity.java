 package wyf.wpf;
 import static wyf.wpf.ConstantUtil.SERVER_ADDRESS;
 ...
 import android.widet.Toast;
 public class PublishDiaryActivity extends Activity{
       MyConnector mc=null;
       ProgressDialog pd= null;
       string uno = null;
       protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       Intent intent= getIntent();
       uno= intent.getStringExtra("uno");
       setContentView(R.layout.publish_diary);
       Button btnDiay=(Button)findViewByld(R.id.btnDiary);
       btnDiary.setOnClickListener(newView.OnClickListener(){
                public void onClick(View v) {
               publishDiary();
           }
   });
    Button btn DiaryBack=(Button)findViewByld(R.id.btnDiaryBack);
    btnDiaryBack.setOnClickListener(new View.OnClickListener(){
         pubic void onClick(View v){
          finish();
       }
   });
 }
   public void publishDiary(){
   protected void onDestroy(){
}



//P187 �����

 public void publishDiary(){
             new Thread(){
                  public void run(){
                        Looper.perpare();
                        EditText etTitle = (EditText)findViewById(R.id.etTitle);
                        EditText etDiary = (EditText)findViewById(R.id.etDiary);
                        String title = etTitle.getEditableText().toString().trim();
                        String diary = etDiary.getEditableText().toString().trim();
                        if(title.equals("")||diary.equals("")){
                                Toast.makeText(PublishDiaryActivity.this,
                                Toast.LENGTH_LONG).show();
                                return;
                        }
                        try{
                                if(mc = null){
                                      mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
                                }
                        String message = "<#NEW_DIARY#>"+title+"|"+diary+"|"+uno;
                        mc.dout.writeUTF(message);
                        String reply = mc.din.readUTF();
                        pd.dismiss();
                  if(reply.equals("<#DIARY_SUCCESS#>")){
                              pd.dismiss();
                              Toast.makeText(PublishDiaryActivity.this,"
                        Toast.LENGTH_LONG).show();
                        Looper.loop();
                  }
                  else if(reply.equals("<#DIARY_FAIL#>")){
                        pd.dismiss();
                        Toast.makeText(PublishDiaryActivity.this,"
                        Toast.LENGTH_LONG).show();
                        Looper.loop();
                  }
                  }catch(Exception e){e.printStackTrace();}
                  Looper.myLooper().quit();
                  }
 }.start();