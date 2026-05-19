package project;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;

import com.gs.imd.pwm.qa.rest.util.log.TestLogger;

public class Utils {

    private static Logger logger = TestLogger.logger();

    private static Properties properties;

    static {
        loadProperties();
    }

    public static void loadProperties() {
        properties = new Properties();

        final InputStream stream = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.application.properties");

        final InputStream streamTwilio = Utils.class.getClassLoader()
                .getResourceAsStream("twilio.properties");

        final InputStream appProp = Utils.class.getClassLoader()
                .getResourceAsStream("application.properties");

        final InputStream streamApplitools = Utils.class.getClassLoader()
                .getResourceAsStream("applitools.properties");

        final InputStream clientOnboarding = Utils.class.getClassLoader()
                .getResourceAsStream("clientOnboarding.properties");

        final InputStream mobileLocators = Utils.class.getClassLoader()
                .getResourceAsStream("mobile.ui.application.properties");

        final InputStream transfer = Utils.class.getClassLoader()
                .getResourceAsStream("atb.ui.application.properties");

        final InputStream streamAccountsPortfolio = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.portfolio.accounts.application.properties");

        final InputStream streamHoldingsPortfolio = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.portfolio.holdings.application.properties");

        final InputStream collaboration = Utils.class.getClassLoader()
                .getResourceAsStream("collaboration.application.properties");

        final InputStream content = Utils.class.getClassLoader()
                .getResourceAsStream("content.application.properties");

        final InputStream gspf = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.gspf.properties");

        final InputStream summary = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.portfolio.summary.application.properties");

        final InputStream taxcenter = Utils.class.getClassLoader()
                .getResourceAsStream("web.ui.taxcenter.application.properties");

        try {

            properties.load(stream);
            properties.load(streamTwilio);
            properties.load(appProp);
            properties.load(streamApplitools);
            properties.load(clientOnboarding);
            properties.load(mobileLocators);
            properties.load(transfer);
            properties.load(streamAccountsPortfolio);
            properties.load(streamHoldingsPortfolio);
            properties.load(collaboration);
            properties.load(content);
            properties.load(gspf);
            properties.load(summary);
            properties.load(taxcenter);

        } catch (IOException e) {

            logger.warn("Error loading properties", e);
        }
    }

    public static String getProperty(String key) {

        if (StringUtils.isNotBlank(System.getProperty(key))) {
            return System.getProperty(key);
        }

        return properties.getProperty(key);
    }

    public static String getTextTemplateAsString(String path)
            throws IOException, URISyntaxException {

        return IOUtils.toString(
                Utils.class.getClassLoader().getResourceAsStream(path),
                StandardCharsets.UTF_8);
    }
}
