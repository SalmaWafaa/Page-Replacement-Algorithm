

package fprojectos;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Salma
 */
public class FProjectOS {
public static void FIFO()
{

    Scanner sc = new Scanner(System.in);  
         //frames,alpointer al han7tgo ashan nt7rg fel string , page fault lhatzed 3ala hasb lhyd5lo , wel refrence length
        int  pointer = 0, pageFault = 0;
        int ourbuffer[];
        int mainref[];
        int finalShape[][];
        System.out.println("Please enter the number of Frames you want: ");
         int Frames = sc.nextInt(); 
        System.out.println("Please enter the length of the Reference string:");
         int Length = sc.nextInt();  
            //main reference dah array bn7ot feha length bta3 string 
        mainref = new int[Length];
           //w bn3rf al final shape bt3na dah hayb2a feh eh  array 2d 3shan row w column
        finalShape = new int[Length][Frames];
           //ourbuffer dah array ll frame el fadyaa el lsa han7ot feeha el data 
        ourbuffer = new int[Frames];
            //loop tmshy 3ala lframes bt3tna
        for(int R = 0; R < Frames; R++)
            //el amakn el fadya bt2leb -1 lhad ma ttmelyy
        {  ourbuffer[R] = -1;}
        System.out.println("Enter Numbers of reference string:: ");
        //loop ta5od al reference str length lhayd5lha
        for(int S = 0; S < Length; S++)
        { 
            mainref[S]  = sc.nextInt();
        }
        System.out.println();
        for(int S = 0; S < Length; S++)
        {
         int check = -1;
       
         for(int R = 0; R < Frames; R++)
         {
          if(ourbuffer[R] == mainref[S])
          {  
           check = R;
           break;
          } 
         }
          // check en hya fadia
          //law hya fadya f3ln
         if(check == -1)
         {
           //bnghz lpointer bt3na 3ala al ref string ashan  lpointer  yb2a yt7rk 3alaa lb3dha
          ourbuffer[pointer] = mainref[S];
          //bn3d page fault
           pageFault++;
          //pointer bt3na byt7rk 3ala lb3dha
           pointer++;
          //bas law al pointer = frame yb2a 5eles
           if(pointer == Frames)
              //han5li lpointer yo2af
           pointer = 0;
         }
         // an b3d may5las lhwa 3amlo fo2 wel conditions  yd5l b2a ba2y larkam fel shape bt3na
          
            for(int R = 0; R < Frames; R++)
            finalShape[S][R] = ourbuffer[R];
        }
        //loop btgblna alframes
        //loop btgblna al refrence length ashan nwz3ha fel frames
        for(int S = 0; S < Frames; S++)
        {
            for(int R = 0; R < Length; R++)
                 //hya %3d space ben rows
                //bn5od al a7na 3amlnlhom loop w n print them f 2D mafrod
             
                System.out.printf("%3d ",finalShape[R][S]);
            System.out.println();
        }
        System.out.println("Number of page faults of the reference string you entered are : " + pageFault);
  
}

public static void LRU(){
           Scanner sc = new Scanner(System.in);  // Create a Scanner object

        int Frames, pointer = 0,pageFault = 0, Length;
        Boolean Completed = false;
        int ourbuffer[];
        ArrayList<Integer> rr = new ArrayList<Integer>();
        int mainref[];
        int[][] finalShape;

        System.out.println("Please enter the number of Frames you want:");
        Frames = sc.nextInt();
        System.out.println("Please enter the length of the Reference string: ");
        Length = sc.nextInt();

        mainref = new int[Length];
        finalShape = new int[Length][Frames];
        ourbuffer = new int[Frames];
        for (int R = 0; R < Frames; R++) {
            ourbuffer[R] = -1;
        }

        System.out.println("Please enter the reference string: ");
        for (int S = 0; S < Length; S++) {
            mainref[S] = sc.nextInt();
        }
        System.out.println();
        //3andna rr fadya now
        //byshof an arraylist by contain length lama hayd5ol awl mara hay7ot 1 wel s mashya b 0 1 2 3 tab hya mawgoda la fa hay3mlha add 
        //law l2aha mawgoda by remove ashan n keep track llhgat latkrrt ashan law mshelthash msh hy3rf 
        for (int S = 0; S < Length; S++) {
            //
            if (rr.contains(mainref[S])) {
                rr.remove(rr.indexOf(mainref[S]));
            }
            
            //
            rr.add(mainref[S]);
            int check = -1;
            // byt2aked en frames msh fadii 
            for (int R = 0; R < Frames; R++) {
                if (ourbuffer[R] == mainref[S]) {
                    check = R;
                    break;
                }
            }
            if (check == -1) {
                //msh malyana
                if (Completed) {
                    //variable esmo min = length 
                    int min_loc = Length;
                    
                    for (int R = 0; R < Frames; R++) {
                        // number el fe frame() mawgood fe arraylist 
                        if (rr.contains(ourbuffer[R])) {
                            // temp hat2oaf 3nd el rakm el fe ourbuffer[j]
                            
                            int temp = rr.indexOf(ourbuffer[R]); // temp hayb2aa feeh location bta3 index aw lframes
                            if (temp < min_loc) {             //an law ltemp lhwa gowah location lframes 22l men  min 5alehom = b3d l2n s3tha hanb2a wslna le ab3d whda lm7tgnha 
                                min_loc = temp; 
                                
                                pointer = R;      
                            }
                        }
                    }
                }
                //mesh malyana hay insert rakam w y yzwd pointer wel page fault
                ourbuffer[pointer] = mainref[S];
                pageFault++;
                pointer++;
                
                //in case an hya malyana hayfdl pointer ylf l7d ma yb2a = frames y3ne 5lso s3tha han5li lpointer b zero w s3tha hatb2a malyana
                if (pointer == Frames) {
                    pointer = 0;
                    Completed = true;
                }
            }
            for (int R = 0; R < Frames; R++) {
                finalShape[S][R] = ourbuffer[R];
            }
        }

        for (int S = 0; S < Frames; S++) {
            for (int j = 0; j < Length; j++) {
                System.out.printf("%3d ", finalShape[j][S]);
            }
            System.out.println();
        }

        System.out.println("The number of Faults: " + pageFault);
    }
public static void Optimal()
{
    Scanner sc = new Scanner(System.in);  

        int  pointer = 0, pageFault = 0;
        int ourbuffer[];
        int mainref[];
        int finalShape[][];
        boolean Completed = false;
            System.out.println("Please enter the number of Frames you want:");
        int Frames  = sc.nextInt(); 
        System.out.println("Please enter the length of the Reference string: ");
        int Length  = sc.nextInt(); 
        mainref = new int[Length];
        finalShape = new int[Length][Frames];
        ourbuffer = new int[Frames];
        for(int j = 0; j < Frames; j++)
        ourbuffer[j] = -1;
        System.out.println("Please enter the reference string: ");
        for(int S = 0; S < Length; S++)
        {
            mainref[S] =sc.nextInt(); 
        }
        System.out.println();
        for(int S = 0; S < Length; S++)
        {
         int check = -1;
         for(int R = 0; R < Frames; R++)
         {
          if(ourbuffer[R] == mainref[S])
          {
              //Check frames 3shan ykhhly check b rtakm that means en hya msh empty 
           check = R;
           break;
          } 
         }
         // check en hya fadia
         if(check == -1)
         {
             //Check en hya msh malyana  "boolean = false"
          if(Completed)
          {
              //Array w hatena feeha frames 
              //index ashan btshof law larkam atkrrt b3den
           int ind[] = new int[Frames];
           //bybos  ll future 3shan n compare ehh ab3ad wahdaa msh han7tghaa
           for(int R = S + 1; R < Length; R++)
           {
            for(int Y = 0; Y < Frames; Y++)
            {
                // compare string el user dakhlo b length w yshfo law = ba3d msh hay-replace
             if((mainref[R] == ourbuffer[Y]) )
             {
              ind[Y] = R;
              break;
             }
            }
           }
           //Bn3mel variable max w bensweh b ind 
           int Maximum = ind[0];
           pointer = 0;
           
          //law max = 0 5aleh 150
           if(Maximum == 0)
           { 
               Maximum = 150;
           }
           
           //for loop hatmshy 3ala lframes w law lind bt3t al frame b zero 5aliha 150 ashan tb2a m3 lmaximum
           for(int R = 0; R < Frames; R++)
           {
               //Law index 3nd awl rakam b zero hankhali = akher rakm (al max)
            if(ind[R] == 0)
            { 
                ind[R] = 150;
            }
            
            //  law makan lframe akbar mn lmax 5alih ad lmax w hot lpointer 3ala lframe dah ashan dah lmax
            if(ind[R] > Maximum)
            {
             Maximum = ind[R];
             pointer = R;
            }
           }
          }
          
          //law makan lpointer lhwa wa2f feh = makan string lrakam hanzwd lpage fault (la2ena lframe fady w han insert )
          ourbuffer[pointer] = mainref[S];
          pageFault++;
          
          if(!Completed)  // ya3ni completed 
          {
           pointer++;
              if(pointer == Frames) // law lpointer 5alas lafa 3al frames
              {
               pointer = 0; //yerg3 tany men awl lframe
               
           
               Completed = true; // hya kda malyana
              }
          }
         
         }
         
         
         
        
         // Print shape 
         //loop tzbt lshakl
            for(int R = 0; R < Frames; R++)
                finalShape[S][R] = ourbuffer[R];
        }
        
        for(int S = 0; S < Frames; S++)
        {
            for(int R = 0; R < Length; R++)
                System.out.printf("%3d ",finalShape[R][S]); //btrsmhom b3d ma t3dy 3ala kol row and coloumn
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
              break;
            case 2:
               LRU();
               break;
            case 3:
             Optimal();
               break;

        }
    }
}
