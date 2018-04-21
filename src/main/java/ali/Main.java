package ali;

import java.util.*;

/**
 * Created by tuomao on 2017-08-16.
 */
public class Main {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
        String cards=scanner.nextLine();
        String inCards=scanner.nextLine();

    }
    public static String out(String cards,String inCards){
        if(cards==null || cards.length()==0|| inCards==null|| inCards.length()==0) return "0";
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<cards.length();i++){
            list.add(cards.substring(i,i+1));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareCard(o1.charAt(0),o2.charAt(0));
            }
        });

        String result="0";
        StringBuffer buffer=new StringBuffer();
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<cards.length();i++){
            String a=cards.substring(i,i+1);
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }

        if(inCards.length()==1){// 单牌
            char b=inCards.charAt(0);

            int min=-10000;
            // 找单个的
            for(int i=0;i<cards.length();i++){
                int r=compareCard(cards.charAt(i),b);
                if(r>0&& r<min){
                    min=r;
                    result=String.valueOf(cards.charAt(i));
                }
            }
            if(min<0){
                // 4个头
                for(int i=0;i<cards.length();i++){
                    if (map.get(cards.substring(i,i+1))==4){
                    }
                }
            }

        }else  if(inCards.length()==2){
            if(inCards.charAt(0)!=inCards.charAt(1)) return "0";
            for(int i=0;i<list.size();i++){
                if(map.get(list.get(i))==2 && compareCard(list.get(i).charAt(0),cards.charAt(0))>0) {
                    return list.get(i)+list.get(i);
                }
            }
        }else if(inCards.length()==5){// 顺子

        }else if(inCards.length()==4){// 连对
            int flag=0;
            for(int i=0;i<inCards.length()-1;i++){
                if(inCards.charAt(i)!=inCards.charAt(i+1)) {
                    flag=1;
                    break;
                }
            }
//            if(flag==0){// 4个头
//                for(int i=0;i<list.size();i++){
//                    if(compareCard(list.get(i).charAt(0),inCards.charAt()))
//                }
//            }else{// 连对
//
//            }
        }else {

        }

        return result;
    }


    public static int compareCard(char a,char b){
        return getCardNumber(a)-getCardNumber(b);
    }

    public static int getCardNumber(char a){
        switch (a){
            case '2':
                return 15;
            case 'A':
                return 14;
            case 'I':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
        }
        return a-'0';
    }

//    public char findMin(List<String> list,String s){
//        for(int i=0;i<list.size();i++){
////            if(compareCard(list.get(i).charAt(0),s))
//        }
//        return
//    }
}