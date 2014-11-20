//”‡Õ¶ ’≈º”≈Ù

package wyf.wpf;
import java.util.ArrayList;
..
import android.widget.AdapterView.OnItemClickListener;
public class ContactsActivity extends Activity{
String uno=null;
int type=-1;
Bitmap[]headList=null;
ArrayList<String[]>infoList=null;
MyConnector me=null;
ListView lv=null;
String[] messageHead= new Handler(){
@Override
public void handleMessage(Message msg){
switch(msg.what){
case 0:
lv.seAdapter(baContacts);
break;
}
super.handleMessage(msg);
}
};
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
Intent intent=getIntExtra("uno");
type=intent.getIntExtra("type",-1);
if(type==0){
baContacts=new BaseAdapter{
else if (type==1){
baContacts=new BaseAdapter()
}
setContentView(R.layout.contacts);
lv=(ListView)findViewByld(R.id.listFriend);
getContact£®£©;
lv.setOnItemCltckListener(new OnItemClickListener(){
public void onItemClick(AdapterView<?>parent,View v,int position,long id){
Intent intent = new Intent(ContactsActivity.this,HomePageActivity.class);
intent.putExtra("uno",infoList.get(position)[0]);
intent.putExtra("visitor",uno);
startActivity(intent);
}
});

}
public void getContact(){
protected void onDestroy(){


public void getContact(){
new Thread(){
public void run(){
try{
mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
me.dout.writeUTF(messageHead[type]+uno);
int size = mc.din.readInt();
headList = null;
infoList = null;
headList = new Bitmap[size];
infoList = new ArrayList<String []>(size);
for(int i=0;i<size;i++){
String fInfo = mc.din.readUTF();
String[]sa = fInfo.split("\\|");
infoList.add(sa);
int headSize = mc.din.readInt();
byte[]buf = new byte[headSize];
mc.din.read(buf);
headList[i] = BitmapFactory.decodeByteArray
(buf,0,headSize);
}
}catch(Exception e){e.printStackTrace();}
myHandler.sendEmptyMessage(0);
}
}.start();
}

}