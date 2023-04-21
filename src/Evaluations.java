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
    int physicalSelfHarm;

    public Evaluations(int anxietyScore, int depressionScore, int selfHarmScore, int suicidalIdeationScore, int energyLevelScore, int impulseLevelScore, int cravingsScore, int physicalSelfHarm) {
        this.anxietyScore = anxietyScore;
        this.depressionScore = depressionScore;
        this.selfHarmScore = selfHarmScore;
        this.suicidalIdeationScore = suicidalIdeationScore;
        this.energyLevelScore = energyLevelScore;
        this.impulseLevelScore = impulseLevelScore;
        this.cravingsScore = cravingsScore;
        this.physicalSelfHarm = physicalSelfHarm;
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

    public int isPhysicalSelfHarm() {
        return physicalSelfHarm;
    }

    public void setPhysicalSelfHarm(int physicalSelfHarm) {
        this.physicalSelfHarm = physicalSelfHarm;
    }

    @Override
    public String toString() {
        return "TherpyEvaluation{" +
                "anxietyScore=" + anxietyScore +
                ", depressionScore=" + depressionScore +
                ", selfHarmScore=" + selfHarmScore +
                ", suicidialIdeationScore=" + suicidalIdeationScore +
                ", energyLevelScore=" + energyLevelScore +
                ", impulseLevelScore=" + impulseLevelScore +
                ", cravingsScore=" + cravingsScore +
                ", physicalSelfHarm=" + physicalSelfHarm +
                '}';
    }
    public void writeToFile(ArrayList<String[]> numbersArrayList, Path path) throws IOException {
        for(String[] numbers: numbersArrayList){
            String content = "";
            for(String s : numbers){
                content = s + ",";
                if(Files.exists(path))
                    Files.writeString(path, content, StandardOpenOption.APPEND);
                else
                    Files.writeString(path, content, StandardOpenOption.CREATE);
            }
            if(Files.exists(path))
                Files.writeString(path,"\n",StandardOpenOption.APPEND);
        }
    }
}
