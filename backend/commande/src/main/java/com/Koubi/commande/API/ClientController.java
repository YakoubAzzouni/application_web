package com.Koubi.commande.API;

import com.Koubi.commande.Model.Client;
import com.Koubi.commande.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("client") // besh n9olo win yaffichiha
@RestController // to define that we're working with rest

public class ClientController {
    private final ClientService cs;

    @Autowired
    public ClientController(ClientService cs) {
        this.cs = cs;
    }

    @GetMapping
    private Iterable<Client> getAllClients(){
        return cs.getAllClients();
    }

    @GetMapping("{client_id}")
    private @ResponseBody
    Client getClientById(@PathVariable("client_id") UUID client_id){
        return cs.getClientById(client_id);
    }

    @PostMapping
    private @ResponseBody
    Client insertClient(@RequestBody Client client){
        return cs.insertClient(client);
    }
}
