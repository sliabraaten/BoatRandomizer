/**
 * Project: BoatRandomizer
 * Description: to interface with the user to generate a randomized lineup based off of user input
 * FHT VERSION: 1.4 05/23/2017
 *
 * @author Seth LiaBraaten
 * @version 1.0 created 23-May-2017 11:27:20 AM
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class BoatRandomizerApplication
{
	private JFrame frame;
	private Label labelBoatType;

	private JComboBox boatType;

	//TODO:  add other boats w/o cox, etc
	private String[] boatTypes = {"8+", "4+", "2-"};
	private String[] sides = {"Any", "Port", "Starboard"};
	private boolean[] coxwains = {false, false, false, false, false, false, false, false, false, false};

	public BoatRandomizerApplication()
	{
		setupFrame();
	}

	private void setupFrame()
	{
		frame = new JFrame();
		frame.setSize(800, 1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JPanel rowerEntry = new JPanel(new GridLayout(20, 2));

		for (int i = 1; i <= 10; i++)
		{
			final int iteration = i;
			rowerEntry.add(new JLabel("Individual " + i));
			//TODO add greying of jcombobox based off of cox check
			//TODO add greying of names based on boat selection
			JCheckBox box = new JCheckBox();
			box.setActionCommand("Cox" + i);
			box.addActionListener(e -> coxwains[iteration] = !coxwains[iteration]);
			rowerEntry.add(box);
			JTextField name = new JTextField();
			name.setActionCommand("Indv" + i);
			rowerEntry.add(name);
			JComboBox side = new JComboBox(sides);
			side.setActionCommand("Side" + i);
			rowerEntry.add(side);

		}

		boatType = new JComboBox(boatTypes);
		boatType.setSelectedIndex(0);
		boatType.addActionListener(e -> System.out.println("action occurred"));
		labelBoatType = new Label("Boat Type");

		frame.add(rowerEntry, BorderLayout.WEST);

		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new BoatRandomizerApplication();
	}
}