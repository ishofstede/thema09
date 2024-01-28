package nl.bioinf.ishofstede.thema09;

/*
 * Copyright (c) 2023. Isabella Hofstede
 *
 */

import org.apache.commons.cli.*;

public class OptionsGetter implements OptionProvider {
    private Options options;
    private CommandLine cmd;
    private String csvFile;
    private String unknownFile;

    public OptionsGetter(String[] args) {
        createOptions();
        parseCommandArgs(args);
    }

    private void createOptions() {
        try {
            this.options = new Options();
            options.addOption(new Option("f",
                    "file",
                    true,
                    "The input CSV file with the known types of the instances"));
            options.addOption(new Option("u",
                    "unknown",
                    true,
                    "The input CSV file of the unknown types of the instances"));
            options.addOption(new Option("h",
                    "help",
                    false,
                    "Displays the help for the command line arguments"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseCommandArgs(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            this.cmd = parser.parse(options, args);
            if (cmd.hasOption('h')) {
                printHelp();
            }
            checkOptions();
        } catch (ParseException exp) {
            System.err.println("Parsing failed! As a result of an error: " +
                    exp.getMessage());
            printHelp();
        }
    }

    private void checkOptions() throws ParseException {
        if (cmd.hasOption('f')) {
            this.csvFile = cmd.getOptionValue('f');
        } else {
            throw new ParseException("No CSV file is provided");
        }
        if (cmd.hasOption('u')) {
            this.unknownFile = cmd.getOptionValue('u');
        } else {
            throw new ParseException("No CSV file is provided with unknown instances");
        }
    }

    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar ./build/libs/wrapper-1.0-SNAPSHOT.jar [options]", options);
    }

    @Override
    public String getFileName() {
        return csvFile;
    }

    @Override
    public String getUnknownFile() {
        return unknownFile;
    }
}
