package Run;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuUI {

    public JMenuBar menuConfiguration(){

        JMenuBar menuBar = new JMenuBar();
        JMenu goalMenu = new JMenu("Goals");
        JMenu fileMenu = new JMenu("File");

        menuBar.add(fileMenu);
        menuBar.add(goalMenu);

        JMenuItem goalMenuItem = new JMenuItem("Goal Tab");
        goalMenuItem.addActionListener(this::menuActionPerformed);
        goalMenu.add(goalMenuItem);

        JMenuItem fileMenuItem = new JMenuItem("Load File");
        fileMenuItem.addActionListener(this::LoadFileActionPerformed);
        fileMenu.add(fileMenuItem);



        return menuBar;
    }
    private void menuActionPerformed(ActionEvent e){
        Goals goals = new Goals();
        goals.run();
    }

    private void LoadFileActionPerformed(ActionEvent e){
        LoadMenuUI loadMenuUI = new LoadMenuUI();
        loadMenuUI.loadActionPerformed(e);

    }

}
