package net.sf.jweather.metar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Responsible for downloading the METAR reports
 *
 * <p>
 * <code>
 * String metarData = MetarFetcher.fetch("KLAX");<br>
 * </code>
 * </p>
 *
 * @author David Castro, dcastro@apu.edu
 * @version $Revision: 1.4 $
 * @see <a href="Metar.html">Metar</a>
 */
public class MetarFetcher {
    final static String httpMetarURL = "http://weather.noaa.gov/pub/data/observations/metar/stations/";
    private static Logger log = LoggerFactory.getLogger(MetarFetcher.class);
    //final static String httpMetarHostname =  "weather.noaa.gov";
    //final static int    httpMetarPort     =  80;
    //final static String httpMetarPath     = "/pub/data/observations/metar/stations/";

    public static String fetch(String station) throws MetarDownloadException {
        return fetch(station, 0);
    }

    public static String fetch(String station, int timeout) throws MetarDownloadException {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try {
            // create the HttpURLConnection
            url = new URL(httpMetarURL + station + ".TXT");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // give it 15 seconds to respond
            connection.setReadTimeout(timeout);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new MetarDownloadException("Failure downloading METAR", e);
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

}
