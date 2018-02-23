/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BavarianHotdog
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wmr.findAll", query = "SELECT w FROM Wmr w")
    , @NamedQuery(name = "Wmr.findByIdWMR", query = "SELECT w FROM Wmr w WHERE w.idWMR = :idWMR")
    , @NamedQuery(name = "Wmr.findByIdFundCluster", query = "SELECT w FROM Wmr w WHERE w.idFundCluster = :idFundCluster")
    , @NamedQuery(name = "Wmr.findByPlaceStorage", query = "SELECT w FROM Wmr w WHERE w.placeStorage = :placeStorage")
    , @NamedQuery(name = "Wmr.findByDate", query = "SELECT w FROM Wmr w WHERE w.date = :date")
    , @NamedQuery(name = "Wmr.findByDispItem", query = "SELECT w FROM Wmr w WHERE w.dispItem = :dispItem")
    , @NamedQuery(name = "Wmr.findByDispQuantity", query = "SELECT w FROM Wmr w WHERE w.dispQuantity = :dispQuantity")
    , @NamedQuery(name = "Wmr.findByDispUnit", query = "SELECT w FROM Wmr w WHERE w.dispUnit = :dispUnit")
    , @NamedQuery(name = "Wmr.findByDispDescription", query = "SELECT w FROM Wmr w WHERE w.dispDescription = :dispDescription")
    , @NamedQuery(name = "Wmr.findByRsOrNum", query = "SELECT w FROM Wmr w WHERE w.rsOrNum = :rsOrNum")
    , @NamedQuery(name = "Wmr.findByRsOrDate", query = "SELECT w FROM Wmr w WHERE w.rsOrDate = :rsOrDate")
    , @NamedQuery(name = "Wmr.findByCertifiedCorrectBy", query = "SELECT w FROM Wmr w WHERE w.certifiedCorrectBy = :certifiedCorrectBy")
    , @NamedQuery(name = "Wmr.findByDisposalApprovedBy", query = "SELECT w FROM Wmr w WHERE w.disposalApprovedBy = :disposalApprovedBy")
    , @NamedQuery(name = "Wmr.findByCertInspItemDestroy", query = "SELECT w FROM Wmr w WHERE w.certInspItemDestroy = :certInspItemDestroy")
    , @NamedQuery(name = "Wmr.findByCertInspItemSoldPri", query = "SELECT w FROM Wmr w WHERE w.certInspItemSoldPri = :certInspItemSoldPri")
    , @NamedQuery(name = "Wmr.findByCertInspItemSoldAuc", query = "SELECT w FROM Wmr w WHERE w.certInspItemSoldAuc = :certInspItemSoldAuc")
    , @NamedQuery(name = "Wmr.findByCertInspItemTransfer", query = "SELECT w FROM Wmr w WHERE w.certInspItemTransfer = :certInspItemTransfer")
    , @NamedQuery(name = "Wmr.findByItemTransferTo", query = "SELECT w FROM Wmr w WHERE w.itemTransferTo = :itemTransferTo")
    , @NamedQuery(name = "Wmr.findByCiCertifiedCorrectBy", query = "SELECT w FROM Wmr w WHERE w.ciCertifiedCorrectBy = :ciCertifiedCorrectBy")
    , @NamedQuery(name = "Wmr.findByCiWitnessDisposalBy", query = "SELECT w FROM Wmr w WHERE w.ciWitnessDisposalBy = :ciWitnessDisposalBy")})
