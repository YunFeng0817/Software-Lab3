package graph;

import java.io.*;
import java.util.regex.*;

abstract public class GraphFactory {
    public static Graph createGraph(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String content;
        content = fileReader.readLine();
        Pattern typePattern = Pattern.compile("^GraphType\\s*=\\s*\".*\"");
        Matcher typeMatcher = typePattern.matcher(content);
        if (typeMatcher.find()) {
            String line = typeMatcher.group();
            typePattern = Pattern.compile("\".*\"");
            typeMatcher = typePattern.matcher(line);
            if (typeMatcher.find()) {
                String type = typeMatcher.group().substring(1, typeMatcher.group().length() - 1);
            }
        }
        return null;
    }
}
