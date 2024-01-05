package br.com.vrsoft.vrmobile.infrastructure.controllers;

import br.com.vrsoft.vrmobile.application.usecases.GetProdutosInteractor;
import br.com.vrsoft.vrmobile.domain.entity.Produto;
import br.com.vrsoft.vrmobile.domain.entity.VRException;
import br.com.vrsoft.vrmobile.infrastructure.controllers.dtos.DefaultResponse;
import br.com.vrsoft.vrmobile.infrastructure.controllers.dtos.GetProdutosResponse;
import br.com.vrsoft.vrmobile.infrastructure.controllers.mappers.ProdutoDTOMapper;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final GetProdutosInteractor getProdutosInteractor;
    private final ProdutoDTOMapper produtoDTOMapper;

    public ProdutoController(GetProdutosInteractor getProdutosInteractor, ProdutoDTOMapper produtoDTOMapper) {
        this.getProdutosInteractor = getProdutosInteractor;
        this.produtoDTOMapper = produtoDTOMapper;
    }

    @GetMapping
    public ResponseEntity<DefaultResponse<GetProdutosResponse>> getProdutos() {
        Either<VRException, List<Produto>> response = getProdutosInteractor.getProdutos();

        return response.fold(
            vrException -> ResponseEntity.badRequest().body(new DefaultResponse<>(vrException.getMessage(), null)),
            produtos -> {
                GetProdutosResponse getProdutosResponse = produtoDTOMapper.toGetProdutosResponse(produtos);
                return ResponseEntity.ok().body(new DefaultResponse<>("", getProdutosResponse));
            }
        );
    }
}
