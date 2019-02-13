package lk.online.DAO.DAOImpl;

import lk.online.DAO.IAddProductsDAO;
import lk.online.DTO.ProdDetailsTempDTO;
import lk.online.DTO.ProdDetailsTempResponse;
import org.springframework.stereotype.Repository;

@Repository
public class AddProductsDAOImpl implements IAddProductsDAO{


    @Override
    public ProdDetailsTempResponse AddProductsDAOImpl(ProdDetailsTempDTO productInfo) {
        return null;

        //Insert into PRODUCT_DETAILS_TEMP(VENDOR_PRODUCT_ID,MASTER_CATEGORY,CATEGORY,SUB_CATEGORY,PRICE,QUANTITY,DESCRIPTION,BRAND,COLOUR,SIZE,FEATURES,PROCESS_FLAG,ADDED_DATE) VALUES()
    }
}
