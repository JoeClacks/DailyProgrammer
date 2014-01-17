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
public class Problem145 {
    public static void Main()
    {
        Scanner s = new Scanner(System.in);
        
        System.out.print("-->");
        String input = s.nextLine();
        String[] split = input.split(" ");
        
        int width = Integer.parseInt(split[0]);
        String trunk = split[1];
        String leafs = split[2];
        
        int currentWidth = 1;
        
        int spacing;

        while(currentWidth <= width)
        {
            spacing = width / 2 - currentWidth / 2;
            
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < spacing; i++)
            {
                sb.append(' ');
            }
            
            for(int i = 0; i < currentWidth; i++)
            {
                sb.append(leafs);
            }
            
            currentWidth += 2;
            
            System.out.println(sb);
        }
        
        spacing = width / 2 - 1;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < spacing; i++)
        {
            sb.append(' ');
        }
        
        for(int i = 0; i < 3; i++)
        {
            sb.append(trunk);
        }
        
        System.out.println(sb);
    }
}
