//  ����  ������
package wyf.wpf;
import java.util.ArrayList;
import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Spinner;
import android.widget.TextView;
/*import android.widget.ViewSwitcher;  
import android.widget.ViewSwitcher.ViewFactory;*/

public class AlbumActivity extends Activity implements ViewSwitcher.ViewFactory{
	List<String []> photoInfoList = new ArrayList<String []>();
	Bitmap [] photoList;
	Gallery gl=null;
	Spinner sp=null;
	MyConnector mc=null;   //MyConnector文件还未定义
	String xid="";
	String uno="";
	String visitor="";
	String pid="";
	int from=-1;
	List<String []>albumInfoList=new ArrayList<String []>();
	BaseAdapter baSpinner = new BaseAdapter(){};
	BaseAdapter baGallery = new BaseAdapter(){};
	OnItemClickListener myListener = new OnItemClickListener(){};
	Handler myHandler = new Handler(){
		
	};
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.album);
			Intent intent = getIntent();
			uno=intent.getStringExtra("uno");
			visitor=intent.getStringExtra("vistor");
			from=intent.getIntExtra("from",-1);
			int position=intent.getIntExtra("position",0);
			String [] albumInfoArray=intent.getStringArrayExtra("albumlist");
			xid=intent.getStringExtra("xid");	
			albumInfoList=new ArrayList<String[]>();
			for(String s:albumInfoArray){
				String[]sa=s.split("\\|");
				albumInfoList.add(sa);
			}
		sp=(Spinner)findViewById(R.id.spAlbum);
		sp.setAdapter(baSpinner);
		sp.setSelection(position);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			gl=(Gallery)findViewById(R.id.galleryPhoto);
			gl.setOnItemClickListener(myListener);
			is=(ImageSwitcher)findViewById|(R.id.isPhoto);
			is.setFactory(this);
			is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
			is.setOutAnimation(AnimationUtils.loadAnimation(this,andriod.R.anim.fade_out));
			Button btnBack=(Button)findViewById(R.id.btnAlbumBack);
			btnBack.setOnClickListener(new View.OnClickListener(){});
			Button btnDeletePhoto =(Button)findViewById(R.id.btnDeletePhoto);
			if(visitor !=null){
				btnDeletePhoto.setVisibility(View.GONE);
				
			}
			btnDeletePhoto.setOnClickListener(new 
		}
		View.OnClickListener(){
			public void getPhotoList(){}
			public void deletePhoto(){}
			public View makeView(){}	
	

		}
	}


