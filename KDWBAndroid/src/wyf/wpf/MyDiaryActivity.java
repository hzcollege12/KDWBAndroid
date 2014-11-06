//37张伟雄

package wyf.wpf;
import android.app.Activity;
import android.widget.ListView;
public class MyDiaryActivity extends Activity{
	MyConnector mc=null;
ArrayList<String[]>diaryList=new ArrayList<String[]>();
ListView lvDiary=null;
int positionToDelete=-1;
String uno =null;
Handler myHandler=new Handler(){
public void handleMessage(Message msg){
	switch(msg.what){
case:0:
lvDiary.setAdapter(ba);
break;
}
super.handleMessage(msg);
}
};
BaseeAdapter ba= new BaseAdapter(){
View.OnClickListener listenerToEdit=new View.OnClickListener(){};
View.OnClickListener listenerDelete=new View.OnClickListener(){};
protected void onCreate(Bundle saveInstanceState){
super.onCreate(saveInstanceState);
Intent intent=getIntent();
uno=intent.getStringExtra("uno");
setContentView(R.layout.diary);
lvDiary=(ListView)findViewById(R.id.lvDiary);
getDiaryList();
}
public void deleteDiary(){}
public void getDiaryList(){}
protected void onDestroy(){}
}
public void deleteDiary(){ 
    new Thread(){
     public void run(){
        Looper.prepare();
          try{
                if(mc==null){
                    mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
                                         }
                String rid =diaryList.get(position ToDelete)[0];
                String msg ="<#DELETE_DIARY#>"+rid;
                mc.dout.writeUTF(msg); 
                String reply=mc.din.readUTF();
                if(reply.equals("<#DELETE_DIARY_SUCCESS#>")){
                Tost.makeText(MyDiaryActivity.this,"删除日志成功！",Toast.LENGTH_LONG).show();
                    getDiaryList();
                    Looper.loop();
                 }
                 else{
                 Tost.makeText(MyDiaryActivity.this,"删除失败，请重试！",Toast.LENGTH_LONG).show();
                    Looper.loop();
                  }
     }catch(Exception e){e.printStackTrace();}
                  Looper.myLooper().quit();
         }
    }.start();
}
public void getDiaryList(){
new Thread(){
public void run(){
try{
mc=new MyConnector(SERVER_ADDRESS,SERVER_PORT);
mc.dout.writeUTF("<#GET_DIARY#>"+uno+"|"+"1");
int size=mc.din.readInt();
diaryList=null;
diaryList=new ArrayList(String[])();
for(int i=0;i<size;i++){
String diaryInfo=mc.din.readUTF();
String[] sa =diaryInfo.split("\\|");
diaryList.add(sa);
}
myHandler.sendEmptyMessage(0);}
}
}.start();
}