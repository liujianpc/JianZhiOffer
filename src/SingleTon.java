/**
 * Date: 2019/1/2
 * Created by Liuian
 */

/**
 * 1、懒汉（懒加载）  double check的類型
 */
/*
class SingleTon {
    private volatile static SingleTon sInstance = null;
    private SingleTon(){

    }

    public static SingleTon getInstance() {
        if (sInstance == null){
            synchronized (SingleTon.class){
                if (sInstance == null){
                    sInstance = new SingleTon();
                }
            }
        }
        return sInstance;
    }
}
*/

/**
 * 2、餓漢模式  沒有懶加載，直接初始化
 */

/*
class SingleTon{
    private static SingleTon sInstance = new SingleTon();
    private SingleTon(){

    }

    public static SingleTon getInstance(){
        return sInstance;
    }
}
*/

/**
 * 3、内部类模式，懒加载且线程安全
 *
 */

class SingleTon{
    private SingleTon(){}
    static class Holder{
        static final SingleTon INSTANCE = new SingleTon();
    }
    public SingleTon getInstance(){
        return Holder.INSTANCE;
    }
}



