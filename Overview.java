package calculatefuelcost;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andrew
 */
public class Overview extends JPanel implements ActionListener, MouseListener {

    JLabel distancePrompt;
    JTextField distanceInput;
    JLabel fuelEconomyPrompt;
    JTextField fuelEconomyInput;
    JLabel fuelPricePrompt;
    JTextField fuelPriceInput;
    JLabel fuelConsumptionLabel;
    JLabel fuelConsumptionOutput;

    JButton calcFuelCostBtn;
    JLabel fuelCostOutputLabel;
    JLabel fuelCostOutput;

    public Overview() {
        distancePrompt = new JLabel("Distance");
        distanceInput = new JTextField("Enter distance in kilometres");
        fuelEconomyPrompt = new JLabel("Fuel economy");
        fuelEconomyInput = new JTextField("Enter litres per 100 kilometres");
        fuelPricePrompt = new JLabel("Fuel price");
        fuelPriceInput = new JTextField("Enter price");
        calcFuelCostBtn = new JButton("calculate cost");
        fuelCostOutputLabel = new JLabel("Fuel cost:");
        fuelCostOutput = new JLabel();
        fuelConsumptionOutput = new JLabel();
        fuelConsumptionLabel = new JLabel("Fuel consumption:");

        this.setLayout(new GridLayout(11, 1));
        this.add(distancePrompt);
        this.add(distanceInput);
        this.add(fuelEconomyPrompt);
        this.add(fuelEconomyInput);
        this.add(fuelPricePrompt);
        this.add(fuelPriceInput);
        this.add(calcFuelCostBtn);
        this.add(fuelConsumptionLabel);
        this.add(fuelConsumptionOutput);
        this.add(fuelCostOutputLabel);
        this.add(fuelCostOutput);

        distanceInput.addActionListener(this);
        fuelEconomyInput.addActionListener(this);
        fuelPriceInput.addActionListener(this);
        calcFuelCostBtn.addActionListener(this);

        distanceInput.addMouseListener(this);
        fuelEconomyInput.addMouseListener(this);
        fuelPriceInput.addMouseListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(calcFuelCostBtn)) {
            double distInput = Double.parseDouble(distanceInput.getText());
            double fuelEconInput = Double.parseDouble(fuelEconomyInput.getText());
            double fuelCostInput = Double.parseDouble(fuelPriceInput.getText());

            double fuelConsumption = distInput / 100 * fuelEconInput;
            double fuelCost = fuelConsumption * fuelCostInput;
            fuelConsumptionOutput.setText(String.valueOf(fuelConsumption) + " litres");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);

            fuelCostOutput.setText(String.valueOf(currencyFormatter.format(fuelCost)));

        }
    }

    public void mousePressed(MouseEvent me) {
        if (me.getSource().equals(distanceInput)) {
            distanceInput.setText(null);
        }
        if (me.getSource().equals(fuelEconomyInput)) {
            fuelEconomyInput.setText(null);
        }
        if (me.getSource().equals(fuelPriceInput)) {
            fuelPriceInput.setText(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
