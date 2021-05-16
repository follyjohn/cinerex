package org.hermit.cinerex.security.playload.response;

public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    
    /** 
     * @return String
     */
    public String getMessage() {
        return message;
    }

    
    /** 
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}