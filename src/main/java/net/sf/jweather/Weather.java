package net.sf.jweather;

import net.sf.jweather.metar.Metar;
import net.sf.jweather.metar.MetarDownloadException;
import net.sf.jweather.metar.MetarFetcher;
import net.sf.jweather.metar.MetarParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Responsible for downloading the METAR reports and feeding them to the Metar
 * class to be parsed
 *
 * <p>
 * <code>
 * Metar metar = Weather.getMetar("KLAX");<br>
 * metar.print();
 * </code>
 * </p>
 *
 * @author David Castro, dcastro@apu.edu
 * @version $Revision: 1.8 $
 * @see <a href="MetarFetcher.html">Metar</a>
 * @see <a href="Metar.html">Metar</a>
 */
public class Weather {
    private static final Logger log = LoggerFactory.getLogger(Weather.class);

    static {
        log.debug("Weather: instantiated");
    }

    public static Metar getMetar(String station) {
        return getMetar(station, 0);
    }

    public static Metar getMetar(String station, int timeout) {
        Metar metar = null;
        try {
            String metarData = MetarFetcher.fetch(station, timeout);

            if (metarData != null) {
                try {
                    metar = MetarParser.parse(metarData);
                } catch (Exception e) {
                    System.err.println("Weather: " + e);
                    e.printStackTrace(System.err);
                }
            }
        } catch (MetarDownloadException mde) {
            System.err.println("Unable to download METAR for: " + station);
            mde.printStackTrace(System.err);
        }

        return metar;
    }
}
