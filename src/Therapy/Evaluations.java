package Therapy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Evaluations {
    int anxietyScore;
    int depressionScore;
    int selfHarmScore;
    int suicidalIdeationScore;
    int energyLevelScore;
    int impulseLevelScore;
    int cravingsScore;
    boolean physicalSelfHarm;
    String date;

    public Evaluations(int anxietyScore, int depressionScore, int selfHarmScore, int suicidalIdeationScore, int energyLevelScore, int impulseLevelScore, int cravingsScore, boolean physicalSelfHarm, String date) {
        this.anxietyScore = anxietyScore;
        this.depressionScore = depressionScore;
        this.selfHarmScore = selfHarmScore;
        this.suicidalIdeationScore = suicidalIdeationScore;
        this.energyLevelScore = energyLevelScore;
        this.impulseLevelScore = impulseLevelScore;
        this.cravingsScore = cravingsScore;
        this.physicalSelfHarm = physicalSelfHarm;
        this.date = date;
    }

    public Evaluations() {

    }

    public int getAnxietyScore() {
        return anxietyScore;
    }

    public void setAnxietyScore(int anxietyScore) {
        this.anxietyScore = anxietyScore;
    }

    public int getDepressionScore() {
        return depressionScore;
    }

    public void setDepressionScore(int depressionScore) {
        this.depressionScore = depressionScore;
    }

    public int getSelfHarmScore() {
        return selfHarmScore;
    }

    public void setSelfHarmScore(int selfHarmScore) {
        this.selfHarmScore = selfHarmScore;
    }

    public int getSuicidalIdeationScore() {
        return suicidalIdeationScore;
    }

    public void setSuicidalIdeationScore(int suicidalIdeationScore) {
        this.suicidalIdeationScore = suicidalIdeationScore;
    }

    public int getEnergyLevelScore() {
        return energyLevelScore;
    }

    public void setEnergyLevelScore(int energyLevelScore) {
        this.energyLevelScore = energyLevelScore;
    }

    public int getImpulseLevelScore() {
        return impulseLevelScore;
    }

    public void setImpulseLevelScore(int impulseLevelScore) {
        this.impulseLevelScore = impulseLevelScore;
    }

    public int getCravingsScore() {
        return cravingsScore;
    }

    public void setCravingsScore(int cravingsScore) {
        this.cravingsScore = cravingsScore;
    }

    public boolean isPhysicalSelfHarm() {
        return physicalSelfHarm;
    }

    public void setPhysicalSelfHarm(boolean physicalSelfHarm) {
        this.physicalSelfHarm = physicalSelfHarm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TherapyEvaluation{" +
                "anxietyScore=" + anxietyScore +
                ", depressionScore=" + depressionScore +
                ", selfHarmScore=" + selfHarmScore +
                ", suicidalIdeationScore=" + suicidalIdeationScore +
                ", energyLevelScore=" + energyLevelScore +
                ", impulseLevelScore=" + impulseLevelScore +
                ", cravingsScore=" + cravingsScore +
                ", physicalSelfHarm=" + physicalSelfHarm +
                ", date=" + date +
                '}';
    }
    public void writeToFile(ArrayList <String> answerQuestions, String save_filepath) throws IOException {
        StringBuilder content = new StringBuilder();
        Path saveFile = Path.of(save_filepath);
        for (int i = 0; i < answerQuestions.size(); i++) {
           content = i <=7  ? content.append(answerQuestions.get(i)).append(",")
                            : content.append(answerQuestions.get(i));
        }
        if(Files.exists(saveFile))
            Files.writeString(saveFile, content, StandardOpenOption.APPEND);
        else
            Files.writeString(saveFile, content, StandardOpenOption.CREATE);
        Files.writeString(saveFile,"\n",StandardOpenOption.APPEND);
    }
    public void arrayListConversion(ArrayList<String> strings) {
        anxietyScore = Integer.parseInt(strings.get(0));
        depressionScore = Integer.parseInt(strings.get(1));
        selfHarmScore = Integer.parseInt(strings.get(2));
        suicidalIdeationScore = Integer.parseInt(strings.get(3));
        energyLevelScore = Integer.parseInt(strings.get(4));
        impulseLevelScore = Integer.parseInt(strings.get(5));
        cravingsScore = Integer.parseInt(strings.get(6));
        physicalSelfHarm = strings.get(7).equals("1");
        date = strings.get(8);
    }
    public Evaluations arrayOfStringsConversion(String[] strings) {
        Evaluations eval = new Evaluations();
        eval.anxietyScore = Integer.parseInt(strings[0]);
        eval.depressionScore = Integer.parseInt(strings[1]);
        eval.selfHarmScore = Integer.parseInt(strings[2]);
        eval.suicidalIdeationScore = Integer.parseInt(strings[3]);
        eval.energyLevelScore = Integer.parseInt(strings[4]);
        eval.impulseLevelScore = Integer.parseInt(strings[5]);
        eval.cravingsScore = Integer.parseInt(strings[6]);
        eval.physicalSelfHarm = strings[7].equals("1");
        eval.date = strings[8];
        return eval;
    }


}
