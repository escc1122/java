public class OauthUtil {
  public String getOauth_consumer_key() {
    return oauth_consumer_key;
  }

  public void setOauth_consumer_key(String oauth_consumer_key) {
    this.oauth_consumer_key = oauth_consumer_key;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }

  public String getOauth_token() {
    return oauth_token;
  }

  public void setOauth_token(String oauth_token) {
    this.oauth_token = oauth_token;
  }

  public String getTokenSecret() {
    return tokenSecret;
  }

  public void setTokenSecret(String tokenSecret) {
    this.tokenSecret = tokenSecret;
  }

  private String oauth_consumer_key="";
  private String consumerSecret="";
  private String oauth_token="";
  private String tokenSecret="";

}
