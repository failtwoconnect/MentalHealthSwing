package Run;

import Therapy.Evaluations;

import javax.swing.*;
import java.awt.*;

public class RunGUI {




    private JFrame window;

    public RunGUI(){

    }

    public void start(){
        MenuUI menuUI = new MenuUI();
        QuestionUI qUI = new QuestionUI();

        window = new JFrame();
        window.setTitle("hello world");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800,500));


        window.setLayout(new BorderLayout());
        window.add(qUI.borderCenter(), BorderLayout.CENTER);
        window.add(menuUI.menuConfiguration(), BorderLayout.PAGE_START);
        window.setVisible(true);
    }










}
