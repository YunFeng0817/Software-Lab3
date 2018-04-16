package graph;

import javax.activation.UnsupportedDataTypeException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

abstract public class GraphFactory {
    public static Graph createGraph(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String content;
        while ((content = fileReader.readLine()).replace(" ", "").equals("")) ;
        fileReader.close();
        Pattern typePattern = Pattern.compile("GraphType\\s*=\\s*\"(.*)\"");
        Matcher typeMatcher = typePattern.matcher(content);
        if (typeMatcher.find()) {
            String type = typeMatcher.group(1);
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

    static String GraphLabel(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        Pattern regex;
        Matcher matcher;
        String content;
        fileReader.readLine();  // graph type
        // graph name
        if ((content = fileReader.readLine()) != null) {
            fileReader.close();
            regex = Pattern.compile("GraphName\\s*=\\s*\"(.*)\"");
            matcher = regex.matcher(content);
            if (matcher.find()) {
                String graphName = matcher.group(1);
                return graphName;
            } else {
                throw new RuntimeException("form of the file is wrong!");
            }
        } else {
            throw new RuntimeException("form of the file is wrong!");
        }
    }

    static List<List<String>> getVertices(String filePath) throws IOException {
        List<List<String>> vertices = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        Pattern regex;
        Matcher matcher;
        String content;
        // 跳过图的类型，图的label的内容
        while (!fileReader.readLine().equals("")) ;
        fileReader.readLine();
        while (!(content = fileReader.readLine()).equals("")) {
            regex = Pattern.compile("^Vertex\\s*=\\s*<\"(.*)\",\\s*\"(.*)\",\\s*<(.*)>>$");
            matcher = regex.matcher(content);
            if (matcher.find()) {
                String label = matcher.group(1);
                String type = matcher.group(2);
                String attr = matcher.group(3);
                vertices.add(new ArrayList<>(Arrays.asList(label, type, attr)));
            }
        }
        return vertices;
    }
}
