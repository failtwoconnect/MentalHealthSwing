package Run;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class LoadMenuUI extends Component {

    private JFileChooser fileChooser;
    public LoadMenuUI() { }


    public void loadQuestions(QuestionUI questionUI){
        ArrayList<String> questions = new ArrayList<>();
        String content;

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File("C:/Users/Emily/IdeaProjects"));

        try(BufferedReader br = Files.newBufferedReader(Path.of(questionUI.getLoadFilePath()))){
            System.out.println(questionUI.getLoadFilePath());
            while((content = br.readLine()) != null){

                questions.add(content);
            }
            questionUI.setResponseQuestions(questions);
            questionUI.setQuestionText(questionUI, questions.get(0));
            System.out.println("Response Question array size is " + questionUI.getResponseQuestions().size());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadActionPerformed(ActionEvent e) {
            QuestionUI questionUI = new QuestionUI();
            int returnVal = fileChooser.showOpenDialog(LoadMenuUI.this);

            if (returnVal == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                questionUI.setLoadFilePath(file.getPath());
//                System.out.println(questionUI.getLoadFilePath());
                loadQuestions(questionUI);
            }

    }
}
