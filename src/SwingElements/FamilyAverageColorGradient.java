package SwingElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Frame responsible for displaying a gradient of average family colors over
 * time. Each instance displays the gradient for one family.
 */
public class FamilyAverageColorGradient extends javax.swing.JFrame implements Runnable {

    private ArrayList<Color> colors = new ArrayList<>();                    //List of colors recorded

    /**
     * Internal class used to draw and manipulate the gradient.
     */
    private class GCanvas extends JPanel {

        int windowX = 0;             //Used to record the distance the mouse has been dragged on the X axis

        int startX;                  //Variable used to record the starting mouse X position on mouse pressed/dragged

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            this.setBackground(Color.WHITE);
            for (int i = 0; i < colors.size(); i++) {
                g.setColor(colors.get(i));
                g.fillRect(i * 2 + windowX, 0, 2, 1000);
            }//end for
        }//end paint
    }
    private GCanvas canvas = new GCanvas();                                 //Implementation of the GCanvas internal class

    /**
     * Constructor.
     */
    public FamilyAverageColorGradient(int familyID) {
        initComponents();
        this.add(canvas);
        canvas.setSize(this.getWidth(), this.getHeight());
        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    canvas.startX = e.getXOnScreen();
                }//end if
            }//end mousePressed

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    canvas.windowX += (e.getXOnScreen() - canvas.startX);
                    canvas.startX = e.getXOnScreen();
                    canvas.repaint();
                }//end if
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }//end mouseMoved

        });
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        canvas.setBackground(Color.WHITE);
        this.setTitle("Average Color Gradient for Family " + familyID);
    }//end constructor

    /**
     * Adds a new color to the gradient.
     *
     * @param in The color to be added
     */
    public void addNewColor(Color in) {
        colors.add(in);
    }//end addNewColor

    /**
     * External method to cause the window to update with a new color.
     */
    public void refresh() {
        canvas.repaint();
    }//end refresh

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        setVisible(true);
    }//end for

}//end FamilyAverageColorGradient
