package nl.bioinf.ishofstede.thema09;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */

/**
 * Interface provides the options that is requested.
 */

public interface OptionProvider {
    /**
     * Gives the name of the csv file
     * @return csv file
     */
    String getFileName();

    /**
     * Give the name of the csv file with the unknown class of the instances
     * @return csv file
     */
    String getUnknownFile();
}