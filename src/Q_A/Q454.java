package Q_A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q454 {
    /**
     * 超级暴力
     */
    public int fourSumCount_PlanA(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        int result = 0;
        //数据排序
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        //都是大于零的数
        if(length>0&&A[0]>0&&B[0]>0&&C[0]>0&&D[0]>0)
            return result;
        int i,j,k,l;
        for ( i = 0; i <length ; i++) {
            if(A[i]>=0&&D[0]>0&&C[0]>0&&B[0]>0)
                break;
            for ( j = 0; j <length ; j++) {
                if(A[i]+B[j]>=0&&D[0]>0&&C[0]>0)
                    break;
                for ( k = 0; k <length ; k++) {
                    if(A[i]+B[j]+C[k]>=0&&D[0]>0)
                        break;
                    for ( l = 0; l < length; l++) {
                        if(A[i]+B[j]+C[k]+D[l]>0)
                            break;
                        if(A[i]+B[j]+C[k]+D[l]==0)
                            result++;
                    }
                }
            }
        }
        return result;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        int length = A.length;
        int temp;
        Map<Integer,Integer> integerIntegerHashMap_ab = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length ; j++) {
                temp = A[i]+B[j];
                integerIntegerHashMap_ab.put(temp,integerIntegerHashMap_ab.getOrDefault(temp,0)+1);
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length ; j++) {
                temp =0- C[i]-D[j];
                if(integerIntegerHashMap_ab.containsKey(temp))
                    result+=integerIntegerHashMap_ab.get(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q454().fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}));
    }
}
