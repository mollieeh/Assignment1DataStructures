public class LogEntry {
    private String ymdDate, timeStamp, errorType, reason, logDataLine;

    public LogEntry(String logDataLine) {
        String[] dividedData = logDataLine.split(" ");
        String ymdDate = dividedData[0];
        String timeStamp = dividedData[1];
        String errorType = dividedData[2];
        String reason = dividedData[3]; // depending on first word, we can type the rest

        this.ymdDate = ymdDate;
        this.timeStamp = timeStamp;
        this.errorType = errorType;
        this.reason = reason;
        this.logDataLine = logDataLine;
    }

    // GETTERS
    public String getYmdDate() { // for these, you could take off the first element '['
        return ymdDate;
    }

    public String getTimeStamp() { // remove last element ']'
        return timeStamp;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getReason() { // takes the first word of reason and returns full String
        return reason;
    }

    public String getLogDataLine() {
        return logDataLine;
    }
}
