package kr.unithon.noname.api;

import kr.unithon.noname.util.DummyNetwork;

public class Api {

    private static ApiService apiService;

    public static ApiService getDummyInstance() {
        if(apiService == null){
            apiService = new DummyNetwork();
        }

        return apiService;
    }

}
