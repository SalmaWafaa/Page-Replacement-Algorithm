/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fprojectos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class FProjectOS {
public static void FIFO()
{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

           Scanner sc = new Scanner(System.in);  // Create a Scanner object
         //frames,alpointer al han7tgo ashan nt7rg fel string , page fault lhatzed 3ala hasb lhyd5lo , wel refrence length
        int  pointer = 0, pageFault = 0;
        int ourbuffer[];
        int mainref[];
        int finalShape[][];
        System.out.println("Enter the number of Frames you want: ");
         int Frames = sc.nextInt(); 
        System.out.println("Enter  length of  Reference string you will enter: ");
         int Length = sc.nextInt();  
            //main reference dah array bn7ot feha length bta3 string 
        mainref = new int[Length];
           //w bn3rf al final shape bt3na dah hayb2a feh eh  array 2d 3shan row w column
        finalShape = new int[Length][Frames];
           //ourbuffer dah array ll frame el fadyaa el lsa han7ot feeha el data 
        ourbuffer = new int[Frames];
            //loop tmshy 3ala lframes bt3tna
        for(int j = 0; j < Frames; j++)
            //el amakn el fadya bt2leb -1 lhad ma ttmelyy
        {  ourbuffer[j] = -1;}
        System.out.println("Enter Numbers of reference string:: ");
        //loop ta5od al reference str length lhayd5lha
        for(int i = 0; i < Length; i++)
        { 
            mainref[i]  = sc.nextInt();
        }
        System.out.println();
        for(int i = 0; i < Length; i++)
        {
         int check = -1;
         //de lheta lshelnaha kan mafrod nshel hit++ bs msh al loop kolaha
         for(int j = 0; j < Frames; j++)
         {
          if(ourbuffer[j] == mainref[i])
          {  
           check = j;
           break;
          } 
         }
          // check en hya fadia
          //law hya fadya f3ln
         if(check == -1)
         {
           //bnghz lpointer bt3na 3ala al ref string bt3tna ashan  lpoiner bt3na  yb2a yt7rk 3alaa lb3dha
          ourbuffer[pointer] = mainref[i];
          //bn3d page fault
           pageFault++;
          //pointer bt3na byt7rk 3ala lb3dha
           pointer++;
          //bas law al pointer = frame 5alas
           if(pointer == Frames)
              //han5li lpointer yo2af
           pointer = 0;
         }
         //?? i think azdo an b3d may5las lhwa 3amlo fo2 wel conditions  yd5l b2a ba2y larkam fel shape bt3na
         //Deeh 
            for(int j = 0; j < Frames; j++)
            finalShape[i][j] = ourbuffer[j];
        }
        //loop btgblna alframes
        //loop btgblna al refrence length ashan nwz3ha fel frames
        for(int i = 0; i < Frames; i++)
        {
            for(int j = 0; j < Length; j++)
                 //hya %3d space been rows
                //bn5od al a7na 3amlnlhom loop w n print them f 2D mafrod
             //System.out.print("     " + finalShape[j][i]);
                System.out.printf("%3d ",finalShape[j][i]);
            System.out.println();
        }
        System.out.println("Number of page faults of the reference string you entered are : " + pageFault);
  
}
public static void LRU(){
           Scanner sc = new Scanner(System.in);  // Create a Scanner object

        int Frames, pointer = 0,pageFault = 0, Length;
        Boolean isFull = false;
        int ourbuffer[];
        ArrayList<Integer> rr = new ArrayList<Integer>();
        int mainref[];
        int[][] finalShape;

        System.out.println("Please enter the number of Frames: ");
        Frames = sc.nextInt();
        System.out.println("Please enter the length of the Reference string: ");
        Length = sc.nextInt();

        mainref = new int[Length];
        finalShape = new int[Length][Frames];
        ourbuffer = new int[Frames];
        for (int j = 0; j < Frames; j++) {
            ourbuffer[j] = -1;
        }

        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < Length; i++) {
            mainref[i] = sc.nextInt();
        }
        System.out.println();
        for (int i = 0; i < Length; i++) {
            if (rr.contains(mainref[i])) {
                rr.remove(rr.indexOf(mainref[i]));
            }
            rr.add(mainref[i]);
            int check = -1;
            // byt2aked en frame msh fadii 
            for (int j = 0; j < Frames; j++) {
                if (ourbuffer[j] == mainref[i]) {
                    check = j;
                    break;
                }
            }
            if (check == -1) {
                // law frame not empty 
                if (isFull) {
                    int min_loc = Length;
                    for (int j = 0; j < Frames; j++) {
                        // number el fe frame() mawgood fe arraylist 
                        if (rr.contains(ourbuffer[j])) {
                            // temp hat2oaf 3nd el rakm el fe ourbuffer[j]
                            int temp = rr.indexOf(ourbuffer[j]); // temp hayb2aa feeh location bta3 index j
                            if (temp < min_loc) {
                                min_loc = temp;     
                                pointer = j;      
                            }
                        }
                    }
                }
                ourbuffer[pointer] = mainref[i];
                pageFault++;
                pointer++;
                if (pointer == Frames) {
                    pointer = 0;
                    isFull = true;
                }
            }
            for (int j = 0; j < Frames; j++) {
                finalShape[i][j] = ourbuffer[j];
            }
        }

        for (int i = 0; i < Frames; i++) {
            for (int j = 0; j < Length; j++) {
                System.out.printf("%3d ", finalShape[j][i]);
            }
            System.out.println();
        }

        System.out.println("The number of Faults: " + pageFault);
    }
