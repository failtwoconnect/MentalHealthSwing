package Run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Goals {

    JTextArea answerArea;
    JLabel errorMessage;

    public Goals() {

    }
    public void run(){
        JFrame window = new JFrame();
        window.setTitle("child window");
        int WINDOW_LENGTH = 400;
        int WINDOW_HEIGHT = 400;
        window.setSize(WINDOW_LENGTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(mainPanel());
        window.setVisible(true);
    }

    private JPanel mainPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel question = new JLabel("What are your goals for today?");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,10,0);
        c.anchor = GridBagConstraints.PAGE_START;
        panel.add(question, c);

        answerArea = new JTextArea();
        JScrollPane areaScrollPane = new JScrollPane(answerArea);
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        answerArea.setSize(new Dimension(300,300));
        answerArea.setLineWrap(true);
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0,0,0,0);
        panel.add(answerArea, c);

        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 10;
        panel.add(buttonPanel(), c);

        return panel;
    }

    private JPanel buttonPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton submit = new JButton("Submit");
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        panel.add(submit, c);
        submit.addActionListener(this::actionPerformed);

        errorMessage = new JLabel("");
        c.gridx = 1;
        c.gridy = 1;
        panel.add(errorMessage, c);

        return panel;
    }
    public void actionPerformed(ActionEvent e){
        try{
            if(answerArea.getText().equals("")){
                errorMessage.setForeground(Color.RED);
                errorMessage.setText("Text Area is blank.");
            }else{
                errorMessage.setText("");

            }

        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Goals g = new Goals();
        g.run();
    }
}
