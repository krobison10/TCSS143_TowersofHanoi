/*
   TCSS 143 
   Author:  Kyler Robison
*/
import java.util.*;

public class Rod 
{
    private String name;
    private LinkedList<Disk> diskStack;

    /**
     * Constructs a rod which is essential a linkedlist to represent a stack of disks
     * @param n the amount of disks to be put on the rod
     */
    public Rod (int n)
    {
        diskStack = new LinkedList<Disk>();
        for(int i = 1; i <= n; i++)
        {
            diskStack.add(new Disk(i));
        }
    }
    /**
     * 
     * @return the number of disks on the rod
     */
    public int getNumDisk()
    {
        return diskStack.size();
    }
    /**
     * Sets the name of the rod
     * @param in name input
     */
    public void setName(String in)
    {
        name = in;
    }
    /**
     * 
     * @return name of the rod
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * overloaded method which returns a string representation of the disk at a certain level on the stack given an index
     * @param index which level of the stack is being searched for
     * @return string representation of disk size 
     */
    public String getDisk(int index)
    {
        if(index < diskStack.size())
        {
            return diskStack.get(index).toString();
        }
        else
        {
            return " ";
        }
    }
    /**
     * 
     * @return the object representing the top disk if the rod isn't empty
     */
    public Disk getDisk()
    {
        if(diskStack.isEmpty())
            return null;
        else
            return diskStack.getLast();
    }
    /**
     * 
     * @return the disk that was removed from the stack if the rod was not empty
     */
    public Disk removeDisk()
    {
        if(diskStack.isEmpty())
            return null;
        else
            return diskStack.removeLast();
    }
    /**
     * adds a disk to the top of the stack
     * @param in disk to be added to the stack
     */
    public void addDisk(Disk in)
    {
        diskStack.addLast(in);
    }

    @Override
    /**
     * returns a string representation of the rod, which is a string of numbers representing the sizes of the disks
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(Disk disk : diskStack)
        {
            s.append(disk.getSize()).append("  ");
        }
        return s.toString().trim();
    }
    
}
