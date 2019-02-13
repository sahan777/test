package lk.online.DAO;

import lk.online.DTO.ProdDetailsTempDTO;
import lk.online.DTO.ProdDetailsTempResponse;

public interface IAddProductsDAO {

    public ProdDetailsTempResponse AddProductsDAOImpl(ProdDetailsTempDTO productInfo);
}
