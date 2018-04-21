package connection;

public class Connection {
    //Default fields
//    private static final DEFAULT_


    //Required fields
    private int port;
    private String host;
    private String protocol;

    //Optional fields
    private String method;
    private String data;
    private int sendDelay;
    private int timeout;
    private boolean getRespondMessage;
    private boolean showWarnings;
    private boolean shouldRetryWhenFail;
    private boolean shouldUseSSL;

    private ConnectionState connectionState;

    private Connection(Builder connectionBuilder){
        this.port = connectionBuilder.port;
        this.host = connectionBuilder.host;
        this.protocol = connectionBuilder.protocol;
    }

    public static class Builder{

        //Required fields
        private int port;
        private String host;
        private String protocol;

        //Optional fields
        private String method;
        private String data;
        private int sendDelay;
        private int timeout;
        private boolean getRespondMessage;
        private boolean showWarnings;
        private boolean shouldRetryWhenFail;
        private boolean shouldUseSSL;

        public Builder(int port, String host, String protocol){

            //Set values from user
            this.port = port;
            this.host = host;
            this.protocol = protocol;

            //Set defaultValues
            this.method = "POST";
            this.data = "";
            this.sendDelay = 0;
            this.timeout = 5000;
            this.getRespondMessage = true;
            this.showWarnings = false;
            this.shouldRetryWhenFail = false;
            this.shouldUseSSL = false;
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

        public Builder setShouldRetryWhenFail(boolean shouldRetryWhenFail){
            this.shouldRetryWhenFail = shouldRetryWhenFail;
            return this;
        }

        public Builder setShouldUseSSL(boolean shouldUseSSL){
            this.shouldUseSSL = shouldUseSSL;
            return this;
        }

        public Connection build(){
            return new Connection(this);
        }
    }

}
