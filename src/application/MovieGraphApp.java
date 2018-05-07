package application;

import helper.ParseCommandHelper;

import java.io.IOException;

class MovieGraphApp {

//    public static void main(String[] args) throws IOException {
//        new MovieGraphApp("test/graph/data/GraphMovie.txt");
//    }

    MovieGraphApp(String filePath) throws IOException {
        ParseCommandHelper.Command(filePath);
    }
}
