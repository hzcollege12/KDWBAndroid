//P187 Íõ´ïºê

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