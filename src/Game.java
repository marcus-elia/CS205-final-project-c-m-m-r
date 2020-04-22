/*
This code is from https://www.youtube.com/watch?v=1gir2R7G9ws
It is a tutorial by RealTutsGML
 */


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable
{
    public static final int WIDTH = 1024, HEIGHT = 624;
    private Thread thread;
    private boolean running = false;

    private GameManager gameManager;

    public Game() throws IOException
    {

        gameManager = new GameManager(WIDTH, HEIGHT);
        this.addMouseListener(new MouseInput(gameManager));
        new Window(WIDTH, HEIGHT, "Janggi", this);
        //this.addKeyListener(new KeyInput(handler));

    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }

        }
        stop();
    }

    private void tick()
    {
        gameManager.tick();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

        Color paleOrange = new Color(255,207,165);
        Color paleBlue = new Color(188, 219, 248);
        // Draw the background each frame
        g2d.setColor(paleBlue);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        gameManager.render(g2d);

        g2d.dispose();
        bs.show();
    }

    public int getWidth()
    {
        return WIDTH;
    }

    public int getHeight()
    {
        return HEIGHT;
    }

    public static void main(String[] args) throws IOException
    {
        new Game();

    }

}