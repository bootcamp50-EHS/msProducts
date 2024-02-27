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
    @NonNull
    private String nameAccount;
    private Boolean commission;
    private Boolean limitMovement;
    private Integer limitNumberWithdrawal;
    private Integer limitNumberDeposit;
    private Integer limitAccounts;
    private String typeProduct;

}
