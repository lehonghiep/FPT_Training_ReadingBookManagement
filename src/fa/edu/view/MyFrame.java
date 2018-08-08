package fa.edu.view;

import fa.edu.Constants;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        setTitle(Constants.TITLE);
        setSize(Constants.WIDTH_LOGIN, Constants.HEIGHT_LOGIN);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
