package lk.online.Service.impl;

import lk.online.DAO.IAddProductsDAO;
import lk.online.DTO.ProdDetailsTempDTO;
import lk.online.DTO.ProdDetailsTempResponse;
import lk.online.Service.IAddProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProductsServiceImpl implements IAddProductsService {

    @Autowired
    IAddProductsDAO iAddProductsDAO;

    @Override
    public ProdDetailsTempResponse AddProductsService(ProdDetailsTempDTO productInfo) {
        return iAddProductsDAO.AddProductsDAOImpl(productInfo);
    }
}
