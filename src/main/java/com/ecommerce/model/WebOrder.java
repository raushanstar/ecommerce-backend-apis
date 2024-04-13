package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "web_order")
public class WebOrder {

  /** Unique id for the order. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  /** The user of the order. */
  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private LocalUser user;
  /** The shipping address of the order. */
  @ManyToOne(optional = false)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;
  /** The quantities ordered. */
  @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<WebOrderQuantities> quantities = new ArrayList<>();

}
