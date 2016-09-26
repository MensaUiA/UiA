/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlitServer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haris
 */
@Entity
@Table(name = "orderproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderproduct.findAll", query = "SELECT o FROM Orderproduct o"),
    @NamedQuery(name = "Orderproduct.findByOrderID", query = "SELECT o FROM Orderproduct o WHERE o.orderproductPK.orderID = :orderID"),
    @NamedQuery(name = "Orderproduct.findByProdID", query = "SELECT o FROM Orderproduct o WHERE o.orderproductPK.prodID = :prodID"),
    @NamedQuery(name = "Orderproduct.findByOrderQuantity", query = "SELECT o FROM Orderproduct o WHERE o.orderQuantity = :orderQuantity")})
public class Orderproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderproductPK orderproductPK;
    @Column(name = "order_quantity")
    private Integer orderQuantity;
    @JoinColumn(name = "order_ID", referencedColumnName = "order_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "prod_ID", referencedColumnName = "prod_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public Orderproduct() {
    }

    public Orderproduct(OrderproductPK orderproductPK) {
        this.orderproductPK = orderproductPK;
    }

    public Orderproduct(String orderID, String prodID) {
        this.orderproductPK = new OrderproductPK(orderID, prodID);
    }

    public OrderproductPK getOrderproductPK() {
        return orderproductPK;
    }

    public void setOrderproductPK(OrderproductPK orderproductPK) {
        this.orderproductPK = orderproductPK;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderproductPK != null ? orderproductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderproduct)) {
            return false;
        }
        Orderproduct other = (Orderproduct) object;
        if ((this.orderproductPK == null && other.orderproductPK != null) || (this.orderproductPK != null && !this.orderproductPK.equals(other.orderproductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SlitServer.Orderproduct[ orderproductPK=" + orderproductPK + " ]";
    }
    
}
