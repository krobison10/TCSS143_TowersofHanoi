/*
   TCSS 143 
   Author:  Kyler Robison
*/
public class Hanoi 
{

    private Rod rodA, rodB, rodC;
    private int size;

    /**
     * Constructs the Hanoi object
     * @param n the amount of disks to be put on the initial rod
     */
    public Hanoi(int n)
    {
        size = n;
        rodA = new Rod(n);
        rodA.setName("A");
        rodB = new Rod(0);
        rodB.setName("B");
        rodC = new Rod(0);
        rodC.setName("C");
    }

    /**
     * Prints the current status of the puzzle
     */
    public void printStatus()
    {
        int maxStack = 0;
        maxStack = rodA.getNumDisk();
        if(maxStack < rodB.getNumDisk())
            maxStack = rodB.getNumDisk();
        if(maxStack < rodC.getNumDisk())
            maxStack = rodC.getNumDisk();
        for(int i = maxStack; i >= 0; i--)
        {
            if(i > 0)
                System.out.println(rodA.getDisk(i - 1).toString() + "  " + rodB.getDisk(i - 1).toString() + "  " + rodC.getDisk(i - 1).toString());
            else
                System.out.println("A  B  C");
        }
    }

    /**
     * Moves the top disk from one rod, to another specific rod
     * @param rod1 the rod from which the disk is removed
     * @param rod2 the rod on which the new disk is placed
     */
    private void move(Rod rod1, Rod rod2)
    {
        if(rod1.getNumDisk() == 0)
        {
            System.out.println("Rod1 does not have any disk.");
            return;
        }
        if(rod2.getNumDisk() != 0 && rod1.getDisk().compareTo(rod2.getDisk()) < 0)
        {
            System.out.println("Smaller disk cannot be placed above a larger disk.");
            return;
        }
        Disk disk = rod1.removeDisk();
        rod2.addDisk(disk);
        this.printStatus();
    }

    /**
     * Recursive method that moves disks until the puzzle is solved
     * @param n represents how many disks are in the puzzle
     * @param fromRod 
     * @param toRod
     * @param auxRod
     */
    private void recursiveTohHelper(int n, Rod fromRod, Rod toRod, Rod auxRod){
        if(n == size) 
        {
            System.out.println("Move disk " + fromRod.getDisk().getSize() + " from " + fromRod.getName() + " to " + toRod.getName());
            move(fromRod, toRod);
        }
        else 
        {
            recursiveTohHelper(n+1, fromRod, auxRod, toRod);
            System.out.println("Move disk " + fromRod.getDisk().getSize() + " from " + fromRod.getName() + " to " + toRod.getName());
            move(fromRod, toRod);
            recursiveTohHelper(n+1, auxRod, toRod, fromRod);
        }
    }
    /**
     * Calls the recursive method that solves the puzzle;
     */
    public void recursiveTOH(){
        recursiveTohHelper(1, rodA, rodB, rodC);
    }
}
