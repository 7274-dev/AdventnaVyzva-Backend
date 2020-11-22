package sk.mysterum.backend.requestmodel;

public class Response {
    private String response;

    //**************Constructor***************//
    // Only real use for this is to create a dict for response to frontend //

    public Response(String response) {
        this.response = response;
    }

    //*********Getter_and_Setter*************//

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

