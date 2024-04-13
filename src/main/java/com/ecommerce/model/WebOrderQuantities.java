package com.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "web_order_quantities")
public class WebOrderQuantities {

  /** The unqiue id of the order quantity. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  /** The product being ordered. */
  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;
  /** The quantity being ordered. */
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
  /** The order itself. */
  @ManyToOne(optional = false)
  @JoinColumn(name = "order_id", nullable = false)
  private WebOrder order;
}
