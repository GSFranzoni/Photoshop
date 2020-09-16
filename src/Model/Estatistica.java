
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estatistica {
    public static int count(ArrayList<Integer> arr, int value){        
        int count=0;
        for(int i: arr)
            if(value==i)
                count++;
        return count;
    }
    
    public static int max(ArrayList<Integer> arr){
        return Collections.max(arr);
    }
    
    public static int min(ArrayList<Integer> arr){
        return Collections.min(arr);
    }
    
    public static int moda(ArrayList<Integer> arr, int centro){
        int moda = -1, count = -1, aux;
        for(int i=0; i<arr.size(); i++){
            aux = count(arr, arr.get(i));
            if(aux>count){
                moda = arr.get(i);
                count = aux;
            }
            else if(aux==count){
                if(Math.abs(moda-centro)>=Math.abs(arr.get(i)-centro)){
                    moda = arr.get(i);
                    count = aux;
                }
            }
        }
        return moda;
    }
   
    public static int media(List<Integer> list){
        int media = 0;
        media = list.stream().map((i) -> i).reduce(media, Integer::sum);
        return (int) Math.ceil(media/list.size());
    }
    
    public static int mediana(ArrayList<Integer> arr){
        arr.sort(null);
        if(arr.size()%2==0){
            return (int)(arr.get((int)(arr.size()/2))+arr.get((int)(arr.size()/2)-1))/2;
        }
        return (int)arr.get((int)arr.size()/2);
    }
}
