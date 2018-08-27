package net.sf.jweather.metar;


/**
 * Basic JWeather parse exception. This is simply a holder to identify a
 * parsing problem. It should be extended to identify more specific issues.
 *
 * @author dennis@bullamanka.com
 */
public class MetarParseException extends Exception {

    /**
     * The record that caused the exception.
     */
    protected String record = null;

    /**
     * Default constructor
     */
    public MetarParseException() {
        super();
    }

    /**
     * Create exception with error message
     *
     * @param message The error message for this exception
     */
    public MetarParseException(String message) {
        super(message);
    }

    /**
     * Create exception based on an existing Throwable
     *
     * @param cause The throwable on which we'll base this exception
     */
    public MetarParseException(Throwable cause) {
        super(cause);
    }

    /**
     * Create an exception with custom message and throwable info
     *
     * @param message The message
     * @param cause   The target Throwable
     */
    public MetarParseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return Returns the record.
     */
    public String getRecord() {
        return record;
    }

    /**
     * @param record The record to set.
     */
    public void setRecord(String record) {
        this.record = record;
    }
}
