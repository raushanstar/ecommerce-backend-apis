package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "inventory")
public class Inventory {

  /** Unique id for the inventory. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  /** The product this inventory is of. */
  @OneToOne(optional = false, orphanRemoval = true)
  @JoinColumn(name = "product_id", nullable = false, unique = true)
  private Product product;
  /** The quantity in stock. */
  @Column(name = "quantity", nullable = false)
  private Integer quantity;

}
