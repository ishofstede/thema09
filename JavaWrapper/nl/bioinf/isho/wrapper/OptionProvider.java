package nl.bioinf.isho.wrapper;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */

/**
 * Interface provides the options that is requested.
 */

public interface OptionProvider {
    /**
     * Gives the name of the arff file
     * @return arff file
     */
    String getFileName();

    /**
     * Give the name of the arff file with the unknown class of the instances
     * @return arff file
     */
    String getUnknownFile();
}