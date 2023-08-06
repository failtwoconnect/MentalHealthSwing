package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuUI {
    private QuestionUI questionUI;
    public MenuUI(QuestionUI questionUI){
        this.questionUI = questionUI;
    }
    public JMenuBar menuConfiguration(){

        JMenuBar menuBar = new JMenuBar();
        JMenu goalMenu = new JMenu("Goals");
        JMenu fileMenu = new JMenu("File");

        menuBar.add(fileMenu);
//        menuBar.add(goalMenu);

//        JMenuItem goalMenuItem = new JMenuItem("Goal Tab");
//        goalMenuItem.addActionListener(this::menuActionPerformed);
//        goalMenu.add(goalMenuItem);

        JMenuItem fileMenuItem = new JMenuItem("Load File");
        fileMenuItem.addActionListener(this::LoadFileActionPerformed);
        fileMenu.add(fileMenuItem);

        JMenuItem historyMenuItem = new JMenuItem("Load History");
        historyMenuItem.addActionListener(this::loadHistoryActionPerformed);
        fileMenu.add(historyMenuItem);


        return menuBar;
    }
    private void menuActionPerformed(ActionEvent e){
        Goals goals = new Goals();
        goals.run();
    }

    private void LoadFileActionPerformed(ActionEvent e){
        LoadMenuUI loadMenuUI = new LoadMenuUI(questionUI);
        loadMenuUI.loadActionPerformed(e);

    }

    private void loadHistoryActionPerformed(ActionEvent e){
        LoadMenuUI loadMenuUI = new LoadMenuUI();
        loadMenuUI.loadHistoryActionPerformed(e);
    }

}
