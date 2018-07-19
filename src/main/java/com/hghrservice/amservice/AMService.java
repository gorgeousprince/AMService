package com.hghrservice.amservice;

import com.dig.awaremanager.ws.client.AMServiceSettings;
import com.dig.awaremanager.ws.client.core.model.AMRequestHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AMService {

    private static final Logger logger = LoggerFactory.getLogger(AMService.class);

    public static final String baseURL = "https://nyulmctest.api.amjxt.com/admin";
    public static final String serviceKey = "A8zFfWU4ykIbqPoe";
    public static final String accessKey = "4a0b11i64tqxcpnt";
    public static final String secretKey = "aHOBXCwQLhdCtEqtF3cl2rZkNBaV9dB4VIQCtXNSvgY";

    private static final AMService instance = new AMService();

    public static AMService getInstance() {
        return instance;
    }

    private void validateOnlineStatus() {
        AMServiceSettings.getInstance().setUrl(baseURL);
        AMServiceSettings.getInstance().setServiceKey(serviceKey);
        AMServiceSettings.getInstance().setAccessKey(accessKey);
        AMServiceSettings.getInstance().setSecretKey(secretKey);

        boolean useSandbox = true;
        AMRequestHeader header = new AMRequestHeader("core/getdatabases", useSandbox);
        String url = AMServiceSettings.getInstance().getUrl() + header.getUrlParameters();
        logger.info("Constructed url = " + url);
        //TODO access url by method GET
    }

    public static void main(String[] args) {
        AMService.getInstance().validateOnlineStatus();
    }
}
