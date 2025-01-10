// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.GradientPaint;


public class MazeProgram extends JPanel implements KeyListener{
    JFrame frame;
    String[][]maze;
    int x =100,y=100;
    Hero hero;
    boolean is3D=false;
    ArrayList<Wall> walls;

    public MazeProgram(){
        frame = new JFrame("A-mazing Program");
        frame.add(this);
        frame.setSize(1400,800);
        walls = new ArrayList<Wall>();
        setMaze();
        if(is3D)
        {
            createWalls();
        }
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2  =(Graphics2D)g;
        int initalColor = 190;
        int colorChangePer = 20;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,frame.getWidth(),frame.getHeight());
        // create if statements for hero.getDirection();
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("Steps Taken:", 850, 700);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString(String.valueOf(hero.getsteps()), 1070, 700);

        g.setColor(new Color(255,0,0));
        g.fillOval(900,500,50,50);
        g.setColor(new Color(0,0,255));
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("N", 912, 540);

        g.setColor(new Color(255,0,0));
        g.fillOval(900,600,50,50);
        g.setColor(new Color(0,0,255));
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("S", 915, 640);


        g.setColor(new Color(255,0,0));
        g.fillOval(850,550,50,50);
        g.setColor(new Color(0,0,255));
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("W", 855, 590);

        g.setColor(new Color(255,0,0));
        g.fillOval(950,550,50,50);
        g.setColor(new Color(0,0,255));
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("E", 965, 590);

        if(hero.getDirection().equals("N")){
            g.setColor(new Color(0,255,0));
            g.fillOval(900,500,50,50);
            g.setColor(new Color(0,0,255));
            g.setFont(new Font("Serif", Font.PLAIN, 40));
            g.drawString("N", 912, 540);
        }

        if(hero.getDirection().equals("E")){
            g.setColor(new Color(0,255,0));
            g.fillOval(950,550,50,50);
            g.setColor(new Color(0,0,255));
            g.setFont(new Font("Serif", Font.PLAIN, 40));
            g.drawString("E", 965, 590);
        }
        if(hero.getDirection().equals("W")){
            g.setColor(new Color(0,255,0));
            g.fillOval(850,550,50,50);
            g.setColor(new Color(0,0,255));
            g.setFont(new Font("Serif", Font.PLAIN, 40));
            g.drawString("W", 855, 590);
        }
        if(hero.getDirection().equals("S")){
            g.setColor(new Color(0,255,0));
            g.fillOval(900,600,50,50);
            g.setColor(new Color(0,0,255));
            g.setFont(new Font("Serif", Font.PLAIN, 40));
            g.drawString("S", 915, 640);
        }


