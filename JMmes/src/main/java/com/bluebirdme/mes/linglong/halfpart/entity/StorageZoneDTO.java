package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.List;

public class StorageZoneDTO extends StorageZone{
private List<StorageZone> inserted;
private List<StorageZone> deleted;
private List<StorageZone> updated;
public List<StorageZone> getInserted() {
	return inserted;
}
public void setInserted(List<StorageZone> inserted) {
	this.inserted = inserted;
}
public List<StorageZone> getDeleted() {
	return deleted;
}
public void setDeleted(List<StorageZone> deleted) {
	this.deleted = deleted;
}
public List<StorageZone> getUpdated() {
	return updated;
}
public void setUpdated(List<StorageZone> updated) {
	this.updated = updated;
}

}
