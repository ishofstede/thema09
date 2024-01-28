package nl.bioinf.ishofstede.thema09;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;
import java.io.IOException;

public class GetData {
    protected Instances removeAttribute(Instances datafile) throws Exception {
        Remove remove = new Remove();
        remove.setInvertSelection(false);
        remove.setInputFormat(datafile);
        Instances filteredData = Filter.useFilter(datafile, remove);
        return filteredData;
    }

    protected Instances loadFromCsvFile(String datafile) throws IOException {
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(datafile));
            Instances data = loader.getDataSet();
            if (data.classIndex() == -1) {
                data.setClassIndex(data.numAttributes() - 1);
            }
            return data;
        } catch (IOException e) {
            throw new IOException("[Error] Failed to load instances from CSV file " + datafile);
        }
    }
}
