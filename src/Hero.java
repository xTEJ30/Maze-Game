public class Hero
{
    int r,c,steps;
    String [][]maze;
    boolean [][] visitedLocs;
    String direction = "S";
    public Hero(int r, int c,String direction,String[][] maze)
    {
        this.r=r;
        this.c=c;
        this.maze=maze;
        this.steps = steps;
        this.direction = direction;
    }
    public void move(int key)
    {

        if(key==39)//turn right
        {
            if(direction.equals("N"))
            {
                direction= "E";

            }
            else if(direction.equals("E"))
            {
                direction= "S";
            }
            else if(direction.equals("S"))
            {
                direction= "W";
            }
            else if(direction.equals("W"))
            {
                direction= "N";
            }

        }
        if(key==37)//turn left
        {
            if(direction.equals("N"))
            {
                direction= "W";
            }
            else if(direction.equals("W"))
            {
                direction= "S";
            }
            else if(direction.equals("S"))
            {
                direction= "E";
            }
            else if(direction.equals("E"))
            {
                direction= "N";
            }

        }
        if(key==38)//forward
        {
            boolean moved = false;
            if(direction.equals("N"))//move North
            {
                try
                {
                    if(maze[r-1][c].equals(" "))
                    {
                        r--;
                        moved = true;

                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
            if(direction.equals("W"))//move West
            {
                try{
                    if(maze[r][c-1].equals(" "))
                    {
                        c--;
                        moved = true;

                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
            if(direction.equals("E"))//move East
            {
                try{
                    if(maze[r][c+1].equals(" "))
                    {
                        c++;
                        moved = true;

                    }
                }catch(ArrayIndexOutOfBoundsException e){}

            }
            if(direction.equals("S"))//move East
            {
                try{
                    if(maze[r+1][c].equals(" "))
                    {
                        r++;
                        moved = true;

                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }
            if(moved) { steps++; }
        }


    }
    public int getRow()
    {
        return r;
    }

    public int getCol()
    {
        return c;
    }
    public String getDirection()
    {
        return direction;
    }

    public int getsteps(){
        return steps;
    }

}
