import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogEntryProcessor { // reads the file and adds it to the queue
    private int errorCount = 0, warnCount = 0, infoCount = 0, memoryCount = 0;

    public Queue<LogEntry> readFileIntoQueue(String fileName) {
        try {
            System.out.println("Reading log file.\n");
            File logData = new File(fileName);
            Queue<LogEntry> logEntries = new Queue<LogEntry>(); // maybe these can be outside of main?
            Scanner scanner = new Scanner(logData);
            scanner.nextLine(); // skips the "Log Entry" line at the beginning
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine(); // data is each line of the csv
                LogEntry dataObjects = new LogEntry(data);
                logEntries.enqueue(dataObjects); // add each log entry into a queue
            }
            scanner.close();
            System.out.println("Read finished.");
            return logEntries;
        } catch (FileNotFoundException e) {
            System.out.println("file reading error");
            e.printStackTrace();
            return null;
        }

    }

    public Stack<LogEntry> createErrorStack(Queue<LogEntry> logEntries) {
        Stack<LogEntry> errorStack = new Stack<LogEntry>();
        while (!logEntries.isEmpty()) {
            LogEntry entry = logEntries.dequeue(); // local value entry assigned to value that was dequeued
            switch (entry.getErrorType()) {
                case "ERROR":
                    errorStack.push(entry); // adds errors to the stack
                    errorCount++;
                    break;
                case "WARN":  // NUMBER 6 check for memory
                    if (entry.getReason().equals("Memory")) {
                        memoryCount++;
                    }
                    warnCount++;
                    break;
                case "INFO":
                    infoCount++;
                    break;
            }
        }
        return errorStack;
    }

    public void printDataAnalysis(Stack<LogEntry> errorStack) {
        System.out.println("\n** Log Level Count: **");
        System.out.println(
                "INFO: " + infoCount +
                        "\nWARN: " + warnCount +
                        "\nERRORS: " + errorCount +
                        "\nMemory Warnings: " + memoryCount +
                        "\n");

        System.out.println("** Last 100 Errors: **");
        for (int i = 0; i < 100; i++) {
            LogEntry poppedObject = errorStack.pop();
            System.out.println(poppedObject.getLogDataLine());
        }
    }
}

// Sources Used:
// https://www.w3schools.com/java/java_files_read.asp
// https://stackoverflow.com/questions/21082139/java-scanner-class-skipping-over-the-first-line-when-reading-a-textfile
