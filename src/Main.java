public class Main {
    public static void main(String[] args) {
        LogEntryProcessor logEntryProcessor = new LogEntryProcessor();
        Queue<LogEntry> logQueue = logEntryProcessor.readFileIntoQueue("log-data.csv");
        Stack<LogEntry> logStack = logEntryProcessor.createErrorStack(logQueue);
        logEntryProcessor.printDataAnalysis(logStack);
    }
}
