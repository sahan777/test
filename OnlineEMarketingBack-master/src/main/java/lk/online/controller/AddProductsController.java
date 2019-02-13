package lk.online.controller;


import lk.online.DTO.ProdDetailsTempDTO;
import lk.online.Service.IAddProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class AddProductsController {

    @Autowired
    IAddProductsService iAddProductsService;

    @PostMapping("save/product")
    public ResponseEntity saveProduct(@Valid @RequestBody ProdDetailsTempDTO detailsTempDTO){

        iAddProductsService.AddProductsService(detailsTempDTO);

        return ResponseEntity.status(HttpStatus.OK).body("succees");
    }
}