public class Wmr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_WMR")
    private Integer idWMR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FundCluster")
    private int idFundCluster;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "place_storage")
    private String placeStorage;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disp_item")
    private int dispItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disp_quantity")
    private int dispQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disp_unit")
    private int dispUnit;
    @Size(max = 45)
    @Column(name = "disp_description")
    private String dispDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rs_or_num")
    private int rsOrNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rs_or_date")
    @Temporal(TemporalType.DATE)
    private Date rsOrDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "certified_correct_by")
    private String certifiedCorrectBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "disposal_approved_by")
    private String disposalApprovedBy;
    @Size(max = 45)
    @Column(name = "cert_insp_item_destroy")
    private String certInspItemDestroy;
    @Size(max = 45)
    @Column(name = "cert_insp_item_sold_pri")
    private String certInspItemSoldPri;
    @Size(max = 45)
    @Column(name = "cert_insp_item_sold_auc")
    private String certInspItemSoldAuc;
    @Size(max = 45)
    @Column(name = "cert_insp_item_transfer")
    private String certInspItemTransfer;
    @Size(max = 45)
    @Column(name = "item_transfer_to")
    private String itemTransferTo;
    @Size(max = 45)
    @Column(name = "ci_certified_correct_by")
    private String ciCertifiedCorrectBy;
    @Size(max = 45)
    @Column(name = "ci_witness_disposal_by")
    private String ciWitnessDisposalBy;
    @JoinColumn(name = "id_item", referencedColumnName = "id_GeneralInventory")
    @ManyToOne(optional = false)
    private Generalinventory idItem;

    public Wmr() {
    }

    public Wmr(Integer idWMR) {
        this.idWMR = idWMR;
    }

    public Wmr(Integer idWMR, int idFundCluster, String placeStorage, Date date, int dispItem, int dispQuantity, int dispUnit, int rsOrNum, Date rsOrDate, String certifiedCorrectBy, String disposalApprovedBy) {
        this.idWMR = idWMR;
        this.idFundCluster = idFundCluster;
        this.placeStorage = placeStorage;
        this.date = date;
        this.dispItem = dispItem;
        this.dispQuantity = dispQuantity;
        this.dispUnit = dispUnit;
        this.rsOrNum = rsOrNum;
        this.rsOrDate = rsOrDate;
        this.certifiedCorrectBy = certifiedCorrectBy;
        this.disposalApprovedBy = disposalApprovedBy;
    }

    public Integer getIdWMR() {
        return idWMR;
    }

    public void setIdWMR(Integer idWMR) {
        this.idWMR = idWMR;
    }

    public int getIdFundCluster() {
        return idFundCluster;
    }

    public void setIdFundCluster(int idFundCluster) {
        this.idFundCluster = idFundCluster;
    }

    public String getPlaceStorage() {
        return placeStorage;
    }

    public void setPlaceStorage(String placeStorage) {
        this.placeStorage = placeStorage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDispItem() {
        return dispItem;
    }

    public void setDispItem(int dispItem) {
        this.dispItem = dispItem;
    }

    public int getDispQuantity() {
        return dispQuantity;
    }

    public void setDispQuantity(int dispQuantity) {
        this.dispQuantity = dispQuantity;
    }

    public int getDispUnit() {
        return dispUnit;
    }

    public void setDispUnit(int dispUnit) {
        this.dispUnit = dispUnit;
    }

    public String getDispDescription() {
        return dispDescription;
    }

    public void setDispDescription(String dispDescription) {
        this.dispDescription = dispDescription;
    }

    public int getRsOrNum() {
        return rsOrNum;
    }

    public void setRsOrNum(int rsOrNum) {
        this.rsOrNum = rsOrNum;
    }

    public Date getRsOrDate() {
        return rsOrDate;
    }

    public void setRsOrDate(Date rsOrDate) {
        this.rsOrDate = rsOrDate;
    }

    public String getCertifiedCorrectBy() {
        return certifiedCorrectBy;
    }

    public void setCertifiedCorrectBy(String certifiedCorrectBy) {
        this.certifiedCorrectBy = certifiedCorrectBy;
    }

    public String getDisposalApprovedBy() {
        return disposalApprovedBy;
    }

    public void setDisposalApprovedBy(String disposalApprovedBy) {
        this.disposalApprovedBy = disposalApprovedBy;
    }

    public String getCertInspItemDestroy() {
        return certInspItemDestroy;
    }

    public void setCertInspItemDestroy(String certInspItemDestroy) {
        this.certInspItemDestroy = certInspItemDestroy;
    }

    public String getCertInspItemSoldPri() {
        return certInspItemSoldPri;
    }

    public void setCertInspItemSoldPri(String certInspItemSoldPri) {
        this.certInspItemSoldPri = certInspItemSoldPri;
    }

    public String getCertInspItemSoldAuc() {
        return certInspItemSoldAuc;
    }

    public void setCertInspItemSoldAuc(String certInspItemSoldAuc) {
        this.certInspItemSoldAuc = certInspItemSoldAuc;
    }

    public String getCertInspItemTransfer() {
        return certInspItemTransfer;
    }

    public void setCertInspItemTransfer(String certInspItemTransfer) {
        this.certInspItemTransfer = certInspItemTransfer;
    }

    public String getItemTransferTo() {
        return itemTransferTo;
    }

    public void setItemTransferTo(String itemTransferTo) {
        this.itemTransferTo = itemTransferTo;
    }

    public String getCiCertifiedCorrectBy() {
        return ciCertifiedCorrectBy;
    }

    public void setCiCertifiedCorrectBy(String ciCertifiedCorrectBy) {
        this.ciCertifiedCorrectBy = ciCertifiedCorrectBy;
    }

    public String getCiWitnessDisposalBy() {
        return ciWitnessDisposalBy;
    }

    public void setCiWitnessDisposalBy(String ciWitnessDisposalBy) {
        this.ciWitnessDisposalBy = ciWitnessDisposalBy;
    }

    public Generalinventory getIdItem() {
        return idItem;
    }

    public void setIdItem(Generalinventory idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWMR != null ? idWMR.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wmr)) {
            return false;
        }
        Wmr other = (Wmr) object;
        if ((this.idWMR == null && other.idWMR != null) || (this.idWMR != null && !this.idWMR.equals(other.idWMR))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Wmr[ idWMR=" + idWMR + " ]";
    }
    
}
