package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_product database table.
 * 
 */
@Entity
@Table(name="product_product")
@NamedQuery(name="ProductProduct.findAll", query="SELECT p FROM ProductProduct p")
public class ProductProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

//	private Boolean active;

	private String barcode;

//	@Column(name="can_image_variant_1024_be_zoomed")
//	private Boolean canImageVariant1024BeZoomed;

	@Column(name="combination_indices")
	private String combinationIndices;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="default_code")
	private String defaultCode;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	@Column(name="product_tmpl_id")
	private Integer productTmplId;

	private BigDecimal volume;

	private BigDecimal weight;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	@OneToMany(mappedBy="productProduct")
	private List<SaleOrderLine> saleOrderLines;
	//bi-directional many-to-one association to PurchaseOrderLine

	@OneToMany(mappedBy="productProduct")
	private List<PurchaseOrderLine> purchaseOrderLines;


	public ProductProduct() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Boolean getActive() {
//		return this.active;
//	}
//
//	public void setActive(Boolean active) {
//		this.active = active;
//	}
public List<PurchaseOrderLine> getPurchaseOrderLines() {
	return this.purchaseOrderLines;
}

	public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
		this.purchaseOrderLines = purchaseOrderLines;
	}

	public PurchaseOrderLine addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().add(purchaseOrderLine);
		purchaseOrderLine.setProductProduct(this);

		return purchaseOrderLine;
	}

	public PurchaseOrderLine removePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().remove(purchaseOrderLine);
		purchaseOrderLine.setProductProduct(null);

		return purchaseOrderLine;
	}
	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

//	public Boolean getCanImageVariant1024BeZoomed() {
//		return this.canImageVariant1024BeZoomed;
//	}
//
//	public void setCanImageVariant1024BeZoomed(Boolean canImageVariant1024BeZoomed) {
//		this.canImageVariant1024BeZoomed = canImageVariant1024BeZoomed;
//	}

	public String getCombinationIndices() {
		return this.combinationIndices;
	}

	public void setCombinationIndices(String combinationIndices) {
		this.combinationIndices = combinationIndices;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public String getDefaultCode() {
		return this.defaultCode;
	}

	public void setDefaultCode(String defaultCode) {
		this.defaultCode = defaultCode;
	}

	public Integer getMessageMainAttachmentId() {
		return this.messageMainAttachmentId;
	}

	public void setMessageMainAttachmentId(Integer messageMainAttachmentId) {
		this.messageMainAttachmentId = messageMainAttachmentId;
	}

	public Integer getProductTmplId() {
		return this.productTmplId;
	}

	public void setProductTmplId(Integer productTmplId) {
		this.productTmplId = productTmplId;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public List<SaleOrderLine> getSaleOrderLines() {
		return this.saleOrderLines;
	}

	public void setSaleOrderLines(List<SaleOrderLine> saleOrderLines) {
		this.saleOrderLines = saleOrderLines;
	}

	public SaleOrderLine addSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().add(saleOrderLine);
		saleOrderLine.setProductProduct(this);

		return saleOrderLine;
	}

	public SaleOrderLine removeSaleOrderLine(SaleOrderLine saleOrderLine) {
		getSaleOrderLines().remove(saleOrderLine);
		saleOrderLine.setProductProduct(null);

		return saleOrderLine;
	}
}