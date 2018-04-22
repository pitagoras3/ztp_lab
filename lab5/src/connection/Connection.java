package connection;

import java.util.Random;

public class Connection {

    public static final String  DEFAULT_METHOD = "POST";
    public static final String  DEFAULT_DATA = "";
    public static final int     DEFAULT_DELAY = 0;
    public static final int     DEFAULT_TIMEOUT = 5000;
    public static final boolean DEFAULT_GET_RESPOND_MESSAGE = true;
    public static final boolean DEFAULT_SHOW_WARNINGS = false;
    public static final boolean DEFAULT_RETRY_WHEN_FAIL = false;
    public static final boolean DEFAULT_USE_SSL = false;

    //Required fields
    private int     port;
    private String  host;
    private String  protocol;

    //Optional fields
    private String  method;
    private String  data;
    private int     sendDelay;
    private int     timeout;
    private boolean getRespondMessage;
    private boolean showWarnings;
    private boolean setRetryWhenFail;
    private boolean setUseSSL;

    //Reducing tower of ifs
    private ConnectionState connectionState;
    private static final Random random = new Random();

    private Connection(Builder connectionBuilder){
        //Required fields
        this.port = connectionBuilder.port;
        this.host = connectionBuilder.host;
        this.protocol = connectionBuilder.protocol;

        //Optional fields
        this.method             = connectionBuilder.method;
        this.data               = connectionBuilder.data;
        this.sendDelay          = connectionBuilder.sendDelay;
        this.timeout            = connectionBuilder.timeout;
        this.getRespondMessage  = connectionBuilder.getRespondMessage;
        this.showWarnings       = connectionBuilder.showWarnings;
        this.setRetryWhenFail   = connectionBuilder.setRetryWhenFail;
        this.setUseSSL          = connectionBuilder.setUseSSL;
    }

    public ConnectionState getConnectionState() {
        return connectionState;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "\n\tport=" + port +
                "\n\thost='" + host + '\'' +
                "\n\tprotocol='" + protocol + '\'' +
                "\n\tmethod='" + method + '\'' +
                "\n\tdata='" + data + '\'' +
                "\n\tsendDelay=" + sendDelay +
                "\n\ttimeout=" + timeout +
                "\n\tgetRespondMessage=" + getRespondMessage +
                "\n\tshowWarnings=" + showWarnings +
                "\n\tsetRetryWhenFail=" + setRetryWhenFail +
                "\n\tsetUseSSL=" + setUseSSL +
                "\n}";
    }

    /**
     * Initialize connection is 'dummy' function for mocking connectionState
     */
    public void initializeConnection(){
        int randomInt = random.nextInt(100);
        int modulo = randomInt % ConnectionState.AMOUNT_OF_CONNECTION_TYPES;

        switch (modulo){
            case 0:
                connectionState = new ConnectionStateAvailable();
                break;

            case 1:
                connectionState = new ConnectionStateConnected();
                break;

            case 2:
                connectionState = new ConnectionStateUnavailable();
                break;

            case 3:
                connectionState = new ConnectionStateDisconnected();
                break;
        }
    }

    public static class Builder{

        //Required fields
        private int     port;
        private String  host;
        private String  protocol;

        //Optional fields
        private String  method;
        private String  data;
        private int     sendDelay;
        private int     timeout;
        private boolean getRespondMessage;
        private boolean showWarnings;
        private boolean setRetryWhenFail;
        private boolean setUseSSL;

        public Builder(int port, String host, String protocol){

            //Set values from user
            this.port       = port;
            this.host       = host;
            this.protocol   = protocol;

            //Set defaultValues
            this.method             = DEFAULT_METHOD;
            this.data               = DEFAULT_DATA;
            this.sendDelay          = DEFAULT_DELAY;
            this.timeout            = DEFAULT_TIMEOUT;
            this.getRespondMessage  = DEFAULT_GET_RESPOND_MESSAGE;
            this.showWarnings       = DEFAULT_SHOW_WARNINGS;
            this.setRetryWhenFail   = DEFAULT_RETRY_WHEN_FAIL;
            this.setUseSSL          = DEFAULT_USE_SSL;
        }

        public Builder setMethod(String method){
            this.method = method;
            return this;
        }

        public Builder setData(String data){
            this.data = data;
            return this;
        }

        public Builder setSendDelay(int sendDelay){
            this.sendDelay = sendDelay;
            return this;
        }

        public Builder setTimeout(int timeout){
            this.timeout = timeout;
            return this;
        }

        public Builder setGetRespondMessage(boolean getRespondMessage){
            this.getRespondMessage = getRespondMessage;
            return this;
        }

        public Builder setShowWarnings(boolean showWarnings){
            this.showWarnings = showWarnings;
            return this;
        }

        public Builder setRetryWhenFail(boolean setRetryWhenFail){
            this.setRetryWhenFail = setRetryWhenFail;
            return this;
        }

        public Builder setUseSSL(boolean setUseSSL){
            this.setUseSSL = setUseSSL;
            return this;
        }

        public Connection build(){
            return new Connection(this);
        }
    }

}
