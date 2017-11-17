package mx.com.mentoringit.model.dao;

import org.springframework.stereotype.Repository;

import mx.com.mentoringit.model.entities.PurchaseOrder;
import mx.com.mentoringit.model.interfaces.IPurchaseOrder;

@Repository("purchaseOrderDAO")
public class PurchaseOrderDAO extends GenericDAO<PurchaseOrder> implements IPurchaseOrder<PurchaseOrder> {


}
