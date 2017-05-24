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
    private Frame frame;
    private Label labelBoatType;

    private JComboBox boatType;

    //TODO:  add other boats w/o cox, etc
    private String[] boatTypes = {"8+", "4+", "2-"};
    public BoatRandomizerApplication()
    {

    }

    private void setupFrame()
    {
        frame = new JFrame();
        frame.setSize(800, 1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        boatType = new JComboBox(boatTypes);
        boatType.setSelectedIndex(0);
        boatType.addActionListener(e -> System.out.println("action occurred"));
        labelBoatType = new Label("Boat Type");
    }

    public static void main(String[] args)
    {
        new BoatRandomizerApplication();
    }
}