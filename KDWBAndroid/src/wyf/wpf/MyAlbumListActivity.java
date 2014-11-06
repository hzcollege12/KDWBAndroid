//陈坤凤//朱启
package wyf.wpf;

import java.awt.List;

import javax.swing.text.html.ListView;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
public class MyAlbumListActivity<MyConnector, BaseAdappter> extends Activity{
	MyConnector mc = null;
	ListView lvAlbumList = null;
	List albuminfoList = null;
	String albumInfoArray[] = null;
	String uno = null;
	int newAccess = -1;
	String [] acessOptions={"公开","好友可见","仅个人可见"};
	int albumIndexToChange= -1;
	String albumToChange = null;
	String accessToChange = null;
	BaseAdappter ba = new BaseAapter(){
	View.OnClickListener listenerToDetail = new View.OnClickListener(){
		public void onClick(View v){//重写 onClick方法Intent intent =new Intent(My AlbumListActivity.this,AlbumActivity.class);
		intent.putExtra("uno",uno);
		intent.putExtra("albumlist",labumInfoArray);
		intent.putExtra("xiu",albuminfoList.get(v.getId())[0]);
		intent.putExtra("position",v.getId());
		intent.putExtra("form",0);
		startActivity(intent);
		finish();
		
		}
	View.OnClickListener listenerToAcess  = new View.OnClickListener(){
		public void onClick(View v){
			albumIndexToChang=v.getId();
			albumTochange = albumInfoList.getId()[0];
			newAcess = Integer.valueOf(albumInfoList.get(v.getId())[2]);
			showMyDialog();
		}
	Handlerr myHandler new Handler(){
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanctState);
			setContentView(R.layout.album_list);
			Intent intent = getIntent();
			uno= intent.getStringExtra("uno");
			lvAlbumList=(ListView)findViewById(R.id.lvAlbumList);
			getlvAlbumList();
		}
		public void lvAlbumList(){
		public void showMyDialog(){
		public int changeAlbumAcess(){
		protected void onDestroy(){}
	public void getAlbumList(){
		new Thread(){
			public void run(){
				Looper.prepare();
				try{
					if(mc==null){
						mc= new MyConnector(SERVER_ADDRESS,SERVER_POPT);
				 }
				
				mc.dout.writeUTF("#GET_ALBUM_LIST#>"+uno);
				String reply=mc.din.readUT();
				if(reply.equals("<#NO_ALBUM#>")){
					Toast.makeText(MyAlbumActivity.this,"你还未上传照片"，
					Toast.LENGTH_LONG).show();
					Looper.loop();
					return;
			}
				albumInfoArray=reply.split("\\$");
				albumInfoList= new ArrayList<String []>();
				for(String s:albumInfoArray){
					String [] sa =s.splist("\\|);" 
				albumInfoList.add(sa);
				}
				myHandler.sendEmptyMessage(0);
		}catch(Exception e){e.printStackTrace();}
	}
		}
	}.start();
		}
	//
