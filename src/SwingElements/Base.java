package SwingElements;

import EventScheduler.EventScheduler;
import Listeners.*;
import graphvisualizer.Graph;
import graphvisualizer.SettingsFileManipulator;
import java.io.File;
import java.sql.Connection;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Initializes both the Graph and the Canvas. Attaches mouse and key listeners,
 * for user interaction.
 */
public class Base extends JFrame {

    public static Graph graph;                                                        //The grid

    private Canvas canvas;                                                      //Canvas for displaying stuff

    private Timer timer;                                                        //Repaints the grid on an interval
    private TimerActionListener timerListener;                                  //Action listener for the Timer

    private int stepTime;                                                       //Interval for repainting

    private boolean refreshOn = false;                                          //Is the seed refreshed after each picture interval?

    private int pictureInterval = 5;                                            //Number of pictures in a seed cycle

    private boolean intervalPause = false;                                      //Pause grid after interval?

    private File bookDirectory;                                                 //Folder location where generated pictures are to be saved

    private final JPopupMenu rightClickMenu = new JPopupMenu();                 //Right-Click Menu

    private final JMenuBar menuBar = new JMenuBar();                            //Menu Bar

    private final JMenu gridOptions = new JMenu("Grid Options");                //Menu Bar Items
    private final JMenu propertiesMenu = new JMenu("Properties");
    private final JMenu save = new JMenu("Save");
    private final JMenu schedulerMenu = new JMenu("Scheduler");

    private final JMenuItem step = new JMenuItem("Step forward");                                       //Right-click button
    private final JMenuItem loop = new JMenuItem("Run");                                                //Right-click button   
    private final JMenuItem averageColor = new JMenuItem("Show average connection color");              //Right-click button
    private final JMenuItem databaseConnect = new JMenuItem("Connect to local database");               //Right-click button  

    private final JMenuItem reset = new JMenuItem("Reset grid");                                        //Grid options menu
    private final JMenuItem whiteOutGrid = new JMenuItem("Turn all grid points white");                 //Grid options menu
    private final JMenuItem centerGrid = new JMenuItem("Center the grid on the screen");                //Grid options menu

    private final JMenuItem propertiesItem = new JMenuItem("Edit properties");                          //Properties menu
    private final JMenuItem customLine = new JMenuItem("Set properties for next line");                 //Properties menu
    private final JMenuItem seedColoringBook = new JMenuItem("Set up starting coloring book seed");    //Properties menu
    private final JMenuItem toggleDrag = new JMenuItem("Disable drag to reposition");                   //Properties menu

    private final JMenuItem saveState = new JMenuItem("Save state");                                    //Save menu
    private final JMenuItem savePicture = new JMenuItem("Save Picture");                                //Save menu
    private final JMenuItem folderSelect = new JMenuItem("Choose folder to save book images in");       //Save menu

    private boolean run = false;                                                //Determines if Graph.takeStep() should be executed inside the TimerActionListener

    private SettingsFileManipulator settingsManager;                            //Settings manager, reads the persistent settings in from the file

    private AverageColorDisplay averageDisplay = new AverageColorDisplay();     //Displays average color of all lines

    private static Connection conn = null;                                      //MySQL connection variable

    public EventScheduler scheduler = new EventScheduler();                     //Event scheduler
    
    public boolean curveSwitcher = false;                                        //Handles determining if the curve toggle boolean should be switched between steps.

