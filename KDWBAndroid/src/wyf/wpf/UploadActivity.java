//文件名称：UploadActivity
//页码：192-196
//姓名：29,30  叶春贵,谢维 
package wyf.wpf;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Looper;
import android.widget.Toast;

public class UploadActivity extends Activity{


	public void getAlbumList(){
		new Thread(){
			public void run(){
				
				try {
					if(mc == null){
						mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
					}
					mc.dout.writeUTF("<#GET_ALBUM_LIST#>"+uno);
					String reply = mc.din.readUTF();
					if(reply.equals("<#NO_ALBUM#>")){
						Toast.makeText(UploadActivity.this, "你还没有创建任何相册！", Toast.LENGTH_LONG).show();
						albumList = new ArrayList<String []>();
						albumList.add(new String[]{null,"无相册"});
						return;
					}
					String albumArray [] = reply.split("\\$");
					albumList = null;
					albumList = new ArrayList<String[]>();
					for(String s:albumArray){
						String [] sa = s.split("\\|");
						albumList.add(sa);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myHandler.sendEmptyMessage(0);
			}
		}.start();
	}
	
	public void createNewAlbum(){
		new Thread(){
			public void run(){
				Looper.prepare();
				try {
					if(mc == null){
						mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
					}
					mc.dout.writeUTF("<#NEW_ALBUM#>"+newAlbum+"|"+uno);
					String reply = mc.din.readUTF();
					if(reply.equals("<#NEW_ALBUM_SUCCESS#>")){
						getAlbumList();
						Toast.makeText(UploadActivity.this, "相册创建成功！", Toast.LENGTH_LONG).show();
						Looper.loop();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Looper.myLooper().quit();
			}
		}.start();
	}
	
	public void uploadMyPhoto(){
		new Thread(){
			public void run(){
				Looper.prepare();
				if(mc == null){
					mc = new MyConnector(SERVER_ADDRESS,SERVER_PORT);
				}
				try{
					String msg = "<#NEW_PHOTO#>"+name+"|"+des+"|"+xid;
					mc.dout.writeUTF(msg);
					mc.dout.writeInt(data.length);
					for(int i=0;i < data.length;i++){
						mc.dout.writeByte(data[i]);
					}
					mc.dout.flush();
					String reply = mc.din.readUTF();
					if(reply.equals("<#NEW_PHOTO_SUCCESS#>")){
						pd.dismiss();
						Toast.makeText(UploadActivity.this, "照片上传成功！", Toast.LENGTH_LONG).show();
						Looper.loop();
					}
					else{
						pd.dismiss();
						Toast.makeText(UploadActivity.this, "照片上传失败！", Toast.LENGTH_LONG).show();
						Looper.loop();
					}
				}catch(Exception e){e.printStackTrace();}
			}
		}.start();
	}

}
