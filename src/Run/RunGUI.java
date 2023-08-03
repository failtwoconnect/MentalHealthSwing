package Run;

import UI.Goals;
import UI.MenuUI;
import UI.QuestionUI;

import javax.swing.*;
import java.awt.*;

public class RunGUI {
    private JFrame window;
    private static final QuestionUI QUESTIONUI = new QuestionUI();;
    public RunGUI(){ }


    public void start(){
        MenuUI menuUI = new MenuUI(QUESTIONUI);

        window = new JFrame();
        window.setTitle("Mental Health Application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800,500));

        window.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Questionnaire",QUESTIONUI.borderCenter());
        tabbedPane.add("Goals", Goals.mainPanel());

        window.add(tabbedPane, BorderLayout.CENTER);
        window.add(menuUI.menuConfiguration(), BorderLayout.PAGE_START);
        window.setVisible(true);
    }










}
