package pt.estig.twdm.pdm.youranimeresume.Data;


import java.util.List;

public class JAPIResponse {
    private List results;
    private int count;
    private String next;
    private String previous;

    public JAPIResponse(int count, String next, String previous,List results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List getResults() {
        return results;
    }
}
