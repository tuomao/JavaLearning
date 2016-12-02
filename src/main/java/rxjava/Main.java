package rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuomao on 2016/9/30.
 */
public class Main {
    public static void main(String[] agrs){
        //test();
       //from_test();
        List<String> list=Arrays.asList("1111","3","5");
        Observable.from(list)
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        List<String> list1 = new ArrayList<String>();
                        for (int i = 0; i < s.length(); i++) {
                            list1.add(s.substring(i, i + 1));
                        }
                        return Observable.from(list1);
                    }
                })
                .subscribe(s -> System.out.println(s));
    }

    public static void test(){
        //被观察者
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {

                    public void call(Subscriber<? super String> sub) {

                        // 发射出字符串
                        sub.onNext("Hello, world!");
                        sub.onCompleted();

                    }
                }
        );

        //订阅者
        Subscriber subscriber = new Subscriber<String>() {

            public void onCompleted() {
                System.out.println("Complete!");
            }

            public void onError(Throwable e) {
            }

            public void onNext(String o) {
                System.out.println("onNext: " + o);
            }
        };

        //订阅者
        Subscriber subscriber1 = new Subscriber<String>() {

            public void onCompleted() {
                System.out.println("ss Complete!");
            }

            public void onError(Throwable e) {
            }

            public void onNext(String o) {
                System.out.println("subscriber 1onNext: " + o);
            }
        };

        myObservable.subscribe(subscriber);
        myObservable.subscribe(subscriber1);
    }

    public static void just_test(){
        Observable.just("Hello, world111!")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));
    }
    public static void from_test(){
        List<String> list= Arrays.asList("1","2","3");
        Observable.from(list)
                .subscribe(s -> System.out.println(s));
    }
}
