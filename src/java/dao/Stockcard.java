/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockcard.findAll", query = "SELECT s FROM Stockcard s")
    , @NamedQuery(name = "Stockcard.findByIdStockCard", query = "SELECT s FROM Stockcard s WHERE s.idStockCard = :idStockCard")
    , @NamedQuery(name = "Stockcard.findByStockNum", query = "SELECT s FROM Stockcard s WHERE s.stockNum = :stockNum")
    , @NamedQuery(name = "Stockcard.findByOrderPoint", query = "SELECT s FROM Stockcard s WHERE s.orderPoint = :orderPoint")})
public class Stockcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_StockCard")
    private Integer idStockCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_num")
    private int stockNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_point")
    private int orderPoint;
    @JoinColumn(name = "asset_id", referencedColumnName = "id_Asset")
    @ManyToOne(optional = false)
    private Asset assetId;

    public Stockcard() {
    }

    public Stockcard(Integer idStockCard) {
        this.idStockCard = idStockCard;
    }

    public Stockcard(Integer idStockCard, int stockNum, int orderPoint) {
        this.idStockCard = idStockCard;
        this.stockNum = stockNum;
        this.orderPoint = orderPoint;
    }

    public Integer getIdStockCard() {
        return idStockCard;
    }

    public void setIdStockCard(Integer idStockCard) {
        this.idStockCard = idStockCard;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(int orderPoint) {
        this.orderPoint = orderPoint;
    }

    public Asset getAssetId() {
        return assetId;
    }

    public void setAssetId(Asset assetId) {
        this.assetId = assetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStockCard != null ? idStockCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockcard)) {
            return false;
        }
        Stockcard other = (Stockcard) object;
        if ((this.idStockCard == null && other.idStockCard != null) || (this.idStockCard != null && !this.idStockCard.equals(other.idStockCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Stockcard[ idStockCard=" + idStockCard + " ]";
    }
    
}
