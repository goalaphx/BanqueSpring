package org.lsi.metier;
import java.util.List;
import org.lsi.entities.Operation;
public interface OperationMetier {
public Operation saveOperation(Operation o);
public List<Operation> listOperation();

} 