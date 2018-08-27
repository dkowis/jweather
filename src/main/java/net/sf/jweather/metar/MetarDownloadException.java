package net.sf.jweather.metar;

public class MetarDownloadException extends Exception {
    public MetarDownloadException(String message) {
        super(message);
    }

    public MetarDownloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetarDownloadException(Throwable cause) {
        super(cause);
    }

    public MetarDownloadException() {
        super();
    }
}
