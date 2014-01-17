/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dailyprogrammer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joe
 */

public class Problem130 {
    public static class Vertex
    {
        public Set<Integer> neighborVertexes;
        public Set<Integer> neighborColors;
        public int color;
        
        public Vertex(List<Integer> neighbors)
        {
            neighborVertexes = new HashSet<>();
            neighborVertexes.addAll(neighbors);
            neighborColors = new HashSet<>();
            color = -1;
        }
    }
    
    public static void Main()
    {
        Scanner s = new Scanner(System.in);
        
        int vertexCount = Integer.parseInt(s.nextLine());
        
        HashMap<Integer, Vertex> vMap = new HashMap<>();
        
        for(int i = 0; i < vertexCount; i++) // O(|V|)
        {
            String[] values = s.nextLine().split(" ");
            
            Integer v = Integer.parseInt(values[0]);
            
            List<Integer> nList = new ArrayList<>(values.length - 1);
            
            for(int j = 1; j < values.length; j++)
            {
                nList.add(Integer.parseInt(values[j]));
            }
            
            vMap.put(v, new Vertex(nList));
        }
        
        boolean done = false;
        //Might be able to reduce to O(|V|) but using a set of buckets to store
        //  vectors according to the number of colors they border, instead of
        //  iteratating over the entire collection each time.
        // Would need better (bigger) data set to test. The given test data for 
        //  France runs under a second as it is.
        while(!done) // O(|V|^2)
        {        
            int highestVertex = -1;
            int highestVertexColorCount = -1;

            for(Entry<Integer, Vertex> entry : vMap.entrySet()) // O(|V|)
            {
                if(entry.getValue().color == -1 
                        && highestVertexColorCount < entry.getValue().neighborColors.size())
                {
                    highestVertex = entry.getKey();
                    highestVertexColorCount = entry.getValue().neighborColors.size();
                }
            }
            
            if(highestVertex == -1)
            {
                done = true;
            }
            else
            {
                //find the first unused color
                for(int i = 0; ; i++) // constant - 4 color theorem
                {
                    if(!vMap.get(highestVertex).neighborColors.contains(i))
                    {
                        vMap.get(highestVertex).color = i;
                        
                        //set the colors on its neighbors
                        for(Integer v : vMap.get(highestVertex).neighborVertexes)
                        {
                            if(vMap.containsKey(v))
                            {
                                vMap.get(v).neighborColors.add(i);
                            }
                        }
                        
                        break;
                    }
                }
                
            }
        }
        
        for(Entry<Integer, Vertex> entry : vMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue().color);
        }
    }
}
