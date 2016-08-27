package cn.com.gome.hawkeye.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectorConfig {

    private String hostname;
    private String url;
    private int interval;
    private int timeout;

    CollectorConfig(String filename) throws IOException {

        Properties prop = new Properties();
        InputStream cfgStream = CollectorConfig.class.getClassLoader().getResourceAsStream(filename);
        if (cfgStream != null) {
            prop.load(cfgStream);

            this.hostname = prop.getProperty("hostname").trim();
            this.url = prop.getProperty("url").trim();
            if (prop.containsKey("interval")) {
                this.interval = Integer.parseInt(prop.getProperty("interval"));
            }
            if (prop.containsKey("timeout")) {
                this.timeout = Integer.parseInt(prop.getProperty("timeout"));
            }
        }
    }

    CollectorConfig(String hostname, String url, int interval, int timeout) {
        this.hostname = hostname;
        this.url = url;
        this.interval = interval;
        this.timeout = timeout;
    }

    public String getHostname() {
        return hostname;
    }

    public String getUrl() {
        return url;
    }

    public int getInterval() {
        return interval;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class Builder {
        private String hostname;
        private String url;
        private int interval;
        private int timeout;
        private String filename;

        Builder() {
        }

        public String getHostname() {
            return hostname;
        }

        public Builder setHostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public int getInterval() {
            return interval;
        }

        public Builder setInterval(int interval) {
            this.interval = interval;
            return this;
        }

        public int getTimeout() {
            return timeout;
        }

        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public String getFilename() {
            return filename;
        }

        public Builder setFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public CollectorConfig build() {
            return new CollectorConfig(hostname, url, interval, timeout);
        }

        public CollectorConfig load() throws IOException {
            return new CollectorConfig(this.filename);
        }
    }

    public static CollectorConfig.Builder custom() {
        return new CollectorConfig.Builder();
    }
}
