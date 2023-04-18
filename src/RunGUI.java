import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;

public class RunGUI {

    private final Path SAVE_FILEPATH = Path.of("src\\responseHistory.txt");
    private final Path LOAD_FILEPATH = Path.of("src\\response.txt");
    private int counter = 1;
    private ArrayList<String> answerQuestions;
    private String[] responseQuestions;
    private JPanel northPanel;
    private JPanel answerPanel;
    private JPanel borderCenterPanel;
    private JPanel submitButtonPanel;
    private JRadioButton radioButton0;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private ButtonGroup radioButtonGroupScore;
    private JLabel questionHeader;
    private JLabel errorLabel;
    private JLabel question;
    private JButton submitButton;
    public RunGUI(){

    }

    public void start(){
        loadFile();
        answerQuestions = new ArrayList<>();
        JFrame window = new JFrame();
        window.setTitle("hello world");
        int WINDOW_LENGTH = 800;
        int WINDOW_WIDTH = 600;
        window.setSize(WINDOW_LENGTH, WINDOW_WIDTH);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        window.setLayout(new BorderLayout());
        window.add(borderCenter(), BorderLayout.CENTER);
        window.add(borderNorth(), BorderLayout.PAGE_START);
        window.setVisible(true);
    }

    private void loadFile(){
        responseQuestions = new String[8];
        int ctr = 0;
        String content;
        try(BufferedReader br = Files.newBufferedReader(LOAD_FILEPATH)){
            while((content = br.readLine()) != null){
                responseQuestions[ctr] = content;
                ctr++;
            }

        }catch(Exception e){
            errorLabel.setText("String file not loaded.");
        }
    }
    private void writeToFile() throws IOException {
        StringBuilder content = new StringBuilder();
        Date date = new Date();
        for (String s: answerQuestions) {
            content.append(s);
        }
        if(Files.exists(SAVE_FILEPATH))
            Files.writeString(SAVE_FILEPATH, content, StandardOpenOption.APPEND);
        else
            Files.writeString(SAVE_FILEPATH, content, StandardOpenOption.CREATE);
        Files.writeString(SAVE_FILEPATH,"\n" + date.toString(),StandardOpenOption.APPEND);
        answerQuestions.clear();
    }

    public void actionPerformed(ActionEvent e){
        try{
            if("Submit Answer".equals(e.getActionCommand()) && counter <= 7 && counter >= 0 ){
                if(radioButtonGroupScore.getSelection().isSelected()) {
                    errorLabel.setText("");
                    answerQuestions.add(radioButtonGroupScore.getSelection().getActionCommand() + ",");
                    question.setText(responseQuestions[counter]);
                    counter++;
                }

            }else {
                counter = 0;
                question.setText(responseQuestions[counter]);
                writeToFile();

            }
        }catch(Exception exception){
            errorLabel.setText("Error: Nothing is selected.");
            exception.printStackTrace();
        }


    }

    private JPanel borderCenter(){
        borderCenterPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        question = new JLabel("What is your anxiety level like today (0-7)?");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,10,0);
        borderCenterPanel.add(question, c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        borderCenterPanel.add(borderCenterAnswerPanel(), c);

        errorLabel = new JLabel("");
        c.gridx = 1;
        c.gridy = 2;
        borderCenterPanel.add(errorLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        borderCenterPanel.add(submitButtonPanel(), c);
        return borderCenterPanel;
    }

    private JPanel submitButtonPanel(){
        submitButtonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        submitButton = new JButton("Submit Answer");
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(10,0,0,0);
        c.anchor = GridBagConstraints.PAGE_END;
        submitButtonPanel.add(submitButton, c);
        submitButton.addActionListener(this::actionPerformed);
        return submitButtonPanel;
    }

    private JPanel borderCenterAnswerPanel(){
        answerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        radioButtonGroupScore = new ButtonGroup();

        radioButton0 = new JRadioButton("0 (Zero)");
        radioButton0.setActionCommand("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton0);
        answerPanel.add(radioButton0, c);

        radioButton1 = new JRadioButton("1");
        radioButton1.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton1);
        answerPanel.add(radioButton1, c);

        radioButton2 = new JRadioButton("2");
        radioButton2.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton2);
        answerPanel.add(radioButton2, c);

        radioButton3 = new JRadioButton("3");
        radioButton3.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton3);
        answerPanel.add(radioButton3, c);

        radioButton4 = new JRadioButton("4");
        radioButton4.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton4);
        answerPanel.add(radioButton4, c);

        radioButton5 = new JRadioButton("5");
        radioButton5.setActionCommand("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton5);
        answerPanel.add(radioButton5, c);

        radioButton6 = new JRadioButton("6");
        radioButton6.setActionCommand("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton6);
        answerPanel.add(radioButton6 ,c);

        radioButton7 = new JRadioButton("7");
        radioButton7.setActionCommand("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 7;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton7);
        answerPanel.add(radioButton7, c);

        return answerPanel;
    }
    private JPanel borderNorth(){
        northPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        questionHeader = new JLabel();
        questionHeader.setText("Hello World.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 40;
        c.insets = new Insets(0,0,10,0);
        c.anchor = GridBagConstraints.CENTER;

        northPanel.add(questionHeader,c);
        return northPanel;
    }

}