    /**
     * Constructor for Base class. Determines grid dimensions, as well as the
     * interval for steps and repaint actions
     *
     * @param c The number of columns in the grid
     * @param r The number of rows in the grid
     * @param st The time in between TimerActionLister events
     * @param pc Number of pictures before resetting the seed (Currently unused)
     */
    public Base(int c, int r, int st, int pc) {
        canvas = new Canvas(this);
        graph = new Graph(r, c, this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        settingsManager = new SettingsFileManipulator("./res/settings.txt", this);
        settingsManager.readSettingsIn();

        addMenuListeners();
        createRightClickMenu();
        createGridOptionsMenu();
        createPropertiesMenu();
        createSaveMenu();
        createMenuBar();

        setJMenuBar(menuBar);

        this.addKeyListener(new BaseKeyListener(this));
        this.setSize(500, 500);
        this.add(canvas);

        stepTime = st;
        pictureInterval = pc;
        //Repaints on an interval
        timerListener = new TimerActionListener(this);
        timer = new Timer(stepTime, timerListener);
        timer.start();
    }//end constructor

    /**
     * Re-sizes the grid dimensions, as well as the step interval, and the
     * number of pictures in a cycle for coloring book picture generation.
     *
     * @param c The number of columns
     * @param r The number of rows
     * @param st The amount of time in ms between steps when auto-running steps
     * @param pc The number of pictures in a cycle before re-seeding the grid
     */
    public void resizeGrid(int c, int r, int st, int pc) {
        timer.stop();
        int tempPictureCount = graph.getCamera().getPictureCount();
        graph = new Graph(r, c, this);
        graph.getCamera().setPictureCount(tempPictureCount);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(canvas);

        stepTime = st;
        pictureInterval = pc;

        timer = new Timer(stepTime, new TimerActionListener(this));
        timer.start();
    }//end resizeGrid

    /**
     * Changes the color of the AverageColorDisplay
     */
    public void updateAverageColor() {
        averageDisplay.updateColor(graph.getAverageColor());
    }//end updateAverageColor

    /**
     * Adds the ActionListeners to the right-click menu buttons
     */
    private void addMenuListeners() {
        step.addActionListener(new StepActionListener(this));
        loop.addActionListener(new LoopActionListener(this));
        reset.addActionListener(new ResetActionListener(this));
        whiteOutGrid.addActionListener(new WhiteOutGridActionListener(this));
        propertiesItem.addActionListener(new PropertiesActionListener(this));
        averageColor.addActionListener(new AverageColorActionListener(this));
        customLine.addActionListener(new CustomLineActionListener(this));
        saveState.addActionListener(new SaveStateActionListener(this));
        savePicture.addActionListener(new SavePictureActionListener(this));
        seedColoringBook.addActionListener(new SeedColoringBookListener(this));
        centerGrid.addActionListener(new CenterGridActionListener(this));
        toggleDrag.addActionListener(new ToggleDragActionListener(this));
        folderSelect.addActionListener(new FolderSelectActionListener(this));
        databaseConnect.addActionListener(new DatabaseConnectListener(this));
        schedulerMenu.addMouseListener(new SchedulerMenuActionListener(this));
    }//end addMenuListeners

    /**
     * Adds the right-click menu buttons to the menu
     */
    private void createRightClickMenu() {
        rightClickMenu.add(step);
        rightClickMenu.add(loop);
        rightClickMenu.add(averageColor);
        rightClickMenu.add(databaseConnect);
    }//end createRightClickMenu

    /**
     * Adds the grid options menu buttons to the menu
     */
    private void createGridOptionsMenu() {
        gridOptions.add(reset);
        gridOptions.add(whiteOutGrid);
        gridOptions.add(centerGrid);
    }//end createGridOptionsMenu

    /**
     * Adds the properties menu buttons to the menu
     */
    private void createPropertiesMenu() {
        propertiesMenu.add(propertiesItem);
        propertiesMenu.add(customLine);
        propertiesMenu.add(seedColoringBook);
        propertiesMenu.add(toggleDrag);
    }//end createPropertiesMenu

    /**
     * Adds the save menu buttons to the menu
     */
    private void createSaveMenu() {
        save.add(saveState);
        save.add(savePicture);
        save.add(folderSelect);
    }//end createSaveMenu

    /**
     * Adds the menu bar items to the menu bar
     */
    private void createMenuBar() {
        menuBar.add(gridOptions);
        menuBar.add(propertiesMenu);
        menuBar.add(save);
        menuBar.add(schedulerMenu);
    }//end createMenuBar

    /**
     * Inverts the run boolean, used in the loop menu button
     */
    public void flipRun() {
        if (run) {
            pause();
        }//end if
        else {
            run();
        }//end else
    }//end flipRun

    /**
     * Sets the run variable to true, and updates the text of the loop menu
     * item.
     */
    public void run() {
        run = true;
        loop.setText("Pause");
    }//end run

    /**
     * Sets the run variable to false, and updates the text of the loop menu
     * item.
     */
    public void pause() {
        run = false;
        loop.setText("Run");
    }//end pause;

    /**
     * Checks to see if the connection variable has been created.
     *
     * @return True if the connection has been set, false if not
     */
    public static boolean checkConnection() {
        return conn == null;
    }//end checkConnection

    /**
     * Returns the {@link Canvas} object
     *
     * @return The canvas object
     * @see Canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }//end getCanvas

    /**
     * Sets the value for the run variable
     *
     * @param in The new value for run
     */
    public void setRun(boolean in) {
        run = in;
    }//end setRun

    /**
     * Returns the value of the run variable
     *
     * @return The value of run
     */
    public boolean getRun() {
        return run;
    }//end getRun

    /**
     * Shows the {@link AverageColorDisplay} window
     */
    public void showAverageDisplay() {
        averageDisplay = new AverageColorDisplay();
        SwingUtilities.invokeLater(averageDisplay);
    }//end getAverageDisplay

    /**
     * Returns the right click menu
     *
     * @return The right click menu
     */
    public JPopupMenu getRightClickMenu() {
        return rightClickMenu;
    }//end getRightClickMenu

    /**
     * Returns the Graph object
     *
     * @return The graph object
     */
    public Graph getGraph() {
        return graph;
    }//end getGraph

    /**
     * Returns the {@link JMenuItem} used to control mouse dragging.
     *
     * @return The {@link JMenuItem} controlling mouse dragging
     */
    public JMenuItem getToggleDrag() {
        return toggleDrag;
    }//end getToggleDrag

    /**
     * Returns the {@link JMenuItem} used to toggle step auto-running
     *
     * @return The {@link JMenuItem} controlling auto-running
     */
    public JMenuItem getLoop() {
        return loop;
    }//end getLoop

    /**
     * Returns the directory where coloring book pictures are saved.
     *
     * @return The file path to the directory
     */
    public File getBookDirectory() {
        return bookDirectory;
    }//end getBookDirectory

    /**
     * Sets the directory where coloring book pages are saved.
     *
     * @param in The location
     */
    public void setBookDirectory(File in) {
        bookDirectory = in;
    }//end setBookDirectory

    /**
     * Gets the amount of time in ms between steps when auto-running
     *
     * @return The number of ms between steps when auto-running
     */
    public int getStepTime() {
        return stepTime;
    }//end getStepTime

    /**
     * Sets the amount of time in ms between steps when auto-running
     *
     * @param in The number of ms to wait between steps when auto-running
     */
    public void setStepTime(int in) {
        stepTime = in;
    }//end setStepTime

    /**
     * Gets the object responsible for reading/editing the settings file
     *
     * @return The {@link SettingsFileManipulator} object created at
     * initialization
     */
    public SettingsFileManipulator getSettingsManager() {
        return settingsManager;
    }//end getSettingsManager

    /**
     * Gets the interval used to re-seed the graph when taking pictures for a
     * coloring book.
     *
     * @return The number of pictures to be taken before the graph is re-seeded
     */
    public int getPictureInterval() {
        return pictureInterval;
    }//end getPictureInterval

    /**
     * Sets the number of pictures to be taken before the graph is re-seeded.
     *
     * @param in The new number of pictures to be taken before the graph is
     * re-seeded
     */
    public void setPictureInterval(int in) {
        pictureInterval = in;
    }//end setPictureInterval

    /**
     * Returns the {@link TimerActionListener} used to auto-run steps.
     *
     * @return The {@link TimerActionListener} used to auto-run steps.
     */
    public TimerActionListener getTimerListener() {
        return timerListener;
    } //end getTimerListener

    /**
     * Returns the value of refreshOn, the boolean determining if the seed
     * should be refreshed after each picture interval.
     *
     * @return True if the seed should be refreshed, false if not
     */
    public boolean isRefreshOn() {
        return refreshOn;
    }//end isRefreshOn

    /**
     * Sets the value of refreshOn, the boolean determining if the seed should
     * be refreshed after each picture interval.
     *
     * @param in The new value of refreshOn
     */
    public void setRefreshOn(boolean in) {
        refreshOn = in;
    }//end setRefreshOn

    /**
     * Does step auto-running pause after the picture interval?
     *
     * @return True if yes, false if no
     */
    public boolean isIntervalPause() {
        return intervalPause;
    }//end isIntervalPause

    /**
     * Sets the variable determining if step auto-running should pause after
     * each picture interval.
     *
     * @param in True if yes, false if no
     */
    public void setIntervalPause(boolean in) {
        intervalPause = in;
    }//end setIntervalPause

    /**
     * Returns the {@link Connection} used to communicate with the MySQL
     * database.
     *
     * @return The {@link Connection} object used to communicate with the MySQL
     * database
     */
    public Connection getConn() {
        return conn;
    }//end getConn

    /**
     * Sets a new {@link Connection} used to communicate with the MySQL
     * database.
     *
     * @param in A new {@link Connection} used to communicate with the MySQL
     * database
     */
    public void setConn(Connection in) {
        conn = in;
    }//end setConn

}//end Base class
