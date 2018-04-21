package designMode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tuomao on 2017-08-28.
 */
public class ObserverTest {

    @Test
    public void test(){
        ConcreteSubject subject=new ConcreteSubject();
        Observer observer1=new ConcreteObserver("wsh");
        Observer observer2=new ConcreteObserver("hy");
        subject.register(observer1);
        subject.register(observer2);
        subject.chageState("有新消息");
    }
}

interface Observer{
    public void onUpdate(Object o);
}



class ConcreteObserver implements Observer{

    String name;
    public  ConcreteObserver(String name){
        this.name=name;
    }
    @Override
    public void onUpdate(Object o) {
        System.out.println(name+"接受到通知"+o);
    }
}

abstract class Subject{
    private ArrayList<Observer> observers=new ArrayList<>();

    public void register(Observer observer){
        if(!observers.contains(observer)) observers.add(observer);
    }

    public void unRegist(Observer observer){
        if(observers.contains(observer)) observers.remove(observer);
    }
    public void nodifyObservers(String newState){
        for(Observer observer:observers) observer.onUpdate(newState);
    }
}

class ConcreteSubject extends Subject{

    String state;

    public void chageState(String state){
        this.state=state;
        nodifyObservers(state);
    }
}


