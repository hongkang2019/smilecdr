package techotakus.pythontrainningplatform.service;

import java.io.ByteArrayOutputStream;
import java.util.Properties;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service("runPythonImp")
public class RunPythonImp implements RunPython {
    public String Run(String script) {
        try {
            script = script.replaceAll("\\\\", "_back_slash_");
            script = script.replaceAll("_symbol_new_line_", "\\\n");
            script = script.replaceAll("_str_new_line_", "\\\r");
            script = script.replaceAll("_back_slash_", "\\\\\\\\");
            Properties props = new Properties();
            props.put("python.import.site", "false");
            Properties preprops = System.getProperties();
            PythonInterpreter.initialize(preprops, props, new String[0]);
            PythonInterpreter interpreter = new PythonInterpreter();
            // Create a stream to hold the output
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // Set the output of the Interpreter to the stream
            interpreter.setOut(baos);
            interpreter.exec(script);
            return baos.toString();
        } catch (Exception e){
            System.out.println(e.toString());
            return e.toString();
        }
    }
//    public static void main(String[] args){
//        System.out.println(Run("for f in range(10): print(i);" +
//                "print(\"ok\")"));
//    }
}
