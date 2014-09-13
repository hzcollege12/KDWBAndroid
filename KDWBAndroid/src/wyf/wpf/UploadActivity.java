//�ļ����ƣ�UploadActivity
//ҳ�룺192-196
//������29,30  Ҷ����,лά 
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
						Toast.makeText(UploadActivity.this, "�㻹û�д����κ���ᣡ", Toast.LENGTH_LONG).show();
						albumList = new ArrayList<String []>();
						albumList.add(new String[]{null,"�����"});
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
						Toast.makeText(UploadActivity.this, "��ᴴ���ɹ���", Toast.LENGTH_LONG).show();
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
						Toast.makeText(UploadActivity.this, "��Ƭ�ϴ��ɹ���", Toast.LENGTH_LONG).show();
						Looper.loop();
					}
					else{
						pd.dismiss();
						Toast.makeText(UploadActivity.this, "��Ƭ�ϴ�ʧ�ܣ�", Toast.LENGTH_LONG).show();
						Looper.loop();
					}
				}catch(Exception e){e.printStackTrace();}
			}
		}.start();
	}

}
