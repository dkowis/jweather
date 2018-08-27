jWeather (TM) v0.4.0

Copyright (C) 2018, David Kowis

Previous Versions:

Copyright (C) 2003, Azusa Pacific University

Contact:  David Castro <dcastro@apu.edu>

jWeather is a Java library for parsing raw weather data (e.g. METAR, TAF).
Initially it will focus on parsing and providing an API for access to METAR
data, but may grow to include access to multiple reporting formats.

Please see LICENSE in this directory for jWeather licensing information. 

Thanks to the National Oceanic and Atmospheric Administration for the work they
have done to provide this data to the public.  More information regarding
weather data and the NOAA can be found at http://www.noaa.gov/

Information regarding METAR specification can be found at
http://www.ofcm.gov/fmh-1/fmh1.htm

Information regarding the TAF specification can be found at
http://metar.noaa.gov/table_master.jsp?sub_menu=yes&dir=./rel_docs/wsom/d31/&show=d31links.htm&title=title_related_docs

Requirements:
* Java 8

Testing:
  optionally change the station id in the build.xml file.  To do this, change
  the argument specified for 'test' target to a valid station id (see
  stations.txt for a list of valid stations).


  with any luck, you should now be seeing parsed weather data

