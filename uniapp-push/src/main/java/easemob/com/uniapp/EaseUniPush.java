package easemob.com.uniapp;


public class EaseUniPush {
    private static EaseUniPush instance;


    private EaseUniPush() {}

    public static EaseUniPush getInstance() {
        if(instance == null) {
            synchronized (EaseUniPush.class) {
                if(instance == null) {
                    instance = new EaseUniPush();
                }
            }
        }
        return instance;
    }


    public void xiaomi(){

    }

}
