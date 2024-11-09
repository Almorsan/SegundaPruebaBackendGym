

package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.dtos.ClienteDTO;
import com.almorsan.gimnasio.models.Cliente;
import com.almorsan.gimnasio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteDTOController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }
}