        if(!is3D)
        {
            g.setColor(Color.ORANGE);
            // g.fillRect(100,100,500,500);
// g.setColor(Color.WHITE);
// g.drawRect(100,100,500,500);
// g.fillOval(100,100,500,500);
            for(int r = 0;r<maze.length;r++)
            {
                for(int c = 0;c<maze[r].length;c++)
                {
                    if(maze[r][c].equals("@"))
                    {

                        g.fillRect(c*20+50,r*20+50,20,20);

                    }
                }
                System.out.println();
            }
            g.setColor(Color.CYAN);
            g.fillOval(hero.getCol()*20+50,hero.getRow()*20+50,20,20);
        }
        else
        {
            for(Wall wall:walls) // convert this to dix explicit loops OR add the gradient by mod renderDistance
            {
                g2.setPaint(wall.getPaint());
//g.setColor(new Color(175,175,175));
                g.fillPolygon(wall.getPoly());
//g.setColor(Color.GRAY);
//g.drawPolygon(wall.getPoly());

            }
        }






    }
    public void setMaze()
    {
        maze = new String[20][60];

        try
        {
            File name = new File("Maze.txt");
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;
            int r = 0;
            while((text=input.readLine())!=null)
            {
                maze[r]=text.split("");
                r++;

            }

        }catch(IOException e){

        }
        hero = new Hero(0,1,"S",maze);
	/*for(int r = 0;r<maze.length;r++)
	{
	for(int c = 0;c<maze[r].length;c++)
	{
	System.out.print(maze[r][c]);
	}
	System.out.println();
	}*/
    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==32)//spacebar
        {
            is3D=!is3D;
        }
        else
        {
            hero.move(e.getKeyCode());
        }
        if(is3D)
        {
            createWalls();
        }
        repaint();
    }
    public void keyReleased(KeyEvent e)
    {
    }
    public void keyTyped(KeyEvent e)
    {
    }
    public void createWalls()
    {
        walls = new ArrayList<Wall>();
        int r = hero.getRow();
        int c = hero.getCol();
        String di = hero.getDirection();
        for(int a = 0;a<5;a++)
        {
            walls.add(leftWall(a));
            walls.add(rightWall(a));
            walls.add(leftPath(a));
            walls.add(rightPath(a));
            walls.add(ceilingWall(a));
            walls.add(floorWall(a));

            if(di.equals("S"))
            {
                try
                {
                    if(maze[r+a][c+1].equals("@"))
                    {
                        walls.add(leftWall(a));
                    }
                    if(maze[r+a][c-1].equals("@"))
                    {
                        walls.add(rightWall(a));
                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }

            if(di.equals("N"))
            {
                try
                {
                    if(maze[r-a][c-1].equals("@"))
                    {
                        walls.add(leftWall(a));
                    }
                    if(maze[r-a][c+1].equals("@"))
                    {
                        walls.add(rightWall(a));
                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }

            if(di.equals("W"))
            {
                try
                {
                    if(maze[r+1][c-a].equals("@"))
                    {
                        walls.add(leftWall(a));
                    }
                    if(maze[r-1][c-a].equals("@"))
                    {
                        walls.add(rightWall(a));
                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }

            if(di.equals("E"))
            {
                try
                {
                    if(maze[r-1][c+a].equals("@"))
                    {
                        walls.add(leftWall(a));
                    }
                    if(maze[r+1][c+a].equals("@"))
                    {
                        walls.add(rightWall(a));
                    }

                }catch(ArrayIndexOutOfBoundsException e){}
            }

        }
        for(int a = 5;a>=0;a--)
        {
            switch(di)
            {
                case "S":

                    try
                    {
                        if(maze[r+a][c].equals("@"))
                        {
                            walls.add(frontWall(a));
                        }
                    }catch(ArrayIndexOutOfBoundsException e){}
                    break;
                case "N":
                    try
                    {
                        if(maze[r-a][c].equals("@"))
                        {

                            walls.add(frontWall(a));
                        }
                    }catch(ArrayIndexOutOfBoundsException e){}
                    break;
                case "W":

                    try
                    {
                        if(maze[r][c-a].equals("@"))
                        {
                            walls.add(frontWall(a));
                        }
                    }catch(ArrayIndexOutOfBoundsException e){}
                    break;

                case "E":
                    try
                    {
                        if(maze[r][c+a].equals("@"))
                        {
                            walls.add(frontWall(a));
                        }
                    }catch(ArrayIndexOutOfBoundsException e){}
                    break;


            }

        }







    }

    //public void frontWall(String di){
    //for(int i = 0
    //}

    public Wall leftPath(int a)
    {
        int []x = new int[]{100+50*a,150+50*a,150+50*a,100+50*a};
        int []y = {150+50*a,150+50*a,650-50*a,650-50*a};
        return new Wall(x,y,'P',255-50*a,"left path");
    }
    public Wall rightPath(int a)
    {
        int []x = new int[]{700-50*a,650-50*a,650-50*a,700-50*a};
        int []y = {150+50*a,150+50*a,650-50*a,650-50*a};
        return new Wall(x,y,'F',255-50*a,"right path");
    }



    public Wall leftWall(int a)
    {
        int []x = new int[]{100+50*a,150+50*a,150+50*a,100+50*a};
        int []y = {100+50*a,150+50*a,650-50*a,700-50*a};
        return new Wall(x,y, 'L',255-50*a,"left");
    }
    public Wall rightWall(int a)
    {
        int []x = new int[]{700-50*a,650-50*a,650-50*a,700-50*a};
        int []y = {100+50*a,150+50*a,650-50*a,700-50*a};
        return new Wall(x,y,'R',255-50*a,"right");
    }
    public Wall frontWall(int a)
    {
        int []x = new int[]{100+50*a,700-50*a,700-50*a,100+50*a};
        int []y = {100+50*a,100+50*a,700-50*a,700-50*a};
        return new Wall(x,y,'F',255-50*a,"front");
    }
    public Wall ceilingWall(int a)
    {
        int []x = new int[]{150+50*a,650-50*a,700-50*a,100+50*a};
        int []y = {150+50*a,150+50*a,100+50*a,100+50*a};
        return new Wall(x,y,'U',255-50*a,"ceiling");
    }
    public Wall floorWall(int a)
    {
        int []x = new int[]{150+50*a,700-50*a,700-50*a,100+50*a};
        int []y = {650-50*a,650-50*a,700-50*a,700-50*a};
        return new Wall(x,y,'D',255-50*a,"floor");
    }

    public static void main(String[]args)
    {
        MazeProgram app = new MazeProgram();


    }
}