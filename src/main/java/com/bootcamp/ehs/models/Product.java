package com.bootcamp.ehs.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class Product {

    @Id
    private String id;
    // Codigo de la cuenta bancaria
    @NonNull
    private String codeAccount;
    //Nombre de la cuenta bancaria
    @NonNull
    private String nameAccount;
    // Indica si la cuenta bancaria genera comision
    private Boolean commission;
    // Indica si la cuenta tiene un limite de movimiento
    private Boolean limitMovement;
    // Indica el numero maximo de transacciones
    private Integer limitTransacctions;
    // Inidica el limite de cuentas que un cliente puede tener
    private Integer limitAccounts;
    // Indica el tipo de producto si es Pasivo o Activo
    private String typeProduct;

}
