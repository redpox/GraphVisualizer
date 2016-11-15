package SwingElements;

import graphvisualizer.GraphTuple;
import graphvisualizer.GraphTupleInfo;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Form used to input settings for a new line to be created.
 */
public class CustomLineForm extends javax.swing.JFrame implements Runnable {

    private GraphTupleInfo store;                               //The GraphTupleInfo object used to describe the line being created
    private boolean complete = true;                            //Boolean, checking to see if all input has been correctly entered after validation
    private Base ref;                                           //Base object, used to access other objects as needed
    private LineEventDetailsInputForm parent;                   //If set, the LineEventDetailsInputForm asking for a GraphTupleInfo object describing the line to be created

    /**
     * Constructor. Used when the user describes a line to be created by the
     * user.
     *
     * @param simIn The {@link Base} object used to access other objects as
     * needed
     */
    public CustomLineForm(Base simIn) {
        ref = simIn;
        parent = null;
        store = ref.getCanvas().getGtiStorage();
        //initComponents();
    }//end constructor

    /**
     * Constructor. Used when the user describes a line to be created by a
     * {@link PlaceLineEvent}.
     *
     * @param in The {@link LineEventDetailsInputForm} asking for user input
     */
    public CustomLineForm(LineEventDetailsInputForm in) {
        parent = in;
        ref = null;
        store = parent.gti;
    }//end constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HealthLabel = new javax.swing.JLabel();
        HealthTextField = new javax.swing.JTextField();
        MutationLabel = new javax.swing.JLabel();
        MutationTextField = new javax.swing.JTextField();
        jColorChooser1 = new javax.swing.JColorChooser();
        SubmitButton = new javax.swing.JButton();
        CycleBaseLable = new javax.swing.JLabel();
        CycleBaseCheckBox = new javax.swing.JCheckBox();
        ReproductionClockLabel = new javax.swing.JLabel();
        ReproductionClockTextField = new javax.swing.JTextField();
        EdgeLabel = new javax.swing.JLabel();
        EdgeCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        HealthLabel.setText("Health: ");

        MutationLabel.setText("Mutation Chance(out of " + GraphTuple.MUTATION_DIVISOR + "):");

        SubmitButton.setText("OK");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        CycleBaseLable.setText("Cycle Base?");

        ReproductionClockLabel.setText("Turns for reproduction: ");

        EdgeLabel.setText("Edge? ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HealthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HealthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MutationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReproductionClockLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReproductionClockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CycleBaseLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CycleBaseCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EdgeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EdgeCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(SubmitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EdgeCheckBox)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HealthLabel)
                        .addComponent(HealthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MutationLabel)
                        .addComponent(MutationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CycleBaseLable)
                        .addComponent(ReproductionClockLabel)
                        .addComponent(ReproductionClockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EdgeLabel))
                    .addComponent(CycleBaseCheckBox))
                .addGap(5, 5, 5)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubmitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action method for the submit button. Validates input, enters it into a
     * {@link GraphTupleInfo} object, to be used when a line is created.
     */
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        complete = true;
        store.startHealth = checkTextField(HealthTextField, "Starting Health");
        store.mutationPercentage = checkTextField(MutationTextField, "Mutation Percentage");
        store.reproductionClock = checkTextField(ReproductionClockTextField, "Reproduction Clock");
        store.color = jColorChooser1.getColor();
        if (CycleBaseCheckBox.isSelected()) {
            if (store.startHealth > 0) {
                ref.getGraph().setCycleBase(store.startHealth);
            }//end if
        }//end if
        store.edge = EdgeCheckBox.isSelected();
        if (complete) {
            if (ref != null && parent == null) {
                ref.getCanvas().setGtiStorage(store);
            }//end if
            else if (parent != null && ref == null) {
                parent.gti = store;
            }//end else if
            this.dispose();
        }//end if
    }//GEN-LAST:event_SubmitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CycleBaseCheckBox;
    private javax.swing.JLabel CycleBaseLable;
    private javax.swing.JCheckBox EdgeCheckBox;
    private javax.swing.JLabel EdgeLabel;
    private javax.swing.JLabel HealthLabel;
    private javax.swing.JTextField HealthTextField;
    private javax.swing.JLabel MutationLabel;
    private javax.swing.JTextField MutationTextField;
    private javax.swing.JLabel ReproductionClockLabel;
    private javax.swing.JTextField ReproductionClockTextField;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables

    /**
     * Checks a given {@link JTextField} to ensure that the input is numerical
     * and greater than 0.
     *
     * @param field The {@link JTextField} to be checked.
     * @param title The title for the error message, should it be generated.
     * @return The final integer value after checking is performed
     */
    private int checkTextField(JTextField field, String title) {
        int out;
        try {
            out = Integer.parseInt(field.getText());
            if (out < 0) {
                JOptionPane.showMessageDialog(this, "Enter a number greater than 0!", title, JOptionPane.ERROR_MESSAGE);
                complete = false;
                out = -1;
            }//end if
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You must enter a number!", title, JOptionPane.ERROR_MESSAGE);
            complete = false;
            out = -1;
        }//end tryCatch
        return out;
    }//end checkTextField

    @Override
    /**
     * Runs the form.
     */
    public void run() {
        if (ref != null && parent == null) {
            store = ref.getCanvas().getGtiStorage();
            initComponents();
            this.setVisible(true);
        }//end if
        else if (ref == null && parent != null) {
            store = parent.gti;
            initComponents();
            this.setVisible(true);
        }//end else if
    }//end run

}//end CustomLineForm
