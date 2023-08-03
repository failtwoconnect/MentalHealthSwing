package UI;


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
    private QuestionUI questionUI;

    public LoadMenuUI() {}

    public LoadMenuUI(QuestionUI questionUI){
        this.questionUI = questionUI;
    }
    public void loadQuestions(){
        ArrayList<String> questions = new ArrayList<>();
        String content;

        try(BufferedReader br = Files.newBufferedReader(Path.of(questionUI.getLoadFilePath()))){
            while((content = br.readLine()) != null){
                questions.add(content);
            }
            questionUI.setResponseQuestions(questions);
            questionUI.setQuestionText(questions.get(0));

        }catch(Exception e){
            System.out.println("Load file failed to load correctly");
            e.printStackTrace();
        }
    }

    public void loadActionPerformed(ActionEvent e) {
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setCurrentDirectory(new File("C:/Users/Emily/IdeaProjects"));
            int returnVal = fileChooser.showOpenDialog(LoadMenuUI.this);

            if (returnVal == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                questionUI.setLoadFilePath(file.getPath());
                loadQuestions();
            }

    }

    public void loadHistoryActionPerformed(ActionEvent e){

    }
}
