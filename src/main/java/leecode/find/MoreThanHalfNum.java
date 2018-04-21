package leecode.find;

/**
 * Created by tuomao on 2017-07-13.
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution1(int [] array) {
        if(array==null||array.length==0) return 0;
        int n=helper(array,0,array.length-1);
        int counter=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==n) counter++;
        }
        if(counter>array.length/2) return n;
        return 0;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0) return 0;
        int n,c=0;
        n=array[0];
        int i=1;
        c=1;
        while (i<array.length){
            if(array[i]==n) {
                c++;
            } else {
                if(c>0) {
                    c--;
                }else {
                    n=array[i];
                    c=1;
                }
            }
            i++;
        }

        int counter=0;
        for(i=0;i<array.length;i++){
            if(array[i]==n) counter++;
        }
        if(counter>=(array.length+1)/2) return n;
        return 0;
    }

    public int helper(int array[], int l,int r){

        int p=partition(array,l,r);
        if(p==array.length/2) return array[p];
        else if(p<array.length/2) return    helper(array,p+1,r);
        else return helper(array,l,p-1);
    }


    public int partition(int[] array,int l,int r){
        int i=l,j=r;
        int base=array[l];
        while (i<j){
            while (j>i && array[j]>=base) j--;
            array[i]=array[j];
            while (i<j && array[i]<=base) i++;
            array[j]=array[i];
        }
        array[i]=base;
        return i;
    }


}
