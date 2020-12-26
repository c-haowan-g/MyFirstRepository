package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.List;

public class StorageSpaceDTO extends StorageSpace{
private List<StorageSpace> inserted;
private List<StorageSpace> deleted;
private List<StorageSpace> updated;
public List<StorageSpace> getInserted() {
	return inserted;
}
public void setInserted(List<StorageSpace> inserted) {
	this.inserted = inserted;
}
public List<StorageSpace> getDeleted() {
	return deleted;
}
public void setDeleted(List<StorageSpace> deleted) {
	this.deleted = deleted;
}
public List<StorageSpace> getUpdated() {
	return updated;
}
public void setUpdated(List<StorageSpace> updated) {
	this.updated = updated;
}

}
