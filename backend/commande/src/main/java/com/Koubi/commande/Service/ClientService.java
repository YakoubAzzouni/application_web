package com.Koubi.commande.Service;

import com.Koubi.commande.Model.Client;
import com.Koubi.commande.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository cr;


    public ClientService(ClientRepository cr) {
        this.cr = cr;
    }

    ///******** get ************
    public Iterable<Client> getAllClients(){
        return cr.findAll();
    }

    public Client getClientById(UUID client_id) { return cr.findById(client_id).get();}

    //********* post ***********
    public Client insertClient( Client client){
        return cr.save(client);
    }

    //******* delete ***********

    //***** put
}