public static void Optimal()
{
    Scanner sc = new Scanner(System.in);  // Create a Scanner object

        int  pointer = 0, pageFault = 0;
        int ourbuffer[];
        int mainref[];
        int finalShape[][];
        boolean isFull = false;
        System.out.println("Enter the number of Frames you want:");
        int Frames  = sc.nextInt(); 
        System.out.println("Please enter the length of the Reference string: ");
        int Length  = sc.nextInt(); 
        mainref = new int[Length];
        finalShape = new int[Length][Frames];
        ourbuffer = new int[Frames];
        for(int j = 0; j < Frames; j++)
        ourbuffer[j] = -1;
        System.out.println("Please enter the reference string: ");
        for(int i = 0; i < Length; i++)
        {
            mainref[i] =sc.nextInt(); 
        }
        System.out.println();
        for(int i = 0; i < Length; i++)
        {
         int check = -1;
         for(int j = 0; j < Frames; j++)
         {
          if(ourbuffer[j] == mainref[i])
          {
           check = j;
           break;
          } 
         }
         if(check == -1)
         {
          if(isFull)
          {
           int index[] = new int[Frames];
           boolean index_flag[] = new boolean[Frames];
           for(int j = i + 1; j < Length; j++)
           {
            for(int k = 0; k < Frames; k++)
            {
             if((mainref[j] == ourbuffer[k]) && (index_flag[k] == false))
             {
              index[k] = j;
              index_flag[k] = true;
              break;
             }
            }
           }
           int max = index[0];
           pointer = 0;
           if(max == 0)
            max = 200;
           for(int j = 0; j < Frames; j++)
           {
            if(index[j] == 0)
             index[j] = 200;
            if(index[j] > max)
            {
             max = index[j];
             pointer = j;
            }
           }
          }
          ourbuffer[pointer] = mainref[i];
          pageFault++;
          if(!isFull)
          {
           pointer++;
              if(pointer == Frames)
              {
               pointer = 0;
               isFull = true;
              }
          }
         }
            for(int j = 0; j < Frames; j++)
                finalShape[i][j] = ourbuffer[j];
        }
        
        for(int i = 0; i < Frames; i++)
        {
            for(int j = 0; j < Length; j++)
                System.out.printf("%3d ",finalShape[j][i]);
            System.out.println();
        }
        
        System.out.println("The number of Faults: " + pageFault);
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner m= new Scanner(System.in);
        System.out.println("Choose method 1 for FIFO 2 for LRU 3 for Optimal");
          int choose = m.nextInt();

        switch (choose){
            case 1:
                       FIFO();
            case 2:
                      LRU();
            case 3:
             Optimal();
        }
    }
}
