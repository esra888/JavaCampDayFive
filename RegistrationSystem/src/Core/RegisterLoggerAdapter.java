package Core;

import registerLoggerManager.registerLoggerManager;

public class RegisterLoggerAdapter implements LoggerService {
    @Override
    public void logToSystem(String message) {
        registerLoggerManager manager = new registerLoggerManager();
        manager.log(message);
    }
}
