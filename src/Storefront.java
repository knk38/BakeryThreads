import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Storefront extends JFrame {
    JLabel availLoaves;

    public Storefront() {
        super("My Bakery");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        JLabel title= new JLabel("Kirin's Bakery");
        availLoaves= new JLabel("0 Available Loaves");
        title.setFont(new Font("Helvetica", Font.PLAIN, 30));
        add(title, BorderLayout.NORTH);
        add(availLoaves, BorderLayout.CENTER);
        JButton newProducer= new JButton("Add Producer");
        add(newProducer, BorderLayout.EAST);
        pack();
        setVisible(true);
        newProducer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producer p= new Producer();
                p.run();
            }
        });
    }

    public void changeSupply(int newValue) {

        availLoaves.setText(newValue + " Available Loaves");
        availLoaves.paintImmediately(availLoaves.getVisibleRect());
        System.out.println("change");

    }
}
