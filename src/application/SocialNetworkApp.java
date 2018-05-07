package application;

import helper.ParseCommandHelper;

import java.io.IOException;

class SocialNetworkApp {

//    public static void main(String[] args) throws IOException {
//        new NetworkTopologyApp("test/graph/data/GraphSocial.txt");
//    }

    SocialNetworkApp(String filePath) throws IOException {
        ParseCommandHelper.Command(filePath);
    }
}
