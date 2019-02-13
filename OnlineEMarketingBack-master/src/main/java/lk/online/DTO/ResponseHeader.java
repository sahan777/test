package lk.online.DTO;

import lombok.Data;

@Data
public class ResponseHeader {

    private String responseCode;
    private String responseDescription;
    private String transactionId;

}
