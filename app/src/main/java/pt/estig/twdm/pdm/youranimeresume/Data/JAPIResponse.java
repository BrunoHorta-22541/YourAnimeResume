package pt.estig.twdm.pdm.youranimeresume.Data;


import java.util.List;

public class JAPIResponse {
    private List results;


    public JAPIResponse(List results) {

        this.results = results;
    }

    public List getResults() {
        return results;
    }
}
