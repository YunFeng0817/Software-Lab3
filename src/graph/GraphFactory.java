package graph;

import javax.activation.UnsupportedDataTypeException;
import java.io.*;
import java.util.regex.*;

abstract public class GraphFactory {
    public static Graph createGraph(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String content;
        System.out.println();
        while ((content = fileReader.readLine()).replace(" ", "").equals("")) ;
        Pattern typePattern = Pattern.compile("\".*\"");
        Matcher typeMatcher = typePattern.matcher(content);
        if (typeMatcher.find()) {
            String type = typeMatcher.group().substring(1, typeMatcher.group().length() - 1);
            switch (type) {
                case "GraphPoet":
                    return GraphPoetFactory.createGraph(filePath);
                case "SocialNetwork":
                    return GraphSocialFactory.createGraph(filePath);
                case "NetworkTopology":
                    return GraphTopologyFactory.createGraph(filePath);
                case "MovieGraph":
                    return GraphMovieFactory.createGraph(filePath);
                default:
                    throw new UnsupportedDataTypeException(type);
            }
        } else {
            throw new RuntimeException("form of the file is wrong!");
        }
    }
}
