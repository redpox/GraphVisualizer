package SwingElements;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GridSelectionFrame extends javax.swing.JFrame implements Runnable {

    private Base ref;

    public GridSelectionFrame(Base in) {
        ref = in;
        initComponents();
        if (ref != null) {
            NumberOfRowsTextField.setText(ref.getGraph().getMatrix().length + "");
            NumberOfColumnsTextField.setText(ref.getGraph().getMatrix()[0].length + "");
            StepTimeTextField.setText(ref.getStepTime() + "");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }//end if
    }//end constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NumberOfColumnsLabel = new javax.swing.JLabel();
        NumberOfRowsLabel = new javax.swing.JLabel();
        NumberOfColumnsTextField = new javax.swing.JTextField();
        NumberOfRowsTextField = new javax.swing.JTextField();
        SubmitButton = new javax.swing.JButton();
        TimeBetweenStepsLabel = new javax.swing.JLabel();
        StepTimeTextField = new javax.swing.JTextField();
        PictureCycleLabel = new javax.swing.JLabel();
        PictureCycleTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 155));
        setPreferredSize(new java.awt.Dimension(300, 155));
        setResizable(false);

        NumberOfColumnsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberOfColumnsLabel.setText("Number of Columns");
        NumberOfColumnsLabel.setMaximumSize(new java.awt.Dimension(93, 15));
        NumberOfColumnsLabel.setMinimumSize(new java.awt.Dimension(93, 15));
        NumberOfColumnsLabel.setPreferredSize(new java.awt.Dimension(93, 15));

        NumberOfRowsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberOfRowsLabel.setText("Number of Rows");

        SubmitButton.setText("Ok");
        SubmitButton.setMaximumSize(new java.awt.Dimension(50, 25));
        SubmitButton.setMinimumSize(new java.awt.Dimension(50, 25));
        SubmitButton.setPreferredSize(new java.awt.Dimension(50, 25));
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        TimeBetweenStepsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeBetweenStepsLabel.setText("Time between steps");
        TimeBetweenStepsLabel.setMaximumSize(new java.awt.Dimension(96, 15));
        TimeBetweenStepsLabel.setMinimumSize(new java.awt.Dimension(96, 15));

        PictureCycleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PictureCycleLabel.setText("Picture Cycle Length");

        PictureCycleTextField.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NumberOfColumnsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PictureCycleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumberOfRowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StepTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PictureCycleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TimeBetweenStepsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NumberOfColumnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NumberOfRowsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberOfColumnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumberOfRowsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberOfColumnsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumberOfRowsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeBetweenStepsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PictureCycleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StepTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PictureCycleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        int c = checkTextField(NumberOfColumnsTextField, "Columns");
        int r = checkTextField(NumberOfRowsTextField, "Rows");
        int st = checkTextField(StepTimeTextField, "Step Time");
        int pc = checkTextField(PictureCycleTextField,"Cycle Length");
        if (c != -1 && r != -1) {
            if (ref == null) {
                new Base(c, r, st, pc).setVisible(true);
            } else {
                ref.resizeGrid(c, r, st, pc);
            }//end else
            this.dispose();
        }//end if
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private int checkTextField(JTextField field, String title) {
        int out;
        try {
            out = Integer.parseInt(field.getText());
            if (out <= 0) {
                JOptionPane.showMessageDialog(this, "Enter a number greater than 0!", title, JOptionPane.ERROR_MESSAGE);
                out = -1;
            }//end if
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You must enter a number!", title, JOptionPane.ERROR_MESSAGE);
            out = -1;
        }//end tryCatch
        return out;
    }//end checkTextField


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NumberOfColumnsLabel;
    private javax.swing.JTextField NumberOfColumnsTextField;
    private javax.swing.JLabel NumberOfRowsLabel;
    private javax.swing.JTextField NumberOfRowsTextField;
    private javax.swing.JLabel PictureCycleLabel;
    private javax.swing.JTextField PictureCycleTextField;
    private javax.swing.JTextField StepTimeTextField;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel TimeBetweenStepsLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        if (ref != null) {
            this.setVisible(true);
        }//end if
    }//end run
}//end GridSelectionFrame
