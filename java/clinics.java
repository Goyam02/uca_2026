import java.util.*;


public class clinics{


    private void reverse(int[] population){
        int left = 0;
        int right = population.length - 1;

        while(left < right){
            int temp = population[left];
            population[left] = population[right];
            population[right] = temp;
            left++;
            right--;
        }

    }

    public double minMaxLoad(int[] population, int k){
        int n = population.length;

        Arrays.sort(population);
        reverse(population);

        int[] village = new int[n];

        for(int i = 0; i < n ; i++){
            village[i] = 1;

        }

        int remaining = k - n;

        while(remaining > 0){

            int maxIndex = 0;


            for(int i = 1; i < n ; i++){
                double currLoad = (double) population[i]/ village[i];
                double maxLoad = (double) population[maxIndex]/ village[maxIndex];

                if(currLoad > maxLoad) maxIndex = i;
            }

            village[maxIndex]++;
            remaining --;

        }

        double ans = 0;

        for(int i = 0; i < n; i++){

            double load = (double) population[i] / village[i];

            ans = Math.max(ans, load);
        }

        return ans;
    }



    
}

class Main{

    public static void main(String[] args){

        clinics test1 = new clinics();

        int[] population = {200, 20, 50};

        double ans = test1.minMaxLoad(population, 5);
        System.out.println(ans);


    }
}