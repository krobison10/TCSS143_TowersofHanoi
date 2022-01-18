/*
   TCSS 143 
   Author:  Kyler Robison
*/
public class Disk implements Comparable<Disk>
{
    private Integer size;
    /**
     * creates a disk given a size as an argument
     * @param s
     */
    public Disk(int s)
    {
        size = s;
    }
    /**
     * 
     * @return size of the disk
     */
    public int getSize()
    {
        return this.size;
    }
    @Override
    /**
     * returns a string representation of the disk
     */
    public String toString()
    {
        return size.toString();
    }

    @Override
    /**
     * compares the size of this disk object to others, to be sure that the rules of the puzzle are being followed
     */
    public int compareTo(Disk other)
    {
        return this.size.compareTo(other.getSize());
    }
}
