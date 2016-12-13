package com.atguigu.jf.console.item.bean.bo;

import java.util.Date;


public class ItemMenuBean {
    private Long itemId;
    private String itemName;
    private String itemPicture;
    private  String itemType;
    private String itemTypecategory;
    private String prePrice;
    private String savePrice;
    private Date itemValidStart;
    private Date itemValidEnd;
    private String saveState;
    
	public ItemMenuBean() {
	}
	
	public ItemMenuBean(Long itemId, String itemName, String itemPicture,
			String itemType, String itemTypecategory, String prePrice,
			String savePrice, Date itemValidStart, Date itemValidEnd,
			String saveState) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPicture = itemPicture;
		this.itemType = itemType;
		this.itemTypecategory = itemTypecategory;
		this.prePrice = prePrice;
		this.savePrice = savePrice;
		this.itemValidStart = itemValidStart;
		this.itemValidEnd = itemValidEnd;
		this.saveState = saveState;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPicture() {
		return itemPicture;
	}
	public void setItemPicture(String itemPicture) {
		this.itemPicture = itemPicture;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemTypecategory() {
		return itemTypecategory;
	}
	public void setItemTypecategory(String itemTypecategory) {
		this.itemTypecategory = itemTypecategory;
	}
	public String getPrePrice() {
		return prePrice;
	}
	public void setPrePrice(String prePrice) {
		this.prePrice = prePrice;
	}
	public String getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(String savePrice) {
		this.savePrice = savePrice;
	}
	public Date getItemValidStart() {
		return itemValidStart;
	}
	public void setItemValidStart(Date itemValidStart) {
		this.itemValidStart = itemValidStart;
	}
	public Date getItemValidEnd() {
		return itemValidEnd;
	}
	public void setItemValidEnd(Date itemValidEnd) {
		this.itemValidEnd = itemValidEnd;
	}
	public String getSaveState() {
		return saveState;
	}
	public void setSaveState(String saveState) {
		this.saveState = saveState;
	}
	@Override
	public String toString() {
		return "ItemMenuBean [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPicture=" + itemPicture + ", itemType=" + itemType
				+ ", itemTypecategory=" + itemTypecategory + ", prePrice="
				+ prePrice + ", savePrice=" + savePrice + ", itemValidStart="
				+ itemValidStart + ", itemValidEnd=" + itemValidEnd
				+ ", saveState=" + saveState + "]";
	}

    
}