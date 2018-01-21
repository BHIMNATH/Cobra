package bhim.project.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.SoundPool;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Aswin on 21-Jan-18.
 */

class SnakeView extends SurfaceView implements Runnable {
    // All the code will run separately to the UI
    private Thread m_Thread = null;
    // This variable determines when the game is playing
    // It is declared as volatile because
    // it can be accessed from inside and outside the thread
    private volatile boolean m_Playing;

    // This is what we draw on
    private Canvas m_Canvas;
    // This is required by the Canvas class to do the drawing
    private SurfaceHolder m_Holder;
    // This lets us control colors etc
    private Paint m_Paint;

    // This will be a reference to the Activity
    private Context m_context;

    // Sound
    private SoundPool m_SoundPool;
    private int m_get_mouse_sound = -1;
    private int m_dead_sound = -1;

    // For tracking movement m_Direction
    public enum Direction {UP, RIGHT, DOWN, LEFT}
    // Start by heading to the right
    private Direction m_Direction = Direction.RIGHT;

    // What is the screen resolution
    private int m_ScreenWidth;
    private int m_ScreenHeight;

    // Control pausing between updates
    private long m_NextFrameTime;
    // Update the game 10 times per second
    private final long FPS = 10;
    // There are 1000 milliseconds in a second
    private final long MILLIS_IN_A_SECOND = 1000;
    // We will draw the frame much more often

    // The current m_Score
    private int m_Score;

    // The location in the grid of all the segments
    private int[] m_SnakeXs;
    private int[] m_SnakeYs;

    // How long is the snake at the moment
    private int m_SnakeLength;

    // Where is the mouse
    private int m_MouseX;
    private int m_MouseY;

    // The size in pixels of a snake segment
    private int m_BlockSize;

    // The size in segments of the playable area
    private final int NUM_BLOCKS_WIDE = 40;
    private int m_NumBlocksHigh; // determined dynamically
}
