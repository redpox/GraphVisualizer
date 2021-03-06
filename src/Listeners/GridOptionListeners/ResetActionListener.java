package Listeners.GridOptionListeners;

import SwingElements.Base;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * {@link ActionListener} child, clear the graph when the corresponding menu
 * button is pressed in the {@link Base} class.
 */
public class ResetActionListener implements ActionListener {

    private Base ref;                                                           //Base object, used for reference

    /**
     * Constructor.
     *
     * @param in {@link Base} object, used for reference
     */
    public ResetActionListener(Base in) {
        ref = in;
    }//end constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        ref.pause();
        ref.getGraph().reset();
        if ("Restore all grid point colors".equals(ref.getWhiteOutGrid().getText())) {
            ref.getWhiteOutGrid().getActionListeners()[0].actionPerformed(e);
        }//end if
    }//endActionPerformed
}//end LoopActionListener
