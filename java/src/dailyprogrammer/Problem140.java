/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dailyprogrammer;

import java.util.Scanner;

/**
 *
 * @author joe
 */
public class Problem140 {
    public static void Main()
    {
        Scanner s = new Scanner(System.in);
        
        int nodes = Integer.parseInt(s.nextLine());
        
        int[][] array = new int[nodes][nodes];
        
        
        
        for(int i = 0; i < nodes; i++)
        {
            String[] values = s.nextLine().split(" ");
            
            for(int j = 0; j < nodes; j++)
            {
                if(i == j)
                {
                    array[i][j] = 0;
                }
                else
                {
                    int value = Integer.parseInt(values[j]);
                    
                    if(value == 1)
                    {
                        array[i][j] = value;
                    }
                    else
                    {
                        array[i][j] = -1;
                    }
                }
            }
        }
        
        //Floyd–Warshall
        for(int k = 0; k < nodes; k++)
        {
            for(int i= 0; i < nodes; i++)
            {
                for(int j = 0; j < nodes; j++)
                {
                   if(array[i][k] != -1 && array[k][j] != -1)
                   {
                        if(array[i][j] > array[i][k] + array[k][j] || (array[i][j] == -1 ))
                        {
                            array[i][j] = array[i][k] + array[k][j];
                        }
                   }
                }
            }
        }
        
        //find the max value in the graph
        int max = 0;
        for(int i = 0; i < nodes; i++)
        {            
            for(int j = 0; j < nodes; j++)
            {
                int minValue = array[i][j] < array[j][i] ? array[i][j] : array[j][i];
                if(minValue > max)
                {
                    max = minValue;
                }
            }
        }
        
        System.out.println(max);
    }
}
