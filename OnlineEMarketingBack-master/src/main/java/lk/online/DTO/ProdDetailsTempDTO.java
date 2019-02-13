package lk.online.DTO;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "PRODUCT_DETAILS_TEMP")
public class ProdDetailsTempDTO {


    private RequestHeader requestHeader;
    @Id
    @NonNull
    @Column(name = "TRAN_ID")
    private String tran_id;

    @Id
    @Column(name = "VENDOR_PRODUCT_ID")
    private String vendor_product_id;

    @Id
    @Column(name = "MASTER_CATEGORY")
    private String master_category;

    @Id
    @Column(name = "CATEGORY")
    private String category;

    @Id
    @Column(name = "SUB_CATEGORY")
    private String sub_category;

    @Id
    @Column(name = "PRICE")
    private String price;

    @Id
    @Column(name = "QUANTITY")
    private String quantity;

    @Id
    @Column(name = "DESCRIPTION")
    private String description;

    @Id
    @Column(name = "BRAND")
    private String brand;

    @Id
    @Column(name = "COLOUR")
    private String colour;

    @Id
    @Column(name = "SIZE")
    private String size;

    @Id
    @Column(name = "FEATURES")
    private String features;

    @Id
    @Column(name = "PROCESS_FLAG")
    private String process_flag;

    @Id
    @Column(name = "ADDED_DATE")
    private String added_date;


}
