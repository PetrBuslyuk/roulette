import java.util.Random;
import java.lang.Math;
public class Main {
    final static int numbers = 37;
    final static int needed = 5;
    final static int spins = 150;
    final static int STOP = 12;
    final static int trying = 12;
    static int balans = 256;

    public static int generate(int min,int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void main(String[] args) {
        int totalProfitCount = 0;
        int totalProfitSumm = 0;
        while(true){
            int redCount = 0;
            int blackCount = 0;
            int failed = 0;
            int win = 0;
            int totalProfit = 0;

            while(failed!=STOP){
                //System.out.println("count black "+blackCount+" count red "+redCount);
                int current = generate(0,numbers);
                if(current==0){
                    //System.out.println("Zero ");
                    if (redCount == needed){
                        ++failed;
                        //System.out.println("Failed red(count)= "+redCount+", failed = " +failed);
                    }
                    if(blackCount == needed ){
                        ++failed;
                        //System.out.println("Failed black(count)= "+blackCount+", failed = "+failed);
                    }
                    redCount = 0;
                    blackCount = 0;
                }else if(current%2==0){
                    redCount++;
                    //System.out.println("_______________ " +current+ " _______________");
                    if(blackCount == needed){
                        ++win;
                        failed = 0;
                        if(win>=STOP-trying){
                            ++totalProfit;
                        }
                        //System.out.println("Bingo black wins count= "+win);
                    }
                    if(blackCount > needed){
                        ++failed;
                        win = 0;
                        //System.out.println("FAIL black failed count= "+failed);
                    }
                    blackCount = 0;
                }else{
                    blackCount++;
                    //System.out.println("**************** "+current+" ***************");
                    if(redCount == needed){
                        ++win;
                        failed = 0;
                        if(win>=STOP-trying){
                            ++totalProfit;
                        }
                        //System.out.println("Bingo red  wins count= "+win);
                    }
                    if(redCount > needed){
                        ++failed;
                        win = 0;
                        //System.out.println("FAIL RED failed count="+failed);
                    }
                    redCount = 0;
                    //System.out.println("total profit"+totalProfit);
                }
            }
            totalProfitSumm += totalProfit;
            totalProfitCount +=1;
            System.out.println(totalProfitCount+"_"+totalProfit+"___AVERAGE PROFIT__"+totalProfitSumm/totalProfitCount+"__");
        }
    }
}
