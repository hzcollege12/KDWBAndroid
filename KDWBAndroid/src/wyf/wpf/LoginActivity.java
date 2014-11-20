//刘俊1麟
package wyf.wpf;//声明包语句
import static wyf.wpf.ConstantUtil.*;	//静态引入ConstantUtil类的静态成员
...//此处省略部分引入相关类的代码
import android.widget.Toase;	//引用相关类
public class LoginActivity extends Acitity{
	MyConnector mc = null;		//声明MyConnector对象引用
	ProgressDialog pd;		//声明ProgressDialog对象引用
	@Override
	public void onCreate(Bundle savedInstanceState){	//重写onCreate方法
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);		//设置当前屏幕
		checkIfRemember();		//检查是否曾经记录过帐号和密码
		Button btnLogin = (Button)findViewById(R.id.btnLogin);		//获得登录Button对象
			btnLogin.setOnClickListener(new View.OnClickListener(){		//为“登录”按钮添加监听器
				public void onCreate(View v){		//重写onClick
					pd = ProgressDialog.show(LoginActivity.this,"请稍后","正在连接服务器...",true,true);
					login();		//调用login方法获得
				}
			});
	Button btnReg = (Button)findViewById(R.id.btnReg);		//获得注册Button对象
		btnReg.setOnClickListener(new View.OnClickListener(){		//为“注册”按钮添加监听器
			public void onClick(View v){		//重写onClick
				Intent Intent =new Intent(LoginActivity.this, wyf.wpf.RegActivity.class);
				startActivity(Intent);		//启动负责注册的Activity
				finish();		//结束本Activity的运行
			}
		});
		ImageButton ibExit = (ImageButton)findViewById(R.id.ibExit);
		//获得退出 ImageButton 对象
		ibExit.setOnClickListener(new View.OnClickListener(){
			public void onCreate(View v){
				android.os.Process.killProcess(android.os.Process.MyPid());
				//结束进程，退出程序
			}
		});
	}
	public void login(){
		public void rememberMe(String uid,String pwd){//方法：将用户的id和密码存入Preferences
			}
		public void checkIfRemember(){				//方法：从Preferences中读取用户名和密码
			protected void onDestroy(){
				if(mc!==null){						//判断MyConnector是否为null
					mc.sayBye();					//调用通知服务器客户端结束通信
					mc=null;
				}
			}
			super.onDestroy();						//调用父类的onDestroy
			}
		}		
	}
