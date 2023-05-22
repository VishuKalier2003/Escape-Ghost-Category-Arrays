/* You are playing a simplified PAC-MAN game on an infinite 2-D grid... You start at the point [0, 0], and you are 
given a destination point target = [xtarget, ytarget] that you are trying to get to... There are several ghosts 
on the map with their starting positions given as a 2D array ghosts, where ghosts[i] = [xi, yi] represents the 
starting position of the ith ghost... All inputs are integral coordinates... Each turn, you and all the ghosts may 
independently choose to either move 1 unit in any of the four cardinal directions: north, east, south, or west, or 
stay still... All actions happen simultaneously... You escape if and only if you can reach the target before any 
ghost reaches you. If you reach any square (including the target) at the same time as a ghost, it does not count as 
an escape... Return true if it is possible to escape regardless of how the ghosts move, otherwise return false...
* Eg 1 : Ghosts = [[1,0],[0,3]]                    Target = [0,1]                     Output = False
* Eg 2 : Ghosts = [[1,0]]                          Target = [2,0]                     Output = True
* Eg 3 : Ghosts = [[2,0]]                          Target = [1,0]                     Output = False
*/
import java.util.*;
public class Escape
{
      public boolean EscapeGhosts(int ghosts[][], int target[])
      {
            for(int i = 0; i < ghosts.length; i++)   //! Comparison => O(N)
            {
                  int GhostDistance = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
                  int PlayerDistance = Math.abs(target[0] + target[1]);     //*  Variable => O(1)
                  if(GhostDistance <= PlayerDistance)    // If any ghost distance is equal or less than player...
                        return false;
            }
            return true;     // Base return statement...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of ghosts on the grid : ");
            x = sc.nextInt();
            int[][] gh = new int[x][2];
            for(int i = 0; i < gh.length; i++)
            {
                  System.out.print("Enter x coordinate of "+(i+1)+" ghost : ");
                  gh[i][0] = sc.nextInt();
                  System.out.print("Enter y coordinate of "+(i+1)+" ghost : ");
                  gh[i][1] = sc.nextInt();
            }
            int tar[] = new int[2];
            System.out.print("Enter x coordinate of target : ");
            tar[0] = sc.nextInt();
            System.out.print("Enter y coordinate of target : ");
            tar[1] = sc.nextInt();
            Escape escape = new Escape();    // Object creation...
            System.out.println("Escape Possibility : "+escape.EscapeGhosts(gh, tar));
            sc.close();
      }
}


//! Time Complexity  => O(N)
//* Space Complexity => O(1)

/** //? DEDUCTIONS :-
 * ? Since the ghost can stay at one point, if a ghost reaches the target before, it only has to wait for 
 * ? the player...
 * ? Thus, we compare the absolute distance of every ghost to the player and target...
 */