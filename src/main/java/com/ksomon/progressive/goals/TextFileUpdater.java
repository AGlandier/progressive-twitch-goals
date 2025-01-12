package com.ksomon.progressive.goals;

import com.ksomon.progressive.goals.model.Goal;
import com.ksomon.progressive.goals.parser.GoalParser;
import com.ksomon.progressive.goals.parser.GoalsReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TextFileUpdater {

    private File textFile;
    private List<Goal> goals;

    public TextFileUpdater(File textFile, File csvFile) throws IOException {
        this.textFile = textFile;
        GoalsReader reader = new GoalsReader(csvFile, new GoalParser());
        this.goals = reader.getAllGoals();
        this.goals.sort(Comparator.comparingInt(Goal::getAmount));
    }

    public void updateTextToDisplay(Integer count) throws IOException {
        FileWriter writer = new FileWriter(textFile);
        Goal goal = getAccurateGoal(count);
        String line = count.toString() + "/" + goal.getAmount() + " : " + goal.getName();
        writer.write(line);
        writer.close();
    }

    private Goal getAccurateGoal(Integer amount) {
        Iterator<Goal> itGoal = this.goals.iterator();
        while (itGoal.hasNext()) {
            Goal current = itGoal.next();
            if (amount < current.getAmount()) {
                return current;
            }
        }
        return this.goals.get(this.goals.size()-1);
    }




}
