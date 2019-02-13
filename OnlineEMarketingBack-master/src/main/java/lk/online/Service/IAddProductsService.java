package lk.online.Service;

import lk.online.DTO.ProdDetailsTempDTO;
import lk.online.DTO.ProdDetailsTempResponse;

public interface IAddProductsService {

    public ProdDetailsTempResponse AddProductsService(ProdDetailsTempDTO productInfo);
}
