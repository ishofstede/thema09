package nl.bioinf.ishofstede.thema09;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */


import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;

public class CategoriseInstances {
    protected final String simpleLogisticModelFile = "./build/resources/main/SimpleLogistic.model";



    protected void CategoriseUnknownInstances(SimpleLogistic model, Instances test) throws Exception {
        Instances predicted = new Instances(test);
        for (int i = 0; i < test.numInstances(); i++) {
            double[] preds = model.distributionForInstance(test.instance(i));
            int predClass = (int) model.classifyInstance(test.instance(i));
            System.out.println("type: " + test.instance(i).value(10) +
                    ", Predicted type: " + test.classAttribute().value(predClass));
        }
    }

    protected SimpleLogistic loadClassifier() throws Exception {
        return (SimpleLogistic) weka.core.SerializationHelper.read(simpleLogisticModelFile);
    }

    protected void saveClassifier(SimpleLogistic simpleLogistic) throws Exception {
        weka.core.SerializationHelper.write(simpleLogisticModelFile, simpleLogistic);
    }

    protected SimpleLogistic buildModel(Instances train) throws Exception {
        SimpleLogistic model = new SimpleLogistic();
        model.buildClassifier(train);
        return model;
    }
}
