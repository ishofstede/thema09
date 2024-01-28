package nl.bioinf.ishofstede.thema09;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */

import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;

/**
 * This class is the main which gets the arguments and categorise the new instances.
 * Sets up every file to let it work.
 */

public class RunnerMain {
    public static void main(String[] args) {
        OptionProvider optionProvider = new OptionsGetter(args);
        ArgsEngine argsEngine = new ArgsEngine();
        argsEngine.activation(optionProvider);
        CategoriseInstances categoriseInstances = new CategoriseInstances();
        GetData getData = new GetData();
        try {
            Instances train = getData.loadFromCsvFile(optionProvider.getFileName());
            SimpleLogistic simpleLogistic = categoriseInstances.buildModel(train);
            categoriseInstances.saveClassifier(simpleLogistic);
            SimpleLogistic fromFile = categoriseInstances.loadClassifier();
            Instances test = getData.loadFromCsvFile(optionProvider.getUnknownFile());
            Instances removedAttribute = getData.removeAttribute(test);
            categoriseInstances.CategoriseUnknownInstances(fromFile, removedAttribute);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
