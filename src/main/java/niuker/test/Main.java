package niuker.test;

import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();

        ArrayList<Integer> tables=new ArrayList(n);
        for(int i=0;i<n;i++){
            tables.add(s.nextInt());
        }

        ArrayList<ArrayList<Integer>> users=new ArrayList(m);
        for(int i=0;i<m;i++){
            ArrayList<Integer> u=new ArrayList(2);
            u.add(s.nextInt());
            u.add(s.nextInt());
            users.add(u);
        }
        System.out.println(getMaxConsume(tables,users));

    }

    public static int getMaxConsume(ArrayList<Integer> t,ArrayList<ArrayList<Integer>> users){
        if(t==null || t.size()==0 || users==null || users.size()==0) return 0;

        Collections.sort(t);

        Collections.sort(users,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
                return a1.get(1).compareTo(a2.get(1));
            }
        });

        System.out.println(users);
        int flags[] =new int[users.size()];

        for(int i=0;i<flags.length;i++) flags[i]=0;
        int r=0;

        for(int i=0;i<t.size();i++){
            int index=-1;
            for(int j=users.size()-1;j>=0;j--){
                if(users.get(j).get(0)<=t.get(i)){
                    if(flags[j]==0){
                        if(index==-1) index=j;

                        else{
                            if(users.get(j).get(1)==users.get(index).get(1)){
                                if( users.get(j).get(0) > users.get(index).get(0))   index=j;
                            }else{
                                break;
                            }

                        }

                    }
                }
            }

            if(index!=-1){
                flags[index]=1;
                r+=users.get(index).get(1);
                System.out.println(t.get(i)+" choose:"+ users.get(index));
            }

        }
        return r;
    }


}