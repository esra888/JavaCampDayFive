package Core;

import GoogleServiceManager.googleServiceManager;

public class GoogleAdapter implements LoggerService {
    @Override
    public void logToSystem(String message) {
        googleServiceManager manager = new googleServiceManager();
        manager.log(message);
    }
}
