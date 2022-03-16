package techotakus.pythontrainningplatform.service;

public interface Authentication {
    Integer Signup(String user_name, String user_password);

    String Signin(String user_name, String user_password);
}
