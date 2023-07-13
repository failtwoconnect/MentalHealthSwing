package Run;

import Therapy.Evaluations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class QuestionUI {
    private String saveFilePath;
    private String loadFilePath;
    private ArrayList<String> responseQuestions = new ArrayList<>();
    private int responseQuestionCounter = 1;
    private ArrayList<Evaluations> therapyEvaluations = new ArrayList<>();
    private ArrayList<String> answerQuestions = new ArrayList<>();
    private ButtonGroup radioButtonGroupScore;
    private JLabel errorLabel;
    private JLabel question = new JLabel("");
    private JButton submitButton = new JButton("Submit Answer");
    private Evaluations evaluation;


    public QuestionUI(){
        submitButton.setEnabled(false);
    }


    public QuestionUI(ArrayList<String> answerQuestions, ArrayList<Evaluations> therapyEvaluations){
        this.answerQuestions = answerQuestions;
        this.therapyEvaluations = therapyEvaluations;
    }

    public ArrayList<String> getResponseQuestions() {
        return responseQuestions;
    }

    public void setResponseQuestions(ArrayList<String> responseQuestions) {
        this.responseQuestions = responseQuestions;
    }

    public void setQuestionText(QuestionUI questionUI, String text){
        question.setText(questionUI.responseQuestions.get(0));
    }

    public String getSaveFilePath() {
        return saveFilePath;
    }

    public String getLoadFilePath() {
        return loadFilePath;
    }
    public void setLoadFilePath(String loadFilePath){
        this.loadFilePath = loadFilePath;
    }
    private boolean isPhysicalValidation(){
        String physical = radioButtonGroupScore.getSelection().getActionCommand();
        return physical.equals("0") || physical.equals("1");
    }

    /**
     * This Submit Button Action is to iterate through a list of questions from response.txt
     * @param event is controlling the ActionEvent class
     */
    private void submitButtonActionPerformed(ActionEvent event){
        try{
            String radioButtonScore = radioButtonGroupScore.getSelection().getActionCommand();
            System.out.println("this is the size of the array " + responseQuestions.size());
            if("Submit Answer".equals(event.getActionCommand())
                    && responseQuestionCounter <= responseQuestions.size() - 1
                    && responseQuestionCounter >= 0 ){
                if(radioButtonGroupScore.getSelection().isSelected()) {
                    errorLabel.setText("");
                    answerQuestions.add(radioButtonScore);
                    question.setText(responseQuestions.get(responseQuestionCounter));
                    responseQuestionCounter++;
                }
            }else {
                if(isPhysicalValidation()) {
                    errorLabel.setText("");
                    answerQuestions.add(radioButtonScore);
                    responseQuestionCounter = 1;
                    question.setText(responseQuestions.get(0));
                    Date date = new Date();
                    answerQuestions.add(date.toString());
                    evaluation = new Evaluations();
                    evaluation.arrayListConversion(answerQuestions);
                    therapyEvaluations.add(evaluation);
                    evaluation.writeToFile(answerQuestions, saveFilePath);
                    answerQuestions.clear();
                }
                else{
                    errorLabel.setForeground(Color.RED);
                    errorLabel.setText("Error: needs to be zero (0) or one (1)");
                }
            }
        }catch(Exception exception){
            errorLabel.setForeground(Color.RED);
            errorLabel.setText(exception.getMessage());
            exception.printStackTrace();
        }
    }
    private void radioButtonGroupListener(ActionEvent e){
        submitButton.setEnabled(radioButtonGroupScore.getSelection().isSelected());
    }


//    private void loadButtonActionPerformed(ActionEvent e){
//        String content;
//        try(BufferedReader br = Files.newBufferedReader(Path.of(saveFilePath))){
//            while((content = br.readLine()) != null){
//                evaluation = new Evaluations();
//                evaluation.arrayOfStringsConversion(content.split(","));
//                therapyEvaluations.add(evaluation);
//            }
//
//        }catch(Exception exception){
//            errorLabel.setText("String file not loaded.");
//        }
//    }
    public JPanel borderCenter(){
        JPanel borderCenterPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

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
        borderCenterPanel.add(buttonPanel(), c);

        return borderCenterPanel;
    }

    private JPanel buttonPanel(){
        JPanel submitButtonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10,0,0,0);
        c.anchor = GridBagConstraints.PAGE_END;

        submitButtonPanel.add(submitButton, c);
        submitButton.addActionListener(this::submitButtonActionPerformed);

//        JButton loadButton = new JButton("Load");
//        c.anchor = GridBagConstraints.PAGE_END;
//        c.insets = new Insets(10,0,0,0);

//        submitButtonPanel.add(loadButton, c);
//        loadButton.addActionListener(this::loadButtonActionPerformed);

        return submitButtonPanel;
    }

    private JPanel borderCenterAnswerPanel(){
        JPanel answerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        radioButtonGroupScore = new ButtonGroup();

        JRadioButton radioButton0 = new JRadioButton("0 (Zero)/ False");
        radioButton0.setActionCommand("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 1;
        radioButton0.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton0);

        answerPanel.add(radioButton0, c);

        JRadioButton radioButton1 = new JRadioButton("1 / True");
        radioButton1.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        radioButtonGroupScore.add(radioButton1);
        radioButton1.addActionListener(this::radioButtonGroupListener);
        answerPanel.add(radioButton1, c);

        JRadioButton radioButton2 = new JRadioButton("2");
        radioButton2.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        radioButton2.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton2);
        answerPanel.add(radioButton2, c);

        JRadioButton radioButton3 = new JRadioButton("3");
        radioButton3.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        radioButton3.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton3);
        answerPanel.add(radioButton3, c);

        JRadioButton radioButton4 = new JRadioButton("4");
        radioButton4.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 1;
        radioButton4.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton4);
        answerPanel.add(radioButton4, c);

        JRadioButton radioButton5 = new JRadioButton("5");
        radioButton5.setActionCommand("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 1;
        radioButton5.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton5);
        answerPanel.add(radioButton5, c);

        JRadioButton radioButton6 = new JRadioButton("6");
        radioButton6.setActionCommand("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 1;
        radioButton6.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton6);
        answerPanel.add(radioButton6,c);

        JRadioButton radioButton7 = new JRadioButton("7");
        radioButton7.setActionCommand("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 7;
        c.gridy = 1;
        radioButton7.addActionListener(this::radioButtonGroupListener);
        radioButtonGroupScore.add(radioButton7);
        answerPanel.add(radioButton7, c);

        return answerPanel;
    }
}
